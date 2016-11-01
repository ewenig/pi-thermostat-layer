# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f9cd18d99c49ad5c1067d3bcdc038816"

SRC_URI = "git://github.com/ewenig/pi-thermostat;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "742011326f779bb13651c6e14e16d40984050b0d"

S = "${WORKDIR}/git"

DEPENDS = "wiringpi"
LDFLAGS = "-lwiringPi -lpthread"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# This is a guess; additional arguments may be required
	oe_runmake install 'DESTDIR=${D}'
}

