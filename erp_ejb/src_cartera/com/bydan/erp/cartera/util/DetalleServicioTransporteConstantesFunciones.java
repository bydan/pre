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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.DetalleServicioTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleServicioTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleServicioTransporteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleServicioTransporteConstantesFunciones extends DetalleServicioTransporteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleServicioTransporte";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleServicioTransporte"+DetalleServicioTransporteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleServicioTransporteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleServicioTransporteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleServicioTransporteConstantesFunciones.SCHEMA+"_"+DetalleServicioTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleServicioTransporteConstantesFunciones.SCHEMA+"_"+DetalleServicioTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleServicioTransporteConstantesFunciones.SCHEMA+"_"+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleServicioTransporteConstantesFunciones.SCHEMA+"_"+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleServicioTransporteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleServicioTransporteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleServicioTransporteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleServicioTransporteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Servicio Transportes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Servicio Transporte";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Servicio Transporte";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleServicioTransporte";
	public static final String OBJECTNAME="detalleserviciotransporte";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_servicio_transporte";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleserviciotransporte from "+DetalleServicioTransporteConstantesFunciones.SPERSISTENCENAME+" detalleserviciotransporte";
	public static String QUERYSELECTNATIVE="select "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".version_row,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_servicio_transporte,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_empresa,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_periodo,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_bodega,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_producto,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_unidad,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".cantidad,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".precio,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".total,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".descripcion from "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME;//+" as "+DetalleServicioTransporteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleServicioTransporteConstantesFuncionesAdditional detalleserviciotransporteConstantesFuncionesAdditional=null;
	
	public DetalleServicioTransporteConstantesFuncionesAdditional getDetalleServicioTransporteConstantesFuncionesAdditional() {
		return this.detalleserviciotransporteConstantesFuncionesAdditional;
	}
	
	public void setDetalleServicioTransporteConstantesFuncionesAdditional(DetalleServicioTransporteConstantesFuncionesAdditional detalleserviciotransporteConstantesFuncionesAdditional) {
		try {
			this.detalleserviciotransporteConstantesFuncionesAdditional=detalleserviciotransporteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSERVICIOTRANSPORTE= "id_servicio_transporte";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String TOTAL= "total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSERVICIOTRANSPORTE= "Servicio Transporte";
		public static final String LABEL_IDSERVICIOTRANSPORTE_LOWER= "Servicio Transporte";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleServicioTransporteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDSERVICIOTRANSPORTE;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.PRECIO)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.TOTAL)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleServicioTransporteConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleServicioTransporteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleServicioTransporteDescripcion(DetalleServicioTransporte detalleserviciotransporte) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleserviciotransporte !=null/* && detalleserviciotransporte.getId()!=0*/) {
			if(detalleserviciotransporte.getId()!=null) {
				sDescripcion=detalleserviciotransporte.getId().toString();
			}//detalleserviciotransportedetalleserviciotransporte.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleServicioTransporteDescripcionDetallado(DetalleServicioTransporte detalleserviciotransporte) {
		String sDescripcion="";
			
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.ID+"=";
		sDescripcion+=detalleserviciotransporte.getId().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleserviciotransporte.getVersionRow().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE+"=";
		sDescripcion+=detalleserviciotransporte.getid_servicio_transporte().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleserviciotransporte.getid_empresa().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleserviciotransporte.getid_sucursal().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleserviciotransporte.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleserviciotransporte.getid_periodo().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleserviciotransporte.getid_bodega().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleserviciotransporte.getid_producto().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleserviciotransporte.getid_unidad().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleserviciotransporte.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleserviciotransporte.getcantidad().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.PRECIO+"=";
		sDescripcion+=detalleserviciotransporte.getprecio().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.TOTAL+"=";
		sDescripcion+=detalleserviciotransporte.gettotal().toString()+",";
		sDescripcion+=DetalleServicioTransporteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleserviciotransporte.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleServicioTransporteDescripcion(DetalleServicioTransporte detalleserviciotransporte,String sValor) throws Exception {			
		if(detalleserviciotransporte !=null) {
			//detalleserviciotransportedetalleserviciotransporte.getId().toString();
		}		
	}
	
		

	public static String getServicioTransporteDescripcion(ServicioTransporte serviciotransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(serviciotransporte!=null/*&&serviciotransporte.getId()>0*/) {
			sDescripcion=ServicioTransporteConstantesFunciones.getServicioTransporteDescripcion(serviciotransporte);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdServicioTransporte")) {
			sNombreIndice="Tipo=  Por Servicio Transporte";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

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

	public static String getDetalleIndiceFK_IdServicioTransporte(Long id_servicio_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_servicio_transporte!=null) {sDetalleIndice+=" Codigo Unico De Servicio Transporte="+id_servicio_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleserviciotransporte.setdescripcion(detalleserviciotransporte.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleServicioTransportes(List<DetalleServicioTransporte> detalleserviciotransportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleServicioTransporte detalleserviciotransporte: detalleserviciotransportes) {
			detalleserviciotransporte.setdescripcion(detalleserviciotransporte.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleserviciotransporte.getConCambioAuxiliar()) {
			detalleserviciotransporte.setIsDeleted(detalleserviciotransporte.getIsDeletedAuxiliar());	
			detalleserviciotransporte.setIsNew(detalleserviciotransporte.getIsNewAuxiliar());	
			detalleserviciotransporte.setIsChanged(detalleserviciotransporte.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleserviciotransporte.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleserviciotransporte.setIsDeletedAuxiliar(false);	
			detalleserviciotransporte.setIsNewAuxiliar(false);	
			detalleserviciotransporte.setIsChangedAuxiliar(false);
			
			detalleserviciotransporte.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleServicioTransportes(List<DetalleServicioTransporte> detalleserviciotransportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleServicioTransporte detalleserviciotransporte : detalleserviciotransportes) {
			if(conAsignarBase && detalleserviciotransporte.getConCambioAuxiliar()) {
				detalleserviciotransporte.setIsDeleted(detalleserviciotransporte.getIsDeletedAuxiliar());	
				detalleserviciotransporte.setIsNew(detalleserviciotransporte.getIsNewAuxiliar());	
				detalleserviciotransporte.setIsChanged(detalleserviciotransporte.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleserviciotransporte.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleserviciotransporte.setIsDeletedAuxiliar(false);	
				detalleserviciotransporte.setIsNewAuxiliar(false);	
				detalleserviciotransporte.setIsChangedAuxiliar(false);
				
				detalleserviciotransporte.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte,Boolean conEnteros) throws Exception  {
		detalleserviciotransporte.setprecio(0.0);
		detalleserviciotransporte.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleserviciotransporte.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleServicioTransportes(List<DetalleServicioTransporte> detalleserviciotransportes,Boolean conEnteros) throws Exception  {
		
		for(DetalleServicioTransporte detalleserviciotransporte: detalleserviciotransportes) {
			detalleserviciotransporte.setprecio(0.0);
			detalleserviciotransporte.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleserviciotransporte.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleServicioTransporte(List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporte detalleserviciotransporteAux) throws Exception  {
		DetalleServicioTransporteConstantesFunciones.InicializarValoresDetalleServicioTransporte(detalleserviciotransporteAux,true);
		
		for(DetalleServicioTransporte detalleserviciotransporte: detalleserviciotransportes) {
			if(detalleserviciotransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleserviciotransporteAux.setcantidad(detalleserviciotransporteAux.getcantidad()+detalleserviciotransporte.getcantidad());			
			detalleserviciotransporteAux.setprecio(detalleserviciotransporteAux.getprecio()+detalleserviciotransporte.getprecio());			
			detalleserviciotransporteAux.settotal(detalleserviciotransporteAux.gettotal()+detalleserviciotransporte.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleServicioTransporteConstantesFunciones.getArrayColumnasGlobalesDetalleServicioTransporte(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleServicioTransporteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleServicioTransporteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleServicioTransporteConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleServicioTransporteConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporte detalleserviciotransporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleServicioTransporte detalleserviciotransporteAux: detalleserviciotransportes) {
			if(detalleserviciotransporteAux!=null && detalleserviciotransporte!=null) {
				if((detalleserviciotransporteAux.getId()==null && detalleserviciotransporte.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleserviciotransporteAux.getId()!=null && detalleserviciotransporte.getId()!=null){
					if(detalleserviciotransporteAux.getId().equals(detalleserviciotransporte.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleServicioTransporte(List<DetalleServicioTransporte> detalleserviciotransportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetalleServicioTransporte detalleserviciotransporte: detalleserviciotransportes) {			
			if(detalleserviciotransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detalleserviciotransporte.getprecio();
			totalTotal+=detalleserviciotransporte.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleServicioTransporteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleServicioTransporteConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleServicioTransporte() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_ID, DetalleServicioTransporteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_VERSIONROW, DetalleServicioTransporteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDSERVICIOTRANSPORTE, DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDEMPRESA, DetalleServicioTransporteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL, DetalleServicioTransporteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO, DetalleServicioTransporteConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDPERIODO, DetalleServicioTransporteConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDBODEGA, DetalleServicioTransporteConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDPRODUCTO, DetalleServicioTransporteConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDUNIDAD, DetalleServicioTransporteConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_CANTIDAD, DetalleServicioTransporteConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO, DetalleServicioTransporteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL, DetalleServicioTransporteConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleServicioTransporteConstantesFunciones.LABEL_DESCRIPCION, DetalleServicioTransporteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleServicioTransporte() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleServicioTransporteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleServicioTransporte() throws Exception  {
		return DetalleServicioTransporteConstantesFunciones.getTiposSeleccionarDetalleServicioTransporte(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleServicioTransporte(Boolean conFk) throws Exception  {
		return DetalleServicioTransporteConstantesFunciones.getTiposSeleccionarDetalleServicioTransporte(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleServicioTransporte(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDSERVICIOTRANSPORTE);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDSERVICIOTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleServicioTransporte(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporteAux) throws Exception {
		
			detalleserviciotransporteAux.setserviciotransporte_descripcion(ServicioTransporteConstantesFunciones.getServicioTransporteDescripcion(detalleserviciotransporteAux.getServicioTransporte()));
			detalleserviciotransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleserviciotransporteAux.getEmpresa()));
			detalleserviciotransporteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleserviciotransporteAux.getSucursal()));
			detalleserviciotransporteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleserviciotransporteAux.getEjercicio()));
			detalleserviciotransporteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleserviciotransporteAux.getPeriodo()));
			detalleserviciotransporteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleserviciotransporteAux.getBodega()));
			detalleserviciotransporteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleserviciotransporteAux.getProducto()));
			detalleserviciotransporteAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleserviciotransporteAux.getUnidad()));
			detalleserviciotransporteAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleserviciotransporteAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleServicioTransporte(List<DetalleServicioTransporte> detalleserviciotransportesTemp) throws Exception {
		for(DetalleServicioTransporte detalleserviciotransporteAux:detalleserviciotransportesTemp) {
			
			detalleserviciotransporteAux.setserviciotransporte_descripcion(ServicioTransporteConstantesFunciones.getServicioTransporteDescripcion(detalleserviciotransporteAux.getServicioTransporte()));
			detalleserviciotransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleserviciotransporteAux.getEmpresa()));
			detalleserviciotransporteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleserviciotransporteAux.getSucursal()));
			detalleserviciotransporteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleserviciotransporteAux.getEjercicio()));
			detalleserviciotransporteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleserviciotransporteAux.getPeriodo()));
			detalleserviciotransporteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleserviciotransporteAux.getBodega()));
			detalleserviciotransporteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleserviciotransporteAux.getProducto()));
			detalleserviciotransporteAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleserviciotransporteAux.getUnidad()));
			detalleserviciotransporteAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleserviciotransporteAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ServicioTransporte.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(CentroCosto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioTransporte.class)) {
						classes.add(new Classe(ServicioTransporte.class));
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}

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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}

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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleServicioTransporteConstantesFunciones.getClassesRelationshipsOfDetalleServicioTransporte(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleServicioTransporteConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleServicioTransporte(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleServicioTransporte detalleserviciotransporte,List<DetalleServicioTransporte> detalleserviciotransportes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleServicioTransporte detalleserviciotransporteEncontrado=null;
			
			for(DetalleServicioTransporte detalleserviciotransporteLocal:detalleserviciotransportes) {
				if(detalleserviciotransporteLocal.getId().equals(detalleserviciotransporte.getId())) {
					detalleserviciotransporteEncontrado=detalleserviciotransporteLocal;
					
					detalleserviciotransporteLocal.setIsChanged(detalleserviciotransporte.getIsChanged());
					detalleserviciotransporteLocal.setIsNew(detalleserviciotransporte.getIsNew());
					detalleserviciotransporteLocal.setIsDeleted(detalleserviciotransporte.getIsDeleted());
					
					detalleserviciotransporteLocal.setGeneralEntityOriginal(detalleserviciotransporte.getGeneralEntityOriginal());
					
					detalleserviciotransporteLocal.setId(detalleserviciotransporte.getId());	
					detalleserviciotransporteLocal.setVersionRow(detalleserviciotransporte.getVersionRow());	
					detalleserviciotransporteLocal.setid_servicio_transporte(detalleserviciotransporte.getid_servicio_transporte());	
					detalleserviciotransporteLocal.setid_empresa(detalleserviciotransporte.getid_empresa());	
					detalleserviciotransporteLocal.setid_sucursal(detalleserviciotransporte.getid_sucursal());	
					detalleserviciotransporteLocal.setid_ejercicio(detalleserviciotransporte.getid_ejercicio());	
					detalleserviciotransporteLocal.setid_periodo(detalleserviciotransporte.getid_periodo());	
					detalleserviciotransporteLocal.setid_bodega(detalleserviciotransporte.getid_bodega());	
					detalleserviciotransporteLocal.setid_producto(detalleserviciotransporte.getid_producto());	
					detalleserviciotransporteLocal.setid_unidad(detalleserviciotransporte.getid_unidad());	
					detalleserviciotransporteLocal.setid_centro_costo(detalleserviciotransporte.getid_centro_costo());	
					detalleserviciotransporteLocal.setcantidad(detalleserviciotransporte.getcantidad());	
					detalleserviciotransporteLocal.setprecio(detalleserviciotransporte.getprecio());	
					detalleserviciotransporteLocal.settotal(detalleserviciotransporte.gettotal());	
					detalleserviciotransporteLocal.setdescripcion(detalleserviciotransporte.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleserviciotransporte.getIsDeleted()) {
				if(!existe) {
					detalleserviciotransportes.add(detalleserviciotransporte);
				}
			} else {
				if(detalleserviciotransporteEncontrado!=null && permiteQuitar)  {
					detalleserviciotransportes.remove(detalleserviciotransporteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleServicioTransporte detalleserviciotransporte,List<DetalleServicioTransporte> detalleserviciotransportes) throws Exception {
		try	{			
			for(DetalleServicioTransporte detalleserviciotransporteLocal:detalleserviciotransportes) {
				if(detalleserviciotransporteLocal.getId().equals(detalleserviciotransporte.getId())) {
					detalleserviciotransporteLocal.setIsSelected(detalleserviciotransporte.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleServicioTransporte(List<DetalleServicioTransporte> detalleserviciotransportesAux) throws Exception {
		//this.detalleserviciotransportesAux=detalleserviciotransportesAux;
		
		for(DetalleServicioTransporte detalleserviciotransporteAux:detalleserviciotransportesAux) {
			if(detalleserviciotransporteAux.getIsChanged()) {
				detalleserviciotransporteAux.setIsChanged(false);
			}		
			
			if(detalleserviciotransporteAux.getIsNew()) {
				detalleserviciotransporteAux.setIsNew(false);
			}	
			
			if(detalleserviciotransporteAux.getIsDeleted()) {
				detalleserviciotransporteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporteAux) throws Exception {
		//this.detalleserviciotransporteAux=detalleserviciotransporteAux;
		
			if(detalleserviciotransporteAux.getIsChanged()) {
				detalleserviciotransporteAux.setIsChanged(false);
			}		
			
			if(detalleserviciotransporteAux.getIsNew()) {
				detalleserviciotransporteAux.setIsNew(false);
			}	
			
			if(detalleserviciotransporteAux.getIsDeleted()) {
				detalleserviciotransporteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleServicioTransporte detalleserviciotransporteAsignar,DetalleServicioTransporte detalleserviciotransporte) throws Exception {
		detalleserviciotransporteAsignar.setId(detalleserviciotransporte.getId());	
		detalleserviciotransporteAsignar.setVersionRow(detalleserviciotransporte.getVersionRow());	
		detalleserviciotransporteAsignar.setid_servicio_transporte(detalleserviciotransporte.getid_servicio_transporte());
		detalleserviciotransporteAsignar.setserviciotransporte_descripcion(detalleserviciotransporte.getserviciotransporte_descripcion());	
		detalleserviciotransporteAsignar.setid_empresa(detalleserviciotransporte.getid_empresa());
		detalleserviciotransporteAsignar.setempresa_descripcion(detalleserviciotransporte.getempresa_descripcion());	
		detalleserviciotransporteAsignar.setid_sucursal(detalleserviciotransporte.getid_sucursal());
		detalleserviciotransporteAsignar.setsucursal_descripcion(detalleserviciotransporte.getsucursal_descripcion());	
		detalleserviciotransporteAsignar.setid_ejercicio(detalleserviciotransporte.getid_ejercicio());
		detalleserviciotransporteAsignar.setejercicio_descripcion(detalleserviciotransporte.getejercicio_descripcion());	
		detalleserviciotransporteAsignar.setid_periodo(detalleserviciotransporte.getid_periodo());
		detalleserviciotransporteAsignar.setperiodo_descripcion(detalleserviciotransporte.getperiodo_descripcion());	
		detalleserviciotransporteAsignar.setid_bodega(detalleserviciotransporte.getid_bodega());
		detalleserviciotransporteAsignar.setbodega_descripcion(detalleserviciotransporte.getbodega_descripcion());	
		detalleserviciotransporteAsignar.setid_producto(detalleserviciotransporte.getid_producto());
		detalleserviciotransporteAsignar.setproducto_descripcion(detalleserviciotransporte.getproducto_descripcion());	
		detalleserviciotransporteAsignar.setid_unidad(detalleserviciotransporte.getid_unidad());
		detalleserviciotransporteAsignar.setunidad_descripcion(detalleserviciotransporte.getunidad_descripcion());	
		detalleserviciotransporteAsignar.setid_centro_costo(detalleserviciotransporte.getid_centro_costo());
		detalleserviciotransporteAsignar.setcentrocosto_descripcion(detalleserviciotransporte.getcentrocosto_descripcion());	
		detalleserviciotransporteAsignar.setcantidad(detalleserviciotransporte.getcantidad());	
		detalleserviciotransporteAsignar.setprecio(detalleserviciotransporte.getprecio());	
		detalleserviciotransporteAsignar.settotal(detalleserviciotransporte.gettotal());	
		detalleserviciotransporteAsignar.setdescripcion(detalleserviciotransporte.getdescripcion());	
	}
	
	public static void inicializarDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte) throws Exception {
		try {
				detalleserviciotransporte.setId(0L);	
					
				detalleserviciotransporte.setid_servicio_transporte(-1L);	
				detalleserviciotransporte.setid_empresa(-1L);	
				detalleserviciotransporte.setid_sucursal(-1L);	
				detalleserviciotransporte.setid_ejercicio(-1L);	
				detalleserviciotransporte.setid_periodo(-1L);	
				detalleserviciotransporte.setid_bodega(-1L);	
				detalleserviciotransporte.setid_producto(-1L);	
				detalleserviciotransporte.setid_unidad(-1L);	
				detalleserviciotransporte.setid_centro_costo(null);	
				detalleserviciotransporte.setcantidad(0);	
				detalleserviciotransporte.setprecio(0.0);	
				detalleserviciotransporte.settotal(0.0);	
				detalleserviciotransporte.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleServicioTransporte(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDSERVICIOTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleServicioTransporte(String sTipo,Row row,Workbook workbook,DetalleServicioTransporte detalleserviciotransporte,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getserviciotransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserviciotransporte.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleServicioTransporte=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleServicioTransporte() {
		return this.sFinalQueryDetalleServicioTransporte;
	}
	
	public void setsFinalQueryDetalleServicioTransporte(String sFinalQueryDetalleServicioTransporte) {
		this.sFinalQueryDetalleServicioTransporte= sFinalQueryDetalleServicioTransporte;
	}
	
	public Border resaltarSeleccionarDetalleServicioTransporte=null;
	
	public Border setResaltarSeleccionarDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleServicioTransporte= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleServicioTransporte() {
		return this.resaltarSeleccionarDetalleServicioTransporte;
	}
	
	public void setResaltarSeleccionarDetalleServicioTransporte(Border borderResaltarSeleccionarDetalleServicioTransporte) {
		this.resaltarSeleccionarDetalleServicioTransporte= borderResaltarSeleccionarDetalleServicioTransporte;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleServicioTransporte=null;
	public Boolean mostraridDetalleServicioTransporte=true;
	public Boolean activaridDetalleServicioTransporte=true;

	public Border resaltarid_servicio_transporteDetalleServicioTransporte=null;
	public Boolean mostrarid_servicio_transporteDetalleServicioTransporte=true;
	public Boolean activarid_servicio_transporteDetalleServicioTransporte=true;
	public Boolean cargarid_servicio_transporteDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_servicio_transporteDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleServicioTransporte=null;
	public Boolean mostrarid_empresaDetalleServicioTransporte=true;
	public Boolean activarid_empresaDetalleServicioTransporte=true;
	public Boolean cargarid_empresaDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleServicioTransporte=null;
	public Boolean mostrarid_sucursalDetalleServicioTransporte=true;
	public Boolean activarid_sucursalDetalleServicioTransporte=true;
	public Boolean cargarid_sucursalDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleServicioTransporte=null;
	public Boolean mostrarid_ejercicioDetalleServicioTransporte=true;
	public Boolean activarid_ejercicioDetalleServicioTransporte=true;
	public Boolean cargarid_ejercicioDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleServicioTransporte=null;
	public Boolean mostrarid_periodoDetalleServicioTransporte=true;
	public Boolean activarid_periodoDetalleServicioTransporte=true;
	public Boolean cargarid_periodoDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleServicioTransporte=null;
	public Boolean mostrarid_bodegaDetalleServicioTransporte=true;
	public Boolean activarid_bodegaDetalleServicioTransporte=true;
	public Boolean cargarid_bodegaDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleServicioTransporte=null;
	public Boolean mostrarid_productoDetalleServicioTransporte=true;
	public Boolean activarid_productoDetalleServicioTransporte=true;
	public Boolean cargarid_productoDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleServicioTransporte=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleServicioTransporte=null;
	public Boolean mostrarid_unidadDetalleServicioTransporte=true;
	public Boolean activarid_unidadDetalleServicioTransporte=true;
	public Boolean cargarid_unidadDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleServicioTransporte=true;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleServicioTransporte=null;
	public Boolean mostrarid_centro_costoDetalleServicioTransporte=true;
	public Boolean activarid_centro_costoDetalleServicioTransporte=true;
	public Boolean cargarid_centro_costoDetalleServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleServicioTransporte=false;//ConEventDepend=true

	public Border resaltarcantidadDetalleServicioTransporte=null;
	public Boolean mostrarcantidadDetalleServicioTransporte=true;
	public Boolean activarcantidadDetalleServicioTransporte=true;

	public Border resaltarprecioDetalleServicioTransporte=null;
	public Boolean mostrarprecioDetalleServicioTransporte=true;
	public Boolean activarprecioDetalleServicioTransporte=true;

	public Border resaltartotalDetalleServicioTransporte=null;
	public Boolean mostrartotalDetalleServicioTransporte=true;
	public Boolean activartotalDetalleServicioTransporte=true;

	public Border resaltardescripcionDetalleServicioTransporte=null;
	public Boolean mostrardescripcionDetalleServicioTransporte=true;
	public Boolean activardescripcionDetalleServicioTransporte=true;

	
	

	public Border setResaltaridDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltaridDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleServicioTransporte() {
		return this.resaltaridDetalleServicioTransporte;
	}

	public void setResaltaridDetalleServicioTransporte(Border borderResaltar) {
		this.resaltaridDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostraridDetalleServicioTransporte() {
		return this.mostraridDetalleServicioTransporte;
	}

	public void setMostraridDetalleServicioTransporte(Boolean mostraridDetalleServicioTransporte) {
		this.mostraridDetalleServicioTransporte= mostraridDetalleServicioTransporte;
	}

	public Boolean getActivaridDetalleServicioTransporte() {
		return this.activaridDetalleServicioTransporte;
	}

	public void setActivaridDetalleServicioTransporte(Boolean activaridDetalleServicioTransporte) {
		this.activaridDetalleServicioTransporte= activaridDetalleServicioTransporte;
	}

	public Border setResaltarid_servicio_transporteDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_servicio_transporteDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_servicio_transporteDetalleServicioTransporte() {
		return this.resaltarid_servicio_transporteDetalleServicioTransporte;
	}

	public void setResaltarid_servicio_transporteDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_servicio_transporteDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_servicio_transporteDetalleServicioTransporte() {
		return this.mostrarid_servicio_transporteDetalleServicioTransporte;
	}

	public void setMostrarid_servicio_transporteDetalleServicioTransporte(Boolean mostrarid_servicio_transporteDetalleServicioTransporte) {
		this.mostrarid_servicio_transporteDetalleServicioTransporte= mostrarid_servicio_transporteDetalleServicioTransporte;
	}

	public Boolean getActivarid_servicio_transporteDetalleServicioTransporte() {
		return this.activarid_servicio_transporteDetalleServicioTransporte;
	}

	public void setActivarid_servicio_transporteDetalleServicioTransporte(Boolean activarid_servicio_transporteDetalleServicioTransporte) {
		this.activarid_servicio_transporteDetalleServicioTransporte= activarid_servicio_transporteDetalleServicioTransporte;
	}

	public Boolean getCargarid_servicio_transporteDetalleServicioTransporte() {
		return this.cargarid_servicio_transporteDetalleServicioTransporte;
	}

	public void setCargarid_servicio_transporteDetalleServicioTransporte(Boolean cargarid_servicio_transporteDetalleServicioTransporte) {
		this.cargarid_servicio_transporteDetalleServicioTransporte= cargarid_servicio_transporteDetalleServicioTransporte;
	}

	public Border setResaltarid_empresaDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleServicioTransporte() {
		return this.resaltarid_empresaDetalleServicioTransporte;
	}

	public void setResaltarid_empresaDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_empresaDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleServicioTransporte() {
		return this.mostrarid_empresaDetalleServicioTransporte;
	}

	public void setMostrarid_empresaDetalleServicioTransporte(Boolean mostrarid_empresaDetalleServicioTransporte) {
		this.mostrarid_empresaDetalleServicioTransporte= mostrarid_empresaDetalleServicioTransporte;
	}

	public Boolean getActivarid_empresaDetalleServicioTransporte() {
		return this.activarid_empresaDetalleServicioTransporte;
	}

	public void setActivarid_empresaDetalleServicioTransporte(Boolean activarid_empresaDetalleServicioTransporte) {
		this.activarid_empresaDetalleServicioTransporte= activarid_empresaDetalleServicioTransporte;
	}

	public Boolean getCargarid_empresaDetalleServicioTransporte() {
		return this.cargarid_empresaDetalleServicioTransporte;
	}

	public void setCargarid_empresaDetalleServicioTransporte(Boolean cargarid_empresaDetalleServicioTransporte) {
		this.cargarid_empresaDetalleServicioTransporte= cargarid_empresaDetalleServicioTransporte;
	}

	public Border setResaltarid_sucursalDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleServicioTransporte() {
		return this.resaltarid_sucursalDetalleServicioTransporte;
	}

	public void setResaltarid_sucursalDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_sucursalDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleServicioTransporte() {
		return this.mostrarid_sucursalDetalleServicioTransporte;
	}

	public void setMostrarid_sucursalDetalleServicioTransporte(Boolean mostrarid_sucursalDetalleServicioTransporte) {
		this.mostrarid_sucursalDetalleServicioTransporte= mostrarid_sucursalDetalleServicioTransporte;
	}

	public Boolean getActivarid_sucursalDetalleServicioTransporte() {
		return this.activarid_sucursalDetalleServicioTransporte;
	}

	public void setActivarid_sucursalDetalleServicioTransporte(Boolean activarid_sucursalDetalleServicioTransporte) {
		this.activarid_sucursalDetalleServicioTransporte= activarid_sucursalDetalleServicioTransporte;
	}

	public Boolean getCargarid_sucursalDetalleServicioTransporte() {
		return this.cargarid_sucursalDetalleServicioTransporte;
	}

	public void setCargarid_sucursalDetalleServicioTransporte(Boolean cargarid_sucursalDetalleServicioTransporte) {
		this.cargarid_sucursalDetalleServicioTransporte= cargarid_sucursalDetalleServicioTransporte;
	}

	public Border setResaltarid_ejercicioDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleServicioTransporte() {
		return this.resaltarid_ejercicioDetalleServicioTransporte;
	}

	public void setResaltarid_ejercicioDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleServicioTransporte() {
		return this.mostrarid_ejercicioDetalleServicioTransporte;
	}

	public void setMostrarid_ejercicioDetalleServicioTransporte(Boolean mostrarid_ejercicioDetalleServicioTransporte) {
		this.mostrarid_ejercicioDetalleServicioTransporte= mostrarid_ejercicioDetalleServicioTransporte;
	}

	public Boolean getActivarid_ejercicioDetalleServicioTransporte() {
		return this.activarid_ejercicioDetalleServicioTransporte;
	}

	public void setActivarid_ejercicioDetalleServicioTransporte(Boolean activarid_ejercicioDetalleServicioTransporte) {
		this.activarid_ejercicioDetalleServicioTransporte= activarid_ejercicioDetalleServicioTransporte;
	}

	public Boolean getCargarid_ejercicioDetalleServicioTransporte() {
		return this.cargarid_ejercicioDetalleServicioTransporte;
	}

	public void setCargarid_ejercicioDetalleServicioTransporte(Boolean cargarid_ejercicioDetalleServicioTransporte) {
		this.cargarid_ejercicioDetalleServicioTransporte= cargarid_ejercicioDetalleServicioTransporte;
	}

	public Border setResaltarid_periodoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleServicioTransporte() {
		return this.resaltarid_periodoDetalleServicioTransporte;
	}

	public void setResaltarid_periodoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_periodoDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleServicioTransporte() {
		return this.mostrarid_periodoDetalleServicioTransporte;
	}

	public void setMostrarid_periodoDetalleServicioTransporte(Boolean mostrarid_periodoDetalleServicioTransporte) {
		this.mostrarid_periodoDetalleServicioTransporte= mostrarid_periodoDetalleServicioTransporte;
	}

	public Boolean getActivarid_periodoDetalleServicioTransporte() {
		return this.activarid_periodoDetalleServicioTransporte;
	}

	public void setActivarid_periodoDetalleServicioTransporte(Boolean activarid_periodoDetalleServicioTransporte) {
		this.activarid_periodoDetalleServicioTransporte= activarid_periodoDetalleServicioTransporte;
	}

	public Boolean getCargarid_periodoDetalleServicioTransporte() {
		return this.cargarid_periodoDetalleServicioTransporte;
	}

	public void setCargarid_periodoDetalleServicioTransporte(Boolean cargarid_periodoDetalleServicioTransporte) {
		this.cargarid_periodoDetalleServicioTransporte= cargarid_periodoDetalleServicioTransporte;
	}

	public Border setResaltarid_bodegaDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleServicioTransporte() {
		return this.resaltarid_bodegaDetalleServicioTransporte;
	}

	public void setResaltarid_bodegaDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_bodegaDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleServicioTransporte() {
		return this.mostrarid_bodegaDetalleServicioTransporte;
	}

	public void setMostrarid_bodegaDetalleServicioTransporte(Boolean mostrarid_bodegaDetalleServicioTransporte) {
		this.mostrarid_bodegaDetalleServicioTransporte= mostrarid_bodegaDetalleServicioTransporte;
	}

	public Boolean getActivarid_bodegaDetalleServicioTransporte() {
		return this.activarid_bodegaDetalleServicioTransporte;
	}

	public void setActivarid_bodegaDetalleServicioTransporte(Boolean activarid_bodegaDetalleServicioTransporte) {
		this.activarid_bodegaDetalleServicioTransporte= activarid_bodegaDetalleServicioTransporte;
	}

	public Boolean getCargarid_bodegaDetalleServicioTransporte() {
		return this.cargarid_bodegaDetalleServicioTransporte;
	}

	public void setCargarid_bodegaDetalleServicioTransporte(Boolean cargarid_bodegaDetalleServicioTransporte) {
		this.cargarid_bodegaDetalleServicioTransporte= cargarid_bodegaDetalleServicioTransporte;
	}

	public Border setResaltarid_productoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleServicioTransporte() {
		return this.resaltarid_productoDetalleServicioTransporte;
	}

	public void setResaltarid_productoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_productoDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleServicioTransporte() {
		return this.mostrarid_productoDetalleServicioTransporte;
	}

	public void setMostrarid_productoDetalleServicioTransporte(Boolean mostrarid_productoDetalleServicioTransporte) {
		this.mostrarid_productoDetalleServicioTransporte= mostrarid_productoDetalleServicioTransporte;
	}

	public Boolean getActivarid_productoDetalleServicioTransporte() {
		return this.activarid_productoDetalleServicioTransporte;
	}

	public void setActivarid_productoDetalleServicioTransporte(Boolean activarid_productoDetalleServicioTransporte) {
		this.activarid_productoDetalleServicioTransporte= activarid_productoDetalleServicioTransporte;
	}

	public Boolean getCargarid_productoDetalleServicioTransporte() {
		return this.cargarid_productoDetalleServicioTransporte;
	}

	public void setCargarid_productoDetalleServicioTransporte(Boolean cargarid_productoDetalleServicioTransporte) {
		this.cargarid_productoDetalleServicioTransporte= cargarid_productoDetalleServicioTransporte;
	}

	public Border setResaltarid_unidadDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleServicioTransporte() {
		return this.resaltarid_unidadDetalleServicioTransporte;
	}

	public void setResaltarid_unidadDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_unidadDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleServicioTransporte() {
		return this.mostrarid_unidadDetalleServicioTransporte;
	}

	public void setMostrarid_unidadDetalleServicioTransporte(Boolean mostrarid_unidadDetalleServicioTransporte) {
		this.mostrarid_unidadDetalleServicioTransporte= mostrarid_unidadDetalleServicioTransporte;
	}

	public Boolean getActivarid_unidadDetalleServicioTransporte() {
		return this.activarid_unidadDetalleServicioTransporte;
	}

	public void setActivarid_unidadDetalleServicioTransporte(Boolean activarid_unidadDetalleServicioTransporte) {
		this.activarid_unidadDetalleServicioTransporte= activarid_unidadDetalleServicioTransporte;
	}

	public Boolean getCargarid_unidadDetalleServicioTransporte() {
		return this.cargarid_unidadDetalleServicioTransporte;
	}

	public void setCargarid_unidadDetalleServicioTransporte(Boolean cargarid_unidadDetalleServicioTransporte) {
		this.cargarid_unidadDetalleServicioTransporte= cargarid_unidadDetalleServicioTransporte;
	}

	public Border setResaltarid_centro_costoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleServicioTransporte() {
		return this.resaltarid_centro_costoDetalleServicioTransporte;
	}

	public void setResaltarid_centro_costoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleServicioTransporte() {
		return this.mostrarid_centro_costoDetalleServicioTransporte;
	}

	public void setMostrarid_centro_costoDetalleServicioTransporte(Boolean mostrarid_centro_costoDetalleServicioTransporte) {
		this.mostrarid_centro_costoDetalleServicioTransporte= mostrarid_centro_costoDetalleServicioTransporte;
	}

	public Boolean getActivarid_centro_costoDetalleServicioTransporte() {
		return this.activarid_centro_costoDetalleServicioTransporte;
	}

	public void setActivarid_centro_costoDetalleServicioTransporte(Boolean activarid_centro_costoDetalleServicioTransporte) {
		this.activarid_centro_costoDetalleServicioTransporte= activarid_centro_costoDetalleServicioTransporte;
	}

	public Boolean getCargarid_centro_costoDetalleServicioTransporte() {
		return this.cargarid_centro_costoDetalleServicioTransporte;
	}

	public void setCargarid_centro_costoDetalleServicioTransporte(Boolean cargarid_centro_costoDetalleServicioTransporte) {
		this.cargarid_centro_costoDetalleServicioTransporte= cargarid_centro_costoDetalleServicioTransporte;
	}

	public Border setResaltarcantidadDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleServicioTransporte() {
		return this.resaltarcantidadDetalleServicioTransporte;
	}

	public void setResaltarcantidadDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarcantidadDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleServicioTransporte() {
		return this.mostrarcantidadDetalleServicioTransporte;
	}

	public void setMostrarcantidadDetalleServicioTransporte(Boolean mostrarcantidadDetalleServicioTransporte) {
		this.mostrarcantidadDetalleServicioTransporte= mostrarcantidadDetalleServicioTransporte;
	}

	public Boolean getActivarcantidadDetalleServicioTransporte() {
		return this.activarcantidadDetalleServicioTransporte;
	}

	public void setActivarcantidadDetalleServicioTransporte(Boolean activarcantidadDetalleServicioTransporte) {
		this.activarcantidadDetalleServicioTransporte= activarcantidadDetalleServicioTransporte;
	}

	public Border setResaltarprecioDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleServicioTransporte() {
		return this.resaltarprecioDetalleServicioTransporte;
	}

	public void setResaltarprecioDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarprecioDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleServicioTransporte() {
		return this.mostrarprecioDetalleServicioTransporte;
	}

	public void setMostrarprecioDetalleServicioTransporte(Boolean mostrarprecioDetalleServicioTransporte) {
		this.mostrarprecioDetalleServicioTransporte= mostrarprecioDetalleServicioTransporte;
	}

	public Boolean getActivarprecioDetalleServicioTransporte() {
		return this.activarprecioDetalleServicioTransporte;
	}

	public void setActivarprecioDetalleServicioTransporte(Boolean activarprecioDetalleServicioTransporte) {
		this.activarprecioDetalleServicioTransporte= activarprecioDetalleServicioTransporte;
	}

	public Border setResaltartotalDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltartotalDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleServicioTransporte() {
		return this.resaltartotalDetalleServicioTransporte;
	}

	public void setResaltartotalDetalleServicioTransporte(Border borderResaltar) {
		this.resaltartotalDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrartotalDetalleServicioTransporte() {
		return this.mostrartotalDetalleServicioTransporte;
	}

	public void setMostrartotalDetalleServicioTransporte(Boolean mostrartotalDetalleServicioTransporte) {
		this.mostrartotalDetalleServicioTransporte= mostrartotalDetalleServicioTransporte;
	}

	public Boolean getActivartotalDetalleServicioTransporte() {
		return this.activartotalDetalleServicioTransporte;
	}

	public void setActivartotalDetalleServicioTransporte(Boolean activartotalDetalleServicioTransporte) {
		this.activartotalDetalleServicioTransporte= activartotalDetalleServicioTransporte;
	}

	public Border setResaltardescripcionDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserviciotransporteBeanSwingJInternalFrame.jTtoolBarDetalleServicioTransporte.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleServicioTransporte() {
		return this.resaltardescripcionDetalleServicioTransporte;
	}

	public void setResaltardescripcionDetalleServicioTransporte(Border borderResaltar) {
		this.resaltardescripcionDetalleServicioTransporte= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleServicioTransporte() {
		return this.mostrardescripcionDetalleServicioTransporte;
	}

	public void setMostrardescripcionDetalleServicioTransporte(Boolean mostrardescripcionDetalleServicioTransporte) {
		this.mostrardescripcionDetalleServicioTransporte= mostrardescripcionDetalleServicioTransporte;
	}

	public Boolean getActivardescripcionDetalleServicioTransporte() {
		return this.activardescripcionDetalleServicioTransporte;
	}

	public void setActivardescripcionDetalleServicioTransporte(Boolean activardescripcionDetalleServicioTransporte) {
		this.activardescripcionDetalleServicioTransporte= activardescripcionDetalleServicioTransporte;
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
		
		
		this.setMostraridDetalleServicioTransporte(esInicial);
		this.setMostrarid_servicio_transporteDetalleServicioTransporte(esInicial);
		this.setMostrarid_empresaDetalleServicioTransporte(esInicial);
		this.setMostrarid_sucursalDetalleServicioTransporte(esInicial);
		this.setMostrarid_ejercicioDetalleServicioTransporte(esInicial);
		this.setMostrarid_periodoDetalleServicioTransporte(esInicial);
		this.setMostrarid_bodegaDetalleServicioTransporte(esInicial);
		this.setMostrarid_productoDetalleServicioTransporte(esInicial);
		this.setMostrarid_unidadDetalleServicioTransporte(esInicial);
		this.setMostrarid_centro_costoDetalleServicioTransporte(esInicial);
		this.setMostrarcantidadDetalleServicioTransporte(esInicial);
		this.setMostrarprecioDetalleServicioTransporte(esInicial);
		this.setMostrartotalDetalleServicioTransporte(esInicial);
		this.setMostrardescripcionDetalleServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.ID)) {
				this.setMostraridDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE)) {
				this.setMostrarid_servicio_transporteDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleServicioTransporte(esAsigna);
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
		
		
		this.setActivaridDetalleServicioTransporte(esInicial);
		this.setActivarid_servicio_transporteDetalleServicioTransporte(esInicial);
		this.setActivarid_empresaDetalleServicioTransporte(esInicial);
		this.setActivarid_sucursalDetalleServicioTransporte(esInicial);
		this.setActivarid_ejercicioDetalleServicioTransporte(esInicial);
		this.setActivarid_periodoDetalleServicioTransporte(esInicial);
		this.setActivarid_bodegaDetalleServicioTransporte(esInicial);
		this.setActivarid_productoDetalleServicioTransporte(esInicial);
		this.setActivarid_unidadDetalleServicioTransporte(esInicial);
		this.setActivarid_centro_costoDetalleServicioTransporte(esInicial);
		this.setActivarcantidadDetalleServicioTransporte(esInicial);
		this.setActivarprecioDetalleServicioTransporte(esInicial);
		this.setActivartotalDetalleServicioTransporte(esInicial);
		this.setActivardescripcionDetalleServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.ID)) {
				this.setActivaridDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE)) {
				this.setActivarid_servicio_transporteDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleServicioTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleServicioTransporte(esInicial);
		this.setResaltarid_servicio_transporteDetalleServicioTransporte(esInicial);
		this.setResaltarid_empresaDetalleServicioTransporte(esInicial);
		this.setResaltarid_sucursalDetalleServicioTransporte(esInicial);
		this.setResaltarid_ejercicioDetalleServicioTransporte(esInicial);
		this.setResaltarid_periodoDetalleServicioTransporte(esInicial);
		this.setResaltarid_bodegaDetalleServicioTransporte(esInicial);
		this.setResaltarid_productoDetalleServicioTransporte(esInicial);
		this.setResaltarid_unidadDetalleServicioTransporte(esInicial);
		this.setResaltarid_centro_costoDetalleServicioTransporte(esInicial);
		this.setResaltarcantidadDetalleServicioTransporte(esInicial);
		this.setResaltarprecioDetalleServicioTransporte(esInicial);
		this.setResaltartotalDetalleServicioTransporte(esInicial);
		this.setResaltardescripcionDetalleServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.ID)) {
				this.setResaltaridDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE)) {
				this.setResaltarid_servicio_transporteDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleServicioTransporte(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdBodegaDetalleServicioTransporte() {
		return this.mostrarFK_IdBodegaDetalleServicioTransporte;
	}

	public void setMostrarFK_IdBodegaDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleServicioTransporte() {
		return this.mostrarFK_IdCentroCostoDetalleServicioTransporte;
	}

	public void setMostrarFK_IdCentroCostoDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdEjercicioDetalleServicioTransporte() {
		return this.mostrarFK_IdEjercicioDetalleServicioTransporte;
	}

	public void setMostrarFK_IdEjercicioDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdEmpresaDetalleServicioTransporte() {
		return this.mostrarFK_IdEmpresaDetalleServicioTransporte;
	}

	public void setMostrarFK_IdEmpresaDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdPeriodoDetalleServicioTransporte() {
		return this.mostrarFK_IdPeriodoDetalleServicioTransporte;
	}

	public void setMostrarFK_IdPeriodoDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdProductoDetalleServicioTransporte() {
		return this.mostrarFK_IdProductoDetalleServicioTransporte;
	}

	public void setMostrarFK_IdProductoDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdServicioTransporteDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdServicioTransporteDetalleServicioTransporte() {
		return this.mostrarFK_IdServicioTransporteDetalleServicioTransporte;
	}

	public void setMostrarFK_IdServicioTransporteDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdServicioTransporteDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdSucursalDetalleServicioTransporte() {
		return this.mostrarFK_IdSucursalDetalleServicioTransporte;
	}

	public void setMostrarFK_IdSucursalDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleServicioTransporte=true;

	public Boolean getMostrarFK_IdUnidadDetalleServicioTransporte() {
		return this.mostrarFK_IdUnidadDetalleServicioTransporte;
	}

	public void setMostrarFK_IdUnidadDetalleServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleServicioTransporte= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdBodegaDetalleServicioTransporte() {
		return this.activarFK_IdBodegaDetalleServicioTransporte;
	}

	public void setActivarFK_IdBodegaDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdCentroCostoDetalleServicioTransporte() {
		return this.activarFK_IdCentroCostoDetalleServicioTransporte;
	}

	public void setActivarFK_IdCentroCostoDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdEjercicioDetalleServicioTransporte() {
		return this.activarFK_IdEjercicioDetalleServicioTransporte;
	}

	public void setActivarFK_IdEjercicioDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdEmpresaDetalleServicioTransporte() {
		return this.activarFK_IdEmpresaDetalleServicioTransporte;
	}

	public void setActivarFK_IdEmpresaDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdPeriodoDetalleServicioTransporte() {
		return this.activarFK_IdPeriodoDetalleServicioTransporte;
	}

	public void setActivarFK_IdPeriodoDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdProductoDetalleServicioTransporte() {
		return this.activarFK_IdProductoDetalleServicioTransporte;
	}

	public void setActivarFK_IdProductoDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdServicioTransporteDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdServicioTransporteDetalleServicioTransporte() {
		return this.activarFK_IdServicioTransporteDetalleServicioTransporte;
	}

	public void setActivarFK_IdServicioTransporteDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdServicioTransporteDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdSucursalDetalleServicioTransporte() {
		return this.activarFK_IdSucursalDetalleServicioTransporte;
	}

	public void setActivarFK_IdSucursalDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleServicioTransporte=true;

	public Boolean getActivarFK_IdUnidadDetalleServicioTransporte() {
		return this.activarFK_IdUnidadDetalleServicioTransporte;
	}

	public void setActivarFK_IdUnidadDetalleServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleServicioTransporte= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleServicioTransporte=null;

	public Border getResaltarFK_IdBodegaDetalleServicioTransporte() {
		return this.resaltarFK_IdBodegaDetalleServicioTransporte;
	}

	public void setResaltarFK_IdBodegaDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleServicioTransporte=null;

	public Border getResaltarFK_IdCentroCostoDetalleServicioTransporte() {
		return this.resaltarFK_IdCentroCostoDetalleServicioTransporte;
	}

	public void setResaltarFK_IdCentroCostoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleServicioTransporte=null;

	public Border getResaltarFK_IdEjercicioDetalleServicioTransporte() {
		return this.resaltarFK_IdEjercicioDetalleServicioTransporte;
	}

	public void setResaltarFK_IdEjercicioDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleServicioTransporte=null;

	public Border getResaltarFK_IdEmpresaDetalleServicioTransporte() {
		return this.resaltarFK_IdEmpresaDetalleServicioTransporte;
	}

	public void setResaltarFK_IdEmpresaDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleServicioTransporte=null;

	public Border getResaltarFK_IdPeriodoDetalleServicioTransporte() {
		return this.resaltarFK_IdPeriodoDetalleServicioTransporte;
	}

	public void setResaltarFK_IdPeriodoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleServicioTransporte=null;

	public Border getResaltarFK_IdProductoDetalleServicioTransporte() {
		return this.resaltarFK_IdProductoDetalleServicioTransporte;
	}

	public void setResaltarFK_IdProductoDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdServicioTransporteDetalleServicioTransporte=null;

	public Border getResaltarFK_IdServicioTransporteDetalleServicioTransporte() {
		return this.resaltarFK_IdServicioTransporteDetalleServicioTransporte;
	}

	public void setResaltarFK_IdServicioTransporteDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdServicioTransporteDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdServicioTransporteDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdServicioTransporteDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleServicioTransporte=null;

	public Border getResaltarFK_IdSucursalDetalleServicioTransporte() {
		return this.resaltarFK_IdSucursalDetalleServicioTransporte;
	}

	public void setResaltarFK_IdSucursalDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleServicioTransporte=null;

	public Border getResaltarFK_IdUnidadDetalleServicioTransporte() {
		return this.resaltarFK_IdUnidadDetalleServicioTransporte;
	}

	public void setResaltarFK_IdUnidadDetalleServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleServicioTransporteBeanSwingJInternalFrame detalleserviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleServicioTransporte= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}