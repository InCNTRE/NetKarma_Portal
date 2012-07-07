#!/usr/bin/env python

from xml.dom.minidom import parse, parseString
from xml.etree import ElementTree
import sys

if len(sys.argv) != 3:
  print 'usage: ', sys.argv[0], '<manifest-rspec> <exp-id>'
  sys.exit(0);

propertiesFile = "elements.prop"
inputRspec = sys.argv[1]
exp_id = sys.argv[2]
outfile = "/home/chsmall/git/NetKarma_Portal/new_portal/webservice/uploads/" + exp_id + "/slice.info"

inp = open(propertiesFile, "r")
f = open(outfile, "w")
rspecFile = parse(inputRspec)

for line in inp:
  tokens = line.split()
  tagName = tokens[0]
  elementName = tokens[1]
  attribName = tokens[2]

  loginStmts = []
  for node in rspecFile.getElementsByTagName(tagName):
    loginStmts.append(node)

  for stmt in loginStmts:
    element = ElementTree.XML(stmt.toxml())
    pair = tagName + ':' + attribName + '='
    for subElement in element.findall(elementName):
      pair = pair + ' ' + subElement.attrib[attribName]
    f.write(pair.strip() + '\n')

f.close()
inp.close()

