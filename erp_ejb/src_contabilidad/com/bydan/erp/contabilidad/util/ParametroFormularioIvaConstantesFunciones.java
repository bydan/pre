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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.ParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroFormularioIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFormularioIvaConstantesFunciones extends ParametroFormularioIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFormularioIva"+ParametroFormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+ParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+ParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Formulario Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Formulario Iva";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFormularioIva";
	public static final String OBJECTNAME="parametroformularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroformularioiva from "+ParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" parametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_tipo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_grupo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_sub_grupo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".grupo,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".grupo2,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".codigo_sri,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".porcentaje,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".con_total,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable1,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable2,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable3,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable4,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable5 from "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+ParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFormularioIvaConstantesFuncionesAdditional parametroformularioivaConstantesFuncionesAdditional=null;
	
	public ParametroFormularioIvaConstantesFuncionesAdditional getParametroFormularioIvaConstantesFuncionesAdditional() {
		return this.parametroformularioivaConstantesFuncionesAdditional;
	}
	
	public void setParametroFormularioIvaConstantesFuncionesAdditional(ParametroFormularioIvaConstantesFuncionesAdditional parametroformularioivaConstantesFuncionesAdditional) {
		try {
			this.parametroformularioivaConstantesFuncionesAdditional=parametroformularioivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOPARAMETROFORMULARIOIVA= "id_tipo_parametro_formulario_iva";
    public static final String IDGRUPOPARAMETROFORMULARIOIVA= "id_grupo_parametro_formulario_iva";
    public static final String IDSUBGRUPOPARAMETROFORMULARIOIVA= "id_sub_grupo_parametro_formulario_iva";
    public static final String GRUPO= "grupo";
    public static final String GRUPO2= "grupo2";
    public static final String CODIGOSRI= "codigo_sri";
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJE= "porcentaje";
    public static final String CONTOTAL= "con_total";
    public static final String IDCUENTACONTABLE1= "id_cuenta_contable1";
    public static final String IDCUENTACONTABLE2= "id_cuenta_contable2";
    public static final String IDCUENTACONTABLE3= "id_cuenta_contable3";
    public static final String IDCUENTACONTABLE4= "id_cuenta_contable4";
    public static final String IDCUENTACONTABLE5= "id_cuenta_contable5";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOPARAMETROFORMULARIOIVA= "Tipo Parametro";
		public static final String LABEL_IDTIPOPARAMETROFORMULARIOIVA_LOWER= "Tipo Parametro Formulario Iva";
    	public static final String LABEL_IDGRUPOPARAMETROFORMULARIOIVA= "Grupo Parametro";
		public static final String LABEL_IDGRUPOPARAMETROFORMULARIOIVA_LOWER= "Grupo Parametro Formulario Iva";
    	public static final String LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA= "Sub Grupo Parametro";
		public static final String LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA_LOWER= "Sub Grupo Parametro Formulario Iva";
    	public static final String LABEL_GRUPO= "Grupo";
		public static final String LABEL_GRUPO_LOWER= "Grupo";
    	public static final String LABEL_GRUPO2= "Grupo 2";
		public static final String LABEL_GRUPO2_LOWER= "Grupo2";
    	public static final String LABEL_CODIGOSRI= "Codigo Sri";
		public static final String LABEL_CODIGOSRI_LOWER= "Codigo Sri";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_CONTOTAL= "Con Total";
		public static final String LABEL_CONTOTAL_LOWER= "Con Total";
    	public static final String LABEL_IDCUENTACONTABLE1= "Cuenta C. 1";
		public static final String LABEL_IDCUENTACONTABLE1_LOWER= "Cuenta Contable1";
    	public static final String LABEL_IDCUENTACONTABLE2= "Cuenta C. 2";
		public static final String LABEL_IDCUENTACONTABLE2_LOWER= "Cuenta Contable2";
    	public static final String LABEL_IDCUENTACONTABLE3= "Cuenta C. 3";
		public static final String LABEL_IDCUENTACONTABLE3_LOWER= "Cuenta Contable3";
    	public static final String LABEL_IDCUENTACONTABLE4= "Cuenta C. 4";
		public static final String LABEL_IDCUENTACONTABLE4_LOWER= "Cuenta Contable4";
    	public static final String LABEL_IDCUENTACONTABLE5= "Cuenta C. 5";
		public static final String LABEL_IDCUENTACONTABLE5_LOWER= "Cuenta Contable5";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_SRI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SRI=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getParametroFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDTIPOPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.GRUPO)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.GRUPO2)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO2;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.NOMBRE)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.PORCENTAJE)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.CONTOTAL)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_CONTOTAL;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE1;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE2;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE3;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE4;}
		if(sNombreColumna.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5)) {sLabelColumna=ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE5;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_totalDescripcion(ParametroFormularioIva parametroformularioiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroformularioiva.getcon_total()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_totalHtmlDescripcion(ParametroFormularioIva parametroformularioiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroformularioiva.getId(),parametroformularioiva.getcon_total());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getParametroFormularioIvaDescripcion(ParametroFormularioIva parametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroformularioiva !=null/* && parametroformularioiva.getId()!=0*/) {
			sDescripcion=parametroformularioiva.getcodigo_sri();//parametroformularioivaparametroformularioiva.getcodigo_sri().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFormularioIvaDescripcionDetallado(ParametroFormularioIva parametroformularioiva) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=parametroformularioiva.getId().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroformularioiva.getVersionRow().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroformularioiva.getid_empresa().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=parametroformularioiva.getid_tipo_parametro_formulario_iva().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=parametroformularioiva.getid_grupo_parametro_formulario_iva().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=parametroformularioiva.getid_sub_grupo_parametro_formulario_iva().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.GRUPO+"=";
		sDescripcion+=parametroformularioiva.getgrupo().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.GRUPO2+"=";
		sDescripcion+=parametroformularioiva.getgrupo2().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.CODIGOSRI+"=";
		sDescripcion+=parametroformularioiva.getcodigo_sri()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=parametroformularioiva.getnombre()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=parametroformularioiva.getporcentaje().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.CONTOTAL+"=";
		sDescripcion+=parametroformularioiva.getcon_total().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1+"=";
		sDescripcion+=parametroformularioiva.getid_cuenta_contable1().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2+"=";
		sDescripcion+=parametroformularioiva.getid_cuenta_contable2().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3+"=";
		sDescripcion+=parametroformularioiva.getid_cuenta_contable3().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4+"=";
		sDescripcion+=parametroformularioiva.getid_cuenta_contable4().toString()+",";
		sDescripcion+=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5+"=";
		sDescripcion+=parametroformularioiva.getid_cuenta_contable5().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFormularioIvaDescripcion(ParametroFormularioIva parametroformularioiva,String sValor) throws Exception {			
		if(parametroformularioiva !=null) {
			parametroformularioiva.setcodigo_sri(sValor);;//parametroformularioivaparametroformularioiva.getcodigo_sri().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoParametroFormularioIvaDescripcion(TipoParametroFormularioIva tipoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparametroformularioiva!=null/*&&tipoparametroformularioiva.getId()>0*/) {
			sDescripcion=TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaDescripcion(tipoparametroformularioiva);
		}

		return sDescripcion;
	}

	public static String getGrupoParametroFormularioIvaDescripcion(GrupoParametroFormularioIva grupoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupoparametroformularioiva!=null/*&&grupoparametroformularioiva.getId()>0*/) {
			sDescripcion=GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(grupoparametroformularioiva);
		}

		return sDescripcion;
	}

	public static String getSubGrupoParametroFormularioIvaDescripcion(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subgrupoparametroformularioiva!=null/*&&subgrupoparametroformularioiva.getId()>0*/) {
			sDescripcion=SubGrupoParametroFormularioIvaConstantesFunciones.getSubGrupoParametroFormularioIvaDescripcion(subgrupoparametroformularioiva);
		}

		return sDescripcion;
	}

	public static String getCuentaContable1Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContable2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContable3Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContable4Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContable5Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable1")) {
			sNombreIndice="Tipo=  Por Cuenta C. 1";
		} else if(sNombreIndice.equals("FK_IdCuentaContable2")) {
			sNombreIndice="Tipo=  Por Cuenta C. 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContable3")) {
			sNombreIndice="Tipo=  Por Cuenta C. 3";
		} else if(sNombreIndice.equals("FK_IdCuentaContable4")) {
			sNombreIndice="Tipo=  Por Cuenta C. 4";
		} else if(sNombreIndice.equals("FK_IdCuentaContable5")) {
			sNombreIndice="Tipo=  Por Cuenta C. 5";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Grupo Parametro";
		} else if(sNombreIndice.equals("FK_IdSubGrupoParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Sub Grupo Parametro";
		} else if(sNombreIndice.equals("FK_IdTipoParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Tipo Parametro";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable1(Long id_cuenta_contable1) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable1!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. 1="+id_cuenta_contable1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable2(Long id_cuenta_contable2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. 2="+id_cuenta_contable2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable3(Long id_cuenta_contable3) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable3!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. 3="+id_cuenta_contable3.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable4(Long id_cuenta_contable4) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable4!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. 4="+id_cuenta_contable4.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable5(Long id_cuenta_contable5) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable5!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. 5="+id_cuenta_contable5.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoParametroFormularioIva(Long id_grupo_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Grupo Parametro="+id_grupo_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubGrupoParametroFormularioIva(Long id_sub_grupo_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_grupo_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Sub Grupo Parametro="+id_sub_grupo_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoParametroFormularioIva(Long id_tipo_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Parametro="+id_tipo_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFormularioIva(ParametroFormularioIva parametroformularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametroformularioiva.setcodigo_sri(parametroformularioiva.getcodigo_sri().trim());
		parametroformularioiva.setnombre(parametroformularioiva.getnombre().trim());
	}
	
	public static void quitarEspaciosParametroFormularioIvas(List<ParametroFormularioIva> parametroformularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFormularioIva parametroformularioiva: parametroformularioivas) {
			parametroformularioiva.setcodigo_sri(parametroformularioiva.getcodigo_sri().trim());
			parametroformularioiva.setnombre(parametroformularioiva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFormularioIva(ParametroFormularioIva parametroformularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroformularioiva.getConCambioAuxiliar()) {
			parametroformularioiva.setIsDeleted(parametroformularioiva.getIsDeletedAuxiliar());	
			parametroformularioiva.setIsNew(parametroformularioiva.getIsNewAuxiliar());	
			parametroformularioiva.setIsChanged(parametroformularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroformularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroformularioiva.setIsDeletedAuxiliar(false);	
			parametroformularioiva.setIsNewAuxiliar(false);	
			parametroformularioiva.setIsChangedAuxiliar(false);
			
			parametroformularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFormularioIvas(List<ParametroFormularioIva> parametroformularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFormularioIva parametroformularioiva : parametroformularioivas) {
			if(conAsignarBase && parametroformularioiva.getConCambioAuxiliar()) {
				parametroformularioiva.setIsDeleted(parametroformularioiva.getIsDeletedAuxiliar());	
				parametroformularioiva.setIsNew(parametroformularioiva.getIsNewAuxiliar());	
				parametroformularioiva.setIsChanged(parametroformularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroformularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroformularioiva.setIsDeletedAuxiliar(false);	
				parametroformularioiva.setIsNewAuxiliar(false);	
				parametroformularioiva.setIsChangedAuxiliar(false);
				
				parametroformularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFormularioIva(ParametroFormularioIva parametroformularioiva,Boolean conEnteros) throws Exception  {
		parametroformularioiva.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroformularioiva.setgrupo(0);
			parametroformularioiva.setgrupo2(0);
		}
	}		
	
	public static void InicializarValoresParametroFormularioIvas(List<ParametroFormularioIva> parametroformularioivas,Boolean conEnteros) throws Exception  {
		
		for(ParametroFormularioIva parametroformularioiva: parametroformularioivas) {
			parametroformularioiva.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroformularioiva.setgrupo(0);
				parametroformularioiva.setgrupo2(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFormularioIva(List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIva parametroformularioivaAux) throws Exception  {
		ParametroFormularioIvaConstantesFunciones.InicializarValoresParametroFormularioIva(parametroformularioivaAux,true);
		
		for(ParametroFormularioIva parametroformularioiva: parametroformularioivas) {
			if(parametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametroformularioivaAux.setgrupo(parametroformularioivaAux.getgrupo()+parametroformularioiva.getgrupo());			
			parametroformularioivaAux.setgrupo2(parametroformularioivaAux.getgrupo2()+parametroformularioiva.getgrupo2());			
			parametroformularioivaAux.setporcentaje(parametroformularioivaAux.getporcentaje()+parametroformularioiva.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFormularioIvaConstantesFunciones.getArrayColumnasGlobalesParametroFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFormularioIvaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIva parametroformularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFormularioIva parametroformularioivaAux: parametroformularioivas) {
			if(parametroformularioivaAux!=null && parametroformularioiva!=null) {
				if((parametroformularioivaAux.getId()==null && parametroformularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroformularioivaAux.getId()!=null && parametroformularioiva.getId()!=null){
					if(parametroformularioivaAux.getId().equals(parametroformularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFormularioIva(List<ParametroFormularioIva> parametroformularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ParametroFormularioIva parametroformularioiva: parametroformularioivas) {			
			if(parametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=parametroformularioiva.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroFormularioIvaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_ID, ParametroFormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_VERSIONROW, ParametroFormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA, ParametroFormularioIvaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDTIPOPARAMETROFORMULARIOIVA, ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA, ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA, ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO, ParametroFormularioIvaConstantesFunciones.GRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO2, ParametroFormularioIvaConstantesFunciones.GRUPO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI, ParametroFormularioIvaConstantesFunciones.CODIGOSRI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE, ParametroFormularioIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE, ParametroFormularioIvaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_CONTOTAL, ParametroFormularioIvaConstantesFunciones.CONTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE1, ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE2, ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE3, ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE4, ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE5, ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.GRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.GRUPO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.CODIGOSRI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.CONTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFormularioIva() throws Exception  {
		return ParametroFormularioIvaConstantesFunciones.getTiposSeleccionarParametroFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFormularioIva(Boolean conFk) throws Exception  {
		return ParametroFormularioIvaConstantesFunciones.getTiposSeleccionarParametroFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDTIPOPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDTIPOPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO2);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_CONTOTAL);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_CONTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE1);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE2);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE3);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE4);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE5);
			reporte.setsDescripcion(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFormularioIva(ParametroFormularioIva parametroformularioivaAux) throws Exception {
		
			parametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroformularioivaAux.getEmpresa()));
			parametroformularioivaAux.settipoparametroformularioiva_descripcion(TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaDescripcion(parametroformularioivaAux.getTipoParametroFormularioIva()));
			parametroformularioivaAux.setgrupoparametroformularioiva_descripcion(GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(parametroformularioivaAux.getGrupoParametroFormularioIva()));
			parametroformularioivaAux.setsubgrupoparametroformularioiva_descripcion(SubGrupoParametroFormularioIvaConstantesFunciones.getSubGrupoParametroFormularioIvaDescripcion(parametroformularioivaAux.getSubGrupoParametroFormularioIva()));
			parametroformularioivaAux.setcuentacontable1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable1()));
			parametroformularioivaAux.setcuentacontable2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable2()));
			parametroformularioivaAux.setcuentacontable3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable3()));
			parametroformularioivaAux.setcuentacontable4_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable4()));
			parametroformularioivaAux.setcuentacontable5_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable5()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFormularioIva(List<ParametroFormularioIva> parametroformularioivasTemp) throws Exception {
		for(ParametroFormularioIva parametroformularioivaAux:parametroformularioivasTemp) {
			
			parametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroformularioivaAux.getEmpresa()));
			parametroformularioivaAux.settipoparametroformularioiva_descripcion(TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaDescripcion(parametroformularioivaAux.getTipoParametroFormularioIva()));
			parametroformularioivaAux.setgrupoparametroformularioiva_descripcion(GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(parametroformularioivaAux.getGrupoParametroFormularioIva()));
			parametroformularioivaAux.setsubgrupoparametroformularioiva_descripcion(SubGrupoParametroFormularioIvaConstantesFunciones.getSubGrupoParametroFormularioIvaDescripcion(parametroformularioivaAux.getSubGrupoParametroFormularioIva()));
			parametroformularioivaAux.setcuentacontable1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable1()));
			parametroformularioivaAux.setcuentacontable2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable2()));
			parametroformularioivaAux.setcuentacontable3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable3()));
			parametroformularioivaAux.setcuentacontable4_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable4()));
			parametroformularioivaAux.setcuentacontable5_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroformularioivaAux.getCuentaContable5()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoParametroFormularioIva.class));
				classes.add(new Classe(GrupoParametroFormularioIva.class));
				classes.add(new Classe(SubGrupoParametroFormularioIva.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoParametroFormularioIva.class)) {
						classes.add(new Classe(TipoParametroFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
						classes.add(new Classe(SubGrupoParametroFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParametroFormularioIva.class)); continue;
					}

					if(GrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class)); continue;
					}

					if(SubGrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoParametroFormularioIva.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParametroFormularioIva.class)); continue;
					}

					if(GrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class)); continue;
					}

					if(SubGrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoParametroFormularioIva.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfParametroFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormularioRenta.class));
				classes.add(new Classe(FormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRenta.class)) {
						classes.add(new Classe(FormularioRenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioIva.class)) {
						classes.add(new Classe(FormularioIva.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta.class)); continue;
					}

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta.class)); continue;
					}

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ParametroFormularioIva parametroformularioiva,List<ParametroFormularioIva> parametroformularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFormularioIva parametroformularioivaEncontrado=null;
			
			for(ParametroFormularioIva parametroformularioivaLocal:parametroformularioivas) {
				if(parametroformularioivaLocal.getId().equals(parametroformularioiva.getId())) {
					parametroformularioivaEncontrado=parametroformularioivaLocal;
					
					parametroformularioivaLocal.setIsChanged(parametroformularioiva.getIsChanged());
					parametroformularioivaLocal.setIsNew(parametroformularioiva.getIsNew());
					parametroformularioivaLocal.setIsDeleted(parametroformularioiva.getIsDeleted());
					
					parametroformularioivaLocal.setGeneralEntityOriginal(parametroformularioiva.getGeneralEntityOriginal());
					
					parametroformularioivaLocal.setId(parametroformularioiva.getId());	
					parametroformularioivaLocal.setVersionRow(parametroformularioiva.getVersionRow());	
					parametroformularioivaLocal.setid_empresa(parametroformularioiva.getid_empresa());	
					parametroformularioivaLocal.setid_tipo_parametro_formulario_iva(parametroformularioiva.getid_tipo_parametro_formulario_iva());	
					parametroformularioivaLocal.setid_grupo_parametro_formulario_iva(parametroformularioiva.getid_grupo_parametro_formulario_iva());	
					parametroformularioivaLocal.setid_sub_grupo_parametro_formulario_iva(parametroformularioiva.getid_sub_grupo_parametro_formulario_iva());	
					parametroformularioivaLocal.setgrupo(parametroformularioiva.getgrupo());	
					parametroformularioivaLocal.setgrupo2(parametroformularioiva.getgrupo2());	
					parametroformularioivaLocal.setcodigo_sri(parametroformularioiva.getcodigo_sri());	
					parametroformularioivaLocal.setnombre(parametroformularioiva.getnombre());	
					parametroformularioivaLocal.setporcentaje(parametroformularioiva.getporcentaje());	
					parametroformularioivaLocal.setcon_total(parametroformularioiva.getcon_total());	
					parametroformularioivaLocal.setid_cuenta_contable1(parametroformularioiva.getid_cuenta_contable1());	
					parametroformularioivaLocal.setid_cuenta_contable2(parametroformularioiva.getid_cuenta_contable2());	
					parametroformularioivaLocal.setid_cuenta_contable3(parametroformularioiva.getid_cuenta_contable3());	
					parametroformularioivaLocal.setid_cuenta_contable4(parametroformularioiva.getid_cuenta_contable4());	
					parametroformularioivaLocal.setid_cuenta_contable5(parametroformularioiva.getid_cuenta_contable5());	
					
					
					parametroformularioivaLocal.setFormularioRentas(parametroformularioiva.getFormularioRentas());
					parametroformularioivaLocal.setFormularioIvas(parametroformularioiva.getFormularioIvas());
					
					existe=true;
					break;
				}
			}
			
			if(!parametroformularioiva.getIsDeleted()) {
				if(!existe) {
					parametroformularioivas.add(parametroformularioiva);
				}
			} else {
				if(parametroformularioivaEncontrado!=null && permiteQuitar)  {
					parametroformularioivas.remove(parametroformularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFormularioIva parametroformularioiva,List<ParametroFormularioIva> parametroformularioivas) throws Exception {
		try	{			
			for(ParametroFormularioIva parametroformularioivaLocal:parametroformularioivas) {
				if(parametroformularioivaLocal.getId().equals(parametroformularioiva.getId())) {
					parametroformularioivaLocal.setIsSelected(parametroformularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFormularioIva(List<ParametroFormularioIva> parametroformularioivasAux) throws Exception {
		//this.parametroformularioivasAux=parametroformularioivasAux;
		
		for(ParametroFormularioIva parametroformularioivaAux:parametroformularioivasAux) {
			if(parametroformularioivaAux.getIsChanged()) {
				parametroformularioivaAux.setIsChanged(false);
			}		
			
			if(parametroformularioivaAux.getIsNew()) {
				parametroformularioivaAux.setIsNew(false);
			}	
			
			if(parametroformularioivaAux.getIsDeleted()) {
				parametroformularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFormularioIva(ParametroFormularioIva parametroformularioivaAux) throws Exception {
		//this.parametroformularioivaAux=parametroformularioivaAux;
		
			if(parametroformularioivaAux.getIsChanged()) {
				parametroformularioivaAux.setIsChanged(false);
			}		
			
			if(parametroformularioivaAux.getIsNew()) {
				parametroformularioivaAux.setIsNew(false);
			}	
			
			if(parametroformularioivaAux.getIsDeleted()) {
				parametroformularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFormularioIva parametroformularioivaAsignar,ParametroFormularioIva parametroformularioiva) throws Exception {
		parametroformularioivaAsignar.setId(parametroformularioiva.getId());	
		parametroformularioivaAsignar.setVersionRow(parametroformularioiva.getVersionRow());	
		parametroformularioivaAsignar.setid_empresa(parametroformularioiva.getid_empresa());
		parametroformularioivaAsignar.setempresa_descripcion(parametroformularioiva.getempresa_descripcion());	
		parametroformularioivaAsignar.setid_tipo_parametro_formulario_iva(parametroformularioiva.getid_tipo_parametro_formulario_iva());
		parametroformularioivaAsignar.settipoparametroformularioiva_descripcion(parametroformularioiva.gettipoparametroformularioiva_descripcion());	
		parametroformularioivaAsignar.setid_grupo_parametro_formulario_iva(parametroformularioiva.getid_grupo_parametro_formulario_iva());
		parametroformularioivaAsignar.setgrupoparametroformularioiva_descripcion(parametroformularioiva.getgrupoparametroformularioiva_descripcion());	
		parametroformularioivaAsignar.setid_sub_grupo_parametro_formulario_iva(parametroformularioiva.getid_sub_grupo_parametro_formulario_iva());
		parametroformularioivaAsignar.setsubgrupoparametroformularioiva_descripcion(parametroformularioiva.getsubgrupoparametroformularioiva_descripcion());	
		parametroformularioivaAsignar.setgrupo(parametroformularioiva.getgrupo());	
		parametroformularioivaAsignar.setgrupo2(parametroformularioiva.getgrupo2());	
		parametroformularioivaAsignar.setcodigo_sri(parametroformularioiva.getcodigo_sri());	
		parametroformularioivaAsignar.setnombre(parametroformularioiva.getnombre());	
		parametroformularioivaAsignar.setporcentaje(parametroformularioiva.getporcentaje());	
		parametroformularioivaAsignar.setcon_total(parametroformularioiva.getcon_total());	
		parametroformularioivaAsignar.setid_cuenta_contable1(parametroformularioiva.getid_cuenta_contable1());
		parametroformularioivaAsignar.setcuentacontable1_descripcion(parametroformularioiva.getcuentacontable1_descripcion());	
		parametroformularioivaAsignar.setid_cuenta_contable2(parametroformularioiva.getid_cuenta_contable2());
		parametroformularioivaAsignar.setcuentacontable2_descripcion(parametroformularioiva.getcuentacontable2_descripcion());	
		parametroformularioivaAsignar.setid_cuenta_contable3(parametroformularioiva.getid_cuenta_contable3());
		parametroformularioivaAsignar.setcuentacontable3_descripcion(parametroformularioiva.getcuentacontable3_descripcion());	
		parametroformularioivaAsignar.setid_cuenta_contable4(parametroformularioiva.getid_cuenta_contable4());
		parametroformularioivaAsignar.setcuentacontable4_descripcion(parametroformularioiva.getcuentacontable4_descripcion());	
		parametroformularioivaAsignar.setid_cuenta_contable5(parametroformularioiva.getid_cuenta_contable5());
		parametroformularioivaAsignar.setcuentacontable5_descripcion(parametroformularioiva.getcuentacontable5_descripcion());	
	}
	
	public static void inicializarParametroFormularioIva(ParametroFormularioIva parametroformularioiva) throws Exception {
		try {
				parametroformularioiva.setId(0L);	
					
				parametroformularioiva.setid_empresa(-1L);	
				parametroformularioiva.setid_tipo_parametro_formulario_iva(-1L);	
				parametroformularioiva.setid_grupo_parametro_formulario_iva(-1L);	
				parametroformularioiva.setid_sub_grupo_parametro_formulario_iva(-1L);	
				parametroformularioiva.setgrupo(0);	
				parametroformularioiva.setgrupo2(0);	
				parametroformularioiva.setcodigo_sri("");	
				parametroformularioiva.setnombre("");	
				parametroformularioiva.setporcentaje(0.0);	
				parametroformularioiva.setcon_total(false);	
				parametroformularioiva.setid_cuenta_contable1(null);	
				parametroformularioiva.setid_cuenta_contable2(null);	
				parametroformularioiva.setid_cuenta_contable3(null);	
				parametroformularioiva.setid_cuenta_contable4(null);	
				parametroformularioiva.setid_cuenta_contable5(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDTIPOPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDSUBGRUPOPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_GRUPO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_CONTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFormularioIvaConstantesFunciones.LABEL_IDCUENTACONTABLE5);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFormularioIva(String sTipo,Row row,Workbook workbook,ParametroFormularioIva parametroformularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.gettipoparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getgrupoparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getsubgrupoparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getgrupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getgrupo2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcodigo_sri());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroformularioiva.getcon_total()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcuentacontable1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcuentacontable2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcuentacontable3_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcuentacontable4_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroformularioiva.getcuentacontable5_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFormularioIva() {
		return this.sFinalQueryParametroFormularioIva;
	}
	
	public void setsFinalQueryParametroFormularioIva(String sFinalQueryParametroFormularioIva) {
		this.sFinalQueryParametroFormularioIva= sFinalQueryParametroFormularioIva;
	}
	
	public Border resaltarSeleccionarParametroFormularioIva=null;
	
	public Border setResaltarSeleccionarParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFormularioIva() {
		return this.resaltarSeleccionarParametroFormularioIva;
	}
	
	public void setResaltarSeleccionarParametroFormularioIva(Border borderResaltarSeleccionarParametroFormularioIva) {
		this.resaltarSeleccionarParametroFormularioIva= borderResaltarSeleccionarParametroFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFormularioIva=null;
	public Boolean mostraridParametroFormularioIva=true;
	public Boolean activaridParametroFormularioIva=true;

	public Border resaltarid_empresaParametroFormularioIva=null;
	public Boolean mostrarid_empresaParametroFormularioIva=true;
	public Boolean activarid_empresaParametroFormularioIva=true;
	public Boolean cargarid_empresaParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_tipo_parametro_formulario_ivaParametroFormularioIva=null;
	public Boolean mostrarid_tipo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean activarid_tipo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean cargarid_tipo_parametro_formulario_ivaParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_parametro_formulario_ivaParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_grupo_parametro_formulario_ivaParametroFormularioIva=null;
	public Boolean mostrarid_grupo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean activarid_grupo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean cargarid_grupo_parametro_formulario_ivaParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_parametro_formulario_ivaParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva=null;
	public Boolean mostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean activarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva=true;
	public Boolean cargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_grupo_parametro_formulario_ivaParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltargrupoParametroFormularioIva=null;
	public Boolean mostrargrupoParametroFormularioIva=true;
	public Boolean activargrupoParametroFormularioIva=true;

	public Border resaltargrupo2ParametroFormularioIva=null;
	public Boolean mostrargrupo2ParametroFormularioIva=true;
	public Boolean activargrupo2ParametroFormularioIva=true;

	public Border resaltarcodigo_sriParametroFormularioIva=null;
	public Boolean mostrarcodigo_sriParametroFormularioIva=true;
	public Boolean activarcodigo_sriParametroFormularioIva=true;

	public Border resaltarnombreParametroFormularioIva=null;
	public Boolean mostrarnombreParametroFormularioIva=true;
	public Boolean activarnombreParametroFormularioIva=true;

	public Border resaltarporcentajeParametroFormularioIva=null;
	public Boolean mostrarporcentajeParametroFormularioIva=true;
	public Boolean activarporcentajeParametroFormularioIva=true;

	public Border resaltarcon_totalParametroFormularioIva=null;
	public Boolean mostrarcon_totalParametroFormularioIva=true;
	public Boolean activarcon_totalParametroFormularioIva=true;

	public Border resaltarid_cuenta_contable1ParametroFormularioIva=null;
	public Boolean mostrarid_cuenta_contable1ParametroFormularioIva=true;
	public Boolean activarid_cuenta_contable1ParametroFormularioIva=true;
	public Boolean cargarid_cuenta_contable1ParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable1ParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable2ParametroFormularioIva=null;
	public Boolean mostrarid_cuenta_contable2ParametroFormularioIva=true;
	public Boolean activarid_cuenta_contable2ParametroFormularioIva=true;
	public Boolean cargarid_cuenta_contable2ParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable2ParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable3ParametroFormularioIva=null;
	public Boolean mostrarid_cuenta_contable3ParametroFormularioIva=true;
	public Boolean activarid_cuenta_contable3ParametroFormularioIva=true;
	public Boolean cargarid_cuenta_contable3ParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable3ParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable4ParametroFormularioIva=null;
	public Boolean mostrarid_cuenta_contable4ParametroFormularioIva=true;
	public Boolean activarid_cuenta_contable4ParametroFormularioIva=true;
	public Boolean cargarid_cuenta_contable4ParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable4ParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable5ParametroFormularioIva=null;
	public Boolean mostrarid_cuenta_contable5ParametroFormularioIva=true;
	public Boolean activarid_cuenta_contable5ParametroFormularioIva=true;
	public Boolean cargarid_cuenta_contable5ParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable5ParametroFormularioIva=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFormularioIva() {
		return this.resaltaridParametroFormularioIva;
	}

	public void setResaltaridParametroFormularioIva(Border borderResaltar) {
		this.resaltaridParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostraridParametroFormularioIva() {
		return this.mostraridParametroFormularioIva;
	}

	public void setMostraridParametroFormularioIva(Boolean mostraridParametroFormularioIva) {
		this.mostraridParametroFormularioIva= mostraridParametroFormularioIva;
	}

	public Boolean getActivaridParametroFormularioIva() {
		return this.activaridParametroFormularioIva;
	}

	public void setActivaridParametroFormularioIva(Boolean activaridParametroFormularioIva) {
		this.activaridParametroFormularioIva= activaridParametroFormularioIva;
	}

	public Border setResaltarid_empresaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFormularioIva() {
		return this.resaltarid_empresaParametroFormularioIva;
	}

	public void setResaltarid_empresaParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_empresaParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFormularioIva() {
		return this.mostrarid_empresaParametroFormularioIva;
	}

	public void setMostrarid_empresaParametroFormularioIva(Boolean mostrarid_empresaParametroFormularioIva) {
		this.mostrarid_empresaParametroFormularioIva= mostrarid_empresaParametroFormularioIva;
	}

	public Boolean getActivarid_empresaParametroFormularioIva() {
		return this.activarid_empresaParametroFormularioIva;
	}

	public void setActivarid_empresaParametroFormularioIva(Boolean activarid_empresaParametroFormularioIva) {
		this.activarid_empresaParametroFormularioIva= activarid_empresaParametroFormularioIva;
	}

	public Boolean getCargarid_empresaParametroFormularioIva() {
		return this.cargarid_empresaParametroFormularioIva;
	}

	public void setCargarid_empresaParametroFormularioIva(Boolean cargarid_empresaParametroFormularioIva) {
		this.cargarid_empresaParametroFormularioIva= cargarid_empresaParametroFormularioIva;
	}

	public Border setResaltarid_tipo_parametro_formulario_ivaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_tipo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_parametro_formulario_ivaParametroFormularioIva() {
		return this.resaltarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setResaltarid_tipo_parametro_formulario_ivaParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_tipo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_tipo_parametro_formulario_ivaParametroFormularioIva() {
		return this.mostrarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setMostrarid_tipo_parametro_formulario_ivaParametroFormularioIva(Boolean mostrarid_tipo_parametro_formulario_ivaParametroFormularioIva) {
		this.mostrarid_tipo_parametro_formulario_ivaParametroFormularioIva= mostrarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getActivarid_tipo_parametro_formulario_ivaParametroFormularioIva() {
		return this.activarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setActivarid_tipo_parametro_formulario_ivaParametroFormularioIva(Boolean activarid_tipo_parametro_formulario_ivaParametroFormularioIva) {
		this.activarid_tipo_parametro_formulario_ivaParametroFormularioIva= activarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getCargarid_tipo_parametro_formulario_ivaParametroFormularioIva() {
		return this.cargarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setCargarid_tipo_parametro_formulario_ivaParametroFormularioIva(Boolean cargarid_tipo_parametro_formulario_ivaParametroFormularioIva) {
		this.cargarid_tipo_parametro_formulario_ivaParametroFormularioIva= cargarid_tipo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Border setResaltarid_grupo_parametro_formulario_ivaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_grupo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.resaltarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setResaltarid_grupo_parametro_formulario_ivaParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_grupo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.mostrarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setMostrarid_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean mostrarid_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.mostrarid_grupo_parametro_formulario_ivaParametroFormularioIva= mostrarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getActivarid_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.activarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setActivarid_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean activarid_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.activarid_grupo_parametro_formulario_ivaParametroFormularioIva= activarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getCargarid_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.cargarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setCargarid_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean cargarid_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.cargarid_grupo_parametro_formulario_ivaParametroFormularioIva= cargarid_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Border setResaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.resaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setResaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.mostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setMostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean mostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.mostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva= mostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getActivarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.activarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setActivarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean activarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.activarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva= activarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Boolean getCargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva() {
		return this.cargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public void setCargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(Boolean cargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva) {
		this.cargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva= cargarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva;
	}

	public Border setResaltargrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltargrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargrupoParametroFormularioIva() {
		return this.resaltargrupoParametroFormularioIva;
	}

	public void setResaltargrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltargrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrargrupoParametroFormularioIva() {
		return this.mostrargrupoParametroFormularioIva;
	}

	public void setMostrargrupoParametroFormularioIva(Boolean mostrargrupoParametroFormularioIva) {
		this.mostrargrupoParametroFormularioIva= mostrargrupoParametroFormularioIva;
	}

	public Boolean getActivargrupoParametroFormularioIva() {
		return this.activargrupoParametroFormularioIva;
	}

	public void setActivargrupoParametroFormularioIva(Boolean activargrupoParametroFormularioIva) {
		this.activargrupoParametroFormularioIva= activargrupoParametroFormularioIva;
	}

	public Border setResaltargrupo2ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltargrupo2ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargrupo2ParametroFormularioIva() {
		return this.resaltargrupo2ParametroFormularioIva;
	}

	public void setResaltargrupo2ParametroFormularioIva(Border borderResaltar) {
		this.resaltargrupo2ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrargrupo2ParametroFormularioIva() {
		return this.mostrargrupo2ParametroFormularioIva;
	}

	public void setMostrargrupo2ParametroFormularioIva(Boolean mostrargrupo2ParametroFormularioIva) {
		this.mostrargrupo2ParametroFormularioIva= mostrargrupo2ParametroFormularioIva;
	}

	public Boolean getActivargrupo2ParametroFormularioIva() {
		return this.activargrupo2ParametroFormularioIva;
	}

	public void setActivargrupo2ParametroFormularioIva(Boolean activargrupo2ParametroFormularioIva) {
		this.activargrupo2ParametroFormularioIva= activargrupo2ParametroFormularioIva;
	}

	public Border setResaltarcodigo_sriParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarcodigo_sriParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sriParametroFormularioIva() {
		return this.resaltarcodigo_sriParametroFormularioIva;
	}

	public void setResaltarcodigo_sriParametroFormularioIva(Border borderResaltar) {
		this.resaltarcodigo_sriParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarcodigo_sriParametroFormularioIva() {
		return this.mostrarcodigo_sriParametroFormularioIva;
	}

	public void setMostrarcodigo_sriParametroFormularioIva(Boolean mostrarcodigo_sriParametroFormularioIva) {
		this.mostrarcodigo_sriParametroFormularioIva= mostrarcodigo_sriParametroFormularioIva;
	}

	public Boolean getActivarcodigo_sriParametroFormularioIva() {
		return this.activarcodigo_sriParametroFormularioIva;
	}

	public void setActivarcodigo_sriParametroFormularioIva(Boolean activarcodigo_sriParametroFormularioIva) {
		this.activarcodigo_sriParametroFormularioIva= activarcodigo_sriParametroFormularioIva;
	}

	public Border setResaltarnombreParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarnombreParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreParametroFormularioIva() {
		return this.resaltarnombreParametroFormularioIva;
	}

	public void setResaltarnombreParametroFormularioIva(Border borderResaltar) {
		this.resaltarnombreParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarnombreParametroFormularioIva() {
		return this.mostrarnombreParametroFormularioIva;
	}

	public void setMostrarnombreParametroFormularioIva(Boolean mostrarnombreParametroFormularioIva) {
		this.mostrarnombreParametroFormularioIva= mostrarnombreParametroFormularioIva;
	}

	public Boolean getActivarnombreParametroFormularioIva() {
		return this.activarnombreParametroFormularioIva;
	}

	public void setActivarnombreParametroFormularioIva(Boolean activarnombreParametroFormularioIva) {
		this.activarnombreParametroFormularioIva= activarnombreParametroFormularioIva;
	}

	public Border setResaltarporcentajeParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarporcentajeParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeParametroFormularioIva() {
		return this.resaltarporcentajeParametroFormularioIva;
	}

	public void setResaltarporcentajeParametroFormularioIva(Border borderResaltar) {
		this.resaltarporcentajeParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarporcentajeParametroFormularioIva() {
		return this.mostrarporcentajeParametroFormularioIva;
	}

	public void setMostrarporcentajeParametroFormularioIva(Boolean mostrarporcentajeParametroFormularioIva) {
		this.mostrarporcentajeParametroFormularioIva= mostrarporcentajeParametroFormularioIva;
	}

	public Boolean getActivarporcentajeParametroFormularioIva() {
		return this.activarporcentajeParametroFormularioIva;
	}

	public void setActivarporcentajeParametroFormularioIva(Boolean activarporcentajeParametroFormularioIva) {
		this.activarporcentajeParametroFormularioIva= activarporcentajeParametroFormularioIva;
	}

	public Border setResaltarcon_totalParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarcon_totalParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_totalParametroFormularioIva() {
		return this.resaltarcon_totalParametroFormularioIva;
	}

	public void setResaltarcon_totalParametroFormularioIva(Border borderResaltar) {
		this.resaltarcon_totalParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarcon_totalParametroFormularioIva() {
		return this.mostrarcon_totalParametroFormularioIva;
	}

	public void setMostrarcon_totalParametroFormularioIva(Boolean mostrarcon_totalParametroFormularioIva) {
		this.mostrarcon_totalParametroFormularioIva= mostrarcon_totalParametroFormularioIva;
	}

	public Boolean getActivarcon_totalParametroFormularioIva() {
		return this.activarcon_totalParametroFormularioIva;
	}

	public void setActivarcon_totalParametroFormularioIva(Boolean activarcon_totalParametroFormularioIva) {
		this.activarcon_totalParametroFormularioIva= activarcon_totalParametroFormularioIva;
	}

	public Border setResaltarid_cuenta_contable1ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable1ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable1ParametroFormularioIva() {
		return this.resaltarid_cuenta_contable1ParametroFormularioIva;
	}

	public void setResaltarid_cuenta_contable1ParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable1ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable1ParametroFormularioIva() {
		return this.mostrarid_cuenta_contable1ParametroFormularioIva;
	}

	public void setMostrarid_cuenta_contable1ParametroFormularioIva(Boolean mostrarid_cuenta_contable1ParametroFormularioIva) {
		this.mostrarid_cuenta_contable1ParametroFormularioIva= mostrarid_cuenta_contable1ParametroFormularioIva;
	}

	public Boolean getActivarid_cuenta_contable1ParametroFormularioIva() {
		return this.activarid_cuenta_contable1ParametroFormularioIva;
	}

	public void setActivarid_cuenta_contable1ParametroFormularioIva(Boolean activarid_cuenta_contable1ParametroFormularioIva) {
		this.activarid_cuenta_contable1ParametroFormularioIva= activarid_cuenta_contable1ParametroFormularioIva;
	}

	public Boolean getCargarid_cuenta_contable1ParametroFormularioIva() {
		return this.cargarid_cuenta_contable1ParametroFormularioIva;
	}

	public void setCargarid_cuenta_contable1ParametroFormularioIva(Boolean cargarid_cuenta_contable1ParametroFormularioIva) {
		this.cargarid_cuenta_contable1ParametroFormularioIva= cargarid_cuenta_contable1ParametroFormularioIva;
	}

	public Border setResaltarid_cuenta_contable2ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable2ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable2ParametroFormularioIva() {
		return this.resaltarid_cuenta_contable2ParametroFormularioIva;
	}

	public void setResaltarid_cuenta_contable2ParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable2ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable2ParametroFormularioIva() {
		return this.mostrarid_cuenta_contable2ParametroFormularioIva;
	}

	public void setMostrarid_cuenta_contable2ParametroFormularioIva(Boolean mostrarid_cuenta_contable2ParametroFormularioIva) {
		this.mostrarid_cuenta_contable2ParametroFormularioIva= mostrarid_cuenta_contable2ParametroFormularioIva;
	}

	public Boolean getActivarid_cuenta_contable2ParametroFormularioIva() {
		return this.activarid_cuenta_contable2ParametroFormularioIva;
	}

	public void setActivarid_cuenta_contable2ParametroFormularioIva(Boolean activarid_cuenta_contable2ParametroFormularioIva) {
		this.activarid_cuenta_contable2ParametroFormularioIva= activarid_cuenta_contable2ParametroFormularioIva;
	}

	public Boolean getCargarid_cuenta_contable2ParametroFormularioIva() {
		return this.cargarid_cuenta_contable2ParametroFormularioIva;
	}

	public void setCargarid_cuenta_contable2ParametroFormularioIva(Boolean cargarid_cuenta_contable2ParametroFormularioIva) {
		this.cargarid_cuenta_contable2ParametroFormularioIva= cargarid_cuenta_contable2ParametroFormularioIva;
	}

	public Border setResaltarid_cuenta_contable3ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable3ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable3ParametroFormularioIva() {
		return this.resaltarid_cuenta_contable3ParametroFormularioIva;
	}

	public void setResaltarid_cuenta_contable3ParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable3ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable3ParametroFormularioIva() {
		return this.mostrarid_cuenta_contable3ParametroFormularioIva;
	}

	public void setMostrarid_cuenta_contable3ParametroFormularioIva(Boolean mostrarid_cuenta_contable3ParametroFormularioIva) {
		this.mostrarid_cuenta_contable3ParametroFormularioIva= mostrarid_cuenta_contable3ParametroFormularioIva;
	}

	public Boolean getActivarid_cuenta_contable3ParametroFormularioIva() {
		return this.activarid_cuenta_contable3ParametroFormularioIva;
	}

	public void setActivarid_cuenta_contable3ParametroFormularioIva(Boolean activarid_cuenta_contable3ParametroFormularioIva) {
		this.activarid_cuenta_contable3ParametroFormularioIva= activarid_cuenta_contable3ParametroFormularioIva;
	}

	public Boolean getCargarid_cuenta_contable3ParametroFormularioIva() {
		return this.cargarid_cuenta_contable3ParametroFormularioIva;
	}

	public void setCargarid_cuenta_contable3ParametroFormularioIva(Boolean cargarid_cuenta_contable3ParametroFormularioIva) {
		this.cargarid_cuenta_contable3ParametroFormularioIva= cargarid_cuenta_contable3ParametroFormularioIva;
	}

	public Border setResaltarid_cuenta_contable4ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable4ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable4ParametroFormularioIva() {
		return this.resaltarid_cuenta_contable4ParametroFormularioIva;
	}

	public void setResaltarid_cuenta_contable4ParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable4ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable4ParametroFormularioIva() {
		return this.mostrarid_cuenta_contable4ParametroFormularioIva;
	}

	public void setMostrarid_cuenta_contable4ParametroFormularioIva(Boolean mostrarid_cuenta_contable4ParametroFormularioIva) {
		this.mostrarid_cuenta_contable4ParametroFormularioIva= mostrarid_cuenta_contable4ParametroFormularioIva;
	}

	public Boolean getActivarid_cuenta_contable4ParametroFormularioIva() {
		return this.activarid_cuenta_contable4ParametroFormularioIva;
	}

	public void setActivarid_cuenta_contable4ParametroFormularioIva(Boolean activarid_cuenta_contable4ParametroFormularioIva) {
		this.activarid_cuenta_contable4ParametroFormularioIva= activarid_cuenta_contable4ParametroFormularioIva;
	}

	public Boolean getCargarid_cuenta_contable4ParametroFormularioIva() {
		return this.cargarid_cuenta_contable4ParametroFormularioIva;
	}

	public void setCargarid_cuenta_contable4ParametroFormularioIva(Boolean cargarid_cuenta_contable4ParametroFormularioIva) {
		this.cargarid_cuenta_contable4ParametroFormularioIva= cargarid_cuenta_contable4ParametroFormularioIva;
	}

	public Border setResaltarid_cuenta_contable5ParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable5ParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable5ParametroFormularioIva() {
		return this.resaltarid_cuenta_contable5ParametroFormularioIva;
	}

	public void setResaltarid_cuenta_contable5ParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable5ParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable5ParametroFormularioIva() {
		return this.mostrarid_cuenta_contable5ParametroFormularioIva;
	}

	public void setMostrarid_cuenta_contable5ParametroFormularioIva(Boolean mostrarid_cuenta_contable5ParametroFormularioIva) {
		this.mostrarid_cuenta_contable5ParametroFormularioIva= mostrarid_cuenta_contable5ParametroFormularioIva;
	}

	public Boolean getActivarid_cuenta_contable5ParametroFormularioIva() {
		return this.activarid_cuenta_contable5ParametroFormularioIva;
	}

	public void setActivarid_cuenta_contable5ParametroFormularioIva(Boolean activarid_cuenta_contable5ParametroFormularioIva) {
		this.activarid_cuenta_contable5ParametroFormularioIva= activarid_cuenta_contable5ParametroFormularioIva;
	}

	public Boolean getCargarid_cuenta_contable5ParametroFormularioIva() {
		return this.cargarid_cuenta_contable5ParametroFormularioIva;
	}

	public void setCargarid_cuenta_contable5ParametroFormularioIva(Boolean cargarid_cuenta_contable5ParametroFormularioIva) {
		this.cargarid_cuenta_contable5ParametroFormularioIva= cargarid_cuenta_contable5ParametroFormularioIva;
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
		
		
		this.setMostraridParametroFormularioIva(esInicial);
		this.setMostrarid_empresaParametroFormularioIva(esInicial);
		this.setMostrarid_tipo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setMostrarid_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setMostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setMostrargrupoParametroFormularioIva(esInicial);
		this.setMostrargrupo2ParametroFormularioIva(esInicial);
		this.setMostrarcodigo_sriParametroFormularioIva(esInicial);
		this.setMostrarnombreParametroFormularioIva(esInicial);
		this.setMostrarporcentajeParametroFormularioIva(esInicial);
		this.setMostrarcon_totalParametroFormularioIva(esInicial);
		this.setMostrarid_cuenta_contable1ParametroFormularioIva(esInicial);
		this.setMostrarid_cuenta_contable2ParametroFormularioIva(esInicial);
		this.setMostrarid_cuenta_contable3ParametroFormularioIva(esInicial);
		this.setMostrarid_cuenta_contable4ParametroFormularioIva(esInicial);
		this.setMostrarid_cuenta_contable5ParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.ID)) {
				this.setMostraridParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_tipo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO)) {
				this.setMostrargrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO2)) {
				this.setMostrargrupo2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setMostrarcodigo_sriParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CONTOTAL)) {
				this.setMostrarcon_totalParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1)) {
				this.setMostrarid_cuenta_contable1ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2)) {
				this.setMostrarid_cuenta_contable2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3)) {
				this.setMostrarid_cuenta_contable3ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4)) {
				this.setMostrarid_cuenta_contable4ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5)) {
				this.setMostrarid_cuenta_contable5ParametroFormularioIva(esAsigna);
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
		
		
		this.setActivaridParametroFormularioIva(esInicial);
		this.setActivarid_empresaParametroFormularioIva(esInicial);
		this.setActivarid_tipo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setActivarid_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setActivarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setActivargrupoParametroFormularioIva(esInicial);
		this.setActivargrupo2ParametroFormularioIva(esInicial);
		this.setActivarcodigo_sriParametroFormularioIva(esInicial);
		this.setActivarnombreParametroFormularioIva(esInicial);
		this.setActivarporcentajeParametroFormularioIva(esInicial);
		this.setActivarcon_totalParametroFormularioIva(esInicial);
		this.setActivarid_cuenta_contable1ParametroFormularioIva(esInicial);
		this.setActivarid_cuenta_contable2ParametroFormularioIva(esInicial);
		this.setActivarid_cuenta_contable3ParametroFormularioIva(esInicial);
		this.setActivarid_cuenta_contable4ParametroFormularioIva(esInicial);
		this.setActivarid_cuenta_contable5ParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.ID)) {
				this.setActivaridParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA)) {
				this.setActivarid_tipo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setActivarid_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA)) {
				this.setActivarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO)) {
				this.setActivargrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO2)) {
				this.setActivargrupo2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setActivarcodigo_sriParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CONTOTAL)) {
				this.setActivarcon_totalParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1)) {
				this.setActivarid_cuenta_contable1ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2)) {
				this.setActivarid_cuenta_contable2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3)) {
				this.setActivarid_cuenta_contable3ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4)) {
				this.setActivarid_cuenta_contable4ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5)) {
				this.setActivarid_cuenta_contable5ParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFormularioIva(esInicial);
		this.setResaltarid_empresaParametroFormularioIva(esInicial);
		this.setResaltarid_tipo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setResaltarid_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setResaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esInicial);
		this.setResaltargrupoParametroFormularioIva(esInicial);
		this.setResaltargrupo2ParametroFormularioIva(esInicial);
		this.setResaltarcodigo_sriParametroFormularioIva(esInicial);
		this.setResaltarnombreParametroFormularioIva(esInicial);
		this.setResaltarporcentajeParametroFormularioIva(esInicial);
		this.setResaltarcon_totalParametroFormularioIva(esInicial);
		this.setResaltarid_cuenta_contable1ParametroFormularioIva(esInicial);
		this.setResaltarid_cuenta_contable2ParametroFormularioIva(esInicial);
		this.setResaltarid_cuenta_contable3ParametroFormularioIva(esInicial);
		this.setResaltarid_cuenta_contable4ParametroFormularioIva(esInicial);
		this.setResaltarid_cuenta_contable5ParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_tipo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_sub_grupo_parametro_formulario_ivaParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO)) {
				this.setResaltargrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.GRUPO2)) {
				this.setResaltargrupo2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setResaltarcodigo_sriParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.CONTOTAL)) {
				this.setResaltarcon_totalParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1)) {
				this.setResaltarid_cuenta_contable1ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2)) {
				this.setResaltarid_cuenta_contable2ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3)) {
				this.setResaltarid_cuenta_contable3ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4)) {
				this.setResaltarid_cuenta_contable4ParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5)) {
				this.setResaltarid_cuenta_contable5ParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormularioRentaParametroFormularioIva=null;

	public Border getResaltarFormularioRentaParametroFormularioIva() {
		return this.resaltarFormularioRentaParametroFormularioIva;
	}

	public void setResaltarFormularioRentaParametroFormularioIva(Border borderResaltarFormularioRenta) {
		if(borderResaltarFormularioRenta!=null) {
			this.resaltarFormularioRentaParametroFormularioIva= borderResaltarFormularioRenta;
		}
	}

	public Border setResaltarFormularioRentaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioRenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltarFormularioRenta);
			
		this.resaltarFormularioRentaParametroFormularioIva= borderResaltarFormularioRenta;

		 return borderResaltarFormularioRenta;
	}



	public Boolean mostrarFormularioRentaParametroFormularioIva=true;

	public Boolean getMostrarFormularioRentaParametroFormularioIva() {
		return this.mostrarFormularioRentaParametroFormularioIva;
	}

	public void setMostrarFormularioRentaParametroFormularioIva(Boolean visibilidadResaltarFormularioRenta) {
		this.mostrarFormularioRentaParametroFormularioIva= visibilidadResaltarFormularioRenta;
	}



	public Boolean activarFormularioRentaParametroFormularioIva=true;

	public Boolean gethabilitarResaltarFormularioRentaParametroFormularioIva() {
		return this.activarFormularioRentaParametroFormularioIva;
	}

	public void setActivarFormularioRentaParametroFormularioIva(Boolean habilitarResaltarFormularioRenta) {
		this.activarFormularioRentaParametroFormularioIva= habilitarResaltarFormularioRenta;
	}


	public Border resaltarFormularioIvaParametroFormularioIva=null;

	public Border getResaltarFormularioIvaParametroFormularioIva() {
		return this.resaltarFormularioIvaParametroFormularioIva;
	}

	public void setResaltarFormularioIvaParametroFormularioIva(Border borderResaltarFormularioIva) {
		if(borderResaltarFormularioIva!=null) {
			this.resaltarFormularioIvaParametroFormularioIva= borderResaltarFormularioIva;
		}
	}

	public Border setResaltarFormularioIvaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//parametroformularioivaBeanSwingJInternalFrame.jTtoolBarParametroFormularioIva.setBorder(borderResaltarFormularioIva);
			
		this.resaltarFormularioIvaParametroFormularioIva= borderResaltarFormularioIva;

		 return borderResaltarFormularioIva;
	}



	public Boolean mostrarFormularioIvaParametroFormularioIva=true;

	public Boolean getMostrarFormularioIvaParametroFormularioIva() {
		return this.mostrarFormularioIvaParametroFormularioIva;
	}

	public void setMostrarFormularioIvaParametroFormularioIva(Boolean visibilidadResaltarFormularioIva) {
		this.mostrarFormularioIvaParametroFormularioIva= visibilidadResaltarFormularioIva;
	}



	public Boolean activarFormularioIvaParametroFormularioIva=true;

	public Boolean gethabilitarResaltarFormularioIvaParametroFormularioIva() {
		return this.activarFormularioIvaParametroFormularioIva;
	}

	public void setActivarFormularioIvaParametroFormularioIva(Boolean habilitarResaltarFormularioIva) {
		this.activarFormularioIvaParametroFormularioIva= habilitarResaltarFormularioIva;
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

		this.setMostrarFormularioRentaParametroFormularioIva(esInicial);
		this.setMostrarFormularioIvaParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setMostrarFormularioRentaParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setMostrarFormularioIvaParametroFormularioIva(esAsigna);
				continue;
			}
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

		this.setActivarFormularioRentaParametroFormularioIva(esInicial);
		this.setActivarFormularioIvaParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setActivarFormularioRentaParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setActivarFormularioIvaParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormularioRentaParametroFormularioIva(esInicial);
		this.setResaltarFormularioIvaParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setResaltarFormularioRentaParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setResaltarFormularioIvaParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaParametroFormularioIva=true;

	public Boolean getMostrarFK_IdEmpresaParametroFormularioIva() {
		return this.mostrarFK_IdEmpresaParametroFormularioIva;
	}

	public void setMostrarFK_IdEmpresaParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getMostrarFK_IdGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.mostrarFK_IdGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setMostrarFK_IdGrupoParametroFormularioIvaParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoParametroFormularioIvaParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getMostrarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.mostrarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setMostrarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getMostrarFK_IdTipoParametroFormularioIvaParametroFormularioIva() {
		return this.mostrarFK_IdTipoParametroFormularioIvaParametroFormularioIva;
	}

	public void setMostrarFK_IdTipoParametroFormularioIvaParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoParametroFormularioIvaParametroFormularioIva= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroFormularioIva=true;

	public Boolean getActivarFK_IdEmpresaParametroFormularioIva() {
		return this.activarFK_IdEmpresaParametroFormularioIva;
	}

	public void setActivarFK_IdEmpresaParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getActivarFK_IdGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.activarFK_IdGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setActivarFK_IdGrupoParametroFormularioIvaParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoParametroFormularioIvaParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getActivarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.activarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setActivarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoParametroFormularioIvaParametroFormularioIva=true;

	public Boolean getActivarFK_IdTipoParametroFormularioIvaParametroFormularioIva() {
		return this.activarFK_IdTipoParametroFormularioIvaParametroFormularioIva;
	}

	public void setActivarFK_IdTipoParametroFormularioIvaParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdTipoParametroFormularioIvaParametroFormularioIva= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroFormularioIva=null;

	public Border getResaltarFK_IdEmpresaParametroFormularioIva() {
		return this.resaltarFK_IdEmpresaParametroFormularioIva;
	}

	public void setResaltarFK_IdEmpresaParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva=null;

	public Border getResaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.resaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setResaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva=null;

	public Border getResaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva() {
		return this.resaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva;
	}

	public void setResaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubGrupoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva=null;

	public Border getResaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva() {
		return this.resaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva;
	}

	public void setResaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFormularioIvaBeanSwingJInternalFrame parametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoParametroFormularioIvaParametroFormularioIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}