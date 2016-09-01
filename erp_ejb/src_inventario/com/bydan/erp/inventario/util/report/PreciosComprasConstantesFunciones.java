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


import com.bydan.erp.inventario.util.report.PreciosComprasConstantesFunciones;
import com.bydan.erp.inventario.util.report.PreciosComprasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.PreciosComprasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PreciosComprasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PreciosCompras";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PreciosCompras"+PreciosComprasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PreciosComprasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PreciosComprasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PreciosComprasConstantesFunciones.SCHEMA+"_"+PreciosComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PreciosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PreciosComprasConstantesFunciones.SCHEMA+"_"+PreciosComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PreciosComprasConstantesFunciones.SCHEMA+"_"+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PreciosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PreciosComprasConstantesFunciones.SCHEMA+"_"+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreciosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreciosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreciosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PreciosComprasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PreciosComprasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PreciosComprasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PreciosComprasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Precios Comprases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Precios Compras";
	public static final String SCLASSWEBTITULO_LOWER="Precios Compras";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PreciosCompras";
	public static final String OBJECTNAME="precioscompras";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="precios_compras";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select precioscompras from "+PreciosComprasConstantesFunciones.SPERSISTENCENAME+" precioscompras";
	public static String QUERYSELECTNATIVE="select "+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".version_row,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_empresa,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_sucursal,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_bodega,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_producto,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_transaccion,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_linea,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_linea_grupo,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_linea_categoria,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".id_linea_marca,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".numero_comprobante,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".fecha_emision,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".nombre_producto,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".costo_unitario,"+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME+".codigo_producto from "+PreciosComprasConstantesFunciones.SCHEMA+"."+PreciosComprasConstantesFunciones.TABLENAME;//+" as "+PreciosComprasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String CODIGOPRODUCTO= "codigo_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPreciosComprasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDBODEGA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDTRANSACCION)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDLINEA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.FECHAEMISION)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(PreciosComprasConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=PreciosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPreciosComprasDescripcion(PreciosCompras precioscompras) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(precioscompras !=null/* && precioscompras.getId()!=0*/) {
			if(precioscompras.getId()!=null) {
				sDescripcion=precioscompras.getId().toString();
			}//precioscomprasprecioscompras.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPreciosComprasDescripcionDetallado(PreciosCompras precioscompras) {
		String sDescripcion="";
			
		sDescripcion+=PreciosComprasConstantesFunciones.ID+"=";
		sDescripcion+=precioscompras.getId().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=precioscompras.getVersionRow().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=precioscompras.getid_empresa().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=precioscompras.getid_sucursal().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=precioscompras.getid_bodega().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=precioscompras.getid_producto().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=precioscompras.getid_transaccion().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=precioscompras.getid_linea().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=precioscompras.getid_linea_grupo().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=precioscompras.getid_linea_categoria().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=precioscompras.getid_linea_marca().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=precioscompras.getfecha_emision_desde().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=precioscompras.getfecha_emision_hasta().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=precioscompras.getnombre_completo_cliente()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=precioscompras.getnumero_comprobante()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=precioscompras.getfecha_emision().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=precioscompras.getnombre_producto()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=precioscompras.getcosto_unitario().toString()+",";
		sDescripcion+=PreciosComprasConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=precioscompras.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setPreciosComprasDescripcion(PreciosCompras precioscompras,String sValor) throws Exception {			
		if(precioscompras !=null) {
			//precioscomprasprecioscompras.getId().toString();
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPreciosCompras")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Transaccion Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
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

	public static String getDetalleIndiceBusquedaPreciosCompras(Long id_bodega,Long id_producto,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPreciosCompras(PreciosCompras precioscompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		precioscompras.setnombre_completo_cliente(precioscompras.getnombre_completo_cliente().trim());
		precioscompras.setnumero_comprobante(precioscompras.getnumero_comprobante().trim());
		precioscompras.setnombre_producto(precioscompras.getnombre_producto().trim());
		precioscompras.setcodigo_producto(precioscompras.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosPreciosComprass(List<PreciosCompras> precioscomprass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PreciosCompras precioscompras: precioscomprass) {
			precioscompras.setnombre_completo_cliente(precioscompras.getnombre_completo_cliente().trim());
			precioscompras.setnumero_comprobante(precioscompras.getnumero_comprobante().trim());
			precioscompras.setnombre_producto(precioscompras.getnombre_producto().trim());
			precioscompras.setcodigo_producto(precioscompras.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreciosCompras(PreciosCompras precioscompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && precioscompras.getConCambioAuxiliar()) {
			precioscompras.setIsDeleted(precioscompras.getIsDeletedAuxiliar());	
			precioscompras.setIsNew(precioscompras.getIsNewAuxiliar());	
			precioscompras.setIsChanged(precioscompras.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			precioscompras.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			precioscompras.setIsDeletedAuxiliar(false);	
			precioscompras.setIsNewAuxiliar(false);	
			precioscompras.setIsChangedAuxiliar(false);
			
			precioscompras.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreciosComprass(List<PreciosCompras> precioscomprass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PreciosCompras precioscompras : precioscomprass) {
			if(conAsignarBase && precioscompras.getConCambioAuxiliar()) {
				precioscompras.setIsDeleted(precioscompras.getIsDeletedAuxiliar());	
				precioscompras.setIsNew(precioscompras.getIsNewAuxiliar());	
				precioscompras.setIsChanged(precioscompras.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				precioscompras.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				precioscompras.setIsDeletedAuxiliar(false);	
				precioscompras.setIsNewAuxiliar(false);	
				precioscompras.setIsChangedAuxiliar(false);
				
				precioscompras.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPreciosCompras(PreciosCompras precioscompras,Boolean conEnteros) throws Exception  {
		precioscompras.setcosto_unitario(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPreciosComprass(List<PreciosCompras> precioscomprass,Boolean conEnteros) throws Exception  {
		
		for(PreciosCompras precioscompras: precioscomprass) {
			precioscompras.setcosto_unitario(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPreciosCompras(List<PreciosCompras> precioscomprass,PreciosCompras precioscomprasAux) throws Exception  {
		PreciosComprasConstantesFunciones.InicializarValoresPreciosCompras(precioscomprasAux,true);
		
		for(PreciosCompras precioscompras: precioscomprass) {
			if(precioscompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioscomprasAux.setcosto_unitario(precioscomprasAux.getcosto_unitario()+precioscompras.getcosto_unitario());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPreciosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PreciosComprasConstantesFunciones.getArrayColumnasGlobalesPreciosCompras(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPreciosCompras(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreciosComprasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreciosComprasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreciosComprasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreciosComprasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPreciosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PreciosCompras> precioscomprass,PreciosCompras precioscompras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PreciosCompras precioscomprasAux: precioscomprass) {
			if(precioscomprasAux!=null && precioscompras!=null) {
				if((precioscomprasAux.getId()==null && precioscompras.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(precioscomprasAux.getId()!=null && precioscompras.getId()!=null){
					if(precioscomprasAux.getId().equals(precioscompras.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPreciosCompras(List<PreciosCompras> precioscomprass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
	
		for(PreciosCompras precioscompras: precioscomprass) {			
			if(precioscompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=precioscompras.getcosto_unitario();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PreciosComprasConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPreciosCompras() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_ID, PreciosComprasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_VERSIONROW, PreciosComprasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_NUMEROCOMPROBANTE, PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_FECHAEMISION, PreciosComprasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO, PreciosComprasConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO, PreciosComprasConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreciosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO, PreciosComprasConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPreciosCompras() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreciosComprasConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreciosCompras() throws Exception  {
		return PreciosComprasConstantesFunciones.getTiposSeleccionarPreciosCompras(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreciosCompras(Boolean conFk) throws Exception  {
		return PreciosComprasConstantesFunciones.getTiposSeleccionarPreciosCompras(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreciosCompras(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreciosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPreciosCompras(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPreciosCompras(PreciosCompras precioscomprasAux) throws Exception {
		
			precioscomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(precioscomprasAux.getEmpresa()));
			precioscomprasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(precioscomprasAux.getSucursal()));
			precioscomprasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(precioscomprasAux.getBodega()));
			precioscomprasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(precioscomprasAux.getProducto()));
			precioscomprasAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(precioscomprasAux.getTransaccion()));
			precioscomprasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLinea()));
			precioscomprasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaGrupo()));
			precioscomprasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaCategoria()));
			precioscomprasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPreciosCompras(List<PreciosCompras> precioscomprassTemp) throws Exception {
		for(PreciosCompras precioscomprasAux:precioscomprassTemp) {
			
			precioscomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(precioscomprasAux.getEmpresa()));
			precioscomprasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(precioscomprasAux.getSucursal()));
			precioscomprasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(precioscomprasAux.getBodega()));
			precioscomprasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(precioscomprasAux.getProducto()));
			precioscomprasAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(precioscomprasAux.getTransaccion()));
			precioscomprasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLinea()));
			precioscomprasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaGrupo()));
			precioscomprasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaCategoria()));
			precioscomprasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioscomprasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPreciosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPreciosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreciosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreciosComprasConstantesFunciones.getClassesRelationshipsOfPreciosCompras(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreciosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreciosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreciosComprasConstantesFunciones.getClassesRelationshipsFromStringsOfPreciosCompras(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreciosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PreciosCompras precioscompras,List<PreciosCompras> precioscomprass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PreciosCompras precioscompras,List<PreciosCompras> precioscomprass) throws Exception {
		try	{			
			for(PreciosCompras precioscomprasLocal:precioscomprass) {
				if(precioscomprasLocal.getId().equals(precioscompras.getId())) {
					precioscomprasLocal.setIsSelected(precioscompras.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPreciosCompras(List<PreciosCompras> precioscomprassAux) throws Exception {
		//this.precioscomprassAux=precioscomprassAux;
		
		for(PreciosCompras precioscomprasAux:precioscomprassAux) {
			if(precioscomprasAux.getIsChanged()) {
				precioscomprasAux.setIsChanged(false);
			}		
			
			if(precioscomprasAux.getIsNew()) {
				precioscomprasAux.setIsNew(false);
			}	
			
			if(precioscomprasAux.getIsDeleted()) {
				precioscomprasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPreciosCompras(PreciosCompras precioscomprasAux) throws Exception {
		//this.precioscomprasAux=precioscomprasAux;
		
			if(precioscomprasAux.getIsChanged()) {
				precioscomprasAux.setIsChanged(false);
			}		
			
			if(precioscomprasAux.getIsNew()) {
				precioscomprasAux.setIsNew(false);
			}	
			
			if(precioscomprasAux.getIsDeleted()) {
				precioscomprasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PreciosCompras precioscomprasAsignar,PreciosCompras precioscompras) throws Exception {
		precioscomprasAsignar.setId(precioscompras.getId());	
		precioscomprasAsignar.setVersionRow(precioscompras.getVersionRow());	
		precioscomprasAsignar.setnombre_completo_cliente(precioscompras.getnombre_completo_cliente());	
		precioscomprasAsignar.setnumero_comprobante(precioscompras.getnumero_comprobante());	
		precioscomprasAsignar.setfecha_emision(precioscompras.getfecha_emision());	
		precioscomprasAsignar.setnombre_producto(precioscompras.getnombre_producto());	
		precioscomprasAsignar.setcosto_unitario(precioscompras.getcosto_unitario());	
		precioscomprasAsignar.setcodigo_producto(precioscompras.getcodigo_producto());	
	}
	
	public static void inicializarPreciosCompras(PreciosCompras precioscompras) throws Exception {
		try {
				precioscompras.setId(0L);	
					
				precioscompras.setnombre_completo_cliente("");	
				precioscompras.setnumero_comprobante("");	
				precioscompras.setfecha_emision(new Date());	
				precioscompras.setnombre_producto("");	
				precioscompras.setcosto_unitario(0.0);	
				precioscompras.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPreciosCompras(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreciosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPreciosCompras(String sTipo,Row row,Workbook workbook,PreciosCompras precioscompras,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precioscompras.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPreciosCompras="";
	
	public String getsFinalQueryPreciosCompras() {
		return this.sFinalQueryPreciosCompras;
	}
	
	public void setsFinalQueryPreciosCompras(String sFinalQueryPreciosCompras) {
		this.sFinalQueryPreciosCompras= sFinalQueryPreciosCompras;
	}
	
	public Border resaltarSeleccionarPreciosCompras=null;
	
	public Border setResaltarSeleccionarPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPreciosCompras= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPreciosCompras() {
		return this.resaltarSeleccionarPreciosCompras;
	}
	
	public void setResaltarSeleccionarPreciosCompras(Border borderResaltarSeleccionarPreciosCompras) {
		this.resaltarSeleccionarPreciosCompras= borderResaltarSeleccionarPreciosCompras;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPreciosCompras=null;
	public Boolean mostraridPreciosCompras=true;
	public Boolean activaridPreciosCompras=true;

	public Border resaltarid_empresaPreciosCompras=null;
	public Boolean mostrarid_empresaPreciosCompras=true;
	public Boolean activarid_empresaPreciosCompras=true;
	public Boolean cargarid_empresaPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_sucursalPreciosCompras=null;
	public Boolean mostrarid_sucursalPreciosCompras=true;
	public Boolean activarid_sucursalPreciosCompras=true;
	public Boolean cargarid_sucursalPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_bodegaPreciosCompras=null;
	public Boolean mostrarid_bodegaPreciosCompras=true;
	public Boolean activarid_bodegaPreciosCompras=true;
	public Boolean cargarid_bodegaPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_productoPreciosCompras=null;
	public Boolean mostrarid_productoPreciosCompras=true;
	public Boolean activarid_productoPreciosCompras=true;
	public Boolean cargarid_productoPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_transaccionPreciosCompras=null;
	public Boolean mostrarid_transaccionPreciosCompras=true;
	public Boolean activarid_transaccionPreciosCompras=true;
	public Boolean cargarid_transaccionPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_lineaPreciosCompras=null;
	public Boolean mostrarid_lineaPreciosCompras=true;
	public Boolean activarid_lineaPreciosCompras=true;
	public Boolean cargarid_lineaPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoPreciosCompras=null;
	public Boolean mostrarid_linea_grupoPreciosCompras=true;
	public Boolean activarid_linea_grupoPreciosCompras=true;
	public Boolean cargarid_linea_grupoPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaPreciosCompras=null;
	public Boolean mostrarid_linea_categoriaPreciosCompras=true;
	public Boolean activarid_linea_categoriaPreciosCompras=true;
	public Boolean cargarid_linea_categoriaPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaPreciosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaPreciosCompras=null;
	public Boolean mostrarid_linea_marcaPreciosCompras=true;
	public Boolean activarid_linea_marcaPreciosCompras=true;
	public Boolean cargarid_linea_marcaPreciosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaPreciosCompras=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdePreciosCompras=null;
	public Boolean mostrarfecha_emision_desdePreciosCompras=true;
	public Boolean activarfecha_emision_desdePreciosCompras=true;

	public Border resaltarfecha_emision_hastaPreciosCompras=null;
	public Boolean mostrarfecha_emision_hastaPreciosCompras=true;
	public Boolean activarfecha_emision_hastaPreciosCompras=true;

	public Border resaltarnombre_completo_clientePreciosCompras=null;
	public Boolean mostrarnombre_completo_clientePreciosCompras=true;
	public Boolean activarnombre_completo_clientePreciosCompras=true;

	public Border resaltarnumero_comprobantePreciosCompras=null;
	public Boolean mostrarnumero_comprobantePreciosCompras=true;
	public Boolean activarnumero_comprobantePreciosCompras=true;

	public Border resaltarfecha_emisionPreciosCompras=null;
	public Boolean mostrarfecha_emisionPreciosCompras=true;
	public Boolean activarfecha_emisionPreciosCompras=true;

	public Border resaltarnombre_productoPreciosCompras=null;
	public Boolean mostrarnombre_productoPreciosCompras=true;
	public Boolean activarnombre_productoPreciosCompras=true;

	public Border resaltarcosto_unitarioPreciosCompras=null;
	public Boolean mostrarcosto_unitarioPreciosCompras=true;
	public Boolean activarcosto_unitarioPreciosCompras=true;

	public Border resaltarcodigo_productoPreciosCompras=null;
	public Boolean mostrarcodigo_productoPreciosCompras=true;
	public Boolean activarcodigo_productoPreciosCompras=true;

	
	

	public Border setResaltaridPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltaridPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPreciosCompras() {
		return this.resaltaridPreciosCompras;
	}

	public void setResaltaridPreciosCompras(Border borderResaltar) {
		this.resaltaridPreciosCompras= borderResaltar;
	}

	public Boolean getMostraridPreciosCompras() {
		return this.mostraridPreciosCompras;
	}

	public void setMostraridPreciosCompras(Boolean mostraridPreciosCompras) {
		this.mostraridPreciosCompras= mostraridPreciosCompras;
	}

	public Boolean getActivaridPreciosCompras() {
		return this.activaridPreciosCompras;
	}

	public void setActivaridPreciosCompras(Boolean activaridPreciosCompras) {
		this.activaridPreciosCompras= activaridPreciosCompras;
	}

	public Border setResaltarid_empresaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_empresaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPreciosCompras() {
		return this.resaltarid_empresaPreciosCompras;
	}

	public void setResaltarid_empresaPreciosCompras(Border borderResaltar) {
		this.resaltarid_empresaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_empresaPreciosCompras() {
		return this.mostrarid_empresaPreciosCompras;
	}

	public void setMostrarid_empresaPreciosCompras(Boolean mostrarid_empresaPreciosCompras) {
		this.mostrarid_empresaPreciosCompras= mostrarid_empresaPreciosCompras;
	}

	public Boolean getActivarid_empresaPreciosCompras() {
		return this.activarid_empresaPreciosCompras;
	}

	public void setActivarid_empresaPreciosCompras(Boolean activarid_empresaPreciosCompras) {
		this.activarid_empresaPreciosCompras= activarid_empresaPreciosCompras;
	}

	public Boolean getCargarid_empresaPreciosCompras() {
		return this.cargarid_empresaPreciosCompras;
	}

	public void setCargarid_empresaPreciosCompras(Boolean cargarid_empresaPreciosCompras) {
		this.cargarid_empresaPreciosCompras= cargarid_empresaPreciosCompras;
	}

	public Border setResaltarid_sucursalPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPreciosCompras() {
		return this.resaltarid_sucursalPreciosCompras;
	}

	public void setResaltarid_sucursalPreciosCompras(Border borderResaltar) {
		this.resaltarid_sucursalPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPreciosCompras() {
		return this.mostrarid_sucursalPreciosCompras;
	}

	public void setMostrarid_sucursalPreciosCompras(Boolean mostrarid_sucursalPreciosCompras) {
		this.mostrarid_sucursalPreciosCompras= mostrarid_sucursalPreciosCompras;
	}

	public Boolean getActivarid_sucursalPreciosCompras() {
		return this.activarid_sucursalPreciosCompras;
	}

	public void setActivarid_sucursalPreciosCompras(Boolean activarid_sucursalPreciosCompras) {
		this.activarid_sucursalPreciosCompras= activarid_sucursalPreciosCompras;
	}

	public Boolean getCargarid_sucursalPreciosCompras() {
		return this.cargarid_sucursalPreciosCompras;
	}

	public void setCargarid_sucursalPreciosCompras(Boolean cargarid_sucursalPreciosCompras) {
		this.cargarid_sucursalPreciosCompras= cargarid_sucursalPreciosCompras;
	}

	public Border setResaltarid_bodegaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_bodegaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaPreciosCompras() {
		return this.resaltarid_bodegaPreciosCompras;
	}

	public void setResaltarid_bodegaPreciosCompras(Border borderResaltar) {
		this.resaltarid_bodegaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_bodegaPreciosCompras() {
		return this.mostrarid_bodegaPreciosCompras;
	}

	public void setMostrarid_bodegaPreciosCompras(Boolean mostrarid_bodegaPreciosCompras) {
		this.mostrarid_bodegaPreciosCompras= mostrarid_bodegaPreciosCompras;
	}

	public Boolean getActivarid_bodegaPreciosCompras() {
		return this.activarid_bodegaPreciosCompras;
	}

	public void setActivarid_bodegaPreciosCompras(Boolean activarid_bodegaPreciosCompras) {
		this.activarid_bodegaPreciosCompras= activarid_bodegaPreciosCompras;
	}

	public Boolean getCargarid_bodegaPreciosCompras() {
		return this.cargarid_bodegaPreciosCompras;
	}

	public void setCargarid_bodegaPreciosCompras(Boolean cargarid_bodegaPreciosCompras) {
		this.cargarid_bodegaPreciosCompras= cargarid_bodegaPreciosCompras;
	}

	public Border setResaltarid_productoPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_productoPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPreciosCompras() {
		return this.resaltarid_productoPreciosCompras;
	}

	public void setResaltarid_productoPreciosCompras(Border borderResaltar) {
		this.resaltarid_productoPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_productoPreciosCompras() {
		return this.mostrarid_productoPreciosCompras;
	}

	public void setMostrarid_productoPreciosCompras(Boolean mostrarid_productoPreciosCompras) {
		this.mostrarid_productoPreciosCompras= mostrarid_productoPreciosCompras;
	}

	public Boolean getActivarid_productoPreciosCompras() {
		return this.activarid_productoPreciosCompras;
	}

	public void setActivarid_productoPreciosCompras(Boolean activarid_productoPreciosCompras) {
		this.activarid_productoPreciosCompras= activarid_productoPreciosCompras;
	}

	public Boolean getCargarid_productoPreciosCompras() {
		return this.cargarid_productoPreciosCompras;
	}

	public void setCargarid_productoPreciosCompras(Boolean cargarid_productoPreciosCompras) {
		this.cargarid_productoPreciosCompras= cargarid_productoPreciosCompras;
	}

	public Border setResaltarid_transaccionPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_transaccionPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionPreciosCompras() {
		return this.resaltarid_transaccionPreciosCompras;
	}

	public void setResaltarid_transaccionPreciosCompras(Border borderResaltar) {
		this.resaltarid_transaccionPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_transaccionPreciosCompras() {
		return this.mostrarid_transaccionPreciosCompras;
	}

	public void setMostrarid_transaccionPreciosCompras(Boolean mostrarid_transaccionPreciosCompras) {
		this.mostrarid_transaccionPreciosCompras= mostrarid_transaccionPreciosCompras;
	}

	public Boolean getActivarid_transaccionPreciosCompras() {
		return this.activarid_transaccionPreciosCompras;
	}

	public void setActivarid_transaccionPreciosCompras(Boolean activarid_transaccionPreciosCompras) {
		this.activarid_transaccionPreciosCompras= activarid_transaccionPreciosCompras;
	}

	public Boolean getCargarid_transaccionPreciosCompras() {
		return this.cargarid_transaccionPreciosCompras;
	}

	public void setCargarid_transaccionPreciosCompras(Boolean cargarid_transaccionPreciosCompras) {
		this.cargarid_transaccionPreciosCompras= cargarid_transaccionPreciosCompras;
	}

	public Border setResaltarid_lineaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_lineaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaPreciosCompras() {
		return this.resaltarid_lineaPreciosCompras;
	}

	public void setResaltarid_lineaPreciosCompras(Border borderResaltar) {
		this.resaltarid_lineaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_lineaPreciosCompras() {
		return this.mostrarid_lineaPreciosCompras;
	}

	public void setMostrarid_lineaPreciosCompras(Boolean mostrarid_lineaPreciosCompras) {
		this.mostrarid_lineaPreciosCompras= mostrarid_lineaPreciosCompras;
	}

	public Boolean getActivarid_lineaPreciosCompras() {
		return this.activarid_lineaPreciosCompras;
	}

	public void setActivarid_lineaPreciosCompras(Boolean activarid_lineaPreciosCompras) {
		this.activarid_lineaPreciosCompras= activarid_lineaPreciosCompras;
	}

	public Boolean getCargarid_lineaPreciosCompras() {
		return this.cargarid_lineaPreciosCompras;
	}

	public void setCargarid_lineaPreciosCompras(Boolean cargarid_lineaPreciosCompras) {
		this.cargarid_lineaPreciosCompras= cargarid_lineaPreciosCompras;
	}

	public Border setResaltarid_linea_grupoPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoPreciosCompras() {
		return this.resaltarid_linea_grupoPreciosCompras;
	}

	public void setResaltarid_linea_grupoPreciosCompras(Border borderResaltar) {
		this.resaltarid_linea_grupoPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoPreciosCompras() {
		return this.mostrarid_linea_grupoPreciosCompras;
	}

	public void setMostrarid_linea_grupoPreciosCompras(Boolean mostrarid_linea_grupoPreciosCompras) {
		this.mostrarid_linea_grupoPreciosCompras= mostrarid_linea_grupoPreciosCompras;
	}

	public Boolean getActivarid_linea_grupoPreciosCompras() {
		return this.activarid_linea_grupoPreciosCompras;
	}

	public void setActivarid_linea_grupoPreciosCompras(Boolean activarid_linea_grupoPreciosCompras) {
		this.activarid_linea_grupoPreciosCompras= activarid_linea_grupoPreciosCompras;
	}

	public Boolean getCargarid_linea_grupoPreciosCompras() {
		return this.cargarid_linea_grupoPreciosCompras;
	}

	public void setCargarid_linea_grupoPreciosCompras(Boolean cargarid_linea_grupoPreciosCompras) {
		this.cargarid_linea_grupoPreciosCompras= cargarid_linea_grupoPreciosCompras;
	}

	public Border setResaltarid_linea_categoriaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaPreciosCompras() {
		return this.resaltarid_linea_categoriaPreciosCompras;
	}

	public void setResaltarid_linea_categoriaPreciosCompras(Border borderResaltar) {
		this.resaltarid_linea_categoriaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaPreciosCompras() {
		return this.mostrarid_linea_categoriaPreciosCompras;
	}

	public void setMostrarid_linea_categoriaPreciosCompras(Boolean mostrarid_linea_categoriaPreciosCompras) {
		this.mostrarid_linea_categoriaPreciosCompras= mostrarid_linea_categoriaPreciosCompras;
	}

	public Boolean getActivarid_linea_categoriaPreciosCompras() {
		return this.activarid_linea_categoriaPreciosCompras;
	}

	public void setActivarid_linea_categoriaPreciosCompras(Boolean activarid_linea_categoriaPreciosCompras) {
		this.activarid_linea_categoriaPreciosCompras= activarid_linea_categoriaPreciosCompras;
	}

	public Boolean getCargarid_linea_categoriaPreciosCompras() {
		return this.cargarid_linea_categoriaPreciosCompras;
	}

	public void setCargarid_linea_categoriaPreciosCompras(Boolean cargarid_linea_categoriaPreciosCompras) {
		this.cargarid_linea_categoriaPreciosCompras= cargarid_linea_categoriaPreciosCompras;
	}

	public Border setResaltarid_linea_marcaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaPreciosCompras() {
		return this.resaltarid_linea_marcaPreciosCompras;
	}

	public void setResaltarid_linea_marcaPreciosCompras(Border borderResaltar) {
		this.resaltarid_linea_marcaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaPreciosCompras() {
		return this.mostrarid_linea_marcaPreciosCompras;
	}

	public void setMostrarid_linea_marcaPreciosCompras(Boolean mostrarid_linea_marcaPreciosCompras) {
		this.mostrarid_linea_marcaPreciosCompras= mostrarid_linea_marcaPreciosCompras;
	}

	public Boolean getActivarid_linea_marcaPreciosCompras() {
		return this.activarid_linea_marcaPreciosCompras;
	}

	public void setActivarid_linea_marcaPreciosCompras(Boolean activarid_linea_marcaPreciosCompras) {
		this.activarid_linea_marcaPreciosCompras= activarid_linea_marcaPreciosCompras;
	}

	public Boolean getCargarid_linea_marcaPreciosCompras() {
		return this.cargarid_linea_marcaPreciosCompras;
	}

	public void setCargarid_linea_marcaPreciosCompras(Boolean cargarid_linea_marcaPreciosCompras) {
		this.cargarid_linea_marcaPreciosCompras= cargarid_linea_marcaPreciosCompras;
	}

	public Border setResaltarfecha_emision_desdePreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdePreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdePreciosCompras() {
		return this.resaltarfecha_emision_desdePreciosCompras;
	}

	public void setResaltarfecha_emision_desdePreciosCompras(Border borderResaltar) {
		this.resaltarfecha_emision_desdePreciosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdePreciosCompras() {
		return this.mostrarfecha_emision_desdePreciosCompras;
	}

	public void setMostrarfecha_emision_desdePreciosCompras(Boolean mostrarfecha_emision_desdePreciosCompras) {
		this.mostrarfecha_emision_desdePreciosCompras= mostrarfecha_emision_desdePreciosCompras;
	}

	public Boolean getActivarfecha_emision_desdePreciosCompras() {
		return this.activarfecha_emision_desdePreciosCompras;
	}

	public void setActivarfecha_emision_desdePreciosCompras(Boolean activarfecha_emision_desdePreciosCompras) {
		this.activarfecha_emision_desdePreciosCompras= activarfecha_emision_desdePreciosCompras;
	}

	public Border setResaltarfecha_emision_hastaPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaPreciosCompras() {
		return this.resaltarfecha_emision_hastaPreciosCompras;
	}

	public void setResaltarfecha_emision_hastaPreciosCompras(Border borderResaltar) {
		this.resaltarfecha_emision_hastaPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaPreciosCompras() {
		return this.mostrarfecha_emision_hastaPreciosCompras;
	}

	public void setMostrarfecha_emision_hastaPreciosCompras(Boolean mostrarfecha_emision_hastaPreciosCompras) {
		this.mostrarfecha_emision_hastaPreciosCompras= mostrarfecha_emision_hastaPreciosCompras;
	}

	public Boolean getActivarfecha_emision_hastaPreciosCompras() {
		return this.activarfecha_emision_hastaPreciosCompras;
	}

	public void setActivarfecha_emision_hastaPreciosCompras(Boolean activarfecha_emision_hastaPreciosCompras) {
		this.activarfecha_emision_hastaPreciosCompras= activarfecha_emision_hastaPreciosCompras;
	}

	public Border setResaltarnombre_completo_clientePreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clientePreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clientePreciosCompras() {
		return this.resaltarnombre_completo_clientePreciosCompras;
	}

	public void setResaltarnombre_completo_clientePreciosCompras(Border borderResaltar) {
		this.resaltarnombre_completo_clientePreciosCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clientePreciosCompras() {
		return this.mostrarnombre_completo_clientePreciosCompras;
	}

	public void setMostrarnombre_completo_clientePreciosCompras(Boolean mostrarnombre_completo_clientePreciosCompras) {
		this.mostrarnombre_completo_clientePreciosCompras= mostrarnombre_completo_clientePreciosCompras;
	}

	public Boolean getActivarnombre_completo_clientePreciosCompras() {
		return this.activarnombre_completo_clientePreciosCompras;
	}

	public void setActivarnombre_completo_clientePreciosCompras(Boolean activarnombre_completo_clientePreciosCompras) {
		this.activarnombre_completo_clientePreciosCompras= activarnombre_completo_clientePreciosCompras;
	}

	public Border setResaltarnumero_comprobantePreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobantePreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobantePreciosCompras() {
		return this.resaltarnumero_comprobantePreciosCompras;
	}

	public void setResaltarnumero_comprobantePreciosCompras(Border borderResaltar) {
		this.resaltarnumero_comprobantePreciosCompras= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobantePreciosCompras() {
		return this.mostrarnumero_comprobantePreciosCompras;
	}

	public void setMostrarnumero_comprobantePreciosCompras(Boolean mostrarnumero_comprobantePreciosCompras) {
		this.mostrarnumero_comprobantePreciosCompras= mostrarnumero_comprobantePreciosCompras;
	}

	public Boolean getActivarnumero_comprobantePreciosCompras() {
		return this.activarnumero_comprobantePreciosCompras;
	}

	public void setActivarnumero_comprobantePreciosCompras(Boolean activarnumero_comprobantePreciosCompras) {
		this.activarnumero_comprobantePreciosCompras= activarnumero_comprobantePreciosCompras;
	}

	public Border setResaltarfecha_emisionPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPreciosCompras() {
		return this.resaltarfecha_emisionPreciosCompras;
	}

	public void setResaltarfecha_emisionPreciosCompras(Border borderResaltar) {
		this.resaltarfecha_emisionPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPreciosCompras() {
		return this.mostrarfecha_emisionPreciosCompras;
	}

	public void setMostrarfecha_emisionPreciosCompras(Boolean mostrarfecha_emisionPreciosCompras) {
		this.mostrarfecha_emisionPreciosCompras= mostrarfecha_emisionPreciosCompras;
	}

	public Boolean getActivarfecha_emisionPreciosCompras() {
		return this.activarfecha_emisionPreciosCompras;
	}

	public void setActivarfecha_emisionPreciosCompras(Boolean activarfecha_emisionPreciosCompras) {
		this.activarfecha_emisionPreciosCompras= activarfecha_emisionPreciosCompras;
	}

	public Border setResaltarnombre_productoPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_productoPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoPreciosCompras() {
		return this.resaltarnombre_productoPreciosCompras;
	}

	public void setResaltarnombre_productoPreciosCompras(Border borderResaltar) {
		this.resaltarnombre_productoPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_productoPreciosCompras() {
		return this.mostrarnombre_productoPreciosCompras;
	}

	public void setMostrarnombre_productoPreciosCompras(Boolean mostrarnombre_productoPreciosCompras) {
		this.mostrarnombre_productoPreciosCompras= mostrarnombre_productoPreciosCompras;
	}

	public Boolean getActivarnombre_productoPreciosCompras() {
		return this.activarnombre_productoPreciosCompras;
	}

	public void setActivarnombre_productoPreciosCompras(Boolean activarnombre_productoPreciosCompras) {
		this.activarnombre_productoPreciosCompras= activarnombre_productoPreciosCompras;
	}

	public Border setResaltarcosto_unitarioPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioPreciosCompras() {
		return this.resaltarcosto_unitarioPreciosCompras;
	}

	public void setResaltarcosto_unitarioPreciosCompras(Border borderResaltar) {
		this.resaltarcosto_unitarioPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioPreciosCompras() {
		return this.mostrarcosto_unitarioPreciosCompras;
	}

	public void setMostrarcosto_unitarioPreciosCompras(Boolean mostrarcosto_unitarioPreciosCompras) {
		this.mostrarcosto_unitarioPreciosCompras= mostrarcosto_unitarioPreciosCompras;
	}

	public Boolean getActivarcosto_unitarioPreciosCompras() {
		return this.activarcosto_unitarioPreciosCompras;
	}

	public void setActivarcosto_unitarioPreciosCompras(Boolean activarcosto_unitarioPreciosCompras) {
		this.activarcosto_unitarioPreciosCompras= activarcosto_unitarioPreciosCompras;
	}

	public Border setResaltarcodigo_productoPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioscomprasBeanSwingJInternalFrame.jTtoolBarPreciosCompras.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoPreciosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoPreciosCompras() {
		return this.resaltarcodigo_productoPreciosCompras;
	}

	public void setResaltarcodigo_productoPreciosCompras(Border borderResaltar) {
		this.resaltarcodigo_productoPreciosCompras= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoPreciosCompras() {
		return this.mostrarcodigo_productoPreciosCompras;
	}

	public void setMostrarcodigo_productoPreciosCompras(Boolean mostrarcodigo_productoPreciosCompras) {
		this.mostrarcodigo_productoPreciosCompras= mostrarcodigo_productoPreciosCompras;
	}

	public Boolean getActivarcodigo_productoPreciosCompras() {
		return this.activarcodigo_productoPreciosCompras;
	}

	public void setActivarcodigo_productoPreciosCompras(Boolean activarcodigo_productoPreciosCompras) {
		this.activarcodigo_productoPreciosCompras= activarcodigo_productoPreciosCompras;
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
		
		
		this.setMostraridPreciosCompras(esInicial);
		this.setMostrarid_empresaPreciosCompras(esInicial);
		this.setMostrarid_sucursalPreciosCompras(esInicial);
		this.setMostrarid_bodegaPreciosCompras(esInicial);
		this.setMostrarid_productoPreciosCompras(esInicial);
		this.setMostrarid_transaccionPreciosCompras(esInicial);
		this.setMostrarid_lineaPreciosCompras(esInicial);
		this.setMostrarid_linea_grupoPreciosCompras(esInicial);
		this.setMostrarid_linea_categoriaPreciosCompras(esInicial);
		this.setMostrarid_linea_marcaPreciosCompras(esInicial);
		this.setMostrarfecha_emision_desdePreciosCompras(esInicial);
		this.setMostrarfecha_emision_hastaPreciosCompras(esInicial);
		this.setMostrarnombre_completo_clientePreciosCompras(esInicial);
		this.setMostrarnumero_comprobantePreciosCompras(esInicial);
		this.setMostrarfecha_emisionPreciosCompras(esInicial);
		this.setMostrarnombre_productoPreciosCompras(esInicial);
		this.setMostrarcosto_unitarioPreciosCompras(esInicial);
		this.setMostrarcodigo_productoPreciosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreciosComprasConstantesFunciones.ID)) {
				this.setMostraridPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clientePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobantePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoPreciosCompras(esAsigna);
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
		
		
		this.setActivaridPreciosCompras(esInicial);
		this.setActivarid_empresaPreciosCompras(esInicial);
		this.setActivarid_sucursalPreciosCompras(esInicial);
		this.setActivarid_bodegaPreciosCompras(esInicial);
		this.setActivarid_productoPreciosCompras(esInicial);
		this.setActivarid_transaccionPreciosCompras(esInicial);
		this.setActivarid_lineaPreciosCompras(esInicial);
		this.setActivarid_linea_grupoPreciosCompras(esInicial);
		this.setActivarid_linea_categoriaPreciosCompras(esInicial);
		this.setActivarid_linea_marcaPreciosCompras(esInicial);
		this.setActivarfecha_emision_desdePreciosCompras(esInicial);
		this.setActivarfecha_emision_hastaPreciosCompras(esInicial);
		this.setActivarnombre_completo_clientePreciosCompras(esInicial);
		this.setActivarnumero_comprobantePreciosCompras(esInicial);
		this.setActivarfecha_emisionPreciosCompras(esInicial);
		this.setActivarnombre_productoPreciosCompras(esInicial);
		this.setActivarcosto_unitarioPreciosCompras(esInicial);
		this.setActivarcodigo_productoPreciosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreciosComprasConstantesFunciones.ID)) {
				this.setActivaridPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clientePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobantePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoPreciosCompras(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPreciosCompras(esInicial);
		this.setResaltarid_empresaPreciosCompras(esInicial);
		this.setResaltarid_sucursalPreciosCompras(esInicial);
		this.setResaltarid_bodegaPreciosCompras(esInicial);
		this.setResaltarid_productoPreciosCompras(esInicial);
		this.setResaltarid_transaccionPreciosCompras(esInicial);
		this.setResaltarid_lineaPreciosCompras(esInicial);
		this.setResaltarid_linea_grupoPreciosCompras(esInicial);
		this.setResaltarid_linea_categoriaPreciosCompras(esInicial);
		this.setResaltarid_linea_marcaPreciosCompras(esInicial);
		this.setResaltarfecha_emision_desdePreciosCompras(esInicial);
		this.setResaltarfecha_emision_hastaPreciosCompras(esInicial);
		this.setResaltarnombre_completo_clientePreciosCompras(esInicial);
		this.setResaltarnumero_comprobantePreciosCompras(esInicial);
		this.setResaltarfecha_emisionPreciosCompras(esInicial);
		this.setResaltarnombre_productoPreciosCompras(esInicial);
		this.setResaltarcosto_unitarioPreciosCompras(esInicial);
		this.setResaltarcodigo_productoPreciosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreciosComprasConstantesFunciones.ID)) {
				this.setResaltaridPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clientePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobantePreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioPreciosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreciosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoPreciosCompras(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPreciosComprasPreciosCompras=true;

	public Boolean getMostrarBusquedaPreciosComprasPreciosCompras() {
		return this.mostrarBusquedaPreciosComprasPreciosCompras;
	}

	public void setMostrarBusquedaPreciosComprasPreciosCompras(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPreciosComprasPreciosCompras= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPreciosComprasPreciosCompras=true;

	public Boolean getActivarBusquedaPreciosComprasPreciosCompras() {
		return this.activarBusquedaPreciosComprasPreciosCompras;
	}

	public void setActivarBusquedaPreciosComprasPreciosCompras(Boolean habilitarResaltar) {
		this.activarBusquedaPreciosComprasPreciosCompras= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPreciosComprasPreciosCompras=null;

	public Border getResaltarBusquedaPreciosComprasPreciosCompras() {
		return this.resaltarBusquedaPreciosComprasPreciosCompras;
	}

	public void setResaltarBusquedaPreciosComprasPreciosCompras(Border borderResaltar) {
		this.resaltarBusquedaPreciosComprasPreciosCompras= borderResaltar;
	}

	public void setResaltarBusquedaPreciosComprasPreciosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PreciosComprasBeanSwingJInternalFrame precioscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPreciosComprasPreciosCompras= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}