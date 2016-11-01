DESCRIPTION="Wrapper function to publish statistics to Adafruit.IO"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file:///home/vagrant/rpi/build/recipes-pi/aio-publisher/aio-publisher/LICENSE;md5=77dbdc10bd034ef2d164690fa2ff64da"

SRC_URI = "file:///home/vagrant/rpi/build/recipes-pi/aio-publisher/aio-publisher/aio-publisher"

S = "${WORKDIR}/home/vagrant/rpi/build/recipes-pi/aio-publisher/aio-publisher"

do_install () {
	# Specify install commands here
	install -d ${D}/usr/bin
	install -m 755 ${S}/aio-publisher ${D}/usr/bin/
}

