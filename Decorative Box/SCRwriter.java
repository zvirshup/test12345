
import java.io.IOException;
import java.util.ArrayList;

public class SCRwriter extends OutputFileManager {

    public SCRwriter() throws OutputFileManagerException
    {
        super();
    }
   
    public void OpenFile(String f, String qual, String ext) throws IOException, OutputFileManagerException
    {
        String fn = AddQual(f, qual);
        super.OpenFile(fn, ext);
    }
    public void OpenFile(InputFileManager f, String qual, String ext) throws IOException, OutputFileManagerException
    {
        String fn = AddQual(f.GetFileName(), qual);
        super.OpenFile(fn, ext);
    }
public void Write3d(ArrayList<Triple> points) throws IOException
{
   file.write("3dpoly");
   file.newLine();
   
   for(Triple t : points)
       { /* each point */
        file.write(Double.toString(t.X()));
        file.write(",");  // AutoCAD gets unhappy if there is a space after the comma
        file.write(Double.toString(t.Y()));
        file.write(",");  // AutoCAD gets unhappy if there is a space after the comma
        file.write(Double.toString(t.Z()));
        file.newLine();
       } /* each point */
} // Write3d

public void Write2d(ArrayList<Triple> points) throws IOException
{
    file.write("2dpoly");
    file.newLine();
     
     for(Triple t : points)
         { /* each point */
             file.write(Double.toString(t.X()));
             file.write(","); // AutoCAD gets unhappy if there is a space after the comma
             file.write(Double.toString(t.Y()));;
             file.newLine();
         } /* each point */
} // Write2d

    
}
