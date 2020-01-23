FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://automount.service \
            file://automount.sh \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} += "automount.service"

do_install_append () {
    sed -i 's/^WantedBy=.*/WantedBy=multi-user.target/' ${D}${systemd_unitdir}/system/udisks2.service

    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/automount.service ${D}${systemd_unitdir}/system

    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/automount.sh ${D}${libexecdir}/automount.sh
}

FILES_${PN} += "${base_libdir}/systemd/system/automount.service \
                ${libexecdir}/automount.sh \
"
