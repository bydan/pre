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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.InformacionLaboralConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionLaboralParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionLaboralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class InformacionLaboralConstantesFunciones extends InformacionLaboralConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="InformacionLaboral";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="InformacionLaboral"+InformacionLaboralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="InformacionLaboralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="InformacionLaboralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=InformacionLaboralConstantesFunciones.SCHEMA+"_"+InformacionLaboralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/InformacionLaboralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=InformacionLaboralConstantesFunciones.SCHEMA+"_"+InformacionLaboralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=InformacionLaboralConstantesFunciones.SCHEMA+"_"+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/InformacionLaboralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=InformacionLaboralConstantesFunciones.SCHEMA+"_"+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionLaboralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionLaboralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionLaboralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=InformacionLaboralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+InformacionLaboralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=InformacionLaboralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+InformacionLaboralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Informacion Laborales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Informacion Laboral";
	public static final String SCLASSWEBTITULO_LOWER="Informacion Laboral";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="InformacionLaboral";
	public static final String OBJECTNAME="informacionlaboral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="informacionlaboral";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select informacionlaboral from "+InformacionLaboralConstantesFunciones.SPERSISTENCENAME+" informacionlaboral";
	public static String QUERYSELECTNATIVE="select "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".id,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".version_row,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idcliente,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorempresa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclienterelacionlaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclientearealaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclientecargolaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".id_pais,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idciudad,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".tiempoa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".tiempom,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".nombreempresa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".direccion,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".nombrereferencia,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefono,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefonocodigoarea,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefonomovil,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".email,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".esactivo from "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME;//+" as "+InformacionLaboralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected InformacionLaboralConstantesFuncionesAdditional informacionlaboralConstantesFuncionesAdditional=null;
	
	public InformacionLaboralConstantesFuncionesAdditional getInformacionLaboralConstantesFuncionesAdditional() {
		return this.informacionlaboralConstantesFuncionesAdditional;
	}
	
	public void setInformacionLaboralConstantesFuncionesAdditional(InformacionLaboralConstantesFuncionesAdditional informacionlaboralConstantesFuncionesAdditional) {
		try {
			this.informacionlaboralConstantesFuncionesAdditional=informacionlaboralConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOEMPRESA= "idvalorempresa";
    public static final String IDTIPORELALABO= "idvalorclienterelacionlaboral";
    public static final String IDTIPOAREALABO= "idvalorclientearealaboral";
    public static final String IDTIPOCARGOLABO= "idvalorclientecargolaboral";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "idciudad";
    public static final String TIEMPOA= "tiempoa";
    public static final String TIEMPOM= "tiempom";
    public static final String NOMBREEMPRESA= "nombreempresa";
    public static final String DIRECCION= "direccion";
    public static final String NOMBREREFERENCIA= "nombrereferencia";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOCODIGOAREA= "telefonocodigoarea";
    public static final String TELEFONOMOVIL= "telefonomovil";
    public static final String EMAIL= "email";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOEMPRESA= "Tipo Empresa";
		public static final String LABEL_IDTIPOEMPRESA_LOWER= "Tipo Empresa";
    	public static final String LABEL_IDTIPORELALABO= "Tipo Rela Labo";
		public static final String LABEL_IDTIPORELALABO_LOWER= "Tipo Rela Labo";
    	public static final String LABEL_IDTIPOAREALABO= "Tipo Area Labo";
		public static final String LABEL_IDTIPOAREALABO_LOWER= "Tipo Area Labo";
    	public static final String LABEL_IDTIPOCARGOLABO= "Tipo Cargo Labo";
		public static final String LABEL_IDTIPOCARGOLABO_LOWER= "Tipo Cargo Labo";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_TIEMPOA= "Tiempo A";
		public static final String LABEL_TIEMPOA_LOWER= "Tiempo A";
    	public static final String LABEL_TIEMPOM= "Tiempo M";
		public static final String LABEL_TIEMPOM_LOWER= "Tiempo M";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_NOMBREREFERENCIA= "Nombre Referencia";
		public static final String LABEL_NOMBREREFERENCIA_LOWER= "Nombre Referencia";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOCODIGOAREA= "Telefono Codigo Area";
		public static final String LABEL_TELEFONOCODIGOAREA_LOWER= "Telefono Codigo Area";
    	public static final String LABEL_TELEFONOMOVIL= "Telefono Movil";
		public static final String LABEL_TELEFONOMOVIL_LOWER= "Telefono Movil";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBREEMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBREEMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBREREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBREREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONOMOVIL=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONOMOVIL=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getInformacionLaboralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDCLIENTE)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDTIPOEMPRESA)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDTIPOEMPRESA;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDTIPORELALABO)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDTIPORELALABO;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDTIPOAREALABO)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDTIPOAREALABO;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDTIPOCARGOLABO;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDPAIS)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.IDCIUDAD)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.TIEMPOA)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_TIEMPOA;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.TIEMPOM)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_TIEMPOM;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.DIRECCION)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.NOMBREREFERENCIA)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_NOMBREREFERENCIA;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.TELEFONO)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_TELEFONOCODIGOAREA;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.TELEFONOMOVIL)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_TELEFONOMOVIL;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.EMAIL)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(InformacionLaboralConstantesFunciones.ESACTIVO)) {sLabelColumna=InformacionLaboralConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(InformacionLaboral informacionlaboral) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!informacionlaboral.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(InformacionLaboral informacionlaboral) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(informacionlaboral.getId(),informacionlaboral.getesactivo());

		return sDescripcion;
	}	
	
	public static String getInformacionLaboralDescripcion(InformacionLaboral informacionlaboral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(informacionlaboral !=null/* && informacionlaboral.getId()!=0*/) {
			if(informacionlaboral.getId()!=null) {
				sDescripcion=informacionlaboral.getId().toString();
			}//informacionlaboralinformacionlaboral.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getInformacionLaboralDescripcionDetallado(InformacionLaboral informacionlaboral) {
		String sDescripcion="";
			
		sDescripcion+=InformacionLaboralConstantesFunciones.ID+"=";
		sDescripcion+=informacionlaboral.getId().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=informacionlaboral.getVersionRow().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=informacionlaboral.getidcliente().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDTIPOEMPRESA+"=";
		sDescripcion+=informacionlaboral.getidvalorempresa().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDTIPORELALABO+"=";
		sDescripcion+=informacionlaboral.getidvalorclienterelacionlaboral().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDTIPOAREALABO+"=";
		sDescripcion+=informacionlaboral.getidvalorclientearealaboral().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO+"=";
		sDescripcion+=informacionlaboral.getidvalorclientecargolaboral().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDPAIS+"=";
		sDescripcion+=informacionlaboral.getid_pais().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=informacionlaboral.getidciudad().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.TIEMPOA+"=";
		sDescripcion+=informacionlaboral.gettiempoa().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.TIEMPOM+"=";
		sDescripcion+=informacionlaboral.gettiempom().toString()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=informacionlaboral.getnombreempresa()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.DIRECCION+"=";
		sDescripcion+=informacionlaboral.getdireccion()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.NOMBREREFERENCIA+"=";
		sDescripcion+=informacionlaboral.getnombrereferencia()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.TELEFONO+"=";
		sDescripcion+=informacionlaboral.gettelefono()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA+"=";
		sDescripcion+=informacionlaboral.gettelefonocodigoarea()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.TELEFONOMOVIL+"=";
		sDescripcion+=informacionlaboral.gettelefonomovil()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.EMAIL+"=";
		sDescripcion+=informacionlaboral.getemail()+",";
		sDescripcion+=InformacionLaboralConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=informacionlaboral.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setInformacionLaboralDescripcion(InformacionLaboral informacionlaboral,String sValor) throws Exception {			
		if(informacionlaboral !=null) {
			//informacionlaboralinformacionlaboral.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoEmpresaDescripcion(TipoEmpresa tipoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoempresa!=null/*&&tipoempresa.getId()>0*/) {
			sDescripcion=TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(tipoempresa);
		}

		return sDescripcion;
	}

	public static String getTipoRelaLaboDescripcion(TipoRelaLabo tiporelalabo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporelalabo!=null/*&&tiporelalabo.getId()>0*/) {
			sDescripcion=TipoRelaLaboConstantesFunciones.getTipoRelaLaboDescripcion(tiporelalabo);
		}

		return sDescripcion;
	}

	public static String getTipoAreaLaboDescripcion(TipoAreaLabo tipoarealabo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoarealabo!=null/*&&tipoarealabo.getId()>0*/) {
			sDescripcion=TipoAreaLaboConstantesFunciones.getTipoAreaLaboDescripcion(tipoarealabo);
		}

		return sDescripcion;
	}

	public static String getTipoCargoLaboDescripcion(TipoCargoLabo tipocargolabo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocargolabo!=null/*&&tipocargolabo.getId()>0*/) {
			sDescripcion=TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(tipocargolabo);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTipoEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Empresa";
		} else if(sNombreIndice.equals("FK_IdValorClienteAreaLaboral")) {
			sNombreIndice="Tipo=  Por Tipo Area Labo";
		} else if(sNombreIndice.equals("FK_IdValorClienteCargoLaboral")) {
			sNombreIndice="Tipo=  Por Tipo Cargo Labo";
		} else if(sNombreIndice.equals("FK_IdValorClienteRelacionLaboral")) {
			sNombreIndice="Tipo=  Por Tipo Rela Labo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long idciudad) {
		String sDetalleIndice=" Parametros->";
		if(idciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+idciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEmpresa(Long idvalorempresa) {
		String sDetalleIndice=" Parametros->";
		if(idvalorempresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Empresa="+idvalorempresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteAreaLaboral(Long idvalorclientearealaboral) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientearealaboral!=null) {sDetalleIndice+=" Codigo Unico De Tipo Area Labo="+idvalorclientearealaboral.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteCargoLaboral(Long idvalorclientecargolaboral) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientecargolaboral!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cargo Labo="+idvalorclientecargolaboral.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteRelacionLaboral(Long idvalorclienterelacionlaboral) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclienterelacionlaboral!=null) {sDetalleIndice+=" Codigo Unico De Tipo Rela Labo="+idvalorclienterelacionlaboral.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosInformacionLaboral(InformacionLaboral informacionlaboral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		informacionlaboral.setnombreempresa(informacionlaboral.getnombreempresa().trim());
		informacionlaboral.setdireccion(informacionlaboral.getdireccion().trim());
		informacionlaboral.setnombrereferencia(informacionlaboral.getnombrereferencia().trim());
		informacionlaboral.settelefono(informacionlaboral.gettelefono().trim());
		informacionlaboral.settelefonocodigoarea(informacionlaboral.gettelefonocodigoarea().trim());
		informacionlaboral.settelefonomovil(informacionlaboral.gettelefonomovil().trim());
		informacionlaboral.setemail(informacionlaboral.getemail().trim());
	}
	
	public static void quitarEspaciosInformacionLaborals(List<InformacionLaboral> informacionlaborals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(InformacionLaboral informacionlaboral: informacionlaborals) {
			informacionlaboral.setnombreempresa(informacionlaboral.getnombreempresa().trim());
			informacionlaboral.setdireccion(informacionlaboral.getdireccion().trim());
			informacionlaboral.setnombrereferencia(informacionlaboral.getnombrereferencia().trim());
			informacionlaboral.settelefono(informacionlaboral.gettelefono().trim());
			informacionlaboral.settelefonocodigoarea(informacionlaboral.gettelefonocodigoarea().trim());
			informacionlaboral.settelefonomovil(informacionlaboral.gettelefonomovil().trim());
			informacionlaboral.setemail(informacionlaboral.getemail().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionLaboral(InformacionLaboral informacionlaboral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && informacionlaboral.getConCambioAuxiliar()) {
			informacionlaboral.setIsDeleted(informacionlaboral.getIsDeletedAuxiliar());	
			informacionlaboral.setIsNew(informacionlaboral.getIsNewAuxiliar());	
			informacionlaboral.setIsChanged(informacionlaboral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			informacionlaboral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			informacionlaboral.setIsDeletedAuxiliar(false);	
			informacionlaboral.setIsNewAuxiliar(false);	
			informacionlaboral.setIsChangedAuxiliar(false);
			
			informacionlaboral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionLaborals(List<InformacionLaboral> informacionlaborals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(InformacionLaboral informacionlaboral : informacionlaborals) {
			if(conAsignarBase && informacionlaboral.getConCambioAuxiliar()) {
				informacionlaboral.setIsDeleted(informacionlaboral.getIsDeletedAuxiliar());	
				informacionlaboral.setIsNew(informacionlaboral.getIsNewAuxiliar());	
				informacionlaboral.setIsChanged(informacionlaboral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				informacionlaboral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				informacionlaboral.setIsDeletedAuxiliar(false);	
				informacionlaboral.setIsNewAuxiliar(false);	
				informacionlaboral.setIsChangedAuxiliar(false);
				
				informacionlaboral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresInformacionLaboral(InformacionLaboral informacionlaboral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			informacionlaboral.settiempoa(0);
			informacionlaboral.settiempom(0);
		}
	}		
	
	public static void InicializarValoresInformacionLaborals(List<InformacionLaboral> informacionlaborals,Boolean conEnteros) throws Exception  {
		
		for(InformacionLaboral informacionlaboral: informacionlaborals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				informacionlaboral.settiempoa(0);
				informacionlaboral.settiempom(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaInformacionLaboral(List<InformacionLaboral> informacionlaborals,InformacionLaboral informacionlaboralAux) throws Exception  {
		InformacionLaboralConstantesFunciones.InicializarValoresInformacionLaboral(informacionlaboralAux,true);
		
		for(InformacionLaboral informacionlaboral: informacionlaborals) {
			if(informacionlaboral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			informacionlaboralAux.settiempoa(informacionlaboralAux.gettiempoa()+informacionlaboral.gettiempoa());			
			informacionlaboralAux.settiempom(informacionlaboralAux.gettiempom()+informacionlaboral.gettiempom());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionLaboral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=InformacionLaboralConstantesFunciones.getArrayColumnasGlobalesInformacionLaboral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionLaboral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoInformacionLaboral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<InformacionLaboral> informacionlaborals,InformacionLaboral informacionlaboral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(InformacionLaboral informacionlaboralAux: informacionlaborals) {
			if(informacionlaboralAux!=null && informacionlaboral!=null) {
				if((informacionlaboralAux.getId()==null && informacionlaboral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(informacionlaboralAux.getId()!=null && informacionlaboral.getId()!=null){
					if(informacionlaboralAux.getId().equals(informacionlaboral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInformacionLaboral(List<InformacionLaboral> informacionlaborals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(InformacionLaboral informacionlaboral: informacionlaborals) {			
			if(informacionlaboral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaInformacionLaboral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_ID, InformacionLaboralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_VERSIONROW, InformacionLaboralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDCLIENTE, InformacionLaboralConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDTIPOEMPRESA, InformacionLaboralConstantesFunciones.IDTIPOEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDTIPORELALABO, InformacionLaboralConstantesFunciones.IDTIPORELALABO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDTIPOAREALABO, InformacionLaboralConstantesFunciones.IDTIPOAREALABO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDTIPOCARGOLABO, InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDPAIS, InformacionLaboralConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_IDCIUDAD, InformacionLaboralConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_TIEMPOA, InformacionLaboralConstantesFunciones.TIEMPOA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_TIEMPOM, InformacionLaboralConstantesFunciones.TIEMPOM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_NOMBREEMPRESA, InformacionLaboralConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_DIRECCION, InformacionLaboralConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_NOMBREREFERENCIA, InformacionLaboralConstantesFunciones.NOMBREREFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_TELEFONO, InformacionLaboralConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_TELEFONOCODIGOAREA, InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_TELEFONOMOVIL, InformacionLaboralConstantesFunciones.TELEFONOMOVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_EMAIL, InformacionLaboralConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionLaboralConstantesFunciones.LABEL_ESACTIVO, InformacionLaboralConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasInformacionLaboral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDTIPOEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDTIPORELALABO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDTIPOAREALABO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.TIEMPOA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.TIEMPOM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.NOMBREREFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.TELEFONOMOVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionLaboralConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionLaboral() throws Exception  {
		return InformacionLaboralConstantesFunciones.getTiposSeleccionarInformacionLaboral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionLaboral(Boolean conFk) throws Exception  {
		return InformacionLaboralConstantesFunciones.getTiposSeleccionarInformacionLaboral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionLaboral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDTIPOEMPRESA);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDTIPOEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDTIPORELALABO);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDTIPORELALABO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDTIPOAREALABO);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDTIPOAREALABO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDTIPOCARGOLABO);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDTIPOCARGOLABO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_TIEMPOA);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_TIEMPOA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_TIEMPOM);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_TIEMPOM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_NOMBREREFERENCIA);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_NOMBREREFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_TELEFONOCODIGOAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_TELEFONOMOVIL);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_TELEFONOMOVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionLaboralConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(InformacionLaboralConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesInformacionLaboral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionLaboral(InformacionLaboral informacionlaboralAux) throws Exception {
		
			informacionlaboralAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacionlaboralAux.getCliente()));
			informacionlaboralAux.settipoempresa_descripcion(TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(informacionlaboralAux.getTipoEmpresa()));
			informacionlaboralAux.settiporelalabo_descripcion(TipoRelaLaboConstantesFunciones.getTipoRelaLaboDescripcion(informacionlaboralAux.getTipoRelaLabo()));
			informacionlaboralAux.settipoarealabo_descripcion(TipoAreaLaboConstantesFunciones.getTipoAreaLaboDescripcion(informacionlaboralAux.getTipoAreaLabo()));
			informacionlaboralAux.settipocargolabo_descripcion(TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(informacionlaboralAux.getTipoCargoLabo()));
			informacionlaboralAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(informacionlaboralAux.getPais()));
			informacionlaboralAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(informacionlaboralAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionLaboral(List<InformacionLaboral> informacionlaboralsTemp) throws Exception {
		for(InformacionLaboral informacionlaboralAux:informacionlaboralsTemp) {
			
			informacionlaboralAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacionlaboralAux.getCliente()));
			informacionlaboralAux.settipoempresa_descripcion(TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(informacionlaboralAux.getTipoEmpresa()));
			informacionlaboralAux.settiporelalabo_descripcion(TipoRelaLaboConstantesFunciones.getTipoRelaLaboDescripcion(informacionlaboralAux.getTipoRelaLabo()));
			informacionlaboralAux.settipoarealabo_descripcion(TipoAreaLaboConstantesFunciones.getTipoAreaLaboDescripcion(informacionlaboralAux.getTipoAreaLabo()));
			informacionlaboralAux.settipocargolabo_descripcion(TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(informacionlaboralAux.getTipoCargoLabo()));
			informacionlaboralAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(informacionlaboralAux.getPais()));
			informacionlaboralAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(informacionlaboralAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionLaboral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoEmpresa.class));
				classes.add(new Classe(TipoRelaLabo.class));
				classes.add(new Classe(TipoAreaLabo.class));
				classes.add(new Classe(TipoCargoLabo.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEmpresa.class)) {
						classes.add(new Classe(TipoEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRelaLabo.class)) {
						classes.add(new Classe(TipoRelaLabo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoAreaLabo.class)) {
						classes.add(new Classe(TipoAreaLabo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCargoLabo.class)) {
						classes.add(new Classe(TipoCargoLabo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfInformacionLaboral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpresa.class)); continue;
					}

					if(TipoRelaLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRelaLabo.class)); continue;
					}

					if(TipoAreaLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAreaLabo.class)); continue;
					}

					if(TipoCargoLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargoLabo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpresa.class)); continue;
					}

					if(TipoRelaLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRelaLabo.class)); continue;
					}

					if(TipoAreaLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAreaLabo.class)); continue;
					}

					if(TipoCargoLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargoLabo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionLaboral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionLaboralConstantesFunciones.getClassesRelationshipsOfInformacionLaboral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionLaboral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionLaboral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionLaboralConstantesFunciones.getClassesRelationshipsFromStringsOfInformacionLaboral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionLaboral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(InformacionLaboral informacionlaboral,List<InformacionLaboral> informacionlaborals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			InformacionLaboral informacionlaboralEncontrado=null;
			
			for(InformacionLaboral informacionlaboralLocal:informacionlaborals) {
				if(informacionlaboralLocal.getId().equals(informacionlaboral.getId())) {
					informacionlaboralEncontrado=informacionlaboralLocal;
					
					informacionlaboralLocal.setIsChanged(informacionlaboral.getIsChanged());
					informacionlaboralLocal.setIsNew(informacionlaboral.getIsNew());
					informacionlaboralLocal.setIsDeleted(informacionlaboral.getIsDeleted());
					
					informacionlaboralLocal.setGeneralEntityOriginal(informacionlaboral.getGeneralEntityOriginal());
					
					informacionlaboralLocal.setId(informacionlaboral.getId());	
					informacionlaboralLocal.setVersionRow(informacionlaboral.getVersionRow());	
					informacionlaboralLocal.setidcliente(informacionlaboral.getidcliente());	
					informacionlaboralLocal.setidvalorempresa(informacionlaboral.getidvalorempresa());	
					informacionlaboralLocal.setidvalorclienterelacionlaboral(informacionlaboral.getidvalorclienterelacionlaboral());	
					informacionlaboralLocal.setidvalorclientearealaboral(informacionlaboral.getidvalorclientearealaboral());	
					informacionlaboralLocal.setidvalorclientecargolaboral(informacionlaboral.getidvalorclientecargolaboral());	
					informacionlaboralLocal.setid_pais(informacionlaboral.getid_pais());	
					informacionlaboralLocal.setidciudad(informacionlaboral.getidciudad());	
					informacionlaboralLocal.settiempoa(informacionlaboral.gettiempoa());	
					informacionlaboralLocal.settiempom(informacionlaboral.gettiempom());	
					informacionlaboralLocal.setnombreempresa(informacionlaboral.getnombreempresa());	
					informacionlaboralLocal.setdireccion(informacionlaboral.getdireccion());	
					informacionlaboralLocal.setnombrereferencia(informacionlaboral.getnombrereferencia());	
					informacionlaboralLocal.settelefono(informacionlaboral.gettelefono());	
					informacionlaboralLocal.settelefonocodigoarea(informacionlaboral.gettelefonocodigoarea());	
					informacionlaboralLocal.settelefonomovil(informacionlaboral.gettelefonomovil());	
					informacionlaboralLocal.setemail(informacionlaboral.getemail());	
					informacionlaboralLocal.setesactivo(informacionlaboral.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!informacionlaboral.getIsDeleted()) {
				if(!existe) {
					informacionlaborals.add(informacionlaboral);
				}
			} else {
				if(informacionlaboralEncontrado!=null && permiteQuitar)  {
					informacionlaborals.remove(informacionlaboralEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(InformacionLaboral informacionlaboral,List<InformacionLaboral> informacionlaborals) throws Exception {
		try	{			
			for(InformacionLaboral informacionlaboralLocal:informacionlaborals) {
				if(informacionlaboralLocal.getId().equals(informacionlaboral.getId())) {
					informacionlaboralLocal.setIsSelected(informacionlaboral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesInformacionLaboral(List<InformacionLaboral> informacionlaboralsAux) throws Exception {
		//this.informacionlaboralsAux=informacionlaboralsAux;
		
		for(InformacionLaboral informacionlaboralAux:informacionlaboralsAux) {
			if(informacionlaboralAux.getIsChanged()) {
				informacionlaboralAux.setIsChanged(false);
			}		
			
			if(informacionlaboralAux.getIsNew()) {
				informacionlaboralAux.setIsNew(false);
			}	
			
			if(informacionlaboralAux.getIsDeleted()) {
				informacionlaboralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesInformacionLaboral(InformacionLaboral informacionlaboralAux) throws Exception {
		//this.informacionlaboralAux=informacionlaboralAux;
		
			if(informacionlaboralAux.getIsChanged()) {
				informacionlaboralAux.setIsChanged(false);
			}		
			
			if(informacionlaboralAux.getIsNew()) {
				informacionlaboralAux.setIsNew(false);
			}	
			
			if(informacionlaboralAux.getIsDeleted()) {
				informacionlaboralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(InformacionLaboral informacionlaboralAsignar,InformacionLaboral informacionlaboral) throws Exception {
		informacionlaboralAsignar.setId(informacionlaboral.getId());	
		informacionlaboralAsignar.setVersionRow(informacionlaboral.getVersionRow());	
		informacionlaboralAsignar.setidcliente(informacionlaboral.getidcliente());
		informacionlaboralAsignar.setcliente_descripcion(informacionlaboral.getcliente_descripcion());	
		informacionlaboralAsignar.setidvalorempresa(informacionlaboral.getidvalorempresa());
		informacionlaboralAsignar.settipoempresa_descripcion(informacionlaboral.gettipoempresa_descripcion());	
		informacionlaboralAsignar.setidvalorclienterelacionlaboral(informacionlaboral.getidvalorclienterelacionlaboral());
		informacionlaboralAsignar.settiporelalabo_descripcion(informacionlaboral.gettiporelalabo_descripcion());	
		informacionlaboralAsignar.setidvalorclientearealaboral(informacionlaboral.getidvalorclientearealaboral());
		informacionlaboralAsignar.settipoarealabo_descripcion(informacionlaboral.gettipoarealabo_descripcion());	
		informacionlaboralAsignar.setidvalorclientecargolaboral(informacionlaboral.getidvalorclientecargolaboral());
		informacionlaboralAsignar.settipocargolabo_descripcion(informacionlaboral.gettipocargolabo_descripcion());	
		informacionlaboralAsignar.setid_pais(informacionlaboral.getid_pais());
		informacionlaboralAsignar.setpais_descripcion(informacionlaboral.getpais_descripcion());	
		informacionlaboralAsignar.setidciudad(informacionlaboral.getidciudad());
		informacionlaboralAsignar.setciudad_descripcion(informacionlaboral.getciudad_descripcion());	
		informacionlaboralAsignar.settiempoa(informacionlaboral.gettiempoa());	
		informacionlaboralAsignar.settiempom(informacionlaboral.gettiempom());	
		informacionlaboralAsignar.setnombreempresa(informacionlaboral.getnombreempresa());	
		informacionlaboralAsignar.setdireccion(informacionlaboral.getdireccion());	
		informacionlaboralAsignar.setnombrereferencia(informacionlaboral.getnombrereferencia());	
		informacionlaboralAsignar.settelefono(informacionlaboral.gettelefono());	
		informacionlaboralAsignar.settelefonocodigoarea(informacionlaboral.gettelefonocodigoarea());	
		informacionlaboralAsignar.settelefonomovil(informacionlaboral.gettelefonomovil());	
		informacionlaboralAsignar.setemail(informacionlaboral.getemail());	
		informacionlaboralAsignar.setesactivo(informacionlaboral.getesactivo());	
	}
	
	public static void inicializarInformacionLaboral(InformacionLaboral informacionlaboral) throws Exception {
		try {
				informacionlaboral.setId(0L);	
					
				informacionlaboral.setidcliente(-1L);	
				informacionlaboral.setidvalorempresa(-1L);	
				informacionlaboral.setidvalorclienterelacionlaboral(-1L);	
				informacionlaboral.setidvalorclientearealaboral(-1L);	
				informacionlaboral.setidvalorclientecargolaboral(-1L);	
				informacionlaboral.setid_pais(-1L);	
				informacionlaboral.setidciudad(-1L);	
				informacionlaboral.settiempoa(0);	
				informacionlaboral.settiempom(0);	
				informacionlaboral.setnombreempresa("");	
				informacionlaboral.setdireccion("");	
				informacionlaboral.setnombrereferencia("");	
				informacionlaboral.settelefono("");	
				informacionlaboral.settelefonocodigoarea("");	
				informacionlaboral.settelefonomovil("");	
				informacionlaboral.setemail("");	
				informacionlaboral.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderInformacionLaboral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDTIPOEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDTIPORELALABO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDTIPOAREALABO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDTIPOCARGOLABO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_TIEMPOA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_TIEMPOM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_NOMBREREFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_TELEFONOMOVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionLaboralConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataInformacionLaboral(String sTipo,Row row,Workbook workbook,InformacionLaboral informacionlaboral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettipoempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettiporelalabo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettipoarealabo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettipocargolabo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettiempoa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettiempom());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getnombreempresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getnombrereferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettelefonocodigoarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.gettelefonomovil());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionlaboral.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(informacionlaboral.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryInformacionLaboral=Constantes.SFINALQUERY;
	
	public String getsFinalQueryInformacionLaboral() {
		return this.sFinalQueryInformacionLaboral;
	}
	
	public void setsFinalQueryInformacionLaboral(String sFinalQueryInformacionLaboral) {
		this.sFinalQueryInformacionLaboral= sFinalQueryInformacionLaboral;
	}
	
	public Border resaltarSeleccionarInformacionLaboral=null;
	
	public Border setResaltarSeleccionarInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarInformacionLaboral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarInformacionLaboral() {
		return this.resaltarSeleccionarInformacionLaboral;
	}
	
	public void setResaltarSeleccionarInformacionLaboral(Border borderResaltarSeleccionarInformacionLaboral) {
		this.resaltarSeleccionarInformacionLaboral= borderResaltarSeleccionarInformacionLaboral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridInformacionLaboral=null;
	public Boolean mostraridInformacionLaboral=true;
	public Boolean activaridInformacionLaboral=true;

	public Border resaltaridclienteInformacionLaboral=null;
	public Boolean mostraridclienteInformacionLaboral=true;
	public Boolean activaridclienteInformacionLaboral=true;
	public Boolean cargaridclienteInformacionLaboral=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteInformacionLaboral=false;//ConEventDepend=true

	public Border resaltaridvalorempresaInformacionLaboral=null;
	public Boolean mostraridvalorempresaInformacionLaboral=true;
	public Boolean activaridvalorempresaInformacionLaboral=true;
	public Boolean cargaridvalorempresaInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorempresaInformacionLaboral=false;//ConEventDepend=true

	public Border resaltaridvalorclienterelacionlaboralInformacionLaboral=null;
	public Boolean mostraridvalorclienterelacionlaboralInformacionLaboral=true;
	public Boolean activaridvalorclienterelacionlaboralInformacionLaboral=true;
	public Boolean cargaridvalorclienterelacionlaboralInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclienterelacionlaboralInformacionLaboral=false;//ConEventDepend=true

	public Border resaltaridvalorclientearealaboralInformacionLaboral=null;
	public Boolean mostraridvalorclientearealaboralInformacionLaboral=true;
	public Boolean activaridvalorclientearealaboralInformacionLaboral=true;
	public Boolean cargaridvalorclientearealaboralInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientearealaboralInformacionLaboral=false;//ConEventDepend=true

	public Border resaltaridvalorclientecargolaboralInformacionLaboral=null;
	public Boolean mostraridvalorclientecargolaboralInformacionLaboral=true;
	public Boolean activaridvalorclientecargolaboralInformacionLaboral=true;
	public Boolean cargaridvalorclientecargolaboralInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientecargolaboralInformacionLaboral=false;//ConEventDepend=true

	public Border resaltarid_paisInformacionLaboral=null;
	public Boolean mostrarid_paisInformacionLaboral=true;
	public Boolean activarid_paisInformacionLaboral=true;
	public Boolean cargarid_paisInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisInformacionLaboral=false;//ConEventDepend=true

	public Border resaltaridciudadInformacionLaboral=null;
	public Boolean mostraridciudadInformacionLaboral=true;
	public Boolean activaridciudadInformacionLaboral=true;
	public Boolean cargaridciudadInformacionLaboral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidciudadInformacionLaboral=true;//ConEventDepend=true

	public Border resaltartiempoaInformacionLaboral=null;
	public Boolean mostrartiempoaInformacionLaboral=true;
	public Boolean activartiempoaInformacionLaboral=true;

	public Border resaltartiempomInformacionLaboral=null;
	public Boolean mostrartiempomInformacionLaboral=true;
	public Boolean activartiempomInformacionLaboral=true;

	public Border resaltarnombreempresaInformacionLaboral=null;
	public Boolean mostrarnombreempresaInformacionLaboral=true;
	public Boolean activarnombreempresaInformacionLaboral=true;

	public Border resaltardireccionInformacionLaboral=null;
	public Boolean mostrardireccionInformacionLaboral=true;
	public Boolean activardireccionInformacionLaboral=true;

	public Border resaltarnombrereferenciaInformacionLaboral=null;
	public Boolean mostrarnombrereferenciaInformacionLaboral=true;
	public Boolean activarnombrereferenciaInformacionLaboral=true;

	public Border resaltartelefonoInformacionLaboral=null;
	public Boolean mostrartelefonoInformacionLaboral=true;
	public Boolean activartelefonoInformacionLaboral=true;

	public Border resaltartelefonocodigoareaInformacionLaboral=null;
	public Boolean mostrartelefonocodigoareaInformacionLaboral=true;
	public Boolean activartelefonocodigoareaInformacionLaboral=true;

	public Border resaltartelefonomovilInformacionLaboral=null;
	public Boolean mostrartelefonomovilInformacionLaboral=true;
	public Boolean activartelefonomovilInformacionLaboral=true;

	public Border resaltaremailInformacionLaboral=null;
	public Boolean mostraremailInformacionLaboral=true;
	public Boolean activaremailInformacionLaboral=true;

	public Border resaltaresactivoInformacionLaboral=null;
	public Boolean mostraresactivoInformacionLaboral=true;
	public Boolean activaresactivoInformacionLaboral=true;

	
	

	public Border setResaltaridInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridInformacionLaboral() {
		return this.resaltaridInformacionLaboral;
	}

	public void setResaltaridInformacionLaboral(Border borderResaltar) {
		this.resaltaridInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridInformacionLaboral() {
		return this.mostraridInformacionLaboral;
	}

	public void setMostraridInformacionLaboral(Boolean mostraridInformacionLaboral) {
		this.mostraridInformacionLaboral= mostraridInformacionLaboral;
	}

	public Boolean getActivaridInformacionLaboral() {
		return this.activaridInformacionLaboral;
	}

	public void setActivaridInformacionLaboral(Boolean activaridInformacionLaboral) {
		this.activaridInformacionLaboral= activaridInformacionLaboral;
	}

	public Border setResaltaridclienteInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridclienteInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteInformacionLaboral() {
		return this.resaltaridclienteInformacionLaboral;
	}

	public void setResaltaridclienteInformacionLaboral(Border borderResaltar) {
		this.resaltaridclienteInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridclienteInformacionLaboral() {
		return this.mostraridclienteInformacionLaboral;
	}

	public void setMostraridclienteInformacionLaboral(Boolean mostraridclienteInformacionLaboral) {
		this.mostraridclienteInformacionLaboral= mostraridclienteInformacionLaboral;
	}

	public Boolean getActivaridclienteInformacionLaboral() {
		return this.activaridclienteInformacionLaboral;
	}

	public void setActivaridclienteInformacionLaboral(Boolean activaridclienteInformacionLaboral) {
		this.activaridclienteInformacionLaboral= activaridclienteInformacionLaboral;
	}

	public Boolean getCargaridclienteInformacionLaboral() {
		return this.cargaridclienteInformacionLaboral;
	}

	public void setCargaridclienteInformacionLaboral(Boolean cargaridclienteInformacionLaboral) {
		this.cargaridclienteInformacionLaboral= cargaridclienteInformacionLaboral;
	}

	public Border setResaltaridvalorempresaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridvalorempresaInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorempresaInformacionLaboral() {
		return this.resaltaridvalorempresaInformacionLaboral;
	}

	public void setResaltaridvalorempresaInformacionLaboral(Border borderResaltar) {
		this.resaltaridvalorempresaInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridvalorempresaInformacionLaboral() {
		return this.mostraridvalorempresaInformacionLaboral;
	}

	public void setMostraridvalorempresaInformacionLaboral(Boolean mostraridvalorempresaInformacionLaboral) {
		this.mostraridvalorempresaInformacionLaboral= mostraridvalorempresaInformacionLaboral;
	}

	public Boolean getActivaridvalorempresaInformacionLaboral() {
		return this.activaridvalorempresaInformacionLaboral;
	}

	public void setActivaridvalorempresaInformacionLaboral(Boolean activaridvalorempresaInformacionLaboral) {
		this.activaridvalorempresaInformacionLaboral= activaridvalorempresaInformacionLaboral;
	}

	public Boolean getCargaridvalorempresaInformacionLaboral() {
		return this.cargaridvalorempresaInformacionLaboral;
	}

	public void setCargaridvalorempresaInformacionLaboral(Boolean cargaridvalorempresaInformacionLaboral) {
		this.cargaridvalorempresaInformacionLaboral= cargaridvalorempresaInformacionLaboral;
	}

	public Border setResaltaridvalorclienterelacionlaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridvalorclienterelacionlaboralInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclienterelacionlaboralInformacionLaboral() {
		return this.resaltaridvalorclienterelacionlaboralInformacionLaboral;
	}

	public void setResaltaridvalorclienterelacionlaboralInformacionLaboral(Border borderResaltar) {
		this.resaltaridvalorclienterelacionlaboralInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridvalorclienterelacionlaboralInformacionLaboral() {
		return this.mostraridvalorclienterelacionlaboralInformacionLaboral;
	}

	public void setMostraridvalorclienterelacionlaboralInformacionLaboral(Boolean mostraridvalorclienterelacionlaboralInformacionLaboral) {
		this.mostraridvalorclienterelacionlaboralInformacionLaboral= mostraridvalorclienterelacionlaboralInformacionLaboral;
	}

	public Boolean getActivaridvalorclienterelacionlaboralInformacionLaboral() {
		return this.activaridvalorclienterelacionlaboralInformacionLaboral;
	}

	public void setActivaridvalorclienterelacionlaboralInformacionLaboral(Boolean activaridvalorclienterelacionlaboralInformacionLaboral) {
		this.activaridvalorclienterelacionlaboralInformacionLaboral= activaridvalorclienterelacionlaboralInformacionLaboral;
	}

	public Boolean getCargaridvalorclienterelacionlaboralInformacionLaboral() {
		return this.cargaridvalorclienterelacionlaboralInformacionLaboral;
	}

	public void setCargaridvalorclienterelacionlaboralInformacionLaboral(Boolean cargaridvalorclienterelacionlaboralInformacionLaboral) {
		this.cargaridvalorclienterelacionlaboralInformacionLaboral= cargaridvalorclienterelacionlaboralInformacionLaboral;
	}

	public Border setResaltaridvalorclientearealaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridvalorclientearealaboralInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientearealaboralInformacionLaboral() {
		return this.resaltaridvalorclientearealaboralInformacionLaboral;
	}

	public void setResaltaridvalorclientearealaboralInformacionLaboral(Border borderResaltar) {
		this.resaltaridvalorclientearealaboralInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridvalorclientearealaboralInformacionLaboral() {
		return this.mostraridvalorclientearealaboralInformacionLaboral;
	}

	public void setMostraridvalorclientearealaboralInformacionLaboral(Boolean mostraridvalorclientearealaboralInformacionLaboral) {
		this.mostraridvalorclientearealaboralInformacionLaboral= mostraridvalorclientearealaboralInformacionLaboral;
	}

	public Boolean getActivaridvalorclientearealaboralInformacionLaboral() {
		return this.activaridvalorclientearealaboralInformacionLaboral;
	}

	public void setActivaridvalorclientearealaboralInformacionLaboral(Boolean activaridvalorclientearealaboralInformacionLaboral) {
		this.activaridvalorclientearealaboralInformacionLaboral= activaridvalorclientearealaboralInformacionLaboral;
	}

	public Boolean getCargaridvalorclientearealaboralInformacionLaboral() {
		return this.cargaridvalorclientearealaboralInformacionLaboral;
	}

	public void setCargaridvalorclientearealaboralInformacionLaboral(Boolean cargaridvalorclientearealaboralInformacionLaboral) {
		this.cargaridvalorclientearealaboralInformacionLaboral= cargaridvalorclientearealaboralInformacionLaboral;
	}

	public Border setResaltaridvalorclientecargolaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridvalorclientecargolaboralInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientecargolaboralInformacionLaboral() {
		return this.resaltaridvalorclientecargolaboralInformacionLaboral;
	}

	public void setResaltaridvalorclientecargolaboralInformacionLaboral(Border borderResaltar) {
		this.resaltaridvalorclientecargolaboralInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridvalorclientecargolaboralInformacionLaboral() {
		return this.mostraridvalorclientecargolaboralInformacionLaboral;
	}

	public void setMostraridvalorclientecargolaboralInformacionLaboral(Boolean mostraridvalorclientecargolaboralInformacionLaboral) {
		this.mostraridvalorclientecargolaboralInformacionLaboral= mostraridvalorclientecargolaboralInformacionLaboral;
	}

	public Boolean getActivaridvalorclientecargolaboralInformacionLaboral() {
		return this.activaridvalorclientecargolaboralInformacionLaboral;
	}

	public void setActivaridvalorclientecargolaboralInformacionLaboral(Boolean activaridvalorclientecargolaboralInformacionLaboral) {
		this.activaridvalorclientecargolaboralInformacionLaboral= activaridvalorclientecargolaboralInformacionLaboral;
	}

	public Boolean getCargaridvalorclientecargolaboralInformacionLaboral() {
		return this.cargaridvalorclientecargolaboralInformacionLaboral;
	}

	public void setCargaridvalorclientecargolaboralInformacionLaboral(Boolean cargaridvalorclientecargolaboralInformacionLaboral) {
		this.cargaridvalorclientecargolaboralInformacionLaboral= cargaridvalorclientecargolaboralInformacionLaboral;
	}

	public Border setResaltarid_paisInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltarid_paisInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisInformacionLaboral() {
		return this.resaltarid_paisInformacionLaboral;
	}

	public void setResaltarid_paisInformacionLaboral(Border borderResaltar) {
		this.resaltarid_paisInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrarid_paisInformacionLaboral() {
		return this.mostrarid_paisInformacionLaboral;
	}

	public void setMostrarid_paisInformacionLaboral(Boolean mostrarid_paisInformacionLaboral) {
		this.mostrarid_paisInformacionLaboral= mostrarid_paisInformacionLaboral;
	}

	public Boolean getActivarid_paisInformacionLaboral() {
		return this.activarid_paisInformacionLaboral;
	}

	public void setActivarid_paisInformacionLaboral(Boolean activarid_paisInformacionLaboral) {
		this.activarid_paisInformacionLaboral= activarid_paisInformacionLaboral;
	}

	public Boolean getCargarid_paisInformacionLaboral() {
		return this.cargarid_paisInformacionLaboral;
	}

	public void setCargarid_paisInformacionLaboral(Boolean cargarid_paisInformacionLaboral) {
		this.cargarid_paisInformacionLaboral= cargarid_paisInformacionLaboral;
	}

	public Border setResaltaridciudadInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaridciudadInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridciudadInformacionLaboral() {
		return this.resaltaridciudadInformacionLaboral;
	}

	public void setResaltaridciudadInformacionLaboral(Border borderResaltar) {
		this.resaltaridciudadInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraridciudadInformacionLaboral() {
		return this.mostraridciudadInformacionLaboral;
	}

	public void setMostraridciudadInformacionLaboral(Boolean mostraridciudadInformacionLaboral) {
		this.mostraridciudadInformacionLaboral= mostraridciudadInformacionLaboral;
	}

	public Boolean getActivaridciudadInformacionLaboral() {
		return this.activaridciudadInformacionLaboral;
	}

	public void setActivaridciudadInformacionLaboral(Boolean activaridciudadInformacionLaboral) {
		this.activaridciudadInformacionLaboral= activaridciudadInformacionLaboral;
	}

	public Boolean getCargaridciudadInformacionLaboral() {
		return this.cargaridciudadInformacionLaboral;
	}

	public void setCargaridciudadInformacionLaboral(Boolean cargaridciudadInformacionLaboral) {
		this.cargaridciudadInformacionLaboral= cargaridciudadInformacionLaboral;
	}

	public Border setResaltartiempoaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltartiempoaInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiempoaInformacionLaboral() {
		return this.resaltartiempoaInformacionLaboral;
	}

	public void setResaltartiempoaInformacionLaboral(Border borderResaltar) {
		this.resaltartiempoaInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrartiempoaInformacionLaboral() {
		return this.mostrartiempoaInformacionLaboral;
	}

	public void setMostrartiempoaInformacionLaboral(Boolean mostrartiempoaInformacionLaboral) {
		this.mostrartiempoaInformacionLaboral= mostrartiempoaInformacionLaboral;
	}

	public Boolean getActivartiempoaInformacionLaboral() {
		return this.activartiempoaInformacionLaboral;
	}

	public void setActivartiempoaInformacionLaboral(Boolean activartiempoaInformacionLaboral) {
		this.activartiempoaInformacionLaboral= activartiempoaInformacionLaboral;
	}

	public Border setResaltartiempomInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltartiempomInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiempomInformacionLaboral() {
		return this.resaltartiempomInformacionLaboral;
	}

	public void setResaltartiempomInformacionLaboral(Border borderResaltar) {
		this.resaltartiempomInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrartiempomInformacionLaboral() {
		return this.mostrartiempomInformacionLaboral;
	}

	public void setMostrartiempomInformacionLaboral(Boolean mostrartiempomInformacionLaboral) {
		this.mostrartiempomInformacionLaboral= mostrartiempomInformacionLaboral;
	}

	public Boolean getActivartiempomInformacionLaboral() {
		return this.activartiempomInformacionLaboral;
	}

	public void setActivartiempomInformacionLaboral(Boolean activartiempomInformacionLaboral) {
		this.activartiempomInformacionLaboral= activartiempomInformacionLaboral;
	}

	public Border setResaltarnombreempresaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltarnombreempresaInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreempresaInformacionLaboral() {
		return this.resaltarnombreempresaInformacionLaboral;
	}

	public void setResaltarnombreempresaInformacionLaboral(Border borderResaltar) {
		this.resaltarnombreempresaInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrarnombreempresaInformacionLaboral() {
		return this.mostrarnombreempresaInformacionLaboral;
	}

	public void setMostrarnombreempresaInformacionLaboral(Boolean mostrarnombreempresaInformacionLaboral) {
		this.mostrarnombreempresaInformacionLaboral= mostrarnombreempresaInformacionLaboral;
	}

	public Boolean getActivarnombreempresaInformacionLaboral() {
		return this.activarnombreempresaInformacionLaboral;
	}

	public void setActivarnombreempresaInformacionLaboral(Boolean activarnombreempresaInformacionLaboral) {
		this.activarnombreempresaInformacionLaboral= activarnombreempresaInformacionLaboral;
	}

	public Border setResaltardireccionInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltardireccionInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionInformacionLaboral() {
		return this.resaltardireccionInformacionLaboral;
	}

	public void setResaltardireccionInformacionLaboral(Border borderResaltar) {
		this.resaltardireccionInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrardireccionInformacionLaboral() {
		return this.mostrardireccionInformacionLaboral;
	}

	public void setMostrardireccionInformacionLaboral(Boolean mostrardireccionInformacionLaboral) {
		this.mostrardireccionInformacionLaboral= mostrardireccionInformacionLaboral;
	}

	public Boolean getActivardireccionInformacionLaboral() {
		return this.activardireccionInformacionLaboral;
	}

	public void setActivardireccionInformacionLaboral(Boolean activardireccionInformacionLaboral) {
		this.activardireccionInformacionLaboral= activardireccionInformacionLaboral;
	}

	public Border setResaltarnombrereferenciaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltarnombrereferenciaInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrereferenciaInformacionLaboral() {
		return this.resaltarnombrereferenciaInformacionLaboral;
	}

	public void setResaltarnombrereferenciaInformacionLaboral(Border borderResaltar) {
		this.resaltarnombrereferenciaInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrarnombrereferenciaInformacionLaboral() {
		return this.mostrarnombrereferenciaInformacionLaboral;
	}

	public void setMostrarnombrereferenciaInformacionLaboral(Boolean mostrarnombrereferenciaInformacionLaboral) {
		this.mostrarnombrereferenciaInformacionLaboral= mostrarnombrereferenciaInformacionLaboral;
	}

	public Boolean getActivarnombrereferenciaInformacionLaboral() {
		return this.activarnombrereferenciaInformacionLaboral;
	}

	public void setActivarnombrereferenciaInformacionLaboral(Boolean activarnombrereferenciaInformacionLaboral) {
		this.activarnombrereferenciaInformacionLaboral= activarnombrereferenciaInformacionLaboral;
	}

	public Border setResaltartelefonoInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltartelefonoInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoInformacionLaboral() {
		return this.resaltartelefonoInformacionLaboral;
	}

	public void setResaltartelefonoInformacionLaboral(Border borderResaltar) {
		this.resaltartelefonoInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrartelefonoInformacionLaboral() {
		return this.mostrartelefonoInformacionLaboral;
	}

	public void setMostrartelefonoInformacionLaboral(Boolean mostrartelefonoInformacionLaboral) {
		this.mostrartelefonoInformacionLaboral= mostrartelefonoInformacionLaboral;
	}

	public Boolean getActivartelefonoInformacionLaboral() {
		return this.activartelefonoInformacionLaboral;
	}

	public void setActivartelefonoInformacionLaboral(Boolean activartelefonoInformacionLaboral) {
		this.activartelefonoInformacionLaboral= activartelefonoInformacionLaboral;
	}

	public Border setResaltartelefonocodigoareaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltartelefonocodigoareaInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonocodigoareaInformacionLaboral() {
		return this.resaltartelefonocodigoareaInformacionLaboral;
	}

	public void setResaltartelefonocodigoareaInformacionLaboral(Border borderResaltar) {
		this.resaltartelefonocodigoareaInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrartelefonocodigoareaInformacionLaboral() {
		return this.mostrartelefonocodigoareaInformacionLaboral;
	}

	public void setMostrartelefonocodigoareaInformacionLaboral(Boolean mostrartelefonocodigoareaInformacionLaboral) {
		this.mostrartelefonocodigoareaInformacionLaboral= mostrartelefonocodigoareaInformacionLaboral;
	}

	public Boolean getActivartelefonocodigoareaInformacionLaboral() {
		return this.activartelefonocodigoareaInformacionLaboral;
	}

	public void setActivartelefonocodigoareaInformacionLaboral(Boolean activartelefonocodigoareaInformacionLaboral) {
		this.activartelefonocodigoareaInformacionLaboral= activartelefonocodigoareaInformacionLaboral;
	}

	public Border setResaltartelefonomovilInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltartelefonomovilInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonomovilInformacionLaboral() {
		return this.resaltartelefonomovilInformacionLaboral;
	}

	public void setResaltartelefonomovilInformacionLaboral(Border borderResaltar) {
		this.resaltartelefonomovilInformacionLaboral= borderResaltar;
	}

	public Boolean getMostrartelefonomovilInformacionLaboral() {
		return this.mostrartelefonomovilInformacionLaboral;
	}

	public void setMostrartelefonomovilInformacionLaboral(Boolean mostrartelefonomovilInformacionLaboral) {
		this.mostrartelefonomovilInformacionLaboral= mostrartelefonomovilInformacionLaboral;
	}

	public Boolean getActivartelefonomovilInformacionLaboral() {
		return this.activartelefonomovilInformacionLaboral;
	}

	public void setActivartelefonomovilInformacionLaboral(Boolean activartelefonomovilInformacionLaboral) {
		this.activartelefonomovilInformacionLaboral= activartelefonomovilInformacionLaboral;
	}

	public Border setResaltaremailInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaremailInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailInformacionLaboral() {
		return this.resaltaremailInformacionLaboral;
	}

	public void setResaltaremailInformacionLaboral(Border borderResaltar) {
		this.resaltaremailInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraremailInformacionLaboral() {
		return this.mostraremailInformacionLaboral;
	}

	public void setMostraremailInformacionLaboral(Boolean mostraremailInformacionLaboral) {
		this.mostraremailInformacionLaboral= mostraremailInformacionLaboral;
	}

	public Boolean getActivaremailInformacionLaboral() {
		return this.activaremailInformacionLaboral;
	}

	public void setActivaremailInformacionLaboral(Boolean activaremailInformacionLaboral) {
		this.activaremailInformacionLaboral= activaremailInformacionLaboral;
	}

	public Border setResaltaresactivoInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionlaboralBeanSwingJInternalFrame.jTtoolBarInformacionLaboral.setBorder(borderResaltar);
		
		this.resaltaresactivoInformacionLaboral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoInformacionLaboral() {
		return this.resaltaresactivoInformacionLaboral;
	}

	public void setResaltaresactivoInformacionLaboral(Border borderResaltar) {
		this.resaltaresactivoInformacionLaboral= borderResaltar;
	}

	public Boolean getMostraresactivoInformacionLaboral() {
		return this.mostraresactivoInformacionLaboral;
	}

	public void setMostraresactivoInformacionLaboral(Boolean mostraresactivoInformacionLaboral) {
		this.mostraresactivoInformacionLaboral= mostraresactivoInformacionLaboral;
	}

	public Boolean getActivaresactivoInformacionLaboral() {
		return this.activaresactivoInformacionLaboral;
	}

	public void setActivaresactivoInformacionLaboral(Boolean activaresactivoInformacionLaboral) {
		this.activaresactivoInformacionLaboral= activaresactivoInformacionLaboral;
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
		
		
		this.setMostraridInformacionLaboral(esInicial);
		this.setMostraridclienteInformacionLaboral(esInicial);
		this.setMostraridvalorempresaInformacionLaboral(esInicial);
		this.setMostraridvalorclienterelacionlaboralInformacionLaboral(esInicial);
		this.setMostraridvalorclientearealaboralInformacionLaboral(esInicial);
		this.setMostraridvalorclientecargolaboralInformacionLaboral(esInicial);
		this.setMostrarid_paisInformacionLaboral(esInicial);
		this.setMostraridciudadInformacionLaboral(esInicial);
		this.setMostrartiempoaInformacionLaboral(esInicial);
		this.setMostrartiempomInformacionLaboral(esInicial);
		this.setMostrarnombreempresaInformacionLaboral(esInicial);
		this.setMostrardireccionInformacionLaboral(esInicial);
		this.setMostrarnombrereferenciaInformacionLaboral(esInicial);
		this.setMostrartelefonoInformacionLaboral(esInicial);
		this.setMostrartelefonocodigoareaInformacionLaboral(esInicial);
		this.setMostrartelefonomovilInformacionLaboral(esInicial);
		this.setMostraremailInformacionLaboral(esInicial);
		this.setMostraresactivoInformacionLaboral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ID)) {
				this.setMostraridInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOEMPRESA)) {
				this.setMostraridvalorempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPORELALABO)) {
				this.setMostraridvalorclienterelacionlaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOAREALABO)) {
				this.setMostraridvalorclientearealaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setMostraridvalorclientecargolaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCIUDAD)) {
				this.setMostraridciudadInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOA)) {
				this.setMostrartiempoaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOM)) {
				this.setMostrartiempomInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombreempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREREFERENCIA)) {
				this.setMostrarnombrereferenciaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setMostrartelefonocodigoareaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOMOVIL)) {
				this.setMostrartelefonomovilInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.EMAIL)) {
				this.setMostraremailInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoInformacionLaboral(esAsigna);
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
		
		
		this.setActivaridInformacionLaboral(esInicial);
		this.setActivaridclienteInformacionLaboral(esInicial);
		this.setActivaridvalorempresaInformacionLaboral(esInicial);
		this.setActivaridvalorclienterelacionlaboralInformacionLaboral(esInicial);
		this.setActivaridvalorclientearealaboralInformacionLaboral(esInicial);
		this.setActivaridvalorclientecargolaboralInformacionLaboral(esInicial);
		this.setActivarid_paisInformacionLaboral(esInicial);
		this.setActivaridciudadInformacionLaboral(esInicial);
		this.setActivartiempoaInformacionLaboral(esInicial);
		this.setActivartiempomInformacionLaboral(esInicial);
		this.setActivarnombreempresaInformacionLaboral(esInicial);
		this.setActivardireccionInformacionLaboral(esInicial);
		this.setActivarnombrereferenciaInformacionLaboral(esInicial);
		this.setActivartelefonoInformacionLaboral(esInicial);
		this.setActivartelefonocodigoareaInformacionLaboral(esInicial);
		this.setActivartelefonomovilInformacionLaboral(esInicial);
		this.setActivaremailInformacionLaboral(esInicial);
		this.setActivaresactivoInformacionLaboral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ID)) {
				this.setActivaridInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOEMPRESA)) {
				this.setActivaridvalorempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPORELALABO)) {
				this.setActivaridvalorclienterelacionlaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOAREALABO)) {
				this.setActivaridvalorclientearealaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setActivaridvalorclientecargolaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCIUDAD)) {
				this.setActivaridciudadInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOA)) {
				this.setActivartiempoaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOM)) {
				this.setActivartiempomInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombreempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.DIRECCION)) {
				this.setActivardireccionInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREREFERENCIA)) {
				this.setActivarnombrereferenciaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setActivartelefonocodigoareaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOMOVIL)) {
				this.setActivartelefonomovilInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.EMAIL)) {
				this.setActivaremailInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoInformacionLaboral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridInformacionLaboral(esInicial);
		this.setResaltaridclienteInformacionLaboral(esInicial);
		this.setResaltaridvalorempresaInformacionLaboral(esInicial);
		this.setResaltaridvalorclienterelacionlaboralInformacionLaboral(esInicial);
		this.setResaltaridvalorclientearealaboralInformacionLaboral(esInicial);
		this.setResaltaridvalorclientecargolaboralInformacionLaboral(esInicial);
		this.setResaltarid_paisInformacionLaboral(esInicial);
		this.setResaltaridciudadInformacionLaboral(esInicial);
		this.setResaltartiempoaInformacionLaboral(esInicial);
		this.setResaltartiempomInformacionLaboral(esInicial);
		this.setResaltarnombreempresaInformacionLaboral(esInicial);
		this.setResaltardireccionInformacionLaboral(esInicial);
		this.setResaltarnombrereferenciaInformacionLaboral(esInicial);
		this.setResaltartelefonoInformacionLaboral(esInicial);
		this.setResaltartelefonocodigoareaInformacionLaboral(esInicial);
		this.setResaltartelefonomovilInformacionLaboral(esInicial);
		this.setResaltaremailInformacionLaboral(esInicial);
		this.setResaltaresactivoInformacionLaboral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ID)) {
				this.setResaltaridInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOEMPRESA)) {
				this.setResaltaridvalorempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPORELALABO)) {
				this.setResaltaridvalorclienterelacionlaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOAREALABO)) {
				this.setResaltaridvalorclientearealaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setResaltaridvalorclientecargolaboralInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.IDCIUDAD)) {
				this.setResaltaridciudadInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOA)) {
				this.setResaltartiempoaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TIEMPOM)) {
				this.setResaltartiempomInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombreempresaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.NOMBREREFERENCIA)) {
				this.setResaltarnombrereferenciaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setResaltartelefonocodigoareaInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.TELEFONOMOVIL)) {
				this.setResaltartelefonomovilInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.EMAIL)) {
				this.setResaltaremailInformacionLaboral(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionLaboralConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoInformacionLaboral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadInformacionLaboral=true;

	public Boolean getMostrarFK_IdCiudadInformacionLaboral() {
		return this.mostrarFK_IdCiudadInformacionLaboral;
	}

	public void setMostrarFK_IdCiudadInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteInformacionLaboral=true;

	public Boolean getMostrarFK_IdClienteInformacionLaboral() {
		return this.mostrarFK_IdClienteInformacionLaboral;
	}

	public void setMostrarFK_IdClienteInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisInformacionLaboral=true;

	public Boolean getMostrarFK_IdPaisInformacionLaboral() {
		return this.mostrarFK_IdPaisInformacionLaboral;
	}

	public void setMostrarFK_IdPaisInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEmpresaInformacionLaboral=true;

	public Boolean getMostrarFK_IdTipoEmpresaInformacionLaboral() {
		return this.mostrarFK_IdTipoEmpresaInformacionLaboral;
	}

	public void setMostrarFK_IdTipoEmpresaInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEmpresaInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteAreaLaboralInformacionLaboral=true;

	public Boolean getMostrarFK_IdValorClienteAreaLaboralInformacionLaboral() {
		return this.mostrarFK_IdValorClienteAreaLaboralInformacionLaboral;
	}

	public void setMostrarFK_IdValorClienteAreaLaboralInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteAreaLaboralInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteCargoLaboralInformacionLaboral=true;

	public Boolean getMostrarFK_IdValorClienteCargoLaboralInformacionLaboral() {
		return this.mostrarFK_IdValorClienteCargoLaboralInformacionLaboral;
	}

	public void setMostrarFK_IdValorClienteCargoLaboralInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteCargoLaboralInformacionLaboral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteRelacionLaboralInformacionLaboral=true;

	public Boolean getMostrarFK_IdValorClienteRelacionLaboralInformacionLaboral() {
		return this.mostrarFK_IdValorClienteRelacionLaboralInformacionLaboral;
	}

	public void setMostrarFK_IdValorClienteRelacionLaboralInformacionLaboral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteRelacionLaboralInformacionLaboral= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadInformacionLaboral=true;

	public Boolean getActivarFK_IdCiudadInformacionLaboral() {
		return this.activarFK_IdCiudadInformacionLaboral;
	}

	public void setActivarFK_IdCiudadInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteInformacionLaboral=true;

	public Boolean getActivarFK_IdClienteInformacionLaboral() {
		return this.activarFK_IdClienteInformacionLaboral;
	}

	public void setActivarFK_IdClienteInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdClienteInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisInformacionLaboral=true;

	public Boolean getActivarFK_IdPaisInformacionLaboral() {
		return this.activarFK_IdPaisInformacionLaboral;
	}

	public void setActivarFK_IdPaisInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdPaisInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEmpresaInformacionLaboral=true;

	public Boolean getActivarFK_IdTipoEmpresaInformacionLaboral() {
		return this.activarFK_IdTipoEmpresaInformacionLaboral;
	}

	public void setActivarFK_IdTipoEmpresaInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEmpresaInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteAreaLaboralInformacionLaboral=true;

	public Boolean getActivarFK_IdValorClienteAreaLaboralInformacionLaboral() {
		return this.activarFK_IdValorClienteAreaLaboralInformacionLaboral;
	}

	public void setActivarFK_IdValorClienteAreaLaboralInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteAreaLaboralInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteCargoLaboralInformacionLaboral=true;

	public Boolean getActivarFK_IdValorClienteCargoLaboralInformacionLaboral() {
		return this.activarFK_IdValorClienteCargoLaboralInformacionLaboral;
	}

	public void setActivarFK_IdValorClienteCargoLaboralInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteCargoLaboralInformacionLaboral= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteRelacionLaboralInformacionLaboral=true;

	public Boolean getActivarFK_IdValorClienteRelacionLaboralInformacionLaboral() {
		return this.activarFK_IdValorClienteRelacionLaboralInformacionLaboral;
	}

	public void setActivarFK_IdValorClienteRelacionLaboralInformacionLaboral(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteRelacionLaboralInformacionLaboral= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadInformacionLaboral=null;

	public Border getResaltarFK_IdCiudadInformacionLaboral() {
		return this.resaltarFK_IdCiudadInformacionLaboral;
	}

	public void setResaltarFK_IdCiudadInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdCiudadInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdCiudadInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdClienteInformacionLaboral=null;

	public Border getResaltarFK_IdClienteInformacionLaboral() {
		return this.resaltarFK_IdClienteInformacionLaboral;
	}

	public void setResaltarFK_IdClienteInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdClienteInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdClienteInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdPaisInformacionLaboral=null;

	public Border getResaltarFK_IdPaisInformacionLaboral() {
		return this.resaltarFK_IdPaisInformacionLaboral;
	}

	public void setResaltarFK_IdPaisInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdPaisInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdPaisInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdTipoEmpresaInformacionLaboral=null;

	public Border getResaltarFK_IdTipoEmpresaInformacionLaboral() {
		return this.resaltarFK_IdTipoEmpresaInformacionLaboral;
	}

	public void setResaltarFK_IdTipoEmpresaInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdTipoEmpresaInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdTipoEmpresaInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEmpresaInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteAreaLaboralInformacionLaboral=null;

	public Border getResaltarFK_IdValorClienteAreaLaboralInformacionLaboral() {
		return this.resaltarFK_IdValorClienteAreaLaboralInformacionLaboral;
	}

	public void setResaltarFK_IdValorClienteAreaLaboralInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdValorClienteAreaLaboralInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteAreaLaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteAreaLaboralInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteCargoLaboralInformacionLaboral=null;

	public Border getResaltarFK_IdValorClienteCargoLaboralInformacionLaboral() {
		return this.resaltarFK_IdValorClienteCargoLaboralInformacionLaboral;
	}

	public void setResaltarFK_IdValorClienteCargoLaboralInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdValorClienteCargoLaboralInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteCargoLaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteCargoLaboralInformacionLaboral= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteRelacionLaboralInformacionLaboral=null;

	public Border getResaltarFK_IdValorClienteRelacionLaboralInformacionLaboral() {
		return this.resaltarFK_IdValorClienteRelacionLaboralInformacionLaboral;
	}

	public void setResaltarFK_IdValorClienteRelacionLaboralInformacionLaboral(Border borderResaltar) {
		this.resaltarFK_IdValorClienteRelacionLaboralInformacionLaboral= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteRelacionLaboralInformacionLaboral(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionLaboralBeanSwingJInternalFrame informacionlaboralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteRelacionLaboralInformacionLaboral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}