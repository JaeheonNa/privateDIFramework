package org.study;

public class WriterService {

    @Inject
    BookPublisherService bookPublisherService;

    public void askPublish(String bookName){
        System.out.println("Please publish my book \'" + bookName + "\'");
        bookPublisherService.publish(bookName);
    }
}
