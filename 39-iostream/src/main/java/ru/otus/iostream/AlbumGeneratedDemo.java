package ru.otus.iostream;

import ru.otus.generated.AlbumProtos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AlbumGeneratedDemo {
	public static void main(String[] args) throws Exception {
		var album = AlbumProtos.Album.newBuilder()
				.addArtist("Artist1")
				.addArtist("Artist2")
				.addSongTitle("Song")
				.setTitle("Title")
				.build();
		System.out.println(album);

		try (OutputStream os = new FileOutputStream("protobuf.bin")) {
			album.writeTo(os);
		}

		try (InputStream is = new FileInputStream("protobuf.bin")) {
			var readed = AlbumProtos.Album.parseFrom(is);
			System.out.println("Readed: " + readed);
		}
	}
}
