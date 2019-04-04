(defproject clj-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clj-demo.core
  :target-path "target/%s"

  :java-cmd "/Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java"
  ;; :jvm-opts ["--add-modules" "java.xml.bind"] ;; for Java 10

  :profiles {:uberjar {:aot :all}})
