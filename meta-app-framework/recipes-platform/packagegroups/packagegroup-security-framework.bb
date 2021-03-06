SUMMARY = "Security middleware components"
LICENSE = "MIT"

inherit packagegroup

# Install Cynara and security-manager by default if (and only if)
# Smack is enabled.
#
# Cynara does not have a hard dependency on Smack security,
# but is meant to be used with it. security-manager however
# links against smack and expects Smack to be active,
# so we do not have any choice.
#
# Without configuration, security-manager is not usable. We use
# the policy packaged from the upstream source code here. Adapting
# it for the distro can be done by patching that source.
RDEPENDS:${PN}:append:with-lsm-smack = " \
    cynagora \
    security-manager \
    security-manager-policy \
    smack-system-setup \
"
