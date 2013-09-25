package org.burroloco.donkey.demo.filemeta2fixed;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.file.FileMetadataSlurper;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.fixedwidth.FixedRecordDefinition;
import org.burroloco.donkey.spit.fixedwidth.FixedWidthRecordSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class FileMetadataToFixedWidthWirer implements Wirer {
    Wire wire;
    Dna dna;

    //SIMIAN OFF
    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        wire.cls(FileMetadataSlurper.class).to(Slurper.class);
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        wire.cls(FileMetadataFixedRecordDefinition.class).to(FixedRecordDefinition.class);
        wire.cls(FixedWidthRecordSpitter.class).to(Spitter.class);
    }
    //SIMIAN ON
}
