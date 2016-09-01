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


import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LiquidacionImpuestoImporConstantesFunciones extends LiquidacionImpuestoImporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="LiquidacionImpuestoImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LiquidacionImpuestoImpor"+LiquidacionImpuestoImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LiquidacionImpuestoImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LiquidacionImpuestoImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LiquidacionImpuestoImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LiquidacionImpuestoImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LiquidacionImpuestoImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LiquidacionImpuestoImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Liquidacion Impuesto Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Liquidacion Impuesto Impor";
	public static final String SCLASSWEBTITULO_LOWER="Liquidacion Impuesto Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LiquidacionImpuestoImpor";
	public static final String OBJECTNAME="liquidacionimpuestoimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="liquidacion_impuesto_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select liquidacionimpuestoimpor from "+LiquidacionImpuestoImporConstantesFunciones.SPERSISTENCENAME+" liquidacionimpuestoimpor";
	public static String QUERYSELECTNATIVE="select "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_pedido_compra_impor,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_empresa,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_sucursal,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_cliente,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_factura,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_comprobante,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_dui,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fecha,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fecha_pago,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fob,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".seguro,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".flete,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_fodi,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_iva,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".tasa_control,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cfr,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cif,"+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME+".total from "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LiquidacionImpuestoImporConstantesFuncionesAdditional liquidacionimpuestoimporConstantesFuncionesAdditional=null;
	
	public LiquidacionImpuestoImporConstantesFuncionesAdditional getLiquidacionImpuestoImporConstantesFuncionesAdditional() {
		return this.liquidacionimpuestoimporConstantesFuncionesAdditional;
	}
	
	public void setLiquidacionImpuestoImporConstantesFuncionesAdditional(LiquidacionImpuestoImporConstantesFuncionesAdditional liquidacionimpuestoimporConstantesFuncionesAdditional) {
		try {
			this.liquidacionimpuestoimporConstantesFuncionesAdditional=liquidacionimpuestoimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPEDIDOCOMPRAIMPOR= "id_pedido_compra_impor";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMERODUI= "numero_dui";
    public static final String FECHA= "fecha";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String FOB= "fob";
    public static final String SEGURO= "seguro";
    public static final String FLETE= "flete";
    public static final String PORCENTAJEFODI= "porcentaje_fodi";
    public static final String PORCENTAJEIVA= "porcentaje_iva";
    public static final String TASACONTROL= "tasa_control";
    public static final String CFR= "cfr";
    public static final String CIF= "cif";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPEDIDOCOMPRAIMPOR= "Pedo Compra Impor";
		public static final String LABEL_IDPEDIDOCOMPRAIMPOR_LOWER= "Pedido Compra Impor";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMERODUI= "Numero Dui";
		public static final String LABEL_NUMERODUI_LOWER= "Numero Dui";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_FOB= "Fob";
		public static final String LABEL_FOB_LOWER= "Fob";
    	public static final String LABEL_SEGURO= "Seguro";
		public static final String LABEL_SEGURO_LOWER= "Seguro";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_PORCENTAJEFODI= "Porcentaje Fodi";
		public static final String LABEL_PORCENTAJEFODI_LOWER= "Porcentaje Fodi";
    	public static final String LABEL_PORCENTAJEIVA= "Porcentaje Iva";
		public static final String LABEL_PORCENTAJEIVA_LOWER= "Porcentaje Iva";
    	public static final String LABEL_TASACONTROL= "Tasa Control";
		public static final String LABEL_TASACONTROL_LOWER= "Tasa Control";
    	public static final String LABEL_CFR= "Cfr";
		public static final String LABEL_CFR_LOWER= "Cfr";
    	public static final String LABEL_CIF= "Cif";
		public static final String LABEL_CIF_LOWER= "Cif";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DUI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DUI=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getLiquidacionImpuestoImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.IDFACTURA)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.NUMERODUI)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMERODUI;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.FECHA)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.FOB)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.SEGURO)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.FLETE)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.CFR)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.CIF)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF;}
		if(sNombreColumna.equals(LiquidacionImpuestoImporConstantesFunciones.TOTAL)) {sLabelColumna=LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getLiquidacionImpuestoImporDescripcion(LiquidacionImpuestoImpor liquidacionimpuestoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(liquidacionimpuestoimpor !=null/* && liquidacionimpuestoimpor.getId()!=0*/) {
			if(liquidacionimpuestoimpor.getId()!=null) {
				sDescripcion=liquidacionimpuestoimpor.getId().toString();
			}//liquidacionimpuestoimporliquidacionimpuestoimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getLiquidacionImpuestoImporDescripcionDetallado(LiquidacionImpuestoImpor liquidacionimpuestoimpor) {
		String sDescripcion="";
			
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.ID+"=";
		sDescripcion+=liquidacionimpuestoimpor.getId().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=liquidacionimpuestoimpor.getVersionRow().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR+"=";
		sDescripcion+=liquidacionimpuestoimpor.getid_pedido_compra_impor().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=liquidacionimpuestoimpor.getid_empresa().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=liquidacionimpuestoimpor.getid_sucursal().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=liquidacionimpuestoimpor.getid_cliente().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=liquidacionimpuestoimpor.getid_factura().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=liquidacionimpuestoimpor.getnumero_comprobante()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.NUMERODUI+"=";
		sDescripcion+=liquidacionimpuestoimpor.getnumero_dui()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.FECHA+"=";
		sDescripcion+=liquidacionimpuestoimpor.getfecha().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=liquidacionimpuestoimpor.getfecha_pago().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.FOB+"=";
		sDescripcion+=liquidacionimpuestoimpor.getfob().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.SEGURO+"=";
		sDescripcion+=liquidacionimpuestoimpor.getseguro().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.FLETE+"=";
		sDescripcion+=liquidacionimpuestoimpor.getflete().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI+"=";
		sDescripcion+=liquidacionimpuestoimpor.getporcentaje_fodi().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA+"=";
		sDescripcion+=liquidacionimpuestoimpor.getporcentaje_iva().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.TASACONTROL+"=";
		sDescripcion+=liquidacionimpuestoimpor.gettasa_control().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.CFR+"=";
		sDescripcion+=liquidacionimpuestoimpor.getcfr().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.CIF+"=";
		sDescripcion+=liquidacionimpuestoimpor.getcif().toString()+",";
		sDescripcion+=LiquidacionImpuestoImporConstantesFunciones.TOTAL+"=";
		sDescripcion+=liquidacionimpuestoimpor.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setLiquidacionImpuestoImporDescripcion(LiquidacionImpuestoImpor liquidacionimpuestoimpor,String sValor) throws Exception {			
		if(liquidacionimpuestoimpor !=null) {
			//liquidacionimpuestoimporliquidacionimpuestoimpor.getId().toString();
		}		
	}
	
		

	public static String getPedidoCompraImporDescripcion(PedidoCompraImpor pedidocompraimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidocompraimpor!=null/*&&pedidocompraimpor.getId()>0*/) {
			sDescripcion=PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(pedidocompraimpor);
		}

		return sDescripcion;
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdPedidoCompraImpor")) {
			sNombreIndice="Tipo=  Por Pedo Compra Impor";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoCompraImpor(Long id_pedido_compra_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_compra_impor!=null) {sDetalleIndice+=" Codigo Unico De Pedo Compra Impor="+id_pedido_compra_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		liquidacionimpuestoimpor.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante().trim());
		liquidacionimpuestoimpor.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui().trim());
	}
	
	public static void quitarEspaciosLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {
			liquidacionimpuestoimpor.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante().trim());
			liquidacionimpuestoimpor.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && liquidacionimpuestoimpor.getConCambioAuxiliar()) {
			liquidacionimpuestoimpor.setIsDeleted(liquidacionimpuestoimpor.getIsDeletedAuxiliar());	
			liquidacionimpuestoimpor.setIsNew(liquidacionimpuestoimpor.getIsNewAuxiliar());	
			liquidacionimpuestoimpor.setIsChanged(liquidacionimpuestoimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			liquidacionimpuestoimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			liquidacionimpuestoimpor.setIsDeletedAuxiliar(false);	
			liquidacionimpuestoimpor.setIsNewAuxiliar(false);	
			liquidacionimpuestoimpor.setIsChangedAuxiliar(false);
			
			liquidacionimpuestoimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor : liquidacionimpuestoimpors) {
			if(conAsignarBase && liquidacionimpuestoimpor.getConCambioAuxiliar()) {
				liquidacionimpuestoimpor.setIsDeleted(liquidacionimpuestoimpor.getIsDeletedAuxiliar());	
				liquidacionimpuestoimpor.setIsNew(liquidacionimpuestoimpor.getIsNewAuxiliar());	
				liquidacionimpuestoimpor.setIsChanged(liquidacionimpuestoimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				liquidacionimpuestoimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				liquidacionimpuestoimpor.setIsDeletedAuxiliar(false);	
				liquidacionimpuestoimpor.setIsNewAuxiliar(false);	
				liquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
				liquidacionimpuestoimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean conEnteros) throws Exception  {
		liquidacionimpuestoimpor.setfob(0.0);
		liquidacionimpuestoimpor.setseguro(0.0);
		liquidacionimpuestoimpor.setflete(0.0);
		liquidacionimpuestoimpor.setporcentaje_fodi(0.0);
		liquidacionimpuestoimpor.setporcentaje_iva(0.0);
		liquidacionimpuestoimpor.settasa_control(0.0);
		liquidacionimpuestoimpor.setcfr(0.0);
		liquidacionimpuestoimpor.setcif(0.0);
		liquidacionimpuestoimpor.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,Boolean conEnteros) throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {
			liquidacionimpuestoimpor.setfob(0.0);
			liquidacionimpuestoimpor.setseguro(0.0);
			liquidacionimpuestoimpor.setflete(0.0);
			liquidacionimpuestoimpor.setporcentaje_fodi(0.0);
			liquidacionimpuestoimpor.setporcentaje_iva(0.0);
			liquidacionimpuestoimpor.settasa_control(0.0);
			liquidacionimpuestoimpor.setcfr(0.0);
			liquidacionimpuestoimpor.setcif(0.0);
			liquidacionimpuestoimpor.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImpor liquidacionimpuestoimporAux) throws Exception  {
		LiquidacionImpuestoImporConstantesFunciones.InicializarValoresLiquidacionImpuestoImpor(liquidacionimpuestoimporAux,true);
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {
			if(liquidacionimpuestoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			liquidacionimpuestoimporAux.setfob(liquidacionimpuestoimporAux.getfob()+liquidacionimpuestoimpor.getfob());			
			liquidacionimpuestoimporAux.setseguro(liquidacionimpuestoimporAux.getseguro()+liquidacionimpuestoimpor.getseguro());			
			liquidacionimpuestoimporAux.setflete(liquidacionimpuestoimporAux.getflete()+liquidacionimpuestoimpor.getflete());			
			liquidacionimpuestoimporAux.setporcentaje_fodi(liquidacionimpuestoimporAux.getporcentaje_fodi()+liquidacionimpuestoimpor.getporcentaje_fodi());			
			liquidacionimpuestoimporAux.setporcentaje_iva(liquidacionimpuestoimporAux.getporcentaje_iva()+liquidacionimpuestoimpor.getporcentaje_iva());			
			liquidacionimpuestoimporAux.settasa_control(liquidacionimpuestoimporAux.gettasa_control()+liquidacionimpuestoimpor.gettasa_control());			
			liquidacionimpuestoimporAux.setcfr(liquidacionimpuestoimporAux.getcfr()+liquidacionimpuestoimpor.getcfr());			
			liquidacionimpuestoimporAux.setcif(liquidacionimpuestoimporAux.getcif()+liquidacionimpuestoimpor.getcif());			
			liquidacionimpuestoimporAux.settotal(liquidacionimpuestoimporAux.gettotal()+liquidacionimpuestoimpor.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LiquidacionImpuestoImporConstantesFunciones.getArrayColumnasGlobalesLiquidacionImpuestoImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux: liquidacionimpuestoimpors) {
			if(liquidacionimpuestoimporAux!=null && liquidacionimpuestoimpor!=null) {
				if((liquidacionimpuestoimporAux.getId()==null && liquidacionimpuestoimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(liquidacionimpuestoimporAux.getId()!=null && liquidacionimpuestoimpor.getId()!=null){
					if(liquidacionimpuestoimporAux.getId().equals(liquidacionimpuestoimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fobTotal=0.0;
		Double seguroTotal=0.0;
		Double fleteTotal=0.0;
		Double porcentaje_fodiTotal=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double tasa_controlTotal=0.0;
		Double cfrTotal=0.0;
		Double cifTotal=0.0;
		Double totalTotal=0.0;
	
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {			
			if(liquidacionimpuestoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			fobTotal+=liquidacionimpuestoimpor.getfob();
			seguroTotal+=liquidacionimpuestoimpor.getseguro();
			fleteTotal+=liquidacionimpuestoimpor.getflete();
			porcentaje_fodiTotal+=liquidacionimpuestoimpor.getporcentaje_fodi();
			porcentaje_ivaTotal+=liquidacionimpuestoimpor.getporcentaje_iva();
			tasa_controlTotal+=liquidacionimpuestoimpor.gettasa_control();
			cfrTotal+=liquidacionimpuestoimpor.getcfr();
			cifTotal+=liquidacionimpuestoimpor.getcif();
			totalTotal+=liquidacionimpuestoimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		datoGeneral.setdValorDouble(porcentaje_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL);
		datoGeneral.setdValorDouble(tasa_controlTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.CFR);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR);
		datoGeneral.setdValorDouble(cfrTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.CIF);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF);
		datoGeneral.setdValorDouble(cifTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLiquidacionImpuestoImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_ID, LiquidacionImpuestoImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_VERSIONROW, LiquidacionImpuestoImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR, LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA, LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL, LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_IDCLIENTE, LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_IDFACTURA, LiquidacionImpuestoImporConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE, LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMERODUI, LiquidacionImpuestoImporConstantesFunciones.NUMERODUI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHA, LiquidacionImpuestoImporConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHAPAGO, LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB, LiquidacionImpuestoImporConstantesFunciones.FOB,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO, LiquidacionImpuestoImporConstantesFunciones.SEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE, LiquidacionImpuestoImporConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI, LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA, LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL, LiquidacionImpuestoImporConstantesFunciones.TASACONTROL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR, LiquidacionImpuestoImporConstantesFunciones.CFR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF, LiquidacionImpuestoImporConstantesFunciones.CIF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL, LiquidacionImpuestoImporConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLiquidacionImpuestoImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.NUMERODUI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.FOB;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.SEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.TASACONTROL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.CFR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.CIF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImpuestoImporConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpuestoImpor() throws Exception  {
		return LiquidacionImpuestoImporConstantesFunciones.getTiposSeleccionarLiquidacionImpuestoImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpuestoImpor(Boolean conFk) throws Exception  {
		return LiquidacionImpuestoImporConstantesFunciones.getTiposSeleccionarLiquidacionImpuestoImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpuestoImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMERODUI);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMERODUI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLiquidacionImpuestoImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimporAux) throws Exception {
		
			liquidacionimpuestoimporAux.setpedidocompraimpor_descripcion(PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(liquidacionimpuestoimporAux.getPedidoCompraImpor()));
			liquidacionimpuestoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(liquidacionimpuestoimporAux.getEmpresa()));
			liquidacionimpuestoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(liquidacionimpuestoimporAux.getSucursal()));
			liquidacionimpuestoimporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(liquidacionimpuestoimporAux.getCliente()));
			liquidacionimpuestoimporAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(liquidacionimpuestoimporAux.getFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsTemp) throws Exception {
		for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux:liquidacionimpuestoimporsTemp) {
			
			liquidacionimpuestoimporAux.setpedidocompraimpor_descripcion(PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(liquidacionimpuestoimporAux.getPedidoCompraImpor()));
			liquidacionimpuestoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(liquidacionimpuestoimporAux.getEmpresa()));
			liquidacionimpuestoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(liquidacionimpuestoimporAux.getSucursal()));
			liquidacionimpuestoimporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(liquidacionimpuestoimporAux.getCliente()));
			liquidacionimpuestoimporAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(liquidacionimpuestoimporAux.getFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoCompraImpor.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompraImpor.class)) {
						classes.add(new Classe(PedidoCompraImpor.class));
					}
				}

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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsOfLiquidacionImpuestoImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleLiquidacionImpuestoImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)) {
						classes.add(new Classe(DetalleLiquidacionImpuestoImpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsFromStringsOfLiquidacionImpuestoImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpuestoImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpuestoImpor.class)); continue;
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
	public static void actualizarLista(LiquidacionImpuestoImpor liquidacionimpuestoimpor,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LiquidacionImpuestoImpor liquidacionimpuestoimporEncontrado=null;
			
			for(LiquidacionImpuestoImpor liquidacionimpuestoimporLocal:liquidacionimpuestoimpors) {
				if(liquidacionimpuestoimporLocal.getId().equals(liquidacionimpuestoimpor.getId())) {
					liquidacionimpuestoimporEncontrado=liquidacionimpuestoimporLocal;
					
					liquidacionimpuestoimporLocal.setIsChanged(liquidacionimpuestoimpor.getIsChanged());
					liquidacionimpuestoimporLocal.setIsNew(liquidacionimpuestoimpor.getIsNew());
					liquidacionimpuestoimporLocal.setIsDeleted(liquidacionimpuestoimpor.getIsDeleted());
					
					liquidacionimpuestoimporLocal.setGeneralEntityOriginal(liquidacionimpuestoimpor.getGeneralEntityOriginal());
					
					liquidacionimpuestoimporLocal.setId(liquidacionimpuestoimpor.getId());	
					liquidacionimpuestoimporLocal.setVersionRow(liquidacionimpuestoimpor.getVersionRow());	
					liquidacionimpuestoimporLocal.setid_pedido_compra_impor(liquidacionimpuestoimpor.getid_pedido_compra_impor());	
					liquidacionimpuestoimporLocal.setid_empresa(liquidacionimpuestoimpor.getid_empresa());	
					liquidacionimpuestoimporLocal.setid_sucursal(liquidacionimpuestoimpor.getid_sucursal());	
					liquidacionimpuestoimporLocal.setid_cliente(liquidacionimpuestoimpor.getid_cliente());	
					liquidacionimpuestoimporLocal.setid_factura(liquidacionimpuestoimpor.getid_factura());	
					liquidacionimpuestoimporLocal.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante());	
					liquidacionimpuestoimporLocal.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui());	
					liquidacionimpuestoimporLocal.setfecha(liquidacionimpuestoimpor.getfecha());	
					liquidacionimpuestoimporLocal.setfecha_pago(liquidacionimpuestoimpor.getfecha_pago());	
					liquidacionimpuestoimporLocal.setfob(liquidacionimpuestoimpor.getfob());	
					liquidacionimpuestoimporLocal.setseguro(liquidacionimpuestoimpor.getseguro());	
					liquidacionimpuestoimporLocal.setflete(liquidacionimpuestoimpor.getflete());	
					liquidacionimpuestoimporLocal.setporcentaje_fodi(liquidacionimpuestoimpor.getporcentaje_fodi());	
					liquidacionimpuestoimporLocal.setporcentaje_iva(liquidacionimpuestoimpor.getporcentaje_iva());	
					liquidacionimpuestoimporLocal.settasa_control(liquidacionimpuestoimpor.gettasa_control());	
					liquidacionimpuestoimporLocal.setcfr(liquidacionimpuestoimpor.getcfr());	
					liquidacionimpuestoimporLocal.setcif(liquidacionimpuestoimpor.getcif());	
					liquidacionimpuestoimporLocal.settotal(liquidacionimpuestoimpor.gettotal());	
					
					
					liquidacionimpuestoimporLocal.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors());
					
					existe=true;
					break;
				}
			}
			
			if(!liquidacionimpuestoimpor.getIsDeleted()) {
				if(!existe) {
					liquidacionimpuestoimpors.add(liquidacionimpuestoimpor);
				}
			} else {
				if(liquidacionimpuestoimporEncontrado!=null && permiteQuitar)  {
					liquidacionimpuestoimpors.remove(liquidacionimpuestoimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LiquidacionImpuestoImpor liquidacionimpuestoimpor,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors) throws Exception {
		try	{			
			for(LiquidacionImpuestoImpor liquidacionimpuestoimporLocal:liquidacionimpuestoimpors) {
				if(liquidacionimpuestoimporLocal.getId().equals(liquidacionimpuestoimpor.getId())) {
					liquidacionimpuestoimporLocal.setIsSelected(liquidacionimpuestoimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsAux) throws Exception {
		//this.liquidacionimpuestoimporsAux=liquidacionimpuestoimporsAux;
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux:liquidacionimpuestoimporsAux) {
			if(liquidacionimpuestoimporAux.getIsChanged()) {
				liquidacionimpuestoimporAux.setIsChanged(false);
			}		
			
			if(liquidacionimpuestoimporAux.getIsNew()) {
				liquidacionimpuestoimporAux.setIsNew(false);
			}	
			
			if(liquidacionimpuestoimporAux.getIsDeleted()) {
				liquidacionimpuestoimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimporAux) throws Exception {
		//this.liquidacionimpuestoimporAux=liquidacionimpuestoimporAux;
		
			if(liquidacionimpuestoimporAux.getIsChanged()) {
				liquidacionimpuestoimporAux.setIsChanged(false);
			}		
			
			if(liquidacionimpuestoimporAux.getIsNew()) {
				liquidacionimpuestoimporAux.setIsNew(false);
			}	
			
			if(liquidacionimpuestoimporAux.getIsDeleted()) {
				liquidacionimpuestoimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LiquidacionImpuestoImpor liquidacionimpuestoimporAsignar,LiquidacionImpuestoImpor liquidacionimpuestoimpor) throws Exception {
		liquidacionimpuestoimporAsignar.setId(liquidacionimpuestoimpor.getId());	
		liquidacionimpuestoimporAsignar.setVersionRow(liquidacionimpuestoimpor.getVersionRow());	
		liquidacionimpuestoimporAsignar.setid_pedido_compra_impor(liquidacionimpuestoimpor.getid_pedido_compra_impor());
		liquidacionimpuestoimporAsignar.setpedidocompraimpor_descripcion(liquidacionimpuestoimpor.getpedidocompraimpor_descripcion());	
		liquidacionimpuestoimporAsignar.setid_empresa(liquidacionimpuestoimpor.getid_empresa());
		liquidacionimpuestoimporAsignar.setempresa_descripcion(liquidacionimpuestoimpor.getempresa_descripcion());	
		liquidacionimpuestoimporAsignar.setid_sucursal(liquidacionimpuestoimpor.getid_sucursal());
		liquidacionimpuestoimporAsignar.setsucursal_descripcion(liquidacionimpuestoimpor.getsucursal_descripcion());	
		liquidacionimpuestoimporAsignar.setid_cliente(liquidacionimpuestoimpor.getid_cliente());
		liquidacionimpuestoimporAsignar.setcliente_descripcion(liquidacionimpuestoimpor.getcliente_descripcion());	
		liquidacionimpuestoimporAsignar.setid_factura(liquidacionimpuestoimpor.getid_factura());
		liquidacionimpuestoimporAsignar.setfactura_descripcion(liquidacionimpuestoimpor.getfactura_descripcion());	
		liquidacionimpuestoimporAsignar.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante());	
		liquidacionimpuestoimporAsignar.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui());	
		liquidacionimpuestoimporAsignar.setfecha(liquidacionimpuestoimpor.getfecha());	
		liquidacionimpuestoimporAsignar.setfecha_pago(liquidacionimpuestoimpor.getfecha_pago());	
		liquidacionimpuestoimporAsignar.setfob(liquidacionimpuestoimpor.getfob());	
		liquidacionimpuestoimporAsignar.setseguro(liquidacionimpuestoimpor.getseguro());	
		liquidacionimpuestoimporAsignar.setflete(liquidacionimpuestoimpor.getflete());	
		liquidacionimpuestoimporAsignar.setporcentaje_fodi(liquidacionimpuestoimpor.getporcentaje_fodi());	
		liquidacionimpuestoimporAsignar.setporcentaje_iva(liquidacionimpuestoimpor.getporcentaje_iva());	
		liquidacionimpuestoimporAsignar.settasa_control(liquidacionimpuestoimpor.gettasa_control());	
		liquidacionimpuestoimporAsignar.setcfr(liquidacionimpuestoimpor.getcfr());	
		liquidacionimpuestoimporAsignar.setcif(liquidacionimpuestoimpor.getcif());	
		liquidacionimpuestoimporAsignar.settotal(liquidacionimpuestoimpor.gettotal());	
	}
	
	public static void inicializarLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor) throws Exception {
		try {
				liquidacionimpuestoimpor.setId(0L);	
					
				liquidacionimpuestoimpor.setid_pedido_compra_impor(-1L);	
				liquidacionimpuestoimpor.setid_empresa(-1L);	
				liquidacionimpuestoimpor.setid_sucursal(-1L);	
				liquidacionimpuestoimpor.setid_cliente(-1L);	
				liquidacionimpuestoimpor.setid_factura(-1L);	
				liquidacionimpuestoimpor.setnumero_comprobante("");	
				liquidacionimpuestoimpor.setnumero_dui("");	
				liquidacionimpuestoimpor.setfecha(new Date());	
				liquidacionimpuestoimpor.setfecha_pago(new Date());	
				liquidacionimpuestoimpor.setfob(0.0);	
				liquidacionimpuestoimpor.setseguro(0.0);	
				liquidacionimpuestoimpor.setflete(0.0);	
				liquidacionimpuestoimpor.setporcentaje_fodi(0.0);	
				liquidacionimpuestoimpor.setporcentaje_iva(0.0);	
				liquidacionimpuestoimpor.settasa_control(0.0);	
				liquidacionimpuestoimpor.setcfr(0.0);	
				liquidacionimpuestoimpor.setcif(0.0);	
				liquidacionimpuestoimpor.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLiquidacionImpuestoImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_NUMERODUI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLiquidacionImpuestoImpor(String sTipo,Row row,Workbook workbook,LiquidacionImpuestoImpor liquidacionimpuestoimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getpedidocompraimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getnumero_dui());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getfob());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getseguro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getporcentaje_fodi());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getporcentaje_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.gettasa_control());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getcfr());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.getcif());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpuestoimpor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLiquidacionImpuestoImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLiquidacionImpuestoImpor() {
		return this.sFinalQueryLiquidacionImpuestoImpor;
	}
	
	public void setsFinalQueryLiquidacionImpuestoImpor(String sFinalQueryLiquidacionImpuestoImpor) {
		this.sFinalQueryLiquidacionImpuestoImpor= sFinalQueryLiquidacionImpuestoImpor;
	}
	
	public Border resaltarSeleccionarLiquidacionImpuestoImpor=null;
	
	public Border setResaltarSeleccionarLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLiquidacionImpuestoImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLiquidacionImpuestoImpor() {
		return this.resaltarSeleccionarLiquidacionImpuestoImpor;
	}
	
	public void setResaltarSeleccionarLiquidacionImpuestoImpor(Border borderResaltarSeleccionarLiquidacionImpuestoImpor) {
		this.resaltarSeleccionarLiquidacionImpuestoImpor= borderResaltarSeleccionarLiquidacionImpuestoImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLiquidacionImpuestoImpor=null;
	public Boolean mostraridLiquidacionImpuestoImpor=true;
	public Boolean activaridLiquidacionImpuestoImpor=true;

	public Border resaltarid_pedido_compra_imporLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_pedido_compra_imporLiquidacionImpuestoImpor=true;
	public Boolean activarid_pedido_compra_imporLiquidacionImpuestoImpor=true;
	public Boolean cargarid_pedido_compra_imporLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_compra_imporLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_empresaLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_empresaLiquidacionImpuestoImpor=true;
	public Boolean activarid_empresaLiquidacionImpuestoImpor=true;
	public Boolean cargarid_empresaLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_sucursalLiquidacionImpuestoImpor=true;
	public Boolean activarid_sucursalLiquidacionImpuestoImpor=true;
	public Boolean cargarid_sucursalLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_clienteLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_clienteLiquidacionImpuestoImpor=true;
	public Boolean activarid_clienteLiquidacionImpuestoImpor=true;
	public Boolean cargarid_clienteLiquidacionImpuestoImpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_facturaLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_facturaLiquidacionImpuestoImpor=true;
	public Boolean activarid_facturaLiquidacionImpuestoImpor=true;
	public Boolean cargarid_facturaLiquidacionImpuestoImpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteLiquidacionImpuestoImpor=null;
	public Boolean mostrarnumero_comprobanteLiquidacionImpuestoImpor=true;
	public Boolean activarnumero_comprobanteLiquidacionImpuestoImpor=true;

	public Border resaltarnumero_duiLiquidacionImpuestoImpor=null;
	public Boolean mostrarnumero_duiLiquidacionImpuestoImpor=true;
	public Boolean activarnumero_duiLiquidacionImpuestoImpor=true;

	public Border resaltarfechaLiquidacionImpuestoImpor=null;
	public Boolean mostrarfechaLiquidacionImpuestoImpor=true;
	public Boolean activarfechaLiquidacionImpuestoImpor=false;

	public Border resaltarfecha_pagoLiquidacionImpuestoImpor=null;
	public Boolean mostrarfecha_pagoLiquidacionImpuestoImpor=true;
	public Boolean activarfecha_pagoLiquidacionImpuestoImpor=false;

	public Border resaltarfobLiquidacionImpuestoImpor=null;
	public Boolean mostrarfobLiquidacionImpuestoImpor=true;
	public Boolean activarfobLiquidacionImpuestoImpor=true;

	public Border resaltarseguroLiquidacionImpuestoImpor=null;
	public Boolean mostrarseguroLiquidacionImpuestoImpor=true;
	public Boolean activarseguroLiquidacionImpuestoImpor=true;

	public Border resaltarfleteLiquidacionImpuestoImpor=null;
	public Boolean mostrarfleteLiquidacionImpuestoImpor=true;
	public Boolean activarfleteLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_fodiLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_fodiLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_fodiLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_ivaLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_ivaLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_ivaLiquidacionImpuestoImpor=true;

	public Border resaltartasa_controlLiquidacionImpuestoImpor=null;
	public Boolean mostrartasa_controlLiquidacionImpuestoImpor=true;
	public Boolean activartasa_controlLiquidacionImpuestoImpor=true;

	public Border resaltarcfrLiquidacionImpuestoImpor=null;
	public Boolean mostrarcfrLiquidacionImpuestoImpor=true;
	public Boolean activarcfrLiquidacionImpuestoImpor=true;

	public Border resaltarcifLiquidacionImpuestoImpor=null;
	public Boolean mostrarcifLiquidacionImpuestoImpor=true;
	public Boolean activarcifLiquidacionImpuestoImpor=true;

	public Border resaltartotalLiquidacionImpuestoImpor=null;
	public Boolean mostrartotalLiquidacionImpuestoImpor=true;
	public Boolean activartotalLiquidacionImpuestoImpor=true;

	
	

	public Border setResaltaridLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltaridLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLiquidacionImpuestoImpor() {
		return this.resaltaridLiquidacionImpuestoImpor;
	}

	public void setResaltaridLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltaridLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostraridLiquidacionImpuestoImpor() {
		return this.mostraridLiquidacionImpuestoImpor;
	}

	public void setMostraridLiquidacionImpuestoImpor(Boolean mostraridLiquidacionImpuestoImpor) {
		this.mostraridLiquidacionImpuestoImpor= mostraridLiquidacionImpuestoImpor;
	}

	public Boolean getActivaridLiquidacionImpuestoImpor() {
		return this.activaridLiquidacionImpuestoImpor;
	}

	public void setActivaridLiquidacionImpuestoImpor(Boolean activaridLiquidacionImpuestoImpor) {
		this.activaridLiquidacionImpuestoImpor= activaridLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_pedido_compra_imporLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_pedido_compra_imporLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_compra_imporLiquidacionImpuestoImpor() {
		return this.resaltarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public void setResaltarid_pedido_compra_imporLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_pedido_compra_imporLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_pedido_compra_imporLiquidacionImpuestoImpor() {
		return this.mostrarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public void setMostrarid_pedido_compra_imporLiquidacionImpuestoImpor(Boolean mostrarid_pedido_compra_imporLiquidacionImpuestoImpor) {
		this.mostrarid_pedido_compra_imporLiquidacionImpuestoImpor= mostrarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_pedido_compra_imporLiquidacionImpuestoImpor() {
		return this.activarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public void setActivarid_pedido_compra_imporLiquidacionImpuestoImpor(Boolean activarid_pedido_compra_imporLiquidacionImpuestoImpor) {
		this.activarid_pedido_compra_imporLiquidacionImpuestoImpor= activarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_pedido_compra_imporLiquidacionImpuestoImpor() {
		return this.cargarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public void setCargarid_pedido_compra_imporLiquidacionImpuestoImpor(Boolean cargarid_pedido_compra_imporLiquidacionImpuestoImpor) {
		this.cargarid_pedido_compra_imporLiquidacionImpuestoImpor= cargarid_pedido_compra_imporLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_empresaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLiquidacionImpuestoImpor() {
		return this.resaltarid_empresaLiquidacionImpuestoImpor;
	}

	public void setResaltarid_empresaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_empresaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaLiquidacionImpuestoImpor() {
		return this.mostrarid_empresaLiquidacionImpuestoImpor;
	}

	public void setMostrarid_empresaLiquidacionImpuestoImpor(Boolean mostrarid_empresaLiquidacionImpuestoImpor) {
		this.mostrarid_empresaLiquidacionImpuestoImpor= mostrarid_empresaLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_empresaLiquidacionImpuestoImpor() {
		return this.activarid_empresaLiquidacionImpuestoImpor;
	}

	public void setActivarid_empresaLiquidacionImpuestoImpor(Boolean activarid_empresaLiquidacionImpuestoImpor) {
		this.activarid_empresaLiquidacionImpuestoImpor= activarid_empresaLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_empresaLiquidacionImpuestoImpor() {
		return this.cargarid_empresaLiquidacionImpuestoImpor;
	}

	public void setCargarid_empresaLiquidacionImpuestoImpor(Boolean cargarid_empresaLiquidacionImpuestoImpor) {
		this.cargarid_empresaLiquidacionImpuestoImpor= cargarid_empresaLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_sucursalLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalLiquidacionImpuestoImpor() {
		return this.resaltarid_sucursalLiquidacionImpuestoImpor;
	}

	public void setResaltarid_sucursalLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_sucursalLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalLiquidacionImpuestoImpor() {
		return this.mostrarid_sucursalLiquidacionImpuestoImpor;
	}

	public void setMostrarid_sucursalLiquidacionImpuestoImpor(Boolean mostrarid_sucursalLiquidacionImpuestoImpor) {
		this.mostrarid_sucursalLiquidacionImpuestoImpor= mostrarid_sucursalLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_sucursalLiquidacionImpuestoImpor() {
		return this.activarid_sucursalLiquidacionImpuestoImpor;
	}

	public void setActivarid_sucursalLiquidacionImpuestoImpor(Boolean activarid_sucursalLiquidacionImpuestoImpor) {
		this.activarid_sucursalLiquidacionImpuestoImpor= activarid_sucursalLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_sucursalLiquidacionImpuestoImpor() {
		return this.cargarid_sucursalLiquidacionImpuestoImpor;
	}

	public void setCargarid_sucursalLiquidacionImpuestoImpor(Boolean cargarid_sucursalLiquidacionImpuestoImpor) {
		this.cargarid_sucursalLiquidacionImpuestoImpor= cargarid_sucursalLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_clienteLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_clienteLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteLiquidacionImpuestoImpor() {
		return this.resaltarid_clienteLiquidacionImpuestoImpor;
	}

	public void setResaltarid_clienteLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_clienteLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_clienteLiquidacionImpuestoImpor() {
		return this.mostrarid_clienteLiquidacionImpuestoImpor;
	}

	public void setMostrarid_clienteLiquidacionImpuestoImpor(Boolean mostrarid_clienteLiquidacionImpuestoImpor) {
		this.mostrarid_clienteLiquidacionImpuestoImpor= mostrarid_clienteLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_clienteLiquidacionImpuestoImpor() {
		return this.activarid_clienteLiquidacionImpuestoImpor;
	}

	public void setActivarid_clienteLiquidacionImpuestoImpor(Boolean activarid_clienteLiquidacionImpuestoImpor) {
		this.activarid_clienteLiquidacionImpuestoImpor= activarid_clienteLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_clienteLiquidacionImpuestoImpor() {
		return this.cargarid_clienteLiquidacionImpuestoImpor;
	}

	public void setCargarid_clienteLiquidacionImpuestoImpor(Boolean cargarid_clienteLiquidacionImpuestoImpor) {
		this.cargarid_clienteLiquidacionImpuestoImpor= cargarid_clienteLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_facturaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_facturaLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaLiquidacionImpuestoImpor() {
		return this.resaltarid_facturaLiquidacionImpuestoImpor;
	}

	public void setResaltarid_facturaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_facturaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_facturaLiquidacionImpuestoImpor() {
		return this.mostrarid_facturaLiquidacionImpuestoImpor;
	}

	public void setMostrarid_facturaLiquidacionImpuestoImpor(Boolean mostrarid_facturaLiquidacionImpuestoImpor) {
		this.mostrarid_facturaLiquidacionImpuestoImpor= mostrarid_facturaLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_facturaLiquidacionImpuestoImpor() {
		return this.activarid_facturaLiquidacionImpuestoImpor;
	}

	public void setActivarid_facturaLiquidacionImpuestoImpor(Boolean activarid_facturaLiquidacionImpuestoImpor) {
		this.activarid_facturaLiquidacionImpuestoImpor= activarid_facturaLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_facturaLiquidacionImpuestoImpor() {
		return this.cargarid_facturaLiquidacionImpuestoImpor;
	}

	public void setCargarid_facturaLiquidacionImpuestoImpor(Boolean cargarid_facturaLiquidacionImpuestoImpor) {
		this.cargarid_facturaLiquidacionImpuestoImpor= cargarid_facturaLiquidacionImpuestoImpor;
	}

	public Border setResaltarnumero_comprobanteLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteLiquidacionImpuestoImpor() {
		return this.resaltarnumero_comprobanteLiquidacionImpuestoImpor;
	}

	public void setResaltarnumero_comprobanteLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarnumero_comprobanteLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteLiquidacionImpuestoImpor() {
		return this.mostrarnumero_comprobanteLiquidacionImpuestoImpor;
	}

	public void setMostrarnumero_comprobanteLiquidacionImpuestoImpor(Boolean mostrarnumero_comprobanteLiquidacionImpuestoImpor) {
		this.mostrarnumero_comprobanteLiquidacionImpuestoImpor= mostrarnumero_comprobanteLiquidacionImpuestoImpor;
	}

	public Boolean getActivarnumero_comprobanteLiquidacionImpuestoImpor() {
		return this.activarnumero_comprobanteLiquidacionImpuestoImpor;
	}

	public void setActivarnumero_comprobanteLiquidacionImpuestoImpor(Boolean activarnumero_comprobanteLiquidacionImpuestoImpor) {
		this.activarnumero_comprobanteLiquidacionImpuestoImpor= activarnumero_comprobanteLiquidacionImpuestoImpor;
	}

	public Border setResaltarnumero_duiLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarnumero_duiLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_duiLiquidacionImpuestoImpor() {
		return this.resaltarnumero_duiLiquidacionImpuestoImpor;
	}

	public void setResaltarnumero_duiLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarnumero_duiLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarnumero_duiLiquidacionImpuestoImpor() {
		return this.mostrarnumero_duiLiquidacionImpuestoImpor;
	}

	public void setMostrarnumero_duiLiquidacionImpuestoImpor(Boolean mostrarnumero_duiLiquidacionImpuestoImpor) {
		this.mostrarnumero_duiLiquidacionImpuestoImpor= mostrarnumero_duiLiquidacionImpuestoImpor;
	}

	public Boolean getActivarnumero_duiLiquidacionImpuestoImpor() {
		return this.activarnumero_duiLiquidacionImpuestoImpor;
	}

	public void setActivarnumero_duiLiquidacionImpuestoImpor(Boolean activarnumero_duiLiquidacionImpuestoImpor) {
		this.activarnumero_duiLiquidacionImpuestoImpor= activarnumero_duiLiquidacionImpuestoImpor;
	}

	public Border setResaltarfechaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfechaLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaLiquidacionImpuestoImpor() {
		return this.resaltarfechaLiquidacionImpuestoImpor;
	}

	public void setResaltarfechaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfechaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfechaLiquidacionImpuestoImpor() {
		return this.mostrarfechaLiquidacionImpuestoImpor;
	}

	public void setMostrarfechaLiquidacionImpuestoImpor(Boolean mostrarfechaLiquidacionImpuestoImpor) {
		this.mostrarfechaLiquidacionImpuestoImpor= mostrarfechaLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfechaLiquidacionImpuestoImpor() {
		return this.activarfechaLiquidacionImpuestoImpor;
	}

	public void setActivarfechaLiquidacionImpuestoImpor(Boolean activarfechaLiquidacionImpuestoImpor) {
		this.activarfechaLiquidacionImpuestoImpor= activarfechaLiquidacionImpuestoImpor;
	}

	public Border setResaltarfecha_pagoLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoLiquidacionImpuestoImpor() {
		return this.resaltarfecha_pagoLiquidacionImpuestoImpor;
	}

	public void setResaltarfecha_pagoLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfecha_pagoLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoLiquidacionImpuestoImpor() {
		return this.mostrarfecha_pagoLiquidacionImpuestoImpor;
	}

	public void setMostrarfecha_pagoLiquidacionImpuestoImpor(Boolean mostrarfecha_pagoLiquidacionImpuestoImpor) {
		this.mostrarfecha_pagoLiquidacionImpuestoImpor= mostrarfecha_pagoLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfecha_pagoLiquidacionImpuestoImpor() {
		return this.activarfecha_pagoLiquidacionImpuestoImpor;
	}

	public void setActivarfecha_pagoLiquidacionImpuestoImpor(Boolean activarfecha_pagoLiquidacionImpuestoImpor) {
		this.activarfecha_pagoLiquidacionImpuestoImpor= activarfecha_pagoLiquidacionImpuestoImpor;
	}

	public Border setResaltarfobLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfobLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfobLiquidacionImpuestoImpor() {
		return this.resaltarfobLiquidacionImpuestoImpor;
	}

	public void setResaltarfobLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfobLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfobLiquidacionImpuestoImpor() {
		return this.mostrarfobLiquidacionImpuestoImpor;
	}

	public void setMostrarfobLiquidacionImpuestoImpor(Boolean mostrarfobLiquidacionImpuestoImpor) {
		this.mostrarfobLiquidacionImpuestoImpor= mostrarfobLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfobLiquidacionImpuestoImpor() {
		return this.activarfobLiquidacionImpuestoImpor;
	}

	public void setActivarfobLiquidacionImpuestoImpor(Boolean activarfobLiquidacionImpuestoImpor) {
		this.activarfobLiquidacionImpuestoImpor= activarfobLiquidacionImpuestoImpor;
	}

	public Border setResaltarseguroLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarseguroLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarseguroLiquidacionImpuestoImpor() {
		return this.resaltarseguroLiquidacionImpuestoImpor;
	}

	public void setResaltarseguroLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarseguroLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarseguroLiquidacionImpuestoImpor() {
		return this.mostrarseguroLiquidacionImpuestoImpor;
	}

	public void setMostrarseguroLiquidacionImpuestoImpor(Boolean mostrarseguroLiquidacionImpuestoImpor) {
		this.mostrarseguroLiquidacionImpuestoImpor= mostrarseguroLiquidacionImpuestoImpor;
	}

	public Boolean getActivarseguroLiquidacionImpuestoImpor() {
		return this.activarseguroLiquidacionImpuestoImpor;
	}

	public void setActivarseguroLiquidacionImpuestoImpor(Boolean activarseguroLiquidacionImpuestoImpor) {
		this.activarseguroLiquidacionImpuestoImpor= activarseguroLiquidacionImpuestoImpor;
	}

	public Border setResaltarfleteLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfleteLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteLiquidacionImpuestoImpor() {
		return this.resaltarfleteLiquidacionImpuestoImpor;
	}

	public void setResaltarfleteLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfleteLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfleteLiquidacionImpuestoImpor() {
		return this.mostrarfleteLiquidacionImpuestoImpor;
	}

	public void setMostrarfleteLiquidacionImpuestoImpor(Boolean mostrarfleteLiquidacionImpuestoImpor) {
		this.mostrarfleteLiquidacionImpuestoImpor= mostrarfleteLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfleteLiquidacionImpuestoImpor() {
		return this.activarfleteLiquidacionImpuestoImpor;
	}

	public void setActivarfleteLiquidacionImpuestoImpor(Boolean activarfleteLiquidacionImpuestoImpor) {
		this.activarfleteLiquidacionImpuestoImpor= activarfleteLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_fodiLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_fodiLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_fodiLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_fodiLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_fodiLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_fodiLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_fodiLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_fodiLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_fodiLiquidacionImpuestoImpor(Boolean mostrarporcentaje_fodiLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_fodiLiquidacionImpuestoImpor= mostrarporcentaje_fodiLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_fodiLiquidacionImpuestoImpor() {
		return this.activarporcentaje_fodiLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_fodiLiquidacionImpuestoImpor(Boolean activarporcentaje_fodiLiquidacionImpuestoImpor) {
		this.activarporcentaje_fodiLiquidacionImpuestoImpor= activarporcentaje_fodiLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_ivaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ivaLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ivaLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_ivaLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_ivaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_ivaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ivaLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_ivaLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_ivaLiquidacionImpuestoImpor(Boolean mostrarporcentaje_ivaLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_ivaLiquidacionImpuestoImpor= mostrarporcentaje_ivaLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_ivaLiquidacionImpuestoImpor() {
		return this.activarporcentaje_ivaLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_ivaLiquidacionImpuestoImpor(Boolean activarporcentaje_ivaLiquidacionImpuestoImpor) {
		this.activarporcentaje_ivaLiquidacionImpuestoImpor= activarporcentaje_ivaLiquidacionImpuestoImpor;
	}

	public Border setResaltartasa_controlLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltartasa_controlLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartasa_controlLiquidacionImpuestoImpor() {
		return this.resaltartasa_controlLiquidacionImpuestoImpor;
	}

	public void setResaltartasa_controlLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltartasa_controlLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrartasa_controlLiquidacionImpuestoImpor() {
		return this.mostrartasa_controlLiquidacionImpuestoImpor;
	}

	public void setMostrartasa_controlLiquidacionImpuestoImpor(Boolean mostrartasa_controlLiquidacionImpuestoImpor) {
		this.mostrartasa_controlLiquidacionImpuestoImpor= mostrartasa_controlLiquidacionImpuestoImpor;
	}

	public Boolean getActivartasa_controlLiquidacionImpuestoImpor() {
		return this.activartasa_controlLiquidacionImpuestoImpor;
	}

	public void setActivartasa_controlLiquidacionImpuestoImpor(Boolean activartasa_controlLiquidacionImpuestoImpor) {
		this.activartasa_controlLiquidacionImpuestoImpor= activartasa_controlLiquidacionImpuestoImpor;
	}

	public Border setResaltarcfrLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarcfrLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcfrLiquidacionImpuestoImpor() {
		return this.resaltarcfrLiquidacionImpuestoImpor;
	}

	public void setResaltarcfrLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarcfrLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarcfrLiquidacionImpuestoImpor() {
		return this.mostrarcfrLiquidacionImpuestoImpor;
	}

	public void setMostrarcfrLiquidacionImpuestoImpor(Boolean mostrarcfrLiquidacionImpuestoImpor) {
		this.mostrarcfrLiquidacionImpuestoImpor= mostrarcfrLiquidacionImpuestoImpor;
	}

	public Boolean getActivarcfrLiquidacionImpuestoImpor() {
		return this.activarcfrLiquidacionImpuestoImpor;
	}

	public void setActivarcfrLiquidacionImpuestoImpor(Boolean activarcfrLiquidacionImpuestoImpor) {
		this.activarcfrLiquidacionImpuestoImpor= activarcfrLiquidacionImpuestoImpor;
	}

	public Border setResaltarcifLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarcifLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcifLiquidacionImpuestoImpor() {
		return this.resaltarcifLiquidacionImpuestoImpor;
	}

	public void setResaltarcifLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarcifLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarcifLiquidacionImpuestoImpor() {
		return this.mostrarcifLiquidacionImpuestoImpor;
	}

	public void setMostrarcifLiquidacionImpuestoImpor(Boolean mostrarcifLiquidacionImpuestoImpor) {
		this.mostrarcifLiquidacionImpuestoImpor= mostrarcifLiquidacionImpuestoImpor;
	}

	public Boolean getActivarcifLiquidacionImpuestoImpor() {
		return this.activarcifLiquidacionImpuestoImpor;
	}

	public void setActivarcifLiquidacionImpuestoImpor(Boolean activarcifLiquidacionImpuestoImpor) {
		this.activarcifLiquidacionImpuestoImpor= activarcifLiquidacionImpuestoImpor;
	}

	public Border setResaltartotalLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltartotalLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalLiquidacionImpuestoImpor() {
		return this.resaltartotalLiquidacionImpuestoImpor;
	}

	public void setResaltartotalLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltartotalLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrartotalLiquidacionImpuestoImpor() {
		return this.mostrartotalLiquidacionImpuestoImpor;
	}

	public void setMostrartotalLiquidacionImpuestoImpor(Boolean mostrartotalLiquidacionImpuestoImpor) {
		this.mostrartotalLiquidacionImpuestoImpor= mostrartotalLiquidacionImpuestoImpor;
	}

	public Boolean getActivartotalLiquidacionImpuestoImpor() {
		return this.activartotalLiquidacionImpuestoImpor;
	}

	public void setActivartotalLiquidacionImpuestoImpor(Boolean activartotalLiquidacionImpuestoImpor) {
		this.activartotalLiquidacionImpuestoImpor= activartotalLiquidacionImpuestoImpor;
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
		
		
		this.setMostraridLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_pedido_compra_imporLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_empresaLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_sucursalLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_clienteLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_facturaLiquidacionImpuestoImpor(esInicial);
		this.setMostrarnumero_comprobanteLiquidacionImpuestoImpor(esInicial);
		this.setMostrarnumero_duiLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfechaLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfecha_pagoLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfobLiquidacionImpuestoImpor(esInicial);
		this.setMostrarseguroLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfleteLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_fodiLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_ivaLiquidacionImpuestoImpor(esInicial);
		this.setMostrartasa_controlLiquidacionImpuestoImpor(esInicial);
		this.setMostrarcfrLiquidacionImpuestoImpor(esInicial);
		this.setMostrarcifLiquidacionImpuestoImpor(esInicial);
		this.setMostrartotalLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setMostraridLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setMostrarid_pedido_compra_imporLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMERODUI)) {
				this.setMostrarnumero_duiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHA)) {
				this.setMostrarfechaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setMostrarfobLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setMostrarseguroLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setMostrarfleteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setMostrarporcentaje_fodiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setMostrarporcentaje_ivaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL)) {
				this.setMostrartasa_controlLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CFR)) {
				this.setMostrarcfrLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CIF)) {
				this.setMostrarcifLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TOTAL)) {
				this.setMostrartotalLiquidacionImpuestoImpor(esAsigna);
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
		
		
		this.setActivaridLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_pedido_compra_imporLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_empresaLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_sucursalLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_clienteLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_facturaLiquidacionImpuestoImpor(esInicial);
		this.setActivarnumero_comprobanteLiquidacionImpuestoImpor(esInicial);
		this.setActivarnumero_duiLiquidacionImpuestoImpor(esInicial);
		this.setActivarfechaLiquidacionImpuestoImpor(esInicial);
		this.setActivarfecha_pagoLiquidacionImpuestoImpor(esInicial);
		this.setActivarfobLiquidacionImpuestoImpor(esInicial);
		this.setActivarseguroLiquidacionImpuestoImpor(esInicial);
		this.setActivarfleteLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_fodiLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_ivaLiquidacionImpuestoImpor(esInicial);
		this.setActivartasa_controlLiquidacionImpuestoImpor(esInicial);
		this.setActivarcfrLiquidacionImpuestoImpor(esInicial);
		this.setActivarcifLiquidacionImpuestoImpor(esInicial);
		this.setActivartotalLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setActivaridLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setActivarid_pedido_compra_imporLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMERODUI)) {
				this.setActivarnumero_duiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHA)) {
				this.setActivarfechaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setActivarfobLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setActivarseguroLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setActivarfleteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setActivarporcentaje_fodiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setActivarporcentaje_ivaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL)) {
				this.setActivartasa_controlLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CFR)) {
				this.setActivarcfrLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CIF)) {
				this.setActivarcifLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TOTAL)) {
				this.setActivartotalLiquidacionImpuestoImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_pedido_compra_imporLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_empresaLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_sucursalLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_clienteLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_facturaLiquidacionImpuestoImpor(esInicial);
		this.setResaltarnumero_comprobanteLiquidacionImpuestoImpor(esInicial);
		this.setResaltarnumero_duiLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfechaLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfecha_pagoLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfobLiquidacionImpuestoImpor(esInicial);
		this.setResaltarseguroLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfleteLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_fodiLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_ivaLiquidacionImpuestoImpor(esInicial);
		this.setResaltartasa_controlLiquidacionImpuestoImpor(esInicial);
		this.setResaltarcfrLiquidacionImpuestoImpor(esInicial);
		this.setResaltarcifLiquidacionImpuestoImpor(esInicial);
		this.setResaltartotalLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setResaltaridLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setResaltarid_pedido_compra_imporLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.NUMERODUI)) {
				this.setResaltarnumero_duiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHA)) {
				this.setResaltarfechaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setResaltarfobLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setResaltarseguroLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setResaltarfleteLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setResaltarporcentaje_fodiLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setResaltarporcentaje_ivaLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL)) {
				this.setResaltartasa_controlLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CFR)) {
				this.setResaltarcfrLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.CIF)) {
				this.setResaltarcifLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImpuestoImporConstantesFunciones.TOTAL)) {
				this.setResaltartotalLiquidacionImpuestoImpor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor=null;

	public Border getResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor() {
		return this.resaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor;
	}

	public void setResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(Border borderResaltarDetalleLiquidacionImpuestoImpor) {
		if(borderResaltarDetalleLiquidacionImpuestoImpor!=null) {
			this.resaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor= borderResaltarDetalleLiquidacionImpuestoImpor;
		}
	}

	public Border setResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleLiquidacionImpuestoImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//liquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpuestoImpor.setBorder(borderResaltarDetalleLiquidacionImpuestoImpor);
			
		this.resaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor= borderResaltarDetalleLiquidacionImpuestoImpor;

		 return borderResaltarDetalleLiquidacionImpuestoImpor;
	}



	public Boolean mostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor=true;

	public Boolean getMostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor() {
		return this.mostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor;
	}

	public void setMostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(Boolean visibilidadResaltarDetalleLiquidacionImpuestoImpor) {
		this.mostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor= visibilidadResaltarDetalleLiquidacionImpuestoImpor;
	}



	public Boolean activarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor=true;

	public Boolean gethabilitarResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor() {
		return this.activarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor;
	}

	public void setActivarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(Boolean habilitarResaltarDetalleLiquidacionImpuestoImpor) {
		this.activarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor= habilitarResaltarDetalleLiquidacionImpuestoImpor;
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

		this.setMostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpuestoImpor.class)) {
				this.setMostrarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esAsigna);
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

		this.setActivarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpuestoImpor.class)) {
				this.setActivarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpuestoImpor.class)) {
				this.setResaltarDetalleLiquidacionImpuestoImporLiquidacionImpuestoImpor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdClienteLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdClienteLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdClienteLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdEmpresaLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdEmpresaLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdEmpresaLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdFacturaLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdFacturaLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdFacturaLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoCompraImporLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdPedidoCompraImporLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdPedidoCompraImporLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdPedidoCompraImporLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoCompraImporLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdSucursalLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdSucursalLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdSucursalLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalLiquidacionImpuestoImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdClienteLiquidacionImpuestoImpor() {
		return this.activarFK_IdClienteLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdClienteLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdClienteLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdEmpresaLiquidacionImpuestoImpor() {
		return this.activarFK_IdEmpresaLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdEmpresaLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdFacturaLiquidacionImpuestoImpor() {
		return this.activarFK_IdFacturaLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdFacturaLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoCompraImporLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdPedidoCompraImporLiquidacionImpuestoImpor() {
		return this.activarFK_IdPedidoCompraImporLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdPedidoCompraImporLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoCompraImporLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdSucursalLiquidacionImpuestoImpor() {
		return this.activarFK_IdSucursalLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdSucursalLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalLiquidacionImpuestoImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdClienteLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdClienteLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdClienteLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdClienteLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdClienteLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdEmpresaLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdEmpresaLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdEmpresaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdFacturaLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdFacturaLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdFacturaLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdFacturaLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdFacturaLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdFacturaLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoCompraImporLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdSucursalLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdSucursalLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdSucursalLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImpuestoImporBeanSwingJInternalFrame liquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalLiquidacionImpuestoImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}