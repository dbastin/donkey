for i in $@; do
  (cd $i && rm ./build/lib/runtime/donkey/donkey*.jar) && \
  (cd $i && rm ./build/lib/tools/donkey/donkey*.jar) && \
  (./throw.sh $i)
done
