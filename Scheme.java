public class Scheme {
    /**
     * (video)
     * Controller (just for read from db)
     *
     *
     *                  quartz -> videoService.getNewVideos()  (just for put new records in db)
     *                  (list<item>)
     *                      |  1
     *                      V
     *              2   (list<item>)   3
     *  DataParser <->  VideoService  <-> VideoConverter (list<item> -> list<video>)
     *  (list<item>)    (list<video>)
     *                      |  4
     *                      V
     *                  (list<video>)
     *                  VideoRepository -> jOOQ (list<video> -> list<videoRecord>)
     *                  (list<videoRecord>)
     *                      |  5
     *                      V
     *                  (list<videoRecord>)
     *                  db
     *
     */
}
