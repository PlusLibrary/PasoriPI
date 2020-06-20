import nfc
import binascii

def onConnect(tag):
    print(binascii.hexlify(tag.identifier).upper().decode('utf-8'))

def main():
    with nfc.ContactlessFrontend('usb') as clf:
        clf.connect(rdwr={'on-connect': onConnect})

main()
