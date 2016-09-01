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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.PedidoDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.PedidoDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.PedidoDetaProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoDetaProduConstantesFunciones extends PedidoDetaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PedidoDetaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoDetaProdu"+PedidoDetaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoDetaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoDetaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoDetaProduConstantesFunciones.SCHEMA+"_"+PedidoDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoDetaProduConstantesFunciones.SCHEMA+"_"+PedidoDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoDetaProduConstantesFunciones.SCHEMA+"_"+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoDetaProduConstantesFunciones.SCHEMA+"_"+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoDetaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoDetaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoDetaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoDetaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Detalle Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pedido Detalle Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Deta Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoDetaProdu";
	public static final String OBJECTNAME="pedidodetaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="pedido_deta_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidodetaprodu from "+PedidoDetaProduConstantesFunciones.SPERSISTENCENAME+" pedidodetaprodu";
	public static String QUERYSELECTNATIVE="select "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".version_row,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_empresa,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_periodo,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_pedido_produ,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_producto,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_bodega_destino,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".id_tipo_proceso_produ,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".cantidad,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".cantidad_pendiente,"+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME+".descripcion from "+PedidoDetaProduConstantesFunciones.SCHEMA+"."+PedidoDetaProduConstantesFunciones.TABLENAME;//+" as "+PedidoDetaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PedidoDetaProduConstantesFuncionesAdditional pedidodetaproduConstantesFuncionesAdditional=null;
	
	public PedidoDetaProduConstantesFuncionesAdditional getPedidoDetaProduConstantesFuncionesAdditional() {
		return this.pedidodetaproduConstantesFuncionesAdditional;
	}
	
	public void setPedidoDetaProduConstantesFuncionesAdditional(PedidoDetaProduConstantesFuncionesAdditional pedidodetaproduConstantesFuncionesAdditional) {
		try {
			this.pedidodetaproduConstantesFuncionesAdditional=pedidodetaproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDPEDIDOPRODU= "id_pedido_produ";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDBODEGADESTINO= "id_bodega_destino";
    public static final String IDTIPOPROCESOPRODU= "id_tipo_proceso_produ";
    public static final String CANTIDAD= "cantidad";
    public static final String CANTIDADPENDIENTE= "cantidad_pendiente";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDPEDIDOPRODU= "Pedido Produ";
		public static final String LABEL_IDPEDIDOPRODU_LOWER= "Pedido Produ";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDBODEGADESTINO= "Bodega Destino";
		public static final String LABEL_IDBODEGADESTINO_LOWER= "Bodega Destino";
    	public static final String LABEL_IDTIPOPROCESOPRODU= "Tipo Proceso Produ";
		public static final String LABEL_IDTIPOPROCESOPRODU_LOWER= "Tipo Proceso Produ";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_CANTIDADPENDIENTE= "Cantad Pendiente";
		public static final String LABEL_CANTIDADPENDIENTE_LOWER= "Cantidad Pendiente";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPedidoDetaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDPEDIDOPRODU;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDBODEGA)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDUNIDAD)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDBODEGADESTINO)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.CANTIDAD)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		if(sNombreColumna.equals(PedidoDetaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoDetaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoDetaProduDescripcion(PedidoDetaProdu pedidodetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidodetaprodu !=null/* && pedidodetaprodu.getId()!=0*/) {
			if(pedidodetaprodu.getId()!=null) {
				sDescripcion=pedidodetaprodu.getId().toString();
			}//pedidodetaprodupedidodetaprodu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoDetaProduDescripcionDetallado(PedidoDetaProdu pedidodetaprodu) {
		String sDescripcion="";
			
		sDescripcion+=PedidoDetaProduConstantesFunciones.ID+"=";
		sDescripcion+=pedidodetaprodu.getId().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidodetaprodu.getVersionRow().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidodetaprodu.getid_empresa().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidodetaprodu.getid_sucursal().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedidodetaprodu.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedidodetaprodu.getid_periodo().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU+"=";
		sDescripcion+=pedidodetaprodu.getid_pedido_produ().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=pedidodetaprodu.getid_bodega().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=pedidodetaprodu.getid_producto().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=pedidodetaprodu.getid_unidad().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDBODEGADESTINO+"=";
		sDescripcion+=pedidodetaprodu.getid_bodega_destino().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU+"=";
		sDescripcion+=pedidodetaprodu.getid_tipo_proceso_produ().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=pedidodetaprodu.getcantidad().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=pedidodetaprodu.getcantidad_pendiente().toString()+",";
		sDescripcion+=PedidoDetaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedidodetaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoDetaProduDescripcion(PedidoDetaProdu pedidodetaprodu,String sValor) throws Exception {			
		if(pedidodetaprodu !=null) {
			//pedidodetaprodupedidodetaprodu.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getPedidoProduDescripcion(PedidoProdu pedidoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidoprodu!=null/*&&pedidoprodu.getId()>0*/) {
			sDescripcion=PedidoProduConstantesFunciones.getPedidoProduDescripcion(pedidoprodu);
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

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getBodegaDestinoDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getTipoProcesoProduDescripcion(TipoProcesoProdu tipoprocesoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprocesoprodu!=null/*&&tipoprocesoprodu.getId()>0*/) {
			sDescripcion=TipoProcesoProduConstantesFunciones.getTipoProcesoProduDescripcion(tipoprocesoprodu);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaDestino")) {
			sNombreIndice="Tipo=  Por Bodega Destino";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPedidoProdu")) {
			sNombreIndice="Tipo=  Por Pedido Produ";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoProcesoProdu")) {
			sNombreIndice="Tipo=  Por Tipo Proceso Produ";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaDestino(Long id_bodega_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_destino!=null) {sDetalleIndice+=" Codigo Unico De Bodega Destino="+id_bodega_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoProdu(Long id_pedido_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_produ!=null) {sDetalleIndice+=" Codigo Unico De Pedido Produ="+id_pedido_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoProcesoProdu(Long id_tipo_proceso_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_proceso_produ!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proceso Produ="+id_tipo_proceso_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidoDetaProdu(PedidoDetaProdu pedidodetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidodetaprodu.setdescripcion(pedidodetaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidoDetaProdus(List<PedidoDetaProdu> pedidodetaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoDetaProdu pedidodetaprodu: pedidodetaprodus) {
			pedidodetaprodu.setdescripcion(pedidodetaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoDetaProdu(PedidoDetaProdu pedidodetaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidodetaprodu.getConCambioAuxiliar()) {
			pedidodetaprodu.setIsDeleted(pedidodetaprodu.getIsDeletedAuxiliar());	
			pedidodetaprodu.setIsNew(pedidodetaprodu.getIsNewAuxiliar());	
			pedidodetaprodu.setIsChanged(pedidodetaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidodetaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidodetaprodu.setIsDeletedAuxiliar(false);	
			pedidodetaprodu.setIsNewAuxiliar(false);	
			pedidodetaprodu.setIsChangedAuxiliar(false);
			
			pedidodetaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoDetaProdus(List<PedidoDetaProdu> pedidodetaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoDetaProdu pedidodetaprodu : pedidodetaprodus) {
			if(conAsignarBase && pedidodetaprodu.getConCambioAuxiliar()) {
				pedidodetaprodu.setIsDeleted(pedidodetaprodu.getIsDeletedAuxiliar());	
				pedidodetaprodu.setIsNew(pedidodetaprodu.getIsNewAuxiliar());	
				pedidodetaprodu.setIsChanged(pedidodetaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidodetaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidodetaprodu.setIsDeletedAuxiliar(false);	
				pedidodetaprodu.setIsNewAuxiliar(false);	
				pedidodetaprodu.setIsChangedAuxiliar(false);
				
				pedidodetaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoDetaProdu(PedidoDetaProdu pedidodetaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			pedidodetaprodu.setcantidad(0);
			pedidodetaprodu.setcantidad_pendiente(0);
		}
	}		
	
	public static void InicializarValoresPedidoDetaProdus(List<PedidoDetaProdu> pedidodetaprodus,Boolean conEnteros) throws Exception  {
		
		for(PedidoDetaProdu pedidodetaprodu: pedidodetaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				pedidodetaprodu.setcantidad(0);
				pedidodetaprodu.setcantidad_pendiente(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoDetaProdu(List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProdu pedidodetaproduAux) throws Exception  {
		PedidoDetaProduConstantesFunciones.InicializarValoresPedidoDetaProdu(pedidodetaproduAux,true);
		
		for(PedidoDetaProdu pedidodetaprodu: pedidodetaprodus) {
			if(pedidodetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidodetaproduAux.setcantidad(pedidodetaproduAux.getcantidad()+pedidodetaprodu.getcantidad());			
			pedidodetaproduAux.setcantidad_pendiente(pedidodetaproduAux.getcantidad_pendiente()+pedidodetaprodu.getcantidad_pendiente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoDetaProduConstantesFunciones.getArrayColumnasGlobalesPedidoDetaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoDetaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoDetaProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoDetaProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoDetaProduConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoDetaProduConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoDetaProduConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoDetaProduConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoDetaProduConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProdu pedidodetaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoDetaProdu pedidodetaproduAux: pedidodetaprodus) {
			if(pedidodetaproduAux!=null && pedidodetaprodu!=null) {
				if((pedidodetaproduAux.getId()==null && pedidodetaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidodetaproduAux.getId()!=null && pedidodetaprodu.getId()!=null){
					if(pedidodetaproduAux.getId().equals(pedidodetaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoDetaProdu(List<PedidoDetaProdu> pedidodetaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PedidoDetaProdu pedidodetaprodu: pedidodetaprodus) {			
			if(pedidodetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoDetaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_ID, PedidoDetaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_VERSIONROW, PedidoDetaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDEMPRESA, PedidoDetaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDSUCURSAL, PedidoDetaProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDEJERCICIO, PedidoDetaProduConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDPERIODO, PedidoDetaProduConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDPEDIDOPRODU, PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDBODEGA, PedidoDetaProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDPRODUCTO, PedidoDetaProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDUNIDAD, PedidoDetaProduConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO, PedidoDetaProduConstantesFunciones.IDBODEGADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU, PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_CANTIDAD, PedidoDetaProduConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE, PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoDetaProduConstantesFunciones.LABEL_DESCRIPCION, PedidoDetaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoDetaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDBODEGADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoDetaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoDetaProdu() throws Exception  {
		return PedidoDetaProduConstantesFunciones.getTiposSeleccionarPedidoDetaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoDetaProdu(Boolean conFk) throws Exception  {
		return PedidoDetaProduConstantesFunciones.getTiposSeleccionarPedidoDetaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoDetaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDPEDIDOPRODU);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDPEDIDOPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoDetaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoDetaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoDetaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoDetaProdu(PedidoDetaProdu pedidodetaproduAux) throws Exception {
		
			pedidodetaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidodetaproduAux.getEmpresa()));
			pedidodetaproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidodetaproduAux.getSucursal()));
			pedidodetaproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidodetaproduAux.getEjercicio()));
			pedidodetaproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidodetaproduAux.getPeriodo()));
			pedidodetaproduAux.setpedidoprodu_descripcion(PedidoProduConstantesFunciones.getPedidoProduDescripcion(pedidodetaproduAux.getPedidoProdu()));
			pedidodetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(pedidodetaproduAux.getBodega()));
			pedidodetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(pedidodetaproduAux.getProducto()));
			pedidodetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(pedidodetaproduAux.getUnidad()));
			pedidodetaproduAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(pedidodetaproduAux.getBodegaDestino()));
			pedidodetaproduAux.settipoprocesoprodu_descripcion(TipoProcesoProduConstantesFunciones.getTipoProcesoProduDescripcion(pedidodetaproduAux.getTipoProcesoProdu()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoDetaProdu(List<PedidoDetaProdu> pedidodetaprodusTemp) throws Exception {
		for(PedidoDetaProdu pedidodetaproduAux:pedidodetaprodusTemp) {
			
			pedidodetaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidodetaproduAux.getEmpresa()));
			pedidodetaproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidodetaproduAux.getSucursal()));
			pedidodetaproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidodetaproduAux.getEjercicio()));
			pedidodetaproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidodetaproduAux.getPeriodo()));
			pedidodetaproduAux.setpedidoprodu_descripcion(PedidoProduConstantesFunciones.getPedidoProduDescripcion(pedidodetaproduAux.getPedidoProdu()));
			pedidodetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(pedidodetaproduAux.getBodega()));
			pedidodetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(pedidodetaproduAux.getProducto()));
			pedidodetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(pedidodetaproduAux.getUnidad()));
			pedidodetaproduAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(pedidodetaproduAux.getBodegaDestino()));
			pedidodetaproduAux.settipoprocesoprodu_descripcion(TipoProcesoProduConstantesFunciones.getTipoProcesoProduDescripcion(pedidodetaproduAux.getTipoProcesoProdu()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(PedidoProdu.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(TipoProcesoProdu.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoProdu.class)) {
						classes.add(new Classe(PedidoProdu.class));
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
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProcesoProdu.class)) {
						classes.add(new Classe(TipoProcesoProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoProcesoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoProdu.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoProcesoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoDetaProduConstantesFunciones.getClassesRelationshipsOfPedidoDetaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoDetaProduConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoDetaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PedidoDetaProdu pedidodetaprodu,List<PedidoDetaProdu> pedidodetaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoDetaProdu pedidodetaproduEncontrado=null;
			
			for(PedidoDetaProdu pedidodetaproduLocal:pedidodetaprodus) {
				if(pedidodetaproduLocal.getId().equals(pedidodetaprodu.getId())) {
					pedidodetaproduEncontrado=pedidodetaproduLocal;
					
					pedidodetaproduLocal.setIsChanged(pedidodetaprodu.getIsChanged());
					pedidodetaproduLocal.setIsNew(pedidodetaprodu.getIsNew());
					pedidodetaproduLocal.setIsDeleted(pedidodetaprodu.getIsDeleted());
					
					pedidodetaproduLocal.setGeneralEntityOriginal(pedidodetaprodu.getGeneralEntityOriginal());
					
					pedidodetaproduLocal.setId(pedidodetaprodu.getId());	
					pedidodetaproduLocal.setVersionRow(pedidodetaprodu.getVersionRow());	
					pedidodetaproduLocal.setid_empresa(pedidodetaprodu.getid_empresa());	
					pedidodetaproduLocal.setid_sucursal(pedidodetaprodu.getid_sucursal());	
					pedidodetaproduLocal.setid_ejercicio(pedidodetaprodu.getid_ejercicio());	
					pedidodetaproduLocal.setid_periodo(pedidodetaprodu.getid_periodo());	
					pedidodetaproduLocal.setid_pedido_produ(pedidodetaprodu.getid_pedido_produ());	
					pedidodetaproduLocal.setid_bodega(pedidodetaprodu.getid_bodega());	
					pedidodetaproduLocal.setid_producto(pedidodetaprodu.getid_producto());	
					pedidodetaproduLocal.setid_unidad(pedidodetaprodu.getid_unidad());	
					pedidodetaproduLocal.setid_bodega_destino(pedidodetaprodu.getid_bodega_destino());	
					pedidodetaproduLocal.setid_tipo_proceso_produ(pedidodetaprodu.getid_tipo_proceso_produ());	
					pedidodetaproduLocal.setcantidad(pedidodetaprodu.getcantidad());	
					pedidodetaproduLocal.setcantidad_pendiente(pedidodetaprodu.getcantidad_pendiente());	
					pedidodetaproduLocal.setdescripcion(pedidodetaprodu.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!pedidodetaprodu.getIsDeleted()) {
				if(!existe) {
					pedidodetaprodus.add(pedidodetaprodu);
				}
			} else {
				if(pedidodetaproduEncontrado!=null && permiteQuitar)  {
					pedidodetaprodus.remove(pedidodetaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoDetaProdu pedidodetaprodu,List<PedidoDetaProdu> pedidodetaprodus) throws Exception {
		try	{			
			for(PedidoDetaProdu pedidodetaproduLocal:pedidodetaprodus) {
				if(pedidodetaproduLocal.getId().equals(pedidodetaprodu.getId())) {
					pedidodetaproduLocal.setIsSelected(pedidodetaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoDetaProdu(List<PedidoDetaProdu> pedidodetaprodusAux) throws Exception {
		//this.pedidodetaprodusAux=pedidodetaprodusAux;
		
		for(PedidoDetaProdu pedidodetaproduAux:pedidodetaprodusAux) {
			if(pedidodetaproduAux.getIsChanged()) {
				pedidodetaproduAux.setIsChanged(false);
			}		
			
			if(pedidodetaproduAux.getIsNew()) {
				pedidodetaproduAux.setIsNew(false);
			}	
			
			if(pedidodetaproduAux.getIsDeleted()) {
				pedidodetaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoDetaProdu(PedidoDetaProdu pedidodetaproduAux) throws Exception {
		//this.pedidodetaproduAux=pedidodetaproduAux;
		
			if(pedidodetaproduAux.getIsChanged()) {
				pedidodetaproduAux.setIsChanged(false);
			}		
			
			if(pedidodetaproduAux.getIsNew()) {
				pedidodetaproduAux.setIsNew(false);
			}	
			
			if(pedidodetaproduAux.getIsDeleted()) {
				pedidodetaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoDetaProdu pedidodetaproduAsignar,PedidoDetaProdu pedidodetaprodu) throws Exception {
		pedidodetaproduAsignar.setId(pedidodetaprodu.getId());	
		pedidodetaproduAsignar.setVersionRow(pedidodetaprodu.getVersionRow());	
		pedidodetaproduAsignar.setid_empresa(pedidodetaprodu.getid_empresa());
		pedidodetaproduAsignar.setempresa_descripcion(pedidodetaprodu.getempresa_descripcion());	
		pedidodetaproduAsignar.setid_sucursal(pedidodetaprodu.getid_sucursal());
		pedidodetaproduAsignar.setsucursal_descripcion(pedidodetaprodu.getsucursal_descripcion());	
		pedidodetaproduAsignar.setid_ejercicio(pedidodetaprodu.getid_ejercicio());
		pedidodetaproduAsignar.setejercicio_descripcion(pedidodetaprodu.getejercicio_descripcion());	
		pedidodetaproduAsignar.setid_periodo(pedidodetaprodu.getid_periodo());
		pedidodetaproduAsignar.setperiodo_descripcion(pedidodetaprodu.getperiodo_descripcion());	
		pedidodetaproduAsignar.setid_pedido_produ(pedidodetaprodu.getid_pedido_produ());
		pedidodetaproduAsignar.setpedidoprodu_descripcion(pedidodetaprodu.getpedidoprodu_descripcion());	
		pedidodetaproduAsignar.setid_bodega(pedidodetaprodu.getid_bodega());
		pedidodetaproduAsignar.setbodega_descripcion(pedidodetaprodu.getbodega_descripcion());	
		pedidodetaproduAsignar.setid_producto(pedidodetaprodu.getid_producto());
		pedidodetaproduAsignar.setproducto_descripcion(pedidodetaprodu.getproducto_descripcion());	
		pedidodetaproduAsignar.setid_unidad(pedidodetaprodu.getid_unidad());
		pedidodetaproduAsignar.setunidad_descripcion(pedidodetaprodu.getunidad_descripcion());	
		pedidodetaproduAsignar.setid_bodega_destino(pedidodetaprodu.getid_bodega_destino());
		pedidodetaproduAsignar.setbodegadestino_descripcion(pedidodetaprodu.getbodegadestino_descripcion());	
		pedidodetaproduAsignar.setid_tipo_proceso_produ(pedidodetaprodu.getid_tipo_proceso_produ());
		pedidodetaproduAsignar.settipoprocesoprodu_descripcion(pedidodetaprodu.gettipoprocesoprodu_descripcion());	
		pedidodetaproduAsignar.setcantidad(pedidodetaprodu.getcantidad());	
		pedidodetaproduAsignar.setcantidad_pendiente(pedidodetaprodu.getcantidad_pendiente());	
		pedidodetaproduAsignar.setdescripcion(pedidodetaprodu.getdescripcion());	
	}
	
	public static void inicializarPedidoDetaProdu(PedidoDetaProdu pedidodetaprodu) throws Exception {
		try {
				pedidodetaprodu.setId(0L);	
					
				pedidodetaprodu.setid_empresa(-1L);	
				pedidodetaprodu.setid_sucursal(-1L);	
				pedidodetaprodu.setid_ejercicio(-1L);	
				pedidodetaprodu.setid_periodo(-1L);	
				pedidodetaprodu.setid_pedido_produ(-1L);	
				pedidodetaprodu.setid_bodega(-1L);	
				pedidodetaprodu.setid_producto(-1L);	
				pedidodetaprodu.setid_unidad(-1L);	
				pedidodetaprodu.setid_bodega_destino(-1L);	
				pedidodetaprodu.setid_tipo_proceso_produ(-1L);	
				pedidodetaprodu.setcantidad(0);	
				pedidodetaprodu.setcantidad_pendiente(0);	
				pedidodetaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoDetaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDPEDIDOPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoDetaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoDetaProdu(String sTipo,Row row,Workbook workbook,PedidoDetaProdu pedidodetaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getpedidoprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getbodegadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.gettipoprocesoprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidodetaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoDetaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoDetaProdu() {
		return this.sFinalQueryPedidoDetaProdu;
	}
	
	public void setsFinalQueryPedidoDetaProdu(String sFinalQueryPedidoDetaProdu) {
		this.sFinalQueryPedidoDetaProdu= sFinalQueryPedidoDetaProdu;
	}
	
	public Border resaltarSeleccionarPedidoDetaProdu=null;
	
	public Border setResaltarSeleccionarPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoDetaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoDetaProdu() {
		return this.resaltarSeleccionarPedidoDetaProdu;
	}
	
	public void setResaltarSeleccionarPedidoDetaProdu(Border borderResaltarSeleccionarPedidoDetaProdu) {
		this.resaltarSeleccionarPedidoDetaProdu= borderResaltarSeleccionarPedidoDetaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoDetaProdu=null;
	public Boolean mostraridPedidoDetaProdu=true;
	public Boolean activaridPedidoDetaProdu=true;

	public Border resaltarid_empresaPedidoDetaProdu=null;
	public Boolean mostrarid_empresaPedidoDetaProdu=true;
	public Boolean activarid_empresaPedidoDetaProdu=true;
	public Boolean cargarid_empresaPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoDetaProdu=null;
	public Boolean mostrarid_sucursalPedidoDetaProdu=true;
	public Boolean activarid_sucursalPedidoDetaProdu=true;
	public Boolean cargarid_sucursalPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedidoDetaProdu=null;
	public Boolean mostrarid_ejercicioPedidoDetaProdu=true;
	public Boolean activarid_ejercicioPedidoDetaProdu=true;
	public Boolean cargarid_ejercicioPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_periodoPedidoDetaProdu=null;
	public Boolean mostrarid_periodoPedidoDetaProdu=true;
	public Boolean activarid_periodoPedidoDetaProdu=true;
	public Boolean cargarid_periodoPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_pedido_produPedidoDetaProdu=null;
	public Boolean mostrarid_pedido_produPedidoDetaProdu=true;
	public Boolean activarid_pedido_produPedidoDetaProdu=true;
	public Boolean cargarid_pedido_produPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_produPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaPedidoDetaProdu=null;
	public Boolean mostrarid_bodegaPedidoDetaProdu=true;
	public Boolean activarid_bodegaPedidoDetaProdu=true;
	public Boolean cargarid_bodegaPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_productoPedidoDetaProdu=null;
	public Boolean mostrarid_productoPedidoDetaProdu=true;
	public Boolean activarid_productoPedidoDetaProdu=true;
	public Boolean cargarid_productoPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPedidoDetaProdu=true;//ConEventDepend=true

	public Border resaltarid_unidadPedidoDetaProdu=null;
	public Boolean mostrarid_unidadPedidoDetaProdu=true;
	public Boolean activarid_unidadPedidoDetaProdu=true;
	public Boolean cargarid_unidadPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadPedidoDetaProdu=true;//ConEventDepend=true

	public Border resaltarid_bodega_destinoPedidoDetaProdu=null;
	public Boolean mostrarid_bodega_destinoPedidoDetaProdu=true;
	public Boolean activarid_bodega_destinoPedidoDetaProdu=true;
	public Boolean cargarid_bodega_destinoPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_destinoPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_produPedidoDetaProdu=null;
	public Boolean mostrarid_tipo_proceso_produPedidoDetaProdu=true;
	public Boolean activarid_tipo_proceso_produPedidoDetaProdu=true;
	public Boolean cargarid_tipo_proceso_produPedidoDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_produPedidoDetaProdu=false;//ConEventDepend=true

	public Border resaltarcantidadPedidoDetaProdu=null;
	public Boolean mostrarcantidadPedidoDetaProdu=true;
	public Boolean activarcantidadPedidoDetaProdu=true;

	public Border resaltarcantidad_pendientePedidoDetaProdu=null;
	public Boolean mostrarcantidad_pendientePedidoDetaProdu=true;
	public Boolean activarcantidad_pendientePedidoDetaProdu=true;

	public Border resaltardescripcionPedidoDetaProdu=null;
	public Boolean mostrardescripcionPedidoDetaProdu=true;
	public Boolean activardescripcionPedidoDetaProdu=true;

	
	

	public Border setResaltaridPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltaridPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoDetaProdu() {
		return this.resaltaridPedidoDetaProdu;
	}

	public void setResaltaridPedidoDetaProdu(Border borderResaltar) {
		this.resaltaridPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostraridPedidoDetaProdu() {
		return this.mostraridPedidoDetaProdu;
	}

	public void setMostraridPedidoDetaProdu(Boolean mostraridPedidoDetaProdu) {
		this.mostraridPedidoDetaProdu= mostraridPedidoDetaProdu;
	}

	public Boolean getActivaridPedidoDetaProdu() {
		return this.activaridPedidoDetaProdu;
	}

	public void setActivaridPedidoDetaProdu(Boolean activaridPedidoDetaProdu) {
		this.activaridPedidoDetaProdu= activaridPedidoDetaProdu;
	}

	public Border setResaltarid_empresaPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoDetaProdu() {
		return this.resaltarid_empresaPedidoDetaProdu;
	}

	public void setResaltarid_empresaPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_empresaPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoDetaProdu() {
		return this.mostrarid_empresaPedidoDetaProdu;
	}

	public void setMostrarid_empresaPedidoDetaProdu(Boolean mostrarid_empresaPedidoDetaProdu) {
		this.mostrarid_empresaPedidoDetaProdu= mostrarid_empresaPedidoDetaProdu;
	}

	public Boolean getActivarid_empresaPedidoDetaProdu() {
		return this.activarid_empresaPedidoDetaProdu;
	}

	public void setActivarid_empresaPedidoDetaProdu(Boolean activarid_empresaPedidoDetaProdu) {
		this.activarid_empresaPedidoDetaProdu= activarid_empresaPedidoDetaProdu;
	}

	public Boolean getCargarid_empresaPedidoDetaProdu() {
		return this.cargarid_empresaPedidoDetaProdu;
	}

	public void setCargarid_empresaPedidoDetaProdu(Boolean cargarid_empresaPedidoDetaProdu) {
		this.cargarid_empresaPedidoDetaProdu= cargarid_empresaPedidoDetaProdu;
	}

	public Border setResaltarid_sucursalPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoDetaProdu() {
		return this.resaltarid_sucursalPedidoDetaProdu;
	}

	public void setResaltarid_sucursalPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_sucursalPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoDetaProdu() {
		return this.mostrarid_sucursalPedidoDetaProdu;
	}

	public void setMostrarid_sucursalPedidoDetaProdu(Boolean mostrarid_sucursalPedidoDetaProdu) {
		this.mostrarid_sucursalPedidoDetaProdu= mostrarid_sucursalPedidoDetaProdu;
	}

	public Boolean getActivarid_sucursalPedidoDetaProdu() {
		return this.activarid_sucursalPedidoDetaProdu;
	}

	public void setActivarid_sucursalPedidoDetaProdu(Boolean activarid_sucursalPedidoDetaProdu) {
		this.activarid_sucursalPedidoDetaProdu= activarid_sucursalPedidoDetaProdu;
	}

	public Boolean getCargarid_sucursalPedidoDetaProdu() {
		return this.cargarid_sucursalPedidoDetaProdu;
	}

	public void setCargarid_sucursalPedidoDetaProdu(Boolean cargarid_sucursalPedidoDetaProdu) {
		this.cargarid_sucursalPedidoDetaProdu= cargarid_sucursalPedidoDetaProdu;
	}

	public Border setResaltarid_ejercicioPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedidoDetaProdu() {
		return this.resaltarid_ejercicioPedidoDetaProdu;
	}

	public void setResaltarid_ejercicioPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_ejercicioPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedidoDetaProdu() {
		return this.mostrarid_ejercicioPedidoDetaProdu;
	}

	public void setMostrarid_ejercicioPedidoDetaProdu(Boolean mostrarid_ejercicioPedidoDetaProdu) {
		this.mostrarid_ejercicioPedidoDetaProdu= mostrarid_ejercicioPedidoDetaProdu;
	}

	public Boolean getActivarid_ejercicioPedidoDetaProdu() {
		return this.activarid_ejercicioPedidoDetaProdu;
	}

	public void setActivarid_ejercicioPedidoDetaProdu(Boolean activarid_ejercicioPedidoDetaProdu) {
		this.activarid_ejercicioPedidoDetaProdu= activarid_ejercicioPedidoDetaProdu;
	}

	public Boolean getCargarid_ejercicioPedidoDetaProdu() {
		return this.cargarid_ejercicioPedidoDetaProdu;
	}

	public void setCargarid_ejercicioPedidoDetaProdu(Boolean cargarid_ejercicioPedidoDetaProdu) {
		this.cargarid_ejercicioPedidoDetaProdu= cargarid_ejercicioPedidoDetaProdu;
	}

	public Border setResaltarid_periodoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedidoDetaProdu() {
		return this.resaltarid_periodoPedidoDetaProdu;
	}

	public void setResaltarid_periodoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_periodoPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedidoDetaProdu() {
		return this.mostrarid_periodoPedidoDetaProdu;
	}

	public void setMostrarid_periodoPedidoDetaProdu(Boolean mostrarid_periodoPedidoDetaProdu) {
		this.mostrarid_periodoPedidoDetaProdu= mostrarid_periodoPedidoDetaProdu;
	}

	public Boolean getActivarid_periodoPedidoDetaProdu() {
		return this.activarid_periodoPedidoDetaProdu;
	}

	public void setActivarid_periodoPedidoDetaProdu(Boolean activarid_periodoPedidoDetaProdu) {
		this.activarid_periodoPedidoDetaProdu= activarid_periodoPedidoDetaProdu;
	}

	public Boolean getCargarid_periodoPedidoDetaProdu() {
		return this.cargarid_periodoPedidoDetaProdu;
	}

	public void setCargarid_periodoPedidoDetaProdu(Boolean cargarid_periodoPedidoDetaProdu) {
		this.cargarid_periodoPedidoDetaProdu= cargarid_periodoPedidoDetaProdu;
	}

	public Border setResaltarid_pedido_produPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_pedido_produPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_produPedidoDetaProdu() {
		return this.resaltarid_pedido_produPedidoDetaProdu;
	}

	public void setResaltarid_pedido_produPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_pedido_produPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_pedido_produPedidoDetaProdu() {
		return this.mostrarid_pedido_produPedidoDetaProdu;
	}

	public void setMostrarid_pedido_produPedidoDetaProdu(Boolean mostrarid_pedido_produPedidoDetaProdu) {
		this.mostrarid_pedido_produPedidoDetaProdu= mostrarid_pedido_produPedidoDetaProdu;
	}

	public Boolean getActivarid_pedido_produPedidoDetaProdu() {
		return this.activarid_pedido_produPedidoDetaProdu;
	}

	public void setActivarid_pedido_produPedidoDetaProdu(Boolean activarid_pedido_produPedidoDetaProdu) {
		this.activarid_pedido_produPedidoDetaProdu= activarid_pedido_produPedidoDetaProdu;
	}

	public Boolean getCargarid_pedido_produPedidoDetaProdu() {
		return this.cargarid_pedido_produPedidoDetaProdu;
	}

	public void setCargarid_pedido_produPedidoDetaProdu(Boolean cargarid_pedido_produPedidoDetaProdu) {
		this.cargarid_pedido_produPedidoDetaProdu= cargarid_pedido_produPedidoDetaProdu;
	}

	public Border setResaltarid_bodegaPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaPedidoDetaProdu() {
		return this.resaltarid_bodegaPedidoDetaProdu;
	}

	public void setResaltarid_bodegaPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_bodegaPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaPedidoDetaProdu() {
		return this.mostrarid_bodegaPedidoDetaProdu;
	}

	public void setMostrarid_bodegaPedidoDetaProdu(Boolean mostrarid_bodegaPedidoDetaProdu) {
		this.mostrarid_bodegaPedidoDetaProdu= mostrarid_bodegaPedidoDetaProdu;
	}

	public Boolean getActivarid_bodegaPedidoDetaProdu() {
		return this.activarid_bodegaPedidoDetaProdu;
	}

	public void setActivarid_bodegaPedidoDetaProdu(Boolean activarid_bodegaPedidoDetaProdu) {
		this.activarid_bodegaPedidoDetaProdu= activarid_bodegaPedidoDetaProdu;
	}

	public Boolean getCargarid_bodegaPedidoDetaProdu() {
		return this.cargarid_bodegaPedidoDetaProdu;
	}

	public void setCargarid_bodegaPedidoDetaProdu(Boolean cargarid_bodegaPedidoDetaProdu) {
		this.cargarid_bodegaPedidoDetaProdu= cargarid_bodegaPedidoDetaProdu;
	}

	public Border setResaltarid_productoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPedidoDetaProdu() {
		return this.resaltarid_productoPedidoDetaProdu;
	}

	public void setResaltarid_productoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_productoPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoPedidoDetaProdu() {
		return this.mostrarid_productoPedidoDetaProdu;
	}

	public void setMostrarid_productoPedidoDetaProdu(Boolean mostrarid_productoPedidoDetaProdu) {
		this.mostrarid_productoPedidoDetaProdu= mostrarid_productoPedidoDetaProdu;
	}

	public Boolean getActivarid_productoPedidoDetaProdu() {
		return this.activarid_productoPedidoDetaProdu;
	}

	public void setActivarid_productoPedidoDetaProdu(Boolean activarid_productoPedidoDetaProdu) {
		this.activarid_productoPedidoDetaProdu= activarid_productoPedidoDetaProdu;
	}

	public Boolean getCargarid_productoPedidoDetaProdu() {
		return this.cargarid_productoPedidoDetaProdu;
	}

	public void setCargarid_productoPedidoDetaProdu(Boolean cargarid_productoPedidoDetaProdu) {
		this.cargarid_productoPedidoDetaProdu= cargarid_productoPedidoDetaProdu;
	}

	public Border setResaltarid_unidadPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_unidadPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadPedidoDetaProdu() {
		return this.resaltarid_unidadPedidoDetaProdu;
	}

	public void setResaltarid_unidadPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_unidadPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_unidadPedidoDetaProdu() {
		return this.mostrarid_unidadPedidoDetaProdu;
	}

	public void setMostrarid_unidadPedidoDetaProdu(Boolean mostrarid_unidadPedidoDetaProdu) {
		this.mostrarid_unidadPedidoDetaProdu= mostrarid_unidadPedidoDetaProdu;
	}

	public Boolean getActivarid_unidadPedidoDetaProdu() {
		return this.activarid_unidadPedidoDetaProdu;
	}

	public void setActivarid_unidadPedidoDetaProdu(Boolean activarid_unidadPedidoDetaProdu) {
		this.activarid_unidadPedidoDetaProdu= activarid_unidadPedidoDetaProdu;
	}

	public Boolean getCargarid_unidadPedidoDetaProdu() {
		return this.cargarid_unidadPedidoDetaProdu;
	}

	public void setCargarid_unidadPedidoDetaProdu(Boolean cargarid_unidadPedidoDetaProdu) {
		this.cargarid_unidadPedidoDetaProdu= cargarid_unidadPedidoDetaProdu;
	}

	public Border setResaltarid_bodega_destinoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodega_destinoPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_destinoPedidoDetaProdu() {
		return this.resaltarid_bodega_destinoPedidoDetaProdu;
	}

	public void setResaltarid_bodega_destinoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_bodega_destinoPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodega_destinoPedidoDetaProdu() {
		return this.mostrarid_bodega_destinoPedidoDetaProdu;
	}

	public void setMostrarid_bodega_destinoPedidoDetaProdu(Boolean mostrarid_bodega_destinoPedidoDetaProdu) {
		this.mostrarid_bodega_destinoPedidoDetaProdu= mostrarid_bodega_destinoPedidoDetaProdu;
	}

	public Boolean getActivarid_bodega_destinoPedidoDetaProdu() {
		return this.activarid_bodega_destinoPedidoDetaProdu;
	}

	public void setActivarid_bodega_destinoPedidoDetaProdu(Boolean activarid_bodega_destinoPedidoDetaProdu) {
		this.activarid_bodega_destinoPedidoDetaProdu= activarid_bodega_destinoPedidoDetaProdu;
	}

	public Boolean getCargarid_bodega_destinoPedidoDetaProdu() {
		return this.cargarid_bodega_destinoPedidoDetaProdu;
	}

	public void setCargarid_bodega_destinoPedidoDetaProdu(Boolean cargarid_bodega_destinoPedidoDetaProdu) {
		this.cargarid_bodega_destinoPedidoDetaProdu= cargarid_bodega_destinoPedidoDetaProdu;
	}

	public Border setResaltarid_tipo_proceso_produPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_produPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_produPedidoDetaProdu() {
		return this.resaltarid_tipo_proceso_produPedidoDetaProdu;
	}

	public void setResaltarid_tipo_proceso_produPedidoDetaProdu(Border borderResaltar) {
		this.resaltarid_tipo_proceso_produPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_produPedidoDetaProdu() {
		return this.mostrarid_tipo_proceso_produPedidoDetaProdu;
	}

	public void setMostrarid_tipo_proceso_produPedidoDetaProdu(Boolean mostrarid_tipo_proceso_produPedidoDetaProdu) {
		this.mostrarid_tipo_proceso_produPedidoDetaProdu= mostrarid_tipo_proceso_produPedidoDetaProdu;
	}

	public Boolean getActivarid_tipo_proceso_produPedidoDetaProdu() {
		return this.activarid_tipo_proceso_produPedidoDetaProdu;
	}

	public void setActivarid_tipo_proceso_produPedidoDetaProdu(Boolean activarid_tipo_proceso_produPedidoDetaProdu) {
		this.activarid_tipo_proceso_produPedidoDetaProdu= activarid_tipo_proceso_produPedidoDetaProdu;
	}

	public Boolean getCargarid_tipo_proceso_produPedidoDetaProdu() {
		return this.cargarid_tipo_proceso_produPedidoDetaProdu;
	}

	public void setCargarid_tipo_proceso_produPedidoDetaProdu(Boolean cargarid_tipo_proceso_produPedidoDetaProdu) {
		this.cargarid_tipo_proceso_produPedidoDetaProdu= cargarid_tipo_proceso_produPedidoDetaProdu;
	}

	public Border setResaltarcantidadPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcantidadPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadPedidoDetaProdu() {
		return this.resaltarcantidadPedidoDetaProdu;
	}

	public void setResaltarcantidadPedidoDetaProdu(Border borderResaltar) {
		this.resaltarcantidadPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcantidadPedidoDetaProdu() {
		return this.mostrarcantidadPedidoDetaProdu;
	}

	public void setMostrarcantidadPedidoDetaProdu(Boolean mostrarcantidadPedidoDetaProdu) {
		this.mostrarcantidadPedidoDetaProdu= mostrarcantidadPedidoDetaProdu;
	}

	public Boolean getActivarcantidadPedidoDetaProdu() {
		return this.activarcantidadPedidoDetaProdu;
	}

	public void setActivarcantidadPedidoDetaProdu(Boolean activarcantidadPedidoDetaProdu) {
		this.activarcantidadPedidoDetaProdu= activarcantidadPedidoDetaProdu;
	}

	public Border setResaltarcantidad_pendientePedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendientePedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendientePedidoDetaProdu() {
		return this.resaltarcantidad_pendientePedidoDetaProdu;
	}

	public void setResaltarcantidad_pendientePedidoDetaProdu(Border borderResaltar) {
		this.resaltarcantidad_pendientePedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendientePedidoDetaProdu() {
		return this.mostrarcantidad_pendientePedidoDetaProdu;
	}

	public void setMostrarcantidad_pendientePedidoDetaProdu(Boolean mostrarcantidad_pendientePedidoDetaProdu) {
		this.mostrarcantidad_pendientePedidoDetaProdu= mostrarcantidad_pendientePedidoDetaProdu;
	}

	public Boolean getActivarcantidad_pendientePedidoDetaProdu() {
		return this.activarcantidad_pendientePedidoDetaProdu;
	}

	public void setActivarcantidad_pendientePedidoDetaProdu(Boolean activarcantidad_pendientePedidoDetaProdu) {
		this.activarcantidad_pendientePedidoDetaProdu= activarcantidad_pendientePedidoDetaProdu;
	}

	public Border setResaltardescripcionPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidodetaproduBeanSwingJInternalFrame.jTtoolBarPedidoDetaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionPedidoDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedidoDetaProdu() {
		return this.resaltardescripcionPedidoDetaProdu;
	}

	public void setResaltardescripcionPedidoDetaProdu(Border borderResaltar) {
		this.resaltardescripcionPedidoDetaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionPedidoDetaProdu() {
		return this.mostrardescripcionPedidoDetaProdu;
	}

	public void setMostrardescripcionPedidoDetaProdu(Boolean mostrardescripcionPedidoDetaProdu) {
		this.mostrardescripcionPedidoDetaProdu= mostrardescripcionPedidoDetaProdu;
	}

	public Boolean getActivardescripcionPedidoDetaProdu() {
		return this.activardescripcionPedidoDetaProdu;
	}

	public void setActivardescripcionPedidoDetaProdu(Boolean activardescripcionPedidoDetaProdu) {
		this.activardescripcionPedidoDetaProdu= activardescripcionPedidoDetaProdu;
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
		
		
		this.setMostraridPedidoDetaProdu(esInicial);
		this.setMostrarid_empresaPedidoDetaProdu(esInicial);
		this.setMostrarid_sucursalPedidoDetaProdu(esInicial);
		this.setMostrarid_ejercicioPedidoDetaProdu(esInicial);
		this.setMostrarid_periodoPedidoDetaProdu(esInicial);
		this.setMostrarid_pedido_produPedidoDetaProdu(esInicial);
		this.setMostrarid_bodegaPedidoDetaProdu(esInicial);
		this.setMostrarid_productoPedidoDetaProdu(esInicial);
		this.setMostrarid_unidadPedidoDetaProdu(esInicial);
		this.setMostrarid_bodega_destinoPedidoDetaProdu(esInicial);
		this.setMostrarid_tipo_proceso_produPedidoDetaProdu(esInicial);
		this.setMostrarcantidadPedidoDetaProdu(esInicial);
		this.setMostrarcantidad_pendientePedidoDetaProdu(esInicial);
		this.setMostrardescripcionPedidoDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.ID)) {
				this.setMostraridPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU)) {
				this.setMostrarid_pedido_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setMostrarid_bodega_destinoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setMostrarid_tipo_proceso_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendientePedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedidoDetaProdu(esAsigna);
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
		
		
		this.setActivaridPedidoDetaProdu(esInicial);
		this.setActivarid_empresaPedidoDetaProdu(esInicial);
		this.setActivarid_sucursalPedidoDetaProdu(esInicial);
		this.setActivarid_ejercicioPedidoDetaProdu(esInicial);
		this.setActivarid_periodoPedidoDetaProdu(esInicial);
		this.setActivarid_pedido_produPedidoDetaProdu(esInicial);
		this.setActivarid_bodegaPedidoDetaProdu(esInicial);
		this.setActivarid_productoPedidoDetaProdu(esInicial);
		this.setActivarid_unidadPedidoDetaProdu(esInicial);
		this.setActivarid_bodega_destinoPedidoDetaProdu(esInicial);
		this.setActivarid_tipo_proceso_produPedidoDetaProdu(esInicial);
		this.setActivarcantidadPedidoDetaProdu(esInicial);
		this.setActivarcantidad_pendientePedidoDetaProdu(esInicial);
		this.setActivardescripcionPedidoDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.ID)) {
				this.setActivaridPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU)) {
				this.setActivarid_pedido_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setActivarid_bodega_destinoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setActivarid_tipo_proceso_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendientePedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedidoDetaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoDetaProdu(esInicial);
		this.setResaltarid_empresaPedidoDetaProdu(esInicial);
		this.setResaltarid_sucursalPedidoDetaProdu(esInicial);
		this.setResaltarid_ejercicioPedidoDetaProdu(esInicial);
		this.setResaltarid_periodoPedidoDetaProdu(esInicial);
		this.setResaltarid_pedido_produPedidoDetaProdu(esInicial);
		this.setResaltarid_bodegaPedidoDetaProdu(esInicial);
		this.setResaltarid_productoPedidoDetaProdu(esInicial);
		this.setResaltarid_unidadPedidoDetaProdu(esInicial);
		this.setResaltarid_bodega_destinoPedidoDetaProdu(esInicial);
		this.setResaltarid_tipo_proceso_produPedidoDetaProdu(esInicial);
		this.setResaltarcantidadPedidoDetaProdu(esInicial);
		this.setResaltarcantidad_pendientePedidoDetaProdu(esInicial);
		this.setResaltardescripcionPedidoDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.ID)) {
				this.setResaltaridPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU)) {
				this.setResaltarid_pedido_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setResaltarid_bodega_destinoPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setResaltarid_tipo_proceso_produPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadPedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendientePedidoDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedidoDetaProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdBodegaPedidoDetaProdu() {
		return this.mostrarFK_IdBodegaPedidoDetaProdu;
	}

	public void setMostrarFK_IdBodegaPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaDestinoPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdBodegaDestinoPedidoDetaProdu() {
		return this.mostrarFK_IdBodegaDestinoPedidoDetaProdu;
	}

	public void setMostrarFK_IdBodegaDestinoPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDestinoPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdEjercicioPedidoDetaProdu() {
		return this.mostrarFK_IdEjercicioPedidoDetaProdu;
	}

	public void setMostrarFK_IdEjercicioPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdEmpresaPedidoDetaProdu() {
		return this.mostrarFK_IdEmpresaPedidoDetaProdu;
	}

	public void setMostrarFK_IdEmpresaPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoProduPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdPedidoProduPedidoDetaProdu() {
		return this.mostrarFK_IdPedidoProduPedidoDetaProdu;
	}

	public void setMostrarFK_IdPedidoProduPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoProduPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdPeriodoPedidoDetaProdu() {
		return this.mostrarFK_IdPeriodoPedidoDetaProdu;
	}

	public void setMostrarFK_IdPeriodoPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdProductoPedidoDetaProdu() {
		return this.mostrarFK_IdProductoPedidoDetaProdu;
	}

	public void setMostrarFK_IdProductoPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdSucursalPedidoDetaProdu() {
		return this.mostrarFK_IdSucursalPedidoDetaProdu;
	}

	public void setMostrarFK_IdSucursalPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoProduPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdTipoProcesoProduPedidoDetaProdu() {
		return this.mostrarFK_IdTipoProcesoProduPedidoDetaProdu;
	}

	public void setMostrarFK_IdTipoProcesoProduPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoProduPedidoDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadPedidoDetaProdu=true;

	public Boolean getMostrarFK_IdUnidadPedidoDetaProdu() {
		return this.mostrarFK_IdUnidadPedidoDetaProdu;
	}

	public void setMostrarFK_IdUnidadPedidoDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadPedidoDetaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaPedidoDetaProdu=true;

	public Boolean getActivarFK_IdBodegaPedidoDetaProdu() {
		return this.activarFK_IdBodegaPedidoDetaProdu;
	}

	public void setActivarFK_IdBodegaPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaDestinoPedidoDetaProdu=true;

	public Boolean getActivarFK_IdBodegaDestinoPedidoDetaProdu() {
		return this.activarFK_IdBodegaDestinoPedidoDetaProdu;
	}

	public void setActivarFK_IdBodegaDestinoPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDestinoPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedidoDetaProdu=true;

	public Boolean getActivarFK_IdEjercicioPedidoDetaProdu() {
		return this.activarFK_IdEjercicioPedidoDetaProdu;
	}

	public void setActivarFK_IdEjercicioPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoDetaProdu=true;

	public Boolean getActivarFK_IdEmpresaPedidoDetaProdu() {
		return this.activarFK_IdEmpresaPedidoDetaProdu;
	}

	public void setActivarFK_IdEmpresaPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoProduPedidoDetaProdu=true;

	public Boolean getActivarFK_IdPedidoProduPedidoDetaProdu() {
		return this.activarFK_IdPedidoProduPedidoDetaProdu;
	}

	public void setActivarFK_IdPedidoProduPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoProduPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedidoDetaProdu=true;

	public Boolean getActivarFK_IdPeriodoPedidoDetaProdu() {
		return this.activarFK_IdPeriodoPedidoDetaProdu;
	}

	public void setActivarFK_IdPeriodoPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPedidoDetaProdu=true;

	public Boolean getActivarFK_IdProductoPedidoDetaProdu() {
		return this.activarFK_IdProductoPedidoDetaProdu;
	}

	public void setActivarFK_IdProductoPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoDetaProdu=true;

	public Boolean getActivarFK_IdSucursalPedidoDetaProdu() {
		return this.activarFK_IdSucursalPedidoDetaProdu;
	}

	public void setActivarFK_IdSucursalPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoProduPedidoDetaProdu=true;

	public Boolean getActivarFK_IdTipoProcesoProduPedidoDetaProdu() {
		return this.activarFK_IdTipoProcesoProduPedidoDetaProdu;
	}

	public void setActivarFK_IdTipoProcesoProduPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoProduPedidoDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadPedidoDetaProdu=true;

	public Boolean getActivarFK_IdUnidadPedidoDetaProdu() {
		return this.activarFK_IdUnidadPedidoDetaProdu;
	}

	public void setActivarFK_IdUnidadPedidoDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadPedidoDetaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaPedidoDetaProdu=null;

	public Border getResaltarFK_IdBodegaPedidoDetaProdu() {
		return this.resaltarFK_IdBodegaPedidoDetaProdu;
	}

	public void setResaltarFK_IdBodegaPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdBodegaDestinoPedidoDetaProdu=null;

	public Border getResaltarFK_IdBodegaDestinoPedidoDetaProdu() {
		return this.resaltarFK_IdBodegaDestinoPedidoDetaProdu;
	}

	public void setResaltarFK_IdBodegaDestinoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaDestinoPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDestinoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDestinoPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedidoDetaProdu=null;

	public Border getResaltarFK_IdEjercicioPedidoDetaProdu() {
		return this.resaltarFK_IdEjercicioPedidoDetaProdu;
	}

	public void setResaltarFK_IdEjercicioPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoDetaProdu=null;

	public Border getResaltarFK_IdEmpresaPedidoDetaProdu() {
		return this.resaltarFK_IdEmpresaPedidoDetaProdu;
	}

	public void setResaltarFK_IdEmpresaPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdPedidoProduPedidoDetaProdu=null;

	public Border getResaltarFK_IdPedidoProduPedidoDetaProdu() {
		return this.resaltarFK_IdPedidoProduPedidoDetaProdu;
	}

	public void setResaltarFK_IdPedidoProduPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdPedidoProduPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdPedidoProduPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoProduPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedidoDetaProdu=null;

	public Border getResaltarFK_IdPeriodoPedidoDetaProdu() {
		return this.resaltarFK_IdPeriodoPedidoDetaProdu;
	}

	public void setResaltarFK_IdPeriodoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdProductoPedidoDetaProdu=null;

	public Border getResaltarFK_IdProductoPedidoDetaProdu() {
		return this.resaltarFK_IdProductoPedidoDetaProdu;
	}

	public void setResaltarFK_IdProductoPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdProductoPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdProductoPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoDetaProdu=null;

	public Border getResaltarFK_IdSucursalPedidoDetaProdu() {
		return this.resaltarFK_IdSucursalPedidoDetaProdu;
	}

	public void setResaltarFK_IdSucursalPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoProduPedidoDetaProdu=null;

	public Border getResaltarFK_IdTipoProcesoProduPedidoDetaProdu() {
		return this.resaltarFK_IdTipoProcesoProduPedidoDetaProdu;
	}

	public void setResaltarFK_IdTipoProcesoProduPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoProduPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoProduPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoProduPedidoDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdUnidadPedidoDetaProdu=null;

	public Border getResaltarFK_IdUnidadPedidoDetaProdu() {
		return this.resaltarFK_IdUnidadPedidoDetaProdu;
	}

	public void setResaltarFK_IdUnidadPedidoDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdUnidadPedidoDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdUnidadPedidoDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoDetaProduBeanSwingJInternalFrame pedidodetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadPedidoDetaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}