package cn.wormholestack.mpring.core.io;

import cn.wormholestack.mpring.espression.NestedIOException;
import cn.wormholestack.mpring.support.utils.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @description： AbstractResource
 * @Author MRyan
 * @Date 2021/9/12 21:48
 * @Version 1.0
 */
public abstract class AbstractResource implements Resource {


    @Override
    public boolean exists() {
        // Try file existence: can we find the file in the file system?
        try {
            return getFile().exists();
        } catch (IOException ex) {
            // Fall back to stream existence: can we open the stream?
            try {
                getInputStream().close();
                return true;
            } catch (Throwable isEx) {
                return false;
            }
        }
    }


    @Override
    public boolean isReadable() {
        return exists();
    }


    @Override
    public boolean isOpen() {
        return false;
    }


    @Override
    public boolean isFile() {
        return false;
    }


    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
    }


    @Override
    public URI getURI() throws IOException {
        URL url = getURL();
        try {
            return ResourceUtils.toURI(url);
        } catch (URISyntaxException ex) {
            throw new NestedIOException("Invalid URI [" + url + "]", ex);
        }
    }


    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
    }


    protected File getFileForLastModifiedCheck() throws IOException {
        return getFile();
    }


    @Override
    public String getFilename() {
        return null;
    }


    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof Resource &&
                ((Resource) other).getDescription().equals(getDescription())));
    }


    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }


    @Override
    public String toString() {
        return getDescription();
    }

}
