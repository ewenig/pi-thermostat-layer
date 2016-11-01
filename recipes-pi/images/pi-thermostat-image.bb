SUMMARY = "A base stable Raspberry Pi Zero image with SSH and some other goodies"
WEBSITE = ""
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

include recipes-core/images/rpi-hwup-image.bb

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    tzdata \
 "

WIFI_SUPPORT = " \
    dhcpcd \
    iw \
    linux-firmware-brcm43430 \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    wireless-tools \
    wpa-supplicant \
 "

DEV_EXTRAS = " \
    binutils \
    binutils-symlinks \
    ntp \
    ntp-tickadj \
 "

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    cronie \
    curl \
    devmem2 \
    dosfstools \
    ethtool \
    findutils \
    i2c-tools \
    iperf \
    iproute2 \
    less \
    memtester \
    netcat \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    wget \
    vim \
    zip \
 "

RPI_UTILS = " \
    bcm2835-tests \
    pi-blaster \
    rpio \
    rpi-gpio \
    userland \
    wiringpi \
 "

PI_THERMOSTAT = " \
    aio-publisher \
    pi-thermostat \
 "

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${RPI_UTILS} \
    ${WIFI_SUPPORT} \
    ${PI_THERMOSTAT} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "rpi-hwup-image"

do_autoinit_i2c() {
    echo 'i2c_dev' >> ${IMAGE_ROOTFS}/etc/modules
}

do_set_default_goodtemp() {
    echo '70' > ${IMAGE_ROOTFS}/etc/goodtemp
}

IMAGE_PREPROCESS_COMMAND += "do_autoinit_i2c; do_set_default_goodtemp; "
