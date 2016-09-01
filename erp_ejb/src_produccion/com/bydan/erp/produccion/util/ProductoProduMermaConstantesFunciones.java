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


import com.bydan.erp.produccion.util.ProductoProduMermaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduMermaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduMermaParameterGeneral;

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
final public class ProductoProduMermaConstantesFunciones extends ProductoProduMermaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProduMerma";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProduMerma"+ProductoProduMermaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProduMermaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProduMermaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProduMermaConstantesFunciones.SCHEMA+"_"+ProductoProduMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProduMermaConstantesFunciones.SCHEMA+"_"+ProductoProduMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProduMermaConstantesFunciones.SCHEMA+"_"+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProduMermaConstantesFunciones.SCHEMA+"_"+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProduMermaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProduMermaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProduMermaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProduMermaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Merma Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Merma Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Produ Merma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProduMerma";
	public static final String OBJECTNAME="productoprodumerma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_produ_merma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoprodumerma from "+ProductoProduMermaConstantesFunciones.SPERSISTENCENAME+" productoprodumerma";
	public static String QUERYSELECTNATIVE="select "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".version_row,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".costo,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMermaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProduMermaConstantesFuncionesAdditional productoprodumermaConstantesFuncionesAdditional=null;
	
	public ProductoProduMermaConstantesFuncionesAdditional getProductoProduMermaConstantesFuncionesAdditional() {
		return this.productoprodumermaConstantesFuncionesAdditional;
	}
	
	public void setProductoProduMermaConstantesFuncionesAdditional(ProductoProduMermaConstantesFuncionesAdditional productoprodumermaConstantesFuncionesAdditional) {
		try {
			this.productoprodumermaConstantesFuncionesAdditional=productoprodumermaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTODEFIPRODU= "id_producto_defi_produ";
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
    	public static final String LABEL_IDPRODUCTODEFIPRODU= "Producto Defi Produ";
		public static final String LABEL_IDPRODUCTODEFIPRODU_LOWER= "Producto Defi Produ";
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
	
	public static String getProductoProduMermaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.COSTO)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoProduMermaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoProduMermaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProduMermaDescripcion(ProductoProduMerma productoprodumerma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoprodumerma !=null/* && productoprodumerma.getId()!=0*/) {
			if(productoprodumerma.getId()!=null) {
				sDescripcion=productoprodumerma.getId().toString();
			}//productoprodumermaproductoprodumerma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProduMermaDescripcionDetallado(ProductoProduMerma productoprodumerma) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProduMermaConstantesFunciones.ID+"=";
		sDescripcion+=productoprodumerma.getId().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoprodumerma.getVersionRow().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU+"=";
		sDescripcion+=productoprodumerma.getid_producto_defi_produ().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA+"=";
		sDescripcion+=productoprodumerma.getid_tipo_merma_empresa().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoprodumerma.getid_unidad().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoprodumerma.getcantidad().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.COSTO+"=";
		sDescripcion+=productoprodumerma.getcosto().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoprodumerma.getcosto_total().toString()+",";
		sDescripcion+=ProductoProduMermaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoprodumerma.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProduMermaDescripcion(ProductoProduMerma productoprodumerma,String sValor) throws Exception {			
		if(productoprodumerma !=null) {
			//productoprodumermaproductoprodumerma.getId().toString();
		}		
	}
	
		

	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(productodefiprodu!=null/*&&productodefiprodu.getId()>0*/) {
			sDescripcion=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productodefiprodu);
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
		} else if(sNombreIndice.equals("FK_IdProductoDefiProdu")) {
			sNombreIndice="Tipo=  Por Producto Defi Produ";
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

	public static String getDetalleIndiceFK_IdProductoDefiProdu(Long id_producto_defi_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_defi_produ!=null) {sDetalleIndice+=" Codigo Unico De Producto Defi Produ="+id_producto_defi_produ.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoProduMerma(ProductoProduMerma productoprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodumerma.setdescripcion(productoprodumerma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProduMermas(List<ProductoProduMerma> productoprodumermas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProduMerma productoprodumerma: productoprodumermas) {
			productoprodumerma.setdescripcion(productoprodumerma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduMerma(ProductoProduMerma productoprodumerma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoprodumerma.getConCambioAuxiliar()) {
			productoprodumerma.setIsDeleted(productoprodumerma.getIsDeletedAuxiliar());	
			productoprodumerma.setIsNew(productoprodumerma.getIsNewAuxiliar());	
			productoprodumerma.setIsChanged(productoprodumerma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoprodumerma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoprodumerma.setIsDeletedAuxiliar(false);	
			productoprodumerma.setIsNewAuxiliar(false);	
			productoprodumerma.setIsChangedAuxiliar(false);
			
			productoprodumerma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduMermas(List<ProductoProduMerma> productoprodumermas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProduMerma productoprodumerma : productoprodumermas) {
			if(conAsignarBase && productoprodumerma.getConCambioAuxiliar()) {
				productoprodumerma.setIsDeleted(productoprodumerma.getIsDeletedAuxiliar());	
				productoprodumerma.setIsNew(productoprodumerma.getIsNewAuxiliar());	
				productoprodumerma.setIsChanged(productoprodumerma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoprodumerma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoprodumerma.setIsDeletedAuxiliar(false);	
				productoprodumerma.setIsNewAuxiliar(false);	
				productoprodumerma.setIsChangedAuxiliar(false);
				
				productoprodumerma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProduMerma(ProductoProduMerma productoprodumerma,Boolean conEnteros) throws Exception  {
		productoprodumerma.setcosto(0.0);
		productoprodumerma.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoprodumerma.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoProduMermas(List<ProductoProduMerma> productoprodumermas,Boolean conEnteros) throws Exception  {
		
		for(ProductoProduMerma productoprodumerma: productoprodumermas) {
			productoprodumerma.setcosto(0.0);
			productoprodumerma.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoprodumerma.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProduMerma(List<ProductoProduMerma> productoprodumermas,ProductoProduMerma productoprodumermaAux) throws Exception  {
		ProductoProduMermaConstantesFunciones.InicializarValoresProductoProduMerma(productoprodumermaAux,true);
		
		for(ProductoProduMerma productoprodumerma: productoprodumermas) {
			if(productoprodumerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoprodumermaAux.setcantidad(productoprodumermaAux.getcantidad()+productoprodumerma.getcantidad());			
			productoprodumermaAux.setcosto(productoprodumermaAux.getcosto()+productoprodumerma.getcosto());			
			productoprodumermaAux.setcosto_total(productoprodumermaAux.getcosto_total()+productoprodumerma.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProduMermaConstantesFunciones.getArrayColumnasGlobalesProductoProduMerma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMerma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProduMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProduMerma> productoprodumermas,ProductoProduMerma productoprodumerma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProduMerma productoprodumermaAux: productoprodumermas) {
			if(productoprodumermaAux!=null && productoprodumerma!=null) {
				if((productoprodumermaAux.getId()==null && productoprodumerma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoprodumermaAux.getId()!=null && productoprodumerma.getId()!=null){
					if(productoprodumermaAux.getId().equals(productoprodumerma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProduMerma(List<ProductoProduMerma> productoprodumermas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProduMerma productoprodumerma: productoprodumermas) {			
			if(productoprodumerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoprodumerma.getcosto();
			costo_totalTotal+=productoprodumerma.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduMermaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduMermaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProduMerma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_ID, ProductoProduMermaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_VERSIONROW, ProductoProduMermaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU, ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA, ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_IDUNIDAD, ProductoProduMermaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_CANTIDAD, ProductoProduMermaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_COSTO, ProductoProduMermaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL, ProductoProduMermaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMermaConstantesFunciones.LABEL_DESCRIPCION, ProductoProduMermaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProduMerma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMermaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMerma() throws Exception  {
		return ProductoProduMermaConstantesFunciones.getTiposSeleccionarProductoProduMerma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMerma(Boolean conFk) throws Exception  {
		return ProductoProduMermaConstantesFunciones.getTiposSeleccionarProductoProduMerma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMerma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMermaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoProduMermaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProduMerma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMerma(ProductoProduMerma productoprodumermaAux) throws Exception {
		
			productoprodumermaAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumermaAux.getProductoDefiProdu()));
			productoprodumermaAux.settipomermaempresa_descripcion(TipoMermaEmpresaConstantesFunciones.getTipoMermaEmpresaDescripcion(productoprodumermaAux.getTipoMermaEmpresa()));
			productoprodumermaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumermaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMerma(List<ProductoProduMerma> productoprodumermasTemp) throws Exception {
		for(ProductoProduMerma productoprodumermaAux:productoprodumermasTemp) {
			
			productoprodumermaAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumermaAux.getProductoDefiProdu()));
			productoprodumermaAux.settipomermaempresa_descripcion(TipoMermaEmpresaConstantesFunciones.getTipoMermaEmpresaDescripcion(productoprodumermaAux.getTipoMermaEmpresa()));
			productoprodumermaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumermaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoDefiProdu.class));
				classes.add(new Classe(TipoMermaEmpresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoDefiProdu.class)) {
						classes.add(new Classe(ProductoDefiProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
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

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduMermaConstantesFunciones.getClassesRelationshipsOfProductoProduMerma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduMermaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProduMerma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProduMerma productoprodumerma,List<ProductoProduMerma> productoprodumermas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProduMerma productoprodumermaEncontrado=null;
			
			for(ProductoProduMerma productoprodumermaLocal:productoprodumermas) {
				if(productoprodumermaLocal.getId().equals(productoprodumerma.getId())) {
					productoprodumermaEncontrado=productoprodumermaLocal;
					
					productoprodumermaLocal.setIsChanged(productoprodumerma.getIsChanged());
					productoprodumermaLocal.setIsNew(productoprodumerma.getIsNew());
					productoprodumermaLocal.setIsDeleted(productoprodumerma.getIsDeleted());
					
					productoprodumermaLocal.setGeneralEntityOriginal(productoprodumerma.getGeneralEntityOriginal());
					
					productoprodumermaLocal.setId(productoprodumerma.getId());	
					productoprodumermaLocal.setVersionRow(productoprodumerma.getVersionRow());	
					productoprodumermaLocal.setid_producto_defi_produ(productoprodumerma.getid_producto_defi_produ());	
					productoprodumermaLocal.setid_tipo_merma_empresa(productoprodumerma.getid_tipo_merma_empresa());	
					productoprodumermaLocal.setid_unidad(productoprodumerma.getid_unidad());	
					productoprodumermaLocal.setcantidad(productoprodumerma.getcantidad());	
					productoprodumermaLocal.setcosto(productoprodumerma.getcosto());	
					productoprodumermaLocal.setcosto_total(productoprodumerma.getcosto_total());	
					productoprodumermaLocal.setdescripcion(productoprodumerma.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoprodumerma.getIsDeleted()) {
				if(!existe) {
					productoprodumermas.add(productoprodumerma);
				}
			} else {
				if(productoprodumermaEncontrado!=null && permiteQuitar)  {
					productoprodumermas.remove(productoprodumermaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProduMerma productoprodumerma,List<ProductoProduMerma> productoprodumermas) throws Exception {
		try	{			
			for(ProductoProduMerma productoprodumermaLocal:productoprodumermas) {
				if(productoprodumermaLocal.getId().equals(productoprodumerma.getId())) {
					productoprodumermaLocal.setIsSelected(productoprodumerma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProduMerma(List<ProductoProduMerma> productoprodumermasAux) throws Exception {
		//this.productoprodumermasAux=productoprodumermasAux;
		
		for(ProductoProduMerma productoprodumermaAux:productoprodumermasAux) {
			if(productoprodumermaAux.getIsChanged()) {
				productoprodumermaAux.setIsChanged(false);
			}		
			
			if(productoprodumermaAux.getIsNew()) {
				productoprodumermaAux.setIsNew(false);
			}	
			
			if(productoprodumermaAux.getIsDeleted()) {
				productoprodumermaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProduMerma(ProductoProduMerma productoprodumermaAux) throws Exception {
		//this.productoprodumermaAux=productoprodumermaAux;
		
			if(productoprodumermaAux.getIsChanged()) {
				productoprodumermaAux.setIsChanged(false);
			}		
			
			if(productoprodumermaAux.getIsNew()) {
				productoprodumermaAux.setIsNew(false);
			}	
			
			if(productoprodumermaAux.getIsDeleted()) {
				productoprodumermaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProduMerma productoprodumermaAsignar,ProductoProduMerma productoprodumerma) throws Exception {
		productoprodumermaAsignar.setId(productoprodumerma.getId());	
		productoprodumermaAsignar.setVersionRow(productoprodumerma.getVersionRow());	
		productoprodumermaAsignar.setid_producto_defi_produ(productoprodumerma.getid_producto_defi_produ());
		productoprodumermaAsignar.setproductodefiprodu_descripcion(productoprodumerma.getproductodefiprodu_descripcion());	
		productoprodumermaAsignar.setid_tipo_merma_empresa(productoprodumerma.getid_tipo_merma_empresa());
		productoprodumermaAsignar.settipomermaempresa_descripcion(productoprodumerma.gettipomermaempresa_descripcion());	
		productoprodumermaAsignar.setid_unidad(productoprodumerma.getid_unidad());
		productoprodumermaAsignar.setunidad_descripcion(productoprodumerma.getunidad_descripcion());	
		productoprodumermaAsignar.setcantidad(productoprodumerma.getcantidad());	
		productoprodumermaAsignar.setcosto(productoprodumerma.getcosto());	
		productoprodumermaAsignar.setcosto_total(productoprodumerma.getcosto_total());	
		productoprodumermaAsignar.setdescripcion(productoprodumerma.getdescripcion());	
	}
	
	public static void inicializarProductoProduMerma(ProductoProduMerma productoprodumerma) throws Exception {
		try {
				productoprodumerma.setId(0L);	
					
				productoprodumerma.setid_producto_defi_produ(-1L);	
				productoprodumerma.setid_tipo_merma_empresa(-1L);	
				productoprodumerma.setid_unidad(-1L);	
				productoprodumerma.setcantidad(0);	
				productoprodumerma.setcosto(0.0);	
				productoprodumerma.setcosto_total(0.0);	
				productoprodumerma.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProduMerma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_IDTIPOMERMAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMermaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProduMerma(String sTipo,Row row,Workbook workbook,ProductoProduMerma productoprodumerma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getproductodefiprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.gettipomermaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumerma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProduMerma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProduMerma() {
		return this.sFinalQueryProductoProduMerma;
	}
	
	public void setsFinalQueryProductoProduMerma(String sFinalQueryProductoProduMerma) {
		this.sFinalQueryProductoProduMerma= sFinalQueryProductoProduMerma;
	}
	
	public Border resaltarSeleccionarProductoProduMerma=null;
	
	public Border setResaltarSeleccionarProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProduMerma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProduMerma() {
		return this.resaltarSeleccionarProductoProduMerma;
	}
	
	public void setResaltarSeleccionarProductoProduMerma(Border borderResaltarSeleccionarProductoProduMerma) {
		this.resaltarSeleccionarProductoProduMerma= borderResaltarSeleccionarProductoProduMerma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProduMerma=null;
	public Boolean mostraridProductoProduMerma=true;
	public Boolean activaridProductoProduMerma=true;

	public Border resaltarid_producto_defi_produProductoProduMerma=null;
	public Boolean mostrarid_producto_defi_produProductoProduMerma=true;
	public Boolean activarid_producto_defi_produProductoProduMerma=true;
	public Boolean cargarid_producto_defi_produProductoProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_defi_produProductoProduMerma=false;//ConEventDepend=true

	public Border resaltarid_tipo_merma_empresaProductoProduMerma=null;
	public Boolean mostrarid_tipo_merma_empresaProductoProduMerma=true;
	public Boolean activarid_tipo_merma_empresaProductoProduMerma=true;
	public Boolean cargarid_tipo_merma_empresaProductoProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_merma_empresaProductoProduMerma=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoProduMerma=null;
	public Boolean mostrarid_unidadProductoProduMerma=true;
	public Boolean activarid_unidadProductoProduMerma=true;
	public Boolean cargarid_unidadProductoProduMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoProduMerma=false;//ConEventDepend=true

	public Border resaltarcantidadProductoProduMerma=null;
	public Boolean mostrarcantidadProductoProduMerma=true;
	public Boolean activarcantidadProductoProduMerma=true;

	public Border resaltarcostoProductoProduMerma=null;
	public Boolean mostrarcostoProductoProduMerma=true;
	public Boolean activarcostoProductoProduMerma=true;

	public Border resaltarcosto_totalProductoProduMerma=null;
	public Boolean mostrarcosto_totalProductoProduMerma=true;
	public Boolean activarcosto_totalProductoProduMerma=true;

	public Border resaltardescripcionProductoProduMerma=null;
	public Boolean mostrardescripcionProductoProduMerma=true;
	public Boolean activardescripcionProductoProduMerma=true;

	
	

	public Border setResaltaridProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltaridProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProduMerma() {
		return this.resaltaridProductoProduMerma;
	}

	public void setResaltaridProductoProduMerma(Border borderResaltar) {
		this.resaltaridProductoProduMerma= borderResaltar;
	}

	public Boolean getMostraridProductoProduMerma() {
		return this.mostraridProductoProduMerma;
	}

	public void setMostraridProductoProduMerma(Boolean mostraridProductoProduMerma) {
		this.mostraridProductoProduMerma= mostraridProductoProduMerma;
	}

	public Boolean getActivaridProductoProduMerma() {
		return this.activaridProductoProduMerma;
	}

	public void setActivaridProductoProduMerma(Boolean activaridProductoProduMerma) {
		this.activaridProductoProduMerma= activaridProductoProduMerma;
	}

	public Border setResaltarid_producto_defi_produProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_producto_defi_produProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_defi_produProductoProduMerma() {
		return this.resaltarid_producto_defi_produProductoProduMerma;
	}

	public void setResaltarid_producto_defi_produProductoProduMerma(Border borderResaltar) {
		this.resaltarid_producto_defi_produProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_producto_defi_produProductoProduMerma() {
		return this.mostrarid_producto_defi_produProductoProduMerma;
	}

	public void setMostrarid_producto_defi_produProductoProduMerma(Boolean mostrarid_producto_defi_produProductoProduMerma) {
		this.mostrarid_producto_defi_produProductoProduMerma= mostrarid_producto_defi_produProductoProduMerma;
	}

	public Boolean getActivarid_producto_defi_produProductoProduMerma() {
		return this.activarid_producto_defi_produProductoProduMerma;
	}

	public void setActivarid_producto_defi_produProductoProduMerma(Boolean activarid_producto_defi_produProductoProduMerma) {
		this.activarid_producto_defi_produProductoProduMerma= activarid_producto_defi_produProductoProduMerma;
	}

	public Boolean getCargarid_producto_defi_produProductoProduMerma() {
		return this.cargarid_producto_defi_produProductoProduMerma;
	}

	public void setCargarid_producto_defi_produProductoProduMerma(Boolean cargarid_producto_defi_produProductoProduMerma) {
		this.cargarid_producto_defi_produProductoProduMerma= cargarid_producto_defi_produProductoProduMerma;
	}

	public Border setResaltarid_tipo_merma_empresaProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_merma_empresaProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_merma_empresaProductoProduMerma() {
		return this.resaltarid_tipo_merma_empresaProductoProduMerma;
	}

	public void setResaltarid_tipo_merma_empresaProductoProduMerma(Border borderResaltar) {
		this.resaltarid_tipo_merma_empresaProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_merma_empresaProductoProduMerma() {
		return this.mostrarid_tipo_merma_empresaProductoProduMerma;
	}

	public void setMostrarid_tipo_merma_empresaProductoProduMerma(Boolean mostrarid_tipo_merma_empresaProductoProduMerma) {
		this.mostrarid_tipo_merma_empresaProductoProduMerma= mostrarid_tipo_merma_empresaProductoProduMerma;
	}

	public Boolean getActivarid_tipo_merma_empresaProductoProduMerma() {
		return this.activarid_tipo_merma_empresaProductoProduMerma;
	}

	public void setActivarid_tipo_merma_empresaProductoProduMerma(Boolean activarid_tipo_merma_empresaProductoProduMerma) {
		this.activarid_tipo_merma_empresaProductoProduMerma= activarid_tipo_merma_empresaProductoProduMerma;
	}

	public Boolean getCargarid_tipo_merma_empresaProductoProduMerma() {
		return this.cargarid_tipo_merma_empresaProductoProduMerma;
	}

	public void setCargarid_tipo_merma_empresaProductoProduMerma(Boolean cargarid_tipo_merma_empresaProductoProduMerma) {
		this.cargarid_tipo_merma_empresaProductoProduMerma= cargarid_tipo_merma_empresaProductoProduMerma;
	}

	public Border setResaltarid_unidadProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoProduMerma() {
		return this.resaltarid_unidadProductoProduMerma;
	}

	public void setResaltarid_unidadProductoProduMerma(Border borderResaltar) {
		this.resaltarid_unidadProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoProduMerma() {
		return this.mostrarid_unidadProductoProduMerma;
	}

	public void setMostrarid_unidadProductoProduMerma(Boolean mostrarid_unidadProductoProduMerma) {
		this.mostrarid_unidadProductoProduMerma= mostrarid_unidadProductoProduMerma;
	}

	public Boolean getActivarid_unidadProductoProduMerma() {
		return this.activarid_unidadProductoProduMerma;
	}

	public void setActivarid_unidadProductoProduMerma(Boolean activarid_unidadProductoProduMerma) {
		this.activarid_unidadProductoProduMerma= activarid_unidadProductoProduMerma;
	}

	public Boolean getCargarid_unidadProductoProduMerma() {
		return this.cargarid_unidadProductoProduMerma;
	}

	public void setCargarid_unidadProductoProduMerma(Boolean cargarid_unidadProductoProduMerma) {
		this.cargarid_unidadProductoProduMerma= cargarid_unidadProductoProduMerma;
	}

	public Border setResaltarcantidadProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoProduMerma() {
		return this.resaltarcantidadProductoProduMerma;
	}

	public void setResaltarcantidadProductoProduMerma(Border borderResaltar) {
		this.resaltarcantidadProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoProduMerma() {
		return this.mostrarcantidadProductoProduMerma;
	}

	public void setMostrarcantidadProductoProduMerma(Boolean mostrarcantidadProductoProduMerma) {
		this.mostrarcantidadProductoProduMerma= mostrarcantidadProductoProduMerma;
	}

	public Boolean getActivarcantidadProductoProduMerma() {
		return this.activarcantidadProductoProduMerma;
	}

	public void setActivarcantidadProductoProduMerma(Boolean activarcantidadProductoProduMerma) {
		this.activarcantidadProductoProduMerma= activarcantidadProductoProduMerma;
	}

	public Border setResaltarcostoProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarcostoProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoProduMerma() {
		return this.resaltarcostoProductoProduMerma;
	}

	public void setResaltarcostoProductoProduMerma(Border borderResaltar) {
		this.resaltarcostoProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarcostoProductoProduMerma() {
		return this.mostrarcostoProductoProduMerma;
	}

	public void setMostrarcostoProductoProduMerma(Boolean mostrarcostoProductoProduMerma) {
		this.mostrarcostoProductoProduMerma= mostrarcostoProductoProduMerma;
	}

	public Boolean getActivarcostoProductoProduMerma() {
		return this.activarcostoProductoProduMerma;
	}

	public void setActivarcostoProductoProduMerma(Boolean activarcostoProductoProduMerma) {
		this.activarcostoProductoProduMerma= activarcostoProductoProduMerma;
	}

	public Border setResaltarcosto_totalProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoProduMerma() {
		return this.resaltarcosto_totalProductoProduMerma;
	}

	public void setResaltarcosto_totalProductoProduMerma(Border borderResaltar) {
		this.resaltarcosto_totalProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoProduMerma() {
		return this.mostrarcosto_totalProductoProduMerma;
	}

	public void setMostrarcosto_totalProductoProduMerma(Boolean mostrarcosto_totalProductoProduMerma) {
		this.mostrarcosto_totalProductoProduMerma= mostrarcosto_totalProductoProduMerma;
	}

	public Boolean getActivarcosto_totalProductoProduMerma() {
		return this.activarcosto_totalProductoProduMerma;
	}

	public void setActivarcosto_totalProductoProduMerma(Boolean activarcosto_totalProductoProduMerma) {
		this.activarcosto_totalProductoProduMerma= activarcosto_totalProductoProduMerma;
	}

	public Border setResaltardescripcionProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumermaBeanSwingJInternalFrame.jTtoolBarProductoProduMerma.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoProduMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoProduMerma() {
		return this.resaltardescripcionProductoProduMerma;
	}

	public void setResaltardescripcionProductoProduMerma(Border borderResaltar) {
		this.resaltardescripcionProductoProduMerma= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoProduMerma() {
		return this.mostrardescripcionProductoProduMerma;
	}

	public void setMostrardescripcionProductoProduMerma(Boolean mostrardescripcionProductoProduMerma) {
		this.mostrardescripcionProductoProduMerma= mostrardescripcionProductoProduMerma;
	}

	public Boolean getActivardescripcionProductoProduMerma() {
		return this.activardescripcionProductoProduMerma;
	}

	public void setActivardescripcionProductoProduMerma(Boolean activardescripcionProductoProduMerma) {
		this.activardescripcionProductoProduMerma= activardescripcionProductoProduMerma;
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
		
		
		this.setMostraridProductoProduMerma(esInicial);
		this.setMostrarid_producto_defi_produProductoProduMerma(esInicial);
		this.setMostrarid_tipo_merma_empresaProductoProduMerma(esInicial);
		this.setMostrarid_unidadProductoProduMerma(esInicial);
		this.setMostrarcantidadProductoProduMerma(esInicial);
		this.setMostrarcostoProductoProduMerma(esInicial);
		this.setMostrarcosto_totalProductoProduMerma(esInicial);
		this.setMostrardescripcionProductoProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.ID)) {
				this.setMostraridProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setMostrarid_producto_defi_produProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setMostrarid_tipo_merma_empresaProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoProduMerma(esAsigna);
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
		
		
		this.setActivaridProductoProduMerma(esInicial);
		this.setActivarid_producto_defi_produProductoProduMerma(esInicial);
		this.setActivarid_tipo_merma_empresaProductoProduMerma(esInicial);
		this.setActivarid_unidadProductoProduMerma(esInicial);
		this.setActivarcantidadProductoProduMerma(esInicial);
		this.setActivarcostoProductoProduMerma(esInicial);
		this.setActivarcosto_totalProductoProduMerma(esInicial);
		this.setActivardescripcionProductoProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.ID)) {
				this.setActivaridProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setActivarid_producto_defi_produProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setActivarid_tipo_merma_empresaProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoProduMerma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProduMerma(esInicial);
		this.setResaltarid_producto_defi_produProductoProduMerma(esInicial);
		this.setResaltarid_tipo_merma_empresaProductoProduMerma(esInicial);
		this.setResaltarid_unidadProductoProduMerma(esInicial);
		this.setResaltarcantidadProductoProduMerma(esInicial);
		this.setResaltarcostoProductoProduMerma(esInicial);
		this.setResaltarcosto_totalProductoProduMerma(esInicial);
		this.setResaltardescripcionProductoProduMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.ID)) {
				this.setResaltaridProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setResaltarid_producto_defi_produProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA)) {
				this.setResaltarid_tipo_merma_empresaProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoProduMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMermaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoProduMerma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdProductoDefiProduProductoProduMerma=true;

	public Boolean getMostrarFK_IdProductoDefiProduProductoProduMerma() {
		return this.mostrarFK_IdProductoDefiProduProductoProduMerma;
	}

	public void setMostrarFK_IdProductoDefiProduProductoProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDefiProduProductoProduMerma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMermaEmpresaProductoProduMerma=true;

	public Boolean getMostrarFK_IdTipoMermaEmpresaProductoProduMerma() {
		return this.mostrarFK_IdTipoMermaEmpresaProductoProduMerma;
	}

	public void setMostrarFK_IdTipoMermaEmpresaProductoProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMermaEmpresaProductoProduMerma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoProduMerma=true;

	public Boolean getMostrarFK_IdUnidadProductoProduMerma() {
		return this.mostrarFK_IdUnidadProductoProduMerma;
	}

	public void setMostrarFK_IdUnidadProductoProduMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoProduMerma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdProductoDefiProduProductoProduMerma=true;

	public Boolean getActivarFK_IdProductoDefiProduProductoProduMerma() {
		return this.activarFK_IdProductoDefiProduProductoProduMerma;
	}

	public void setActivarFK_IdProductoDefiProduProductoProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDefiProduProductoProduMerma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMermaEmpresaProductoProduMerma=true;

	public Boolean getActivarFK_IdTipoMermaEmpresaProductoProduMerma() {
		return this.activarFK_IdTipoMermaEmpresaProductoProduMerma;
	}

	public void setActivarFK_IdTipoMermaEmpresaProductoProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMermaEmpresaProductoProduMerma= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoProduMerma=true;

	public Boolean getActivarFK_IdUnidadProductoProduMerma() {
		return this.activarFK_IdUnidadProductoProduMerma;
	}

	public void setActivarFK_IdUnidadProductoProduMerma(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoProduMerma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdProductoDefiProduProductoProduMerma=null;

	public Border getResaltarFK_IdProductoDefiProduProductoProduMerma() {
		return this.resaltarFK_IdProductoDefiProduProductoProduMerma;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMerma(Border borderResaltar) {
		this.resaltarFK_IdProductoDefiProduProductoProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDefiProduProductoProduMerma= borderResaltar;
	}

	public Border resaltarFK_IdTipoMermaEmpresaProductoProduMerma=null;

	public Border getResaltarFK_IdTipoMermaEmpresaProductoProduMerma() {
		return this.resaltarFK_IdTipoMermaEmpresaProductoProduMerma;
	}

	public void setResaltarFK_IdTipoMermaEmpresaProductoProduMerma(Border borderResaltar) {
		this.resaltarFK_IdTipoMermaEmpresaProductoProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdTipoMermaEmpresaProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMermaEmpresaProductoProduMerma= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoProduMerma=null;

	public Border getResaltarFK_IdUnidadProductoProduMerma() {
		return this.resaltarFK_IdUnidadProductoProduMerma;
	}

	public void setResaltarFK_IdUnidadProductoProduMerma(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoProduMerma= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoProduMerma(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMermaBeanSwingJInternalFrame productoprodumermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoProduMerma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}