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


import com.bydan.erp.produccion.util.OrdenDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.OrdenDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.OrdenDetaProduParameterGeneral;

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
final public class OrdenDetaProduConstantesFunciones extends OrdenDetaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="OrdenDetaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="OrdenDetaProdu"+OrdenDetaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="OrdenDetaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="OrdenDetaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=OrdenDetaProduConstantesFunciones.SCHEMA+"_"+OrdenDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/OrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=OrdenDetaProduConstantesFunciones.SCHEMA+"_"+OrdenDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=OrdenDetaProduConstantesFunciones.SCHEMA+"_"+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/OrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=OrdenDetaProduConstantesFunciones.SCHEMA+"_"+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=OrdenDetaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+OrdenDetaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=OrdenDetaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+OrdenDetaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden Detalle Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden Detalle Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Orden Deta Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="OrdenDetaProdu";
	public static final String OBJECTNAME="ordendetaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="orden_deta_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ordendetaprodu from "+OrdenDetaProduConstantesFunciones.SPERSISTENCENAME+" ordendetaprodu";
	public static String QUERYSELECTNATIVE="select "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".version_row,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_empresa,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_periodo,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_orden_produ,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_producto,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega_destino,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_tipo_proceso_produ,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".cantidad,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".cantidad_pendiente,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".descripcion from "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+OrdenDetaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected OrdenDetaProduConstantesFuncionesAdditional ordendetaproduConstantesFuncionesAdditional=null;
	
	public OrdenDetaProduConstantesFuncionesAdditional getOrdenDetaProduConstantesFuncionesAdditional() {
		return this.ordendetaproduConstantesFuncionesAdditional;
	}
	
	public void setOrdenDetaProduConstantesFuncionesAdditional(OrdenDetaProduConstantesFuncionesAdditional ordendetaproduConstantesFuncionesAdditional) {
		try {
			this.ordendetaproduConstantesFuncionesAdditional=ordendetaproduConstantesFuncionesAdditional;
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
    public static final String IDORDENPRODU= "id_orden_produ";
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
    	public static final String LABEL_IDORDENPRODU= "Orden Produ";
		public static final String LABEL_IDORDENPRODU_LOWER= "Orden Produ";
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
	
	public static String getOrdenDetaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDEJERCICIO)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDPERIODO)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDORDENPRODU)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDORDENPRODU;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDBODEGA)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDUNIDAD)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDBODEGADESTINO)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.CANTIDAD)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		if(sNombreColumna.equals(OrdenDetaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=OrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ordendetaprodu !=null/* && ordendetaprodu.getId()!=0*/) {
			if(ordendetaprodu.getId()!=null) {
				sDescripcion=ordendetaprodu.getId().toString();
			}//ordendetaproduordendetaprodu.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getOrdenDetaProduDescripcionDetallado(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion="";
			
		sDescripcion+=OrdenDetaProduConstantesFunciones.ID+"=";
		sDescripcion+=ordendetaprodu.getId().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ordendetaprodu.getVersionRow().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ordendetaprodu.getid_empresa().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ordendetaprodu.getid_sucursal().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=ordendetaprodu.getid_ejercicio().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=ordendetaprodu.getid_periodo().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDORDENPRODU+"=";
		sDescripcion+=ordendetaprodu.getid_orden_produ().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=ordendetaprodu.getid_bodega().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=ordendetaprodu.getid_producto().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=ordendetaprodu.getid_unidad().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDBODEGADESTINO+"=";
		sDescripcion+=ordendetaprodu.getid_bodega_destino().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU+"=";
		sDescripcion+=ordendetaprodu.getid_tipo_proceso_produ().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=ordendetaprodu.getcantidad().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=ordendetaprodu.getcantidad_pendiente().toString()+",";
		sDescripcion+=OrdenDetaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=ordendetaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu,String sValor) throws Exception {			
		if(ordendetaprodu !=null) {
			;//ordendetaproduordendetaprodu.getId().toString().trim();
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

	public static String getOrdenProduDescripcion(OrdenProdu ordenprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordenprodu!=null/*&&ordenprodu.getId()>0*/) {
			sDescripcion=OrdenProduConstantesFunciones.getOrdenProduDescripcion(ordenprodu);
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
		} else if(sNombreIndice.equals("FK_IdOrdenProdu")) {
			sNombreIndice="Tipo=  Por Orden Produ";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoProcesoProdu")) {
			sNombreIndice="Tipo=  Por Tipo Proceso Produ";
		} else if(sNombreIndice.equals("FK_IdUnidadUnad")) {
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

	public static String getDetalleIndiceFK_IdOrdenProdu(Long id_orden_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Produ="+id_orden_produ.toString();} 

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

	public static String getDetalleIndiceFK_IdUnidadUnad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosOrdenDetaProdu(OrdenDetaProdu ordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ordendetaprodu.setdescripcion(ordendetaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {
			ordendetaprodu.setdescripcion(ordendetaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenDetaProdu(OrdenDetaProdu ordendetaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ordendetaprodu.getConCambioAuxiliar()) {
			ordendetaprodu.setIsDeleted(ordendetaprodu.getIsDeletedAuxiliar());	
			ordendetaprodu.setIsNew(ordendetaprodu.getIsNewAuxiliar());	
			ordendetaprodu.setIsChanged(ordendetaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ordendetaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ordendetaprodu.setIsDeletedAuxiliar(false);	
			ordendetaprodu.setIsNewAuxiliar(false);	
			ordendetaprodu.setIsChangedAuxiliar(false);
			
			ordendetaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu : ordendetaprodus) {
			if(conAsignarBase && ordendetaprodu.getConCambioAuxiliar()) {
				ordendetaprodu.setIsDeleted(ordendetaprodu.getIsDeletedAuxiliar());	
				ordendetaprodu.setIsNew(ordendetaprodu.getIsNewAuxiliar());	
				ordendetaprodu.setIsChanged(ordendetaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ordendetaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ordendetaprodu.setIsDeletedAuxiliar(false);	
				ordendetaprodu.setIsNewAuxiliar(false);	
				ordendetaprodu.setIsChangedAuxiliar(false);
				
				ordendetaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresOrdenDetaProdu(OrdenDetaProdu ordendetaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			ordendetaprodu.setcantidad(0);
			ordendetaprodu.setcantidad_pendiente(0);
		}
	}		
	
	public static void InicializarValoresOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus,Boolean conEnteros) throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				ordendetaprodu.setcantidad(0);
				ordendetaprodu.setcantidad_pendiente(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaOrdenDetaProdu(List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProdu ordendetaproduAux) throws Exception  {
		OrdenDetaProduConstantesFunciones.InicializarValoresOrdenDetaProdu(ordendetaproduAux,true);
		
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {
			if(ordendetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ordendetaproduAux.setcantidad(ordendetaproduAux.getcantidad()+ordendetaprodu.getcantidad());			
			ordendetaproduAux.setcantidad_pendiente(ordendetaproduAux.getcantidad_pendiente()+ordendetaprodu.getcantidad_pendiente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=OrdenDetaProduConstantesFunciones.getArrayColumnasGlobalesOrdenDetaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenDetaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenDetaProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenDetaProduConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenDetaProduConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProdu ordendetaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(OrdenDetaProdu ordendetaproduAux: ordendetaprodus) {
			if(ordendetaproduAux!=null && ordendetaprodu!=null) {
				if((ordendetaproduAux.getId()==null && ordendetaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ordendetaproduAux.getId()!=null && ordendetaprodu.getId()!=null){
					if(ordendetaproduAux.getId().equals(ordendetaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaOrdenDetaProdu(List<OrdenDetaProdu> ordendetaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {			
			if(ordendetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaOrdenDetaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_ID, OrdenDetaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_VERSIONROW, OrdenDetaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDEMPRESA, OrdenDetaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDSUCURSAL, OrdenDetaProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDEJERCICIO, OrdenDetaProduConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDPERIODO, OrdenDetaProduConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDORDENPRODU, OrdenDetaProduConstantesFunciones.IDORDENPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDBODEGA, OrdenDetaProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO, OrdenDetaProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD, OrdenDetaProduConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO, OrdenDetaProduConstantesFunciones.IDBODEGADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU, OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_CANTIDAD, OrdenDetaProduConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE, OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION, OrdenDetaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasOrdenDetaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDORDENPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDBODEGADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenDetaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenDetaProdu() throws Exception  {
		return OrdenDetaProduConstantesFunciones.getTiposSeleccionarOrdenDetaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenDetaProdu(Boolean conFk) throws Exception  {
		return OrdenDetaProduConstantesFunciones.getTiposSeleccionarOrdenDetaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenDetaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDORDENPRODU);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDORDENPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(OrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesOrdenDetaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenDetaProdu(OrdenDetaProdu ordendetaproduAux) throws Exception {
		
			ordendetaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordendetaproduAux.getEmpresa()));
			ordendetaproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordendetaproduAux.getSucursal()));
			ordendetaproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordendetaproduAux.getEjercicio()));
			ordendetaproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordendetaproduAux.getPeriodo()));
			ordendetaproduAux.setordenprodu_descripcion(OrdenProduConstantesFunciones.getOrdenProduDescripcion(ordendetaproduAux.getOrdenProdu()));
			ordendetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ordendetaproduAux.getBodega()));
			ordendetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ordendetaproduAux.getProducto()));
			ordendetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(ordendetaproduAux.getUnidad()));
			ordendetaproduAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ordendetaproduAux.getBodegaDestino()));
			ordendetaproduAux.settipoprocesoprodu_descripcion(TipoProcesoProduConstantesFunciones.getTipoProcesoProduDescripcion(ordendetaproduAux.getTipoProcesoProdu()));		
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenDetaProdu(List<OrdenDetaProdu> ordendetaprodusTemp) throws Exception {
		for(OrdenDetaProdu ordendetaproduAux:ordendetaprodusTemp) {
			
			ordendetaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordendetaproduAux.getEmpresa()));
			ordendetaproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordendetaproduAux.getSucursal()));
			ordendetaproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordendetaproduAux.getEjercicio()));
			ordendetaproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordendetaproduAux.getPeriodo()));
			ordendetaproduAux.setordenprodu_descripcion(OrdenProduConstantesFunciones.getOrdenProduDescripcion(ordendetaproduAux.getOrdenProdu()));
			ordendetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ordendetaproduAux.getBodega()));
			ordendetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ordendetaproduAux.getProducto()));
			ordendetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(ordendetaproduAux.getUnidad()));
			ordendetaproduAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ordendetaproduAux.getBodegaDestino()));
			ordendetaproduAux.settipoprocesoprodu_descripcion(TipoProcesoProduConstantesFunciones.getTipoProcesoProduDescripcion(ordendetaproduAux.getTipoProcesoProdu()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(OrdenProdu.class));
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
					if(clas.clas.equals(OrdenProdu.class)) {
						classes.add(new Classe(OrdenProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
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

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenDetaProduConstantesFunciones.getClassesRelationshipsOfOrdenDetaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoOrdenDetaProduGasto.class));
				classes.add(new Classe(ProductoOrdenDetaProduMano.class));
				classes.add(new Classe(ProductoOrdenDetaProdu.class));
				classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
				classes.add(new Classe(ProductoOrdenDetaProduMerma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMano.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProdu.class)) {
						classes.add(new Classe(ProductoOrdenDetaProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenDetaProduConstantesFunciones.getClassesRelationshipsFromStringsOfOrdenDetaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProdu.class)); continue;
					}

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoOrdenDetaProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProdu.class)); continue;
					}

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoOrdenDetaProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); continue;
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
	public static void actualizarLista(OrdenDetaProdu ordendetaprodu,List<OrdenDetaProdu> ordendetaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			OrdenDetaProdu ordendetaproduEncontrado=null;
			
			for(OrdenDetaProdu ordendetaproduLocal:ordendetaprodus) {
				if(ordendetaproduLocal.getId().equals(ordendetaprodu.getId())) {
					ordendetaproduEncontrado=ordendetaproduLocal;
					
					ordendetaproduLocal.setIsChanged(ordendetaprodu.getIsChanged());
					ordendetaproduLocal.setIsNew(ordendetaprodu.getIsNew());
					ordendetaproduLocal.setIsDeleted(ordendetaprodu.getIsDeleted());
					
					ordendetaproduLocal.setGeneralEntityOriginal(ordendetaprodu.getGeneralEntityOriginal());
					
					ordendetaproduLocal.setId(ordendetaprodu.getId());	
					ordendetaproduLocal.setVersionRow(ordendetaprodu.getVersionRow());	
					ordendetaproduLocal.setid_empresa(ordendetaprodu.getid_empresa());	
					ordendetaproduLocal.setid_sucursal(ordendetaprodu.getid_sucursal());	
					ordendetaproduLocal.setid_ejercicio(ordendetaprodu.getid_ejercicio());	
					ordendetaproduLocal.setid_periodo(ordendetaprodu.getid_periodo());	
					ordendetaproduLocal.setid_orden_produ(ordendetaprodu.getid_orden_produ());	
					ordendetaproduLocal.setid_bodega(ordendetaprodu.getid_bodega());	
					ordendetaproduLocal.setid_producto(ordendetaprodu.getid_producto());	
					ordendetaproduLocal.setid_unidad(ordendetaprodu.getid_unidad());	
					ordendetaproduLocal.setid_bodega_destino(ordendetaprodu.getid_bodega_destino());	
					ordendetaproduLocal.setid_tipo_proceso_produ(ordendetaprodu.getid_tipo_proceso_produ());	
					ordendetaproduLocal.setcantidad(ordendetaprodu.getcantidad());	
					ordendetaproduLocal.setcantidad_pendiente(ordendetaprodu.getcantidad_pendiente());	
					ordendetaproduLocal.setdescripcion(ordendetaprodu.getdescripcion());	
					
					
					ordendetaproduLocal.setProductoOrdenDetaProduGastos(ordendetaprodu.getProductoOrdenDetaProduGastos());
					ordendetaproduLocal.setProductoOrdenDetaProduManos(ordendetaprodu.getProductoOrdenDetaProduManos());
					ordendetaproduLocal.setProductoOrdenDetaProdus(ordendetaprodu.getProductoOrdenDetaProdus());
					ordendetaproduLocal.setProductoOrdenDetaProduMaquinas(ordendetaprodu.getProductoOrdenDetaProduMaquinas());
					ordendetaproduLocal.setProductoOrdenDetaProduMermas(ordendetaprodu.getProductoOrdenDetaProduMermas());
					
					existe=true;
					break;
				}
			}
			
			if(!ordendetaprodu.getIsDeleted()) {
				if(!existe) {
					ordendetaprodus.add(ordendetaprodu);
				}
			} else {
				if(ordendetaproduEncontrado!=null && permiteQuitar)  {
					ordendetaprodus.remove(ordendetaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(OrdenDetaProdu ordendetaprodu,List<OrdenDetaProdu> ordendetaprodus) throws Exception {
		try	{			
			for(OrdenDetaProdu ordendetaproduLocal:ordendetaprodus) {
				if(ordendetaproduLocal.getId().equals(ordendetaprodu.getId())) {
					ordendetaproduLocal.setIsSelected(ordendetaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesOrdenDetaProdu(List<OrdenDetaProdu> ordendetaprodusAux) throws Exception {
		//this.ordendetaprodusAux=ordendetaprodusAux;
		
		for(OrdenDetaProdu ordendetaproduAux:ordendetaprodusAux) {
			if(ordendetaproduAux.getIsChanged()) {
				ordendetaproduAux.setIsChanged(false);
			}		
			
			if(ordendetaproduAux.getIsNew()) {
				ordendetaproduAux.setIsNew(false);
			}	
			
			if(ordendetaproduAux.getIsDeleted()) {
				ordendetaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesOrdenDetaProdu(OrdenDetaProdu ordendetaproduAux) throws Exception {
		//this.ordendetaproduAux=ordendetaproduAux;
		
			if(ordendetaproduAux.getIsChanged()) {
				ordendetaproduAux.setIsChanged(false);
			}		
			
			if(ordendetaproduAux.getIsNew()) {
				ordendetaproduAux.setIsNew(false);
			}	
			
			if(ordendetaproduAux.getIsDeleted()) {
				ordendetaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(OrdenDetaProdu ordendetaproduAsignar,OrdenDetaProdu ordendetaprodu) throws Exception {
		ordendetaproduAsignar.setId(ordendetaprodu.getId());	
		ordendetaproduAsignar.setVersionRow(ordendetaprodu.getVersionRow());	
		ordendetaproduAsignar.setid_empresa(ordendetaprodu.getid_empresa());
		ordendetaproduAsignar.setempresa_descripcion(ordendetaprodu.getempresa_descripcion());	
		ordendetaproduAsignar.setid_sucursal(ordendetaprodu.getid_sucursal());
		ordendetaproduAsignar.setsucursal_descripcion(ordendetaprodu.getsucursal_descripcion());	
		ordendetaproduAsignar.setid_ejercicio(ordendetaprodu.getid_ejercicio());
		ordendetaproduAsignar.setejercicio_descripcion(ordendetaprodu.getejercicio_descripcion());	
		ordendetaproduAsignar.setid_periodo(ordendetaprodu.getid_periodo());
		ordendetaproduAsignar.setperiodo_descripcion(ordendetaprodu.getperiodo_descripcion());	
		ordendetaproduAsignar.setid_orden_produ(ordendetaprodu.getid_orden_produ());
		ordendetaproduAsignar.setordenprodu_descripcion(ordendetaprodu.getordenprodu_descripcion());	
		ordendetaproduAsignar.setid_bodega(ordendetaprodu.getid_bodega());
		ordendetaproduAsignar.setbodega_descripcion(ordendetaprodu.getbodega_descripcion());	
		ordendetaproduAsignar.setid_producto(ordendetaprodu.getid_producto());
		ordendetaproduAsignar.setproducto_descripcion(ordendetaprodu.getproducto_descripcion());	
		ordendetaproduAsignar.setid_unidad(ordendetaprodu.getid_unidad());
		ordendetaproduAsignar.setunidad_descripcion(ordendetaprodu.getunidad_descripcion());	
		ordendetaproduAsignar.setid_bodega_destino(ordendetaprodu.getid_bodega_destino());
		ordendetaproduAsignar.setbodegadestino_descripcion(ordendetaprodu.getbodegadestino_descripcion());	
		ordendetaproduAsignar.setid_tipo_proceso_produ(ordendetaprodu.getid_tipo_proceso_produ());
		ordendetaproduAsignar.settipoprocesoprodu_descripcion(ordendetaprodu.gettipoprocesoprodu_descripcion());	
		ordendetaproduAsignar.setcantidad(ordendetaprodu.getcantidad());	
		ordendetaproduAsignar.setcantidad_pendiente(ordendetaprodu.getcantidad_pendiente());	
		ordendetaproduAsignar.setdescripcion(ordendetaprodu.getdescripcion());	
	}
	
	public static void inicializarOrdenDetaProdu(OrdenDetaProdu ordendetaprodu) throws Exception {
		try {
				ordendetaprodu.setId(0L);	
					
				ordendetaprodu.setid_empresa(-1L);	
				ordendetaprodu.setid_sucursal(-1L);	
				ordendetaprodu.setid_ejercicio(-1L);	
				ordendetaprodu.setid_periodo(-1L);	
				ordendetaprodu.setid_orden_produ(-1L);	
				ordendetaprodu.setid_bodega(-1L);	
				ordendetaprodu.setid_producto(-1L);	
				ordendetaprodu.setid_unidad(-1L);	
				ordendetaprodu.setid_bodega_destino(-1L);	
				ordendetaprodu.setid_tipo_proceso_produ(-1L);	
				ordendetaprodu.setcantidad(0);	
				ordendetaprodu.setcantidad_pendiente(0);	
				ordendetaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderOrdenDetaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDORDENPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDBODEGADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_IDTIPOPROCESOPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataOrdenDetaProdu(String sTipo,Row row,Workbook workbook,OrdenDetaProdu ordendetaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getordenprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getbodegadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.gettipoprocesoprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordendetaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryOrdenDetaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryOrdenDetaProdu() {
		return this.sFinalQueryOrdenDetaProdu;
	}
	
	public void setsFinalQueryOrdenDetaProdu(String sFinalQueryOrdenDetaProdu) {
		this.sFinalQueryOrdenDetaProdu= sFinalQueryOrdenDetaProdu;
	}
	
	public Border resaltarSeleccionarOrdenDetaProdu=null;
	
	public Border setResaltarSeleccionarOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarOrdenDetaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarOrdenDetaProdu() {
		return this.resaltarSeleccionarOrdenDetaProdu;
	}
	
	public void setResaltarSeleccionarOrdenDetaProdu(Border borderResaltarSeleccionarOrdenDetaProdu) {
		this.resaltarSeleccionarOrdenDetaProdu= borderResaltarSeleccionarOrdenDetaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridOrdenDetaProdu=null;
	public Boolean mostraridOrdenDetaProdu=true;
	public Boolean activaridOrdenDetaProdu=true;

	public Border resaltarid_empresaOrdenDetaProdu=null;
	public Boolean mostrarid_empresaOrdenDetaProdu=true;
	public Boolean activarid_empresaOrdenDetaProdu=true;
	public Boolean cargarid_empresaOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalOrdenDetaProdu=null;
	public Boolean mostrarid_sucursalOrdenDetaProdu=true;
	public Boolean activarid_sucursalOrdenDetaProdu=true;
	public Boolean cargarid_sucursalOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_ejercicioOrdenDetaProdu=null;
	public Boolean mostrarid_ejercicioOrdenDetaProdu=true;
	public Boolean activarid_ejercicioOrdenDetaProdu=true;
	public Boolean cargarid_ejercicioOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_periodoOrdenDetaProdu=null;
	public Boolean mostrarid_periodoOrdenDetaProdu=true;
	public Boolean activarid_periodoOrdenDetaProdu=true;
	public Boolean cargarid_periodoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_orden_produOrdenDetaProdu=null;
	public Boolean mostrarid_orden_produOrdenDetaProdu=true;
	public Boolean activarid_orden_produOrdenDetaProdu=true;
	public Boolean cargarid_orden_produOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_produOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaOrdenDetaProdu=null;
	public Boolean mostrarid_bodegaOrdenDetaProdu=true;
	public Boolean activarid_bodegaOrdenDetaProdu=true;
	public Boolean cargarid_bodegaOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_productoOrdenDetaProdu=null;
	public Boolean mostrarid_productoOrdenDetaProdu=true;
	public Boolean activarid_productoOrdenDetaProdu=true;
	public Boolean cargarid_productoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoOrdenDetaProdu=true;//ConEventDepend=true

	public Border resaltarid_unidadOrdenDetaProdu=null;
	public Boolean mostrarid_unidadOrdenDetaProdu=true;
	public Boolean activarid_unidadOrdenDetaProdu=true;
	public Boolean cargarid_unidadOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadOrdenDetaProdu=true;//ConEventDepend=true

	public Border resaltarid_bodega_destinoOrdenDetaProdu=null;
	public Boolean mostrarid_bodega_destinoOrdenDetaProdu=true;
	public Boolean activarid_bodega_destinoOrdenDetaProdu=true;
	public Boolean cargarid_bodega_destinoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_destinoOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_produOrdenDetaProdu=null;
	public Boolean mostrarid_tipo_proceso_produOrdenDetaProdu=true;
	public Boolean activarid_tipo_proceso_produOrdenDetaProdu=true;
	public Boolean cargarid_tipo_proceso_produOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_produOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarcantidadOrdenDetaProdu=null;
	public Boolean mostrarcantidadOrdenDetaProdu=true;
	public Boolean activarcantidadOrdenDetaProdu=true;

	public Border resaltarcantidad_pendienteOrdenDetaProdu=null;
	public Boolean mostrarcantidad_pendienteOrdenDetaProdu=true;
	public Boolean activarcantidad_pendienteOrdenDetaProdu=true;

	public Border resaltardescripcionOrdenDetaProdu=null;
	public Boolean mostrardescripcionOrdenDetaProdu=true;
	public Boolean activardescripcionOrdenDetaProdu=true;

	
	

	public Border setResaltaridOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltaridOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridOrdenDetaProdu() {
		return this.resaltaridOrdenDetaProdu;
	}

	public void setResaltaridOrdenDetaProdu(Border borderResaltar) {
		this.resaltaridOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostraridOrdenDetaProdu() {
		return this.mostraridOrdenDetaProdu;
	}

	public void setMostraridOrdenDetaProdu(Boolean mostraridOrdenDetaProdu) {
		this.mostraridOrdenDetaProdu= mostraridOrdenDetaProdu;
	}

	public Boolean getActivaridOrdenDetaProdu() {
		return this.activaridOrdenDetaProdu;
	}

	public void setActivaridOrdenDetaProdu(Boolean activaridOrdenDetaProdu) {
		this.activaridOrdenDetaProdu= activaridOrdenDetaProdu;
	}

	public Border setResaltarid_empresaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaOrdenDetaProdu() {
		return this.resaltarid_empresaOrdenDetaProdu;
	}

	public void setResaltarid_empresaOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_empresaOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaOrdenDetaProdu() {
		return this.mostrarid_empresaOrdenDetaProdu;
	}

	public void setMostrarid_empresaOrdenDetaProdu(Boolean mostrarid_empresaOrdenDetaProdu) {
		this.mostrarid_empresaOrdenDetaProdu= mostrarid_empresaOrdenDetaProdu;
	}

	public Boolean getActivarid_empresaOrdenDetaProdu() {
		return this.activarid_empresaOrdenDetaProdu;
	}

	public void setActivarid_empresaOrdenDetaProdu(Boolean activarid_empresaOrdenDetaProdu) {
		this.activarid_empresaOrdenDetaProdu= activarid_empresaOrdenDetaProdu;
	}

	public Boolean getCargarid_empresaOrdenDetaProdu() {
		return this.cargarid_empresaOrdenDetaProdu;
	}

	public void setCargarid_empresaOrdenDetaProdu(Boolean cargarid_empresaOrdenDetaProdu) {
		this.cargarid_empresaOrdenDetaProdu= cargarid_empresaOrdenDetaProdu;
	}

	public Border setResaltarid_sucursalOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalOrdenDetaProdu() {
		return this.resaltarid_sucursalOrdenDetaProdu;
	}

	public void setResaltarid_sucursalOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_sucursalOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalOrdenDetaProdu() {
		return this.mostrarid_sucursalOrdenDetaProdu;
	}

	public void setMostrarid_sucursalOrdenDetaProdu(Boolean mostrarid_sucursalOrdenDetaProdu) {
		this.mostrarid_sucursalOrdenDetaProdu= mostrarid_sucursalOrdenDetaProdu;
	}

	public Boolean getActivarid_sucursalOrdenDetaProdu() {
		return this.activarid_sucursalOrdenDetaProdu;
	}

	public void setActivarid_sucursalOrdenDetaProdu(Boolean activarid_sucursalOrdenDetaProdu) {
		this.activarid_sucursalOrdenDetaProdu= activarid_sucursalOrdenDetaProdu;
	}

	public Boolean getCargarid_sucursalOrdenDetaProdu() {
		return this.cargarid_sucursalOrdenDetaProdu;
	}

	public void setCargarid_sucursalOrdenDetaProdu(Boolean cargarid_sucursalOrdenDetaProdu) {
		this.cargarid_sucursalOrdenDetaProdu= cargarid_sucursalOrdenDetaProdu;
	}

	public Border setResaltarid_ejercicioOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioOrdenDetaProdu() {
		return this.resaltarid_ejercicioOrdenDetaProdu;
	}

	public void setResaltarid_ejercicioOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_ejercicioOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioOrdenDetaProdu() {
		return this.mostrarid_ejercicioOrdenDetaProdu;
	}

	public void setMostrarid_ejercicioOrdenDetaProdu(Boolean mostrarid_ejercicioOrdenDetaProdu) {
		this.mostrarid_ejercicioOrdenDetaProdu= mostrarid_ejercicioOrdenDetaProdu;
	}

	public Boolean getActivarid_ejercicioOrdenDetaProdu() {
		return this.activarid_ejercicioOrdenDetaProdu;
	}

	public void setActivarid_ejercicioOrdenDetaProdu(Boolean activarid_ejercicioOrdenDetaProdu) {
		this.activarid_ejercicioOrdenDetaProdu= activarid_ejercicioOrdenDetaProdu;
	}

	public Boolean getCargarid_ejercicioOrdenDetaProdu() {
		return this.cargarid_ejercicioOrdenDetaProdu;
	}

	public void setCargarid_ejercicioOrdenDetaProdu(Boolean cargarid_ejercicioOrdenDetaProdu) {
		this.cargarid_ejercicioOrdenDetaProdu= cargarid_ejercicioOrdenDetaProdu;
	}

	public Border setResaltarid_periodoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_periodoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoOrdenDetaProdu() {
		return this.resaltarid_periodoOrdenDetaProdu;
	}

	public void setResaltarid_periodoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_periodoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_periodoOrdenDetaProdu() {
		return this.mostrarid_periodoOrdenDetaProdu;
	}

	public void setMostrarid_periodoOrdenDetaProdu(Boolean mostrarid_periodoOrdenDetaProdu) {
		this.mostrarid_periodoOrdenDetaProdu= mostrarid_periodoOrdenDetaProdu;
	}

	public Boolean getActivarid_periodoOrdenDetaProdu() {
		return this.activarid_periodoOrdenDetaProdu;
	}

	public void setActivarid_periodoOrdenDetaProdu(Boolean activarid_periodoOrdenDetaProdu) {
		this.activarid_periodoOrdenDetaProdu= activarid_periodoOrdenDetaProdu;
	}

	public Boolean getCargarid_periodoOrdenDetaProdu() {
		return this.cargarid_periodoOrdenDetaProdu;
	}

	public void setCargarid_periodoOrdenDetaProdu(Boolean cargarid_periodoOrdenDetaProdu) {
		this.cargarid_periodoOrdenDetaProdu= cargarid_periodoOrdenDetaProdu;
	}

	public Border setResaltarid_orden_produOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_orden_produOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_produOrdenDetaProdu() {
		return this.resaltarid_orden_produOrdenDetaProdu;
	}

	public void setResaltarid_orden_produOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_orden_produOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_orden_produOrdenDetaProdu() {
		return this.mostrarid_orden_produOrdenDetaProdu;
	}

	public void setMostrarid_orden_produOrdenDetaProdu(Boolean mostrarid_orden_produOrdenDetaProdu) {
		this.mostrarid_orden_produOrdenDetaProdu= mostrarid_orden_produOrdenDetaProdu;
	}

	public Boolean getActivarid_orden_produOrdenDetaProdu() {
		return this.activarid_orden_produOrdenDetaProdu;
	}

	public void setActivarid_orden_produOrdenDetaProdu(Boolean activarid_orden_produOrdenDetaProdu) {
		this.activarid_orden_produOrdenDetaProdu= activarid_orden_produOrdenDetaProdu;
	}

	public Boolean getCargarid_orden_produOrdenDetaProdu() {
		return this.cargarid_orden_produOrdenDetaProdu;
	}

	public void setCargarid_orden_produOrdenDetaProdu(Boolean cargarid_orden_produOrdenDetaProdu) {
		this.cargarid_orden_produOrdenDetaProdu= cargarid_orden_produOrdenDetaProdu;
	}

	public Border setResaltarid_bodegaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaOrdenDetaProdu() {
		return this.resaltarid_bodegaOrdenDetaProdu;
	}

	public void setResaltarid_bodegaOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_bodegaOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaOrdenDetaProdu() {
		return this.mostrarid_bodegaOrdenDetaProdu;
	}

	public void setMostrarid_bodegaOrdenDetaProdu(Boolean mostrarid_bodegaOrdenDetaProdu) {
		this.mostrarid_bodegaOrdenDetaProdu= mostrarid_bodegaOrdenDetaProdu;
	}

	public Boolean getActivarid_bodegaOrdenDetaProdu() {
		return this.activarid_bodegaOrdenDetaProdu;
	}

	public void setActivarid_bodegaOrdenDetaProdu(Boolean activarid_bodegaOrdenDetaProdu) {
		this.activarid_bodegaOrdenDetaProdu= activarid_bodegaOrdenDetaProdu;
	}

	public Boolean getCargarid_bodegaOrdenDetaProdu() {
		return this.cargarid_bodegaOrdenDetaProdu;
	}

	public void setCargarid_bodegaOrdenDetaProdu(Boolean cargarid_bodegaOrdenDetaProdu) {
		this.cargarid_bodegaOrdenDetaProdu= cargarid_bodegaOrdenDetaProdu;
	}

	public Border setResaltarid_productoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoOrdenDetaProdu() {
		return this.resaltarid_productoOrdenDetaProdu;
	}

	public void setResaltarid_productoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_productoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoOrdenDetaProdu() {
		return this.mostrarid_productoOrdenDetaProdu;
	}

	public void setMostrarid_productoOrdenDetaProdu(Boolean mostrarid_productoOrdenDetaProdu) {
		this.mostrarid_productoOrdenDetaProdu= mostrarid_productoOrdenDetaProdu;
	}

	public Boolean getActivarid_productoOrdenDetaProdu() {
		return this.activarid_productoOrdenDetaProdu;
	}

	public void setActivarid_productoOrdenDetaProdu(Boolean activarid_productoOrdenDetaProdu) {
		this.activarid_productoOrdenDetaProdu= activarid_productoOrdenDetaProdu;
	}

	public Boolean getCargarid_productoOrdenDetaProdu() {
		return this.cargarid_productoOrdenDetaProdu;
	}

	public void setCargarid_productoOrdenDetaProdu(Boolean cargarid_productoOrdenDetaProdu) {
		this.cargarid_productoOrdenDetaProdu= cargarid_productoOrdenDetaProdu;
	}

	public Border setResaltarid_unidadOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_unidadOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadOrdenDetaProdu() {
		return this.resaltarid_unidadOrdenDetaProdu;
	}

	public void setResaltarid_unidadOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_unidadOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_unidadOrdenDetaProdu() {
		return this.mostrarid_unidadOrdenDetaProdu;
	}

	public void setMostrarid_unidadOrdenDetaProdu(Boolean mostrarid_unidadOrdenDetaProdu) {
		this.mostrarid_unidadOrdenDetaProdu= mostrarid_unidadOrdenDetaProdu;
	}

	public Boolean getActivarid_unidadOrdenDetaProdu() {
		return this.activarid_unidadOrdenDetaProdu;
	}

	public void setActivarid_unidadOrdenDetaProdu(Boolean activarid_unidadOrdenDetaProdu) {
		this.activarid_unidadOrdenDetaProdu= activarid_unidadOrdenDetaProdu;
	}

	public Boolean getCargarid_unidadOrdenDetaProdu() {
		return this.cargarid_unidadOrdenDetaProdu;
	}

	public void setCargarid_unidadOrdenDetaProdu(Boolean cargarid_unidadOrdenDetaProdu) {
		this.cargarid_unidadOrdenDetaProdu= cargarid_unidadOrdenDetaProdu;
	}

	public Border setResaltarid_bodega_destinoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodega_destinoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_destinoOrdenDetaProdu() {
		return this.resaltarid_bodega_destinoOrdenDetaProdu;
	}

	public void setResaltarid_bodega_destinoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_bodega_destinoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodega_destinoOrdenDetaProdu() {
		return this.mostrarid_bodega_destinoOrdenDetaProdu;
	}

	public void setMostrarid_bodega_destinoOrdenDetaProdu(Boolean mostrarid_bodega_destinoOrdenDetaProdu) {
		this.mostrarid_bodega_destinoOrdenDetaProdu= mostrarid_bodega_destinoOrdenDetaProdu;
	}

	public Boolean getActivarid_bodega_destinoOrdenDetaProdu() {
		return this.activarid_bodega_destinoOrdenDetaProdu;
	}

	public void setActivarid_bodega_destinoOrdenDetaProdu(Boolean activarid_bodega_destinoOrdenDetaProdu) {
		this.activarid_bodega_destinoOrdenDetaProdu= activarid_bodega_destinoOrdenDetaProdu;
	}

	public Boolean getCargarid_bodega_destinoOrdenDetaProdu() {
		return this.cargarid_bodega_destinoOrdenDetaProdu;
	}

	public void setCargarid_bodega_destinoOrdenDetaProdu(Boolean cargarid_bodega_destinoOrdenDetaProdu) {
		this.cargarid_bodega_destinoOrdenDetaProdu= cargarid_bodega_destinoOrdenDetaProdu;
	}

	public Border setResaltarid_tipo_proceso_produOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_produOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_produOrdenDetaProdu() {
		return this.resaltarid_tipo_proceso_produOrdenDetaProdu;
	}

	public void setResaltarid_tipo_proceso_produOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_tipo_proceso_produOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_produOrdenDetaProdu() {
		return this.mostrarid_tipo_proceso_produOrdenDetaProdu;
	}

	public void setMostrarid_tipo_proceso_produOrdenDetaProdu(Boolean mostrarid_tipo_proceso_produOrdenDetaProdu) {
		this.mostrarid_tipo_proceso_produOrdenDetaProdu= mostrarid_tipo_proceso_produOrdenDetaProdu;
	}

	public Boolean getActivarid_tipo_proceso_produOrdenDetaProdu() {
		return this.activarid_tipo_proceso_produOrdenDetaProdu;
	}

	public void setActivarid_tipo_proceso_produOrdenDetaProdu(Boolean activarid_tipo_proceso_produOrdenDetaProdu) {
		this.activarid_tipo_proceso_produOrdenDetaProdu= activarid_tipo_proceso_produOrdenDetaProdu;
	}

	public Boolean getCargarid_tipo_proceso_produOrdenDetaProdu() {
		return this.cargarid_tipo_proceso_produOrdenDetaProdu;
	}

	public void setCargarid_tipo_proceso_produOrdenDetaProdu(Boolean cargarid_tipo_proceso_produOrdenDetaProdu) {
		this.cargarid_tipo_proceso_produOrdenDetaProdu= cargarid_tipo_proceso_produOrdenDetaProdu;
	}

	public Border setResaltarcantidadOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcantidadOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadOrdenDetaProdu() {
		return this.resaltarcantidadOrdenDetaProdu;
	}

	public void setResaltarcantidadOrdenDetaProdu(Border borderResaltar) {
		this.resaltarcantidadOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcantidadOrdenDetaProdu() {
		return this.mostrarcantidadOrdenDetaProdu;
	}

	public void setMostrarcantidadOrdenDetaProdu(Boolean mostrarcantidadOrdenDetaProdu) {
		this.mostrarcantidadOrdenDetaProdu= mostrarcantidadOrdenDetaProdu;
	}

	public Boolean getActivarcantidadOrdenDetaProdu() {
		return this.activarcantidadOrdenDetaProdu;
	}

	public void setActivarcantidadOrdenDetaProdu(Boolean activarcantidadOrdenDetaProdu) {
		this.activarcantidadOrdenDetaProdu= activarcantidadOrdenDetaProdu;
	}

	public Border setResaltarcantidad_pendienteOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendienteOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendienteOrdenDetaProdu() {
		return this.resaltarcantidad_pendienteOrdenDetaProdu;
	}

	public void setResaltarcantidad_pendienteOrdenDetaProdu(Border borderResaltar) {
		this.resaltarcantidad_pendienteOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendienteOrdenDetaProdu() {
		return this.mostrarcantidad_pendienteOrdenDetaProdu;
	}

	public void setMostrarcantidad_pendienteOrdenDetaProdu(Boolean mostrarcantidad_pendienteOrdenDetaProdu) {
		this.mostrarcantidad_pendienteOrdenDetaProdu= mostrarcantidad_pendienteOrdenDetaProdu;
	}

	public Boolean getActivarcantidad_pendienteOrdenDetaProdu() {
		return this.activarcantidad_pendienteOrdenDetaProdu;
	}

	public void setActivarcantidad_pendienteOrdenDetaProdu(Boolean activarcantidad_pendienteOrdenDetaProdu) {
		this.activarcantidad_pendienteOrdenDetaProdu= activarcantidad_pendienteOrdenDetaProdu;
	}

	public Border setResaltardescripcionOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionOrdenDetaProdu() {
		return this.resaltardescripcionOrdenDetaProdu;
	}

	public void setResaltardescripcionOrdenDetaProdu(Border borderResaltar) {
		this.resaltardescripcionOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionOrdenDetaProdu() {
		return this.mostrardescripcionOrdenDetaProdu;
	}

	public void setMostrardescripcionOrdenDetaProdu(Boolean mostrardescripcionOrdenDetaProdu) {
		this.mostrardescripcionOrdenDetaProdu= mostrardescripcionOrdenDetaProdu;
	}

	public Boolean getActivardescripcionOrdenDetaProdu() {
		return this.activardescripcionOrdenDetaProdu;
	}

	public void setActivardescripcionOrdenDetaProdu(Boolean activardescripcionOrdenDetaProdu) {
		this.activardescripcionOrdenDetaProdu= activardescripcionOrdenDetaProdu;
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
		
		
		this.setMostraridOrdenDetaProdu(esInicial);
		this.setMostrarid_empresaOrdenDetaProdu(esInicial);
		this.setMostrarid_sucursalOrdenDetaProdu(esInicial);
		this.setMostrarid_ejercicioOrdenDetaProdu(esInicial);
		this.setMostrarid_periodoOrdenDetaProdu(esInicial);
		this.setMostrarid_orden_produOrdenDetaProdu(esInicial);
		this.setMostrarid_bodegaOrdenDetaProdu(esInicial);
		this.setMostrarid_productoOrdenDetaProdu(esInicial);
		this.setMostrarid_unidadOrdenDetaProdu(esInicial);
		this.setMostrarid_bodega_destinoOrdenDetaProdu(esInicial);
		this.setMostrarid_tipo_proceso_produOrdenDetaProdu(esInicial);
		this.setMostrarcantidadOrdenDetaProdu(esInicial);
		this.setMostrarcantidad_pendienteOrdenDetaProdu(esInicial);
		this.setMostrardescripcionOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.ID)) {
				this.setMostraridOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDORDENPRODU)) {
				this.setMostrarid_orden_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setMostrarid_bodega_destinoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setMostrarid_tipo_proceso_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendienteOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionOrdenDetaProdu(esAsigna);
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
		
		
		this.setActivaridOrdenDetaProdu(esInicial);
		this.setActivarid_empresaOrdenDetaProdu(esInicial);
		this.setActivarid_sucursalOrdenDetaProdu(esInicial);
		this.setActivarid_ejercicioOrdenDetaProdu(esInicial);
		this.setActivarid_periodoOrdenDetaProdu(esInicial);
		this.setActivarid_orden_produOrdenDetaProdu(esInicial);
		this.setActivarid_bodegaOrdenDetaProdu(esInicial);
		this.setActivarid_productoOrdenDetaProdu(esInicial);
		this.setActivarid_unidadOrdenDetaProdu(esInicial);
		this.setActivarid_bodega_destinoOrdenDetaProdu(esInicial);
		this.setActivarid_tipo_proceso_produOrdenDetaProdu(esInicial);
		this.setActivarcantidadOrdenDetaProdu(esInicial);
		this.setActivarcantidad_pendienteOrdenDetaProdu(esInicial);
		this.setActivardescripcionOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.ID)) {
				this.setActivaridOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDORDENPRODU)) {
				this.setActivarid_orden_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setActivarid_bodega_destinoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setActivarid_tipo_proceso_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendienteOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionOrdenDetaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridOrdenDetaProdu(esInicial);
		this.setResaltarid_empresaOrdenDetaProdu(esInicial);
		this.setResaltarid_sucursalOrdenDetaProdu(esInicial);
		this.setResaltarid_ejercicioOrdenDetaProdu(esInicial);
		this.setResaltarid_periodoOrdenDetaProdu(esInicial);
		this.setResaltarid_orden_produOrdenDetaProdu(esInicial);
		this.setResaltarid_bodegaOrdenDetaProdu(esInicial);
		this.setResaltarid_productoOrdenDetaProdu(esInicial);
		this.setResaltarid_unidadOrdenDetaProdu(esInicial);
		this.setResaltarid_bodega_destinoOrdenDetaProdu(esInicial);
		this.setResaltarid_tipo_proceso_produOrdenDetaProdu(esInicial);
		this.setResaltarcantidadOrdenDetaProdu(esInicial);
		this.setResaltarcantidad_pendienteOrdenDetaProdu(esInicial);
		this.setResaltardescripcionOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.ID)) {
				this.setResaltaridOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDORDENPRODU)) {
				this.setResaltarid_orden_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDBODEGADESTINO)) {
				this.setResaltarid_bodega_destinoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU)) {
				this.setResaltarid_tipo_proceso_produOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendienteOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionOrdenDetaProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoOrdenDetaProduGastoOrdenDetaProdu=null;

	public Border getResaltarProductoOrdenDetaProduGastoOrdenDetaProdu() {
		return this.resaltarProductoOrdenDetaProduGastoOrdenDetaProdu;
	}

	public void setResaltarProductoOrdenDetaProduGastoOrdenDetaProdu(Border borderResaltarProductoOrdenDetaProduGasto) {
		if(borderResaltarProductoOrdenDetaProduGasto!=null) {
			this.resaltarProductoOrdenDetaProduGastoOrdenDetaProdu= borderResaltarProductoOrdenDetaProduGasto;
		}
	}

	public Border setResaltarProductoOrdenDetaProduGastoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduGasto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltarProductoOrdenDetaProduGasto);
			
		this.resaltarProductoOrdenDetaProduGastoOrdenDetaProdu= borderResaltarProductoOrdenDetaProduGasto;

		 return borderResaltarProductoOrdenDetaProduGasto;
	}



	public Boolean mostrarProductoOrdenDetaProduGastoOrdenDetaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduGastoOrdenDetaProdu() {
		return this.mostrarProductoOrdenDetaProduGastoOrdenDetaProdu;
	}

	public void setMostrarProductoOrdenDetaProduGastoOrdenDetaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduGasto) {
		this.mostrarProductoOrdenDetaProduGastoOrdenDetaProdu= visibilidadResaltarProductoOrdenDetaProduGasto;
	}



	public Boolean activarProductoOrdenDetaProduGastoOrdenDetaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduGastoOrdenDetaProdu() {
		return this.activarProductoOrdenDetaProduGastoOrdenDetaProdu;
	}

	public void setActivarProductoOrdenDetaProduGastoOrdenDetaProdu(Boolean habilitarResaltarProductoOrdenDetaProduGasto) {
		this.activarProductoOrdenDetaProduGastoOrdenDetaProdu= habilitarResaltarProductoOrdenDetaProduGasto;
	}


	public Border resaltarProductoOrdenDetaProduManoOrdenDetaProdu=null;

	public Border getResaltarProductoOrdenDetaProduManoOrdenDetaProdu() {
		return this.resaltarProductoOrdenDetaProduManoOrdenDetaProdu;
	}

	public void setResaltarProductoOrdenDetaProduManoOrdenDetaProdu(Border borderResaltarProductoOrdenDetaProduMano) {
		if(borderResaltarProductoOrdenDetaProduMano!=null) {
			this.resaltarProductoOrdenDetaProduManoOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMano;
		}
	}

	public Border setResaltarProductoOrdenDetaProduManoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMano=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltarProductoOrdenDetaProduMano);
			
		this.resaltarProductoOrdenDetaProduManoOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMano;

		 return borderResaltarProductoOrdenDetaProduMano;
	}



	public Boolean mostrarProductoOrdenDetaProduManoOrdenDetaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduManoOrdenDetaProdu() {
		return this.mostrarProductoOrdenDetaProduManoOrdenDetaProdu;
	}

	public void setMostrarProductoOrdenDetaProduManoOrdenDetaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMano) {
		this.mostrarProductoOrdenDetaProduManoOrdenDetaProdu= visibilidadResaltarProductoOrdenDetaProduMano;
	}



	public Boolean activarProductoOrdenDetaProduManoOrdenDetaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduManoOrdenDetaProdu() {
		return this.activarProductoOrdenDetaProduManoOrdenDetaProdu;
	}

	public void setActivarProductoOrdenDetaProduManoOrdenDetaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMano) {
		this.activarProductoOrdenDetaProduManoOrdenDetaProdu= habilitarResaltarProductoOrdenDetaProduMano;
	}


	public Border resaltarProductoOrdenDetaProduOrdenDetaProdu=null;

	public Border getResaltarProductoOrdenDetaProduOrdenDetaProdu() {
		return this.resaltarProductoOrdenDetaProduOrdenDetaProdu;
	}

	public void setResaltarProductoOrdenDetaProduOrdenDetaProdu(Border borderResaltarProductoOrdenDetaProdu) {
		if(borderResaltarProductoOrdenDetaProdu!=null) {
			this.resaltarProductoOrdenDetaProduOrdenDetaProdu= borderResaltarProductoOrdenDetaProdu;
		}
	}

	public Border setResaltarProductoOrdenDetaProduOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltarProductoOrdenDetaProdu);
			
		this.resaltarProductoOrdenDetaProduOrdenDetaProdu= borderResaltarProductoOrdenDetaProdu;

		 return borderResaltarProductoOrdenDetaProdu;
	}



	public Boolean mostrarProductoOrdenDetaProduOrdenDetaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduOrdenDetaProdu() {
		return this.mostrarProductoOrdenDetaProduOrdenDetaProdu;
	}

	public void setMostrarProductoOrdenDetaProduOrdenDetaProdu(Boolean visibilidadResaltarProductoOrdenDetaProdu) {
		this.mostrarProductoOrdenDetaProduOrdenDetaProdu= visibilidadResaltarProductoOrdenDetaProdu;
	}



	public Boolean activarProductoOrdenDetaProduOrdenDetaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduOrdenDetaProdu() {
		return this.activarProductoOrdenDetaProduOrdenDetaProdu;
	}

	public void setActivarProductoOrdenDetaProduOrdenDetaProdu(Boolean habilitarResaltarProductoOrdenDetaProdu) {
		this.activarProductoOrdenDetaProduOrdenDetaProdu= habilitarResaltarProductoOrdenDetaProdu;
	}


	public Border resaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu=null;

	public Border getResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu() {
		return this.resaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu;
	}

	public void setResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu(Border borderResaltarProductoOrdenDetaProduMaquina) {
		if(borderResaltarProductoOrdenDetaProduMaquina!=null) {
			this.resaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMaquina;
		}
	}

	public Border setResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltarProductoOrdenDetaProduMaquina);
			
		this.resaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMaquina;

		 return borderResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean mostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu() {
		return this.mostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu;
	}

	public void setMostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMaquina) {
		this.mostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu= visibilidadResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean activarProductoOrdenDetaProduMaquinaOrdenDetaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu() {
		return this.activarProductoOrdenDetaProduMaquinaOrdenDetaProdu;
	}

	public void setActivarProductoOrdenDetaProduMaquinaOrdenDetaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMaquina) {
		this.activarProductoOrdenDetaProduMaquinaOrdenDetaProdu= habilitarResaltarProductoOrdenDetaProduMaquina;
	}


	public Border resaltarProductoOrdenDetaProduMermaOrdenDetaProdu=null;

	public Border getResaltarProductoOrdenDetaProduMermaOrdenDetaProdu() {
		return this.resaltarProductoOrdenDetaProduMermaOrdenDetaProdu;
	}

	public void setResaltarProductoOrdenDetaProduMermaOrdenDetaProdu(Border borderResaltarProductoOrdenDetaProduMerma) {
		if(borderResaltarProductoOrdenDetaProduMerma!=null) {
			this.resaltarProductoOrdenDetaProduMermaOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMerma;
		}
	}

	public Border setResaltarProductoOrdenDetaProduMermaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMerma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordendetaproduBeanSwingJInternalFrame.jTtoolBarOrdenDetaProdu.setBorder(borderResaltarProductoOrdenDetaProduMerma);
			
		this.resaltarProductoOrdenDetaProduMermaOrdenDetaProdu= borderResaltarProductoOrdenDetaProduMerma;

		 return borderResaltarProductoOrdenDetaProduMerma;
	}



	public Boolean mostrarProductoOrdenDetaProduMermaOrdenDetaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduMermaOrdenDetaProdu() {
		return this.mostrarProductoOrdenDetaProduMermaOrdenDetaProdu;
	}

	public void setMostrarProductoOrdenDetaProduMermaOrdenDetaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMerma) {
		this.mostrarProductoOrdenDetaProduMermaOrdenDetaProdu= visibilidadResaltarProductoOrdenDetaProduMerma;
	}



	public Boolean activarProductoOrdenDetaProduMermaOrdenDetaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduMermaOrdenDetaProdu() {
		return this.activarProductoOrdenDetaProduMermaOrdenDetaProdu;
	}

	public void setActivarProductoOrdenDetaProduMermaOrdenDetaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMerma) {
		this.activarProductoOrdenDetaProduMermaOrdenDetaProdu= habilitarResaltarProductoOrdenDetaProduMerma;
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

		this.setMostrarProductoOrdenDetaProduGastoOrdenDetaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduManoOrdenDetaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduOrdenDetaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduMermaOrdenDetaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduGasto.class)) {
				this.setMostrarProductoOrdenDetaProduGastoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setMostrarProductoOrdenDetaProduManoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProdu.class)) {
				this.setMostrarProductoOrdenDetaProduOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setMostrarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMerma.class)) {
				this.setMostrarProductoOrdenDetaProduMermaOrdenDetaProdu(esAsigna);
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

		this.setActivarProductoOrdenDetaProduGastoOrdenDetaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduManoOrdenDetaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduOrdenDetaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduMermaOrdenDetaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduGasto.class)) {
				this.setActivarProductoOrdenDetaProduGastoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setActivarProductoOrdenDetaProduManoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProdu.class)) {
				this.setActivarProductoOrdenDetaProduOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setActivarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMerma.class)) {
				this.setActivarProductoOrdenDetaProduMermaOrdenDetaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoOrdenDetaProduGastoOrdenDetaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduManoOrdenDetaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduOrdenDetaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduMermaOrdenDetaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduGasto.class)) {
				this.setResaltarProductoOrdenDetaProduGastoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setResaltarProductoOrdenDetaProduManoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProdu.class)) {
				this.setResaltarProductoOrdenDetaProduOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setResaltarProductoOrdenDetaProduMaquinaOrdenDetaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMerma.class)) {
				this.setResaltarProductoOrdenDetaProduMermaOrdenDetaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdBodegaOrdenDetaProdu() {
		return this.mostrarFK_IdBodegaOrdenDetaProdu;
	}

	public void setMostrarFK_IdBodegaOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaDestinoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdBodegaDestinoOrdenDetaProdu() {
		return this.mostrarFK_IdBodegaDestinoOrdenDetaProdu;
	}

	public void setMostrarFK_IdBodegaDestinoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDestinoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdEjercicioOrdenDetaProdu() {
		return this.mostrarFK_IdEjercicioOrdenDetaProdu;
	}

	public void setMostrarFK_IdEjercicioOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdEmpresaOrdenDetaProdu() {
		return this.mostrarFK_IdEmpresaOrdenDetaProdu;
	}

	public void setMostrarFK_IdEmpresaOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenProduOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdOrdenProduOrdenDetaProdu() {
		return this.mostrarFK_IdOrdenProduOrdenDetaProdu;
	}

	public void setMostrarFK_IdOrdenProduOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenProduOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdPeriodoOrdenDetaProdu() {
		return this.mostrarFK_IdPeriodoOrdenDetaProdu;
	}

	public void setMostrarFK_IdPeriodoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdProductoOrdenDetaProdu() {
		return this.mostrarFK_IdProductoOrdenDetaProdu;
	}

	public void setMostrarFK_IdProductoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdSucursalOrdenDetaProdu() {
		return this.mostrarFK_IdSucursalOrdenDetaProdu;
	}

	public void setMostrarFK_IdSucursalOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoProduOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdTipoProcesoProduOrdenDetaProdu() {
		return this.mostrarFK_IdTipoProcesoProduOrdenDetaProdu;
	}

	public void setMostrarFK_IdTipoProcesoProduOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoProduOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadUnadOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdUnidadUnadOrdenDetaProdu() {
		return this.mostrarFK_IdUnidadUnadOrdenDetaProdu;
	}

	public void setMostrarFK_IdUnidadUnadOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadUnadOrdenDetaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaOrdenDetaProdu=true;

	public Boolean getActivarFK_IdBodegaOrdenDetaProdu() {
		return this.activarFK_IdBodegaOrdenDetaProdu;
	}

	public void setActivarFK_IdBodegaOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaDestinoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdBodegaDestinoOrdenDetaProdu() {
		return this.activarFK_IdBodegaDestinoOrdenDetaProdu;
	}

	public void setActivarFK_IdBodegaDestinoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDestinoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioOrdenDetaProdu=true;

	public Boolean getActivarFK_IdEjercicioOrdenDetaProdu() {
		return this.activarFK_IdEjercicioOrdenDetaProdu;
	}

	public void setActivarFK_IdEjercicioOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaOrdenDetaProdu=true;

	public Boolean getActivarFK_IdEmpresaOrdenDetaProdu() {
		return this.activarFK_IdEmpresaOrdenDetaProdu;
	}

	public void setActivarFK_IdEmpresaOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenProduOrdenDetaProdu=true;

	public Boolean getActivarFK_IdOrdenProduOrdenDetaProdu() {
		return this.activarFK_IdOrdenProduOrdenDetaProdu;
	}

	public void setActivarFK_IdOrdenProduOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenProduOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdPeriodoOrdenDetaProdu() {
		return this.activarFK_IdPeriodoOrdenDetaProdu;
	}

	public void setActivarFK_IdPeriodoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdProductoOrdenDetaProdu() {
		return this.activarFK_IdProductoOrdenDetaProdu;
	}

	public void setActivarFK_IdProductoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalOrdenDetaProdu=true;

	public Boolean getActivarFK_IdSucursalOrdenDetaProdu() {
		return this.activarFK_IdSucursalOrdenDetaProdu;
	}

	public void setActivarFK_IdSucursalOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoProduOrdenDetaProdu=true;

	public Boolean getActivarFK_IdTipoProcesoProduOrdenDetaProdu() {
		return this.activarFK_IdTipoProcesoProduOrdenDetaProdu;
	}

	public void setActivarFK_IdTipoProcesoProduOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoProduOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadUnadOrdenDetaProdu=true;

	public Boolean getActivarFK_IdUnidadUnadOrdenDetaProdu() {
		return this.activarFK_IdUnidadUnadOrdenDetaProdu;
	}

	public void setActivarFK_IdUnidadUnadOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadUnadOrdenDetaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaOrdenDetaProdu=null;

	public Border getResaltarFK_IdBodegaOrdenDetaProdu() {
		return this.resaltarFK_IdBodegaOrdenDetaProdu;
	}

	public void setResaltarFK_IdBodegaOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdBodegaDestinoOrdenDetaProdu=null;

	public Border getResaltarFK_IdBodegaDestinoOrdenDetaProdu() {
		return this.resaltarFK_IdBodegaDestinoOrdenDetaProdu;
	}

	public void setResaltarFK_IdBodegaDestinoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaDestinoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDestinoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDestinoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioOrdenDetaProdu=null;

	public Border getResaltarFK_IdEjercicioOrdenDetaProdu() {
		return this.resaltarFK_IdEjercicioOrdenDetaProdu;
	}

	public void setResaltarFK_IdEjercicioOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdEjercicioOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaOrdenDetaProdu=null;

	public Border getResaltarFK_IdEmpresaOrdenDetaProdu() {
		return this.resaltarFK_IdEmpresaOrdenDetaProdu;
	}

	public void setResaltarFK_IdEmpresaOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdOrdenProduOrdenDetaProdu=null;

	public Border getResaltarFK_IdOrdenProduOrdenDetaProdu() {
		return this.resaltarFK_IdOrdenProduOrdenDetaProdu;
	}

	public void setResaltarFK_IdOrdenProduOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdOrdenProduOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdOrdenProduOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenProduOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoOrdenDetaProdu=null;

	public Border getResaltarFK_IdPeriodoOrdenDetaProdu() {
		return this.resaltarFK_IdPeriodoOrdenDetaProdu;
	}

	public void setResaltarFK_IdPeriodoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdPeriodoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdProductoOrdenDetaProdu=null;

	public Border getResaltarFK_IdProductoOrdenDetaProdu() {
		return this.resaltarFK_IdProductoOrdenDetaProdu;
	}

	public void setResaltarFK_IdProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdProductoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalOrdenDetaProdu=null;

	public Border getResaltarFK_IdSucursalOrdenDetaProdu() {
		return this.resaltarFK_IdSucursalOrdenDetaProdu;
	}

	public void setResaltarFK_IdSucursalOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoProduOrdenDetaProdu=null;

	public Border getResaltarFK_IdTipoProcesoProduOrdenDetaProdu() {
		return this.resaltarFK_IdTipoProcesoProduOrdenDetaProdu;
	}

	public void setResaltarFK_IdTipoProcesoProduOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoProduOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoProduOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoProduOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdUnidadUnadOrdenDetaProdu=null;

	public Border getResaltarFK_IdUnidadUnadOrdenDetaProdu() {
		return this.resaltarFK_IdUnidadUnadOrdenDetaProdu;
	}

	public void setResaltarFK_IdUnidadUnadOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdUnidadUnadOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdUnidadUnadOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenDetaProduBeanSwingJInternalFrame ordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadUnadOrdenDetaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}