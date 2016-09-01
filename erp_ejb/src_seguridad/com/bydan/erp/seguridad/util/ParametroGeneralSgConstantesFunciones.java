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


import com.bydan.erp.seguridad.util.ParametroGeneralSgConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroGeneralSgParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroGeneralSgParameterGeneral;

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
final public class ParametroGeneralSgConstantesFunciones extends ParametroGeneralSgConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroGeneralSg";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroGeneralSg"+ParametroGeneralSgConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroGeneralSgHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroGeneralSgHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroGeneralSgConstantesFunciones.SCHEMA+"_"+ParametroGeneralSgConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralSgHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroGeneralSgConstantesFunciones.SCHEMA+"_"+ParametroGeneralSgConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroGeneralSgConstantesFunciones.SCHEMA+"_"+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralSgHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroGeneralSgConstantesFunciones.SCHEMA+"_"+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralSgHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralSgHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralSgConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroGeneralSgConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroGeneralSgConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroGeneralSgConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroGeneralSgConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Generales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro General";
	public static final String SCLASSWEBTITULO_LOWER="Parametro General Sg";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroGeneralSg";
	public static final String OBJECTNAME="parametrogeneralsg";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="parametro_general_sg";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrogeneralsg from "+ParametroGeneralSgConstantesFunciones.SPERSISTENCENAME+" parametrogeneralsg";
	public static String QUERYSELECTNATIVE="select "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".id,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_simple_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_empresa,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".version_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".siglas_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".mail_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".telefono_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".fax_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".representante_nombre,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".codigo_proceso_actualizacion,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".esta_activo from "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralSgConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroGeneralSgConstantesFuncionesAdditional parametrogeneralsgConstantesFuncionesAdditional=null;
	
	public ParametroGeneralSgConstantesFuncionesAdditional getParametroGeneralSgConstantesFuncionesAdditional() {
		return this.parametrogeneralsgConstantesFuncionesAdditional;
	}
	
	public void setParametroGeneralSgConstantesFuncionesAdditional(ParametroGeneralSgConstantesFuncionesAdditional parametrogeneralsgConstantesFuncionesAdditional) {
		try {
			this.parametrogeneralsgConstantesFuncionesAdditional=parametrogeneralsgConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRESISTEMA= "nombre_sistema";
    public static final String NOMBRESIMPLESISTEMA= "nombre_simple_sistema";
    public static final String NOMBREEMPRESA= "nombre_empresa";
    public static final String VERSIONSISTEMA= "version_sistema";
    public static final String SIGLASSISTEMA= "siglas_sistema";
    public static final String MAILSISTEMA= "mail_sistema";
    public static final String TELEFONOSISTEMA= "telefono_sistema";
    public static final String FAXSISTEMA= "fax_sistema";
    public static final String REPRESENTANTENOMBRE= "representante_nombre";
    public static final String CODIGOPROCESOACTUALIZACION= "codigo_proceso_actualizacion";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRESISTEMA= "Nombre Sistema";
		public static final String LABEL_NOMBRESISTEMA_LOWER= "Nombre Sistema";
    	public static final String LABEL_NOMBRESIMPLESISTEMA= "Nombre Simple Sistema";
		public static final String LABEL_NOMBRESIMPLESISTEMA_LOWER= "Nombre Simple Sistema";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_VERSIONSISTEMA= "Version Sistema";
		public static final String LABEL_VERSIONSISTEMA_LOWER= "Version Sistema";
    	public static final String LABEL_SIGLASSISTEMA= "Siglas Sistema";
		public static final String LABEL_SIGLASSISTEMA_LOWER= "Siglas Sistema";
    	public static final String LABEL_MAILSISTEMA= "Mail Sistema";
		public static final String LABEL_MAILSISTEMA_LOWER= "Mail Sistema";
    	public static final String LABEL_TELEFONOSISTEMA= "Telefono Sistema";
		public static final String LABEL_TELEFONOSISTEMA_LOWER= "Telefono Sistema";
    	public static final String LABEL_FAXSISTEMA= "Fax Sistema";
		public static final String LABEL_FAXSISTEMA_LOWER= "Fax Sistema";
    	public static final String LABEL_REPRESENTANTENOMBRE= "Representante Nombre";
		public static final String LABEL_REPRESENTANTENOMBRE_LOWER= "Representante Nombre";
    	public static final String LABEL_CODIGOPROCESOACTUALIZACION= "Codigo Proceso Actualizacion";
		public static final String LABEL_CODIGOPROCESOACTUALIZACION_LOWER= "Codigo Proceso Actualizacion";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
	public static final String SREGEXNOMBRE_SISTEMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SIMPLE_SISTEMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SIMPLE_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSIGLAS_SISTEMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMAIL_SISTEMA=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXTELEFONO_SISTEMA=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXFAX_SISTEMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX_SISTEMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREPRESENTANTE_NOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE_NOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PROCESO_ACTUALIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PROCESO_ACTUALIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getParametroGeneralSgLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESIMPLESISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_SIGLASSISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.MAILSISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_MAILSISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_TELEFONOSISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.FAXSISTEMA)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_FAXSISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_REPRESENTANTENOMBRE;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_CODIGOPROCESOACTUALIZACION;}
		if(sNombreColumna.equals(ParametroGeneralSgConstantesFunciones.ESTAACTIVO)) {sLabelColumna=ParametroGeneralSgConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(ParametroGeneralSg parametrogeneralsg) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralsg.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(ParametroGeneralSg parametrogeneralsg) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralsg.getId(),parametrogeneralsg.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getParametroGeneralSgDescripcion(ParametroGeneralSg parametrogeneralsg) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrogeneralsg !=null/* && parametrogeneralsg.getId()!=0*/) {
			sDescripcion=parametrogeneralsg.getnombre_simple_sistema();//parametrogeneralsgparametrogeneralsg.getnombre_simple_sistema().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroGeneralSgDescripcionDetallado(ParametroGeneralSg parametrogeneralsg) {
		String sDescripcion="";
			
		sDescripcion+=ParametroGeneralSgConstantesFunciones.ID+"=";
		sDescripcion+=parametrogeneralsg.getId().toString()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrogeneralsg.getVersionRow().toString()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getnombre_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getnombre_simple_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=parametrogeneralsg.getnombre_empresa()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getversion_sistema().toString()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getsiglas_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.MAILSISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getmail_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA+"=";
		sDescripcion+=parametrogeneralsg.gettelefono_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.FAXSISTEMA+"=";
		sDescripcion+=parametrogeneralsg.getfax_sistema()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE+"=";
		sDescripcion+=parametrogeneralsg.getrepresentante_nombre()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION+"=";
		sDescripcion+=parametrogeneralsg.getcodigo_proceso_actualizacion()+",";
		sDescripcion+=ParametroGeneralSgConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=parametrogeneralsg.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroGeneralSgDescripcion(ParametroGeneralSg parametrogeneralsg,String sValor) throws Exception {			
		if(parametrogeneralsg !=null) {
			parametrogeneralsg.setnombre_simple_sistema(sValor);;//parametrogeneralsgparametrogeneralsg.getnombre_simple_sistema().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroGeneralSg(ParametroGeneralSg parametrogeneralsg,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrogeneralsg.setnombre_sistema(parametrogeneralsg.getnombre_sistema().trim());
		parametrogeneralsg.setnombre_simple_sistema(parametrogeneralsg.getnombre_simple_sistema().trim());
		parametrogeneralsg.setnombre_empresa(parametrogeneralsg.getnombre_empresa().trim());
		parametrogeneralsg.setsiglas_sistema(parametrogeneralsg.getsiglas_sistema().trim());
		parametrogeneralsg.setmail_sistema(parametrogeneralsg.getmail_sistema().trim());
		parametrogeneralsg.settelefono_sistema(parametrogeneralsg.gettelefono_sistema().trim());
		parametrogeneralsg.setfax_sistema(parametrogeneralsg.getfax_sistema().trim());
		parametrogeneralsg.setrepresentante_nombre(parametrogeneralsg.getrepresentante_nombre().trim());
		parametrogeneralsg.setcodigo_proceso_actualizacion(parametrogeneralsg.getcodigo_proceso_actualizacion().trim());
	}
	
	public static void quitarEspaciosParametroGeneralSgs(List<ParametroGeneralSg> parametrogeneralsgs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroGeneralSg parametrogeneralsg: parametrogeneralsgs) {
			parametrogeneralsg.setnombre_sistema(parametrogeneralsg.getnombre_sistema().trim());
			parametrogeneralsg.setnombre_simple_sistema(parametrogeneralsg.getnombre_simple_sistema().trim());
			parametrogeneralsg.setnombre_empresa(parametrogeneralsg.getnombre_empresa().trim());
			parametrogeneralsg.setsiglas_sistema(parametrogeneralsg.getsiglas_sistema().trim());
			parametrogeneralsg.setmail_sistema(parametrogeneralsg.getmail_sistema().trim());
			parametrogeneralsg.settelefono_sistema(parametrogeneralsg.gettelefono_sistema().trim());
			parametrogeneralsg.setfax_sistema(parametrogeneralsg.getfax_sistema().trim());
			parametrogeneralsg.setrepresentante_nombre(parametrogeneralsg.getrepresentante_nombre().trim());
			parametrogeneralsg.setcodigo_proceso_actualizacion(parametrogeneralsg.getcodigo_proceso_actualizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGeneralSg(ParametroGeneralSg parametrogeneralsg,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrogeneralsg.getConCambioAuxiliar()) {
			parametrogeneralsg.setIsDeleted(parametrogeneralsg.getIsDeletedAuxiliar());	
			parametrogeneralsg.setIsNew(parametrogeneralsg.getIsNewAuxiliar());	
			parametrogeneralsg.setIsChanged(parametrogeneralsg.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrogeneralsg.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrogeneralsg.setIsDeletedAuxiliar(false);	
			parametrogeneralsg.setIsNewAuxiliar(false);	
			parametrogeneralsg.setIsChangedAuxiliar(false);
			
			parametrogeneralsg.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGeneralSgs(List<ParametroGeneralSg> parametrogeneralsgs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroGeneralSg parametrogeneralsg : parametrogeneralsgs) {
			if(conAsignarBase && parametrogeneralsg.getConCambioAuxiliar()) {
				parametrogeneralsg.setIsDeleted(parametrogeneralsg.getIsDeletedAuxiliar());	
				parametrogeneralsg.setIsNew(parametrogeneralsg.getIsNewAuxiliar());	
				parametrogeneralsg.setIsChanged(parametrogeneralsg.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrogeneralsg.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrogeneralsg.setIsDeletedAuxiliar(false);	
				parametrogeneralsg.setIsNewAuxiliar(false);	
				parametrogeneralsg.setIsChangedAuxiliar(false);
				
				parametrogeneralsg.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroGeneralSg(ParametroGeneralSg parametrogeneralsg,Boolean conEnteros) throws Exception  {
		parametrogeneralsg.setversion_sistema(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroGeneralSgs(List<ParametroGeneralSg> parametrogeneralsgs,Boolean conEnteros) throws Exception  {
		
		for(ParametroGeneralSg parametrogeneralsg: parametrogeneralsgs) {
			parametrogeneralsg.setversion_sistema(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroGeneralSg(List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSg parametrogeneralsgAux) throws Exception  {
		ParametroGeneralSgConstantesFunciones.InicializarValoresParametroGeneralSg(parametrogeneralsgAux,true);
		
		for(ParametroGeneralSg parametrogeneralsg: parametrogeneralsgs) {
			if(parametrogeneralsg.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrogeneralsgAux.setversion_sistema(parametrogeneralsgAux.getversion_sistema()+parametrogeneralsg.getversion_sistema());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneralSg(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroGeneralSgConstantesFunciones.getArrayColumnasGlobalesParametroGeneralSg(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneralSg(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroGeneralSg(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSg parametrogeneralsg,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroGeneralSg parametrogeneralsgAux: parametrogeneralsgs) {
			if(parametrogeneralsgAux!=null && parametrogeneralsg!=null) {
				if((parametrogeneralsgAux.getId()==null && parametrogeneralsg.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrogeneralsgAux.getId()!=null && parametrogeneralsg.getId()!=null){
					if(parametrogeneralsgAux.getId().equals(parametrogeneralsg.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroGeneralSg(List<ParametroGeneralSg> parametrogeneralsgs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double version_sistemaTotal=0.0;
	
		for(ParametroGeneralSg parametrogeneralsg: parametrogeneralsgs) {			
			if(parametrogeneralsg.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			version_sistemaTotal+=parametrogeneralsg.getversion_sistema();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA);
		datoGeneral.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA);
		datoGeneral.setdValorDouble(version_sistemaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroGeneralSg() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_ID, ParametroGeneralSgConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_VERSIONROW, ParametroGeneralSgConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESISTEMA, ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESIMPLESISTEMA, ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_NOMBREEMPRESA, ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA, ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_SIGLASSISTEMA, ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_MAILSISTEMA, ParametroGeneralSgConstantesFunciones.MAILSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_TELEFONOSISTEMA, ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_FAXSISTEMA, ParametroGeneralSgConstantesFunciones.FAXSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_REPRESENTANTENOMBRE, ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_CODIGOPROCESOACTUALIZACION, ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralSgConstantesFunciones.LABEL_ESTAACTIVO, ParametroGeneralSgConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroGeneralSg() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.MAILSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.FAXSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralSgConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralSg() throws Exception  {
		return ParametroGeneralSgConstantesFunciones.getTiposSeleccionarParametroGeneralSg(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralSg(Boolean conFk) throws Exception  {
		return ParametroGeneralSgConstantesFunciones.getTiposSeleccionarParametroGeneralSg(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralSg(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESIMPLESISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESIMPLESISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_SIGLASSISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_SIGLASSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_MAILSISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_MAILSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_TELEFONOSISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_TELEFONOSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_FAXSISTEMA);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_FAXSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_REPRESENTANTENOMBRE);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_REPRESENTANTENOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_CODIGOPROCESOACTUALIZACION);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_CODIGOPROCESOACTUALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralSgConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(ParametroGeneralSgConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroGeneralSg(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneralSg(ParametroGeneralSg parametrogeneralsgAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneralSg(List<ParametroGeneralSg> parametrogeneralsgsTemp) throws Exception {
		for(ParametroGeneralSg parametrogeneralsgAux:parametrogeneralsgsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneralSg(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroGeneralSg(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralSg(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralSgConstantesFunciones.getClassesRelationshipsOfParametroGeneralSg(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralSg(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneralSg(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralSgConstantesFunciones.getClassesRelationshipsFromStringsOfParametroGeneralSg(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneralSg(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ParametroGeneralSg parametrogeneralsg,List<ParametroGeneralSg> parametrogeneralsgs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroGeneralSg parametrogeneralsgEncontrado=null;
			
			for(ParametroGeneralSg parametrogeneralsgLocal:parametrogeneralsgs) {
				if(parametrogeneralsgLocal.getId().equals(parametrogeneralsg.getId())) {
					parametrogeneralsgEncontrado=parametrogeneralsgLocal;
					
					parametrogeneralsgLocal.setIsChanged(parametrogeneralsg.getIsChanged());
					parametrogeneralsgLocal.setIsNew(parametrogeneralsg.getIsNew());
					parametrogeneralsgLocal.setIsDeleted(parametrogeneralsg.getIsDeleted());
					
					parametrogeneralsgLocal.setGeneralEntityOriginal(parametrogeneralsg.getGeneralEntityOriginal());
					
					parametrogeneralsgLocal.setId(parametrogeneralsg.getId());	
					parametrogeneralsgLocal.setVersionRow(parametrogeneralsg.getVersionRow());	
					parametrogeneralsgLocal.setnombre_sistema(parametrogeneralsg.getnombre_sistema());	
					parametrogeneralsgLocal.setnombre_simple_sistema(parametrogeneralsg.getnombre_simple_sistema());	
					parametrogeneralsgLocal.setnombre_empresa(parametrogeneralsg.getnombre_empresa());	
					parametrogeneralsgLocal.setversion_sistema(parametrogeneralsg.getversion_sistema());	
					parametrogeneralsgLocal.setsiglas_sistema(parametrogeneralsg.getsiglas_sistema());	
					parametrogeneralsgLocal.setmail_sistema(parametrogeneralsg.getmail_sistema());	
					parametrogeneralsgLocal.settelefono_sistema(parametrogeneralsg.gettelefono_sistema());	
					parametrogeneralsgLocal.setfax_sistema(parametrogeneralsg.getfax_sistema());	
					parametrogeneralsgLocal.setrepresentante_nombre(parametrogeneralsg.getrepresentante_nombre());	
					parametrogeneralsgLocal.setcodigo_proceso_actualizacion(parametrogeneralsg.getcodigo_proceso_actualizacion());	
					parametrogeneralsgLocal.setesta_activo(parametrogeneralsg.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrogeneralsg.getIsDeleted()) {
				if(!existe) {
					parametrogeneralsgs.add(parametrogeneralsg);
				}
			} else {
				if(parametrogeneralsgEncontrado!=null && permiteQuitar)  {
					parametrogeneralsgs.remove(parametrogeneralsgEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroGeneralSg parametrogeneralsg,List<ParametroGeneralSg> parametrogeneralsgs) throws Exception {
		try	{			
			for(ParametroGeneralSg parametrogeneralsgLocal:parametrogeneralsgs) {
				if(parametrogeneralsgLocal.getId().equals(parametrogeneralsg.getId())) {
					parametrogeneralsgLocal.setIsSelected(parametrogeneralsg.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroGeneralSg(List<ParametroGeneralSg> parametrogeneralsgsAux) throws Exception {
		//this.parametrogeneralsgsAux=parametrogeneralsgsAux;
		
		for(ParametroGeneralSg parametrogeneralsgAux:parametrogeneralsgsAux) {
			if(parametrogeneralsgAux.getIsChanged()) {
				parametrogeneralsgAux.setIsChanged(false);
			}		
			
			if(parametrogeneralsgAux.getIsNew()) {
				parametrogeneralsgAux.setIsNew(false);
			}	
			
			if(parametrogeneralsgAux.getIsDeleted()) {
				parametrogeneralsgAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroGeneralSg(ParametroGeneralSg parametrogeneralsgAux) throws Exception {
		//this.parametrogeneralsgAux=parametrogeneralsgAux;
		
			if(parametrogeneralsgAux.getIsChanged()) {
				parametrogeneralsgAux.setIsChanged(false);
			}		
			
			if(parametrogeneralsgAux.getIsNew()) {
				parametrogeneralsgAux.setIsNew(false);
			}	
			
			if(parametrogeneralsgAux.getIsDeleted()) {
				parametrogeneralsgAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroGeneralSg parametrogeneralsgAsignar,ParametroGeneralSg parametrogeneralsg) throws Exception {
		parametrogeneralsgAsignar.setId(parametrogeneralsg.getId());	
		parametrogeneralsgAsignar.setVersionRow(parametrogeneralsg.getVersionRow());	
		parametrogeneralsgAsignar.setnombre_sistema(parametrogeneralsg.getnombre_sistema());	
		parametrogeneralsgAsignar.setnombre_simple_sistema(parametrogeneralsg.getnombre_simple_sistema());	
		parametrogeneralsgAsignar.setnombre_empresa(parametrogeneralsg.getnombre_empresa());	
		parametrogeneralsgAsignar.setversion_sistema(parametrogeneralsg.getversion_sistema());	
		parametrogeneralsgAsignar.setsiglas_sistema(parametrogeneralsg.getsiglas_sistema());	
		parametrogeneralsgAsignar.setmail_sistema(parametrogeneralsg.getmail_sistema());	
		parametrogeneralsgAsignar.settelefono_sistema(parametrogeneralsg.gettelefono_sistema());	
		parametrogeneralsgAsignar.setfax_sistema(parametrogeneralsg.getfax_sistema());	
		parametrogeneralsgAsignar.setrepresentante_nombre(parametrogeneralsg.getrepresentante_nombre());	
		parametrogeneralsgAsignar.setcodigo_proceso_actualizacion(parametrogeneralsg.getcodigo_proceso_actualizacion());	
		parametrogeneralsgAsignar.setesta_activo(parametrogeneralsg.getesta_activo());	
	}
	
	public static void inicializarParametroGeneralSg(ParametroGeneralSg parametrogeneralsg) throws Exception {
		try {
				parametrogeneralsg.setId(0L);	
					
				parametrogeneralsg.setnombre_sistema("");	
				parametrogeneralsg.setnombre_simple_sistema("");	
				parametrogeneralsg.setnombre_empresa("");	
				parametrogeneralsg.setversion_sistema(0.0);	
				parametrogeneralsg.setsiglas_sistema("");	
				parametrogeneralsg.setmail_sistema("");	
				parametrogeneralsg.settelefono_sistema("");	
				parametrogeneralsg.setfax_sistema("");	
				parametrogeneralsg.setrepresentante_nombre("");	
				parametrogeneralsg.setcodigo_proceso_actualizacion("");	
				parametrogeneralsg.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroGeneralSg(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_NOMBRESIMPLESISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_VERSIONSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_SIGLASSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_MAILSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_TELEFONOSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_FAXSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_REPRESENTANTENOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_CODIGOPROCESOACTUALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralSgConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroGeneralSg(String sTipo,Row row,Workbook workbook,ParametroGeneralSg parametrogeneralsg,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getnombre_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getnombre_simple_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getversion_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getsiglas_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getmail_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.gettelefono_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getfax_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getrepresentante_nombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralsg.getcodigo_proceso_actualizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralsg.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroGeneralSg=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroGeneralSg() {
		return this.sFinalQueryParametroGeneralSg;
	}
	
	public void setsFinalQueryParametroGeneralSg(String sFinalQueryParametroGeneralSg) {
		this.sFinalQueryParametroGeneralSg= sFinalQueryParametroGeneralSg;
	}
	
	public Border resaltarSeleccionarParametroGeneralSg=null;
	
	public Border setResaltarSeleccionarParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroGeneralSg= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroGeneralSg() {
		return this.resaltarSeleccionarParametroGeneralSg;
	}
	
	public void setResaltarSeleccionarParametroGeneralSg(Border borderResaltarSeleccionarParametroGeneralSg) {
		this.resaltarSeleccionarParametroGeneralSg= borderResaltarSeleccionarParametroGeneralSg;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroGeneralSg=null;
	public Boolean mostraridParametroGeneralSg=true;
	public Boolean activaridParametroGeneralSg=true;

	public Border resaltarnombre_sistemaParametroGeneralSg=null;
	public Boolean mostrarnombre_sistemaParametroGeneralSg=true;
	public Boolean activarnombre_sistemaParametroGeneralSg=true;

	public Border resaltarnombre_simple_sistemaParametroGeneralSg=null;
	public Boolean mostrarnombre_simple_sistemaParametroGeneralSg=true;
	public Boolean activarnombre_simple_sistemaParametroGeneralSg=true;

	public Border resaltarnombre_empresaParametroGeneralSg=null;
	public Boolean mostrarnombre_empresaParametroGeneralSg=true;
	public Boolean activarnombre_empresaParametroGeneralSg=true;

	public Border resaltarversion_sistemaParametroGeneralSg=null;
	public Boolean mostrarversion_sistemaParametroGeneralSg=true;
	public Boolean activarversion_sistemaParametroGeneralSg=true;

	public Border resaltarsiglas_sistemaParametroGeneralSg=null;
	public Boolean mostrarsiglas_sistemaParametroGeneralSg=true;
	public Boolean activarsiglas_sistemaParametroGeneralSg=true;

	public Border resaltarmail_sistemaParametroGeneralSg=null;
	public Boolean mostrarmail_sistemaParametroGeneralSg=true;
	public Boolean activarmail_sistemaParametroGeneralSg=true;

	public Border resaltartelefono_sistemaParametroGeneralSg=null;
	public Boolean mostrartelefono_sistemaParametroGeneralSg=true;
	public Boolean activartelefono_sistemaParametroGeneralSg=true;

	public Border resaltarfax_sistemaParametroGeneralSg=null;
	public Boolean mostrarfax_sistemaParametroGeneralSg=true;
	public Boolean activarfax_sistemaParametroGeneralSg=true;

	public Border resaltarrepresentante_nombreParametroGeneralSg=null;
	public Boolean mostrarrepresentante_nombreParametroGeneralSg=true;
	public Boolean activarrepresentante_nombreParametroGeneralSg=true;

	public Border resaltarcodigo_proceso_actualizacionParametroGeneralSg=null;
	public Boolean mostrarcodigo_proceso_actualizacionParametroGeneralSg=true;
	public Boolean activarcodigo_proceso_actualizacionParametroGeneralSg=true;

	public Border resaltaresta_activoParametroGeneralSg=null;
	public Boolean mostraresta_activoParametroGeneralSg=true;
	public Boolean activaresta_activoParametroGeneralSg=true;

	
	

	public Border setResaltaridParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltaridParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroGeneralSg() {
		return this.resaltaridParametroGeneralSg;
	}

	public void setResaltaridParametroGeneralSg(Border borderResaltar) {
		this.resaltaridParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostraridParametroGeneralSg() {
		return this.mostraridParametroGeneralSg;
	}

	public void setMostraridParametroGeneralSg(Boolean mostraridParametroGeneralSg) {
		this.mostraridParametroGeneralSg= mostraridParametroGeneralSg;
	}

	public Boolean getActivaridParametroGeneralSg() {
		return this.activaridParametroGeneralSg;
	}

	public void setActivaridParametroGeneralSg(Boolean activaridParametroGeneralSg) {
		this.activaridParametroGeneralSg= activaridParametroGeneralSg;
	}

	public Border setResaltarnombre_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarnombre_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sistemaParametroGeneralSg() {
		return this.resaltarnombre_sistemaParametroGeneralSg;
	}

	public void setResaltarnombre_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarnombre_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarnombre_sistemaParametroGeneralSg() {
		return this.mostrarnombre_sistemaParametroGeneralSg;
	}

	public void setMostrarnombre_sistemaParametroGeneralSg(Boolean mostrarnombre_sistemaParametroGeneralSg) {
		this.mostrarnombre_sistemaParametroGeneralSg= mostrarnombre_sistemaParametroGeneralSg;
	}

	public Boolean getActivarnombre_sistemaParametroGeneralSg() {
		return this.activarnombre_sistemaParametroGeneralSg;
	}

	public void setActivarnombre_sistemaParametroGeneralSg(Boolean activarnombre_sistemaParametroGeneralSg) {
		this.activarnombre_sistemaParametroGeneralSg= activarnombre_sistemaParametroGeneralSg;
	}

	public Border setResaltarnombre_simple_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarnombre_simple_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_simple_sistemaParametroGeneralSg() {
		return this.resaltarnombre_simple_sistemaParametroGeneralSg;
	}

	public void setResaltarnombre_simple_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarnombre_simple_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarnombre_simple_sistemaParametroGeneralSg() {
		return this.mostrarnombre_simple_sistemaParametroGeneralSg;
	}

	public void setMostrarnombre_simple_sistemaParametroGeneralSg(Boolean mostrarnombre_simple_sistemaParametroGeneralSg) {
		this.mostrarnombre_simple_sistemaParametroGeneralSg= mostrarnombre_simple_sistemaParametroGeneralSg;
	}

	public Boolean getActivarnombre_simple_sistemaParametroGeneralSg() {
		return this.activarnombre_simple_sistemaParametroGeneralSg;
	}

	public void setActivarnombre_simple_sistemaParametroGeneralSg(Boolean activarnombre_simple_sistemaParametroGeneralSg) {
		this.activarnombre_simple_sistemaParametroGeneralSg= activarnombre_simple_sistemaParametroGeneralSg;
	}

	public Border setResaltarnombre_empresaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaParametroGeneralSg() {
		return this.resaltarnombre_empresaParametroGeneralSg;
	}

	public void setResaltarnombre_empresaParametroGeneralSg(Border borderResaltar) {
		this.resaltarnombre_empresaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaParametroGeneralSg() {
		return this.mostrarnombre_empresaParametroGeneralSg;
	}

	public void setMostrarnombre_empresaParametroGeneralSg(Boolean mostrarnombre_empresaParametroGeneralSg) {
		this.mostrarnombre_empresaParametroGeneralSg= mostrarnombre_empresaParametroGeneralSg;
	}

	public Boolean getActivarnombre_empresaParametroGeneralSg() {
		return this.activarnombre_empresaParametroGeneralSg;
	}

	public void setActivarnombre_empresaParametroGeneralSg(Boolean activarnombre_empresaParametroGeneralSg) {
		this.activarnombre_empresaParametroGeneralSg= activarnombre_empresaParametroGeneralSg;
	}

	public Border setResaltarversion_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarversion_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarversion_sistemaParametroGeneralSg() {
		return this.resaltarversion_sistemaParametroGeneralSg;
	}

	public void setResaltarversion_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarversion_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarversion_sistemaParametroGeneralSg() {
		return this.mostrarversion_sistemaParametroGeneralSg;
	}

	public void setMostrarversion_sistemaParametroGeneralSg(Boolean mostrarversion_sistemaParametroGeneralSg) {
		this.mostrarversion_sistemaParametroGeneralSg= mostrarversion_sistemaParametroGeneralSg;
	}

	public Boolean getActivarversion_sistemaParametroGeneralSg() {
		return this.activarversion_sistemaParametroGeneralSg;
	}

	public void setActivarversion_sistemaParametroGeneralSg(Boolean activarversion_sistemaParametroGeneralSg) {
		this.activarversion_sistemaParametroGeneralSg= activarversion_sistemaParametroGeneralSg;
	}

	public Border setResaltarsiglas_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarsiglas_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglas_sistemaParametroGeneralSg() {
		return this.resaltarsiglas_sistemaParametroGeneralSg;
	}

	public void setResaltarsiglas_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarsiglas_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarsiglas_sistemaParametroGeneralSg() {
		return this.mostrarsiglas_sistemaParametroGeneralSg;
	}

	public void setMostrarsiglas_sistemaParametroGeneralSg(Boolean mostrarsiglas_sistemaParametroGeneralSg) {
		this.mostrarsiglas_sistemaParametroGeneralSg= mostrarsiglas_sistemaParametroGeneralSg;
	}

	public Boolean getActivarsiglas_sistemaParametroGeneralSg() {
		return this.activarsiglas_sistemaParametroGeneralSg;
	}

	public void setActivarsiglas_sistemaParametroGeneralSg(Boolean activarsiglas_sistemaParametroGeneralSg) {
		this.activarsiglas_sistemaParametroGeneralSg= activarsiglas_sistemaParametroGeneralSg;
	}

	public Border setResaltarmail_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarmail_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmail_sistemaParametroGeneralSg() {
		return this.resaltarmail_sistemaParametroGeneralSg;
	}

	public void setResaltarmail_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarmail_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarmail_sistemaParametroGeneralSg() {
		return this.mostrarmail_sistemaParametroGeneralSg;
	}

	public void setMostrarmail_sistemaParametroGeneralSg(Boolean mostrarmail_sistemaParametroGeneralSg) {
		this.mostrarmail_sistemaParametroGeneralSg= mostrarmail_sistemaParametroGeneralSg;
	}

	public Boolean getActivarmail_sistemaParametroGeneralSg() {
		return this.activarmail_sistemaParametroGeneralSg;
	}

	public void setActivarmail_sistemaParametroGeneralSg(Boolean activarmail_sistemaParametroGeneralSg) {
		this.activarmail_sistemaParametroGeneralSg= activarmail_sistemaParametroGeneralSg;
	}

	public Border setResaltartelefono_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltartelefono_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_sistemaParametroGeneralSg() {
		return this.resaltartelefono_sistemaParametroGeneralSg;
	}

	public void setResaltartelefono_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltartelefono_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrartelefono_sistemaParametroGeneralSg() {
		return this.mostrartelefono_sistemaParametroGeneralSg;
	}

	public void setMostrartelefono_sistemaParametroGeneralSg(Boolean mostrartelefono_sistemaParametroGeneralSg) {
		this.mostrartelefono_sistemaParametroGeneralSg= mostrartelefono_sistemaParametroGeneralSg;
	}

	public Boolean getActivartelefono_sistemaParametroGeneralSg() {
		return this.activartelefono_sistemaParametroGeneralSg;
	}

	public void setActivartelefono_sistemaParametroGeneralSg(Boolean activartelefono_sistemaParametroGeneralSg) {
		this.activartelefono_sistemaParametroGeneralSg= activartelefono_sistemaParametroGeneralSg;
	}

	public Border setResaltarfax_sistemaParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarfax_sistemaParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfax_sistemaParametroGeneralSg() {
		return this.resaltarfax_sistemaParametroGeneralSg;
	}

	public void setResaltarfax_sistemaParametroGeneralSg(Border borderResaltar) {
		this.resaltarfax_sistemaParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarfax_sistemaParametroGeneralSg() {
		return this.mostrarfax_sistemaParametroGeneralSg;
	}

	public void setMostrarfax_sistemaParametroGeneralSg(Boolean mostrarfax_sistemaParametroGeneralSg) {
		this.mostrarfax_sistemaParametroGeneralSg= mostrarfax_sistemaParametroGeneralSg;
	}

	public Boolean getActivarfax_sistemaParametroGeneralSg() {
		return this.activarfax_sistemaParametroGeneralSg;
	}

	public void setActivarfax_sistemaParametroGeneralSg(Boolean activarfax_sistemaParametroGeneralSg) {
		this.activarfax_sistemaParametroGeneralSg= activarfax_sistemaParametroGeneralSg;
	}

	public Border setResaltarrepresentante_nombreParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarrepresentante_nombreParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentante_nombreParametroGeneralSg() {
		return this.resaltarrepresentante_nombreParametroGeneralSg;
	}

	public void setResaltarrepresentante_nombreParametroGeneralSg(Border borderResaltar) {
		this.resaltarrepresentante_nombreParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarrepresentante_nombreParametroGeneralSg() {
		return this.mostrarrepresentante_nombreParametroGeneralSg;
	}

	public void setMostrarrepresentante_nombreParametroGeneralSg(Boolean mostrarrepresentante_nombreParametroGeneralSg) {
		this.mostrarrepresentante_nombreParametroGeneralSg= mostrarrepresentante_nombreParametroGeneralSg;
	}

	public Boolean getActivarrepresentante_nombreParametroGeneralSg() {
		return this.activarrepresentante_nombreParametroGeneralSg;
	}

	public void setActivarrepresentante_nombreParametroGeneralSg(Boolean activarrepresentante_nombreParametroGeneralSg) {
		this.activarrepresentante_nombreParametroGeneralSg= activarrepresentante_nombreParametroGeneralSg;
	}

	public Border setResaltarcodigo_proceso_actualizacionParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltarcodigo_proceso_actualizacionParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_proceso_actualizacionParametroGeneralSg() {
		return this.resaltarcodigo_proceso_actualizacionParametroGeneralSg;
	}

	public void setResaltarcodigo_proceso_actualizacionParametroGeneralSg(Border borderResaltar) {
		this.resaltarcodigo_proceso_actualizacionParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostrarcodigo_proceso_actualizacionParametroGeneralSg() {
		return this.mostrarcodigo_proceso_actualizacionParametroGeneralSg;
	}

	public void setMostrarcodigo_proceso_actualizacionParametroGeneralSg(Boolean mostrarcodigo_proceso_actualizacionParametroGeneralSg) {
		this.mostrarcodigo_proceso_actualizacionParametroGeneralSg= mostrarcodigo_proceso_actualizacionParametroGeneralSg;
	}

	public Boolean getActivarcodigo_proceso_actualizacionParametroGeneralSg() {
		return this.activarcodigo_proceso_actualizacionParametroGeneralSg;
	}

	public void setActivarcodigo_proceso_actualizacionParametroGeneralSg(Boolean activarcodigo_proceso_actualizacionParametroGeneralSg) {
		this.activarcodigo_proceso_actualizacionParametroGeneralSg= activarcodigo_proceso_actualizacionParametroGeneralSg;
	}

	public Border setResaltaresta_activoParametroGeneralSg(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralsgBeanSwingJInternalFrame.jTtoolBarParametroGeneralSg.setBorder(borderResaltar);
		
		this.resaltaresta_activoParametroGeneralSg= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoParametroGeneralSg() {
		return this.resaltaresta_activoParametroGeneralSg;
	}

	public void setResaltaresta_activoParametroGeneralSg(Border borderResaltar) {
		this.resaltaresta_activoParametroGeneralSg= borderResaltar;
	}

	public Boolean getMostraresta_activoParametroGeneralSg() {
		return this.mostraresta_activoParametroGeneralSg;
	}

	public void setMostraresta_activoParametroGeneralSg(Boolean mostraresta_activoParametroGeneralSg) {
		this.mostraresta_activoParametroGeneralSg= mostraresta_activoParametroGeneralSg;
	}

	public Boolean getActivaresta_activoParametroGeneralSg() {
		return this.activaresta_activoParametroGeneralSg;
	}

	public void setActivaresta_activoParametroGeneralSg(Boolean activaresta_activoParametroGeneralSg) {
		this.activaresta_activoParametroGeneralSg= activaresta_activoParametroGeneralSg;
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
		
		
		this.setMostraridParametroGeneralSg(esInicial);
		this.setMostrarnombre_sistemaParametroGeneralSg(esInicial);
		this.setMostrarnombre_simple_sistemaParametroGeneralSg(esInicial);
		this.setMostrarnombre_empresaParametroGeneralSg(esInicial);
		this.setMostrarversion_sistemaParametroGeneralSg(esInicial);
		this.setMostrarsiglas_sistemaParametroGeneralSg(esInicial);
		this.setMostrarmail_sistemaParametroGeneralSg(esInicial);
		this.setMostrartelefono_sistemaParametroGeneralSg(esInicial);
		this.setMostrarfax_sistemaParametroGeneralSg(esInicial);
		this.setMostrarrepresentante_nombreParametroGeneralSg(esInicial);
		this.setMostrarcodigo_proceso_actualizacionParametroGeneralSg(esInicial);
		this.setMostraresta_activoParametroGeneralSg(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ID)) {
				this.setMostraridParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA)) {
				this.setMostrarnombre_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA)) {
				this.setMostrarnombre_simple_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA)) {
				this.setMostrarversion_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA)) {
				this.setMostrarsiglas_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.MAILSISTEMA)) {
				this.setMostrarmail_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA)) {
				this.setMostrartelefono_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.FAXSISTEMA)) {
				this.setMostrarfax_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setMostrarrepresentante_nombreParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION)) {
				this.setMostrarcodigo_proceso_actualizacionParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoParametroGeneralSg(esAsigna);
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
		
		
		this.setActivaridParametroGeneralSg(esInicial);
		this.setActivarnombre_sistemaParametroGeneralSg(esInicial);
		this.setActivarnombre_simple_sistemaParametroGeneralSg(esInicial);
		this.setActivarnombre_empresaParametroGeneralSg(esInicial);
		this.setActivarversion_sistemaParametroGeneralSg(esInicial);
		this.setActivarsiglas_sistemaParametroGeneralSg(esInicial);
		this.setActivarmail_sistemaParametroGeneralSg(esInicial);
		this.setActivartelefono_sistemaParametroGeneralSg(esInicial);
		this.setActivarfax_sistemaParametroGeneralSg(esInicial);
		this.setActivarrepresentante_nombreParametroGeneralSg(esInicial);
		this.setActivarcodigo_proceso_actualizacionParametroGeneralSg(esInicial);
		this.setActivaresta_activoParametroGeneralSg(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ID)) {
				this.setActivaridParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA)) {
				this.setActivarnombre_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA)) {
				this.setActivarnombre_simple_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA)) {
				this.setActivarversion_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA)) {
				this.setActivarsiglas_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.MAILSISTEMA)) {
				this.setActivarmail_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA)) {
				this.setActivartelefono_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.FAXSISTEMA)) {
				this.setActivarfax_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setActivarrepresentante_nombreParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION)) {
				this.setActivarcodigo_proceso_actualizacionParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoParametroGeneralSg(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroGeneralSg(esInicial);
		this.setResaltarnombre_sistemaParametroGeneralSg(esInicial);
		this.setResaltarnombre_simple_sistemaParametroGeneralSg(esInicial);
		this.setResaltarnombre_empresaParametroGeneralSg(esInicial);
		this.setResaltarversion_sistemaParametroGeneralSg(esInicial);
		this.setResaltarsiglas_sistemaParametroGeneralSg(esInicial);
		this.setResaltarmail_sistemaParametroGeneralSg(esInicial);
		this.setResaltartelefono_sistemaParametroGeneralSg(esInicial);
		this.setResaltarfax_sistemaParametroGeneralSg(esInicial);
		this.setResaltarrepresentante_nombreParametroGeneralSg(esInicial);
		this.setResaltarcodigo_proceso_actualizacionParametroGeneralSg(esInicial);
		this.setResaltaresta_activoParametroGeneralSg(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ID)) {
				this.setResaltaridParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA)) {
				this.setResaltarnombre_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA)) {
				this.setResaltarnombre_simple_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA)) {
				this.setResaltarversion_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA)) {
				this.setResaltarsiglas_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.MAILSISTEMA)) {
				this.setResaltarmail_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA)) {
				this.setResaltartelefono_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.FAXSISTEMA)) {
				this.setResaltarfax_sistemaParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setResaltarrepresentante_nombreParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION)) {
				this.setResaltarcodigo_proceso_actualizacionParametroGeneralSg(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralSgConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoParametroGeneralSg(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralSgBeanSwingJInternalFrame parametrogeneralsgBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}