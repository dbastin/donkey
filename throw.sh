#!/bin/bash
DEST="$1"
ARTIFACTS="./gen/artifacts/jars"

TARGET="$DEST/build/lib/runtime/donkey/" 
mkdir "$TARGET" 2> /dev/null
for i in `find $ARTIFACTS -name "*.jar" | grep -v "src" | grep -v "test"`; do
  echo "Copying $i to $TARGET"
  cp $i "$TARGET"
done

TARGET="$DEST/build/lib/tools/donkey/"
mkdir "$TARGET" 2> /dev/null
for i in `find $ARTIFACTS -name "*src-*.jar" -o -name "*test*.jar"`; do
  echo "Copying $i to $TARGET"
  cp $i "$TARGET"
done
