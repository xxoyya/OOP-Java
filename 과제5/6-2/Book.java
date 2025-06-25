public class Book {
    private String author;
    private String title;
    private String buyer;

    // 생성자
    public Book(String author, String title, String buyer) {
        this.author = author;
        this.title = title;
        this.buyer = buyer;
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        return buyer + "이 구입한 도서: " + author + "의 " + title;
    }

    // equals() 오버라이딩: author와 title이 같으면 true
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return author.equals(other.author) && title.equals(other.title);
    }
}