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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EmpleadoIdiomaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoIdiomaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoIdiomaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpleadoIdiomaConstantesFunciones extends EmpleadoIdiomaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoIdioma";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoIdioma"+EmpleadoIdiomaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoIdiomaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoIdiomaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoIdiomaConstantesFunciones.SCHEMA+"_"+EmpleadoIdiomaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoIdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoIdiomaConstantesFunciones.SCHEMA+"_"+EmpleadoIdiomaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoIdiomaConstantesFunciones.SCHEMA+"_"+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoIdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoIdiomaConstantesFunciones.SCHEMA+"_"+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoIdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoIdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoIdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoIdiomaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoIdiomaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoIdiomaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoIdiomaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Idiomas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Idioma";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Idioma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoIdioma";
	public static final String OBJECTNAME="empleadoidioma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_idioma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoidioma from "+EmpleadoIdiomaConstantesFunciones.SPERSISTENCENAME+" empleadoidioma";
	public static String QUERYSELECTNATIVE="select "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_idioma,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_materna,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_tecnico,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_tecnico,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_lectura,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_lectura,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_escrito,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_escrito,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_hablado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_hablado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME;//+" as "+EmpleadoIdiomaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoIdiomaConstantesFuncionesAdditional empleadoidiomaConstantesFuncionesAdditional=null;
	
	public EmpleadoIdiomaConstantesFuncionesAdditional getEmpleadoIdiomaConstantesFuncionesAdditional() {
		return this.empleadoidiomaConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoIdiomaConstantesFuncionesAdditional(EmpleadoIdiomaConstantesFuncionesAdditional empleadoidiomaConstantesFuncionesAdditional) {
		try {
			this.empleadoidiomaConstantesFuncionesAdditional=empleadoidiomaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDIDIOMA= "id_idioma";
    public static final String ESMATERNA= "es_materna";
    public static final String ESTECNICO= "es_tecnico";
    public static final String PORCENTECNICO= "porcen_tecnico";
    public static final String ESLECTURA= "es_lectura";
    public static final String PORCENLECTURA= "porcen_lectura";
    public static final String ESESCRITO= "es_escrito";
    public static final String PORCENESCRITO= "porcen_escrito";
    public static final String ESHABLADO= "es_hablado";
    public static final String PORCENHABLADO= "porcen_hablado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDIDIOMA= "Idioma";
		public static final String LABEL_IDIDIOMA_LOWER= "Idioma";
    	public static final String LABEL_ESMATERNA= "Es Materna";
		public static final String LABEL_ESMATERNA_LOWER= "Es Materna";
    	public static final String LABEL_ESTECNICO= "Es Tecnico";
		public static final String LABEL_ESTECNICO_LOWER= "Es Tecnico";
    	public static final String LABEL_PORCENTECNICO= "Porcen Tecnico";
		public static final String LABEL_PORCENTECNICO_LOWER= "Porcen Tecnico";
    	public static final String LABEL_ESLECTURA= "Es Lectura";
		public static final String LABEL_ESLECTURA_LOWER= "Es Lectura";
    	public static final String LABEL_PORCENLECTURA= "Porcen Lectura";
		public static final String LABEL_PORCENLECTURA_LOWER= "Porcen Lectura";
    	public static final String LABEL_ESESCRITO= "Es Escrito";
		public static final String LABEL_ESESCRITO_LOWER= "Es Escrito";
    	public static final String LABEL_PORCENESCRITO= "Porcen Escrito";
		public static final String LABEL_PORCENESCRITO_LOWER= "Porcen Escrito";
    	public static final String LABEL_ESHABLADO= "Es Hablado";
		public static final String LABEL_ESHABLADO_LOWER= "Es Hablado";
    	public static final String LABEL_PORCENHABLADO= "Porcen Hablado";
		public static final String LABEL_PORCENHABLADO_LOWER= "Porcen Hablado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpleadoIdiomaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.IDIDIOMA)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_IDIDIOMA;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.ESMATERNA)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_ESMATERNA;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.ESTECNICO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_ESTECNICO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.PORCENTECNICO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_PORCENTECNICO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.ESLECTURA)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_ESLECTURA;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.PORCENLECTURA)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_PORCENLECTURA;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.ESESCRITO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_ESESCRITO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.PORCENESCRITO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_PORCENESCRITO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.ESHABLADO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_ESHABLADO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.PORCENHABLADO)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_PORCENHABLADO;}
		if(sNombreColumna.equals(EmpleadoIdiomaConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpleadoIdiomaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_maternaDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoidioma.getes_materna()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_maternaHtmlDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoidioma.getId(),empleadoidioma.getes_materna());

		return sDescripcion;
	}	
		
	public static String getes_tecnicoDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoidioma.getes_tecnico()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_tecnicoHtmlDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoidioma.getId(),empleadoidioma.getes_tecnico());

		return sDescripcion;
	}	
			
		
	public static String getes_lecturaDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoidioma.getes_lectura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_lecturaHtmlDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoidioma.getId(),empleadoidioma.getes_lectura());

		return sDescripcion;
	}	
			
		
	public static String getes_escritoDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoidioma.getes_escrito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_escritoHtmlDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoidioma.getId(),empleadoidioma.getes_escrito());

		return sDescripcion;
	}	
			
		
	public static String getes_habladoDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoidioma.getes_hablado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_habladoHtmlDescripcion(EmpleadoIdioma empleadoidioma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoidioma.getId(),empleadoidioma.getes_hablado());

		return sDescripcion;
	}	
			
			
	
	public static String getEmpleadoIdiomaDescripcion(EmpleadoIdioma empleadoidioma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoidioma !=null/* && empleadoidioma.getId()!=0*/) {
			if(empleadoidioma.getId()!=null) {
				sDescripcion=empleadoidioma.getId().toString();
			}//empleadoidiomaempleadoidioma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoIdiomaDescripcionDetallado(EmpleadoIdioma empleadoidioma) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ID+"=";
		sDescripcion+=empleadoidioma.getId().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoidioma.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoidioma.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoidioma.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.IDIDIOMA+"=";
		sDescripcion+=empleadoidioma.getid_idioma().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ESMATERNA+"=";
		sDescripcion+=empleadoidioma.getes_materna().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ESTECNICO+"=";
		sDescripcion+=empleadoidioma.getes_tecnico().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.PORCENTECNICO+"=";
		sDescripcion+=empleadoidioma.getporcen_tecnico().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ESLECTURA+"=";
		sDescripcion+=empleadoidioma.getes_lectura().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.PORCENLECTURA+"=";
		sDescripcion+=empleadoidioma.getporcen_lectura().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ESESCRITO+"=";
		sDescripcion+=empleadoidioma.getes_escrito().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.PORCENESCRITO+"=";
		sDescripcion+=empleadoidioma.getporcen_escrito().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.ESHABLADO+"=";
		sDescripcion+=empleadoidioma.getes_hablado().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.PORCENHABLADO+"=";
		sDescripcion+=empleadoidioma.getporcen_hablado().toString()+",";
		sDescripcion+=EmpleadoIdiomaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empleadoidioma.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoIdiomaDescripcion(EmpleadoIdioma empleadoidioma,String sValor) throws Exception {			
		if(empleadoidioma !=null) {
			//empleadoidiomaempleadoidioma.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getIdiomaDescripcion(Idioma idioma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(idioma!=null/*&&idioma.getId()>0*/) {
			sDescripcion=IdiomaConstantesFunciones.getIdiomaDescripcion(idioma);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdIdioma")) {
			sNombreIndice="Tipo=  Por Idioma";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdIdioma(Long id_idioma) {
		String sDetalleIndice=" Parametros->";
		if(id_idioma!=null) {sDetalleIndice+=" Codigo Unico De Idioma="+id_idioma.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoIdioma(EmpleadoIdioma empleadoidioma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadoidioma.setdescripcion(empleadoidioma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpleadoIdiomas(List<EmpleadoIdioma> empleadoidiomas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoIdioma empleadoidioma: empleadoidiomas) {
			empleadoidioma.setdescripcion(empleadoidioma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoIdioma(EmpleadoIdioma empleadoidioma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoidioma.getConCambioAuxiliar()) {
			empleadoidioma.setIsDeleted(empleadoidioma.getIsDeletedAuxiliar());	
			empleadoidioma.setIsNew(empleadoidioma.getIsNewAuxiliar());	
			empleadoidioma.setIsChanged(empleadoidioma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoidioma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoidioma.setIsDeletedAuxiliar(false);	
			empleadoidioma.setIsNewAuxiliar(false);	
			empleadoidioma.setIsChangedAuxiliar(false);
			
			empleadoidioma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoIdiomas(List<EmpleadoIdioma> empleadoidiomas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoIdioma empleadoidioma : empleadoidiomas) {
			if(conAsignarBase && empleadoidioma.getConCambioAuxiliar()) {
				empleadoidioma.setIsDeleted(empleadoidioma.getIsDeletedAuxiliar());	
				empleadoidioma.setIsNew(empleadoidioma.getIsNewAuxiliar());	
				empleadoidioma.setIsChanged(empleadoidioma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoidioma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoidioma.setIsDeletedAuxiliar(false);	
				empleadoidioma.setIsNewAuxiliar(false);	
				empleadoidioma.setIsChangedAuxiliar(false);
				
				empleadoidioma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoIdioma(EmpleadoIdioma empleadoidioma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			empleadoidioma.setporcen_tecnico(0);
			empleadoidioma.setporcen_lectura(0);
			empleadoidioma.setporcen_escrito(0);
			empleadoidioma.setporcen_hablado(0);
		}
	}		
	
	public static void InicializarValoresEmpleadoIdiomas(List<EmpleadoIdioma> empleadoidiomas,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoIdioma empleadoidioma: empleadoidiomas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				empleadoidioma.setporcen_tecnico(0);
				empleadoidioma.setporcen_lectura(0);
				empleadoidioma.setporcen_escrito(0);
				empleadoidioma.setporcen_hablado(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoIdioma(List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdioma empleadoidiomaAux) throws Exception  {
		EmpleadoIdiomaConstantesFunciones.InicializarValoresEmpleadoIdioma(empleadoidiomaAux,true);
		
		for(EmpleadoIdioma empleadoidioma: empleadoidiomas) {
			if(empleadoidioma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoidiomaAux.setporcen_tecnico(empleadoidiomaAux.getporcen_tecnico()+empleadoidioma.getporcen_tecnico());			
			empleadoidiomaAux.setporcen_lectura(empleadoidiomaAux.getporcen_lectura()+empleadoidioma.getporcen_lectura());			
			empleadoidiomaAux.setporcen_escrito(empleadoidiomaAux.getporcen_escrito()+empleadoidioma.getporcen_escrito());			
			empleadoidiomaAux.setporcen_hablado(empleadoidiomaAux.getporcen_hablado()+empleadoidioma.getporcen_hablado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoIdioma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoIdiomaConstantesFunciones.getArrayColumnasGlobalesEmpleadoIdioma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoIdioma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoIdiomaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoIdiomaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoIdioma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdioma empleadoidioma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoIdioma empleadoidiomaAux: empleadoidiomas) {
			if(empleadoidiomaAux!=null && empleadoidioma!=null) {
				if((empleadoidiomaAux.getId()==null && empleadoidioma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoidiomaAux.getId()!=null && empleadoidioma.getId()!=null){
					if(empleadoidiomaAux.getId().equals(empleadoidioma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoIdioma(List<EmpleadoIdioma> empleadoidiomas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoIdioma empleadoidioma: empleadoidiomas) {			
			if(empleadoidioma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoIdioma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ID, EmpleadoIdiomaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_VERSIONROW, EmpleadoIdiomaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPRESA, EmpleadoIdiomaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoIdiomaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_IDIDIOMA, EmpleadoIdiomaConstantesFunciones.IDIDIOMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ESMATERNA, EmpleadoIdiomaConstantesFunciones.ESMATERNA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ESTECNICO, EmpleadoIdiomaConstantesFunciones.ESTECNICO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_PORCENTECNICO, EmpleadoIdiomaConstantesFunciones.PORCENTECNICO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ESLECTURA, EmpleadoIdiomaConstantesFunciones.ESLECTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_PORCENLECTURA, EmpleadoIdiomaConstantesFunciones.PORCENLECTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ESESCRITO, EmpleadoIdiomaConstantesFunciones.ESESCRITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_PORCENESCRITO, EmpleadoIdiomaConstantesFunciones.PORCENESCRITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_ESHABLADO, EmpleadoIdiomaConstantesFunciones.ESHABLADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_PORCENHABLADO, EmpleadoIdiomaConstantesFunciones.PORCENHABLADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoIdiomaConstantesFunciones.LABEL_DESCRIPCION, EmpleadoIdiomaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoIdioma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.IDIDIOMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ESMATERNA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ESTECNICO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.PORCENTECNICO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ESLECTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.PORCENLECTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ESESCRITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.PORCENESCRITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.ESHABLADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.PORCENHABLADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoIdiomaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoIdioma() throws Exception  {
		return EmpleadoIdiomaConstantesFunciones.getTiposSeleccionarEmpleadoIdioma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoIdioma(Boolean conFk) throws Exception  {
		return EmpleadoIdiomaConstantesFunciones.getTiposSeleccionarEmpleadoIdioma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoIdioma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_IDIDIOMA);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_IDIDIOMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_ESMATERNA);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_ESMATERNA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_ESTECNICO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_ESTECNICO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENTECNICO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENTECNICO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_ESLECTURA);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_ESLECTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENLECTURA);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENLECTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_ESESCRITO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_ESESCRITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENESCRITO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENESCRITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_ESHABLADO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_ESHABLADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENHABLADO);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENHABLADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoIdiomaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpleadoIdiomaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoIdioma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoIdioma(EmpleadoIdioma empleadoidiomaAux) throws Exception {
		
			empleadoidiomaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoidiomaAux.getEmpresa()));
			empleadoidiomaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoidiomaAux.getEmpleado()));
			empleadoidiomaAux.setidioma_descripcion(IdiomaConstantesFunciones.getIdiomaDescripcion(empleadoidiomaAux.getIdioma()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoIdioma(List<EmpleadoIdioma> empleadoidiomasTemp) throws Exception {
		for(EmpleadoIdioma empleadoidiomaAux:empleadoidiomasTemp) {
			
			empleadoidiomaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoidiomaAux.getEmpresa()));
			empleadoidiomaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoidiomaAux.getEmpleado()));
			empleadoidiomaAux.setidioma_descripcion(IdiomaConstantesFunciones.getIdiomaDescripcion(empleadoidiomaAux.getIdioma()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Idioma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Idioma.class)) {
						classes.add(new Classe(Idioma.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Idioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Idioma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Idioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Idioma.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoIdiomaConstantesFunciones.getClassesRelationshipsOfEmpleadoIdioma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoIdiomaConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoIdioma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoIdioma empleadoidioma,List<EmpleadoIdioma> empleadoidiomas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoIdioma empleadoidiomaEncontrado=null;
			
			for(EmpleadoIdioma empleadoidiomaLocal:empleadoidiomas) {
				if(empleadoidiomaLocal.getId().equals(empleadoidioma.getId())) {
					empleadoidiomaEncontrado=empleadoidiomaLocal;
					
					empleadoidiomaLocal.setIsChanged(empleadoidioma.getIsChanged());
					empleadoidiomaLocal.setIsNew(empleadoidioma.getIsNew());
					empleadoidiomaLocal.setIsDeleted(empleadoidioma.getIsDeleted());
					
					empleadoidiomaLocal.setGeneralEntityOriginal(empleadoidioma.getGeneralEntityOriginal());
					
					empleadoidiomaLocal.setId(empleadoidioma.getId());	
					empleadoidiomaLocal.setVersionRow(empleadoidioma.getVersionRow());	
					empleadoidiomaLocal.setid_empresa(empleadoidioma.getid_empresa());	
					empleadoidiomaLocal.setid_empleado(empleadoidioma.getid_empleado());	
					empleadoidiomaLocal.setid_idioma(empleadoidioma.getid_idioma());	
					empleadoidiomaLocal.setes_materna(empleadoidioma.getes_materna());	
					empleadoidiomaLocal.setes_tecnico(empleadoidioma.getes_tecnico());	
					empleadoidiomaLocal.setporcen_tecnico(empleadoidioma.getporcen_tecnico());	
					empleadoidiomaLocal.setes_lectura(empleadoidioma.getes_lectura());	
					empleadoidiomaLocal.setporcen_lectura(empleadoidioma.getporcen_lectura());	
					empleadoidiomaLocal.setes_escrito(empleadoidioma.getes_escrito());	
					empleadoidiomaLocal.setporcen_escrito(empleadoidioma.getporcen_escrito());	
					empleadoidiomaLocal.setes_hablado(empleadoidioma.getes_hablado());	
					empleadoidiomaLocal.setporcen_hablado(empleadoidioma.getporcen_hablado());	
					empleadoidiomaLocal.setdescripcion(empleadoidioma.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoidioma.getIsDeleted()) {
				if(!existe) {
					empleadoidiomas.add(empleadoidioma);
				}
			} else {
				if(empleadoidiomaEncontrado!=null && permiteQuitar)  {
					empleadoidiomas.remove(empleadoidiomaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoIdioma empleadoidioma,List<EmpleadoIdioma> empleadoidiomas) throws Exception {
		try	{			
			for(EmpleadoIdioma empleadoidiomaLocal:empleadoidiomas) {
				if(empleadoidiomaLocal.getId().equals(empleadoidioma.getId())) {
					empleadoidiomaLocal.setIsSelected(empleadoidioma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoIdioma(List<EmpleadoIdioma> empleadoidiomasAux) throws Exception {
		//this.empleadoidiomasAux=empleadoidiomasAux;
		
		for(EmpleadoIdioma empleadoidiomaAux:empleadoidiomasAux) {
			if(empleadoidiomaAux.getIsChanged()) {
				empleadoidiomaAux.setIsChanged(false);
			}		
			
			if(empleadoidiomaAux.getIsNew()) {
				empleadoidiomaAux.setIsNew(false);
			}	
			
			if(empleadoidiomaAux.getIsDeleted()) {
				empleadoidiomaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoIdioma(EmpleadoIdioma empleadoidiomaAux) throws Exception {
		//this.empleadoidiomaAux=empleadoidiomaAux;
		
			if(empleadoidiomaAux.getIsChanged()) {
				empleadoidiomaAux.setIsChanged(false);
			}		
			
			if(empleadoidiomaAux.getIsNew()) {
				empleadoidiomaAux.setIsNew(false);
			}	
			
			if(empleadoidiomaAux.getIsDeleted()) {
				empleadoidiomaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoIdioma empleadoidiomaAsignar,EmpleadoIdioma empleadoidioma) throws Exception {
		empleadoidiomaAsignar.setId(empleadoidioma.getId());	
		empleadoidiomaAsignar.setVersionRow(empleadoidioma.getVersionRow());	
		empleadoidiomaAsignar.setid_empresa(empleadoidioma.getid_empresa());
		empleadoidiomaAsignar.setempresa_descripcion(empleadoidioma.getempresa_descripcion());	
		empleadoidiomaAsignar.setid_empleado(empleadoidioma.getid_empleado());
		empleadoidiomaAsignar.setempleado_descripcion(empleadoidioma.getempleado_descripcion());	
		empleadoidiomaAsignar.setid_idioma(empleadoidioma.getid_idioma());
		empleadoidiomaAsignar.setidioma_descripcion(empleadoidioma.getidioma_descripcion());	
		empleadoidiomaAsignar.setes_materna(empleadoidioma.getes_materna());	
		empleadoidiomaAsignar.setes_tecnico(empleadoidioma.getes_tecnico());	
		empleadoidiomaAsignar.setporcen_tecnico(empleadoidioma.getporcen_tecnico());	
		empleadoidiomaAsignar.setes_lectura(empleadoidioma.getes_lectura());	
		empleadoidiomaAsignar.setporcen_lectura(empleadoidioma.getporcen_lectura());	
		empleadoidiomaAsignar.setes_escrito(empleadoidioma.getes_escrito());	
		empleadoidiomaAsignar.setporcen_escrito(empleadoidioma.getporcen_escrito());	
		empleadoidiomaAsignar.setes_hablado(empleadoidioma.getes_hablado());	
		empleadoidiomaAsignar.setporcen_hablado(empleadoidioma.getporcen_hablado());	
		empleadoidiomaAsignar.setdescripcion(empleadoidioma.getdescripcion());	
	}
	
	public static void inicializarEmpleadoIdioma(EmpleadoIdioma empleadoidioma) throws Exception {
		try {
				empleadoidioma.setId(0L);	
					
				empleadoidioma.setid_empresa(-1L);	
				empleadoidioma.setid_empleado(-1L);	
				empleadoidioma.setid_idioma(-1L);	
				empleadoidioma.setes_materna(false);	
				empleadoidioma.setes_tecnico(false);	
				empleadoidioma.setporcen_tecnico(0);	
				empleadoidioma.setes_lectura(false);	
				empleadoidioma.setporcen_lectura(0);	
				empleadoidioma.setes_escrito(false);	
				empleadoidioma.setporcen_escrito(0);	
				empleadoidioma.setes_hablado(false);	
				empleadoidioma.setporcen_hablado(0);	
				empleadoidioma.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoIdioma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_IDIDIOMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_ESMATERNA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_ESTECNICO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENTECNICO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_ESLECTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENLECTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_ESESCRITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENESCRITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_ESHABLADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_PORCENHABLADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoIdiomaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoIdioma(String sTipo,Row row,Workbook workbook,EmpleadoIdioma empleadoidioma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getidioma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoidioma.getes_materna()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoidioma.getes_tecnico()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getporcen_tecnico());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoidioma.getes_lectura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getporcen_lectura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoidioma.getes_escrito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getporcen_escrito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoidioma.getes_hablado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getporcen_hablado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoidioma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoIdioma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoIdioma() {
		return this.sFinalQueryEmpleadoIdioma;
	}
	
	public void setsFinalQueryEmpleadoIdioma(String sFinalQueryEmpleadoIdioma) {
		this.sFinalQueryEmpleadoIdioma= sFinalQueryEmpleadoIdioma;
	}
	
	public Border resaltarSeleccionarEmpleadoIdioma=null;
	
	public Border setResaltarSeleccionarEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoIdioma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoIdioma() {
		return this.resaltarSeleccionarEmpleadoIdioma;
	}
	
	public void setResaltarSeleccionarEmpleadoIdioma(Border borderResaltarSeleccionarEmpleadoIdioma) {
		this.resaltarSeleccionarEmpleadoIdioma= borderResaltarSeleccionarEmpleadoIdioma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoIdioma=null;
	public Boolean mostraridEmpleadoIdioma=true;
	public Boolean activaridEmpleadoIdioma=true;

	public Border resaltarid_empresaEmpleadoIdioma=null;
	public Boolean mostrarid_empresaEmpleadoIdioma=true;
	public Boolean activarid_empresaEmpleadoIdioma=true;
	public Boolean cargarid_empresaEmpleadoIdioma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoIdioma=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoIdioma=null;
	public Boolean mostrarid_empleadoEmpleadoIdioma=true;
	public Boolean activarid_empleadoEmpleadoIdioma=true;
	public Boolean cargarid_empleadoEmpleadoIdioma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoIdioma=false;//ConEventDepend=true

	public Border resaltarid_idiomaEmpleadoIdioma=null;
	public Boolean mostrarid_idiomaEmpleadoIdioma=true;
	public Boolean activarid_idiomaEmpleadoIdioma=true;
	public Boolean cargarid_idiomaEmpleadoIdioma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_idiomaEmpleadoIdioma=false;//ConEventDepend=true

	public Border resaltares_maternaEmpleadoIdioma=null;
	public Boolean mostrares_maternaEmpleadoIdioma=true;
	public Boolean activares_maternaEmpleadoIdioma=true;

	public Border resaltares_tecnicoEmpleadoIdioma=null;
	public Boolean mostrares_tecnicoEmpleadoIdioma=true;
	public Boolean activares_tecnicoEmpleadoIdioma=true;

	public Border resaltarporcen_tecnicoEmpleadoIdioma=null;
	public Boolean mostrarporcen_tecnicoEmpleadoIdioma=true;
	public Boolean activarporcen_tecnicoEmpleadoIdioma=true;

	public Border resaltares_lecturaEmpleadoIdioma=null;
	public Boolean mostrares_lecturaEmpleadoIdioma=true;
	public Boolean activares_lecturaEmpleadoIdioma=true;

	public Border resaltarporcen_lecturaEmpleadoIdioma=null;
	public Boolean mostrarporcen_lecturaEmpleadoIdioma=true;
	public Boolean activarporcen_lecturaEmpleadoIdioma=true;

	public Border resaltares_escritoEmpleadoIdioma=null;
	public Boolean mostrares_escritoEmpleadoIdioma=true;
	public Boolean activares_escritoEmpleadoIdioma=true;

	public Border resaltarporcen_escritoEmpleadoIdioma=null;
	public Boolean mostrarporcen_escritoEmpleadoIdioma=true;
	public Boolean activarporcen_escritoEmpleadoIdioma=true;

	public Border resaltares_habladoEmpleadoIdioma=null;
	public Boolean mostrares_habladoEmpleadoIdioma=true;
	public Boolean activares_habladoEmpleadoIdioma=true;

	public Border resaltarporcen_habladoEmpleadoIdioma=null;
	public Boolean mostrarporcen_habladoEmpleadoIdioma=true;
	public Boolean activarporcen_habladoEmpleadoIdioma=true;

	public Border resaltardescripcionEmpleadoIdioma=null;
	public Boolean mostrardescripcionEmpleadoIdioma=true;
	public Boolean activardescripcionEmpleadoIdioma=true;

	
	

	public Border setResaltaridEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoIdioma() {
		return this.resaltaridEmpleadoIdioma;
	}

	public void setResaltaridEmpleadoIdioma(Border borderResaltar) {
		this.resaltaridEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostraridEmpleadoIdioma() {
		return this.mostraridEmpleadoIdioma;
	}

	public void setMostraridEmpleadoIdioma(Boolean mostraridEmpleadoIdioma) {
		this.mostraridEmpleadoIdioma= mostraridEmpleadoIdioma;
	}

	public Boolean getActivaridEmpleadoIdioma() {
		return this.activaridEmpleadoIdioma;
	}

	public void setActivaridEmpleadoIdioma(Boolean activaridEmpleadoIdioma) {
		this.activaridEmpleadoIdioma= activaridEmpleadoIdioma;
	}

	public Border setResaltarid_empresaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoIdioma() {
		return this.resaltarid_empresaEmpleadoIdioma;
	}

	public void setResaltarid_empresaEmpleadoIdioma(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoIdioma() {
		return this.mostrarid_empresaEmpleadoIdioma;
	}

	public void setMostrarid_empresaEmpleadoIdioma(Boolean mostrarid_empresaEmpleadoIdioma) {
		this.mostrarid_empresaEmpleadoIdioma= mostrarid_empresaEmpleadoIdioma;
	}

	public Boolean getActivarid_empresaEmpleadoIdioma() {
		return this.activarid_empresaEmpleadoIdioma;
	}

	public void setActivarid_empresaEmpleadoIdioma(Boolean activarid_empresaEmpleadoIdioma) {
		this.activarid_empresaEmpleadoIdioma= activarid_empresaEmpleadoIdioma;
	}

	public Boolean getCargarid_empresaEmpleadoIdioma() {
		return this.cargarid_empresaEmpleadoIdioma;
	}

	public void setCargarid_empresaEmpleadoIdioma(Boolean cargarid_empresaEmpleadoIdioma) {
		this.cargarid_empresaEmpleadoIdioma= cargarid_empresaEmpleadoIdioma;
	}

	public Border setResaltarid_empleadoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoIdioma() {
		return this.resaltarid_empleadoEmpleadoIdioma;
	}

	public void setResaltarid_empleadoEmpleadoIdioma(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoIdioma() {
		return this.mostrarid_empleadoEmpleadoIdioma;
	}

	public void setMostrarid_empleadoEmpleadoIdioma(Boolean mostrarid_empleadoEmpleadoIdioma) {
		this.mostrarid_empleadoEmpleadoIdioma= mostrarid_empleadoEmpleadoIdioma;
	}

	public Boolean getActivarid_empleadoEmpleadoIdioma() {
		return this.activarid_empleadoEmpleadoIdioma;
	}

	public void setActivarid_empleadoEmpleadoIdioma(Boolean activarid_empleadoEmpleadoIdioma) {
		this.activarid_empleadoEmpleadoIdioma= activarid_empleadoEmpleadoIdioma;
	}

	public Boolean getCargarid_empleadoEmpleadoIdioma() {
		return this.cargarid_empleadoEmpleadoIdioma;
	}

	public void setCargarid_empleadoEmpleadoIdioma(Boolean cargarid_empleadoEmpleadoIdioma) {
		this.cargarid_empleadoEmpleadoIdioma= cargarid_empleadoEmpleadoIdioma;
	}

	public Border setResaltarid_idiomaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarid_idiomaEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_idiomaEmpleadoIdioma() {
		return this.resaltarid_idiomaEmpleadoIdioma;
	}

	public void setResaltarid_idiomaEmpleadoIdioma(Border borderResaltar) {
		this.resaltarid_idiomaEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarid_idiomaEmpleadoIdioma() {
		return this.mostrarid_idiomaEmpleadoIdioma;
	}

	public void setMostrarid_idiomaEmpleadoIdioma(Boolean mostrarid_idiomaEmpleadoIdioma) {
		this.mostrarid_idiomaEmpleadoIdioma= mostrarid_idiomaEmpleadoIdioma;
	}

	public Boolean getActivarid_idiomaEmpleadoIdioma() {
		return this.activarid_idiomaEmpleadoIdioma;
	}

	public void setActivarid_idiomaEmpleadoIdioma(Boolean activarid_idiomaEmpleadoIdioma) {
		this.activarid_idiomaEmpleadoIdioma= activarid_idiomaEmpleadoIdioma;
	}

	public Boolean getCargarid_idiomaEmpleadoIdioma() {
		return this.cargarid_idiomaEmpleadoIdioma;
	}

	public void setCargarid_idiomaEmpleadoIdioma(Boolean cargarid_idiomaEmpleadoIdioma) {
		this.cargarid_idiomaEmpleadoIdioma= cargarid_idiomaEmpleadoIdioma;
	}

	public Border setResaltares_maternaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltares_maternaEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_maternaEmpleadoIdioma() {
		return this.resaltares_maternaEmpleadoIdioma;
	}

	public void setResaltares_maternaEmpleadoIdioma(Border borderResaltar) {
		this.resaltares_maternaEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrares_maternaEmpleadoIdioma() {
		return this.mostrares_maternaEmpleadoIdioma;
	}

	public void setMostrares_maternaEmpleadoIdioma(Boolean mostrares_maternaEmpleadoIdioma) {
		this.mostrares_maternaEmpleadoIdioma= mostrares_maternaEmpleadoIdioma;
	}

	public Boolean getActivares_maternaEmpleadoIdioma() {
		return this.activares_maternaEmpleadoIdioma;
	}

	public void setActivares_maternaEmpleadoIdioma(Boolean activares_maternaEmpleadoIdioma) {
		this.activares_maternaEmpleadoIdioma= activares_maternaEmpleadoIdioma;
	}

	public Border setResaltares_tecnicoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltares_tecnicoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_tecnicoEmpleadoIdioma() {
		return this.resaltares_tecnicoEmpleadoIdioma;
	}

	public void setResaltares_tecnicoEmpleadoIdioma(Border borderResaltar) {
		this.resaltares_tecnicoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrares_tecnicoEmpleadoIdioma() {
		return this.mostrares_tecnicoEmpleadoIdioma;
	}

	public void setMostrares_tecnicoEmpleadoIdioma(Boolean mostrares_tecnicoEmpleadoIdioma) {
		this.mostrares_tecnicoEmpleadoIdioma= mostrares_tecnicoEmpleadoIdioma;
	}

	public Boolean getActivares_tecnicoEmpleadoIdioma() {
		return this.activares_tecnicoEmpleadoIdioma;
	}

	public void setActivares_tecnicoEmpleadoIdioma(Boolean activares_tecnicoEmpleadoIdioma) {
		this.activares_tecnicoEmpleadoIdioma= activares_tecnicoEmpleadoIdioma;
	}

	public Border setResaltarporcen_tecnicoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarporcen_tecnicoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_tecnicoEmpleadoIdioma() {
		return this.resaltarporcen_tecnicoEmpleadoIdioma;
	}

	public void setResaltarporcen_tecnicoEmpleadoIdioma(Border borderResaltar) {
		this.resaltarporcen_tecnicoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarporcen_tecnicoEmpleadoIdioma() {
		return this.mostrarporcen_tecnicoEmpleadoIdioma;
	}

	public void setMostrarporcen_tecnicoEmpleadoIdioma(Boolean mostrarporcen_tecnicoEmpleadoIdioma) {
		this.mostrarporcen_tecnicoEmpleadoIdioma= mostrarporcen_tecnicoEmpleadoIdioma;
	}

	public Boolean getActivarporcen_tecnicoEmpleadoIdioma() {
		return this.activarporcen_tecnicoEmpleadoIdioma;
	}

	public void setActivarporcen_tecnicoEmpleadoIdioma(Boolean activarporcen_tecnicoEmpleadoIdioma) {
		this.activarporcen_tecnicoEmpleadoIdioma= activarporcen_tecnicoEmpleadoIdioma;
	}

	public Border setResaltares_lecturaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltares_lecturaEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_lecturaEmpleadoIdioma() {
		return this.resaltares_lecturaEmpleadoIdioma;
	}

	public void setResaltares_lecturaEmpleadoIdioma(Border borderResaltar) {
		this.resaltares_lecturaEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrares_lecturaEmpleadoIdioma() {
		return this.mostrares_lecturaEmpleadoIdioma;
	}

	public void setMostrares_lecturaEmpleadoIdioma(Boolean mostrares_lecturaEmpleadoIdioma) {
		this.mostrares_lecturaEmpleadoIdioma= mostrares_lecturaEmpleadoIdioma;
	}

	public Boolean getActivares_lecturaEmpleadoIdioma() {
		return this.activares_lecturaEmpleadoIdioma;
	}

	public void setActivares_lecturaEmpleadoIdioma(Boolean activares_lecturaEmpleadoIdioma) {
		this.activares_lecturaEmpleadoIdioma= activares_lecturaEmpleadoIdioma;
	}

	public Border setResaltarporcen_lecturaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarporcen_lecturaEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_lecturaEmpleadoIdioma() {
		return this.resaltarporcen_lecturaEmpleadoIdioma;
	}

	public void setResaltarporcen_lecturaEmpleadoIdioma(Border borderResaltar) {
		this.resaltarporcen_lecturaEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarporcen_lecturaEmpleadoIdioma() {
		return this.mostrarporcen_lecturaEmpleadoIdioma;
	}

	public void setMostrarporcen_lecturaEmpleadoIdioma(Boolean mostrarporcen_lecturaEmpleadoIdioma) {
		this.mostrarporcen_lecturaEmpleadoIdioma= mostrarporcen_lecturaEmpleadoIdioma;
	}

	public Boolean getActivarporcen_lecturaEmpleadoIdioma() {
		return this.activarporcen_lecturaEmpleadoIdioma;
	}

	public void setActivarporcen_lecturaEmpleadoIdioma(Boolean activarporcen_lecturaEmpleadoIdioma) {
		this.activarporcen_lecturaEmpleadoIdioma= activarporcen_lecturaEmpleadoIdioma;
	}

	public Border setResaltares_escritoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltares_escritoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_escritoEmpleadoIdioma() {
		return this.resaltares_escritoEmpleadoIdioma;
	}

	public void setResaltares_escritoEmpleadoIdioma(Border borderResaltar) {
		this.resaltares_escritoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrares_escritoEmpleadoIdioma() {
		return this.mostrares_escritoEmpleadoIdioma;
	}

	public void setMostrares_escritoEmpleadoIdioma(Boolean mostrares_escritoEmpleadoIdioma) {
		this.mostrares_escritoEmpleadoIdioma= mostrares_escritoEmpleadoIdioma;
	}

	public Boolean getActivares_escritoEmpleadoIdioma() {
		return this.activares_escritoEmpleadoIdioma;
	}

	public void setActivares_escritoEmpleadoIdioma(Boolean activares_escritoEmpleadoIdioma) {
		this.activares_escritoEmpleadoIdioma= activares_escritoEmpleadoIdioma;
	}

	public Border setResaltarporcen_escritoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarporcen_escritoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_escritoEmpleadoIdioma() {
		return this.resaltarporcen_escritoEmpleadoIdioma;
	}

	public void setResaltarporcen_escritoEmpleadoIdioma(Border borderResaltar) {
		this.resaltarporcen_escritoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarporcen_escritoEmpleadoIdioma() {
		return this.mostrarporcen_escritoEmpleadoIdioma;
	}

	public void setMostrarporcen_escritoEmpleadoIdioma(Boolean mostrarporcen_escritoEmpleadoIdioma) {
		this.mostrarporcen_escritoEmpleadoIdioma= mostrarporcen_escritoEmpleadoIdioma;
	}

	public Boolean getActivarporcen_escritoEmpleadoIdioma() {
		return this.activarporcen_escritoEmpleadoIdioma;
	}

	public void setActivarporcen_escritoEmpleadoIdioma(Boolean activarporcen_escritoEmpleadoIdioma) {
		this.activarporcen_escritoEmpleadoIdioma= activarporcen_escritoEmpleadoIdioma;
	}

	public Border setResaltares_habladoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltares_habladoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_habladoEmpleadoIdioma() {
		return this.resaltares_habladoEmpleadoIdioma;
	}

	public void setResaltares_habladoEmpleadoIdioma(Border borderResaltar) {
		this.resaltares_habladoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrares_habladoEmpleadoIdioma() {
		return this.mostrares_habladoEmpleadoIdioma;
	}

	public void setMostrares_habladoEmpleadoIdioma(Boolean mostrares_habladoEmpleadoIdioma) {
		this.mostrares_habladoEmpleadoIdioma= mostrares_habladoEmpleadoIdioma;
	}

	public Boolean getActivares_habladoEmpleadoIdioma() {
		return this.activares_habladoEmpleadoIdioma;
	}

	public void setActivares_habladoEmpleadoIdioma(Boolean activares_habladoEmpleadoIdioma) {
		this.activares_habladoEmpleadoIdioma= activares_habladoEmpleadoIdioma;
	}

	public Border setResaltarporcen_habladoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltarporcen_habladoEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_habladoEmpleadoIdioma() {
		return this.resaltarporcen_habladoEmpleadoIdioma;
	}

	public void setResaltarporcen_habladoEmpleadoIdioma(Border borderResaltar) {
		this.resaltarporcen_habladoEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrarporcen_habladoEmpleadoIdioma() {
		return this.mostrarporcen_habladoEmpleadoIdioma;
	}

	public void setMostrarporcen_habladoEmpleadoIdioma(Boolean mostrarporcen_habladoEmpleadoIdioma) {
		this.mostrarporcen_habladoEmpleadoIdioma= mostrarporcen_habladoEmpleadoIdioma;
	}

	public Boolean getActivarporcen_habladoEmpleadoIdioma() {
		return this.activarporcen_habladoEmpleadoIdioma;
	}

	public void setActivarporcen_habladoEmpleadoIdioma(Boolean activarporcen_habladoEmpleadoIdioma) {
		this.activarporcen_habladoEmpleadoIdioma= activarporcen_habladoEmpleadoIdioma;
	}

	public Border setResaltardescripcionEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoidiomaBeanSwingJInternalFrame.jTtoolBarEmpleadoIdioma.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpleadoIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpleadoIdioma() {
		return this.resaltardescripcionEmpleadoIdioma;
	}

	public void setResaltardescripcionEmpleadoIdioma(Border borderResaltar) {
		this.resaltardescripcionEmpleadoIdioma= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpleadoIdioma() {
		return this.mostrardescripcionEmpleadoIdioma;
	}

	public void setMostrardescripcionEmpleadoIdioma(Boolean mostrardescripcionEmpleadoIdioma) {
		this.mostrardescripcionEmpleadoIdioma= mostrardescripcionEmpleadoIdioma;
	}

	public Boolean getActivardescripcionEmpleadoIdioma() {
		return this.activardescripcionEmpleadoIdioma;
	}

	public void setActivardescripcionEmpleadoIdioma(Boolean activardescripcionEmpleadoIdioma) {
		this.activardescripcionEmpleadoIdioma= activardescripcionEmpleadoIdioma;
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
		
		
		this.setMostraridEmpleadoIdioma(esInicial);
		this.setMostrarid_empresaEmpleadoIdioma(esInicial);
		this.setMostrarid_empleadoEmpleadoIdioma(esInicial);
		this.setMostrarid_idiomaEmpleadoIdioma(esInicial);
		this.setMostrares_maternaEmpleadoIdioma(esInicial);
		this.setMostrares_tecnicoEmpleadoIdioma(esInicial);
		this.setMostrarporcen_tecnicoEmpleadoIdioma(esInicial);
		this.setMostrares_lecturaEmpleadoIdioma(esInicial);
		this.setMostrarporcen_lecturaEmpleadoIdioma(esInicial);
		this.setMostrares_escritoEmpleadoIdioma(esInicial);
		this.setMostrarporcen_escritoEmpleadoIdioma(esInicial);
		this.setMostrares_habladoEmpleadoIdioma(esInicial);
		this.setMostrarporcen_habladoEmpleadoIdioma(esInicial);
		this.setMostrardescripcionEmpleadoIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ID)) {
				this.setMostraridEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDIDIOMA)) {
				this.setMostrarid_idiomaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESMATERNA)) {
				this.setMostrares_maternaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESTECNICO)) {
				this.setMostrares_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENTECNICO)) {
				this.setMostrarporcen_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESLECTURA)) {
				this.setMostrares_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENLECTURA)) {
				this.setMostrarporcen_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESESCRITO)) {
				this.setMostrares_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENESCRITO)) {
				this.setMostrarporcen_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESHABLADO)) {
				this.setMostrares_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENHABLADO)) {
				this.setMostrarporcen_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpleadoIdioma(esAsigna);
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
		
		
		this.setActivaridEmpleadoIdioma(esInicial);
		this.setActivarid_empresaEmpleadoIdioma(esInicial);
		this.setActivarid_empleadoEmpleadoIdioma(esInicial);
		this.setActivarid_idiomaEmpleadoIdioma(esInicial);
		this.setActivares_maternaEmpleadoIdioma(esInicial);
		this.setActivares_tecnicoEmpleadoIdioma(esInicial);
		this.setActivarporcen_tecnicoEmpleadoIdioma(esInicial);
		this.setActivares_lecturaEmpleadoIdioma(esInicial);
		this.setActivarporcen_lecturaEmpleadoIdioma(esInicial);
		this.setActivares_escritoEmpleadoIdioma(esInicial);
		this.setActivarporcen_escritoEmpleadoIdioma(esInicial);
		this.setActivares_habladoEmpleadoIdioma(esInicial);
		this.setActivarporcen_habladoEmpleadoIdioma(esInicial);
		this.setActivardescripcionEmpleadoIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ID)) {
				this.setActivaridEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDIDIOMA)) {
				this.setActivarid_idiomaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESMATERNA)) {
				this.setActivares_maternaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESTECNICO)) {
				this.setActivares_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENTECNICO)) {
				this.setActivarporcen_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESLECTURA)) {
				this.setActivares_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENLECTURA)) {
				this.setActivarporcen_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESESCRITO)) {
				this.setActivares_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENESCRITO)) {
				this.setActivarporcen_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESHABLADO)) {
				this.setActivares_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENHABLADO)) {
				this.setActivarporcen_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpleadoIdioma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoIdioma(esInicial);
		this.setResaltarid_empresaEmpleadoIdioma(esInicial);
		this.setResaltarid_empleadoEmpleadoIdioma(esInicial);
		this.setResaltarid_idiomaEmpleadoIdioma(esInicial);
		this.setResaltares_maternaEmpleadoIdioma(esInicial);
		this.setResaltares_tecnicoEmpleadoIdioma(esInicial);
		this.setResaltarporcen_tecnicoEmpleadoIdioma(esInicial);
		this.setResaltares_lecturaEmpleadoIdioma(esInicial);
		this.setResaltarporcen_lecturaEmpleadoIdioma(esInicial);
		this.setResaltares_escritoEmpleadoIdioma(esInicial);
		this.setResaltarporcen_escritoEmpleadoIdioma(esInicial);
		this.setResaltares_habladoEmpleadoIdioma(esInicial);
		this.setResaltarporcen_habladoEmpleadoIdioma(esInicial);
		this.setResaltardescripcionEmpleadoIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.IDIDIOMA)) {
				this.setResaltarid_idiomaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESMATERNA)) {
				this.setResaltares_maternaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESTECNICO)) {
				this.setResaltares_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENTECNICO)) {
				this.setResaltarporcen_tecnicoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESLECTURA)) {
				this.setResaltares_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENLECTURA)) {
				this.setResaltarporcen_lecturaEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESESCRITO)) {
				this.setResaltares_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENESCRITO)) {
				this.setResaltarporcen_escritoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.ESHABLADO)) {
				this.setResaltares_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.PORCENHABLADO)) {
				this.setResaltarporcen_habladoEmpleadoIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoIdiomaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpleadoIdioma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoIdioma=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoIdioma() {
		return this.mostrarFK_IdEmpleadoEmpleadoIdioma;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoIdioma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoIdioma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoIdioma=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoIdioma() {
		return this.mostrarFK_IdEmpresaEmpleadoIdioma;
	}

	public void setMostrarFK_IdEmpresaEmpleadoIdioma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoIdioma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdIdiomaEmpleadoIdioma=true;

	public Boolean getMostrarFK_IdIdiomaEmpleadoIdioma() {
		return this.mostrarFK_IdIdiomaEmpleadoIdioma;
	}

	public void setMostrarFK_IdIdiomaEmpleadoIdioma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdIdiomaEmpleadoIdioma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoIdioma=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoIdioma() {
		return this.activarFK_IdEmpleadoEmpleadoIdioma;
	}

	public void setActivarFK_IdEmpleadoEmpleadoIdioma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoIdioma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoIdioma=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoIdioma() {
		return this.activarFK_IdEmpresaEmpleadoIdioma;
	}

	public void setActivarFK_IdEmpresaEmpleadoIdioma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoIdioma= habilitarResaltar;
	}

	public Boolean activarFK_IdIdiomaEmpleadoIdioma=true;

	public Boolean getActivarFK_IdIdiomaEmpleadoIdioma() {
		return this.activarFK_IdIdiomaEmpleadoIdioma;
	}

	public void setActivarFK_IdIdiomaEmpleadoIdioma(Boolean habilitarResaltar) {
		this.activarFK_IdIdiomaEmpleadoIdioma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoIdioma=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoIdioma() {
		return this.resaltarFK_IdEmpleadoEmpleadoIdioma;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoIdioma(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoIdioma= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoIdioma= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoIdioma=null;

	public Border getResaltarFK_IdEmpresaEmpleadoIdioma() {
		return this.resaltarFK_IdEmpresaEmpleadoIdioma;
	}

	public void setResaltarFK_IdEmpresaEmpleadoIdioma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoIdioma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoIdioma= borderResaltar;
	}

	public Border resaltarFK_IdIdiomaEmpleadoIdioma=null;

	public Border getResaltarFK_IdIdiomaEmpleadoIdioma() {
		return this.resaltarFK_IdIdiomaEmpleadoIdioma;
	}

	public void setResaltarFK_IdIdiomaEmpleadoIdioma(Border borderResaltar) {
		this.resaltarFK_IdIdiomaEmpleadoIdioma= borderResaltar;
	}

	public void setResaltarFK_IdIdiomaEmpleadoIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoIdiomaBeanSwingJInternalFrame empleadoidiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdIdiomaEmpleadoIdioma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}