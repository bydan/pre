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


import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoOrdenDetaProduMermaConstantesFunciones extends ProductoOrdenDetaProduMermaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoOrdenDetaProduMerma";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoOrdenDetaProduMerma"+ProductoOrdenDetaProduMermaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoOrdenDetaProduMermaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoOrdenDetaProduMermaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoOrdenDetaProduMermaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduMermaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoOrdenDetaProduMermaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduMermaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden Mermaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden Merma";
	public static final String SCLASSWEBTITULO_LOWER="Producto Orden Deta Produ Merma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoOrdenDetaProduMerma";
	public static final String OBJECTNAME="productoordendetaprodumerma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_orden_deta_produ_merma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoordendetaprodumerma from "+ProductoOrdenDetaProduMermaConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumerma";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoOrdenDetaProduMermaConstantesFuncionesAdditional productoordendetaprodumermaConstantesFuncionesAdditional=null;
	
	public ProductoOrdenDetaProduMermaConstantesFuncionesAdditional getProductoOrdenDetaProduMermaConstantesFuncionesAdditional() {
		return this.productoordendetaprodumermaConstantesFuncionesAdditional;
	}
	
	public void setProductoOrdenDetaProduMermaConstantesFuncionesAdditional(ProductoOrdenDetaProduMermaConstantesFuncionesAdditional productoordendetaprodumermaConstantesFuncionesAdditional) {
		try {
			this.productoordendetaprodumermaConstantesFuncionesAdditional=productoordendetaprodumermaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENDETAPRODU= "id_orden_deta_produ";
    public static final String IDTIPOMERMAEMPRESA= "id_tipo_merma_empresa";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String COSTO= "costo";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDORDENDETAPRODU= "Orden Deta Produ";
		public static final String LABEL_IDORDENDETAPRODU_LOWER= "Orden Deta Produ";
    	public static final String LABEL_IDTIPOMERMAEMPRESA= "Tipo Merma Empresa";
		public static final String LABEL_IDTIPOMERMAEMPRESA_LOWER= "Tipo Merma Empresa";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoOrdenDetaProduMermaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDORDENDETAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getProductoOrdenDetaProduMermaDescripcion(ProductoOrdenDetaProduMerma productoordendetaprodumerma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoordendetaprodumerma !=null/* && productoordendetaprodumerma.getId()!=0*/) {
			if(productoordendetaprodumerma.getId()!=null) {
				sDescripcion=productoordendetaprodumerma.getId().toString();
			}//productoordendetaprodumermaproductoordendetaprodumerma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoOrdenDetaProduMermaDescripcionDetallado(ProductoOrdenDetaProduMerma productoordendetaprodumerma) {
		String sDescripcion="";
			
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.ID+"=";
		sDescripcion+=productoordendetaprodumerma.getId().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoordendetaprodumerma.getVersionRow().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU+"=";
		sDescripcion+=productoordendetaprodumerma.getid_orden_deta_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA+"=";
		sDescripcion+=productoordendetaprodumerma.getid_tipo_merma_empresa().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoordendetaprodumerma.getid_unidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoordendetaprodumerma.getcantidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.COSTO+"=";
		sDescripcion+=productoordendetaprodumerma.getcosto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoordendetaprodumerma.getcosto_total().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoordendetaprodumerma.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoOrdenDetaProduMermaDescripcion(ProductoOrdenDetaProduMerma productoordendetaprodumerma,String sValor) throws Exception {			
		if(productoordendetaprodumerma !=null) {
			//productoordendetaprodumermaproductoordendetaprodumerma.getId().toString();
		}		
	}
	
		

	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordendetaprodu!=null/*&&ordendetaprodu.getId()>0*/) {
			sDescripcion=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(ordendetaprodu);
		}

		return sDescripcion;
	}

	public static String getTipoMermaEmpresaDescripcion(TipoMermaEmpresa tipomermaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomermaempresa!=null/*&&tipomermaempresa.getId()>0*/) {
			sDescripcion=TipoMermaEmpresaConstantesFunciones.getTipoMermaEmpresaDescripcion(tipomermaempresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdOrdenDetaProdu")) {
			sNombreIndice="Tipo=  Por Orden Deta Produ";
		} else if(sNombreIndice.equals("FK_IdTipoMermaEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Merma Empresa";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdOrdenDetaProdu(Long id_orden_deta_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_deta_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Deta Produ="+id_orden_deta_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMermaEmpresa(Long id_tipo_merma_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_merma_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Merma Empresa="+id_tipo_merma_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodumerma.setdescripcion(productoordendetaprodumerma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {
			productoordendetaprodumerma.setdescripcion(productoordendetaprodumerma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoordendetaprodumerma.getConCambioAuxiliar()) {
			productoordendetaprodumerma.setIsDeleted(productoordendetaprodumerma.getIsDeletedAuxiliar());	
			productoordendetaprodumerma.setIsNew(productoordendetaprodumerma.getIsNewAuxiliar());	
			productoordendetaprodumerma.setIsChanged(productoordendetaprodumerma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoordendetaprodumerma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoordendetaprodumerma.setIsDeletedAuxiliar(false);	
			productoordendetaprodumerma.setIsNewAuxiliar(false);	
			productoordendetaprodumerma.setIsChangedAuxiliar(false);
			
			productoordendetaprodumerma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma : productoordendetaprodumermas) {
			if(conAsignarBase && productoordendetaprodumerma.getConCambioAuxiliar()) {
				productoordendetaprodumerma.setIsDeleted(productoordendetaprodumerma.getIsDeletedAuxiliar());	
				productoordendetaprodumerma.setIsNew(productoordendetaprodumerma.getIsNewAuxiliar());	
				productoordendetaprodumerma.setIsChanged(productoordendetaprodumerma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoordendetaprodumerma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoordendetaprodumerma.setIsDeletedAuxiliar(false);	
				productoordendetaprodumerma.setIsNewAuxiliar(false);	
				productoordendetaprodumerma.setIsChangedAuxiliar(false);
				
				productoordendetaprodumerma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean conEnteros) throws Exception  {
		productoordendetaprodumerma.setcosto(0.0);
		productoordendetaprodumerma.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoordendetaprodumerma.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,Boolean conEnteros) throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {
			productoordendetaprodumerma.setcosto(0.0);
			productoordendetaprodumerma.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoordendetaprodumerma.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMerma productoordendetaprodumermaAux) throws Exception  {
		ProductoOrdenDetaProduMermaConstantesFunciones.InicializarValoresProductoOrdenDetaProduMerma(productoordendetaprodumermaAux,true);
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {
			if(productoordendetaprodumerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoordendetaprodumermaAux.setcantidad(productoordendetaprodumermaAux.getcantidad()+productoordendetaprodumerma.getcantidad());			
			productoordendetaprodumermaAux.setcosto(productoordendetaprodumermaAux.getcosto()+productoordendetaprodumerma.getcosto());			
			productoordendetaprodumermaAux.setcosto_total(productoordendetaprodumermaAux.getcosto_total()+productoordendetaprodumerma.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoOrdenDetaProduMermaConstantesFunciones.getArrayColumnasGlobalesProductoOrdenDetaProduMerma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMerma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoOrdenDetaProduMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux: productoordendetaprodumermas) {
			if(productoordendetaprodumermaAux!=null && productoordendetaprodumerma!=null) {
				if((productoordendetaprodumermaAux.getId()==null && productoordendetaprodumerma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoordendetaprodumermaAux.getId()!=null && productoordendetaprodumerma.getId()!=null){
					if(productoordendetaprodumermaAux.getId().equals(productoordendetaprodumerma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {			
			if(productoordendetaprodumerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoordendetaprodumerma.getcosto();
			costo_totalTotal+=productoordendetaprodumerma.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoOrdenDetaProduMerma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_ID, ProductoOrdenDetaProduMermaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_VERSIONROW, ProductoOrdenDetaProduMermaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDORDENDETAPRODU, ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA, ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDUNIDAD, ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_CANTIDAD, ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO, ProductoOrdenDetaProduMermaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL, ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_DESCRIPCION, ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoOrdenDetaProduMerma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMerma() throws Exception  {
		return ProductoOrdenDetaProduMermaConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMerma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMerma(Boolean conFk) throws Exception  {
		return ProductoOrdenDetaProduMermaConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMerma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMerma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDORDENDETAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDORDENDETAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoOrdenDetaProduMerma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux) throws Exception {
		
			productoordendetaprodumermaAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumermaAux.getOrdenDetaProdu()));
			productoordendetaprodumermaAux.settipomermaempresa_descripcion(TipoMermaEmpresaConstantesFunciones.getTipoMermaEmpresaDescripcion(productoordendetaprodumermaAux.getTipoMermaEmpresa()));
			productoordendetaprodumermaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumermaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermasTemp) throws Exception {
		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux:productoordendetaprodumermasTemp) {
			
			productoordendetaprodumermaAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumermaAux.getOrdenDetaProdu()));
			productoordendetaprodumermaAux.settipomermaempresa_descripcion(TipoMermaEmpresaConstantesFunciones.getTipoMermaEmpresaDescripcion(productoordendetaprodumermaAux.getTipoMermaEmpresa()));
			productoordendetaprodumermaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumermaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(TipoMermaEmpresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMermaEmpresa.class)) {
						classes.add(new Classe(TipoMermaEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoOrdenDetaProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}

					if(TipoMermaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMermaEmpresa.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}

					if(TipoMermaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMermaEmpresa.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduMermaConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMerma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduMermaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMerma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoOrdenDetaProduMerma productoordendetaprodumerma,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoOrdenDetaProduMerma productoordendetaprodumermaEncontrado=null;
			
			for(ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal:productoordendetaprodumermas) {
				if(productoordendetaprodumermaLocal.getId().equals(productoordendetaprodumerma.getId())) {
					productoordendetaprodumermaEncontrado=productoordendetaprodumermaLocal;
					
					productoordendetaprodumermaLocal.setIsChanged(productoordendetaprodumerma.getIsChanged());
					productoordendetaprodumermaLocal.setIsNew(productoordendetaprodumerma.getIsNew());
					productoordendetaprodumermaLocal.setIsDeleted(productoordendetaprodumerma.getIsDeleted());
					
					productoordendetaprodumermaLocal.setGeneralEntityOriginal(productoordendetaprodumerma.getGeneralEntityOriginal());
					
					productoordendetaprodumermaLocal.setId(productoordendetaprodumerma.getId());	
					productoordendetaprodumermaLocal.setVersionRow(productoordendetaprodumerma.getVersionRow());	
					productoordendetaprodumermaLocal.setid_orden_deta_produ(productoordendetaprodumerma.getid_orden_deta_produ());	
					productoordendetaprodumermaLocal.setid_tipo_merma_empresa(productoordendetaprodumerma.getid_tipo_merma_empresa());	
					productoordendetaprodumermaLocal.setid_unidad(productoordendetaprodumerma.getid_unidad());	
					productoordendetaprodumermaLocal.setcantidad(productoordendetaprodumerma.getcantidad());	
					productoordendetaprodumermaLocal.setcosto(productoordendetaprodumerma.getcosto());	
					productoordendetaprodumermaLocal.setcosto_total(productoordendetaprodumerma.getcosto_total());	
					productoordendetaprodumermaLocal.setdescripcion(productoordendetaprodumerma.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoordendetaprodumerma.getIsDeleted()) {
				if(!existe) {
					productoordendetaprodumermas.add(productoordendetaprodumerma);
				}
			} else {
				if(productoordendetaprodumermaEncontrado!=null && permiteQuitar)  {
					productoordendetaprodumermas.remove(productoordendetaprodumermaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoOrdenDetaProduMerma productoordendetaprodumerma,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas) throws Exception {
		try	{			
			for(ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal:productoordendetaprodumermas) {
				if(productoordendetaprodumermaLocal.getId().equals(productoordendetaprodumerma.getId())) {
					productoordendetaprodumermaLocal.setIsSelected(productoordendetaprodumerma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermasAux) throws Exception {
		//this.productoordendetaprodumermasAux=productoordendetaprodumermasAux;
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux:productoordendetaprodumermasAux) {
			if(productoordendetaprodumermaAux.getIsChanged()) {
				productoordendetaprodumermaAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumermaAux.getIsNew()) {
				productoordendetaprodumermaAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumermaAux.getIsDeleted()) {
				productoordendetaprodumermaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux) throws Exception {
		//this.productoordendetaprodumermaAux=productoordendetaprodumermaAux;
		
			if(productoordendetaprodumermaAux.getIsChanged()) {
				productoordendetaprodumermaAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumermaAux.getIsNew()) {
				productoordendetaprodumermaAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumermaAux.getIsDeleted()) {
				productoordendetaprodumermaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoOrdenDetaProduMerma productoordendetaprodumermaAsignar,ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {
		productoordendetaprodumermaAsignar.setId(productoordendetaprodumerma.getId());	
		productoordendetaprodumermaAsignar.setVersionRow(productoordendetaprodumerma.getVersionRow());	
		productoordendetaprodumermaAsignar.setid_orden_deta_produ(productoordendetaprodumerma.getid_orden_deta_produ());
		productoordendetaprodumermaAsignar.setordendetaprodu_descripcion(productoordendetaprodumerma.getordendetaprodu_descripcion());	
		productoordendetaprodumermaAsignar.setid_tipo_merma_empresa(productoordendetaprodumerma.getid_tipo_merma_empresa());
		productoordendetaprodumermaAsignar.settipomermaempresa_descripcion(productoordendetaprodumerma.gettipomermaempresa_descripcion());	
		productoordendetaprodumermaAsignar.setid_unidad(productoordendetaprodumerma.getid_unidad());
		productoordendetaprodumermaAsignar.setunidad_descripcion(productoordendetaprodumerma.getunidad_descripcion());	
		productoordendetaprodumermaAsignar.setcantidad(productoordendetaprodumerma.getcantidad());	
		productoordendetaprodumermaAsignar.setcosto(productoordendetaprodumerma.getcosto());	
		productoordendetaprodumermaAsignar.setcosto_total(productoordendetaprodumerma.getcosto_total());	
		productoordendetaprodumermaAsignar.setdescripcion(productoordendetaprodumerma.getdescripcion());	
	}
	
	public static void inicializarProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {
		try {
				productoordendetaprodumerma.setId(0L);	
					
				productoordendetaprodumerma.setid_orden_deta_produ(-1L);	
				productoordendetaprodumerma.setid_tipo_merma_empresa(-1L);	
				productoordendetaprodumerma.setid_unidad(-1L);	
				productoordendetaprodumerma.setcantidad(0);	
				productoordendetaprodumerma.setcosto(0.0);	
				productoordendetaprodumerma.setcosto_total(0.0);	
				productoordendetaprodumerma.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoOrdenDetaProduMerma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDORDENDETAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoOrdenDetaProduMerma(String sTipo,Row row,Workbook workbook,ProductoOrdenDetaProduMerma productoordendetaprodumerma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getordendetaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.gettipomermaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumerma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoOrdenDetaProduMerma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoOrdenDetaProduMerma() {
		return this.sFinalQueryProductoOrdenDetaProduMerma;
	}
	
	public void setsFinalQueryProductoOrdenDetaProduMerma(String sFinalQueryProductoOrdenDetaProduMerma) {
		this.sFinalQueryProductoOrdenDetaProduMerma= sFinalQueryProductoOrdenDetaProduMerma;
	}
	
	public Border resaltarSeleccionarProductoOrdenDetaProduMerma=null;
	
	public Border setResaltarSeleccionarProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoOrdenDetaProduMerma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoOrdenDetaProduMerma() {
		return this.resaltarSeleccionarProductoOrdenDetaProduMerma;
	}
	
	public void setResaltarSeleccionarProductoOrdenDetaProduMerma(Border borderResaltarSeleccionarProductoOrdenDetaProduMerma) {
		this.resaltarSeleccionarProductoOrdenDetaProduMerma= borderResaltarSeleccionarProductoOrdenDetaProduMerma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoOrdenDetaProduMerma=null;
	public Boolean mostraridProductoOrdenDetaProduMerma=true;
	public Boolean activaridProductoOrdenDetaProduMerma=true;

	public Border resaltarid_orden_deta_produProductoOrdenDetaProduMerma=null;
	public Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMerma=true;
	public Boolean activarid_orden_deta_produProductoOrdenDetaProduMerma=true;
	public Boolean cargarid_orden_deta_produProductoOrdenDetaProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_deta_produProductoOrdenDetaProduMerma=false;//ConEventDepend=true

	public Border resaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma=null;
	public Boolean mostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma=true;
	public Boolean activarid_tipo_merma_empresaProductoOrdenDetaProduMerma=true;
	public Boolean cargarid_tipo_merma_empresaProductoOrdenDetaProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_merma_empresaProductoOrdenDetaProduMerma=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoOrdenDetaProduMerma=null;
	public Boolean mostrarid_unidadProductoOrdenDetaProduMerma=true;
	public Boolean activarid_unidadProductoOrdenDetaProduMerma=true;
	public Boolean cargarid_unidadProductoOrdenDetaProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoOrdenDetaProduMerma=false;//ConEventDepend=true

	public Border resaltarcantidadProductoOrdenDetaProduMerma=null;
	public Boolean mostrarcantidadProductoOrdenDetaProduMerma=true;
	public Boolean activarcantidadProductoOrdenDetaProduMerma=true;

	public Border resaltarcostoProductoOrdenDetaProduMerma=null;
	public Boolean mostrarcostoProductoOrdenDetaProduMerma=true;
	public Boolean activarcostoProductoOrdenDetaProduMerma=true;

	public Border resaltarcosto_totalProductoOrdenDetaProduMerma=null;
	public Boolean mostrarcosto_totalProductoOrdenDetaProduMerma=true;
	public Boolean activarcosto_totalProductoOrdenDetaProduMerma=true;

	public Border resaltardescripcionProductoOrdenDetaProduMerma=null;
	public Boolean mostrardescripcionProductoOrdenDetaProduMerma=true;
	public Boolean activardescripcionProductoOrdenDetaProduMerma=true;

	
	

	public Border setResaltaridProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltaridProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoOrdenDetaProduMerma() {
		return this.resaltaridProductoOrdenDetaProduMerma;
	}

	public void setResaltaridProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltaridProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostraridProductoOrdenDetaProduMerma() {
		return this.mostraridProductoOrdenDetaProduMerma;
	}

	public void setMostraridProductoOrdenDetaProduMerma(Boolean mostraridProductoOrdenDetaProduMerma) {
		this.mostraridProductoOrdenDetaProduMerma= mostraridProductoOrdenDetaProduMerma;
	}

	public Boolean getActivaridProductoOrdenDetaProduMerma() {
		return this.activaridProductoOrdenDetaProduMerma;
	}

	public void setActivaridProductoOrdenDetaProduMerma(Boolean activaridProductoOrdenDetaProduMerma) {
		this.activaridProductoOrdenDetaProduMerma= activaridProductoOrdenDetaProduMerma;
	}

	public Border setResaltarid_orden_deta_produProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_deta_produProductoOrdenDetaProduMerma() {
		return this.resaltarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public void setResaltarid_orden_deta_produProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_orden_deta_produProductoOrdenDetaProduMerma() {
		return this.mostrarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public void setMostrarid_orden_deta_produProductoOrdenDetaProduMerma(Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMerma) {
		this.mostrarid_orden_deta_produProductoOrdenDetaProduMerma= mostrarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarid_orden_deta_produProductoOrdenDetaProduMerma() {
		return this.activarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public void setActivarid_orden_deta_produProductoOrdenDetaProduMerma(Boolean activarid_orden_deta_produProductoOrdenDetaProduMerma) {
		this.activarid_orden_deta_produProductoOrdenDetaProduMerma= activarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public Boolean getCargarid_orden_deta_produProductoOrdenDetaProduMerma() {
		return this.cargarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public void setCargarid_orden_deta_produProductoOrdenDetaProduMerma(Boolean cargarid_orden_deta_produProductoOrdenDetaProduMerma) {
		this.cargarid_orden_deta_produProductoOrdenDetaProduMerma= cargarid_orden_deta_produProductoOrdenDetaProduMerma;
	}

	public Border setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma() {
		return this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public void setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma() {
		return this.mostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public void setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma(Boolean mostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma) {
		this.mostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma= mostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarid_tipo_merma_empresaProductoOrdenDetaProduMerma() {
		return this.activarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public void setActivarid_tipo_merma_empresaProductoOrdenDetaProduMerma(Boolean activarid_tipo_merma_empresaProductoOrdenDetaProduMerma) {
		this.activarid_tipo_merma_empresaProductoOrdenDetaProduMerma= activarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public Boolean getCargarid_tipo_merma_empresaProductoOrdenDetaProduMerma() {
		return this.cargarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public void setCargarid_tipo_merma_empresaProductoOrdenDetaProduMerma(Boolean cargarid_tipo_merma_empresaProductoOrdenDetaProduMerma) {
		this.cargarid_tipo_merma_empresaProductoOrdenDetaProduMerma= cargarid_tipo_merma_empresaProductoOrdenDetaProduMerma;
	}

	public Border setResaltarid_unidadProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoOrdenDetaProduMerma() {
		return this.resaltarid_unidadProductoOrdenDetaProduMerma;
	}

	public void setResaltarid_unidadProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarid_unidadProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoOrdenDetaProduMerma() {
		return this.mostrarid_unidadProductoOrdenDetaProduMerma;
	}

	public void setMostrarid_unidadProductoOrdenDetaProduMerma(Boolean mostrarid_unidadProductoOrdenDetaProduMerma) {
		this.mostrarid_unidadProductoOrdenDetaProduMerma= mostrarid_unidadProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarid_unidadProductoOrdenDetaProduMerma() {
		return this.activarid_unidadProductoOrdenDetaProduMerma;
	}

	public void setActivarid_unidadProductoOrdenDetaProduMerma(Boolean activarid_unidadProductoOrdenDetaProduMerma) {
		this.activarid_unidadProductoOrdenDetaProduMerma= activarid_unidadProductoOrdenDetaProduMerma;
	}

	public Boolean getCargarid_unidadProductoOrdenDetaProduMerma() {
		return this.cargarid_unidadProductoOrdenDetaProduMerma;
	}

	public void setCargarid_unidadProductoOrdenDetaProduMerma(Boolean cargarid_unidadProductoOrdenDetaProduMerma) {
		this.cargarid_unidadProductoOrdenDetaProduMerma= cargarid_unidadProductoOrdenDetaProduMerma;
	}

	public Border setResaltarcantidadProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoOrdenDetaProduMerma() {
		return this.resaltarcantidadProductoOrdenDetaProduMerma;
	}

	public void setResaltarcantidadProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarcantidadProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoOrdenDetaProduMerma() {
		return this.mostrarcantidadProductoOrdenDetaProduMerma;
	}

	public void setMostrarcantidadProductoOrdenDetaProduMerma(Boolean mostrarcantidadProductoOrdenDetaProduMerma) {
		this.mostrarcantidadProductoOrdenDetaProduMerma= mostrarcantidadProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarcantidadProductoOrdenDetaProduMerma() {
		return this.activarcantidadProductoOrdenDetaProduMerma;
	}

	public void setActivarcantidadProductoOrdenDetaProduMerma(Boolean activarcantidadProductoOrdenDetaProduMerma) {
		this.activarcantidadProductoOrdenDetaProduMerma= activarcantidadProductoOrdenDetaProduMerma;
	}

	public Border setResaltarcostoProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarcostoProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoOrdenDetaProduMerma() {
		return this.resaltarcostoProductoOrdenDetaProduMerma;
	}

	public void setResaltarcostoProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarcostoProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarcostoProductoOrdenDetaProduMerma() {
		return this.mostrarcostoProductoOrdenDetaProduMerma;
	}

	public void setMostrarcostoProductoOrdenDetaProduMerma(Boolean mostrarcostoProductoOrdenDetaProduMerma) {
		this.mostrarcostoProductoOrdenDetaProduMerma= mostrarcostoProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarcostoProductoOrdenDetaProduMerma() {
		return this.activarcostoProductoOrdenDetaProduMerma;
	}

	public void setActivarcostoProductoOrdenDetaProduMerma(Boolean activarcostoProductoOrdenDetaProduMerma) {
		this.activarcostoProductoOrdenDetaProduMerma= activarcostoProductoOrdenDetaProduMerma;
	}

	public Border setResaltarcosto_totalProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoOrdenDetaProduMerma() {
		return this.resaltarcosto_totalProductoOrdenDetaProduMerma;
	}

	public void setResaltarcosto_totalProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarcosto_totalProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoOrdenDetaProduMerma() {
		return this.mostrarcosto_totalProductoOrdenDetaProduMerma;
	}

	public void setMostrarcosto_totalProductoOrdenDetaProduMerma(Boolean mostrarcosto_totalProductoOrdenDetaProduMerma) {
		this.mostrarcosto_totalProductoOrdenDetaProduMerma= mostrarcosto_totalProductoOrdenDetaProduMerma;
	}

	public Boolean getActivarcosto_totalProductoOrdenDetaProduMerma() {
		return this.activarcosto_totalProductoOrdenDetaProduMerma;
	}

	public void setActivarcosto_totalProductoOrdenDetaProduMerma(Boolean activarcosto_totalProductoOrdenDetaProduMerma) {
		this.activarcosto_totalProductoOrdenDetaProduMerma= activarcosto_totalProductoOrdenDetaProduMerma;
	}

	public Border setResaltardescripcionProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumermaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMerma.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoOrdenDetaProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoOrdenDetaProduMerma() {
		return this.resaltardescripcionProductoOrdenDetaProduMerma;
	}

	public void setResaltardescripcionProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltardescripcionProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoOrdenDetaProduMerma() {
		return this.mostrardescripcionProductoOrdenDetaProduMerma;
	}

	public void setMostrardescripcionProductoOrdenDetaProduMerma(Boolean mostrardescripcionProductoOrdenDetaProduMerma) {
		this.mostrardescripcionProductoOrdenDetaProduMerma= mostrardescripcionProductoOrdenDetaProduMerma;
	}

	public Boolean getActivardescripcionProductoOrdenDetaProduMerma() {
		return this.activardescripcionProductoOrdenDetaProduMerma;
	}

	public void setActivardescripcionProductoOrdenDetaProduMerma(Boolean activardescripcionProductoOrdenDetaProduMerma) {
		this.activardescripcionProductoOrdenDetaProduMerma= activardescripcionProductoOrdenDetaProduMerma;
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
		
		
		this.setMostraridProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarid_orden_deta_produProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarid_unidadProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarcantidadProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarcostoProductoOrdenDetaProduMerma(esInicial);
		this.setMostrarcosto_totalProductoOrdenDetaProduMerma(esInicial);
		this.setMostrardescripcionProductoOrdenDetaProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.ID)) {
				this.setMostraridProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setMostrarid_orden_deta_produProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoOrdenDetaProduMerma(esAsigna);
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
		
		
		this.setActivaridProductoOrdenDetaProduMerma(esInicial);
		this.setActivarid_orden_deta_produProductoOrdenDetaProduMerma(esInicial);
		this.setActivarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esInicial);
		this.setActivarid_unidadProductoOrdenDetaProduMerma(esInicial);
		this.setActivarcantidadProductoOrdenDetaProduMerma(esInicial);
		this.setActivarcostoProductoOrdenDetaProduMerma(esInicial);
		this.setActivarcosto_totalProductoOrdenDetaProduMerma(esInicial);
		this.setActivardescripcionProductoOrdenDetaProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.ID)) {
				this.setActivaridProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setActivarid_orden_deta_produProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setActivarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarid_orden_deta_produProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarid_unidadProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarcantidadProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarcostoProductoOrdenDetaProduMerma(esInicial);
		this.setResaltarcosto_totalProductoOrdenDetaProduMerma(esInicial);
		this.setResaltardescripcionProductoOrdenDetaProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.ID)) {
				this.setResaltaridProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setResaltarid_orden_deta_produProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoOrdenDetaProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoOrdenDetaProduMerma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma=true;

	public Boolean getMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma() {
		return this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma;
	}

	public void setMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma=true;

	public Boolean getMostrarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma() {
		return this.mostrarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma;
	}

	public void setMostrarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoOrdenDetaProduMerma=true;

	public Boolean getMostrarFK_IdUnidadProductoOrdenDetaProduMerma() {
		return this.mostrarFK_IdUnidadProductoOrdenDetaProduMerma;
	}

	public void setMostrarFK_IdUnidadProductoOrdenDetaProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoOrdenDetaProduMerma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma=true;

	public Boolean getActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma() {
		return this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma;
	}

	public void setActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma=true;

	public Boolean getActivarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma() {
		return this.activarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma;
	}

	public void setActivarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoOrdenDetaProduMerma=true;

	public Boolean getActivarFK_IdUnidadProductoOrdenDetaProduMerma() {
		return this.activarFK_IdUnidadProductoOrdenDetaProduMerma;
	}

	public void setActivarFK_IdUnidadProductoOrdenDetaProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoOrdenDetaProduMerma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma=null;

	public Border getResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma() {
		return this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Border resaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma=null;

	public Border getResaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma() {
		return this.resaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma;
	}

	public void setResaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMermaEmpresaProductoOrdenDetaProduMerma= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoOrdenDetaProduMerma=null;

	public Border getResaltarFK_IdUnidadProductoOrdenDetaProduMerma() {
		return this.resaltarFK_IdUnidadProductoOrdenDetaProduMerma;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMerma(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMermaBeanSwingJInternalFrame productoordendetaprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMerma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}