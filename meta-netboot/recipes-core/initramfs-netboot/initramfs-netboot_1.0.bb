SUMMARY = "Extremely basic live image init script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = "file://init.sh"

S = "${WORKDIR}"

RDEPENDS:${PN} += "nbd-client"

do_install() {
	install -dm 0755 ${D}/etc
	touch ${D}/etc/initrd-release
	install -dm 0755 ${D}/dev
	install -dm 0755 ${D}/sbin
	install -m 0755 ${WORKDIR}/init.sh ${D}/sbin/init
}

inherit allarch

FILES:${PN} += " /dev /etc/initrd-release /sbin/init "

