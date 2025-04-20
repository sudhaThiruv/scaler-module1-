package org.example;

public class Main {
    public static void main(String[] args) {



        @RequestMapping(value = "/user-management")
        public class userController
        {
            @RequestMapping(value="/users", method = RequestMethod.OPTIONS)
            ResponseEntity collectionOptions() {
                System.out.println("Collection Options");
                return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS).build();
            }

            @RequestMapping(value="/users/{id}", method=RequestMethod.OPTIONS)
            ResponseEntity singularOptions()
            {
                System.out.println("Singular Options");
                return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS).build();
            }
//Other APIs
        }
    }
}

//http://localhost:8080/user-management/user/1

    //Collections Options
   // Collections Options with GET, POST, OPTIONS as allowed methods
      //  Singular Options with GET, DELETE, PUT, OPTIONS as allowed methods
        //Singular Options