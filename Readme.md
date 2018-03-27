
# ipm package: coap-adapter

## Overview

coap-adapter connects to a CoAP URL and the ClearBlade Platform's MQTT Broker. Messages sent from the CoAP source URL are adapted into an MQTT message sent to a configured topic.

This is an ipm package, which contains one or more reusable assets within the ipm Community. The 'package.json' in this repo is a ipm spec's package.json, [here](https://docs.clearblade.com/v/3/6-ipm/spec), which is a superset of npm's package.json spec, [here](https://docs.npmjs.com/files/package.json).

[Browse ipm Packages](https://ipm.clearblade.com)

## Setup

cb-coap/src/main/java/com/clearblade/coap/cb_coap/App.java

1. Enter your System Settings
2. Enter User Credentials
3. Set your CoAP URL

## Usage

cb-coap/src/main/java/com/clearblade/coap/cb_coap/App.java

1. Set CoAP URL to your source CoAP URL

## API

This program does not take any runtime parameters.

Utilizes ClearBlade's Java SDK ([src](https://github.com/ClearBlade/ClearBladeJavaSDK))

## Thank you

Powered by ClearBlade Enterprise IoT Platform: [https://platform.clearblade.com](https://platform.clearblade.com)

