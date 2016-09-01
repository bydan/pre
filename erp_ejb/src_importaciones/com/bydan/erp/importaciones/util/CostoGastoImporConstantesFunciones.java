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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.CostoGastoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.CostoGastoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.CostoGastoImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CostoGastoImporConstantesFunciones extends CostoGastoImporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CostoGastoImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CostoGastoImpor"+CostoGastoImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CostoGastoImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CostoGastoImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CostoGastoImporConstantesFunciones.SCHEMA+"_"+CostoGastoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CostoGastoImporConstantesFunciones.SCHEMA+"_"+CostoGastoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CostoGastoImporConstantesFunciones.SCHEMA+"_"+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CostoGastoImporConstantesFunciones.SCHEMA+"_"+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CostoGastoImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CostoGastoImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CostoGastoImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CostoGastoImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Costo Gasto Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Costo Gasto Impor";
	public static final String SCLASSWEBTITULO_LOWER="Costo Gasto Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CostoGastoImpor";
	public static final String OBJECTNAME="costogastoimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="costo_gasto_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select costogastoimpor from "+CostoGastoImporConstantesFunciones.SPERSISTENCENAME+" costogastoimpor";
	public static String QUERYSELECTNATIVE="select "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_empresa,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_sucursal,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_tipo_costo_gasto_impor,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".nombre,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".es_activo,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_agrupa,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_prorratea,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_factura,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_flete,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_arancel,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_seguro,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_total_general,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_digitado from "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME;//+" as "+CostoGastoImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CostoGastoImporConstantesFuncionesAdditional costogastoimporConstantesFuncionesAdditional=null;
	
	public CostoGastoImporConstantesFuncionesAdditional getCostoGastoImporConstantesFuncionesAdditional() {
		return this.costogastoimporConstantesFuncionesAdditional;
	}
	
	public void setCostoGastoImporConstantesFuncionesAdditional(CostoGastoImporConstantesFuncionesAdditional costogastoimporConstantesFuncionesAdditional) {
		try {
			this.costogastoimporConstantesFuncionesAdditional=costogastoimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOCOSTOGASTOIMPOR= "id_tipo_costo_gasto_impor";
    public static final String NOMBRE= "nombre";
    public static final String ESACTIVO= "es_activo";
    public static final String CONAGRUPA= "con_agrupa";
    public static final String CONPRORRATEA= "con_prorratea";
    public static final String CONFACTURA= "con_factura";
    public static final String CONFLETE= "con_flete";
    public static final String CONARANCEL= "con_arancel";
    public static final String CONSEGURO= "con_seguro";
    public static final String CONTOTALGENERAL= "con_total_general";
    public static final String CONDIGITADO= "con_digitado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOCOSTOGASTOIMPOR= "Tipo Costo Gasto Impor";
		public static final String LABEL_IDTIPOCOSTOGASTOIMPOR_LOWER= "Tipo Costo Gasto Impor";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
    	public static final String LABEL_CONAGRUPA= "Con Agrupa";
		public static final String LABEL_CONAGRUPA_LOWER= "Con Agrupa";
    	public static final String LABEL_CONPRORRATEA= "Con Prorratea";
		public static final String LABEL_CONPRORRATEA_LOWER= "Con Prorratea";
    	public static final String LABEL_CONFACTURA= "Con Factura";
		public static final String LABEL_CONFACTURA_LOWER= "Con Factura";
    	public static final String LABEL_CONFLETE= "Con Flete";
		public static final String LABEL_CONFLETE_LOWER= "Con Flete";
    	public static final String LABEL_CONARANCEL= "Con Arancel";
		public static final String LABEL_CONARANCEL_LOWER= "Con Arancel";
    	public static final String LABEL_CONSEGURO= "Con Seguro";
		public static final String LABEL_CONSEGURO_LOWER= "Con Seguro";
    	public static final String LABEL_CONTOTALGENERAL= "Con Total General";
		public static final String LABEL_CONTOTALGENERAL_LOWER= "Con Total General";
    	public static final String LABEL_CONDIGITADO= "Con Digitado";
		public static final String LABEL_CONDIGITADO_LOWER= "Con Digitado";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getCostoGastoImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_IDTIPOCOSTOGASTOIMPOR;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.NOMBRE)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.ESACTIVO)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_ESACTIVO;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONAGRUPA)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONAGRUPA;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONPRORRATEA)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONPRORRATEA;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONFACTURA)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONFACTURA;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONFLETE)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONFLETE;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONARANCEL)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONARANCEL;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONSEGURO)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONSEGURO;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONTOTALGENERAL)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONTOTALGENERAL;}
		if(sNombreColumna.equals(CostoGastoImporConstantesFunciones.CONDIGITADO)) {sLabelColumna=CostoGastoImporConstantesFunciones.LABEL_CONDIGITADO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getes_activoDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getes_activo());

		return sDescripcion;
	}	
		
	public static String getcon_agrupaDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_agrupa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_agrupaHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_agrupa());

		return sDescripcion;
	}	
		
	public static String getcon_prorrateaDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_prorratea()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_prorrateaHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_prorratea());

		return sDescripcion;
	}	
		
	public static String getcon_facturaDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_facturaHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_factura());

		return sDescripcion;
	}	
		
	public static String getcon_fleteDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_flete()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_fleteHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_flete());

		return sDescripcion;
	}	
		
	public static String getcon_arancelDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_arancel()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_arancelHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_arancel());

		return sDescripcion;
	}	
		
	public static String getcon_seguroDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_seguro()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_seguroHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_seguro());

		return sDescripcion;
	}	
		
	public static String getcon_total_generalDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_total_general()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_total_generalHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_total_general());

		return sDescripcion;
	}	
		
	public static String getcon_digitadoDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!costogastoimpor.getcon_digitado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_digitadoHtmlDescripcion(CostoGastoImpor costogastoimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(costogastoimpor.getId(),costogastoimpor.getcon_digitado());

		return sDescripcion;
	}	
	
	public static String getCostoGastoImporDescripcion(CostoGastoImpor costogastoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(costogastoimpor !=null/* && costogastoimpor.getId()!=0*/) {
			sDescripcion=costogastoimpor.getnombre();//costogastoimporcostogastoimpor.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCostoGastoImporDescripcionDetallado(CostoGastoImpor costogastoimpor) {
		String sDescripcion="";
			
		sDescripcion+=CostoGastoImporConstantesFunciones.ID+"=";
		sDescripcion+=costogastoimpor.getId().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=costogastoimpor.getVersionRow().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=costogastoimpor.getid_empresa().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=costogastoimpor.getid_sucursal().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR+"=";
		sDescripcion+=costogastoimpor.getid_tipo_costo_gasto_impor().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.NOMBRE+"=";
		sDescripcion+=costogastoimpor.getnombre()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=costogastoimpor.getes_activo().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONAGRUPA+"=";
		sDescripcion+=costogastoimpor.getcon_agrupa().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONPRORRATEA+"=";
		sDescripcion+=costogastoimpor.getcon_prorratea().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONFACTURA+"=";
		sDescripcion+=costogastoimpor.getcon_factura().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONFLETE+"=";
		sDescripcion+=costogastoimpor.getcon_flete().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONARANCEL+"=";
		sDescripcion+=costogastoimpor.getcon_arancel().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONSEGURO+"=";
		sDescripcion+=costogastoimpor.getcon_seguro().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONTOTALGENERAL+"=";
		sDescripcion+=costogastoimpor.getcon_total_general().toString()+",";
		sDescripcion+=CostoGastoImporConstantesFunciones.CONDIGITADO+"=";
		sDescripcion+=costogastoimpor.getcon_digitado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCostoGastoImporDescripcion(CostoGastoImpor costogastoimpor,String sValor) throws Exception {			
		if(costogastoimpor !=null) {
			costogastoimpor.setnombre(sValor);;//costogastoimporcostogastoimpor.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTipoCostoGastoImporDescripcion(TipoCostoGastoImpor tipocostogastoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocostogastoimpor!=null/*&&tipocostogastoimpor.getId()>0*/) {
			sDescripcion=TipoCostoGastoImporConstantesFunciones.getTipoCostoGastoImporDescripcion(tipocostogastoimpor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCostoGastoImpor")) {
			sNombreIndice="Tipo=  Por Tipo Costo Gasto Impor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCostoGastoImpor(Long id_tipo_costo_gasto_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costo_gasto_impor!=null) {sDetalleIndice+=" Codigo Unico De Tipo Costo Gasto Impor="+id_tipo_costo_gasto_impor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCostoGastoImpor(CostoGastoImpor costogastoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		costogastoimpor.setnombre(costogastoimpor.getnombre().trim());
	}
	
	public static void quitarEspaciosCostoGastoImpors(List<CostoGastoImpor> costogastoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CostoGastoImpor costogastoimpor: costogastoimpors) {
			costogastoimpor.setnombre(costogastoimpor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCostoGastoImpor(CostoGastoImpor costogastoimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && costogastoimpor.getConCambioAuxiliar()) {
			costogastoimpor.setIsDeleted(costogastoimpor.getIsDeletedAuxiliar());	
			costogastoimpor.setIsNew(costogastoimpor.getIsNewAuxiliar());	
			costogastoimpor.setIsChanged(costogastoimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			costogastoimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			costogastoimpor.setIsDeletedAuxiliar(false);	
			costogastoimpor.setIsNewAuxiliar(false);	
			costogastoimpor.setIsChangedAuxiliar(false);
			
			costogastoimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCostoGastoImpors(List<CostoGastoImpor> costogastoimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CostoGastoImpor costogastoimpor : costogastoimpors) {
			if(conAsignarBase && costogastoimpor.getConCambioAuxiliar()) {
				costogastoimpor.setIsDeleted(costogastoimpor.getIsDeletedAuxiliar());	
				costogastoimpor.setIsNew(costogastoimpor.getIsNewAuxiliar());	
				costogastoimpor.setIsChanged(costogastoimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				costogastoimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				costogastoimpor.setIsDeletedAuxiliar(false);	
				costogastoimpor.setIsNewAuxiliar(false);	
				costogastoimpor.setIsChangedAuxiliar(false);
				
				costogastoimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCostoGastoImpor(CostoGastoImpor costogastoimpor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCostoGastoImpors(List<CostoGastoImpor> costogastoimpors,Boolean conEnteros) throws Exception  {
		
		for(CostoGastoImpor costogastoimpor: costogastoimpors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCostoGastoImpor(List<CostoGastoImpor> costogastoimpors,CostoGastoImpor costogastoimporAux) throws Exception  {
		CostoGastoImporConstantesFunciones.InicializarValoresCostoGastoImpor(costogastoimporAux,true);
		
		for(CostoGastoImpor costogastoimpor: costogastoimpors) {
			if(costogastoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CostoGastoImporConstantesFunciones.getArrayColumnasGlobalesCostoGastoImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoGastoImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoGastoImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoGastoImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoGastoImporConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CostoGastoImpor> costogastoimpors,CostoGastoImpor costogastoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CostoGastoImpor costogastoimporAux: costogastoimpors) {
			if(costogastoimporAux!=null && costogastoimpor!=null) {
				if((costogastoimporAux.getId()==null && costogastoimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(costogastoimporAux.getId()!=null && costogastoimpor.getId()!=null){
					if(costogastoimporAux.getId().equals(costogastoimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCostoGastoImpor(List<CostoGastoImpor> costogastoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CostoGastoImpor costogastoimpor: costogastoimpors) {			
			if(costogastoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCostoGastoImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_ID, CostoGastoImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_VERSIONROW, CostoGastoImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_IDEMPRESA, CostoGastoImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_IDSUCURSAL, CostoGastoImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_IDTIPOCOSTOGASTOIMPOR, CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_NOMBRE, CostoGastoImporConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_ESACTIVO, CostoGastoImporConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONAGRUPA, CostoGastoImporConstantesFunciones.CONAGRUPA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONPRORRATEA, CostoGastoImporConstantesFunciones.CONPRORRATEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONFACTURA, CostoGastoImporConstantesFunciones.CONFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONFLETE, CostoGastoImporConstantesFunciones.CONFLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONARANCEL, CostoGastoImporConstantesFunciones.CONARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONSEGURO, CostoGastoImporConstantesFunciones.CONSEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONTOTALGENERAL, CostoGastoImporConstantesFunciones.CONTOTALGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoGastoImporConstantesFunciones.LABEL_CONDIGITADO, CostoGastoImporConstantesFunciones.CONDIGITADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCostoGastoImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONAGRUPA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONPRORRATEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONFLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONSEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONTOTALGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoGastoImporConstantesFunciones.CONDIGITADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCostoGastoImpor() throws Exception  {
		return CostoGastoImporConstantesFunciones.getTiposSeleccionarCostoGastoImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCostoGastoImpor(Boolean conFk) throws Exception  {
		return CostoGastoImporConstantesFunciones.getTiposSeleccionarCostoGastoImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCostoGastoImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_IDTIPOCOSTOGASTOIMPOR);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_IDTIPOCOSTOGASTOIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONAGRUPA);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONAGRUPA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONPRORRATEA);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONPRORRATEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONFACTURA);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONFLETE);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONFLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONARANCEL);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONSEGURO);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONSEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONTOTALGENERAL);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONTOTALGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoGastoImporConstantesFunciones.LABEL_CONDIGITADO);
			reporte.setsDescripcion(CostoGastoImporConstantesFunciones.LABEL_CONDIGITADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCostoGastoImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCostoGastoImpor(CostoGastoImpor costogastoimporAux) throws Exception {
		
			costogastoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(costogastoimporAux.getEmpresa()));
			costogastoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(costogastoimporAux.getSucursal()));
			costogastoimporAux.settipocostogastoimpor_descripcion(TipoCostoGastoImporConstantesFunciones.getTipoCostoGastoImporDescripcion(costogastoimporAux.getTipoCostoGastoImpor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCostoGastoImpor(List<CostoGastoImpor> costogastoimporsTemp) throws Exception {
		for(CostoGastoImpor costogastoimporAux:costogastoimporsTemp) {
			
			costogastoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(costogastoimporAux.getEmpresa()));
			costogastoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(costogastoimporAux.getSucursal()));
			costogastoimporAux.settipocostogastoimpor_descripcion(TipoCostoGastoImporConstantesFunciones.getTipoCostoGastoImporDescripcion(costogastoimporAux.getTipoCostoGastoImpor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoCostoGastoImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCostoGastoImpor.class)) {
						classes.add(new Classe(TipoCostoGastoImpor.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoCostoGastoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCostoGastoImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoCostoGastoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCostoGastoImpor.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CostoGastoImporConstantesFunciones.getClassesRelationshipsOfCostoGastoImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleLiquidacionImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleLiquidacionImpor.class)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CostoGastoImporConstantesFunciones.getClassesRelationshipsFromStringsOfCostoGastoImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
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
	public static void actualizarLista(CostoGastoImpor costogastoimpor,List<CostoGastoImpor> costogastoimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CostoGastoImpor costogastoimporEncontrado=null;
			
			for(CostoGastoImpor costogastoimporLocal:costogastoimpors) {
				if(costogastoimporLocal.getId().equals(costogastoimpor.getId())) {
					costogastoimporEncontrado=costogastoimporLocal;
					
					costogastoimporLocal.setIsChanged(costogastoimpor.getIsChanged());
					costogastoimporLocal.setIsNew(costogastoimpor.getIsNew());
					costogastoimporLocal.setIsDeleted(costogastoimpor.getIsDeleted());
					
					costogastoimporLocal.setGeneralEntityOriginal(costogastoimpor.getGeneralEntityOriginal());
					
					costogastoimporLocal.setId(costogastoimpor.getId());	
					costogastoimporLocal.setVersionRow(costogastoimpor.getVersionRow());	
					costogastoimporLocal.setid_empresa(costogastoimpor.getid_empresa());	
					costogastoimporLocal.setid_sucursal(costogastoimpor.getid_sucursal());	
					costogastoimporLocal.setid_tipo_costo_gasto_impor(costogastoimpor.getid_tipo_costo_gasto_impor());	
					costogastoimporLocal.setnombre(costogastoimpor.getnombre());	
					costogastoimporLocal.setes_activo(costogastoimpor.getes_activo());	
					costogastoimporLocal.setcon_agrupa(costogastoimpor.getcon_agrupa());	
					costogastoimporLocal.setcon_prorratea(costogastoimpor.getcon_prorratea());	
					costogastoimporLocal.setcon_factura(costogastoimpor.getcon_factura());	
					costogastoimporLocal.setcon_flete(costogastoimpor.getcon_flete());	
					costogastoimporLocal.setcon_arancel(costogastoimpor.getcon_arancel());	
					costogastoimporLocal.setcon_seguro(costogastoimpor.getcon_seguro());	
					costogastoimporLocal.setcon_total_general(costogastoimpor.getcon_total_general());	
					costogastoimporLocal.setcon_digitado(costogastoimpor.getcon_digitado());	
					
					
					costogastoimporLocal.setDetalleLiquidacionImpors(costogastoimpor.getDetalleLiquidacionImpors());
					
					existe=true;
					break;
				}
			}
			
			if(!costogastoimpor.getIsDeleted()) {
				if(!existe) {
					costogastoimpors.add(costogastoimpor);
				}
			} else {
				if(costogastoimporEncontrado!=null && permiteQuitar)  {
					costogastoimpors.remove(costogastoimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CostoGastoImpor costogastoimpor,List<CostoGastoImpor> costogastoimpors) throws Exception {
		try	{			
			for(CostoGastoImpor costogastoimporLocal:costogastoimpors) {
				if(costogastoimporLocal.getId().equals(costogastoimpor.getId())) {
					costogastoimporLocal.setIsSelected(costogastoimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCostoGastoImpor(List<CostoGastoImpor> costogastoimporsAux) throws Exception {
		//this.costogastoimporsAux=costogastoimporsAux;
		
		for(CostoGastoImpor costogastoimporAux:costogastoimporsAux) {
			if(costogastoimporAux.getIsChanged()) {
				costogastoimporAux.setIsChanged(false);
			}		
			
			if(costogastoimporAux.getIsNew()) {
				costogastoimporAux.setIsNew(false);
			}	
			
			if(costogastoimporAux.getIsDeleted()) {
				costogastoimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCostoGastoImpor(CostoGastoImpor costogastoimporAux) throws Exception {
		//this.costogastoimporAux=costogastoimporAux;
		
			if(costogastoimporAux.getIsChanged()) {
				costogastoimporAux.setIsChanged(false);
			}		
			
			if(costogastoimporAux.getIsNew()) {
				costogastoimporAux.setIsNew(false);
			}	
			
			if(costogastoimporAux.getIsDeleted()) {
				costogastoimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CostoGastoImpor costogastoimporAsignar,CostoGastoImpor costogastoimpor) throws Exception {
		costogastoimporAsignar.setId(costogastoimpor.getId());	
		costogastoimporAsignar.setVersionRow(costogastoimpor.getVersionRow());	
		costogastoimporAsignar.setid_empresa(costogastoimpor.getid_empresa());
		costogastoimporAsignar.setempresa_descripcion(costogastoimpor.getempresa_descripcion());	
		costogastoimporAsignar.setid_sucursal(costogastoimpor.getid_sucursal());
		costogastoimporAsignar.setsucursal_descripcion(costogastoimpor.getsucursal_descripcion());	
		costogastoimporAsignar.setid_tipo_costo_gasto_impor(costogastoimpor.getid_tipo_costo_gasto_impor());
		costogastoimporAsignar.settipocostogastoimpor_descripcion(costogastoimpor.gettipocostogastoimpor_descripcion());	
		costogastoimporAsignar.setnombre(costogastoimpor.getnombre());	
		costogastoimporAsignar.setes_activo(costogastoimpor.getes_activo());	
		costogastoimporAsignar.setcon_agrupa(costogastoimpor.getcon_agrupa());	
		costogastoimporAsignar.setcon_prorratea(costogastoimpor.getcon_prorratea());	
		costogastoimporAsignar.setcon_factura(costogastoimpor.getcon_factura());	
		costogastoimporAsignar.setcon_flete(costogastoimpor.getcon_flete());	
		costogastoimporAsignar.setcon_arancel(costogastoimpor.getcon_arancel());	
		costogastoimporAsignar.setcon_seguro(costogastoimpor.getcon_seguro());	
		costogastoimporAsignar.setcon_total_general(costogastoimpor.getcon_total_general());	
		costogastoimporAsignar.setcon_digitado(costogastoimpor.getcon_digitado());	
	}
	
	public static void inicializarCostoGastoImpor(CostoGastoImpor costogastoimpor) throws Exception {
		try {
				costogastoimpor.setId(0L);	
					
				costogastoimpor.setid_empresa(-1L);	
				costogastoimpor.setid_sucursal(-1L);	
				costogastoimpor.setid_tipo_costo_gasto_impor(-1L);	
				costogastoimpor.setnombre("");	
				costogastoimpor.setes_activo(false);	
				costogastoimpor.setcon_agrupa(false);	
				costogastoimpor.setcon_prorratea(false);	
				costogastoimpor.setcon_factura(false);	
				costogastoimpor.setcon_flete(false);	
				costogastoimpor.setcon_arancel(false);	
				costogastoimpor.setcon_seguro(false);	
				costogastoimpor.setcon_total_general(false);	
				costogastoimpor.setcon_digitado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCostoGastoImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_IDTIPOCOSTOGASTOIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONAGRUPA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONPRORRATEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONFLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONSEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONTOTALGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoGastoImporConstantesFunciones.LABEL_CONDIGITADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCostoGastoImpor(String sTipo,Row row,Workbook workbook,CostoGastoImpor costogastoimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(costogastoimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costogastoimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costogastoimpor.gettipocostogastoimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costogastoimpor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_agrupa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_prorratea()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_flete()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_arancel()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_seguro()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_total_general()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(costogastoimpor.getcon_digitado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCostoGastoImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCostoGastoImpor() {
		return this.sFinalQueryCostoGastoImpor;
	}
	
	public void setsFinalQueryCostoGastoImpor(String sFinalQueryCostoGastoImpor) {
		this.sFinalQueryCostoGastoImpor= sFinalQueryCostoGastoImpor;
	}
	
	public Border resaltarSeleccionarCostoGastoImpor=null;
	
	public Border setResaltarSeleccionarCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCostoGastoImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCostoGastoImpor() {
		return this.resaltarSeleccionarCostoGastoImpor;
	}
	
	public void setResaltarSeleccionarCostoGastoImpor(Border borderResaltarSeleccionarCostoGastoImpor) {
		this.resaltarSeleccionarCostoGastoImpor= borderResaltarSeleccionarCostoGastoImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCostoGastoImpor=null;
	public Boolean mostraridCostoGastoImpor=true;
	public Boolean activaridCostoGastoImpor=true;

	public Border resaltarid_empresaCostoGastoImpor=null;
	public Boolean mostrarid_empresaCostoGastoImpor=true;
	public Boolean activarid_empresaCostoGastoImpor=true;
	public Boolean cargarid_empresaCostoGastoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCostoGastoImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalCostoGastoImpor=null;
	public Boolean mostrarid_sucursalCostoGastoImpor=true;
	public Boolean activarid_sucursalCostoGastoImpor=true;
	public Boolean cargarid_sucursalCostoGastoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCostoGastoImpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_costo_gasto_imporCostoGastoImpor=null;
	public Boolean mostrarid_tipo_costo_gasto_imporCostoGastoImpor=true;
	public Boolean activarid_tipo_costo_gasto_imporCostoGastoImpor=true;
	public Boolean cargarid_tipo_costo_gasto_imporCostoGastoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costo_gasto_imporCostoGastoImpor=false;//ConEventDepend=true

	public Border resaltarnombreCostoGastoImpor=null;
	public Boolean mostrarnombreCostoGastoImpor=true;
	public Boolean activarnombreCostoGastoImpor=true;

	public Border resaltares_activoCostoGastoImpor=null;
	public Boolean mostrares_activoCostoGastoImpor=true;
	public Boolean activares_activoCostoGastoImpor=true;

	public Border resaltarcon_agrupaCostoGastoImpor=null;
	public Boolean mostrarcon_agrupaCostoGastoImpor=true;
	public Boolean activarcon_agrupaCostoGastoImpor=true;

	public Border resaltarcon_prorrateaCostoGastoImpor=null;
	public Boolean mostrarcon_prorrateaCostoGastoImpor=true;
	public Boolean activarcon_prorrateaCostoGastoImpor=true;

	public Border resaltarcon_facturaCostoGastoImpor=null;
	public Boolean mostrarcon_facturaCostoGastoImpor=true;
	public Boolean activarcon_facturaCostoGastoImpor=true;

	public Border resaltarcon_fleteCostoGastoImpor=null;
	public Boolean mostrarcon_fleteCostoGastoImpor=true;
	public Boolean activarcon_fleteCostoGastoImpor=true;

	public Border resaltarcon_arancelCostoGastoImpor=null;
	public Boolean mostrarcon_arancelCostoGastoImpor=true;
	public Boolean activarcon_arancelCostoGastoImpor=true;

	public Border resaltarcon_seguroCostoGastoImpor=null;
	public Boolean mostrarcon_seguroCostoGastoImpor=true;
	public Boolean activarcon_seguroCostoGastoImpor=true;

	public Border resaltarcon_total_generalCostoGastoImpor=null;
	public Boolean mostrarcon_total_generalCostoGastoImpor=true;
	public Boolean activarcon_total_generalCostoGastoImpor=true;

	public Border resaltarcon_digitadoCostoGastoImpor=null;
	public Boolean mostrarcon_digitadoCostoGastoImpor=true;
	public Boolean activarcon_digitadoCostoGastoImpor=true;

	
	

	public Border setResaltaridCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltaridCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCostoGastoImpor() {
		return this.resaltaridCostoGastoImpor;
	}

	public void setResaltaridCostoGastoImpor(Border borderResaltar) {
		this.resaltaridCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostraridCostoGastoImpor() {
		return this.mostraridCostoGastoImpor;
	}

	public void setMostraridCostoGastoImpor(Boolean mostraridCostoGastoImpor) {
		this.mostraridCostoGastoImpor= mostraridCostoGastoImpor;
	}

	public Boolean getActivaridCostoGastoImpor() {
		return this.activaridCostoGastoImpor;
	}

	public void setActivaridCostoGastoImpor(Boolean activaridCostoGastoImpor) {
		this.activaridCostoGastoImpor= activaridCostoGastoImpor;
	}

	public Border setResaltarid_empresaCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCostoGastoImpor() {
		return this.resaltarid_empresaCostoGastoImpor;
	}

	public void setResaltarid_empresaCostoGastoImpor(Border borderResaltar) {
		this.resaltarid_empresaCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaCostoGastoImpor() {
		return this.mostrarid_empresaCostoGastoImpor;
	}

	public void setMostrarid_empresaCostoGastoImpor(Boolean mostrarid_empresaCostoGastoImpor) {
		this.mostrarid_empresaCostoGastoImpor= mostrarid_empresaCostoGastoImpor;
	}

	public Boolean getActivarid_empresaCostoGastoImpor() {
		return this.activarid_empresaCostoGastoImpor;
	}

	public void setActivarid_empresaCostoGastoImpor(Boolean activarid_empresaCostoGastoImpor) {
		this.activarid_empresaCostoGastoImpor= activarid_empresaCostoGastoImpor;
	}

	public Boolean getCargarid_empresaCostoGastoImpor() {
		return this.cargarid_empresaCostoGastoImpor;
	}

	public void setCargarid_empresaCostoGastoImpor(Boolean cargarid_empresaCostoGastoImpor) {
		this.cargarid_empresaCostoGastoImpor= cargarid_empresaCostoGastoImpor;
	}

	public Border setResaltarid_sucursalCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCostoGastoImpor() {
		return this.resaltarid_sucursalCostoGastoImpor;
	}

	public void setResaltarid_sucursalCostoGastoImpor(Border borderResaltar) {
		this.resaltarid_sucursalCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCostoGastoImpor() {
		return this.mostrarid_sucursalCostoGastoImpor;
	}

	public void setMostrarid_sucursalCostoGastoImpor(Boolean mostrarid_sucursalCostoGastoImpor) {
		this.mostrarid_sucursalCostoGastoImpor= mostrarid_sucursalCostoGastoImpor;
	}

	public Boolean getActivarid_sucursalCostoGastoImpor() {
		return this.activarid_sucursalCostoGastoImpor;
	}

	public void setActivarid_sucursalCostoGastoImpor(Boolean activarid_sucursalCostoGastoImpor) {
		this.activarid_sucursalCostoGastoImpor= activarid_sucursalCostoGastoImpor;
	}

	public Boolean getCargarid_sucursalCostoGastoImpor() {
		return this.cargarid_sucursalCostoGastoImpor;
	}

	public void setCargarid_sucursalCostoGastoImpor(Boolean cargarid_sucursalCostoGastoImpor) {
		this.cargarid_sucursalCostoGastoImpor= cargarid_sucursalCostoGastoImpor;
	}

	public Border setResaltarid_tipo_costo_gasto_imporCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costo_gasto_imporCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costo_gasto_imporCostoGastoImpor() {
		return this.resaltarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public void setResaltarid_tipo_costo_gasto_imporCostoGastoImpor(Border borderResaltar) {
		this.resaltarid_tipo_costo_gasto_imporCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costo_gasto_imporCostoGastoImpor() {
		return this.mostrarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public void setMostrarid_tipo_costo_gasto_imporCostoGastoImpor(Boolean mostrarid_tipo_costo_gasto_imporCostoGastoImpor) {
		this.mostrarid_tipo_costo_gasto_imporCostoGastoImpor= mostrarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public Boolean getActivarid_tipo_costo_gasto_imporCostoGastoImpor() {
		return this.activarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public void setActivarid_tipo_costo_gasto_imporCostoGastoImpor(Boolean activarid_tipo_costo_gasto_imporCostoGastoImpor) {
		this.activarid_tipo_costo_gasto_imporCostoGastoImpor= activarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public Boolean getCargarid_tipo_costo_gasto_imporCostoGastoImpor() {
		return this.cargarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public void setCargarid_tipo_costo_gasto_imporCostoGastoImpor(Boolean cargarid_tipo_costo_gasto_imporCostoGastoImpor) {
		this.cargarid_tipo_costo_gasto_imporCostoGastoImpor= cargarid_tipo_costo_gasto_imporCostoGastoImpor;
	}

	public Border setResaltarnombreCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarnombreCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCostoGastoImpor() {
		return this.resaltarnombreCostoGastoImpor;
	}

	public void setResaltarnombreCostoGastoImpor(Border borderResaltar) {
		this.resaltarnombreCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarnombreCostoGastoImpor() {
		return this.mostrarnombreCostoGastoImpor;
	}

	public void setMostrarnombreCostoGastoImpor(Boolean mostrarnombreCostoGastoImpor) {
		this.mostrarnombreCostoGastoImpor= mostrarnombreCostoGastoImpor;
	}

	public Boolean getActivarnombreCostoGastoImpor() {
		return this.activarnombreCostoGastoImpor;
	}

	public void setActivarnombreCostoGastoImpor(Boolean activarnombreCostoGastoImpor) {
		this.activarnombreCostoGastoImpor= activarnombreCostoGastoImpor;
	}

	public Border setResaltares_activoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltares_activoCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoCostoGastoImpor() {
		return this.resaltares_activoCostoGastoImpor;
	}

	public void setResaltares_activoCostoGastoImpor(Border borderResaltar) {
		this.resaltares_activoCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrares_activoCostoGastoImpor() {
		return this.mostrares_activoCostoGastoImpor;
	}

	public void setMostrares_activoCostoGastoImpor(Boolean mostrares_activoCostoGastoImpor) {
		this.mostrares_activoCostoGastoImpor= mostrares_activoCostoGastoImpor;
	}

	public Boolean getActivares_activoCostoGastoImpor() {
		return this.activares_activoCostoGastoImpor;
	}

	public void setActivares_activoCostoGastoImpor(Boolean activares_activoCostoGastoImpor) {
		this.activares_activoCostoGastoImpor= activares_activoCostoGastoImpor;
	}

	public Border setResaltarcon_agrupaCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_agrupaCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_agrupaCostoGastoImpor() {
		return this.resaltarcon_agrupaCostoGastoImpor;
	}

	public void setResaltarcon_agrupaCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_agrupaCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_agrupaCostoGastoImpor() {
		return this.mostrarcon_agrupaCostoGastoImpor;
	}

	public void setMostrarcon_agrupaCostoGastoImpor(Boolean mostrarcon_agrupaCostoGastoImpor) {
		this.mostrarcon_agrupaCostoGastoImpor= mostrarcon_agrupaCostoGastoImpor;
	}

	public Boolean getActivarcon_agrupaCostoGastoImpor() {
		return this.activarcon_agrupaCostoGastoImpor;
	}

	public void setActivarcon_agrupaCostoGastoImpor(Boolean activarcon_agrupaCostoGastoImpor) {
		this.activarcon_agrupaCostoGastoImpor= activarcon_agrupaCostoGastoImpor;
	}

	public Border setResaltarcon_prorrateaCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_prorrateaCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_prorrateaCostoGastoImpor() {
		return this.resaltarcon_prorrateaCostoGastoImpor;
	}

	public void setResaltarcon_prorrateaCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_prorrateaCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_prorrateaCostoGastoImpor() {
		return this.mostrarcon_prorrateaCostoGastoImpor;
	}

	public void setMostrarcon_prorrateaCostoGastoImpor(Boolean mostrarcon_prorrateaCostoGastoImpor) {
		this.mostrarcon_prorrateaCostoGastoImpor= mostrarcon_prorrateaCostoGastoImpor;
	}

	public Boolean getActivarcon_prorrateaCostoGastoImpor() {
		return this.activarcon_prorrateaCostoGastoImpor;
	}

	public void setActivarcon_prorrateaCostoGastoImpor(Boolean activarcon_prorrateaCostoGastoImpor) {
		this.activarcon_prorrateaCostoGastoImpor= activarcon_prorrateaCostoGastoImpor;
	}

	public Border setResaltarcon_facturaCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_facturaCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_facturaCostoGastoImpor() {
		return this.resaltarcon_facturaCostoGastoImpor;
	}

	public void setResaltarcon_facturaCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_facturaCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_facturaCostoGastoImpor() {
		return this.mostrarcon_facturaCostoGastoImpor;
	}

	public void setMostrarcon_facturaCostoGastoImpor(Boolean mostrarcon_facturaCostoGastoImpor) {
		this.mostrarcon_facturaCostoGastoImpor= mostrarcon_facturaCostoGastoImpor;
	}

	public Boolean getActivarcon_facturaCostoGastoImpor() {
		return this.activarcon_facturaCostoGastoImpor;
	}

	public void setActivarcon_facturaCostoGastoImpor(Boolean activarcon_facturaCostoGastoImpor) {
		this.activarcon_facturaCostoGastoImpor= activarcon_facturaCostoGastoImpor;
	}

	public Border setResaltarcon_fleteCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_fleteCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_fleteCostoGastoImpor() {
		return this.resaltarcon_fleteCostoGastoImpor;
	}

	public void setResaltarcon_fleteCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_fleteCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_fleteCostoGastoImpor() {
		return this.mostrarcon_fleteCostoGastoImpor;
	}

	public void setMostrarcon_fleteCostoGastoImpor(Boolean mostrarcon_fleteCostoGastoImpor) {
		this.mostrarcon_fleteCostoGastoImpor= mostrarcon_fleteCostoGastoImpor;
	}

	public Boolean getActivarcon_fleteCostoGastoImpor() {
		return this.activarcon_fleteCostoGastoImpor;
	}

	public void setActivarcon_fleteCostoGastoImpor(Boolean activarcon_fleteCostoGastoImpor) {
		this.activarcon_fleteCostoGastoImpor= activarcon_fleteCostoGastoImpor;
	}

	public Border setResaltarcon_arancelCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_arancelCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_arancelCostoGastoImpor() {
		return this.resaltarcon_arancelCostoGastoImpor;
	}

	public void setResaltarcon_arancelCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_arancelCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_arancelCostoGastoImpor() {
		return this.mostrarcon_arancelCostoGastoImpor;
	}

	public void setMostrarcon_arancelCostoGastoImpor(Boolean mostrarcon_arancelCostoGastoImpor) {
		this.mostrarcon_arancelCostoGastoImpor= mostrarcon_arancelCostoGastoImpor;
	}

	public Boolean getActivarcon_arancelCostoGastoImpor() {
		return this.activarcon_arancelCostoGastoImpor;
	}

	public void setActivarcon_arancelCostoGastoImpor(Boolean activarcon_arancelCostoGastoImpor) {
		this.activarcon_arancelCostoGastoImpor= activarcon_arancelCostoGastoImpor;
	}

	public Border setResaltarcon_seguroCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_seguroCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_seguroCostoGastoImpor() {
		return this.resaltarcon_seguroCostoGastoImpor;
	}

	public void setResaltarcon_seguroCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_seguroCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_seguroCostoGastoImpor() {
		return this.mostrarcon_seguroCostoGastoImpor;
	}

	public void setMostrarcon_seguroCostoGastoImpor(Boolean mostrarcon_seguroCostoGastoImpor) {
		this.mostrarcon_seguroCostoGastoImpor= mostrarcon_seguroCostoGastoImpor;
	}

	public Boolean getActivarcon_seguroCostoGastoImpor() {
		return this.activarcon_seguroCostoGastoImpor;
	}

	public void setActivarcon_seguroCostoGastoImpor(Boolean activarcon_seguroCostoGastoImpor) {
		this.activarcon_seguroCostoGastoImpor= activarcon_seguroCostoGastoImpor;
	}

	public Border setResaltarcon_total_generalCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_total_generalCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_total_generalCostoGastoImpor() {
		return this.resaltarcon_total_generalCostoGastoImpor;
	}

	public void setResaltarcon_total_generalCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_total_generalCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_total_generalCostoGastoImpor() {
		return this.mostrarcon_total_generalCostoGastoImpor;
	}

	public void setMostrarcon_total_generalCostoGastoImpor(Boolean mostrarcon_total_generalCostoGastoImpor) {
		this.mostrarcon_total_generalCostoGastoImpor= mostrarcon_total_generalCostoGastoImpor;
	}

	public Boolean getActivarcon_total_generalCostoGastoImpor() {
		return this.activarcon_total_generalCostoGastoImpor;
	}

	public void setActivarcon_total_generalCostoGastoImpor(Boolean activarcon_total_generalCostoGastoImpor) {
		this.activarcon_total_generalCostoGastoImpor= activarcon_total_generalCostoGastoImpor;
	}

	public Border setResaltarcon_digitadoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcon_digitadoCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_digitadoCostoGastoImpor() {
		return this.resaltarcon_digitadoCostoGastoImpor;
	}

	public void setResaltarcon_digitadoCostoGastoImpor(Border borderResaltar) {
		this.resaltarcon_digitadoCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcon_digitadoCostoGastoImpor() {
		return this.mostrarcon_digitadoCostoGastoImpor;
	}

	public void setMostrarcon_digitadoCostoGastoImpor(Boolean mostrarcon_digitadoCostoGastoImpor) {
		this.mostrarcon_digitadoCostoGastoImpor= mostrarcon_digitadoCostoGastoImpor;
	}

	public Boolean getActivarcon_digitadoCostoGastoImpor() {
		return this.activarcon_digitadoCostoGastoImpor;
	}

	public void setActivarcon_digitadoCostoGastoImpor(Boolean activarcon_digitadoCostoGastoImpor) {
		this.activarcon_digitadoCostoGastoImpor= activarcon_digitadoCostoGastoImpor;
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
		
		
		this.setMostraridCostoGastoImpor(esInicial);
		this.setMostrarid_empresaCostoGastoImpor(esInicial);
		this.setMostrarid_sucursalCostoGastoImpor(esInicial);
		this.setMostrarid_tipo_costo_gasto_imporCostoGastoImpor(esInicial);
		this.setMostrarnombreCostoGastoImpor(esInicial);
		this.setMostrares_activoCostoGastoImpor(esInicial);
		this.setMostrarcon_agrupaCostoGastoImpor(esInicial);
		this.setMostrarcon_prorrateaCostoGastoImpor(esInicial);
		this.setMostrarcon_facturaCostoGastoImpor(esInicial);
		this.setMostrarcon_fleteCostoGastoImpor(esInicial);
		this.setMostrarcon_arancelCostoGastoImpor(esInicial);
		this.setMostrarcon_seguroCostoGastoImpor(esInicial);
		this.setMostrarcon_total_generalCostoGastoImpor(esInicial);
		this.setMostrarcon_digitadoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ID)) {
				this.setMostraridCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR)) {
				this.setMostrarid_tipo_costo_gasto_imporCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONAGRUPA)) {
				this.setMostrarcon_agrupaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONPRORRATEA)) {
				this.setMostrarcon_prorrateaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFACTURA)) {
				this.setMostrarcon_facturaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFLETE)) {
				this.setMostrarcon_fleteCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONARANCEL)) {
				this.setMostrarcon_arancelCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONSEGURO)) {
				this.setMostrarcon_seguroCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONTOTALGENERAL)) {
				this.setMostrarcon_total_generalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONDIGITADO)) {
				this.setMostrarcon_digitadoCostoGastoImpor(esAsigna);
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
		
		
		this.setActivaridCostoGastoImpor(esInicial);
		this.setActivarid_empresaCostoGastoImpor(esInicial);
		this.setActivarid_sucursalCostoGastoImpor(esInicial);
		this.setActivarid_tipo_costo_gasto_imporCostoGastoImpor(esInicial);
		this.setActivarnombreCostoGastoImpor(esInicial);
		this.setActivares_activoCostoGastoImpor(esInicial);
		this.setActivarcon_agrupaCostoGastoImpor(esInicial);
		this.setActivarcon_prorrateaCostoGastoImpor(esInicial);
		this.setActivarcon_facturaCostoGastoImpor(esInicial);
		this.setActivarcon_fleteCostoGastoImpor(esInicial);
		this.setActivarcon_arancelCostoGastoImpor(esInicial);
		this.setActivarcon_seguroCostoGastoImpor(esInicial);
		this.setActivarcon_total_generalCostoGastoImpor(esInicial);
		this.setActivarcon_digitadoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ID)) {
				this.setActivaridCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR)) {
				this.setActivarid_tipo_costo_gasto_imporCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONAGRUPA)) {
				this.setActivarcon_agrupaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONPRORRATEA)) {
				this.setActivarcon_prorrateaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFACTURA)) {
				this.setActivarcon_facturaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFLETE)) {
				this.setActivarcon_fleteCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONARANCEL)) {
				this.setActivarcon_arancelCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONSEGURO)) {
				this.setActivarcon_seguroCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONTOTALGENERAL)) {
				this.setActivarcon_total_generalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONDIGITADO)) {
				this.setActivarcon_digitadoCostoGastoImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCostoGastoImpor(esInicial);
		this.setResaltarid_empresaCostoGastoImpor(esInicial);
		this.setResaltarid_sucursalCostoGastoImpor(esInicial);
		this.setResaltarid_tipo_costo_gasto_imporCostoGastoImpor(esInicial);
		this.setResaltarnombreCostoGastoImpor(esInicial);
		this.setResaltares_activoCostoGastoImpor(esInicial);
		this.setResaltarcon_agrupaCostoGastoImpor(esInicial);
		this.setResaltarcon_prorrateaCostoGastoImpor(esInicial);
		this.setResaltarcon_facturaCostoGastoImpor(esInicial);
		this.setResaltarcon_fleteCostoGastoImpor(esInicial);
		this.setResaltarcon_arancelCostoGastoImpor(esInicial);
		this.setResaltarcon_seguroCostoGastoImpor(esInicial);
		this.setResaltarcon_total_generalCostoGastoImpor(esInicial);
		this.setResaltarcon_digitadoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ID)) {
				this.setResaltaridCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR)) {
				this.setResaltarid_tipo_costo_gasto_imporCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONAGRUPA)) {
				this.setResaltarcon_agrupaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONPRORRATEA)) {
				this.setResaltarcon_prorrateaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFACTURA)) {
				this.setResaltarcon_facturaCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONFLETE)) {
				this.setResaltarcon_fleteCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONARANCEL)) {
				this.setResaltarcon_arancelCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONSEGURO)) {
				this.setResaltarcon_seguroCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONTOTALGENERAL)) {
				this.setResaltarcon_total_generalCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoGastoImporConstantesFunciones.CONDIGITADO)) {
				this.setResaltarcon_digitadoCostoGastoImpor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleLiquidacionImporCostoGastoImpor=null;

	public Border getResaltarDetalleLiquidacionImporCostoGastoImpor() {
		return this.resaltarDetalleLiquidacionImporCostoGastoImpor;
	}

	public void setResaltarDetalleLiquidacionImporCostoGastoImpor(Border borderResaltarDetalleLiquidacionImpor) {
		if(borderResaltarDetalleLiquidacionImpor!=null) {
			this.resaltarDetalleLiquidacionImporCostoGastoImpor= borderResaltarDetalleLiquidacionImpor;
		}
	}

	public Border setResaltarDetalleLiquidacionImporCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleLiquidacionImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//costogastoimporBeanSwingJInternalFrame.jTtoolBarCostoGastoImpor.setBorder(borderResaltarDetalleLiquidacionImpor);
			
		this.resaltarDetalleLiquidacionImporCostoGastoImpor= borderResaltarDetalleLiquidacionImpor;

		 return borderResaltarDetalleLiquidacionImpor;
	}



	public Boolean mostrarDetalleLiquidacionImporCostoGastoImpor=true;

	public Boolean getMostrarDetalleLiquidacionImporCostoGastoImpor() {
		return this.mostrarDetalleLiquidacionImporCostoGastoImpor;
	}

	public void setMostrarDetalleLiquidacionImporCostoGastoImpor(Boolean visibilidadResaltarDetalleLiquidacionImpor) {
		this.mostrarDetalleLiquidacionImporCostoGastoImpor= visibilidadResaltarDetalleLiquidacionImpor;
	}



	public Boolean activarDetalleLiquidacionImporCostoGastoImpor=true;

	public Boolean gethabilitarResaltarDetalleLiquidacionImporCostoGastoImpor() {
		return this.activarDetalleLiquidacionImporCostoGastoImpor;
	}

	public void setActivarDetalleLiquidacionImporCostoGastoImpor(Boolean habilitarResaltarDetalleLiquidacionImpor) {
		this.activarDetalleLiquidacionImporCostoGastoImpor= habilitarResaltarDetalleLiquidacionImpor;
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

		this.setMostrarDetalleLiquidacionImporCostoGastoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setMostrarDetalleLiquidacionImporCostoGastoImpor(esAsigna);
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

		this.setActivarDetalleLiquidacionImporCostoGastoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setActivarDetalleLiquidacionImporCostoGastoImpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleLiquidacionImporCostoGastoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setResaltarDetalleLiquidacionImporCostoGastoImpor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaCostoGastoImpor=true;

	public Boolean getMostrarFK_IdEmpresaCostoGastoImpor() {
		return this.mostrarFK_IdEmpresaCostoGastoImpor;
	}

	public void setMostrarFK_IdEmpresaCostoGastoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCostoGastoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCostoGastoImpor=true;

	public Boolean getMostrarFK_IdSucursalCostoGastoImpor() {
		return this.mostrarFK_IdSucursalCostoGastoImpor;
	}

	public void setMostrarFK_IdSucursalCostoGastoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCostoGastoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCostoGastoImporCostoGastoImpor=true;

	public Boolean getMostrarFK_IdTipoCostoGastoImporCostoGastoImpor() {
		return this.mostrarFK_IdTipoCostoGastoImporCostoGastoImpor;
	}

	public void setMostrarFK_IdTipoCostoGastoImporCostoGastoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCostoGastoImporCostoGastoImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaCostoGastoImpor=true;

	public Boolean getActivarFK_IdEmpresaCostoGastoImpor() {
		return this.activarFK_IdEmpresaCostoGastoImpor;
	}

	public void setActivarFK_IdEmpresaCostoGastoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCostoGastoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCostoGastoImpor=true;

	public Boolean getActivarFK_IdSucursalCostoGastoImpor() {
		return this.activarFK_IdSucursalCostoGastoImpor;
	}

	public void setActivarFK_IdSucursalCostoGastoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCostoGastoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCostoGastoImporCostoGastoImpor=true;

	public Boolean getActivarFK_IdTipoCostoGastoImporCostoGastoImpor() {
		return this.activarFK_IdTipoCostoGastoImporCostoGastoImpor;
	}

	public void setActivarFK_IdTipoCostoGastoImporCostoGastoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCostoGastoImporCostoGastoImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaCostoGastoImpor=null;

	public Border getResaltarFK_IdEmpresaCostoGastoImpor() {
		return this.resaltarFK_IdEmpresaCostoGastoImpor;
	}

	public void setResaltarFK_IdEmpresaCostoGastoImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCostoGastoImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCostoGastoImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCostoGastoImpor=null;

	public Border getResaltarFK_IdSucursalCostoGastoImpor() {
		return this.resaltarFK_IdSucursalCostoGastoImpor;
	}

	public void setResaltarFK_IdSucursalCostoGastoImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalCostoGastoImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCostoGastoImpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoCostoGastoImporCostoGastoImpor=null;

	public Border getResaltarFK_IdTipoCostoGastoImporCostoGastoImpor() {
		return this.resaltarFK_IdTipoCostoGastoImporCostoGastoImpor;
	}

	public void setResaltarFK_IdTipoCostoGastoImporCostoGastoImpor(Border borderResaltar) {
		this.resaltarFK_IdTipoCostoGastoImporCostoGastoImpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoCostoGastoImporCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*CostoGastoImporBeanSwingJInternalFrame costogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCostoGastoImporCostoGastoImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}