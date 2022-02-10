import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

public class DeployerSpec extends JenkinsPipelineSpecification {

        def Jenkinsfile = null

        /*public static class DummyException extends RuntimeException {
                public DummyException(String _message) { super( _message ); }
        }*/

        def setup() {
                Jenkinsfile = loadPipelineScriptForTest("/Deployer.groovy")
                //Jenkinsfile.getBinding().setVariable( "scm", null )
                //explicitlyMockPipelineVariable("deploy")
                /*getPipelineMock("load")("hello.groovy") /*>> {
                        getPipelineMock("hello")
                }*/
        }
        def "sampletest"() {
         when:
                Jenkinsfile.deploy("test")
        then:
                  1 * getPipelineMock("echo")("hello test")
            }
        def "sampleproduction"() {
          when:
                Jenkinsfile.deploy("production")
          then:
                 1 * getPipelineMock("echo")("hello prod")
                       }

}
