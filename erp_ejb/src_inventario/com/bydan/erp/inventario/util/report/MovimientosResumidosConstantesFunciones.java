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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.MovimientosResumidosConstantesFunciones;
import com.bydan.erp.inventario.util.report.MovimientosResumidosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.MovimientosResumidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MovimientosResumidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="MovimientosResumidos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MovimientosResumidos"+MovimientosResumidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MovimientosResumidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MovimientosResumidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MovimientosResumidosConstantesFunciones.SCHEMA+"_"+MovimientosResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MovimientosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MovimientosResumidosConstantesFunciones.SCHEMA+"_"+MovimientosResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MovimientosResumidosConstantesFunciones.SCHEMA+"_"+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MovimientosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MovimientosResumidosConstantesFunciones.SCHEMA+"_"+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MovimientosResumidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MovimientosResumidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MovimientosResumidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MovimientosResumidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Movimientos Resumidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Movimientos Resumidos";
	public static final String SCLASSWEBTITULO_LOWER="Movimientos Resumidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MovimientosResumidos";
	public static final String OBJECTNAME="movimientosresumidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="movimientos_resumidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select movimientosresumidos from "+MovimientosResumidosConstantesFunciones.SPERSISTENCENAME+" movimientosresumidos";
	public static String QUERYSELECTNATIVE="select "+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".id,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".version_row,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".id_empresa,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".id_transaccion,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".nombre_sucursal,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".nombre_transaccion,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".numero_comprobante,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".numero_factura,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".total,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".iva,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".numero_secuencial,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".fecha_emision,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".total_descuento,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".ice,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".retencion,"+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME+".total_otro from "+MovimientosResumidosConstantesFunciones.SCHEMA+"."+MovimientosResumidosConstantesFunciones.TABLENAME;//+" as "+MovimientosResumidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String TOTAL= "total";
    public static final String IVA= "iva";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String ICE= "ice";
    public static final String RETENCION= "retencion";
    public static final String TOTALOTRO= "total_otro";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_NUMEROSECUENCIAL= "Numero Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_TOTALOTRO= "Total Otro";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getMovimientosResumidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.IDTRANSACCION)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.TOTAL)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.IVA)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.FECHAEMISION)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.ICE)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.RETENCION)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(MovimientosResumidosConstantesFunciones.TOTALOTRO)) {sLabelColumna=MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMovimientosResumidosDescripcion(MovimientosResumidos movimientosresumidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(movimientosresumidos !=null/* && movimientosresumidos.getId()!=0*/) {
			if(movimientosresumidos.getId()!=null) {
				sDescripcion=movimientosresumidos.getId().toString();
			}//movimientosresumidosmovimientosresumidos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMovimientosResumidosDescripcionDetallado(MovimientosResumidos movimientosresumidos) {
		String sDescripcion="";
			
		sDescripcion+=MovimientosResumidosConstantesFunciones.ID+"=";
		sDescripcion+=movimientosresumidos.getId().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=movimientosresumidos.getVersionRow().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=movimientosresumidos.getid_empresa().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=movimientosresumidos.getid_sucursal().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=movimientosresumidos.getid_transaccion().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=movimientosresumidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=movimientosresumidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=movimientosresumidos.getnombre_sucursal()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=movimientosresumidos.getnombre_completo_cliente()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=movimientosresumidos.getnombre_transaccion()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=movimientosresumidos.getnumero_comprobante()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=movimientosresumidos.getnumero_factura()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.TOTAL+"=";
		sDescripcion+=movimientosresumidos.gettotal().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.IVA+"=";
		sDescripcion+=movimientosresumidos.getiva().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=movimientosresumidos.getnumero_secuencial()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=movimientosresumidos.getfecha_emision().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=movimientosresumidos.gettotal_descuento().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.ICE+"=";
		sDescripcion+=movimientosresumidos.getice().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.RETENCION+"=";
		sDescripcion+=movimientosresumidos.getretencion().toString()+",";
		sDescripcion+=MovimientosResumidosConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=movimientosresumidos.gettotal_otro().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMovimientosResumidosDescripcion(MovimientosResumidos movimientosresumidos,String sValor) throws Exception {			
		if(movimientosresumidos !=null) {
			//movimientosresumidosmovimientosresumidos.getId().toString();
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaMovimientosResumidos")) {
			sNombreIndice="Tipo=  Por Transaccion Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaMovimientosResumidos(Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMovimientosResumidos(MovimientosResumidos movimientosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientosresumidos.setnombre_sucursal(movimientosresumidos.getnombre_sucursal().trim());
		movimientosresumidos.setnombre_completo_cliente(movimientosresumidos.getnombre_completo_cliente().trim());
		movimientosresumidos.setnombre_transaccion(movimientosresumidos.getnombre_transaccion().trim());
		movimientosresumidos.setnumero_comprobante(movimientosresumidos.getnumero_comprobante().trim());
		movimientosresumidos.setnumero_factura(movimientosresumidos.getnumero_factura().trim());
		movimientosresumidos.setnumero_secuencial(movimientosresumidos.getnumero_secuencial().trim());
	}
	
	public static void quitarEspaciosMovimientosResumidoss(List<MovimientosResumidos> movimientosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {
			movimientosresumidos.setnombre_sucursal(movimientosresumidos.getnombre_sucursal().trim());
			movimientosresumidos.setnombre_completo_cliente(movimientosresumidos.getnombre_completo_cliente().trim());
			movimientosresumidos.setnombre_transaccion(movimientosresumidos.getnombre_transaccion().trim());
			movimientosresumidos.setnumero_comprobante(movimientosresumidos.getnumero_comprobante().trim());
			movimientosresumidos.setnumero_factura(movimientosresumidos.getnumero_factura().trim());
			movimientosresumidos.setnumero_secuencial(movimientosresumidos.getnumero_secuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientosResumidos(MovimientosResumidos movimientosresumidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && movimientosresumidos.getConCambioAuxiliar()) {
			movimientosresumidos.setIsDeleted(movimientosresumidos.getIsDeletedAuxiliar());	
			movimientosresumidos.setIsNew(movimientosresumidos.getIsNewAuxiliar());	
			movimientosresumidos.setIsChanged(movimientosresumidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			movimientosresumidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			movimientosresumidos.setIsDeletedAuxiliar(false);	
			movimientosresumidos.setIsNewAuxiliar(false);	
			movimientosresumidos.setIsChangedAuxiliar(false);
			
			movimientosresumidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientosResumidoss(List<MovimientosResumidos> movimientosresumidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MovimientosResumidos movimientosresumidos : movimientosresumidoss) {
			if(conAsignarBase && movimientosresumidos.getConCambioAuxiliar()) {
				movimientosresumidos.setIsDeleted(movimientosresumidos.getIsDeletedAuxiliar());	
				movimientosresumidos.setIsNew(movimientosresumidos.getIsNewAuxiliar());	
				movimientosresumidos.setIsChanged(movimientosresumidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				movimientosresumidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				movimientosresumidos.setIsDeletedAuxiliar(false);	
				movimientosresumidos.setIsNewAuxiliar(false);	
				movimientosresumidos.setIsChangedAuxiliar(false);
				
				movimientosresumidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMovimientosResumidos(MovimientosResumidos movimientosresumidos,Boolean conEnteros) throws Exception  {
		movimientosresumidos.settotal(0.0);
		movimientosresumidos.setiva(0.0);
		movimientosresumidos.settotal_descuento(0.0);
		movimientosresumidos.setice(0.0);
		movimientosresumidos.setretencion(0.0);
		movimientosresumidos.settotal_otro(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMovimientosResumidoss(List<MovimientosResumidos> movimientosresumidoss,Boolean conEnteros) throws Exception  {
		
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {
			movimientosresumidos.settotal(0.0);
			movimientosresumidos.setiva(0.0);
			movimientosresumidos.settotal_descuento(0.0);
			movimientosresumidos.setice(0.0);
			movimientosresumidos.setretencion(0.0);
			movimientosresumidos.settotal_otro(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMovimientosResumidos(List<MovimientosResumidos> movimientosresumidoss,MovimientosResumidos movimientosresumidosAux) throws Exception  {
		MovimientosResumidosConstantesFunciones.InicializarValoresMovimientosResumidos(movimientosresumidosAux,true);
		
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {
			if(movimientosresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			movimientosresumidosAux.settotal(movimientosresumidosAux.gettotal()+movimientosresumidos.gettotal());			
			movimientosresumidosAux.setiva(movimientosresumidosAux.getiva()+movimientosresumidos.getiva());			
			movimientosresumidosAux.settotal_descuento(movimientosresumidosAux.gettotal_descuento()+movimientosresumidos.gettotal_descuento());			
			movimientosresumidosAux.setice(movimientosresumidosAux.getice()+movimientosresumidos.getice());			
			movimientosresumidosAux.setretencion(movimientosresumidosAux.getretencion()+movimientosresumidos.getretencion());			
			movimientosresumidosAux.settotal_otro(movimientosresumidosAux.gettotal_otro()+movimientosresumidos.gettotal_otro());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MovimientosResumidosConstantesFunciones.getArrayColumnasGlobalesMovimientosResumidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosResumidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientosResumidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientosResumidosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientosResumidosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientosResumidosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMovimientosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientosResumidos> movimientosresumidoss,MovimientosResumidos movimientosresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientosResumidos movimientosresumidosAux: movimientosresumidoss) {
			if(movimientosresumidosAux!=null && movimientosresumidos!=null) {
				if((movimientosresumidosAux.getId()==null && movimientosresumidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(movimientosresumidosAux.getId()!=null && movimientosresumidos.getId()!=null){
					if(movimientosresumidosAux.getId().equals(movimientosresumidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientosResumidos(List<MovimientosResumidos> movimientosresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double iceTotal=0.0;
		Double retencionTotal=0.0;
		Double total_otroTotal=0.0;
	
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {			
			if(movimientosresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=movimientosresumidos.gettotal();
			ivaTotal+=movimientosresumidos.getiva();
			total_descuentoTotal+=movimientosresumidos.gettotal_descuento();
			iceTotal+=movimientosresumidos.getice();
			retencionTotal+=movimientosresumidos.getretencion();
			total_otroTotal+=movimientosresumidos.gettotal_otro();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMovimientosResumidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_ID, MovimientosResumidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_VERSIONROW, MovimientosResumidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NOMBRESUCURSAL, MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION, MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NUMEROCOMPROBANTE, MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NUMEROFACTURA, MovimientosResumidosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_TOTAL, MovimientosResumidosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_IVA, MovimientosResumidosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_NUMEROSECUENCIAL, MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISION, MovimientosResumidosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO, MovimientosResumidosConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_ICE, MovimientosResumidosConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_RETENCION, MovimientosResumidosConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO, MovimientosResumidosConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMovimientosResumidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosResumidosConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosResumidos() throws Exception  {
		return MovimientosResumidosConstantesFunciones.getTiposSeleccionarMovimientosResumidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosResumidos(Boolean conFk) throws Exception  {
		return MovimientosResumidosConstantesFunciones.getTiposSeleccionarMovimientosResumidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosResumidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMovimientosResumidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientosResumidos(MovimientosResumidos movimientosresumidosAux) throws Exception {
		
			movimientosresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientosresumidosAux.getEmpresa()));
			movimientosresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientosresumidosAux.getSucursal()));
			movimientosresumidosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientosresumidosAux.getTransaccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientosResumidos(List<MovimientosResumidos> movimientosresumidossTemp) throws Exception {
		for(MovimientosResumidos movimientosresumidosAux:movimientosresumidossTemp) {
			
			movimientosresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientosresumidosAux.getEmpresa()));
			movimientosresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientosresumidosAux.getSucursal()));
			movimientosresumidosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientosresumidosAux.getTransaccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Transaccion.class));
				
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMovimientosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientosResumidosConstantesFunciones.getClassesRelationshipsOfMovimientosResumidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientosResumidosConstantesFunciones.getClassesRelationshipsFromStringsOfMovimientosResumidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MovimientosResumidos movimientosresumidos,List<MovimientosResumidos> movimientosresumidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(MovimientosResumidos movimientosresumidos,List<MovimientosResumidos> movimientosresumidoss) throws Exception {
		try	{			
			for(MovimientosResumidos movimientosresumidosLocal:movimientosresumidoss) {
				if(movimientosresumidosLocal.getId().equals(movimientosresumidos.getId())) {
					movimientosresumidosLocal.setIsSelected(movimientosresumidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMovimientosResumidos(List<MovimientosResumidos> movimientosresumidossAux) throws Exception {
		//this.movimientosresumidossAux=movimientosresumidossAux;
		
		for(MovimientosResumidos movimientosresumidosAux:movimientosresumidossAux) {
			if(movimientosresumidosAux.getIsChanged()) {
				movimientosresumidosAux.setIsChanged(false);
			}		
			
			if(movimientosresumidosAux.getIsNew()) {
				movimientosresumidosAux.setIsNew(false);
			}	
			
			if(movimientosresumidosAux.getIsDeleted()) {
				movimientosresumidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMovimientosResumidos(MovimientosResumidos movimientosresumidosAux) throws Exception {
		//this.movimientosresumidosAux=movimientosresumidosAux;
		
			if(movimientosresumidosAux.getIsChanged()) {
				movimientosresumidosAux.setIsChanged(false);
			}		
			
			if(movimientosresumidosAux.getIsNew()) {
				movimientosresumidosAux.setIsNew(false);
			}	
			
			if(movimientosresumidosAux.getIsDeleted()) {
				movimientosresumidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MovimientosResumidos movimientosresumidosAsignar,MovimientosResumidos movimientosresumidos) throws Exception {
		movimientosresumidosAsignar.setId(movimientosresumidos.getId());	
		movimientosresumidosAsignar.setVersionRow(movimientosresumidos.getVersionRow());	
		movimientosresumidosAsignar.setnombre_sucursal(movimientosresumidos.getnombre_sucursal());	
		movimientosresumidosAsignar.setnombre_completo_cliente(movimientosresumidos.getnombre_completo_cliente());	
		movimientosresumidosAsignar.setnombre_transaccion(movimientosresumidos.getnombre_transaccion());	
		movimientosresumidosAsignar.setnumero_comprobante(movimientosresumidos.getnumero_comprobante());	
		movimientosresumidosAsignar.setnumero_factura(movimientosresumidos.getnumero_factura());	
		movimientosresumidosAsignar.settotal(movimientosresumidos.gettotal());	
		movimientosresumidosAsignar.setiva(movimientosresumidos.getiva());	
		movimientosresumidosAsignar.setnumero_secuencial(movimientosresumidos.getnumero_secuencial());	
		movimientosresumidosAsignar.setfecha_emision(movimientosresumidos.getfecha_emision());	
		movimientosresumidosAsignar.settotal_descuento(movimientosresumidos.gettotal_descuento());	
		movimientosresumidosAsignar.setice(movimientosresumidos.getice());	
		movimientosresumidosAsignar.setretencion(movimientosresumidos.getretencion());	
		movimientosresumidosAsignar.settotal_otro(movimientosresumidos.gettotal_otro());	
	}
	
	public static void inicializarMovimientosResumidos(MovimientosResumidos movimientosresumidos) throws Exception {
		try {
				movimientosresumidos.setId(0L);	
					
				movimientosresumidos.setnombre_sucursal("");	
				movimientosresumidos.setnombre_completo_cliente("");	
				movimientosresumidos.setnombre_transaccion("");	
				movimientosresumidos.setnumero_comprobante("");	
				movimientosresumidos.setnumero_factura("");	
				movimientosresumidos.settotal(0.0);	
				movimientosresumidos.setiva(0.0);	
				movimientosresumidos.setnumero_secuencial("");	
				movimientosresumidos.setfecha_emision(new Date());	
				movimientosresumidos.settotal_descuento(0.0);	
				movimientosresumidos.setice(0.0);	
				movimientosresumidos.setretencion(0.0);	
				movimientosresumidos.settotal_otro(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMovimientosResumidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMovimientosResumidos(String sTipo,Row row,Workbook workbook,MovimientosResumidos movimientosresumidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosresumidos.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMovimientosResumidos="";
	
	public String getsFinalQueryMovimientosResumidos() {
		return this.sFinalQueryMovimientosResumidos;
	}
	
	public void setsFinalQueryMovimientosResumidos(String sFinalQueryMovimientosResumidos) {
		this.sFinalQueryMovimientosResumidos= sFinalQueryMovimientosResumidos;
	}
	
	public Border resaltarSeleccionarMovimientosResumidos=null;
	
	public Border setResaltarSeleccionarMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMovimientosResumidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMovimientosResumidos() {
		return this.resaltarSeleccionarMovimientosResumidos;
	}
	
	public void setResaltarSeleccionarMovimientosResumidos(Border borderResaltarSeleccionarMovimientosResumidos) {
		this.resaltarSeleccionarMovimientosResumidos= borderResaltarSeleccionarMovimientosResumidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMovimientosResumidos=null;
	public Boolean mostraridMovimientosResumidos=true;
	public Boolean activaridMovimientosResumidos=true;

	public Border resaltarid_empresaMovimientosResumidos=null;
	public Boolean mostrarid_empresaMovimientosResumidos=true;
	public Boolean activarid_empresaMovimientosResumidos=true;
	public Boolean cargarid_empresaMovimientosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMovimientosResumidos=false;//ConEventDepend=true

	public Border resaltarid_sucursalMovimientosResumidos=null;
	public Boolean mostrarid_sucursalMovimientosResumidos=true;
	public Boolean activarid_sucursalMovimientosResumidos=true;
	public Boolean cargarid_sucursalMovimientosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMovimientosResumidos=false;//ConEventDepend=true

	public Border resaltarid_transaccionMovimientosResumidos=null;
	public Boolean mostrarid_transaccionMovimientosResumidos=true;
	public Boolean activarid_transaccionMovimientosResumidos=true;
	public Boolean cargarid_transaccionMovimientosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionMovimientosResumidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeMovimientosResumidos=null;
	public Boolean mostrarfecha_emision_desdeMovimientosResumidos=true;
	public Boolean activarfecha_emision_desdeMovimientosResumidos=true;

	public Border resaltarfecha_emision_hastaMovimientosResumidos=null;
	public Boolean mostrarfecha_emision_hastaMovimientosResumidos=true;
	public Boolean activarfecha_emision_hastaMovimientosResumidos=true;

	public Border resaltarnombre_sucursalMovimientosResumidos=null;
	public Boolean mostrarnombre_sucursalMovimientosResumidos=true;
	public Boolean activarnombre_sucursalMovimientosResumidos=true;

	public Border resaltarnombre_completo_clienteMovimientosResumidos=null;
	public Boolean mostrarnombre_completo_clienteMovimientosResumidos=true;
	public Boolean activarnombre_completo_clienteMovimientosResumidos=true;

	public Border resaltarnombre_transaccionMovimientosResumidos=null;
	public Boolean mostrarnombre_transaccionMovimientosResumidos=true;
	public Boolean activarnombre_transaccionMovimientosResumidos=true;

	public Border resaltarnumero_comprobanteMovimientosResumidos=null;
	public Boolean mostrarnumero_comprobanteMovimientosResumidos=true;
	public Boolean activarnumero_comprobanteMovimientosResumidos=true;

	public Border resaltarnumero_facturaMovimientosResumidos=null;
	public Boolean mostrarnumero_facturaMovimientosResumidos=true;
	public Boolean activarnumero_facturaMovimientosResumidos=true;

	public Border resaltartotalMovimientosResumidos=null;
	public Boolean mostrartotalMovimientosResumidos=true;
	public Boolean activartotalMovimientosResumidos=true;

	public Border resaltarivaMovimientosResumidos=null;
	public Boolean mostrarivaMovimientosResumidos=true;
	public Boolean activarivaMovimientosResumidos=true;

	public Border resaltarnumero_secuencialMovimientosResumidos=null;
	public Boolean mostrarnumero_secuencialMovimientosResumidos=true;
	public Boolean activarnumero_secuencialMovimientosResumidos=true;

	public Border resaltarfecha_emisionMovimientosResumidos=null;
	public Boolean mostrarfecha_emisionMovimientosResumidos=true;
	public Boolean activarfecha_emisionMovimientosResumidos=true;

	public Border resaltartotal_descuentoMovimientosResumidos=null;
	public Boolean mostrartotal_descuentoMovimientosResumidos=true;
	public Boolean activartotal_descuentoMovimientosResumidos=true;

	public Border resaltariceMovimientosResumidos=null;
	public Boolean mostrariceMovimientosResumidos=true;
	public Boolean activariceMovimientosResumidos=true;

	public Border resaltarretencionMovimientosResumidos=null;
	public Boolean mostrarretencionMovimientosResumidos=true;
	public Boolean activarretencionMovimientosResumidos=true;

	public Border resaltartotal_otroMovimientosResumidos=null;
	public Boolean mostrartotal_otroMovimientosResumidos=true;
	public Boolean activartotal_otroMovimientosResumidos=true;

	
	

	public Border setResaltaridMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltaridMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMovimientosResumidos() {
		return this.resaltaridMovimientosResumidos;
	}

	public void setResaltaridMovimientosResumidos(Border borderResaltar) {
		this.resaltaridMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostraridMovimientosResumidos() {
		return this.mostraridMovimientosResumidos;
	}

	public void setMostraridMovimientosResumidos(Boolean mostraridMovimientosResumidos) {
		this.mostraridMovimientosResumidos= mostraridMovimientosResumidos;
	}

	public Boolean getActivaridMovimientosResumidos() {
		return this.activaridMovimientosResumidos;
	}

	public void setActivaridMovimientosResumidos(Boolean activaridMovimientosResumidos) {
		this.activaridMovimientosResumidos= activaridMovimientosResumidos;
	}

	public Border setResaltarid_empresaMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMovimientosResumidos() {
		return this.resaltarid_empresaMovimientosResumidos;
	}

	public void setResaltarid_empresaMovimientosResumidos(Border borderResaltar) {
		this.resaltarid_empresaMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaMovimientosResumidos() {
		return this.mostrarid_empresaMovimientosResumidos;
	}

	public void setMostrarid_empresaMovimientosResumidos(Boolean mostrarid_empresaMovimientosResumidos) {
		this.mostrarid_empresaMovimientosResumidos= mostrarid_empresaMovimientosResumidos;
	}

	public Boolean getActivarid_empresaMovimientosResumidos() {
		return this.activarid_empresaMovimientosResumidos;
	}

	public void setActivarid_empresaMovimientosResumidos(Boolean activarid_empresaMovimientosResumidos) {
		this.activarid_empresaMovimientosResumidos= activarid_empresaMovimientosResumidos;
	}

	public Boolean getCargarid_empresaMovimientosResumidos() {
		return this.cargarid_empresaMovimientosResumidos;
	}

	public void setCargarid_empresaMovimientosResumidos(Boolean cargarid_empresaMovimientosResumidos) {
		this.cargarid_empresaMovimientosResumidos= cargarid_empresaMovimientosResumidos;
	}

	public Border setResaltarid_sucursalMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMovimientosResumidos() {
		return this.resaltarid_sucursalMovimientosResumidos;
	}

	public void setResaltarid_sucursalMovimientosResumidos(Border borderResaltar) {
		this.resaltarid_sucursalMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMovimientosResumidos() {
		return this.mostrarid_sucursalMovimientosResumidos;
	}

	public void setMostrarid_sucursalMovimientosResumidos(Boolean mostrarid_sucursalMovimientosResumidos) {
		this.mostrarid_sucursalMovimientosResumidos= mostrarid_sucursalMovimientosResumidos;
	}

	public Boolean getActivarid_sucursalMovimientosResumidos() {
		return this.activarid_sucursalMovimientosResumidos;
	}

	public void setActivarid_sucursalMovimientosResumidos(Boolean activarid_sucursalMovimientosResumidos) {
		this.activarid_sucursalMovimientosResumidos= activarid_sucursalMovimientosResumidos;
	}

	public Boolean getCargarid_sucursalMovimientosResumidos() {
		return this.cargarid_sucursalMovimientosResumidos;
	}

	public void setCargarid_sucursalMovimientosResumidos(Boolean cargarid_sucursalMovimientosResumidos) {
		this.cargarid_sucursalMovimientosResumidos= cargarid_sucursalMovimientosResumidos;
	}

	public Border setResaltarid_transaccionMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_transaccionMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionMovimientosResumidos() {
		return this.resaltarid_transaccionMovimientosResumidos;
	}

	public void setResaltarid_transaccionMovimientosResumidos(Border borderResaltar) {
		this.resaltarid_transaccionMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_transaccionMovimientosResumidos() {
		return this.mostrarid_transaccionMovimientosResumidos;
	}

	public void setMostrarid_transaccionMovimientosResumidos(Boolean mostrarid_transaccionMovimientosResumidos) {
		this.mostrarid_transaccionMovimientosResumidos= mostrarid_transaccionMovimientosResumidos;
	}

	public Boolean getActivarid_transaccionMovimientosResumidos() {
		return this.activarid_transaccionMovimientosResumidos;
	}

	public void setActivarid_transaccionMovimientosResumidos(Boolean activarid_transaccionMovimientosResumidos) {
		this.activarid_transaccionMovimientosResumidos= activarid_transaccionMovimientosResumidos;
	}

	public Boolean getCargarid_transaccionMovimientosResumidos() {
		return this.cargarid_transaccionMovimientosResumidos;
	}

	public void setCargarid_transaccionMovimientosResumidos(Boolean cargarid_transaccionMovimientosResumidos) {
		this.cargarid_transaccionMovimientosResumidos= cargarid_transaccionMovimientosResumidos;
	}

	public Border setResaltarfecha_emision_desdeMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeMovimientosResumidos() {
		return this.resaltarfecha_emision_desdeMovimientosResumidos;
	}

	public void setResaltarfecha_emision_desdeMovimientosResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeMovimientosResumidos() {
		return this.mostrarfecha_emision_desdeMovimientosResumidos;
	}

	public void setMostrarfecha_emision_desdeMovimientosResumidos(Boolean mostrarfecha_emision_desdeMovimientosResumidos) {
		this.mostrarfecha_emision_desdeMovimientosResumidos= mostrarfecha_emision_desdeMovimientosResumidos;
	}

	public Boolean getActivarfecha_emision_desdeMovimientosResumidos() {
		return this.activarfecha_emision_desdeMovimientosResumidos;
	}

	public void setActivarfecha_emision_desdeMovimientosResumidos(Boolean activarfecha_emision_desdeMovimientosResumidos) {
		this.activarfecha_emision_desdeMovimientosResumidos= activarfecha_emision_desdeMovimientosResumidos;
	}

	public Border setResaltarfecha_emision_hastaMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaMovimientosResumidos() {
		return this.resaltarfecha_emision_hastaMovimientosResumidos;
	}

	public void setResaltarfecha_emision_hastaMovimientosResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaMovimientosResumidos() {
		return this.mostrarfecha_emision_hastaMovimientosResumidos;
	}

	public void setMostrarfecha_emision_hastaMovimientosResumidos(Boolean mostrarfecha_emision_hastaMovimientosResumidos) {
		this.mostrarfecha_emision_hastaMovimientosResumidos= mostrarfecha_emision_hastaMovimientosResumidos;
	}

	public Boolean getActivarfecha_emision_hastaMovimientosResumidos() {
		return this.activarfecha_emision_hastaMovimientosResumidos;
	}

	public void setActivarfecha_emision_hastaMovimientosResumidos(Boolean activarfecha_emision_hastaMovimientosResumidos) {
		this.activarfecha_emision_hastaMovimientosResumidos= activarfecha_emision_hastaMovimientosResumidos;
	}

	public Border setResaltarnombre_sucursalMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalMovimientosResumidos() {
		return this.resaltarnombre_sucursalMovimientosResumidos;
	}

	public void setResaltarnombre_sucursalMovimientosResumidos(Border borderResaltar) {
		this.resaltarnombre_sucursalMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalMovimientosResumidos() {
		return this.mostrarnombre_sucursalMovimientosResumidos;
	}

	public void setMostrarnombre_sucursalMovimientosResumidos(Boolean mostrarnombre_sucursalMovimientosResumidos) {
		this.mostrarnombre_sucursalMovimientosResumidos= mostrarnombre_sucursalMovimientosResumidos;
	}

	public Boolean getActivarnombre_sucursalMovimientosResumidos() {
		return this.activarnombre_sucursalMovimientosResumidos;
	}

	public void setActivarnombre_sucursalMovimientosResumidos(Boolean activarnombre_sucursalMovimientosResumidos) {
		this.activarnombre_sucursalMovimientosResumidos= activarnombre_sucursalMovimientosResumidos;
	}

	public Border setResaltarnombre_completo_clienteMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteMovimientosResumidos() {
		return this.resaltarnombre_completo_clienteMovimientosResumidos;
	}

	public void setResaltarnombre_completo_clienteMovimientosResumidos(Border borderResaltar) {
		this.resaltarnombre_completo_clienteMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteMovimientosResumidos() {
		return this.mostrarnombre_completo_clienteMovimientosResumidos;
	}

	public void setMostrarnombre_completo_clienteMovimientosResumidos(Boolean mostrarnombre_completo_clienteMovimientosResumidos) {
		this.mostrarnombre_completo_clienteMovimientosResumidos= mostrarnombre_completo_clienteMovimientosResumidos;
	}

	public Boolean getActivarnombre_completo_clienteMovimientosResumidos() {
		return this.activarnombre_completo_clienteMovimientosResumidos;
	}

	public void setActivarnombre_completo_clienteMovimientosResumidos(Boolean activarnombre_completo_clienteMovimientosResumidos) {
		this.activarnombre_completo_clienteMovimientosResumidos= activarnombre_completo_clienteMovimientosResumidos;
	}

	public Border setResaltarnombre_transaccionMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionMovimientosResumidos() {
		return this.resaltarnombre_transaccionMovimientosResumidos;
	}

	public void setResaltarnombre_transaccionMovimientosResumidos(Border borderResaltar) {
		this.resaltarnombre_transaccionMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionMovimientosResumidos() {
		return this.mostrarnombre_transaccionMovimientosResumidos;
	}

	public void setMostrarnombre_transaccionMovimientosResumidos(Boolean mostrarnombre_transaccionMovimientosResumidos) {
		this.mostrarnombre_transaccionMovimientosResumidos= mostrarnombre_transaccionMovimientosResumidos;
	}

	public Boolean getActivarnombre_transaccionMovimientosResumidos() {
		return this.activarnombre_transaccionMovimientosResumidos;
	}

	public void setActivarnombre_transaccionMovimientosResumidos(Boolean activarnombre_transaccionMovimientosResumidos) {
		this.activarnombre_transaccionMovimientosResumidos= activarnombre_transaccionMovimientosResumidos;
	}

	public Border setResaltarnumero_comprobanteMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteMovimientosResumidos() {
		return this.resaltarnumero_comprobanteMovimientosResumidos;
	}

	public void setResaltarnumero_comprobanteMovimientosResumidos(Border borderResaltar) {
		this.resaltarnumero_comprobanteMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteMovimientosResumidos() {
		return this.mostrarnumero_comprobanteMovimientosResumidos;
	}

	public void setMostrarnumero_comprobanteMovimientosResumidos(Boolean mostrarnumero_comprobanteMovimientosResumidos) {
		this.mostrarnumero_comprobanteMovimientosResumidos= mostrarnumero_comprobanteMovimientosResumidos;
	}

	public Boolean getActivarnumero_comprobanteMovimientosResumidos() {
		return this.activarnumero_comprobanteMovimientosResumidos;
	}

	public void setActivarnumero_comprobanteMovimientosResumidos(Boolean activarnumero_comprobanteMovimientosResumidos) {
		this.activarnumero_comprobanteMovimientosResumidos= activarnumero_comprobanteMovimientosResumidos;
	}

	public Border setResaltarnumero_facturaMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaMovimientosResumidos() {
		return this.resaltarnumero_facturaMovimientosResumidos;
	}

	public void setResaltarnumero_facturaMovimientosResumidos(Border borderResaltar) {
		this.resaltarnumero_facturaMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaMovimientosResumidos() {
		return this.mostrarnumero_facturaMovimientosResumidos;
	}

	public void setMostrarnumero_facturaMovimientosResumidos(Boolean mostrarnumero_facturaMovimientosResumidos) {
		this.mostrarnumero_facturaMovimientosResumidos= mostrarnumero_facturaMovimientosResumidos;
	}

	public Boolean getActivarnumero_facturaMovimientosResumidos() {
		return this.activarnumero_facturaMovimientosResumidos;
	}

	public void setActivarnumero_facturaMovimientosResumidos(Boolean activarnumero_facturaMovimientosResumidos) {
		this.activarnumero_facturaMovimientosResumidos= activarnumero_facturaMovimientosResumidos;
	}

	public Border setResaltartotalMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltartotalMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalMovimientosResumidos() {
		return this.resaltartotalMovimientosResumidos;
	}

	public void setResaltartotalMovimientosResumidos(Border borderResaltar) {
		this.resaltartotalMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrartotalMovimientosResumidos() {
		return this.mostrartotalMovimientosResumidos;
	}

	public void setMostrartotalMovimientosResumidos(Boolean mostrartotalMovimientosResumidos) {
		this.mostrartotalMovimientosResumidos= mostrartotalMovimientosResumidos;
	}

	public Boolean getActivartotalMovimientosResumidos() {
		return this.activartotalMovimientosResumidos;
	}

	public void setActivartotalMovimientosResumidos(Boolean activartotalMovimientosResumidos) {
		this.activartotalMovimientosResumidos= activartotalMovimientosResumidos;
	}

	public Border setResaltarivaMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarivaMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaMovimientosResumidos() {
		return this.resaltarivaMovimientosResumidos;
	}

	public void setResaltarivaMovimientosResumidos(Border borderResaltar) {
		this.resaltarivaMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarivaMovimientosResumidos() {
		return this.mostrarivaMovimientosResumidos;
	}

	public void setMostrarivaMovimientosResumidos(Boolean mostrarivaMovimientosResumidos) {
		this.mostrarivaMovimientosResumidos= mostrarivaMovimientosResumidos;
	}

	public Boolean getActivarivaMovimientosResumidos() {
		return this.activarivaMovimientosResumidos;
	}

	public void setActivarivaMovimientosResumidos(Boolean activarivaMovimientosResumidos) {
		this.activarivaMovimientosResumidos= activarivaMovimientosResumidos;
	}

	public Border setResaltarnumero_secuencialMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialMovimientosResumidos() {
		return this.resaltarnumero_secuencialMovimientosResumidos;
	}

	public void setResaltarnumero_secuencialMovimientosResumidos(Border borderResaltar) {
		this.resaltarnumero_secuencialMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialMovimientosResumidos() {
		return this.mostrarnumero_secuencialMovimientosResumidos;
	}

	public void setMostrarnumero_secuencialMovimientosResumidos(Boolean mostrarnumero_secuencialMovimientosResumidos) {
		this.mostrarnumero_secuencialMovimientosResumidos= mostrarnumero_secuencialMovimientosResumidos;
	}

	public Boolean getActivarnumero_secuencialMovimientosResumidos() {
		return this.activarnumero_secuencialMovimientosResumidos;
	}

	public void setActivarnumero_secuencialMovimientosResumidos(Boolean activarnumero_secuencialMovimientosResumidos) {
		this.activarnumero_secuencialMovimientosResumidos= activarnumero_secuencialMovimientosResumidos;
	}

	public Border setResaltarfecha_emisionMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionMovimientosResumidos() {
		return this.resaltarfecha_emisionMovimientosResumidos;
	}

	public void setResaltarfecha_emisionMovimientosResumidos(Border borderResaltar) {
		this.resaltarfecha_emisionMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionMovimientosResumidos() {
		return this.mostrarfecha_emisionMovimientosResumidos;
	}

	public void setMostrarfecha_emisionMovimientosResumidos(Boolean mostrarfecha_emisionMovimientosResumidos) {
		this.mostrarfecha_emisionMovimientosResumidos= mostrarfecha_emisionMovimientosResumidos;
	}

	public Boolean getActivarfecha_emisionMovimientosResumidos() {
		return this.activarfecha_emisionMovimientosResumidos;
	}

	public void setActivarfecha_emisionMovimientosResumidos(Boolean activarfecha_emisionMovimientosResumidos) {
		this.activarfecha_emisionMovimientosResumidos= activarfecha_emisionMovimientosResumidos;
	}

	public Border setResaltartotal_descuentoMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoMovimientosResumidos() {
		return this.resaltartotal_descuentoMovimientosResumidos;
	}

	public void setResaltartotal_descuentoMovimientosResumidos(Border borderResaltar) {
		this.resaltartotal_descuentoMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoMovimientosResumidos() {
		return this.mostrartotal_descuentoMovimientosResumidos;
	}

	public void setMostrartotal_descuentoMovimientosResumidos(Boolean mostrartotal_descuentoMovimientosResumidos) {
		this.mostrartotal_descuentoMovimientosResumidos= mostrartotal_descuentoMovimientosResumidos;
	}

	public Boolean getActivartotal_descuentoMovimientosResumidos() {
		return this.activartotal_descuentoMovimientosResumidos;
	}

	public void setActivartotal_descuentoMovimientosResumidos(Boolean activartotal_descuentoMovimientosResumidos) {
		this.activartotal_descuentoMovimientosResumidos= activartotal_descuentoMovimientosResumidos;
	}

	public Border setResaltariceMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltariceMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceMovimientosResumidos() {
		return this.resaltariceMovimientosResumidos;
	}

	public void setResaltariceMovimientosResumidos(Border borderResaltar) {
		this.resaltariceMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrariceMovimientosResumidos() {
		return this.mostrariceMovimientosResumidos;
	}

	public void setMostrariceMovimientosResumidos(Boolean mostrariceMovimientosResumidos) {
		this.mostrariceMovimientosResumidos= mostrariceMovimientosResumidos;
	}

	public Boolean getActivariceMovimientosResumidos() {
		return this.activariceMovimientosResumidos;
	}

	public void setActivariceMovimientosResumidos(Boolean activariceMovimientosResumidos) {
		this.activariceMovimientosResumidos= activariceMovimientosResumidos;
	}

	public Border setResaltarretencionMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltarretencionMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionMovimientosResumidos() {
		return this.resaltarretencionMovimientosResumidos;
	}

	public void setResaltarretencionMovimientosResumidos(Border borderResaltar) {
		this.resaltarretencionMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrarretencionMovimientosResumidos() {
		return this.mostrarretencionMovimientosResumidos;
	}

	public void setMostrarretencionMovimientosResumidos(Boolean mostrarretencionMovimientosResumidos) {
		this.mostrarretencionMovimientosResumidos= mostrarretencionMovimientosResumidos;
	}

	public Boolean getActivarretencionMovimientosResumidos() {
		return this.activarretencionMovimientosResumidos;
	}

	public void setActivarretencionMovimientosResumidos(Boolean activarretencionMovimientosResumidos) {
		this.activarretencionMovimientosResumidos= activarretencionMovimientosResumidos;
	}

	public Border setResaltartotal_otroMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosresumidosBeanSwingJInternalFrame.jTtoolBarMovimientosResumidos.setBorder(borderResaltar);
		
		this.resaltartotal_otroMovimientosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroMovimientosResumidos() {
		return this.resaltartotal_otroMovimientosResumidos;
	}

	public void setResaltartotal_otroMovimientosResumidos(Border borderResaltar) {
		this.resaltartotal_otroMovimientosResumidos= borderResaltar;
	}

	public Boolean getMostrartotal_otroMovimientosResumidos() {
		return this.mostrartotal_otroMovimientosResumidos;
	}

	public void setMostrartotal_otroMovimientosResumidos(Boolean mostrartotal_otroMovimientosResumidos) {
		this.mostrartotal_otroMovimientosResumidos= mostrartotal_otroMovimientosResumidos;
	}

	public Boolean getActivartotal_otroMovimientosResumidos() {
		return this.activartotal_otroMovimientosResumidos;
	}

	public void setActivartotal_otroMovimientosResumidos(Boolean activartotal_otroMovimientosResumidos) {
		this.activartotal_otroMovimientosResumidos= activartotal_otroMovimientosResumidos;
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
		
		
		this.setMostraridMovimientosResumidos(esInicial);
		this.setMostrarid_empresaMovimientosResumidos(esInicial);
		this.setMostrarid_sucursalMovimientosResumidos(esInicial);
		this.setMostrarid_transaccionMovimientosResumidos(esInicial);
		this.setMostrarfecha_emision_desdeMovimientosResumidos(esInicial);
		this.setMostrarfecha_emision_hastaMovimientosResumidos(esInicial);
		this.setMostrarnombre_sucursalMovimientosResumidos(esInicial);
		this.setMostrarnombre_completo_clienteMovimientosResumidos(esInicial);
		this.setMostrarnombre_transaccionMovimientosResumidos(esInicial);
		this.setMostrarnumero_comprobanteMovimientosResumidos(esInicial);
		this.setMostrarnumero_facturaMovimientosResumidos(esInicial);
		this.setMostrartotalMovimientosResumidos(esInicial);
		this.setMostrarivaMovimientosResumidos(esInicial);
		this.setMostrarnumero_secuencialMovimientosResumidos(esInicial);
		this.setMostrarfecha_emisionMovimientosResumidos(esInicial);
		this.setMostrartotal_descuentoMovimientosResumidos(esInicial);
		this.setMostrariceMovimientosResumidos(esInicial);
		this.setMostrarretencionMovimientosResumidos(esInicial);
		this.setMostrartotal_otroMovimientosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ID)) {
				this.setMostraridMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTAL)) {
				this.setMostrartotalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IVA)) {
				this.setMostrarivaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ICE)) {
				this.setMostrariceMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.RETENCION)) {
				this.setMostrarretencionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroMovimientosResumidos(esAsigna);
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
		
		
		this.setActivaridMovimientosResumidos(esInicial);
		this.setActivarid_empresaMovimientosResumidos(esInicial);
		this.setActivarid_sucursalMovimientosResumidos(esInicial);
		this.setActivarid_transaccionMovimientosResumidos(esInicial);
		this.setActivarfecha_emision_desdeMovimientosResumidos(esInicial);
		this.setActivarfecha_emision_hastaMovimientosResumidos(esInicial);
		this.setActivarnombre_sucursalMovimientosResumidos(esInicial);
		this.setActivarnombre_completo_clienteMovimientosResumidos(esInicial);
		this.setActivarnombre_transaccionMovimientosResumidos(esInicial);
		this.setActivarnumero_comprobanteMovimientosResumidos(esInicial);
		this.setActivarnumero_facturaMovimientosResumidos(esInicial);
		this.setActivartotalMovimientosResumidos(esInicial);
		this.setActivarivaMovimientosResumidos(esInicial);
		this.setActivarnumero_secuencialMovimientosResumidos(esInicial);
		this.setActivarfecha_emisionMovimientosResumidos(esInicial);
		this.setActivartotal_descuentoMovimientosResumidos(esInicial);
		this.setActivariceMovimientosResumidos(esInicial);
		this.setActivarretencionMovimientosResumidos(esInicial);
		this.setActivartotal_otroMovimientosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ID)) {
				this.setActivaridMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTAL)) {
				this.setActivartotalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IVA)) {
				this.setActivarivaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ICE)) {
				this.setActivariceMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.RETENCION)) {
				this.setActivarretencionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroMovimientosResumidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMovimientosResumidos(esInicial);
		this.setResaltarid_empresaMovimientosResumidos(esInicial);
		this.setResaltarid_sucursalMovimientosResumidos(esInicial);
		this.setResaltarid_transaccionMovimientosResumidos(esInicial);
		this.setResaltarfecha_emision_desdeMovimientosResumidos(esInicial);
		this.setResaltarfecha_emision_hastaMovimientosResumidos(esInicial);
		this.setResaltarnombre_sucursalMovimientosResumidos(esInicial);
		this.setResaltarnombre_completo_clienteMovimientosResumidos(esInicial);
		this.setResaltarnombre_transaccionMovimientosResumidos(esInicial);
		this.setResaltarnumero_comprobanteMovimientosResumidos(esInicial);
		this.setResaltarnumero_facturaMovimientosResumidos(esInicial);
		this.setResaltartotalMovimientosResumidos(esInicial);
		this.setResaltarivaMovimientosResumidos(esInicial);
		this.setResaltarnumero_secuencialMovimientosResumidos(esInicial);
		this.setResaltarfecha_emisionMovimientosResumidos(esInicial);
		this.setResaltartotal_descuentoMovimientosResumidos(esInicial);
		this.setResaltariceMovimientosResumidos(esInicial);
		this.setResaltarretencionMovimientosResumidos(esInicial);
		this.setResaltartotal_otroMovimientosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ID)) {
				this.setResaltaridMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTAL)) {
				this.setResaltartotalMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.IVA)) {
				this.setResaltarivaMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.ICE)) {
				this.setResaltariceMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.RETENCION)) {
				this.setResaltarretencionMovimientosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosResumidosConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroMovimientosResumidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaMovimientosResumidosMovimientosResumidos=true;

	public Boolean getMostrarBusquedaMovimientosResumidosMovimientosResumidos() {
		return this.mostrarBusquedaMovimientosResumidosMovimientosResumidos;
	}

	public void setMostrarBusquedaMovimientosResumidosMovimientosResumidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaMovimientosResumidosMovimientosResumidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaMovimientosResumidosMovimientosResumidos=true;

	public Boolean getActivarBusquedaMovimientosResumidosMovimientosResumidos() {
		return this.activarBusquedaMovimientosResumidosMovimientosResumidos;
	}

	public void setActivarBusquedaMovimientosResumidosMovimientosResumidos(Boolean habilitarResaltar) {
		this.activarBusquedaMovimientosResumidosMovimientosResumidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaMovimientosResumidosMovimientosResumidos=null;

	public Border getResaltarBusquedaMovimientosResumidosMovimientosResumidos() {
		return this.resaltarBusquedaMovimientosResumidosMovimientosResumidos;
	}

	public void setResaltarBusquedaMovimientosResumidosMovimientosResumidos(Border borderResaltar) {
		this.resaltarBusquedaMovimientosResumidosMovimientosResumidos= borderResaltar;
	}

	public void setResaltarBusquedaMovimientosResumidosMovimientosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosResumidosBeanSwingJInternalFrame movimientosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaMovimientosResumidosMovimientosResumidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}