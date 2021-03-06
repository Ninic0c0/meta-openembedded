SUMMARY = "Python GObject bindings"
HOMEPAGE = "http://www.pygtk.org/"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a916467b91076e631dd8edb7424769c7"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gobject-introspection distutils3-base upstream-version-is-even

DEPENDS += "python3 glib-2.0"

SRCNAME = "pygobject"
SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/sources/${SRCNAME}/${@gnome_verdir("${PV}")}/${SRCNAME}-${PV}.tar.xz \
"

SRC_URI[md5sum] = "ca1dc4f31c1d6d283758e8f315a88ab6"
SRC_URI[sha256sum] = "87e2c9aa785f352ef111dcc5f63df9b85cf6e05e52ff04f803ffbebdacf5271a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

UNKNOWN_CONFIGURE_WHITELIST = "introspection"

PACKAGECONFIG ??= ""

PACKAGECONFIG[cairo] = "-Dpycairo=true,-Dpycairo=false, cairo python-pycairo, python-pycairo"
PACKAGECONFIG[tests] = "-Dtests=true, -Dtests=false, , "

EXTRA_OEMESON_append = " -Dpython=python3"

BBCLASSEXTEND = "native"
RDEPENDS_${PN} = "python3-pkgutil"
RDEPENDS_${PN}_class-native = ""
