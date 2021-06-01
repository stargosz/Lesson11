package configration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Config {
    public static void main(String[] args) throws IOException {
//        Yaml yaml = new Yaml();
//        Constructor constructor = new Constructor(ConfigData.Environments.class);
//
//        TypeDescription dataDesc = new TypeDescription(ConfigData.class);
//        dataDesc.putListPropertyType("tests", ConfigData.Environments.class);
//        constructor.addTypeDescription(dataDesc);
//        Yaml yaml = new Yaml(constructor);
//        InputStream in = ClassLoader.getSystemResourceAsStream("config.yml");
//        ConfigData configData = yaml.loadAs(in, ConfigData.class);


//        InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.yml");
//        Map<String, Object> obj = yaml.load(confFileStream);
//        ConfigData configData = yaml.load(confFileStream);
//        System.out.println(obj.toString());
//        List<Object> envs = Arrays.asList(obj);
//        System.out.println(configData.getBrowser().toString());


//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try {
//            ConfigData configData = mapper.readValue(new File("src/main/resources/config.yml"), ConfigData.class);
//            System.out.println(ReflectionToStringBuilder.toString(configData, ToStringStyle.MULTI_LINE_STYLE));
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


        // Loading the YAML file from the /resources folder
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        File file = new File(classLoader.getResource("config.yml").getFile());
        InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.yml");


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        Environment environment = mapper.readValue(confFileStream, Environment.class);
//
        System.out.println("Employee info " + environment.toString());
        System.out.println(environment.getEnvironments().get(1).get("eTitle"));


    }
}