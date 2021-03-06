/*
 * The MIT License
 *
 *  Copyright (c) 2016, CloudBees, Inc.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package org.jenkinsci.plugins.oneshot;

import hudson.model.Computer;
import hudson.remoting.Channel;
import hudson.remoting.VirtualChannel;
import hudson.slaves.RetentionStrategy;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.annotation.Nullable;
import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.LogRecord;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class DeadComputer extends OneShotComputer {

    private final static Error DEAD = new ThreadDeath() {
        @Override
        public String getMessage() {
            return "Agent failed to start.";
        }
    };


    public DeadComputer(OneShotSlave slave) {
        super(slave);
    }

    @Nullable
    @Override
    public Channel getChannel() {
        throw DEAD;
    }

    @Override
    public Charset getDefaultCharset() {
        throw DEAD;
    }

    @Override
    public List<LogRecord> getLogRecords() throws IOException, InterruptedException {
        throw DEAD;
    }

    @Override
    public void doLaunchSlaveAgent(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        throw DEAD;
    }

    @Override
    protected Future<?> _connect(boolean forceReconnect) {
        throw DEAD;
    }

    @Override
    public Boolean isUnix() {
        throw DEAD;
    }

    @Override
    public boolean isConnecting() {
        throw DEAD;
    }

    @Override
    public RetentionStrategy getRetentionStrategy() {
        throw DEAD;
    }
}
