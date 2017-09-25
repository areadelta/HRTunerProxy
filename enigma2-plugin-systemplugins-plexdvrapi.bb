SUMMARY = "Setup Enigma2 for link with Plex DVR API"
DESCRIPTION = "Setup Enigma2 for link with Plex DVR API"
MAINTAINER = "OpenViX"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

inherit gitpkgv distutils-openplugins
SRCREV = "${AUTOREV}"
PV = "3.0+git${SRCPV}"
PKGV = "3.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/OpenViX/PlexDVRAPI.git;protocol=git"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = " \
    python-argparse \
    "

python populate_packages_prepend() {
    e2_pdir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, e2_pdir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, e2_pdir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}
