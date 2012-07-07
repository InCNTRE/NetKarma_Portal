#!/usr/bin/env python

from xml.dom.minidom import parse, parseString
from xml.etree import ElementTree
import sys

if len(sys.argv) != 2:
  print 'usage: ', sys.argv[0], '<manifest-rspec>'
  sys.exit(0);

inputRspec = sys.argv[1]
outfile = "hostfile.txt"
f = open(outfile, "w")
rspecFile = parse(inputRspec)
loginStmts = []
for node in rspecFile.getElementsByTagName('services'):
  loginStmts.append(node)

hostnames = []
for stmt in loginStmts:
  element = ElementTree.XML(stmt.toxml())
  for subElement in element:
    f.write(subElement.attrib['hostname']+ '\n')

f.close()

