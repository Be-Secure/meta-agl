DESCRIPTION = "logitech g29 wheel service"
HOMEPAGE = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/apps/agl-service-steering-wheel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"
SECTION = "apps"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-steering-wheel;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "6d5d619a059b5aeb76c2add9bc28d45bd31279e9"
PN          = "agl-service-steering-wheel"
S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 af-binder"

inherit cmake aglwgt