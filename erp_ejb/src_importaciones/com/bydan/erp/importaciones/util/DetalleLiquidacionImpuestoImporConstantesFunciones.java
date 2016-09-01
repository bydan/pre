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


import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporParameterGeneral;

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
final public class DetalleLiquidacionImpuestoImporConstantesFunciones extends DetalleLiquidacionImpuestoImporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleLiquidacionImpuestoImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleLiquidacionImpuestoImpor"+DetalleLiquidacionImpuestoImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleLiquidacionImpuestoImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleLiquidacionImpuestoImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"_"+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleLiquidacionImpuestoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleLiquidacionImpuestoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleLiquidacionImpuestoImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleLiquidacionImpuestoImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleLiquidacionImpuestoImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleLiquidacionImpuestoImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Liquidacion Impuesto Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Liquidacion Impuesto Impor";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Liquidacion Impuesto Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleLiquidacionImpuestoImpor";
	public static final String OBJECTNAME="detalleliquidacionimpuestoimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="detalle_liquidacion_impuesto_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleliquidacionimpuestoimpor from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SPERSISTENCENAME+" detalleliquidacionimpuestoimpor";
	public static String QUERYSELECTNATIVE="select "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_liquidacion_impuesto_impor,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_empresa,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cantidad,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fob,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_arancel,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_aplicar,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".flete,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".seguro,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".base_imponible,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_arancel,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_fodi,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_iva,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_fodi,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_imponible from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleLiquidacionImpuestoImporConstantesFuncionesAdditional detalleliquidacionimpuestoimporConstantesFuncionesAdditional=null;
	
	public DetalleLiquidacionImpuestoImporConstantesFuncionesAdditional getDetalleLiquidacionImpuestoImporConstantesFuncionesAdditional() {
		return this.detalleliquidacionimpuestoimporConstantesFuncionesAdditional;
	}
	
	public void setDetalleLiquidacionImpuestoImporConstantesFuncionesAdditional(DetalleLiquidacionImpuestoImporConstantesFuncionesAdditional detalleliquidacionimpuestoimporConstantesFuncionesAdditional) {
		try {
			this.detalleliquidacionimpuestoimporConstantesFuncionesAdditional=detalleliquidacionimpuestoimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDLIQUIDACIONIMPUESTOIMPOR= "id_liquidacion_impuesto_impor";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CANTIDAD= "cantidad";
    public static final String VALOR= "valor";
    public static final String FOB= "fob";
    public static final String PORCENTAJEIVA= "porcentaje_iva";
    public static final String PORCENTAJEARANCEL= "porcentaje_arancel";
    public static final String PORCENTAJEAPLICAR= "porcentaje_aplicar";
    public static final String FLETE= "flete";
    public static final String SEGURO= "seguro";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String VALORARANCEL= "valor_arancel";
    public static final String VALORFODI= "valor_fodi";
    public static final String VALORIVA= "valor_iva";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String PORCENTAJEFODI= "porcentaje_fodi";
    public static final String VALORIMPONIBLE= "valor_imponible";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDLIQUIDACIONIMPUESTOIMPOR= "Liquacion Impuesto Impor";
		public static final String LABEL_IDLIQUIDACIONIMPUESTOIMPOR_LOWER= "Liquidacion Impuesto Impor";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FOB= "Fob";
		public static final String LABEL_FOB_LOWER= "Fob";
    	public static final String LABEL_PORCENTAJEIVA= "Porcentaje Iva";
		public static final String LABEL_PORCENTAJEIVA_LOWER= "Porcentaje Iva";
    	public static final String LABEL_PORCENTAJEARANCEL= "Porcentaje Arancel";
		public static final String LABEL_PORCENTAJEARANCEL_LOWER= "Porcentaje Arancel";
    	public static final String LABEL_PORCENTAJEAPLICAR= "Porcentaje Aplicar";
		public static final String LABEL_PORCENTAJEAPLICAR_LOWER= "Porcentaje Aplicar";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_SEGURO= "Seguro";
		public static final String LABEL_SEGURO_LOWER= "Seguro";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_VALORARANCEL= "Valor Arancel";
		public static final String LABEL_VALORARANCEL_LOWER= "Valor Arancel";
    	public static final String LABEL_VALORFODI= "Valor Fodi";
		public static final String LABEL_VALORFODI_LOWER= "Valor Fodi";
    	public static final String LABEL_VALORIVA= "Valor Iva";
		public static final String LABEL_VALORIVA_LOWER= "Valor Iva";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_PORCENTAJEFODI= "Porcentaje Fodi";
		public static final String LABEL_PORCENTAJEFODI_LOWER= "Porcentaje Fodi";
    	public static final String LABEL_VALORIMPONIBLE= "Valor Imponible";
		public static final String LABEL_VALORIMPONIBLE_LOWER= "Valor Imponible";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleLiquidacionImpuestoImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPUESTOIMPOR;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI;}
		if(sNombreColumna.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE)) {sLabelColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleLiquidacionImpuestoImporDescripcion(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleliquidacionimpuestoimpor !=null/* && detalleliquidacionimpuestoimpor.getId()!=0*/) {
			if(detalleliquidacionimpuestoimpor.getId()!=null) {
				sDescripcion=detalleliquidacionimpuestoimpor.getId().toString();
			}//detalleliquidacionimpuestoimpordetalleliquidacionimpuestoimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleLiquidacionImpuestoImporDescripcionDetallado(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) {
		String sDescripcion="";
			
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.ID+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getId().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getVersionRow().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getid_empresa().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getid_sucursal().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getcantidad().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getvalor().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.FOB+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getfob().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getporcentaje_iva().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getporcentaje_arancel().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getporcentaje_aplicar().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getflete().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getseguro().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getbase_imponible().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getvalor_arancel().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getvalor_fodi().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getvalor_iva().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getnumero_comprobante().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getporcentaje_fodi().toString()+",";
		sDescripcion+=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE+"=";
		sDescripcion+=detalleliquidacionimpuestoimpor.getvalor_imponible().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleLiquidacionImpuestoImporDescripcion(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,String sValor) throws Exception {			
		if(detalleliquidacionimpuestoimpor !=null) {
			//detalleliquidacionimpuestoimpordetalleliquidacionimpuestoimpor.getId().toString();
		}		
	}
	
		

	public static String getLiquidacionImpuestoImporDescripcion(LiquidacionImpuestoImpor liquidacionimpuestoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(liquidacionimpuestoimpor!=null/*&&liquidacionimpuestoimpor.getId()>0*/) {
			sDescripcion=LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporDescripcion(liquidacionimpuestoimpor);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLiquidacionImpuestoImpor")) {
			sNombreIndice="Tipo=  Por Liquacion Impuesto Impor";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdLiquidacionImpuestoImpor(Long id_liquidacion_impuesto_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_liquidacion_impuesto_impor!=null) {sDetalleIndice+=" Codigo Unico De Liquacion Impuesto Impor="+id_liquidacion_impuesto_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleliquidacionimpuestoimpor.getConCambioAuxiliar()) {
			detalleliquidacionimpuestoimpor.setIsDeleted(detalleliquidacionimpuestoimpor.getIsDeletedAuxiliar());	
			detalleliquidacionimpuestoimpor.setIsNew(detalleliquidacionimpuestoimpor.getIsNewAuxiliar());	
			detalleliquidacionimpuestoimpor.setIsChanged(detalleliquidacionimpuestoimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleliquidacionimpuestoimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleliquidacionimpuestoimpor.setIsDeletedAuxiliar(false);	
			detalleliquidacionimpuestoimpor.setIsNewAuxiliar(false);	
			detalleliquidacionimpuestoimpor.setIsChangedAuxiliar(false);
			
			detalleliquidacionimpuestoimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor : detalleliquidacionimpuestoimpors) {
			if(conAsignarBase && detalleliquidacionimpuestoimpor.getConCambioAuxiliar()) {
				detalleliquidacionimpuestoimpor.setIsDeleted(detalleliquidacionimpuestoimpor.getIsDeletedAuxiliar());	
				detalleliquidacionimpuestoimpor.setIsNew(detalleliquidacionimpuestoimpor.getIsNewAuxiliar());	
				detalleliquidacionimpuestoimpor.setIsChanged(detalleliquidacionimpuestoimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleliquidacionimpuestoimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleliquidacionimpuestoimpor.setIsDeletedAuxiliar(false);	
				detalleliquidacionimpuestoimpor.setIsNewAuxiliar(false);	
				detalleliquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
				detalleliquidacionimpuestoimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean conEnteros) throws Exception  {
		detalleliquidacionimpuestoimpor.setvalor(0.0);
		detalleliquidacionimpuestoimpor.setfob(0.0);
		detalleliquidacionimpuestoimpor.setporcentaje_iva(0.0);
		detalleliquidacionimpuestoimpor.setporcentaje_arancel(0.0);
		detalleliquidacionimpuestoimpor.setporcentaje_aplicar(0.0);
		detalleliquidacionimpuestoimpor.setflete(0.0);
		detalleliquidacionimpuestoimpor.setseguro(0.0);
		detalleliquidacionimpuestoimpor.setbase_imponible(0.0);
		detalleliquidacionimpuestoimpor.setvalor_arancel(0.0);
		detalleliquidacionimpuestoimpor.setvalor_fodi(0.0);
		detalleliquidacionimpuestoimpor.setvalor_iva(0.0);
		detalleliquidacionimpuestoimpor.setporcentaje_fodi(0.0);
		detalleliquidacionimpuestoimpor.setvalor_imponible(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleliquidacionimpuestoimpor.setcantidad(0);
			detalleliquidacionimpuestoimpor.setnumero_comprobante(0);
		}
	}		
	
	public static void InicializarValoresDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,Boolean conEnteros) throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {
			detalleliquidacionimpuestoimpor.setvalor(0.0);
			detalleliquidacionimpuestoimpor.setfob(0.0);
			detalleliquidacionimpuestoimpor.setporcentaje_iva(0.0);
			detalleliquidacionimpuestoimpor.setporcentaje_arancel(0.0);
			detalleliquidacionimpuestoimpor.setporcentaje_aplicar(0.0);
			detalleliquidacionimpuestoimpor.setflete(0.0);
			detalleliquidacionimpuestoimpor.setseguro(0.0);
			detalleliquidacionimpuestoimpor.setbase_imponible(0.0);
			detalleliquidacionimpuestoimpor.setvalor_arancel(0.0);
			detalleliquidacionimpuestoimpor.setvalor_fodi(0.0);
			detalleliquidacionimpuestoimpor.setvalor_iva(0.0);
			detalleliquidacionimpuestoimpor.setporcentaje_fodi(0.0);
			detalleliquidacionimpuestoimpor.setvalor_imponible(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleliquidacionimpuestoimpor.setcantidad(0);
				detalleliquidacionimpuestoimpor.setnumero_comprobante(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux) throws Exception  {
		DetalleLiquidacionImpuestoImporConstantesFunciones.InicializarValoresDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporAux,true);
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {
			if(detalleliquidacionimpuestoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleliquidacionimpuestoimporAux.setcantidad(detalleliquidacionimpuestoimporAux.getcantidad()+detalleliquidacionimpuestoimpor.getcantidad());			
			detalleliquidacionimpuestoimporAux.setvalor(detalleliquidacionimpuestoimporAux.getvalor()+detalleliquidacionimpuestoimpor.getvalor());			
			detalleliquidacionimpuestoimporAux.setfob(detalleliquidacionimpuestoimporAux.getfob()+detalleliquidacionimpuestoimpor.getfob());			
			detalleliquidacionimpuestoimporAux.setporcentaje_iva(detalleliquidacionimpuestoimporAux.getporcentaje_iva()+detalleliquidacionimpuestoimpor.getporcentaje_iva());			
			detalleliquidacionimpuestoimporAux.setporcentaje_arancel(detalleliquidacionimpuestoimporAux.getporcentaje_arancel()+detalleliquidacionimpuestoimpor.getporcentaje_arancel());			
			detalleliquidacionimpuestoimporAux.setporcentaje_aplicar(detalleliquidacionimpuestoimporAux.getporcentaje_aplicar()+detalleliquidacionimpuestoimpor.getporcentaje_aplicar());			
			detalleliquidacionimpuestoimporAux.setflete(detalleliquidacionimpuestoimporAux.getflete()+detalleliquidacionimpuestoimpor.getflete());			
			detalleliquidacionimpuestoimporAux.setseguro(detalleliquidacionimpuestoimporAux.getseguro()+detalleliquidacionimpuestoimpor.getseguro());			
			detalleliquidacionimpuestoimporAux.setbase_imponible(detalleliquidacionimpuestoimporAux.getbase_imponible()+detalleliquidacionimpuestoimpor.getbase_imponible());			
			detalleliquidacionimpuestoimporAux.setvalor_arancel(detalleliquidacionimpuestoimporAux.getvalor_arancel()+detalleliquidacionimpuestoimpor.getvalor_arancel());			
			detalleliquidacionimpuestoimporAux.setvalor_fodi(detalleliquidacionimpuestoimporAux.getvalor_fodi()+detalleliquidacionimpuestoimpor.getvalor_fodi());			
			detalleliquidacionimpuestoimporAux.setvalor_iva(detalleliquidacionimpuestoimporAux.getvalor_iva()+detalleliquidacionimpuestoimpor.getvalor_iva());			
			detalleliquidacionimpuestoimporAux.setnumero_comprobante(detalleliquidacionimpuestoimporAux.getnumero_comprobante()+detalleliquidacionimpuestoimpor.getnumero_comprobante());			
			detalleliquidacionimpuestoimporAux.setporcentaje_fodi(detalleliquidacionimpuestoimporAux.getporcentaje_fodi()+detalleliquidacionimpuestoimpor.getporcentaje_fodi());			
			detalleliquidacionimpuestoimporAux.setvalor_imponible(detalleliquidacionimpuestoimporAux.getvalor_imponible()+detalleliquidacionimpuestoimpor.getvalor_imponible());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleLiquidacionImpuestoImporConstantesFunciones.getArrayColumnasGlobalesDetalleLiquidacionImpuestoImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux: detalleliquidacionimpuestoimpors) {
			if(detalleliquidacionimpuestoimporAux!=null && detalleliquidacionimpuestoimpor!=null) {
				if((detalleliquidacionimpuestoimporAux.getId()==null && detalleliquidacionimpuestoimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleliquidacionimpuestoimporAux.getId()!=null && detalleliquidacionimpuestoimpor.getId()!=null){
					if(detalleliquidacionimpuestoimporAux.getId().equals(detalleliquidacionimpuestoimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double fobTotal=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double porcentaje_arancelTotal=0.0;
		Double porcentaje_aplicarTotal=0.0;
		Double fleteTotal=0.0;
		Double seguroTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valor_arancelTotal=0.0;
		Double valor_fodiTotal=0.0;
		Double valor_ivaTotal=0.0;
		Double porcentaje_fodiTotal=0.0;
		Double valor_imponibleTotal=0.0;
	
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {			
			if(detalleliquidacionimpuestoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detalleliquidacionimpuestoimpor.getvalor();
			fobTotal+=detalleliquidacionimpuestoimpor.getfob();
			porcentaje_ivaTotal+=detalleliquidacionimpuestoimpor.getporcentaje_iva();
			porcentaje_arancelTotal+=detalleliquidacionimpuestoimpor.getporcentaje_arancel();
			porcentaje_aplicarTotal+=detalleliquidacionimpuestoimpor.getporcentaje_aplicar();
			fleteTotal+=detalleliquidacionimpuestoimpor.getflete();
			seguroTotal+=detalleliquidacionimpuestoimpor.getseguro();
			base_imponibleTotal+=detalleliquidacionimpuestoimpor.getbase_imponible();
			valor_arancelTotal+=detalleliquidacionimpuestoimpor.getvalor_arancel();
			valor_fodiTotal+=detalleliquidacionimpuestoimpor.getvalor_fodi();
			valor_ivaTotal+=detalleliquidacionimpuestoimpor.getvalor_iva();
			porcentaje_fodiTotal+=detalleliquidacionimpuestoimpor.getporcentaje_fodi();
			valor_imponibleTotal+=detalleliquidacionimpuestoimpor.getvalor_imponible();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		datoGeneral.setdValorDouble(porcentaje_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR);
		datoGeneral.setdValorDouble(porcentaje_aplicarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL);
		datoGeneral.setdValorDouble(valor_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI);
		datoGeneral.setdValorDouble(valor_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA);
		datoGeneral.setdValorDouble(valor_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		datoGeneral.setdValorDouble(porcentaje_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE);
		datoGeneral.setdValorDouble(valor_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleLiquidacionImpuestoImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_ID, DetalleLiquidacionImpuestoImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VERSIONROW, DetalleLiquidacionImpuestoImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPUESTOIMPOR, DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA, DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL, DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_CANTIDAD, DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR, DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB, DetalleLiquidacionImpuestoImporConstantesFunciones.FOB,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA, DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL, DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR, DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE, DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO, DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE, DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL, DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI, DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA, DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI, DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE, DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleLiquidacionImpuestoImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.FOB;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpuestoImpor() throws Exception  {
		return DetalleLiquidacionImpuestoImporConstantesFunciones.getTiposSeleccionarDetalleLiquidacionImpuestoImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpuestoImpor(Boolean conFk) throws Exception  {
		return DetalleLiquidacionImpuestoImporConstantesFunciones.getTiposSeleccionarDetalleLiquidacionImpuestoImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleLiquidacionImpuestoImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPUESTOIMPOR);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPUESTOIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE);
			reporte.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleLiquidacionImpuestoImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux) throws Exception {
		
			detalleliquidacionimpuestoimporAux.setliquidacionimpuestoimpor_descripcion(LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporDescripcion(detalleliquidacionimpuestoimporAux.getLiquidacionImpuestoImpor()));
			detalleliquidacionimpuestoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleliquidacionimpuestoimporAux.getEmpresa()));
			detalleliquidacionimpuestoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleliquidacionimpuestoimporAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimporsTemp) throws Exception {
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux:detalleliquidacionimpuestoimporsTemp) {
			
			detalleliquidacionimpuestoimporAux.setliquidacionimpuestoimpor_descripcion(LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporDescripcion(detalleliquidacionimpuestoimporAux.getLiquidacionImpuestoImpor()));
			detalleliquidacionimpuestoimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleliquidacionimpuestoimporAux.getEmpresa()));
			detalleliquidacionimpuestoimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleliquidacionimpuestoimporAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(LiquidacionImpuestoImpor.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(LiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(LiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsOfDetalleLiquidacionImpuestoImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleLiquidacionImpuestoImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleLiquidacionImpuestoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporEncontrado=null;
			
			for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal:detalleliquidacionimpuestoimpors) {
				if(detalleliquidacionimpuestoimporLocal.getId().equals(detalleliquidacionimpuestoimpor.getId())) {
					detalleliquidacionimpuestoimporEncontrado=detalleliquidacionimpuestoimporLocal;
					
					detalleliquidacionimpuestoimporLocal.setIsChanged(detalleliquidacionimpuestoimpor.getIsChanged());
					detalleliquidacionimpuestoimporLocal.setIsNew(detalleliquidacionimpuestoimpor.getIsNew());
					detalleliquidacionimpuestoimporLocal.setIsDeleted(detalleliquidacionimpuestoimpor.getIsDeleted());
					
					detalleliquidacionimpuestoimporLocal.setGeneralEntityOriginal(detalleliquidacionimpuestoimpor.getGeneralEntityOriginal());
					
					detalleliquidacionimpuestoimporLocal.setId(detalleliquidacionimpuestoimpor.getId());	
					detalleliquidacionimpuestoimporLocal.setVersionRow(detalleliquidacionimpuestoimpor.getVersionRow());	
					detalleliquidacionimpuestoimporLocal.setid_liquidacion_impuesto_impor(detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor());	
					detalleliquidacionimpuestoimporLocal.setid_empresa(detalleliquidacionimpuestoimpor.getid_empresa());	
					detalleliquidacionimpuestoimporLocal.setid_sucursal(detalleliquidacionimpuestoimpor.getid_sucursal());	
					detalleliquidacionimpuestoimporLocal.setcantidad(detalleliquidacionimpuestoimpor.getcantidad());	
					detalleliquidacionimpuestoimporLocal.setvalor(detalleliquidacionimpuestoimpor.getvalor());	
					detalleliquidacionimpuestoimporLocal.setfob(detalleliquidacionimpuestoimpor.getfob());	
					detalleliquidacionimpuestoimporLocal.setporcentaje_iva(detalleliquidacionimpuestoimpor.getporcentaje_iva());	
					detalleliquidacionimpuestoimporLocal.setporcentaje_arancel(detalleliquidacionimpuestoimpor.getporcentaje_arancel());	
					detalleliquidacionimpuestoimporLocal.setporcentaje_aplicar(detalleliquidacionimpuestoimpor.getporcentaje_aplicar());	
					detalleliquidacionimpuestoimporLocal.setflete(detalleliquidacionimpuestoimpor.getflete());	
					detalleliquidacionimpuestoimporLocal.setseguro(detalleliquidacionimpuestoimpor.getseguro());	
					detalleliquidacionimpuestoimporLocal.setbase_imponible(detalleliquidacionimpuestoimpor.getbase_imponible());	
					detalleliquidacionimpuestoimporLocal.setvalor_arancel(detalleliquidacionimpuestoimpor.getvalor_arancel());	
					detalleliquidacionimpuestoimporLocal.setvalor_fodi(detalleliquidacionimpuestoimpor.getvalor_fodi());	
					detalleliquidacionimpuestoimporLocal.setvalor_iva(detalleliquidacionimpuestoimpor.getvalor_iva());	
					detalleliquidacionimpuestoimporLocal.setnumero_comprobante(detalleliquidacionimpuestoimpor.getnumero_comprobante());	
					detalleliquidacionimpuestoimporLocal.setporcentaje_fodi(detalleliquidacionimpuestoimpor.getporcentaje_fodi());	
					detalleliquidacionimpuestoimporLocal.setvalor_imponible(detalleliquidacionimpuestoimpor.getvalor_imponible());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleliquidacionimpuestoimpor.getIsDeleted()) {
				if(!existe) {
					detalleliquidacionimpuestoimpors.add(detalleliquidacionimpuestoimpor);
				}
			} else {
				if(detalleliquidacionimpuestoimporEncontrado!=null && permiteQuitar)  {
					detalleliquidacionimpuestoimpors.remove(detalleliquidacionimpuestoimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors) throws Exception {
		try	{			
			for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal:detalleliquidacionimpuestoimpors) {
				if(detalleliquidacionimpuestoimporLocal.getId().equals(detalleliquidacionimpuestoimpor.getId())) {
					detalleliquidacionimpuestoimporLocal.setIsSelected(detalleliquidacionimpuestoimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimporsAux) throws Exception {
		//this.detalleliquidacionimpuestoimporsAux=detalleliquidacionimpuestoimporsAux;
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux:detalleliquidacionimpuestoimporsAux) {
			if(detalleliquidacionimpuestoimporAux.getIsChanged()) {
				detalleliquidacionimpuestoimporAux.setIsChanged(false);
			}		
			
			if(detalleliquidacionimpuestoimporAux.getIsNew()) {
				detalleliquidacionimpuestoimporAux.setIsNew(false);
			}	
			
			if(detalleliquidacionimpuestoimporAux.getIsDeleted()) {
				detalleliquidacionimpuestoimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux) throws Exception {
		//this.detalleliquidacionimpuestoimporAux=detalleliquidacionimpuestoimporAux;
		
			if(detalleliquidacionimpuestoimporAux.getIsChanged()) {
				detalleliquidacionimpuestoimporAux.setIsChanged(false);
			}		
			
			if(detalleliquidacionimpuestoimporAux.getIsNew()) {
				detalleliquidacionimpuestoimporAux.setIsNew(false);
			}	
			
			if(detalleliquidacionimpuestoimporAux.getIsDeleted()) {
				detalleliquidacionimpuestoimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAsignar,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {
		detalleliquidacionimpuestoimporAsignar.setId(detalleliquidacionimpuestoimpor.getId());	
		detalleliquidacionimpuestoimporAsignar.setVersionRow(detalleliquidacionimpuestoimpor.getVersionRow());	
		detalleliquidacionimpuestoimporAsignar.setid_liquidacion_impuesto_impor(detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor());
		detalleliquidacionimpuestoimporAsignar.setliquidacionimpuestoimpor_descripcion(detalleliquidacionimpuestoimpor.getliquidacionimpuestoimpor_descripcion());	
		detalleliquidacionimpuestoimporAsignar.setid_empresa(detalleliquidacionimpuestoimpor.getid_empresa());
		detalleliquidacionimpuestoimporAsignar.setempresa_descripcion(detalleliquidacionimpuestoimpor.getempresa_descripcion());	
		detalleliquidacionimpuestoimporAsignar.setid_sucursal(detalleliquidacionimpuestoimpor.getid_sucursal());
		detalleliquidacionimpuestoimporAsignar.setsucursal_descripcion(detalleliquidacionimpuestoimpor.getsucursal_descripcion());	
		detalleliquidacionimpuestoimporAsignar.setcantidad(detalleliquidacionimpuestoimpor.getcantidad());	
		detalleliquidacionimpuestoimporAsignar.setvalor(detalleliquidacionimpuestoimpor.getvalor());	
		detalleliquidacionimpuestoimporAsignar.setfob(detalleliquidacionimpuestoimpor.getfob());	
		detalleliquidacionimpuestoimporAsignar.setporcentaje_iva(detalleliquidacionimpuestoimpor.getporcentaje_iva());	
		detalleliquidacionimpuestoimporAsignar.setporcentaje_arancel(detalleliquidacionimpuestoimpor.getporcentaje_arancel());	
		detalleliquidacionimpuestoimporAsignar.setporcentaje_aplicar(detalleliquidacionimpuestoimpor.getporcentaje_aplicar());	
		detalleliquidacionimpuestoimporAsignar.setflete(detalleliquidacionimpuestoimpor.getflete());	
		detalleliquidacionimpuestoimporAsignar.setseguro(detalleliquidacionimpuestoimpor.getseguro());	
		detalleliquidacionimpuestoimporAsignar.setbase_imponible(detalleliquidacionimpuestoimpor.getbase_imponible());	
		detalleliquidacionimpuestoimporAsignar.setvalor_arancel(detalleliquidacionimpuestoimpor.getvalor_arancel());	
		detalleliquidacionimpuestoimporAsignar.setvalor_fodi(detalleliquidacionimpuestoimpor.getvalor_fodi());	
		detalleliquidacionimpuestoimporAsignar.setvalor_iva(detalleliquidacionimpuestoimpor.getvalor_iva());	
		detalleliquidacionimpuestoimporAsignar.setnumero_comprobante(detalleliquidacionimpuestoimpor.getnumero_comprobante());	
		detalleliquidacionimpuestoimporAsignar.setporcentaje_fodi(detalleliquidacionimpuestoimpor.getporcentaje_fodi());	
		detalleliquidacionimpuestoimporAsignar.setvalor_imponible(detalleliquidacionimpuestoimpor.getvalor_imponible());	
	}
	
	public static void inicializarDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {
		try {
				detalleliquidacionimpuestoimpor.setId(0L);	
					
				detalleliquidacionimpuestoimpor.setid_liquidacion_impuesto_impor(-1L);	
				detalleliquidacionimpuestoimpor.setid_empresa(-1L);	
				detalleliquidacionimpuestoimpor.setid_sucursal(-1L);	
				detalleliquidacionimpuestoimpor.setcantidad(0);	
				detalleliquidacionimpuestoimpor.setvalor(0.0);	
				detalleliquidacionimpuestoimpor.setfob(0.0);	
				detalleliquidacionimpuestoimpor.setporcentaje_iva(0.0);	
				detalleliquidacionimpuestoimpor.setporcentaje_arancel(0.0);	
				detalleliquidacionimpuestoimpor.setporcentaje_aplicar(0.0);	
				detalleliquidacionimpuestoimpor.setflete(0.0);	
				detalleliquidacionimpuestoimpor.setseguro(0.0);	
				detalleliquidacionimpuestoimpor.setbase_imponible(0.0);	
				detalleliquidacionimpuestoimpor.setvalor_arancel(0.0);	
				detalleliquidacionimpuestoimpor.setvalor_fodi(0.0);	
				detalleliquidacionimpuestoimpor.setvalor_iva(0.0);	
				detalleliquidacionimpuestoimpor.setnumero_comprobante(0);	
				detalleliquidacionimpuestoimpor.setporcentaje_fodi(0.0);	
				detalleliquidacionimpuestoimpor.setvalor_imponible(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleLiquidacionImpuestoImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDLIQUIDACIONIMPUESTOIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleLiquidacionImpuestoImpor(String sTipo,Row row,Workbook workbook,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getliquidacionimpuestoimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getfob());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getporcentaje_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getporcentaje_arancel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getporcentaje_aplicar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getseguro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getvalor_arancel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getvalor_fodi());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getvalor_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getporcentaje_fodi());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleliquidacionimpuestoimpor.getvalor_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleLiquidacionImpuestoImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleLiquidacionImpuestoImpor() {
		return this.sFinalQueryDetalleLiquidacionImpuestoImpor;
	}
	
	public void setsFinalQueryDetalleLiquidacionImpuestoImpor(String sFinalQueryDetalleLiquidacionImpuestoImpor) {
		this.sFinalQueryDetalleLiquidacionImpuestoImpor= sFinalQueryDetalleLiquidacionImpuestoImpor;
	}
	
	public Border resaltarSeleccionarDetalleLiquidacionImpuestoImpor=null;
	
	public Border setResaltarSeleccionarDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleLiquidacionImpuestoImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleLiquidacionImpuestoImpor() {
		return this.resaltarSeleccionarDetalleLiquidacionImpuestoImpor;
	}
	
	public void setResaltarSeleccionarDetalleLiquidacionImpuestoImpor(Border borderResaltarSeleccionarDetalleLiquidacionImpuestoImpor) {
		this.resaltarSeleccionarDetalleLiquidacionImpuestoImpor= borderResaltarSeleccionarDetalleLiquidacionImpuestoImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostraridDetalleLiquidacionImpuestoImpor=true;
	public Boolean activaridDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor=true;
	public Boolean cargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_empresaDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarid_empresaDetalleLiquidacionImpuestoImpor=true;
	public Boolean cargarid_empresaDetalleLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarid_sucursalDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarid_sucursalDetalleLiquidacionImpuestoImpor=true;
	public Boolean cargarid_sucursalDetalleLiquidacionImpuestoImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleLiquidacionImpuestoImpor=false;//ConEventDepend=true

	public Border resaltarcantidadDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarcantidadDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarcantidadDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarvalorDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarvalorDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarvalorDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarfobDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarfobDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarfobDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_ivaDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_arancelDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_aplicarDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarfleteDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarfleteDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarfleteDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarseguroDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarseguroDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarseguroDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarbase_imponibleDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarbase_imponibleDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarbase_imponibleDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarvalor_arancelDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarvalor_arancelDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarvalor_arancelDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarvalor_fodiDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarvalor_fodiDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarvalor_fodiDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarvalor_ivaDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarvalor_ivaDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarvalor_ivaDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarnumero_comprobanteDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarporcentaje_fodiDetalleLiquidacionImpuestoImpor=true;

	public Border resaltarvalor_imponibleDetalleLiquidacionImpuestoImpor=null;
	public Boolean mostrarvalor_imponibleDetalleLiquidacionImpuestoImpor=true;
	public Boolean activarvalor_imponibleDetalleLiquidacionImpuestoImpor=true;

	
	

	public Border setResaltaridDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltaridDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleLiquidacionImpuestoImpor() {
		return this.resaltaridDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltaridDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltaridDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostraridDetalleLiquidacionImpuestoImpor() {
		return this.mostraridDetalleLiquidacionImpuestoImpor;
	}

	public void setMostraridDetalleLiquidacionImpuestoImpor(Boolean mostraridDetalleLiquidacionImpuestoImpor) {
		this.mostraridDetalleLiquidacionImpuestoImpor= mostraridDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivaridDetalleLiquidacionImpuestoImpor() {
		return this.activaridDetalleLiquidacionImpuestoImpor;
	}

	public void setActivaridDetalleLiquidacionImpuestoImpor(Boolean activaridDetalleLiquidacionImpuestoImpor) {
		this.activaridDetalleLiquidacionImpuestoImpor= activaridDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor() {
		return this.resaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor() {
		return this.mostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(Boolean mostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor) {
		this.mostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor= mostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor() {
		return this.activarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(Boolean activarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor) {
		this.activarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor= activarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor() {
		return this.cargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public void setCargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(Boolean cargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor) {
		this.cargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor= cargarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_empresaDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleLiquidacionImpuestoImpor() {
		return this.resaltarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarid_empresaDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_empresaDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleLiquidacionImpuestoImpor() {
		return this.mostrarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarid_empresaDetalleLiquidacionImpuestoImpor(Boolean mostrarid_empresaDetalleLiquidacionImpuestoImpor) {
		this.mostrarid_empresaDetalleLiquidacionImpuestoImpor= mostrarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_empresaDetalleLiquidacionImpuestoImpor() {
		return this.activarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarid_empresaDetalleLiquidacionImpuestoImpor(Boolean activarid_empresaDetalleLiquidacionImpuestoImpor) {
		this.activarid_empresaDetalleLiquidacionImpuestoImpor= activarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_empresaDetalleLiquidacionImpuestoImpor() {
		return this.cargarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public void setCargarid_empresaDetalleLiquidacionImpuestoImpor(Boolean cargarid_empresaDetalleLiquidacionImpuestoImpor) {
		this.cargarid_empresaDetalleLiquidacionImpuestoImpor= cargarid_empresaDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarid_sucursalDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleLiquidacionImpuestoImpor() {
		return this.resaltarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarid_sucursalDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarid_sucursalDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleLiquidacionImpuestoImpor() {
		return this.mostrarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarid_sucursalDetalleLiquidacionImpuestoImpor(Boolean mostrarid_sucursalDetalleLiquidacionImpuestoImpor) {
		this.mostrarid_sucursalDetalleLiquidacionImpuestoImpor= mostrarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarid_sucursalDetalleLiquidacionImpuestoImpor() {
		return this.activarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarid_sucursalDetalleLiquidacionImpuestoImpor(Boolean activarid_sucursalDetalleLiquidacionImpuestoImpor) {
		this.activarid_sucursalDetalleLiquidacionImpuestoImpor= activarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getCargarid_sucursalDetalleLiquidacionImpuestoImpor() {
		return this.cargarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setCargarid_sucursalDetalleLiquidacionImpuestoImpor(Boolean cargarid_sucursalDetalleLiquidacionImpuestoImpor) {
		this.cargarid_sucursalDetalleLiquidacionImpuestoImpor= cargarid_sucursalDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarcantidadDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleLiquidacionImpuestoImpor() {
		return this.resaltarcantidadDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarcantidadDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarcantidadDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleLiquidacionImpuestoImpor() {
		return this.mostrarcantidadDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarcantidadDetalleLiquidacionImpuestoImpor(Boolean mostrarcantidadDetalleLiquidacionImpuestoImpor) {
		this.mostrarcantidadDetalleLiquidacionImpuestoImpor= mostrarcantidadDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarcantidadDetalleLiquidacionImpuestoImpor() {
		return this.activarcantidadDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarcantidadDetalleLiquidacionImpuestoImpor(Boolean activarcantidadDetalleLiquidacionImpuestoImpor) {
		this.activarcantidadDetalleLiquidacionImpuestoImpor= activarcantidadDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarvalorDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleLiquidacionImpuestoImpor() {
		return this.resaltarvalorDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarvalorDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarvalorDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleLiquidacionImpuestoImpor() {
		return this.mostrarvalorDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarvalorDetalleLiquidacionImpuestoImpor(Boolean mostrarvalorDetalleLiquidacionImpuestoImpor) {
		this.mostrarvalorDetalleLiquidacionImpuestoImpor= mostrarvalorDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarvalorDetalleLiquidacionImpuestoImpor() {
		return this.activarvalorDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarvalorDetalleLiquidacionImpuestoImpor(Boolean activarvalorDetalleLiquidacionImpuestoImpor) {
		this.activarvalorDetalleLiquidacionImpuestoImpor= activarvalorDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarfobDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfobDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfobDetalleLiquidacionImpuestoImpor() {
		return this.resaltarfobDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarfobDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfobDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfobDetalleLiquidacionImpuestoImpor() {
		return this.mostrarfobDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarfobDetalleLiquidacionImpuestoImpor(Boolean mostrarfobDetalleLiquidacionImpuestoImpor) {
		this.mostrarfobDetalleLiquidacionImpuestoImpor= mostrarfobDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfobDetalleLiquidacionImpuestoImpor() {
		return this.activarfobDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarfobDetalleLiquidacionImpuestoImpor(Boolean activarfobDetalleLiquidacionImpuestoImpor) {
		this.activarfobDetalleLiquidacionImpuestoImpor= activarfobDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor(Boolean mostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor= mostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_ivaDetalleLiquidacionImpuestoImpor() {
		return this.activarporcentaje_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_ivaDetalleLiquidacionImpuestoImpor(Boolean activarporcentaje_ivaDetalleLiquidacionImpuestoImpor) {
		this.activarporcentaje_ivaDetalleLiquidacionImpuestoImpor= activarporcentaje_ivaDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor(Boolean mostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor= mostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_arancelDetalleLiquidacionImpuestoImpor() {
		return this.activarporcentaje_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_arancelDetalleLiquidacionImpuestoImpor(Boolean activarporcentaje_arancelDetalleLiquidacionImpuestoImpor) {
		this.activarporcentaje_arancelDetalleLiquidacionImpuestoImpor= activarporcentaje_arancelDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(Boolean mostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor= mostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_aplicarDetalleLiquidacionImpuestoImpor() {
		return this.activarporcentaje_aplicarDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(Boolean activarporcentaje_aplicarDetalleLiquidacionImpuestoImpor) {
		this.activarporcentaje_aplicarDetalleLiquidacionImpuestoImpor= activarporcentaje_aplicarDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarfleteDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarfleteDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteDetalleLiquidacionImpuestoImpor() {
		return this.resaltarfleteDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarfleteDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarfleteDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarfleteDetalleLiquidacionImpuestoImpor() {
		return this.mostrarfleteDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarfleteDetalleLiquidacionImpuestoImpor(Boolean mostrarfleteDetalleLiquidacionImpuestoImpor) {
		this.mostrarfleteDetalleLiquidacionImpuestoImpor= mostrarfleteDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarfleteDetalleLiquidacionImpuestoImpor() {
		return this.activarfleteDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarfleteDetalleLiquidacionImpuestoImpor(Boolean activarfleteDetalleLiquidacionImpuestoImpor) {
		this.activarfleteDetalleLiquidacionImpuestoImpor= activarfleteDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarseguroDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarseguroDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarseguroDetalleLiquidacionImpuestoImpor() {
		return this.resaltarseguroDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarseguroDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarseguroDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarseguroDetalleLiquidacionImpuestoImpor() {
		return this.mostrarseguroDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarseguroDetalleLiquidacionImpuestoImpor(Boolean mostrarseguroDetalleLiquidacionImpuestoImpor) {
		this.mostrarseguroDetalleLiquidacionImpuestoImpor= mostrarseguroDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarseguroDetalleLiquidacionImpuestoImpor() {
		return this.activarseguroDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarseguroDetalleLiquidacionImpuestoImpor(Boolean activarseguroDetalleLiquidacionImpuestoImpor) {
		this.activarseguroDetalleLiquidacionImpuestoImpor= activarseguroDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarbase_imponibleDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.resaltarbase_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarbase_imponibleDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarbase_imponibleDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.mostrarbase_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarbase_imponibleDetalleLiquidacionImpuestoImpor(Boolean mostrarbase_imponibleDetalleLiquidacionImpuestoImpor) {
		this.mostrarbase_imponibleDetalleLiquidacionImpuestoImpor= mostrarbase_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarbase_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.activarbase_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarbase_imponibleDetalleLiquidacionImpuestoImpor(Boolean activarbase_imponibleDetalleLiquidacionImpuestoImpor) {
		this.activarbase_imponibleDetalleLiquidacionImpuestoImpor= activarbase_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarvalor_arancelDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarvalor_arancelDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_arancelDetalleLiquidacionImpuestoImpor() {
		return this.resaltarvalor_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarvalor_arancelDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarvalor_arancelDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarvalor_arancelDetalleLiquidacionImpuestoImpor() {
		return this.mostrarvalor_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarvalor_arancelDetalleLiquidacionImpuestoImpor(Boolean mostrarvalor_arancelDetalleLiquidacionImpuestoImpor) {
		this.mostrarvalor_arancelDetalleLiquidacionImpuestoImpor= mostrarvalor_arancelDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarvalor_arancelDetalleLiquidacionImpuestoImpor() {
		return this.activarvalor_arancelDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarvalor_arancelDetalleLiquidacionImpuestoImpor(Boolean activarvalor_arancelDetalleLiquidacionImpuestoImpor) {
		this.activarvalor_arancelDetalleLiquidacionImpuestoImpor= activarvalor_arancelDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarvalor_fodiDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarvalor_fodiDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_fodiDetalleLiquidacionImpuestoImpor() {
		return this.resaltarvalor_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarvalor_fodiDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarvalor_fodiDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarvalor_fodiDetalleLiquidacionImpuestoImpor() {
		return this.mostrarvalor_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarvalor_fodiDetalleLiquidacionImpuestoImpor(Boolean mostrarvalor_fodiDetalleLiquidacionImpuestoImpor) {
		this.mostrarvalor_fodiDetalleLiquidacionImpuestoImpor= mostrarvalor_fodiDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarvalor_fodiDetalleLiquidacionImpuestoImpor() {
		return this.activarvalor_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarvalor_fodiDetalleLiquidacionImpuestoImpor(Boolean activarvalor_fodiDetalleLiquidacionImpuestoImpor) {
		this.activarvalor_fodiDetalleLiquidacionImpuestoImpor= activarvalor_fodiDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarvalor_ivaDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarvalor_ivaDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ivaDetalleLiquidacionImpuestoImpor() {
		return this.resaltarvalor_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarvalor_ivaDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarvalor_ivaDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarvalor_ivaDetalleLiquidacionImpuestoImpor() {
		return this.mostrarvalor_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarvalor_ivaDetalleLiquidacionImpuestoImpor(Boolean mostrarvalor_ivaDetalleLiquidacionImpuestoImpor) {
		this.mostrarvalor_ivaDetalleLiquidacionImpuestoImpor= mostrarvalor_ivaDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarvalor_ivaDetalleLiquidacionImpuestoImpor() {
		return this.activarvalor_ivaDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarvalor_ivaDetalleLiquidacionImpuestoImpor(Boolean activarvalor_ivaDetalleLiquidacionImpuestoImpor) {
		this.activarvalor_ivaDetalleLiquidacionImpuestoImpor= activarvalor_ivaDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor() {
		return this.resaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor() {
		return this.mostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor(Boolean mostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor) {
		this.mostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor= mostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarnumero_comprobanteDetalleLiquidacionImpuestoImpor() {
		return this.activarnumero_comprobanteDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarnumero_comprobanteDetalleLiquidacionImpuestoImpor(Boolean activarnumero_comprobanteDetalleLiquidacionImpuestoImpor) {
		this.activarnumero_comprobanteDetalleLiquidacionImpuestoImpor= activarnumero_comprobanteDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor() {
		return this.resaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor() {
		return this.mostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor(Boolean mostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor) {
		this.mostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor= mostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarporcentaje_fodiDetalleLiquidacionImpuestoImpor() {
		return this.activarporcentaje_fodiDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarporcentaje_fodiDetalleLiquidacionImpuestoImpor(Boolean activarporcentaje_fodiDetalleLiquidacionImpuestoImpor) {
		this.activarporcentaje_fodiDetalleLiquidacionImpuestoImpor= activarporcentaje_fodiDetalleLiquidacionImpuestoImpor;
	}

	public Border setResaltarvalor_imponibleDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleliquidacionimpuestoimporBeanSwingJInternalFrame.jTtoolBarDetalleLiquidacionImpuestoImpor.setBorder(borderResaltar);
		
		this.resaltarvalor_imponibleDetalleLiquidacionImpuestoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.resaltarvalor_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarvalor_imponibleDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarvalor_imponibleDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Boolean getMostrarvalor_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.mostrarvalor_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarvalor_imponibleDetalleLiquidacionImpuestoImpor(Boolean mostrarvalor_imponibleDetalleLiquidacionImpuestoImpor) {
		this.mostrarvalor_imponibleDetalleLiquidacionImpuestoImpor= mostrarvalor_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public Boolean getActivarvalor_imponibleDetalleLiquidacionImpuestoImpor() {
		return this.activarvalor_imponibleDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarvalor_imponibleDetalleLiquidacionImpuestoImpor(Boolean activarvalor_imponibleDetalleLiquidacionImpuestoImpor) {
		this.activarvalor_imponibleDetalleLiquidacionImpuestoImpor= activarvalor_imponibleDetalleLiquidacionImpuestoImpor;
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
		
		
		this.setMostraridDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_empresaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarid_sucursalDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarcantidadDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarvalorDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfobDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarfleteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarseguroDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarbase_imponibleDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarvalor_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarvalor_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarvalor_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setMostrarvalor_imponibleDetalleLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setMostraridDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR)) {
				this.setMostrarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setMostrarfobDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setMostrarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setMostrarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR)) {
				this.setMostrarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setMostrarfleteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setMostrarseguroDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL)) {
				this.setMostrarvalor_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI)) {
				this.setMostrarvalor_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA)) {
				this.setMostrarvalor_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setMostrarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE)) {
				this.setMostrarvalor_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
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
		
		
		this.setActivaridDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_empresaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarid_sucursalDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarcantidadDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarvalorDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarfobDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarfleteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarseguroDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarbase_imponibleDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarvalor_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarvalor_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarvalor_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setActivarvalor_imponibleDetalleLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setActivaridDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR)) {
				this.setActivarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setActivarfobDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setActivarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setActivarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR)) {
				this.setActivarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setActivarfleteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setActivarseguroDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL)) {
				this.setActivarvalor_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI)) {
				this.setActivarvalor_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA)) {
				this.setActivarvalor_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setActivarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE)) {
				this.setActivarvalor_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_empresaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarid_sucursalDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarcantidadDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarvalorDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfobDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarfleteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarseguroDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarbase_imponibleDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarvalor_arancelDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarvalor_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarvalor_ivaDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esInicial);
		this.setResaltarvalor_imponibleDetalleLiquidacionImpuestoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.ID)) {
				this.setResaltaridDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR)) {
				this.setResaltarid_liquidacion_impuesto_imporDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB)) {
				this.setResaltarfobDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA)) {
				this.setResaltarporcentaje_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setResaltarporcentaje_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR)) {
				this.setResaltarporcentaje_aplicarDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE)) {
				this.setResaltarfleteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO)) {
				this.setResaltarseguroDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL)) {
				this.setResaltarvalor_arancelDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI)) {
				this.setResaltarvalor_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA)) {
				this.setResaltarvalor_ivaDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI)) {
				this.setResaltarporcentaje_fodiDetalleLiquidacionImpuestoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE)) {
				this.setResaltarvalor_imponibleDetalleLiquidacionImpuestoImpor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaDetalleLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdEmpresaDetalleLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdEmpresaDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdEmpresaDetalleLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleLiquidacionImpuestoImpor=true;

	public Boolean getMostrarFK_IdSucursalDetalleLiquidacionImpuestoImpor() {
		return this.mostrarFK_IdSucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setMostrarFK_IdSucursalDetalleLiquidacionImpuestoImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleLiquidacionImpuestoImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaDetalleLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdEmpresaDetalleLiquidacionImpuestoImpor() {
		return this.activarFK_IdEmpresaDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdEmpresaDetalleLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor() {
		return this.activarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleLiquidacionImpuestoImpor=true;

	public Boolean getActivarFK_IdSucursalDetalleLiquidacionImpuestoImpor() {
		return this.activarFK_IdSucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setActivarFK_IdSucursalDetalleLiquidacionImpuestoImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleLiquidacionImpuestoImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLiquidacionImpuestoImporDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor=null;

	public Border getResaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor() {
		return this.resaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor;
	}

	public void setResaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleLiquidacionImpuestoImporBeanSwingJInternalFrame detalleliquidacionimpuestoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleLiquidacionImpuestoImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}