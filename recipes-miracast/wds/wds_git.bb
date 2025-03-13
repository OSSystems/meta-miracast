SUMMARY = "Wireless Display Software For Linux OS (WDS)"
HOMEPAGE = "https://01.org/wds"
BUGTRACKER = "https://github.com/01org/wds/issues"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=cb8aedd3bced19bd8026d96a8b6876d7"

DEPENDS = "gstreamer1.0 bison-native"

inherit cmake pkgconfig

SRCREV = "a488b169d724d6b4cfcd7037dbab1f1c2bf04f3b"
SRC_URI = "git://github.com/01org/wds.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=ON"

do_install:append() {
    install -Dm 0755 ${B}/desktop_source/desktop-source-test ${D}${bindir}/wds-examples/desktop-source-test
    install -Dm 0755 ${B}/libwds/rtsp/tests/test-wds ${D}${bindir}/wds-examples/test-wds
    install -Dm 0755 ${B}/mirac_network/gst-test ${D}${bindir}/wds-examples/gst-test
    install -Dm 0755 ${B}/mirac_network/network-test ${D}${bindir}/wds-examples/network-test
    install -Dm 0755 ${B}/p2p/register-peer-service ${D}${bindir}/wds-examples/register-peer-service
    install -Dm 0755 ${B}/p2p/test-ie ${D}${bindir}/wds-examples/test-ie
    install -Dm 0755 ${B}/sink/sink-test ${D}${bindir}/wds-examples/sink-test
}

PACKAGES =+ "${PN}-examples"
FILES:${PN}-examples += "${bindir}/wds-examples/*"

RDEPENDS:${PN} += " \
    connman-client \
    wpa-supplicant \
    gstreamer1.0-libav \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
"
