SUMMARY = "The middleware for AGL IVI profile"
DESCRIPTION = "The set of packages required for AGL IVI Distribution"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-profile-graphical \
    profile-graphical \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-image-minimal \
    packagegroup-agl-graphical-weston \
    packagegroup-agl-graphical-multimedia \
"
# FIXME: Removed due to issues building against weston 5.0.0:
#    waltham-transmitter

RDEPENDS:profile-graphical = "${PN}"
