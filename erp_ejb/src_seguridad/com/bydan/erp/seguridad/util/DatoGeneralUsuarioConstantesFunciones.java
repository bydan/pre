/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.seguridad.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.seguridad.util.DatoGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.DatoGeneralUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.DatoGeneralUsuarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DatoGeneralUsuarioConstantesFunciones extends DatoGeneralUsuarioConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="DatoGeneralUsuario";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DatoGeneralUsuario"+DatoGeneralUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DatoGeneralUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DatoGeneralUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DatoGeneralUsuarioConstantesFunciones.SCHEMA+"_"+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DatoGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DatoGeneralUsuarioConstantesFunciones.SCHEMA+"_"+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DatoGeneralUsuarioConstantesFunciones.SCHEMA+"_"+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DatoGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DatoGeneralUsuarioConstantesFunciones.SCHEMA+"_"+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DatoGeneralUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DatoGeneralUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DatoGeneralUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DatoGeneralUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dato General Usuarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dato General Usuario";
	public static final String SCLASSWEBTITULO_LOWER="Dato General Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DatoGeneralUsuario";
	public static final String OBJECTNAME="datogeneralusuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="dato_general_usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select datogeneralusuario from "+DatoGeneralUsuarioConstantesFunciones.SPERSISTENCENAME+" datogeneralusuario";
	public static String QUERYSELECTNATIVE="select "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".version_row,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_pais,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_provincia,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_ciudad,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".cedula,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".apellidos,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".nombres,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".telefono,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".telefono_movil,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".e_mail,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".url,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".fecha_nacimiento,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".direccion from "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+DatoGeneralUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DatoGeneralUsuarioConstantesFuncionesAdditional datogeneralusuarioConstantesFuncionesAdditional=null;
	
	public DatoGeneralUsuarioConstantesFuncionesAdditional getDatoGeneralUsuarioConstantesFuncionesAdditional() {
		return this.datogeneralusuarioConstantesFuncionesAdditional;
	}
	
	public void setDatoGeneralUsuarioConstantesFuncionesAdditional(DatoGeneralUsuarioConstantesFuncionesAdditional datogeneralusuarioConstantesFuncionesAdditional) {
		try {
			this.datogeneralusuarioConstantesFuncionesAdditional=datogeneralusuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String CEDULA= "cedula";
    public static final String APELLIDOS= "apellidos";
    public static final String NOMBRES= "nombres";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOMOVIL= "telefono_movil";
    public static final String EMAIL= "e_mail";
    public static final String URL= "url";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String DIRECCION= "direccion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_CEDULA= "Cedula";
		public static final String LABEL_CEDULA_LOWER= "Cedula";
    	public static final String LABEL_APELLIDOS= "Apellidos";
		public static final String LABEL_APELLIDOS_LOWER= "Apellidos";
    	public static final String LABEL_NOMBRES= "Nombres";
		public static final String LABEL_NOMBRES_LOWER= "Nombres";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOMOVIL= "Telefono Movil";
		public static final String LABEL_TELEFONOMOVIL_LOWER= "Telefono Movil";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_URL= "Url";
		public static final String LABEL_URL_LOWER= "Url";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
	
		
		
		
		
		
	public static final String SREGEXCEDULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCEDULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONO_MOVIL=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_MOVIL=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXURL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXURL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDatoGeneralUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.IDPAIS)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.IDCIUDAD)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.CEDULA)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_CEDULA;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.APELLIDOS)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_APELLIDOS;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.NOMBRES)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_NOMBRES;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONO)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONOMOVIL;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.EMAIL)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.URL)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_URL;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(DatoGeneralUsuarioConstantesFunciones.DIRECCION)) {sLabelColumna=DatoGeneralUsuarioConstantesFunciones.LABEL_DIRECCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDatoGeneralUsuarioDescripcion(DatoGeneralUsuario datogeneralusuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(datogeneralusuario !=null/* && datogeneralusuario.getId()!=0*/) {
			if(datogeneralusuario.getId()!=null) {
				sDescripcion=datogeneralusuario.getId().toString();
			}//datogeneralusuariodatogeneralusuario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDatoGeneralUsuarioDescripcionDetallado(DatoGeneralUsuario datogeneralusuario) {
		String sDescripcion="";
			
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=datogeneralusuario.getId().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=datogeneralusuario.getVersionRow().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.IDPAIS+"=";
		sDescripcion+=datogeneralusuario.getid_pais().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=datogeneralusuario.getid_provincia().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=datogeneralusuario.getid_ciudad().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.CEDULA+"=";
		sDescripcion+=datogeneralusuario.getcedula()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.APELLIDOS+"=";
		sDescripcion+=datogeneralusuario.getapellidos()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.NOMBRES+"=";
		sDescripcion+=datogeneralusuario.getnombres()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.TELEFONO+"=";
		sDescripcion+=datogeneralusuario.gettelefono()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL+"=";
		sDescripcion+=datogeneralusuario.gettelefono_movil()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.EMAIL+"=";
		sDescripcion+=datogeneralusuario.gete_mail()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.URL+"=";
		sDescripcion+=datogeneralusuario.geturl()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=datogeneralusuario.getfecha_nacimiento().toString()+",";
		sDescripcion+=DatoGeneralUsuarioConstantesFunciones.DIRECCION+"=";
		sDescripcion+=datogeneralusuario.getdireccion()+",";
			
		return sDescripcion;
	}
	
	public static void setDatoGeneralUsuarioDescripcion(DatoGeneralUsuario datogeneralusuario,String sValor) throws Exception {			
		if(datogeneralusuario !=null) {
			//datogeneralusuariodatogeneralusuario.getId().toString();
		}		
	}
	
		

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Id="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datogeneralusuario.setcedula(datogeneralusuario.getcedula().trim());
		datogeneralusuario.setapellidos(datogeneralusuario.getapellidos().trim());
		datogeneralusuario.setnombres(datogeneralusuario.getnombres().trim());
		datogeneralusuario.settelefono(datogeneralusuario.gettelefono().trim());
		datogeneralusuario.settelefono_movil(datogeneralusuario.gettelefono_movil().trim());
		datogeneralusuario.sete_mail(datogeneralusuario.gete_mail().trim());
		datogeneralusuario.seturl(datogeneralusuario.geturl().trim());
		datogeneralusuario.setdireccion(datogeneralusuario.getdireccion().trim());
	}
	
	public static void quitarEspaciosDatoGeneralUsuarios(List<DatoGeneralUsuario> datogeneralusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario: datogeneralusuarios) {
			datogeneralusuario.setcedula(datogeneralusuario.getcedula().trim());
			datogeneralusuario.setapellidos(datogeneralusuario.getapellidos().trim());
			datogeneralusuario.setnombres(datogeneralusuario.getnombres().trim());
			datogeneralusuario.settelefono(datogeneralusuario.gettelefono().trim());
			datogeneralusuario.settelefono_movil(datogeneralusuario.gettelefono_movil().trim());
			datogeneralusuario.sete_mail(datogeneralusuario.gete_mail().trim());
			datogeneralusuario.seturl(datogeneralusuario.geturl().trim());
			datogeneralusuario.setdireccion(datogeneralusuario.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && datogeneralusuario.getConCambioAuxiliar()) {
			datogeneralusuario.setIsDeleted(datogeneralusuario.getIsDeletedAuxiliar());	
			datogeneralusuario.setIsNew(datogeneralusuario.getIsNewAuxiliar());	
			datogeneralusuario.setIsChanged(datogeneralusuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			datogeneralusuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			datogeneralusuario.setIsDeletedAuxiliar(false);	
			datogeneralusuario.setIsNewAuxiliar(false);	
			datogeneralusuario.setIsChangedAuxiliar(false);
			
			datogeneralusuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoGeneralUsuarios(List<DatoGeneralUsuario> datogeneralusuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario : datogeneralusuarios) {
			if(conAsignarBase && datogeneralusuario.getConCambioAuxiliar()) {
				datogeneralusuario.setIsDeleted(datogeneralusuario.getIsDeletedAuxiliar());	
				datogeneralusuario.setIsNew(datogeneralusuario.getIsNewAuxiliar());	
				datogeneralusuario.setIsChanged(datogeneralusuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				datogeneralusuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				datogeneralusuario.setIsDeletedAuxiliar(false);	
				datogeneralusuario.setIsNewAuxiliar(false);	
				datogeneralusuario.setIsChangedAuxiliar(false);
				
				datogeneralusuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDatoGeneralUsuarios(List<DatoGeneralUsuario> datogeneralusuarios,Boolean conEnteros) throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario: datogeneralusuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDatoGeneralUsuario(List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuario datogeneralusuarioAux) throws Exception  {
		DatoGeneralUsuarioConstantesFunciones.InicializarValoresDatoGeneralUsuario(datogeneralusuarioAux,true);
		
		for(DatoGeneralUsuario datogeneralusuario: datogeneralusuarios) {
			if(datogeneralusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DatoGeneralUsuarioConstantesFunciones.getArrayColumnasGlobalesDatoGeneralUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDatoGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuario datogeneralusuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DatoGeneralUsuario datogeneralusuarioAux: datogeneralusuarios) {
			if(datogeneralusuarioAux!=null && datogeneralusuario!=null) {
				if((datogeneralusuarioAux.getId()==null && datogeneralusuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(datogeneralusuarioAux.getId()!=null && datogeneralusuario.getId()!=null){
					if(datogeneralusuarioAux.getId().equals(datogeneralusuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDatoGeneralUsuario(List<DatoGeneralUsuario> datogeneralusuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DatoGeneralUsuario datogeneralusuario: datogeneralusuarios) {			
			if(datogeneralusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDatoGeneralUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_ID, DatoGeneralUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_VERSIONROW, DatoGeneralUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_IDPAIS, DatoGeneralUsuarioConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_IDPROVINCIA, DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_IDCIUDAD, DatoGeneralUsuarioConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_CEDULA, DatoGeneralUsuarioConstantesFunciones.CEDULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_APELLIDOS, DatoGeneralUsuarioConstantesFunciones.APELLIDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_NOMBRES, DatoGeneralUsuarioConstantesFunciones.NOMBRES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONO, DatoGeneralUsuarioConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONOMOVIL, DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_EMAIL, DatoGeneralUsuarioConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_URL, DatoGeneralUsuarioConstantesFunciones.URL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_FECHANACIMIENTO, DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralUsuarioConstantesFunciones.LABEL_DIRECCION, DatoGeneralUsuarioConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDatoGeneralUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.CEDULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.APELLIDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.NOMBRES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.URL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralUsuarioConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralUsuario() throws Exception  {
		return DatoGeneralUsuarioConstantesFunciones.getTiposSeleccionarDatoGeneralUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralUsuario(Boolean conFk) throws Exception  {
		return DatoGeneralUsuarioConstantesFunciones.getTiposSeleccionarDatoGeneralUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_CEDULA);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_CEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_APELLIDOS);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_APELLIDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_NOMBRES);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_NOMBRES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONOMOVIL);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONOMOVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_URL);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_URL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralUsuarioConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(DatoGeneralUsuarioConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDatoGeneralUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuarioAux) throws Exception {
		
			datogeneralusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(datogeneralusuarioAux.getUsuario()));
			datogeneralusuarioAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(datogeneralusuarioAux.getPais()));
			datogeneralusuarioAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(datogeneralusuarioAux.getProvincia()));
			datogeneralusuarioAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(datogeneralusuarioAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDatoGeneralUsuario(List<DatoGeneralUsuario> datogeneralusuariosTemp) throws Exception {
		for(DatoGeneralUsuario datogeneralusuarioAux:datogeneralusuariosTemp) {
			
			datogeneralusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(datogeneralusuarioAux.getUsuario()));
			datogeneralusuarioAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(datogeneralusuarioAux.getPais()));
			datogeneralusuarioAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(datogeneralusuarioAux.getProvincia()));
			datogeneralusuarioAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(datogeneralusuarioAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDatoGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDatoGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoGeneralUsuarioConstantesFunciones.getClassesRelationshipsOfDatoGeneralUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoGeneralUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfDatoGeneralUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DatoGeneralUsuario datogeneralusuario,List<DatoGeneralUsuario> datogeneralusuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DatoGeneralUsuario datogeneralusuarioEncontrado=null;
			
			for(DatoGeneralUsuario datogeneralusuarioLocal:datogeneralusuarios) {
				if(datogeneralusuarioLocal.getId().equals(datogeneralusuario.getId())) {
					datogeneralusuarioEncontrado=datogeneralusuarioLocal;
					
					datogeneralusuarioLocal.setIsChanged(datogeneralusuario.getIsChanged());
					datogeneralusuarioLocal.setIsNew(datogeneralusuario.getIsNew());
					datogeneralusuarioLocal.setIsDeleted(datogeneralusuario.getIsDeleted());
					
					datogeneralusuarioLocal.setGeneralEntityOriginal(datogeneralusuario.getGeneralEntityOriginal());
					
					datogeneralusuarioLocal.setId(datogeneralusuario.getId());	
					datogeneralusuarioLocal.setVersionRow(datogeneralusuario.getVersionRow());	
					datogeneralusuarioLocal.setid_pais(datogeneralusuario.getid_pais());	
					datogeneralusuarioLocal.setid_provincia(datogeneralusuario.getid_provincia());	
					datogeneralusuarioLocal.setid_ciudad(datogeneralusuario.getid_ciudad());	
					datogeneralusuarioLocal.setcedula(datogeneralusuario.getcedula());	
					datogeneralusuarioLocal.setapellidos(datogeneralusuario.getapellidos());	
					datogeneralusuarioLocal.setnombres(datogeneralusuario.getnombres());	
					datogeneralusuarioLocal.settelefono(datogeneralusuario.gettelefono());	
					datogeneralusuarioLocal.settelefono_movil(datogeneralusuario.gettelefono_movil());	
					datogeneralusuarioLocal.sete_mail(datogeneralusuario.gete_mail());	
					datogeneralusuarioLocal.seturl(datogeneralusuario.geturl());	
					datogeneralusuarioLocal.setfecha_nacimiento(datogeneralusuario.getfecha_nacimiento());	
					datogeneralusuarioLocal.setdireccion(datogeneralusuario.getdireccion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!datogeneralusuario.getIsDeleted()) {
				if(!existe) {
					datogeneralusuarios.add(datogeneralusuario);
				}
			} else {
				if(datogeneralusuarioEncontrado!=null && permiteQuitar)  {
					datogeneralusuarios.remove(datogeneralusuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DatoGeneralUsuario datogeneralusuario,List<DatoGeneralUsuario> datogeneralusuarios) throws Exception {
		try	{			
			for(DatoGeneralUsuario datogeneralusuarioLocal:datogeneralusuarios) {
				if(datogeneralusuarioLocal.getId().equals(datogeneralusuario.getId())) {
					datogeneralusuarioLocal.setIsSelected(datogeneralusuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDatoGeneralUsuario(List<DatoGeneralUsuario> datogeneralusuariosAux) throws Exception {
		//this.datogeneralusuariosAux=datogeneralusuariosAux;
		
		for(DatoGeneralUsuario datogeneralusuarioAux:datogeneralusuariosAux) {
			if(datogeneralusuarioAux.getIsChanged()) {
				datogeneralusuarioAux.setIsChanged(false);
			}		
			
			if(datogeneralusuarioAux.getIsNew()) {
				datogeneralusuarioAux.setIsNew(false);
			}	
			
			if(datogeneralusuarioAux.getIsDeleted()) {
				datogeneralusuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuarioAux) throws Exception {
		//this.datogeneralusuarioAux=datogeneralusuarioAux;
		
			if(datogeneralusuarioAux.getIsChanged()) {
				datogeneralusuarioAux.setIsChanged(false);
			}		
			
			if(datogeneralusuarioAux.getIsNew()) {
				datogeneralusuarioAux.setIsNew(false);
			}	
			
			if(datogeneralusuarioAux.getIsDeleted()) {
				datogeneralusuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DatoGeneralUsuario datogeneralusuarioAsignar,DatoGeneralUsuario datogeneralusuario) throws Exception {
		datogeneralusuarioAsignar.setId(datogeneralusuario.getId());	
		datogeneralusuarioAsignar.setVersionRow(datogeneralusuario.getVersionRow());	
		datogeneralusuarioAsignar.setid_pais(datogeneralusuario.getid_pais());
		datogeneralusuarioAsignar.setpais_descripcion(datogeneralusuario.getpais_descripcion());	
		datogeneralusuarioAsignar.setid_provincia(datogeneralusuario.getid_provincia());
		datogeneralusuarioAsignar.setprovincia_descripcion(datogeneralusuario.getprovincia_descripcion());	
		datogeneralusuarioAsignar.setid_ciudad(datogeneralusuario.getid_ciudad());
		datogeneralusuarioAsignar.setciudad_descripcion(datogeneralusuario.getciudad_descripcion());	
		datogeneralusuarioAsignar.setcedula(datogeneralusuario.getcedula());	
		datogeneralusuarioAsignar.setapellidos(datogeneralusuario.getapellidos());	
		datogeneralusuarioAsignar.setnombres(datogeneralusuario.getnombres());	
		datogeneralusuarioAsignar.settelefono(datogeneralusuario.gettelefono());	
		datogeneralusuarioAsignar.settelefono_movil(datogeneralusuario.gettelefono_movil());	
		datogeneralusuarioAsignar.sete_mail(datogeneralusuario.gete_mail());	
		datogeneralusuarioAsignar.seturl(datogeneralusuario.geturl());	
		datogeneralusuarioAsignar.setfecha_nacimiento(datogeneralusuario.getfecha_nacimiento());	
		datogeneralusuarioAsignar.setdireccion(datogeneralusuario.getdireccion());	
	}
	
	public static void inicializarDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario) throws Exception {
		try {
				datogeneralusuario.setId(-1L);	
					
				datogeneralusuario.setid_pais(-1L);	
				datogeneralusuario.setid_provincia(-1L);	
				datogeneralusuario.setid_ciudad(-1L);	
				datogeneralusuario.setcedula("");	
				datogeneralusuario.setapellidos("");	
				datogeneralusuario.setnombres("");	
				datogeneralusuario.settelefono("");	
				datogeneralusuario.settelefono_movil("");	
				datogeneralusuario.sete_mail("");	
				datogeneralusuario.seturl("");	
				datogeneralusuario.setfecha_nacimiento(new Date());	
				datogeneralusuario.setdireccion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDatoGeneralUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_CEDULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_APELLIDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_NOMBRES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_TELEFONOMOVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_URL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralUsuarioConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDatoGeneralUsuario(String sTipo,Row row,Workbook workbook,DatoGeneralUsuario datogeneralusuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getcedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getapellidos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getnombres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.gettelefono_movil());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.geturl());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralusuario.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDatoGeneralUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDatoGeneralUsuario() {
		return this.sFinalQueryDatoGeneralUsuario;
	}
	
	public void setsFinalQueryDatoGeneralUsuario(String sFinalQueryDatoGeneralUsuario) {
		this.sFinalQueryDatoGeneralUsuario= sFinalQueryDatoGeneralUsuario;
	}
	
	public Border resaltarSeleccionarDatoGeneralUsuario=null;
	
	public Border setResaltarSeleccionarDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDatoGeneralUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDatoGeneralUsuario() {
		return this.resaltarSeleccionarDatoGeneralUsuario;
	}
	
	public void setResaltarSeleccionarDatoGeneralUsuario(Border borderResaltarSeleccionarDatoGeneralUsuario) {
		this.resaltarSeleccionarDatoGeneralUsuario= borderResaltarSeleccionarDatoGeneralUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltarid_usuarioDatoGeneralUsuario=null;
	public Boolean mostrarid_usuarioDatoGeneralUsuario=true;
	public Boolean activarid_usuarioDatoGeneralUsuario=true;
	public Boolean cargarid_usuarioDatoGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDatoGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_paisDatoGeneralUsuario=null;
	public Boolean mostrarid_paisDatoGeneralUsuario=true;
	public Boolean activarid_paisDatoGeneralUsuario=true;
	public Boolean cargarid_paisDatoGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisDatoGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_provinciaDatoGeneralUsuario=null;
	public Boolean mostrarid_provinciaDatoGeneralUsuario=true;
	public Boolean activarid_provinciaDatoGeneralUsuario=true;
	public Boolean cargarid_provinciaDatoGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaDatoGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_ciudadDatoGeneralUsuario=null;
	public Boolean mostrarid_ciudadDatoGeneralUsuario=true;
	public Boolean activarid_ciudadDatoGeneralUsuario=true;
	public Boolean cargarid_ciudadDatoGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadDatoGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarcedulaDatoGeneralUsuario=null;
	public Boolean mostrarcedulaDatoGeneralUsuario=true;
	public Boolean activarcedulaDatoGeneralUsuario=true;

	public Border resaltarapellidosDatoGeneralUsuario=null;
	public Boolean mostrarapellidosDatoGeneralUsuario=true;
	public Boolean activarapellidosDatoGeneralUsuario=true;

	public Border resaltarnombresDatoGeneralUsuario=null;
	public Boolean mostrarnombresDatoGeneralUsuario=true;
	public Boolean activarnombresDatoGeneralUsuario=true;

	public Border resaltartelefonoDatoGeneralUsuario=null;
	public Boolean mostrartelefonoDatoGeneralUsuario=true;
	public Boolean activartelefonoDatoGeneralUsuario=true;

	public Border resaltartelefono_movilDatoGeneralUsuario=null;
	public Boolean mostrartelefono_movilDatoGeneralUsuario=true;
	public Boolean activartelefono_movilDatoGeneralUsuario=true;

	public Border resaltare_mailDatoGeneralUsuario=null;
	public Boolean mostrare_mailDatoGeneralUsuario=true;
	public Boolean activare_mailDatoGeneralUsuario=true;

	public Border resaltarurlDatoGeneralUsuario=null;
	public Boolean mostrarurlDatoGeneralUsuario=true;
	public Boolean activarurlDatoGeneralUsuario=true;

	public Border resaltarfecha_nacimientoDatoGeneralUsuario=null;
	public Boolean mostrarfecha_nacimientoDatoGeneralUsuario=true;
	public Boolean activarfecha_nacimientoDatoGeneralUsuario=false;

	public Border resaltardireccionDatoGeneralUsuario=null;
	public Boolean mostrardireccionDatoGeneralUsuario=true;
	public Boolean activardireccionDatoGeneralUsuario=true;

	
	

	public Border setResaltarid_usuarioDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDatoGeneralUsuario() {
		return this.resaltarid_usuarioDatoGeneralUsuario;
	}

	public void setResaltarid_usuarioDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarid_usuarioDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDatoGeneralUsuario() {
		return this.mostrarid_usuarioDatoGeneralUsuario;
	}

	public void setMostrarid_usuarioDatoGeneralUsuario(Boolean mostrarid_usuarioDatoGeneralUsuario) {
		this.mostrarid_usuarioDatoGeneralUsuario= mostrarid_usuarioDatoGeneralUsuario;
	}

	public Boolean getActivarid_usuarioDatoGeneralUsuario() {
		return this.activarid_usuarioDatoGeneralUsuario;
	}

	public void setActivarid_usuarioDatoGeneralUsuario(Boolean activarid_usuarioDatoGeneralUsuario) {
		this.activarid_usuarioDatoGeneralUsuario= activarid_usuarioDatoGeneralUsuario;
	}

	public Boolean getCargarid_usuarioDatoGeneralUsuario() {
		return this.cargarid_usuarioDatoGeneralUsuario;
	}

	public void setCargarid_usuarioDatoGeneralUsuario(Boolean cargarid_usuarioDatoGeneralUsuario) {
		this.cargarid_usuarioDatoGeneralUsuario= cargarid_usuarioDatoGeneralUsuario;
	}

	public Border setResaltarid_paisDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_paisDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisDatoGeneralUsuario() {
		return this.resaltarid_paisDatoGeneralUsuario;
	}

	public void setResaltarid_paisDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarid_paisDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_paisDatoGeneralUsuario() {
		return this.mostrarid_paisDatoGeneralUsuario;
	}

	public void setMostrarid_paisDatoGeneralUsuario(Boolean mostrarid_paisDatoGeneralUsuario) {
		this.mostrarid_paisDatoGeneralUsuario= mostrarid_paisDatoGeneralUsuario;
	}

	public Boolean getActivarid_paisDatoGeneralUsuario() {
		return this.activarid_paisDatoGeneralUsuario;
	}

	public void setActivarid_paisDatoGeneralUsuario(Boolean activarid_paisDatoGeneralUsuario) {
		this.activarid_paisDatoGeneralUsuario= activarid_paisDatoGeneralUsuario;
	}

	public Boolean getCargarid_paisDatoGeneralUsuario() {
		return this.cargarid_paisDatoGeneralUsuario;
	}

	public void setCargarid_paisDatoGeneralUsuario(Boolean cargarid_paisDatoGeneralUsuario) {
		this.cargarid_paisDatoGeneralUsuario= cargarid_paisDatoGeneralUsuario;
	}

	public Border setResaltarid_provinciaDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_provinciaDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaDatoGeneralUsuario() {
		return this.resaltarid_provinciaDatoGeneralUsuario;
	}

	public void setResaltarid_provinciaDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarid_provinciaDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_provinciaDatoGeneralUsuario() {
		return this.mostrarid_provinciaDatoGeneralUsuario;
	}

	public void setMostrarid_provinciaDatoGeneralUsuario(Boolean mostrarid_provinciaDatoGeneralUsuario) {
		this.mostrarid_provinciaDatoGeneralUsuario= mostrarid_provinciaDatoGeneralUsuario;
	}

	public Boolean getActivarid_provinciaDatoGeneralUsuario() {
		return this.activarid_provinciaDatoGeneralUsuario;
	}

	public void setActivarid_provinciaDatoGeneralUsuario(Boolean activarid_provinciaDatoGeneralUsuario) {
		this.activarid_provinciaDatoGeneralUsuario= activarid_provinciaDatoGeneralUsuario;
	}

	public Boolean getCargarid_provinciaDatoGeneralUsuario() {
		return this.cargarid_provinciaDatoGeneralUsuario;
	}

	public void setCargarid_provinciaDatoGeneralUsuario(Boolean cargarid_provinciaDatoGeneralUsuario) {
		this.cargarid_provinciaDatoGeneralUsuario= cargarid_provinciaDatoGeneralUsuario;
	}

	public Border setResaltarid_ciudadDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_ciudadDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadDatoGeneralUsuario() {
		return this.resaltarid_ciudadDatoGeneralUsuario;
	}

	public void setResaltarid_ciudadDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarid_ciudadDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_ciudadDatoGeneralUsuario() {
		return this.mostrarid_ciudadDatoGeneralUsuario;
	}

	public void setMostrarid_ciudadDatoGeneralUsuario(Boolean mostrarid_ciudadDatoGeneralUsuario) {
		this.mostrarid_ciudadDatoGeneralUsuario= mostrarid_ciudadDatoGeneralUsuario;
	}

	public Boolean getActivarid_ciudadDatoGeneralUsuario() {
		return this.activarid_ciudadDatoGeneralUsuario;
	}

	public void setActivarid_ciudadDatoGeneralUsuario(Boolean activarid_ciudadDatoGeneralUsuario) {
		this.activarid_ciudadDatoGeneralUsuario= activarid_ciudadDatoGeneralUsuario;
	}

	public Boolean getCargarid_ciudadDatoGeneralUsuario() {
		return this.cargarid_ciudadDatoGeneralUsuario;
	}

	public void setCargarid_ciudadDatoGeneralUsuario(Boolean cargarid_ciudadDatoGeneralUsuario) {
		this.cargarid_ciudadDatoGeneralUsuario= cargarid_ciudadDatoGeneralUsuario;
	}

	public Border setResaltarcedulaDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcedulaDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedulaDatoGeneralUsuario() {
		return this.resaltarcedulaDatoGeneralUsuario;
	}

	public void setResaltarcedulaDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarcedulaDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcedulaDatoGeneralUsuario() {
		return this.mostrarcedulaDatoGeneralUsuario;
	}

	public void setMostrarcedulaDatoGeneralUsuario(Boolean mostrarcedulaDatoGeneralUsuario) {
		this.mostrarcedulaDatoGeneralUsuario= mostrarcedulaDatoGeneralUsuario;
	}

	public Boolean getActivarcedulaDatoGeneralUsuario() {
		return this.activarcedulaDatoGeneralUsuario;
	}

	public void setActivarcedulaDatoGeneralUsuario(Boolean activarcedulaDatoGeneralUsuario) {
		this.activarcedulaDatoGeneralUsuario= activarcedulaDatoGeneralUsuario;
	}

	public Border setResaltarapellidosDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarapellidosDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidosDatoGeneralUsuario() {
		return this.resaltarapellidosDatoGeneralUsuario;
	}

	public void setResaltarapellidosDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarapellidosDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarapellidosDatoGeneralUsuario() {
		return this.mostrarapellidosDatoGeneralUsuario;
	}

	public void setMostrarapellidosDatoGeneralUsuario(Boolean mostrarapellidosDatoGeneralUsuario) {
		this.mostrarapellidosDatoGeneralUsuario= mostrarapellidosDatoGeneralUsuario;
	}

	public Boolean getActivarapellidosDatoGeneralUsuario() {
		return this.activarapellidosDatoGeneralUsuario;
	}

	public void setActivarapellidosDatoGeneralUsuario(Boolean activarapellidosDatoGeneralUsuario) {
		this.activarapellidosDatoGeneralUsuario= activarapellidosDatoGeneralUsuario;
	}

	public Border setResaltarnombresDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarnombresDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombresDatoGeneralUsuario() {
		return this.resaltarnombresDatoGeneralUsuario;
	}

	public void setResaltarnombresDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarnombresDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarnombresDatoGeneralUsuario() {
		return this.mostrarnombresDatoGeneralUsuario;
	}

	public void setMostrarnombresDatoGeneralUsuario(Boolean mostrarnombresDatoGeneralUsuario) {
		this.mostrarnombresDatoGeneralUsuario= mostrarnombresDatoGeneralUsuario;
	}

	public Boolean getActivarnombresDatoGeneralUsuario() {
		return this.activarnombresDatoGeneralUsuario;
	}

	public void setActivarnombresDatoGeneralUsuario(Boolean activarnombresDatoGeneralUsuario) {
		this.activarnombresDatoGeneralUsuario= activarnombresDatoGeneralUsuario;
	}

	public Border setResaltartelefonoDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltartelefonoDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoDatoGeneralUsuario() {
		return this.resaltartelefonoDatoGeneralUsuario;
	}

	public void setResaltartelefonoDatoGeneralUsuario(Border borderResaltar) {
		this.resaltartelefonoDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrartelefonoDatoGeneralUsuario() {
		return this.mostrartelefonoDatoGeneralUsuario;
	}

	public void setMostrartelefonoDatoGeneralUsuario(Boolean mostrartelefonoDatoGeneralUsuario) {
		this.mostrartelefonoDatoGeneralUsuario= mostrartelefonoDatoGeneralUsuario;
	}

	public Boolean getActivartelefonoDatoGeneralUsuario() {
		return this.activartelefonoDatoGeneralUsuario;
	}

	public void setActivartelefonoDatoGeneralUsuario(Boolean activartelefonoDatoGeneralUsuario) {
		this.activartelefonoDatoGeneralUsuario= activartelefonoDatoGeneralUsuario;
	}

	public Border setResaltartelefono_movilDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltartelefono_movilDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_movilDatoGeneralUsuario() {
		return this.resaltartelefono_movilDatoGeneralUsuario;
	}

	public void setResaltartelefono_movilDatoGeneralUsuario(Border borderResaltar) {
		this.resaltartelefono_movilDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrartelefono_movilDatoGeneralUsuario() {
		return this.mostrartelefono_movilDatoGeneralUsuario;
	}

	public void setMostrartelefono_movilDatoGeneralUsuario(Boolean mostrartelefono_movilDatoGeneralUsuario) {
		this.mostrartelefono_movilDatoGeneralUsuario= mostrartelefono_movilDatoGeneralUsuario;
	}

	public Boolean getActivartelefono_movilDatoGeneralUsuario() {
		return this.activartelefono_movilDatoGeneralUsuario;
	}

	public void setActivartelefono_movilDatoGeneralUsuario(Boolean activartelefono_movilDatoGeneralUsuario) {
		this.activartelefono_movilDatoGeneralUsuario= activartelefono_movilDatoGeneralUsuario;
	}

	public Border setResaltare_mailDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltare_mailDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailDatoGeneralUsuario() {
		return this.resaltare_mailDatoGeneralUsuario;
	}

	public void setResaltare_mailDatoGeneralUsuario(Border borderResaltar) {
		this.resaltare_mailDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrare_mailDatoGeneralUsuario() {
		return this.mostrare_mailDatoGeneralUsuario;
	}

	public void setMostrare_mailDatoGeneralUsuario(Boolean mostrare_mailDatoGeneralUsuario) {
		this.mostrare_mailDatoGeneralUsuario= mostrare_mailDatoGeneralUsuario;
	}

	public Boolean getActivare_mailDatoGeneralUsuario() {
		return this.activare_mailDatoGeneralUsuario;
	}

	public void setActivare_mailDatoGeneralUsuario(Boolean activare_mailDatoGeneralUsuario) {
		this.activare_mailDatoGeneralUsuario= activare_mailDatoGeneralUsuario;
	}

	public Border setResaltarurlDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarurlDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarurlDatoGeneralUsuario() {
		return this.resaltarurlDatoGeneralUsuario;
	}

	public void setResaltarurlDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarurlDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarurlDatoGeneralUsuario() {
		return this.mostrarurlDatoGeneralUsuario;
	}

	public void setMostrarurlDatoGeneralUsuario(Boolean mostrarurlDatoGeneralUsuario) {
		this.mostrarurlDatoGeneralUsuario= mostrarurlDatoGeneralUsuario;
	}

	public Boolean getActivarurlDatoGeneralUsuario() {
		return this.activarurlDatoGeneralUsuario;
	}

	public void setActivarurlDatoGeneralUsuario(Boolean activarurlDatoGeneralUsuario) {
		this.activarurlDatoGeneralUsuario= activarurlDatoGeneralUsuario;
	}

	public Border setResaltarfecha_nacimientoDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoDatoGeneralUsuario() {
		return this.resaltarfecha_nacimientoDatoGeneralUsuario;
	}

	public void setResaltarfecha_nacimientoDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarfecha_nacimientoDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoDatoGeneralUsuario() {
		return this.mostrarfecha_nacimientoDatoGeneralUsuario;
	}

	public void setMostrarfecha_nacimientoDatoGeneralUsuario(Boolean mostrarfecha_nacimientoDatoGeneralUsuario) {
		this.mostrarfecha_nacimientoDatoGeneralUsuario= mostrarfecha_nacimientoDatoGeneralUsuario;
	}

	public Boolean getActivarfecha_nacimientoDatoGeneralUsuario() {
		return this.activarfecha_nacimientoDatoGeneralUsuario;
	}

	public void setActivarfecha_nacimientoDatoGeneralUsuario(Boolean activarfecha_nacimientoDatoGeneralUsuario) {
		this.activarfecha_nacimientoDatoGeneralUsuario= activarfecha_nacimientoDatoGeneralUsuario;
	}

	public Border setResaltardireccionDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralusuarioBeanSwingJInternalFrame.jTtoolBarDatoGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltardireccionDatoGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionDatoGeneralUsuario() {
		return this.resaltardireccionDatoGeneralUsuario;
	}

	public void setResaltardireccionDatoGeneralUsuario(Border borderResaltar) {
		this.resaltardireccionDatoGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrardireccionDatoGeneralUsuario() {
		return this.mostrardireccionDatoGeneralUsuario;
	}

	public void setMostrardireccionDatoGeneralUsuario(Boolean mostrardireccionDatoGeneralUsuario) {
		this.mostrardireccionDatoGeneralUsuario= mostrardireccionDatoGeneralUsuario;
	}

	public Boolean getActivardireccionDatoGeneralUsuario() {
		return this.activardireccionDatoGeneralUsuario;
	}

	public void setActivardireccionDatoGeneralUsuario(Boolean activardireccionDatoGeneralUsuario) {
		this.activardireccionDatoGeneralUsuario= activardireccionDatoGeneralUsuario;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostrarid_usuarioDatoGeneralUsuario(esInicial);
		this.setMostrarid_paisDatoGeneralUsuario(esInicial);
		this.setMostrarid_provinciaDatoGeneralUsuario(esInicial);
		this.setMostrarid_ciudadDatoGeneralUsuario(esInicial);
		this.setMostrarcedulaDatoGeneralUsuario(esInicial);
		this.setMostrarapellidosDatoGeneralUsuario(esInicial);
		this.setMostrarnombresDatoGeneralUsuario(esInicial);
		this.setMostrartelefonoDatoGeneralUsuario(esInicial);
		this.setMostrartelefono_movilDatoGeneralUsuario(esInicial);
		this.setMostrare_mailDatoGeneralUsuario(esInicial);
		this.setMostrarurlDatoGeneralUsuario(esInicial);
		this.setMostrarfecha_nacimientoDatoGeneralUsuario(esInicial);
		this.setMostrardireccionDatoGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.ID)) {
				this.setMostrarid_usuarioDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.CEDULA)) {
				this.setMostrarcedulaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.APELLIDOS)) {
				this.setMostrarapellidosDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.NOMBRES)) {
				this.setMostrarnombresDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL)) {
				this.setMostrartelefono_movilDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.EMAIL)) {
				this.setMostrare_mailDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.URL)) {
				this.setMostrarurlDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionDatoGeneralUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivarid_usuarioDatoGeneralUsuario(esInicial);
		this.setActivarid_paisDatoGeneralUsuario(esInicial);
		this.setActivarid_provinciaDatoGeneralUsuario(esInicial);
		this.setActivarid_ciudadDatoGeneralUsuario(esInicial);
		this.setActivarcedulaDatoGeneralUsuario(esInicial);
		this.setActivarapellidosDatoGeneralUsuario(esInicial);
		this.setActivarnombresDatoGeneralUsuario(esInicial);
		this.setActivartelefonoDatoGeneralUsuario(esInicial);
		this.setActivartelefono_movilDatoGeneralUsuario(esInicial);
		this.setActivare_mailDatoGeneralUsuario(esInicial);
		this.setActivarurlDatoGeneralUsuario(esInicial);
		this.setActivarfecha_nacimientoDatoGeneralUsuario(esInicial);
		this.setActivardireccionDatoGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.ID)) {
				this.setActivarid_usuarioDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.CEDULA)) {
				this.setActivarcedulaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.APELLIDOS)) {
				this.setActivarapellidosDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.NOMBRES)) {
				this.setActivarnombresDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL)) {
				this.setActivartelefono_movilDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.EMAIL)) {
				this.setActivare_mailDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.URL)) {
				this.setActivarurlDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.DIRECCION)) {
				this.setActivardireccionDatoGeneralUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltarid_usuarioDatoGeneralUsuario(esInicial);
		this.setResaltarid_paisDatoGeneralUsuario(esInicial);
		this.setResaltarid_provinciaDatoGeneralUsuario(esInicial);
		this.setResaltarid_ciudadDatoGeneralUsuario(esInicial);
		this.setResaltarcedulaDatoGeneralUsuario(esInicial);
		this.setResaltarapellidosDatoGeneralUsuario(esInicial);
		this.setResaltarnombresDatoGeneralUsuario(esInicial);
		this.setResaltartelefonoDatoGeneralUsuario(esInicial);
		this.setResaltartelefono_movilDatoGeneralUsuario(esInicial);
		this.setResaltare_mailDatoGeneralUsuario(esInicial);
		this.setResaltarurlDatoGeneralUsuario(esInicial);
		this.setResaltarfecha_nacimientoDatoGeneralUsuario(esInicial);
		this.setResaltardireccionDatoGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.ID)) {
				this.setResaltarid_usuarioDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.CEDULA)) {
				this.setResaltarcedulaDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.APELLIDOS)) {
				this.setResaltarapellidosDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.NOMBRES)) {
				this.setResaltarnombresDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL)) {
				this.setResaltartelefono_movilDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.EMAIL)) {
				this.setResaltare_mailDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.URL)) {
				this.setResaltarurlDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoDatoGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralUsuarioConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionDatoGeneralUsuario(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadDatoGeneralUsuario=true;

	public Boolean getMostrarFK_IdCiudadDatoGeneralUsuario() {
		return this.mostrarFK_IdCiudadDatoGeneralUsuario;
	}

	public void setMostrarFK_IdCiudadDatoGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadDatoGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisDatoGeneralUsuario=true;

	public Boolean getMostrarFK_IdPaisDatoGeneralUsuario() {
		return this.mostrarFK_IdPaisDatoGeneralUsuario;
	}

	public void setMostrarFK_IdPaisDatoGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisDatoGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaDatoGeneralUsuario=true;

	public Boolean getMostrarFK_IdProvinciaDatoGeneralUsuario() {
		return this.mostrarFK_IdProvinciaDatoGeneralUsuario;
	}

	public void setMostrarFK_IdProvinciaDatoGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaDatoGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDatoGeneralUsuario=true;

	public Boolean getMostrarFK_IdUsuarioDatoGeneralUsuario() {
		return this.mostrarFK_IdUsuarioDatoGeneralUsuario;
	}

	public void setMostrarFK_IdUsuarioDatoGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDatoGeneralUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadDatoGeneralUsuario=true;

	public Boolean getActivarFK_IdCiudadDatoGeneralUsuario() {
		return this.activarFK_IdCiudadDatoGeneralUsuario;
	}

	public void setActivarFK_IdCiudadDatoGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadDatoGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisDatoGeneralUsuario=true;

	public Boolean getActivarFK_IdPaisDatoGeneralUsuario() {
		return this.activarFK_IdPaisDatoGeneralUsuario;
	}

	public void setActivarFK_IdPaisDatoGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdPaisDatoGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaDatoGeneralUsuario=true;

	public Boolean getActivarFK_IdProvinciaDatoGeneralUsuario() {
		return this.activarFK_IdProvinciaDatoGeneralUsuario;
	}

	public void setActivarFK_IdProvinciaDatoGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaDatoGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDatoGeneralUsuario=true;

	public Boolean getActivarFK_IdUsuarioDatoGeneralUsuario() {
		return this.activarFK_IdUsuarioDatoGeneralUsuario;
	}

	public void setActivarFK_IdUsuarioDatoGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDatoGeneralUsuario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadDatoGeneralUsuario=null;

	public Border getResaltarFK_IdCiudadDatoGeneralUsuario() {
		return this.resaltarFK_IdCiudadDatoGeneralUsuario;
	}

	public void setResaltarFK_IdCiudadDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdCiudadDatoGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdCiudadDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadDatoGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdPaisDatoGeneralUsuario=null;

	public Border getResaltarFK_IdPaisDatoGeneralUsuario() {
		return this.resaltarFK_IdPaisDatoGeneralUsuario;
	}

	public void setResaltarFK_IdPaisDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdPaisDatoGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdPaisDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisDatoGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaDatoGeneralUsuario=null;

	public Border getResaltarFK_IdProvinciaDatoGeneralUsuario() {
		return this.resaltarFK_IdProvinciaDatoGeneralUsuario;
	}

	public void setResaltarFK_IdProvinciaDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdProvinciaDatoGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaDatoGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDatoGeneralUsuario=null;

	public Border getResaltarFK_IdUsuarioDatoGeneralUsuario() {
		return this.resaltarFK_IdUsuarioDatoGeneralUsuario;
	}

	public void setResaltarFK_IdUsuarioDatoGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDatoGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDatoGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralUsuarioBeanSwingJInternalFrame datogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDatoGeneralUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}