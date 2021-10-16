package cn.wormholestack.mpring.core.io;

import cn.wormholestack.mpring.support.utils.Assert;
import cn.wormholestack.mpring.support.utils.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Path;

/**
 * @description： FileSystemResource 文件系统资源的实现类
 * @Author MRyan
 * @Date 2021/9/12 21:46
 * @Version 1.0
 */
public class FileSystemResource implements Resource {

    private final String path;

    private final File file;

    private final Path filePath;

    public FileSystemResource(String path) {
        Assert.notNull(path, "Path must not be null");
        this.path = StringUtils.cleanPath(path);
        this.file = new File(path);
        this.filePath = this.file.toPath();
    }


    public FileSystemResource(File file) {
        Assert.notNull(file, "File must not be null");
        this.path = StringUtils.cleanPath(file.getPath());
        this.file = file;
        this.filePath = file.toPath();
    }


    public FileSystemResource(Path filePath) {
        Assert.notNull(filePath, "Path must not be null");
        this.path = StringUtils.cleanPath(filePath.toString());
        this.file = null;
        this.filePath = filePath;
    }

    public FileSystemResource(FileSystem fileSystem, String path) {
        Assert.notNull(fileSystem, "FileSystem must not be null");
        Assert.notNull(path, "Path must not be null");
        this.path = StringUtils.cleanPath(path);
        this.file = null;
        this.filePath = fileSystem.getPath(this.path).normalize();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return (this.file != null ? this.file.toURI().toURL() : this.filePath.toUri().toURL());
    }


    @Override
    public URI getURI() throws IOException {
        return (this.file != null ? this.file.toURI() : this.filePath.toUri());
    }

    @Override
    public boolean isFile() {
        return true;
    }


    @Override
    public File getFile() {
        return (this.file != null ? this.file : this.filePath.toFile());
    }


    @Override
    public String getFilename() {
        return (this.file != null ? this.file.getName() : this.filePath.getFileName().toString());
    }


    @Override
    public String getDescription() {
        return "file [" + (this.file != null ? this.file.getAbsolutePath() : this.filePath.toAbsolutePath()) + "]";
    }

    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof FileSystemResource &&
                this.path.equals(((FileSystemResource) other).path)));
    }

    @Override
    public int hashCode() {
        return this.path.hashCode();
    }
}