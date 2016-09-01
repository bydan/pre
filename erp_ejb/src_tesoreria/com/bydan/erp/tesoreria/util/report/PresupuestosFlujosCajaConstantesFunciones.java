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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.PresupuestosFlujosCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.PresupuestosFlujosCajaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PresupuestosFlujosCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestosFlujosCajaConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="PresupuestosFlujosCaja";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestosFlujosCaja"+PresupuestosFlujosCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestosFlujosCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestosFlujosCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"_"+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"_"+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"_"+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"_"+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestosFlujosCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestosFlujosCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestosFlujosCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestosFlujosCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuestos Flujos Cajas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Presupuestos Flujos Caja";
	public static final String SCLASSWEBTITULO_LOWER="Presupuestos Flujos Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestosFlujosCaja";
	public static final String OBJECTNAME="presupuestosflujoscaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="presupuestos_flujos_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestosflujoscaja from "+PresupuestosFlujosCajaConstantesFunciones.SPERSISTENCENAME+" presupuestosflujoscaja";
	public static String QUERYSELECTNATIVE="select "+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".id,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".version_row,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".codigo_cuenta,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".codigo,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".nombre,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".nombre_modulo,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor1,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor2,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor3,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor4,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor5,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor6,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor7,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor8,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor9,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor10,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor11,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".valor12,"+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME+".total from "+PresupuestosFlujosCajaConstantesFunciones.SCHEMA+"."+PresupuestosFlujosCajaConstantesFunciones.TABLENAME;//+" as "+PresupuestosFlujosCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGOCUENTA= "codigo_cuenta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREMODULO= "nombre_modulo";
    public static final String VALOR1= "valor1";
    public static final String VALOR2= "valor2";
    public static final String VALOR3= "valor3";
    public static final String VALOR4= "valor4";
    public static final String VALOR5= "valor5";
    public static final String VALOR6= "valor6";
    public static final String VALOR7= "valor7";
    public static final String VALOR8= "valor8";
    public static final String VALOR9= "valor9";
    public static final String VALOR10= "valor10";
    public static final String VALOR11= "valor11";
    public static final String VALOR12= "valor12";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGOCUENTA= "Codigo Cuenta";
		public static final String LABEL_CODIGOCUENTA_LOWER= "Codigo Cuenta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREMODULO= "Nombre Modulo";
		public static final String LABEL_NOMBREMODULO_LOWER= "Nombre Modulo";
    	public static final String LABEL_VALOR1= "Valor1";
		public static final String LABEL_VALOR1_LOWER= "Valor1";
    	public static final String LABEL_VALOR2= "Valor2";
		public static final String LABEL_VALOR2_LOWER= "Valor2";
    	public static final String LABEL_VALOR3= "Valor3";
		public static final String LABEL_VALOR3_LOWER= "Valor3";
    	public static final String LABEL_VALOR4= "Valor4";
		public static final String LABEL_VALOR4_LOWER= "Valor4";
    	public static final String LABEL_VALOR5= "Valor5";
		public static final String LABEL_VALOR5_LOWER= "Valor5";
    	public static final String LABEL_VALOR6= "Valor6";
		public static final String LABEL_VALOR6_LOWER= "Valor6";
    	public static final String LABEL_VALOR7= "Valor7";
		public static final String LABEL_VALOR7_LOWER= "Valor7";
    	public static final String LABEL_VALOR8= "Valor8";
		public static final String LABEL_VALOR8_LOWER= "Valor8";
    	public static final String LABEL_VALOR9= "Valor9";
		public static final String LABEL_VALOR9_LOWER= "Valor9";
    	public static final String LABEL_VALOR10= "Valor10";
		public static final String LABEL_VALOR10_LOWER= "Valor10";
    	public static final String LABEL_VALOR11= "Valor11";
		public static final String LABEL_VALOR11_LOWER= "Valor11";
    	public static final String LABEL_VALOR12= "Valor12";
		public static final String LABEL_VALOR12_LOWER= "Valor12";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
	public static final String SREGEXCODIGO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPresupuestosFlujosCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGOCUENTA;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGO)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBRE)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBREMODULO;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR1)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR2)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR3)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR4)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR5)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR6)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR7)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR8)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR9)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR10)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR11)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR12)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12;}
		if(sNombreColumna.equals(PresupuestosFlujosCajaConstantesFunciones.TOTAL)) {sLabelColumna=PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestosFlujosCajaDescripcion(PresupuestosFlujosCaja presupuestosflujoscaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestosflujoscaja !=null/* && presupuestosflujoscaja.getId()!=0*/) {
			sDescripcion=presupuestosflujoscaja.getcodigo();//presupuestosflujoscajapresupuestosflujoscaja.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestosFlujosCajaDescripcionDetallado(PresupuestosFlujosCaja presupuestosflujoscaja) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.ID+"=";
		sDescripcion+=presupuestosflujoscaja.getId().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestosflujoscaja.getVersionRow().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestosflujoscaja.getid_empresa().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA+"=";
		sDescripcion+=presupuestosflujoscaja.getcodigo_cuenta()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.CODIGO+"=";
		sDescripcion+=presupuestosflujoscaja.getcodigo()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presupuestosflujoscaja.getnombre()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO+"=";
		sDescripcion+=presupuestosflujoscaja.getnombre_modulo()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR1+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor1().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR2+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor2().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR3+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor3().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR4+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor4().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR5+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor5().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR6+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor6().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR7+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor7().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR8+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor8().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR9+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor9().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR10+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor10().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR11+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor11().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.VALOR12+"=";
		sDescripcion+=presupuestosflujoscaja.getvalor12().toString()+",";
		sDescripcion+=PresupuestosFlujosCajaConstantesFunciones.TOTAL+"=";
		sDescripcion+=presupuestosflujoscaja.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestosFlujosCajaDescripcion(PresupuestosFlujosCaja presupuestosflujoscaja,String sValor) throws Exception {			
		if(presupuestosflujoscaja !=null) {
			presupuestosflujoscaja.setcodigo(sValor);;//presupuestosflujoscajapresupuestosflujoscaja.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPresupuestosFlujosCaja")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPresupuestosFlujosCaja(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presupuestosflujoscaja.setcodigo_cuenta(presupuestosflujoscaja.getcodigo_cuenta().trim());
		presupuestosflujoscaja.setcodigo(presupuestosflujoscaja.getcodigo().trim());
		presupuestosflujoscaja.setnombre(presupuestosflujoscaja.getnombre().trim());
		presupuestosflujoscaja.setnombre_modulo(presupuestosflujoscaja.getnombre_modulo().trim());
	}
	
	public static void quitarEspaciosPresupuestosFlujosCajas(List<PresupuestosFlujosCaja> presupuestosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {
			presupuestosflujoscaja.setcodigo_cuenta(presupuestosflujoscaja.getcodigo_cuenta().trim());
			presupuestosflujoscaja.setcodigo(presupuestosflujoscaja.getcodigo().trim());
			presupuestosflujoscaja.setnombre(presupuestosflujoscaja.getnombre().trim());
			presupuestosflujoscaja.setnombre_modulo(presupuestosflujoscaja.getnombre_modulo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestosflujoscaja.getConCambioAuxiliar()) {
			presupuestosflujoscaja.setIsDeleted(presupuestosflujoscaja.getIsDeletedAuxiliar());	
			presupuestosflujoscaja.setIsNew(presupuestosflujoscaja.getIsNewAuxiliar());	
			presupuestosflujoscaja.setIsChanged(presupuestosflujoscaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestosflujoscaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestosflujoscaja.setIsDeletedAuxiliar(false);	
			presupuestosflujoscaja.setIsNewAuxiliar(false);	
			presupuestosflujoscaja.setIsChangedAuxiliar(false);
			
			presupuestosflujoscaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestosFlujosCajas(List<PresupuestosFlujosCaja> presupuestosflujoscajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestosFlujosCaja presupuestosflujoscaja : presupuestosflujoscajas) {
			if(conAsignarBase && presupuestosflujoscaja.getConCambioAuxiliar()) {
				presupuestosflujoscaja.setIsDeleted(presupuestosflujoscaja.getIsDeletedAuxiliar());	
				presupuestosflujoscaja.setIsNew(presupuestosflujoscaja.getIsNewAuxiliar());	
				presupuestosflujoscaja.setIsChanged(presupuestosflujoscaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestosflujoscaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestosflujoscaja.setIsDeletedAuxiliar(false);	
				presupuestosflujoscaja.setIsNewAuxiliar(false);	
				presupuestosflujoscaja.setIsChangedAuxiliar(false);
				
				presupuestosflujoscaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscaja,Boolean conEnteros) throws Exception  {
		presupuestosflujoscaja.setvalor1(0.0);
		presupuestosflujoscaja.setvalor2(0.0);
		presupuestosflujoscaja.setvalor3(0.0);
		presupuestosflujoscaja.setvalor4(0.0);
		presupuestosflujoscaja.setvalor5(0.0);
		presupuestosflujoscaja.setvalor6(0.0);
		presupuestosflujoscaja.setvalor7(0.0);
		presupuestosflujoscaja.setvalor8(0.0);
		presupuestosflujoscaja.setvalor9(0.0);
		presupuestosflujoscaja.setvalor10(0.0);
		presupuestosflujoscaja.setvalor11(0.0);
		presupuestosflujoscaja.setvalor12(0.0);
		presupuestosflujoscaja.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresupuestosFlujosCajas(List<PresupuestosFlujosCaja> presupuestosflujoscajas,Boolean conEnteros) throws Exception  {
		
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {
			presupuestosflujoscaja.setvalor1(0.0);
			presupuestosflujoscaja.setvalor2(0.0);
			presupuestosflujoscaja.setvalor3(0.0);
			presupuestosflujoscaja.setvalor4(0.0);
			presupuestosflujoscaja.setvalor5(0.0);
			presupuestosflujoscaja.setvalor6(0.0);
			presupuestosflujoscaja.setvalor7(0.0);
			presupuestosflujoscaja.setvalor8(0.0);
			presupuestosflujoscaja.setvalor9(0.0);
			presupuestosflujoscaja.setvalor10(0.0);
			presupuestosflujoscaja.setvalor11(0.0);
			presupuestosflujoscaja.setvalor12(0.0);
			presupuestosflujoscaja.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestosFlujosCaja(List<PresupuestosFlujosCaja> presupuestosflujoscajas,PresupuestosFlujosCaja presupuestosflujoscajaAux) throws Exception  {
		PresupuestosFlujosCajaConstantesFunciones.InicializarValoresPresupuestosFlujosCaja(presupuestosflujoscajaAux,true);
		
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {
			if(presupuestosflujoscaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestosflujoscajaAux.setvalor1(presupuestosflujoscajaAux.getvalor1()+presupuestosflujoscaja.getvalor1());			
			presupuestosflujoscajaAux.setvalor2(presupuestosflujoscajaAux.getvalor2()+presupuestosflujoscaja.getvalor2());			
			presupuestosflujoscajaAux.setvalor3(presupuestosflujoscajaAux.getvalor3()+presupuestosflujoscaja.getvalor3());			
			presupuestosflujoscajaAux.setvalor4(presupuestosflujoscajaAux.getvalor4()+presupuestosflujoscaja.getvalor4());			
			presupuestosflujoscajaAux.setvalor5(presupuestosflujoscajaAux.getvalor5()+presupuestosflujoscaja.getvalor5());			
			presupuestosflujoscajaAux.setvalor6(presupuestosflujoscajaAux.getvalor6()+presupuestosflujoscaja.getvalor6());			
			presupuestosflujoscajaAux.setvalor7(presupuestosflujoscajaAux.getvalor7()+presupuestosflujoscaja.getvalor7());			
			presupuestosflujoscajaAux.setvalor8(presupuestosflujoscajaAux.getvalor8()+presupuestosflujoscaja.getvalor8());			
			presupuestosflujoscajaAux.setvalor9(presupuestosflujoscajaAux.getvalor9()+presupuestosflujoscaja.getvalor9());			
			presupuestosflujoscajaAux.setvalor10(presupuestosflujoscajaAux.getvalor10()+presupuestosflujoscaja.getvalor10());			
			presupuestosflujoscajaAux.setvalor11(presupuestosflujoscajaAux.getvalor11()+presupuestosflujoscaja.getvalor11());			
			presupuestosflujoscajaAux.setvalor12(presupuestosflujoscajaAux.getvalor12()+presupuestosflujoscaja.getvalor12());			
			presupuestosflujoscajaAux.settotal(presupuestosflujoscajaAux.gettotal()+presupuestosflujoscaja.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestosFlujosCajaConstantesFunciones.getArrayColumnasGlobalesPresupuestosFlujosCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestosFlujosCaja> presupuestosflujoscajas,PresupuestosFlujosCaja presupuestosflujoscaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestosFlujosCaja presupuestosflujoscajaAux: presupuestosflujoscajas) {
			if(presupuestosflujoscajaAux!=null && presupuestosflujoscaja!=null) {
				if((presupuestosflujoscajaAux.getId()==null && presupuestosflujoscaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestosflujoscajaAux.getId()!=null && presupuestosflujoscaja.getId()!=null){
					if(presupuestosflujoscajaAux.getId().equals(presupuestosflujoscaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestosFlujosCaja(List<PresupuestosFlujosCaja> presupuestosflujoscajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor1Total=0.0;
		Double valor2Total=0.0;
		Double valor3Total=0.0;
		Double valor4Total=0.0;
		Double valor5Total=0.0;
		Double valor6Total=0.0;
		Double valor7Total=0.0;
		Double valor8Total=0.0;
		Double valor9Total=0.0;
		Double valor10Total=0.0;
		Double valor11Total=0.0;
		Double valor12Total=0.0;
		Double totalTotal=0.0;
	
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {			
			if(presupuestosflujoscaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor1Total+=presupuestosflujoscaja.getvalor1();
			valor2Total+=presupuestosflujoscaja.getvalor2();
			valor3Total+=presupuestosflujoscaja.getvalor3();
			valor4Total+=presupuestosflujoscaja.getvalor4();
			valor5Total+=presupuestosflujoscaja.getvalor5();
			valor6Total+=presupuestosflujoscaja.getvalor6();
			valor7Total+=presupuestosflujoscaja.getvalor7();
			valor8Total+=presupuestosflujoscaja.getvalor8();
			valor9Total+=presupuestosflujoscaja.getvalor9();
			valor10Total+=presupuestosflujoscaja.getvalor10();
			valor11Total+=presupuestosflujoscaja.getvalor11();
			valor12Total+=presupuestosflujoscaja.getvalor12();
			totalTotal+=presupuestosflujoscaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR1);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1);
		datoGeneral.setdValorDouble(valor1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR2);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2);
		datoGeneral.setdValorDouble(valor2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR3);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3);
		datoGeneral.setdValorDouble(valor3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR4);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4);
		datoGeneral.setdValorDouble(valor4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR5);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5);
		datoGeneral.setdValorDouble(valor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR6);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6);
		datoGeneral.setdValorDouble(valor6Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR7);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7);
		datoGeneral.setdValorDouble(valor7Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR8);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8);
		datoGeneral.setdValorDouble(valor8Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR9);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9);
		datoGeneral.setdValorDouble(valor9Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR10);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10);
		datoGeneral.setdValorDouble(valor10Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR11);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11);
		datoGeneral.setdValorDouble(valor11Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR12);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12);
		datoGeneral.setdValorDouble(valor12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestosFlujosCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_ID, PresupuestosFlujosCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VERSIONROW, PresupuestosFlujosCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGOCUENTA, PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGO, PresupuestosFlujosCajaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBRE, PresupuestosFlujosCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBREMODULO, PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1, PresupuestosFlujosCajaConstantesFunciones.VALOR1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2, PresupuestosFlujosCajaConstantesFunciones.VALOR2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3, PresupuestosFlujosCajaConstantesFunciones.VALOR3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4, PresupuestosFlujosCajaConstantesFunciones.VALOR4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5, PresupuestosFlujosCajaConstantesFunciones.VALOR5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6, PresupuestosFlujosCajaConstantesFunciones.VALOR6,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7, PresupuestosFlujosCajaConstantesFunciones.VALOR7,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8, PresupuestosFlujosCajaConstantesFunciones.VALOR8,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9, PresupuestosFlujosCajaConstantesFunciones.VALOR9,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10, PresupuestosFlujosCajaConstantesFunciones.VALOR10,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11, PresupuestosFlujosCajaConstantesFunciones.VALOR11,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12, PresupuestosFlujosCajaConstantesFunciones.VALOR12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL, PresupuestosFlujosCajaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestosFlujosCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR6;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR7;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR8;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR9;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR10;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR11;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.VALOR12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestosFlujosCajaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestosFlujosCaja() throws Exception  {
		return PresupuestosFlujosCajaConstantesFunciones.getTiposSeleccionarPresupuestosFlujosCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestosFlujosCaja(Boolean conFk) throws Exception  {
		return PresupuestosFlujosCajaConstantesFunciones.getTiposSeleccionarPresupuestosFlujosCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestosFlujosCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGOCUENTA);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBREMODULO);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBREMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestosFlujosCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscajaAux) throws Exception {
		
			presupuestosflujoscajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestosflujoscajaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestosFlujosCaja(List<PresupuestosFlujosCaja> presupuestosflujoscajasTemp) throws Exception {
		for(PresupuestosFlujosCaja presupuestosflujoscajaAux:presupuestosflujoscajasTemp) {
			
			presupuestosflujoscajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestosflujoscajaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestosFlujosCajaConstantesFunciones.getClassesRelationshipsOfPresupuestosFlujosCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestosFlujosCajaConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestosFlujosCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestosFlujosCaja presupuestosflujoscaja,List<PresupuestosFlujosCaja> presupuestosflujoscajas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PresupuestosFlujosCaja presupuestosflujoscaja,List<PresupuestosFlujosCaja> presupuestosflujoscajas) throws Exception {
		try	{			
			for(PresupuestosFlujosCaja presupuestosflujoscajaLocal:presupuestosflujoscajas) {
				if(presupuestosflujoscajaLocal.getId().equals(presupuestosflujoscaja.getId())) {
					presupuestosflujoscajaLocal.setIsSelected(presupuestosflujoscaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestosFlujosCaja(List<PresupuestosFlujosCaja> presupuestosflujoscajasAux) throws Exception {
		//this.presupuestosflujoscajasAux=presupuestosflujoscajasAux;
		
		for(PresupuestosFlujosCaja presupuestosflujoscajaAux:presupuestosflujoscajasAux) {
			if(presupuestosflujoscajaAux.getIsChanged()) {
				presupuestosflujoscajaAux.setIsChanged(false);
			}		
			
			if(presupuestosflujoscajaAux.getIsNew()) {
				presupuestosflujoscajaAux.setIsNew(false);
			}	
			
			if(presupuestosflujoscajaAux.getIsDeleted()) {
				presupuestosflujoscajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscajaAux) throws Exception {
		//this.presupuestosflujoscajaAux=presupuestosflujoscajaAux;
		
			if(presupuestosflujoscajaAux.getIsChanged()) {
				presupuestosflujoscajaAux.setIsChanged(false);
			}		
			
			if(presupuestosflujoscajaAux.getIsNew()) {
				presupuestosflujoscajaAux.setIsNew(false);
			}	
			
			if(presupuestosflujoscajaAux.getIsDeleted()) {
				presupuestosflujoscajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestosFlujosCaja presupuestosflujoscajaAsignar,PresupuestosFlujosCaja presupuestosflujoscaja) throws Exception {
		presupuestosflujoscajaAsignar.setId(presupuestosflujoscaja.getId());	
		presupuestosflujoscajaAsignar.setVersionRow(presupuestosflujoscaja.getVersionRow());	
		presupuestosflujoscajaAsignar.setcodigo_cuenta(presupuestosflujoscaja.getcodigo_cuenta());	
		presupuestosflujoscajaAsignar.setcodigo(presupuestosflujoscaja.getcodigo());	
		presupuestosflujoscajaAsignar.setnombre(presupuestosflujoscaja.getnombre());	
		presupuestosflujoscajaAsignar.setnombre_modulo(presupuestosflujoscaja.getnombre_modulo());	
		presupuestosflujoscajaAsignar.setvalor1(presupuestosflujoscaja.getvalor1());	
		presupuestosflujoscajaAsignar.setvalor2(presupuestosflujoscaja.getvalor2());	
		presupuestosflujoscajaAsignar.setvalor3(presupuestosflujoscaja.getvalor3());	
		presupuestosflujoscajaAsignar.setvalor4(presupuestosflujoscaja.getvalor4());	
		presupuestosflujoscajaAsignar.setvalor5(presupuestosflujoscaja.getvalor5());	
		presupuestosflujoscajaAsignar.setvalor6(presupuestosflujoscaja.getvalor6());	
		presupuestosflujoscajaAsignar.setvalor7(presupuestosflujoscaja.getvalor7());	
		presupuestosflujoscajaAsignar.setvalor8(presupuestosflujoscaja.getvalor8());	
		presupuestosflujoscajaAsignar.setvalor9(presupuestosflujoscaja.getvalor9());	
		presupuestosflujoscajaAsignar.setvalor10(presupuestosflujoscaja.getvalor10());	
		presupuestosflujoscajaAsignar.setvalor11(presupuestosflujoscaja.getvalor11());	
		presupuestosflujoscajaAsignar.setvalor12(presupuestosflujoscaja.getvalor12());	
		presupuestosflujoscajaAsignar.settotal(presupuestosflujoscaja.gettotal());	
	}
	
	public static void inicializarPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscaja) throws Exception {
		try {
				presupuestosflujoscaja.setId(0L);	
					
				presupuestosflujoscaja.setcodigo_cuenta("");	
				presupuestosflujoscaja.setcodigo("");	
				presupuestosflujoscaja.setnombre("");	
				presupuestosflujoscaja.setnombre_modulo("");	
				presupuestosflujoscaja.setvalor1(0.0);	
				presupuestosflujoscaja.setvalor2(0.0);	
				presupuestosflujoscaja.setvalor3(0.0);	
				presupuestosflujoscaja.setvalor4(0.0);	
				presupuestosflujoscaja.setvalor5(0.0);	
				presupuestosflujoscaja.setvalor6(0.0);	
				presupuestosflujoscaja.setvalor7(0.0);	
				presupuestosflujoscaja.setvalor8(0.0);	
				presupuestosflujoscaja.setvalor9(0.0);	
				presupuestosflujoscaja.setvalor10(0.0);	
				presupuestosflujoscaja.setvalor11(0.0);	
				presupuestosflujoscaja.setvalor12(0.0);	
				presupuestosflujoscaja.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestosFlujosCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_NOMBREMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestosFlujosCaja(String sTipo,Row row,Workbook workbook,PresupuestosFlujosCaja presupuestosflujoscaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getcodigo_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getnombre_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor6());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor7());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor8());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor9());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor10());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor11());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.getvalor12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestosflujoscaja.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestosFlujosCaja="";
	
	public String getsFinalQueryPresupuestosFlujosCaja() {
		return this.sFinalQueryPresupuestosFlujosCaja;
	}
	
	public void setsFinalQueryPresupuestosFlujosCaja(String sFinalQueryPresupuestosFlujosCaja) {
		this.sFinalQueryPresupuestosFlujosCaja= sFinalQueryPresupuestosFlujosCaja;
	}
	
	public Border resaltarSeleccionarPresupuestosFlujosCaja=null;
	
	public Border setResaltarSeleccionarPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestosFlujosCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestosFlujosCaja() {
		return this.resaltarSeleccionarPresupuestosFlujosCaja;
	}
	
	public void setResaltarSeleccionarPresupuestosFlujosCaja(Border borderResaltarSeleccionarPresupuestosFlujosCaja) {
		this.resaltarSeleccionarPresupuestosFlujosCaja= borderResaltarSeleccionarPresupuestosFlujosCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestosFlujosCaja=null;
	public Boolean mostraridPresupuestosFlujosCaja=true;
	public Boolean activaridPresupuestosFlujosCaja=true;

	public Border resaltarid_empresaPresupuestosFlujosCaja=null;
	public Boolean mostrarid_empresaPresupuestosFlujosCaja=true;
	public Boolean activarid_empresaPresupuestosFlujosCaja=true;
	public Boolean cargarid_empresaPresupuestosFlujosCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestosFlujosCaja=false;//ConEventDepend=true

	public Border resaltarcodigo_cuentaPresupuestosFlujosCaja=null;
	public Boolean mostrarcodigo_cuentaPresupuestosFlujosCaja=true;
	public Boolean activarcodigo_cuentaPresupuestosFlujosCaja=true;

	public Border resaltarcodigoPresupuestosFlujosCaja=null;
	public Boolean mostrarcodigoPresupuestosFlujosCaja=true;
	public Boolean activarcodigoPresupuestosFlujosCaja=true;

	public Border resaltarnombrePresupuestosFlujosCaja=null;
	public Boolean mostrarnombrePresupuestosFlujosCaja=true;
	public Boolean activarnombrePresupuestosFlujosCaja=true;

	public Border resaltarnombre_moduloPresupuestosFlujosCaja=null;
	public Boolean mostrarnombre_moduloPresupuestosFlujosCaja=true;
	public Boolean activarnombre_moduloPresupuestosFlujosCaja=true;

	public Border resaltarvalor1PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor1PresupuestosFlujosCaja=true;
	public Boolean activarvalor1PresupuestosFlujosCaja=true;

	public Border resaltarvalor2PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor2PresupuestosFlujosCaja=true;
	public Boolean activarvalor2PresupuestosFlujosCaja=true;

	public Border resaltarvalor3PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor3PresupuestosFlujosCaja=true;
	public Boolean activarvalor3PresupuestosFlujosCaja=true;

	public Border resaltarvalor4PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor4PresupuestosFlujosCaja=true;
	public Boolean activarvalor4PresupuestosFlujosCaja=true;

	public Border resaltarvalor5PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor5PresupuestosFlujosCaja=true;
	public Boolean activarvalor5PresupuestosFlujosCaja=true;

	public Border resaltarvalor6PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor6PresupuestosFlujosCaja=true;
	public Boolean activarvalor6PresupuestosFlujosCaja=true;

	public Border resaltarvalor7PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor7PresupuestosFlujosCaja=true;
	public Boolean activarvalor7PresupuestosFlujosCaja=true;

	public Border resaltarvalor8PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor8PresupuestosFlujosCaja=true;
	public Boolean activarvalor8PresupuestosFlujosCaja=true;

	public Border resaltarvalor9PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor9PresupuestosFlujosCaja=true;
	public Boolean activarvalor9PresupuestosFlujosCaja=true;

	public Border resaltarvalor10PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor10PresupuestosFlujosCaja=true;
	public Boolean activarvalor10PresupuestosFlujosCaja=true;

	public Border resaltarvalor11PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor11PresupuestosFlujosCaja=true;
	public Boolean activarvalor11PresupuestosFlujosCaja=true;

	public Border resaltarvalor12PresupuestosFlujosCaja=null;
	public Boolean mostrarvalor12PresupuestosFlujosCaja=true;
	public Boolean activarvalor12PresupuestosFlujosCaja=true;

	public Border resaltartotalPresupuestosFlujosCaja=null;
	public Boolean mostrartotalPresupuestosFlujosCaja=true;
	public Boolean activartotalPresupuestosFlujosCaja=true;

	
	

	public Border setResaltaridPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltaridPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestosFlujosCaja() {
		return this.resaltaridPresupuestosFlujosCaja;
	}

	public void setResaltaridPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltaridPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostraridPresupuestosFlujosCaja() {
		return this.mostraridPresupuestosFlujosCaja;
	}

	public void setMostraridPresupuestosFlujosCaja(Boolean mostraridPresupuestosFlujosCaja) {
		this.mostraridPresupuestosFlujosCaja= mostraridPresupuestosFlujosCaja;
	}

	public Boolean getActivaridPresupuestosFlujosCaja() {
		return this.activaridPresupuestosFlujosCaja;
	}

	public void setActivaridPresupuestosFlujosCaja(Boolean activaridPresupuestosFlujosCaja) {
		this.activaridPresupuestosFlujosCaja= activaridPresupuestosFlujosCaja;
	}

	public Border setResaltarid_empresaPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestosFlujosCaja() {
		return this.resaltarid_empresaPresupuestosFlujosCaja;
	}

	public void setResaltarid_empresaPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarid_empresaPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestosFlujosCaja() {
		return this.mostrarid_empresaPresupuestosFlujosCaja;
	}

	public void setMostrarid_empresaPresupuestosFlujosCaja(Boolean mostrarid_empresaPresupuestosFlujosCaja) {
		this.mostrarid_empresaPresupuestosFlujosCaja= mostrarid_empresaPresupuestosFlujosCaja;
	}

	public Boolean getActivarid_empresaPresupuestosFlujosCaja() {
		return this.activarid_empresaPresupuestosFlujosCaja;
	}

	public void setActivarid_empresaPresupuestosFlujosCaja(Boolean activarid_empresaPresupuestosFlujosCaja) {
		this.activarid_empresaPresupuestosFlujosCaja= activarid_empresaPresupuestosFlujosCaja;
	}

	public Boolean getCargarid_empresaPresupuestosFlujosCaja() {
		return this.cargarid_empresaPresupuestosFlujosCaja;
	}

	public void setCargarid_empresaPresupuestosFlujosCaja(Boolean cargarid_empresaPresupuestosFlujosCaja) {
		this.cargarid_empresaPresupuestosFlujosCaja= cargarid_empresaPresupuestosFlujosCaja;
	}

	public Border setResaltarcodigo_cuentaPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuentaPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuentaPresupuestosFlujosCaja() {
		return this.resaltarcodigo_cuentaPresupuestosFlujosCaja;
	}

	public void setResaltarcodigo_cuentaPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarcodigo_cuentaPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuentaPresupuestosFlujosCaja() {
		return this.mostrarcodigo_cuentaPresupuestosFlujosCaja;
	}

	public void setMostrarcodigo_cuentaPresupuestosFlujosCaja(Boolean mostrarcodigo_cuentaPresupuestosFlujosCaja) {
		this.mostrarcodigo_cuentaPresupuestosFlujosCaja= mostrarcodigo_cuentaPresupuestosFlujosCaja;
	}

	public Boolean getActivarcodigo_cuentaPresupuestosFlujosCaja() {
		return this.activarcodigo_cuentaPresupuestosFlujosCaja;
	}

	public void setActivarcodigo_cuentaPresupuestosFlujosCaja(Boolean activarcodigo_cuentaPresupuestosFlujosCaja) {
		this.activarcodigo_cuentaPresupuestosFlujosCaja= activarcodigo_cuentaPresupuestosFlujosCaja;
	}

	public Border setResaltarcodigoPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarcodigoPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresupuestosFlujosCaja() {
		return this.resaltarcodigoPresupuestosFlujosCaja;
	}

	public void setResaltarcodigoPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarcodigoPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarcodigoPresupuestosFlujosCaja() {
		return this.mostrarcodigoPresupuestosFlujosCaja;
	}

	public void setMostrarcodigoPresupuestosFlujosCaja(Boolean mostrarcodigoPresupuestosFlujosCaja) {
		this.mostrarcodigoPresupuestosFlujosCaja= mostrarcodigoPresupuestosFlujosCaja;
	}

	public Boolean getActivarcodigoPresupuestosFlujosCaja() {
		return this.activarcodigoPresupuestosFlujosCaja;
	}

	public void setActivarcodigoPresupuestosFlujosCaja(Boolean activarcodigoPresupuestosFlujosCaja) {
		this.activarcodigoPresupuestosFlujosCaja= activarcodigoPresupuestosFlujosCaja;
	}

	public Border setResaltarnombrePresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarnombrePresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresupuestosFlujosCaja() {
		return this.resaltarnombrePresupuestosFlujosCaja;
	}

	public void setResaltarnombrePresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarnombrePresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarnombrePresupuestosFlujosCaja() {
		return this.mostrarnombrePresupuestosFlujosCaja;
	}

	public void setMostrarnombrePresupuestosFlujosCaja(Boolean mostrarnombrePresupuestosFlujosCaja) {
		this.mostrarnombrePresupuestosFlujosCaja= mostrarnombrePresupuestosFlujosCaja;
	}

	public Boolean getActivarnombrePresupuestosFlujosCaja() {
		return this.activarnombrePresupuestosFlujosCaja;
	}

	public void setActivarnombrePresupuestosFlujosCaja(Boolean activarnombrePresupuestosFlujosCaja) {
		this.activarnombrePresupuestosFlujosCaja= activarnombrePresupuestosFlujosCaja;
	}

	public Border setResaltarnombre_moduloPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_moduloPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_moduloPresupuestosFlujosCaja() {
		return this.resaltarnombre_moduloPresupuestosFlujosCaja;
	}

	public void setResaltarnombre_moduloPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarnombre_moduloPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_moduloPresupuestosFlujosCaja() {
		return this.mostrarnombre_moduloPresupuestosFlujosCaja;
	}

	public void setMostrarnombre_moduloPresupuestosFlujosCaja(Boolean mostrarnombre_moduloPresupuestosFlujosCaja) {
		this.mostrarnombre_moduloPresupuestosFlujosCaja= mostrarnombre_moduloPresupuestosFlujosCaja;
	}

	public Boolean getActivarnombre_moduloPresupuestosFlujosCaja() {
		return this.activarnombre_moduloPresupuestosFlujosCaja;
	}

	public void setActivarnombre_moduloPresupuestosFlujosCaja(Boolean activarnombre_moduloPresupuestosFlujosCaja) {
		this.activarnombre_moduloPresupuestosFlujosCaja= activarnombre_moduloPresupuestosFlujosCaja;
	}

	public Border setResaltarvalor1PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor1PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor1PresupuestosFlujosCaja() {
		return this.resaltarvalor1PresupuestosFlujosCaja;
	}

	public void setResaltarvalor1PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor1PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor1PresupuestosFlujosCaja() {
		return this.mostrarvalor1PresupuestosFlujosCaja;
	}

	public void setMostrarvalor1PresupuestosFlujosCaja(Boolean mostrarvalor1PresupuestosFlujosCaja) {
		this.mostrarvalor1PresupuestosFlujosCaja= mostrarvalor1PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor1PresupuestosFlujosCaja() {
		return this.activarvalor1PresupuestosFlujosCaja;
	}

	public void setActivarvalor1PresupuestosFlujosCaja(Boolean activarvalor1PresupuestosFlujosCaja) {
		this.activarvalor1PresupuestosFlujosCaja= activarvalor1PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor2PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor2PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor2PresupuestosFlujosCaja() {
		return this.resaltarvalor2PresupuestosFlujosCaja;
	}

	public void setResaltarvalor2PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor2PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor2PresupuestosFlujosCaja() {
		return this.mostrarvalor2PresupuestosFlujosCaja;
	}

	public void setMostrarvalor2PresupuestosFlujosCaja(Boolean mostrarvalor2PresupuestosFlujosCaja) {
		this.mostrarvalor2PresupuestosFlujosCaja= mostrarvalor2PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor2PresupuestosFlujosCaja() {
		return this.activarvalor2PresupuestosFlujosCaja;
	}

	public void setActivarvalor2PresupuestosFlujosCaja(Boolean activarvalor2PresupuestosFlujosCaja) {
		this.activarvalor2PresupuestosFlujosCaja= activarvalor2PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor3PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor3PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor3PresupuestosFlujosCaja() {
		return this.resaltarvalor3PresupuestosFlujosCaja;
	}

	public void setResaltarvalor3PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor3PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor3PresupuestosFlujosCaja() {
		return this.mostrarvalor3PresupuestosFlujosCaja;
	}

	public void setMostrarvalor3PresupuestosFlujosCaja(Boolean mostrarvalor3PresupuestosFlujosCaja) {
		this.mostrarvalor3PresupuestosFlujosCaja= mostrarvalor3PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor3PresupuestosFlujosCaja() {
		return this.activarvalor3PresupuestosFlujosCaja;
	}

	public void setActivarvalor3PresupuestosFlujosCaja(Boolean activarvalor3PresupuestosFlujosCaja) {
		this.activarvalor3PresupuestosFlujosCaja= activarvalor3PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor4PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor4PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor4PresupuestosFlujosCaja() {
		return this.resaltarvalor4PresupuestosFlujosCaja;
	}

	public void setResaltarvalor4PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor4PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor4PresupuestosFlujosCaja() {
		return this.mostrarvalor4PresupuestosFlujosCaja;
	}

	public void setMostrarvalor4PresupuestosFlujosCaja(Boolean mostrarvalor4PresupuestosFlujosCaja) {
		this.mostrarvalor4PresupuestosFlujosCaja= mostrarvalor4PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor4PresupuestosFlujosCaja() {
		return this.activarvalor4PresupuestosFlujosCaja;
	}

	public void setActivarvalor4PresupuestosFlujosCaja(Boolean activarvalor4PresupuestosFlujosCaja) {
		this.activarvalor4PresupuestosFlujosCaja= activarvalor4PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor5PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor5PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor5PresupuestosFlujosCaja() {
		return this.resaltarvalor5PresupuestosFlujosCaja;
	}

	public void setResaltarvalor5PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor5PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor5PresupuestosFlujosCaja() {
		return this.mostrarvalor5PresupuestosFlujosCaja;
	}

	public void setMostrarvalor5PresupuestosFlujosCaja(Boolean mostrarvalor5PresupuestosFlujosCaja) {
		this.mostrarvalor5PresupuestosFlujosCaja= mostrarvalor5PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor5PresupuestosFlujosCaja() {
		return this.activarvalor5PresupuestosFlujosCaja;
	}

	public void setActivarvalor5PresupuestosFlujosCaja(Boolean activarvalor5PresupuestosFlujosCaja) {
		this.activarvalor5PresupuestosFlujosCaja= activarvalor5PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor6PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor6PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor6PresupuestosFlujosCaja() {
		return this.resaltarvalor6PresupuestosFlujosCaja;
	}

	public void setResaltarvalor6PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor6PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor6PresupuestosFlujosCaja() {
		return this.mostrarvalor6PresupuestosFlujosCaja;
	}

	public void setMostrarvalor6PresupuestosFlujosCaja(Boolean mostrarvalor6PresupuestosFlujosCaja) {
		this.mostrarvalor6PresupuestosFlujosCaja= mostrarvalor6PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor6PresupuestosFlujosCaja() {
		return this.activarvalor6PresupuestosFlujosCaja;
	}

	public void setActivarvalor6PresupuestosFlujosCaja(Boolean activarvalor6PresupuestosFlujosCaja) {
		this.activarvalor6PresupuestosFlujosCaja= activarvalor6PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor7PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor7PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor7PresupuestosFlujosCaja() {
		return this.resaltarvalor7PresupuestosFlujosCaja;
	}

	public void setResaltarvalor7PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor7PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor7PresupuestosFlujosCaja() {
		return this.mostrarvalor7PresupuestosFlujosCaja;
	}

	public void setMostrarvalor7PresupuestosFlujosCaja(Boolean mostrarvalor7PresupuestosFlujosCaja) {
		this.mostrarvalor7PresupuestosFlujosCaja= mostrarvalor7PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor7PresupuestosFlujosCaja() {
		return this.activarvalor7PresupuestosFlujosCaja;
	}

	public void setActivarvalor7PresupuestosFlujosCaja(Boolean activarvalor7PresupuestosFlujosCaja) {
		this.activarvalor7PresupuestosFlujosCaja= activarvalor7PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor8PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor8PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor8PresupuestosFlujosCaja() {
		return this.resaltarvalor8PresupuestosFlujosCaja;
	}

	public void setResaltarvalor8PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor8PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor8PresupuestosFlujosCaja() {
		return this.mostrarvalor8PresupuestosFlujosCaja;
	}

	public void setMostrarvalor8PresupuestosFlujosCaja(Boolean mostrarvalor8PresupuestosFlujosCaja) {
		this.mostrarvalor8PresupuestosFlujosCaja= mostrarvalor8PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor8PresupuestosFlujosCaja() {
		return this.activarvalor8PresupuestosFlujosCaja;
	}

	public void setActivarvalor8PresupuestosFlujosCaja(Boolean activarvalor8PresupuestosFlujosCaja) {
		this.activarvalor8PresupuestosFlujosCaja= activarvalor8PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor9PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor9PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor9PresupuestosFlujosCaja() {
		return this.resaltarvalor9PresupuestosFlujosCaja;
	}

	public void setResaltarvalor9PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor9PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor9PresupuestosFlujosCaja() {
		return this.mostrarvalor9PresupuestosFlujosCaja;
	}

	public void setMostrarvalor9PresupuestosFlujosCaja(Boolean mostrarvalor9PresupuestosFlujosCaja) {
		this.mostrarvalor9PresupuestosFlujosCaja= mostrarvalor9PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor9PresupuestosFlujosCaja() {
		return this.activarvalor9PresupuestosFlujosCaja;
	}

	public void setActivarvalor9PresupuestosFlujosCaja(Boolean activarvalor9PresupuestosFlujosCaja) {
		this.activarvalor9PresupuestosFlujosCaja= activarvalor9PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor10PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor10PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor10PresupuestosFlujosCaja() {
		return this.resaltarvalor10PresupuestosFlujosCaja;
	}

	public void setResaltarvalor10PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor10PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor10PresupuestosFlujosCaja() {
		return this.mostrarvalor10PresupuestosFlujosCaja;
	}

	public void setMostrarvalor10PresupuestosFlujosCaja(Boolean mostrarvalor10PresupuestosFlujosCaja) {
		this.mostrarvalor10PresupuestosFlujosCaja= mostrarvalor10PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor10PresupuestosFlujosCaja() {
		return this.activarvalor10PresupuestosFlujosCaja;
	}

	public void setActivarvalor10PresupuestosFlujosCaja(Boolean activarvalor10PresupuestosFlujosCaja) {
		this.activarvalor10PresupuestosFlujosCaja= activarvalor10PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor11PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor11PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor11PresupuestosFlujosCaja() {
		return this.resaltarvalor11PresupuestosFlujosCaja;
	}

	public void setResaltarvalor11PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor11PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor11PresupuestosFlujosCaja() {
		return this.mostrarvalor11PresupuestosFlujosCaja;
	}

	public void setMostrarvalor11PresupuestosFlujosCaja(Boolean mostrarvalor11PresupuestosFlujosCaja) {
		this.mostrarvalor11PresupuestosFlujosCaja= mostrarvalor11PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor11PresupuestosFlujosCaja() {
		return this.activarvalor11PresupuestosFlujosCaja;
	}

	public void setActivarvalor11PresupuestosFlujosCaja(Boolean activarvalor11PresupuestosFlujosCaja) {
		this.activarvalor11PresupuestosFlujosCaja= activarvalor11PresupuestosFlujosCaja;
	}

	public Border setResaltarvalor12PresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarvalor12PresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor12PresupuestosFlujosCaja() {
		return this.resaltarvalor12PresupuestosFlujosCaja;
	}

	public void setResaltarvalor12PresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarvalor12PresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarvalor12PresupuestosFlujosCaja() {
		return this.mostrarvalor12PresupuestosFlujosCaja;
	}

	public void setMostrarvalor12PresupuestosFlujosCaja(Boolean mostrarvalor12PresupuestosFlujosCaja) {
		this.mostrarvalor12PresupuestosFlujosCaja= mostrarvalor12PresupuestosFlujosCaja;
	}

	public Boolean getActivarvalor12PresupuestosFlujosCaja() {
		return this.activarvalor12PresupuestosFlujosCaja;
	}

	public void setActivarvalor12PresupuestosFlujosCaja(Boolean activarvalor12PresupuestosFlujosCaja) {
		this.activarvalor12PresupuestosFlujosCaja= activarvalor12PresupuestosFlujosCaja;
	}

	public Border setResaltartotalPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestosflujoscajaBeanSwingJInternalFrame.jTtoolBarPresupuestosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltartotalPresupuestosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPresupuestosFlujosCaja() {
		return this.resaltartotalPresupuestosFlujosCaja;
	}

	public void setResaltartotalPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltartotalPresupuestosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrartotalPresupuestosFlujosCaja() {
		return this.mostrartotalPresupuestosFlujosCaja;
	}

	public void setMostrartotalPresupuestosFlujosCaja(Boolean mostrartotalPresupuestosFlujosCaja) {
		this.mostrartotalPresupuestosFlujosCaja= mostrartotalPresupuestosFlujosCaja;
	}

	public Boolean getActivartotalPresupuestosFlujosCaja() {
		return this.activartotalPresupuestosFlujosCaja;
	}

	public void setActivartotalPresupuestosFlujosCaja(Boolean activartotalPresupuestosFlujosCaja) {
		this.activartotalPresupuestosFlujosCaja= activartotalPresupuestosFlujosCaja;
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
		
		
		this.setMostraridPresupuestosFlujosCaja(esInicial);
		this.setMostrarid_empresaPresupuestosFlujosCaja(esInicial);
		this.setMostrarcodigo_cuentaPresupuestosFlujosCaja(esInicial);
		this.setMostrarcodigoPresupuestosFlujosCaja(esInicial);
		this.setMostrarnombrePresupuestosFlujosCaja(esInicial);
		this.setMostrarnombre_moduloPresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor1PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor2PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor3PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor4PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor5PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor6PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor7PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor8PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor9PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor10PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor11PresupuestosFlujosCaja(esInicial);
		this.setMostrarvalor12PresupuestosFlujosCaja(esInicial);
		this.setMostrartotalPresupuestosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.ID)) {
				this.setMostraridPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA)) {
				this.setMostrarcodigo_cuentaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO)) {
				this.setMostrarnombre_moduloPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR1)) {
				this.setMostrarvalor1PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR2)) {
				this.setMostrarvalor2PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR3)) {
				this.setMostrarvalor3PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR4)) {
				this.setMostrarvalor4PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR5)) {
				this.setMostrarvalor5PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR6)) {
				this.setMostrarvalor6PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR7)) {
				this.setMostrarvalor7PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR8)) {
				this.setMostrarvalor8PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR9)) {
				this.setMostrarvalor9PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR10)) {
				this.setMostrarvalor10PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR11)) {
				this.setMostrarvalor11PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR12)) {
				this.setMostrarvalor12PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.TOTAL)) {
				this.setMostrartotalPresupuestosFlujosCaja(esAsigna);
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
		
		
		this.setActivaridPresupuestosFlujosCaja(esInicial);
		this.setActivarid_empresaPresupuestosFlujosCaja(esInicial);
		this.setActivarcodigo_cuentaPresupuestosFlujosCaja(esInicial);
		this.setActivarcodigoPresupuestosFlujosCaja(esInicial);
		this.setActivarnombrePresupuestosFlujosCaja(esInicial);
		this.setActivarnombre_moduloPresupuestosFlujosCaja(esInicial);
		this.setActivarvalor1PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor2PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor3PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor4PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor5PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor6PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor7PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor8PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor9PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor10PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor11PresupuestosFlujosCaja(esInicial);
		this.setActivarvalor12PresupuestosFlujosCaja(esInicial);
		this.setActivartotalPresupuestosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.ID)) {
				this.setActivaridPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA)) {
				this.setActivarcodigo_cuentaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO)) {
				this.setActivarnombre_moduloPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR1)) {
				this.setActivarvalor1PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR2)) {
				this.setActivarvalor2PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR3)) {
				this.setActivarvalor3PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR4)) {
				this.setActivarvalor4PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR5)) {
				this.setActivarvalor5PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR6)) {
				this.setActivarvalor6PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR7)) {
				this.setActivarvalor7PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR8)) {
				this.setActivarvalor8PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR9)) {
				this.setActivarvalor9PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR10)) {
				this.setActivarvalor10PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR11)) {
				this.setActivarvalor11PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR12)) {
				this.setActivarvalor12PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.TOTAL)) {
				this.setActivartotalPresupuestosFlujosCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestosFlujosCaja(esInicial);
		this.setResaltarid_empresaPresupuestosFlujosCaja(esInicial);
		this.setResaltarcodigo_cuentaPresupuestosFlujosCaja(esInicial);
		this.setResaltarcodigoPresupuestosFlujosCaja(esInicial);
		this.setResaltarnombrePresupuestosFlujosCaja(esInicial);
		this.setResaltarnombre_moduloPresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor1PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor2PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor3PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor4PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor5PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor6PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor7PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor8PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor9PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor10PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor11PresupuestosFlujosCaja(esInicial);
		this.setResaltarvalor12PresupuestosFlujosCaja(esInicial);
		this.setResaltartotalPresupuestosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.ID)) {
				this.setResaltaridPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGOCUENTA)) {
				this.setResaltarcodigo_cuentaPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.NOMBREMODULO)) {
				this.setResaltarnombre_moduloPresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR1)) {
				this.setResaltarvalor1PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR2)) {
				this.setResaltarvalor2PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR3)) {
				this.setResaltarvalor3PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR4)) {
				this.setResaltarvalor4PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR5)) {
				this.setResaltarvalor5PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR6)) {
				this.setResaltarvalor6PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR7)) {
				this.setResaltarvalor7PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR8)) {
				this.setResaltarvalor8PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR9)) {
				this.setResaltarvalor9PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR10)) {
				this.setResaltarvalor10PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR11)) {
				this.setResaltarvalor11PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.VALOR12)) {
				this.setResaltarvalor12PresupuestosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestosFlujosCajaConstantesFunciones.TOTAL)) {
				this.setResaltartotalPresupuestosFlujosCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja=true;

	public Boolean getMostrarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja() {
		return this.mostrarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja;
	}

	public void setMostrarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja=true;

	public Boolean getActivarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja() {
		return this.activarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja;
	}

	public void setActivarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja=null;

	public Border getResaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja() {
		return this.resaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja;
	}

	public void setResaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja(Border borderResaltar) {
		this.resaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja= borderResaltar;
	}

	public void setResaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestosFlujosCajaBeanSwingJInternalFrame presupuestosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPresupuestosFlujosCajaPresupuestosFlujosCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}