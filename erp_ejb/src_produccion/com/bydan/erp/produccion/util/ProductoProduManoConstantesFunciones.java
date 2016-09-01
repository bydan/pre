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


import com.bydan.erp.produccion.util.ProductoProduManoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduManoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduManoParameterGeneral;

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
final public class ProductoProduManoConstantesFunciones extends ProductoProduManoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProduMano";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProduMano"+ProductoProduManoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProduManoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProduManoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProduManoConstantesFunciones.SCHEMA+"_"+ProductoProduManoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProduManoConstantesFunciones.SCHEMA+"_"+ProductoProduManoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProduManoConstantesFunciones.SCHEMA+"_"+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProduManoConstantesFunciones.SCHEMA+"_"+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProduManoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProduManoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProduManoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProduManoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Mano De Obra Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Mano De Obra Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Produ Mano";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProduMano";
	public static final String OBJECTNAME="productoprodumano";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_produ_mano";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoprodumano from "+ProductoProduManoConstantesFunciones.SPERSISTENCENAME+" productoprodumano";
	public static String QUERYSELECTNATIVE="select "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".version_row,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_tipo_mano_produ_empresa,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".costo,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoProduManoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProduManoConstantesFuncionesAdditional productoprodumanoConstantesFuncionesAdditional=null;
	
	public ProductoProduManoConstantesFuncionesAdditional getProductoProduManoConstantesFuncionesAdditional() {
		return this.productoprodumanoConstantesFuncionesAdditional;
	}
	
	public void setProductoProduManoConstantesFuncionesAdditional(ProductoProduManoConstantesFuncionesAdditional productoprodumanoConstantesFuncionesAdditional) {
		try {
			this.productoprodumanoConstantesFuncionesAdditional=productoprodumanoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTODEFIPRODU= "id_producto_defi_produ";
    public static final String IDTIPOMANOPRODUEMPRESA= "id_tipo_mano_produ_empresa";
    public static final String IDTIPOPROCESOEMPRESAPRODU= "id_tipo_proceso_empresa_produ";
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
    	public static final String LABEL_IDTIPOMANOPRODUEMPRESA= "Tipo Mano Obra Empresa";
		public static final String LABEL_IDTIPOMANOPRODUEMPRESA_LOWER= "Tipo Mano Produ Empresa";
    	public static final String LABEL_IDTIPOPROCESOEMPRESAPRODU= "Tipo Proceso Empresa Produ";
		public static final String LABEL_IDTIPOPROCESOEMPRESAPRODU_LOWER= "Tipo Proceso Empresa Produ";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoProduManoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.COSTO)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoProduManoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoProduManoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProduManoDescripcion(ProductoProduMano productoprodumano) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoprodumano !=null/* && productoprodumano.getId()!=0*/) {
			if(productoprodumano.getId()!=null) {
				sDescripcion=productoprodumano.getId().toString();
			}//productoprodumanoproductoprodumano.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProduManoDescripcionDetallado(ProductoProduMano productoprodumano) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProduManoConstantesFunciones.ID+"=";
		sDescripcion+=productoprodumano.getId().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoprodumano.getVersionRow().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU+"=";
		sDescripcion+=productoprodumano.getid_producto_defi_produ().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA+"=";
		sDescripcion+=productoprodumano.getid_tipo_mano_produ_empresa().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU+"=";
		sDescripcion+=productoprodumano.getid_tipo_proceso_empresa_produ().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoprodumano.getid_unidad().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoprodumano.getcantidad().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.COSTO+"=";
		sDescripcion+=productoprodumano.getcosto().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoprodumano.getcosto_total().toString()+",";
		sDescripcion+=ProductoProduManoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoprodumano.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProduManoDescripcion(ProductoProduMano productoprodumano,String sValor) throws Exception {			
		if(productoprodumano !=null) {
			//productoprodumanoproductoprodumano.getId().toString();
		}		
	}
	
		

	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(productodefiprodu!=null/*&&productodefiprodu.getId()>0*/) {
			sDescripcion=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productodefiprodu);
		}

		return sDescripcion;
	}

	public static String getTipoManoProduEmpresaDescripcion(TipoManoProduEmpresa tipomanoproduempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomanoproduempresa!=null/*&&tipomanoproduempresa.getId()>0*/) {
			sDescripcion=TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaDescripcion(tipomanoproduempresa);
		}

		return sDescripcion;
	}

	public static String getTipoProcesoEmpresaProduDescripcion(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprocesoempresaprodu!=null/*&&tipoprocesoempresaprodu.getId()>0*/) {
			sDescripcion=TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(tipoprocesoempresaprodu);
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
		} else if(sNombreIndice.equals("FK_IdTipoManoProduEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Mano Obra Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoProcesoEmpresaProdu")) {
			sNombreIndice="Tipo=  Por Tipo Proceso Empresa Produ";
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

	public static String getDetalleIndiceFK_IdTipoManoProduEmpresa(Long id_tipo_mano_produ_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_mano_produ_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Mano Obra Empresa="+id_tipo_mano_produ_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProcesoEmpresaProdu(Long id_tipo_proceso_empresa_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_proceso_empresa_produ!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proceso Empresa Produ="+id_tipo_proceso_empresa_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoProduMano(ProductoProduMano productoprodumano,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodumano.setdescripcion(productoprodumano.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProduManos(List<ProductoProduMano> productoprodumanos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProduMano productoprodumano: productoprodumanos) {
			productoprodumano.setdescripcion(productoprodumano.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduMano(ProductoProduMano productoprodumano,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoprodumano.getConCambioAuxiliar()) {
			productoprodumano.setIsDeleted(productoprodumano.getIsDeletedAuxiliar());	
			productoprodumano.setIsNew(productoprodumano.getIsNewAuxiliar());	
			productoprodumano.setIsChanged(productoprodumano.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoprodumano.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoprodumano.setIsDeletedAuxiliar(false);	
			productoprodumano.setIsNewAuxiliar(false);	
			productoprodumano.setIsChangedAuxiliar(false);
			
			productoprodumano.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduManos(List<ProductoProduMano> productoprodumanos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProduMano productoprodumano : productoprodumanos) {
			if(conAsignarBase && productoprodumano.getConCambioAuxiliar()) {
				productoprodumano.setIsDeleted(productoprodumano.getIsDeletedAuxiliar());	
				productoprodumano.setIsNew(productoprodumano.getIsNewAuxiliar());	
				productoprodumano.setIsChanged(productoprodumano.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoprodumano.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoprodumano.setIsDeletedAuxiliar(false);	
				productoprodumano.setIsNewAuxiliar(false);	
				productoprodumano.setIsChangedAuxiliar(false);
				
				productoprodumano.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProduMano(ProductoProduMano productoprodumano,Boolean conEnteros) throws Exception  {
		productoprodumano.setcosto(0.0);
		productoprodumano.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoprodumano.setcantidad(0L);
		}
	}		
	
	public static void InicializarValoresProductoProduManos(List<ProductoProduMano> productoprodumanos,Boolean conEnteros) throws Exception  {
		
		for(ProductoProduMano productoprodumano: productoprodumanos) {
			productoprodumano.setcosto(0.0);
			productoprodumano.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoprodumano.setcantidad(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProduMano(List<ProductoProduMano> productoprodumanos,ProductoProduMano productoprodumanoAux) throws Exception  {
		ProductoProduManoConstantesFunciones.InicializarValoresProductoProduMano(productoprodumanoAux,true);
		
		for(ProductoProduMano productoprodumano: productoprodumanos) {
			if(productoprodumano.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoprodumanoAux.setcantidad(productoprodumanoAux.getcantidad()+productoprodumano.getcantidad());			
			productoprodumanoAux.setcosto(productoprodumanoAux.getcosto()+productoprodumano.getcosto());			
			productoprodumanoAux.setcosto_total(productoprodumanoAux.getcosto_total()+productoprodumano.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMano(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProduManoConstantesFunciones.getArrayColumnasGlobalesProductoProduMano(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMano(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProduMano(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProduMano> productoprodumanos,ProductoProduMano productoprodumano,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProduMano productoprodumanoAux: productoprodumanos) {
			if(productoprodumanoAux!=null && productoprodumano!=null) {
				if((productoprodumanoAux.getId()==null && productoprodumano.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoprodumanoAux.getId()!=null && productoprodumano.getId()!=null){
					if(productoprodumanoAux.getId().equals(productoprodumano.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProduMano(List<ProductoProduMano> productoprodumanos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProduMano productoprodumano: productoprodumanos) {			
			if(productoprodumano.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoprodumano.getcosto();
			costo_totalTotal+=productoprodumano.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduManoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduManoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProduMano() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_ID, ProductoProduManoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_VERSIONROW, ProductoProduManoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU, ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA, ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU, ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_IDUNIDAD, ProductoProduManoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_CANTIDAD, ProductoProduManoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_COSTO, ProductoProduManoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL, ProductoProduManoConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduManoConstantesFunciones.LABEL_DESCRIPCION, ProductoProduManoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProduMano() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduManoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMano() throws Exception  {
		return ProductoProduManoConstantesFunciones.getTiposSeleccionarProductoProduMano(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMano(Boolean conFk) throws Exception  {
		return ProductoProduManoConstantesFunciones.getTiposSeleccionarProductoProduMano(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMano(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduManoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoProduManoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProduMano(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMano(ProductoProduMano productoprodumanoAux) throws Exception {
		
			productoprodumanoAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumanoAux.getProductoDefiProdu()));
			productoprodumanoAux.settipomanoproduempresa_descripcion(TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaDescripcion(productoprodumanoAux.getTipoManoProduEmpresa()));
			productoprodumanoAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoprodumanoAux.getTipoProcesoEmpresaProdu()));
			productoprodumanoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumanoAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMano(List<ProductoProduMano> productoprodumanosTemp) throws Exception {
		for(ProductoProduMano productoprodumanoAux:productoprodumanosTemp) {
			
			productoprodumanoAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumanoAux.getProductoDefiProdu()));
			productoprodumanoAux.settipomanoproduempresa_descripcion(TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaDescripcion(productoprodumanoAux.getTipoManoProduEmpresa()));
			productoprodumanoAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoprodumanoAux.getTipoProcesoEmpresaProdu()));
			productoprodumanoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumanoAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoDefiProdu.class));
				classes.add(new Classe(TipoManoProduEmpresa.class));
				classes.add(new Classe(TipoProcesoEmpresaProdu.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoDefiProdu.class)) {
						classes.add(new Classe(ProductoDefiProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoManoProduEmpresa.class)) {
						classes.add(new Classe(TipoManoProduEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
					}

					if(TipoManoProduEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoManoProduEmpresa.class)); continue;
					}

					if(TipoProcesoEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class)); continue;
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

					if(TipoManoProduEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoManoProduEmpresa.class)); continue;
					}

					if(TipoProcesoEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduManoConstantesFunciones.getClassesRelationshipsOfProductoProduMano(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduManoConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProduMano(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProduMano productoprodumano,List<ProductoProduMano> productoprodumanos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProduMano productoprodumanoEncontrado=null;
			
			for(ProductoProduMano productoprodumanoLocal:productoprodumanos) {
				if(productoprodumanoLocal.getId().equals(productoprodumano.getId())) {
					productoprodumanoEncontrado=productoprodumanoLocal;
					
					productoprodumanoLocal.setIsChanged(productoprodumano.getIsChanged());
					productoprodumanoLocal.setIsNew(productoprodumano.getIsNew());
					productoprodumanoLocal.setIsDeleted(productoprodumano.getIsDeleted());
					
					productoprodumanoLocal.setGeneralEntityOriginal(productoprodumano.getGeneralEntityOriginal());
					
					productoprodumanoLocal.setId(productoprodumano.getId());	
					productoprodumanoLocal.setVersionRow(productoprodumano.getVersionRow());	
					productoprodumanoLocal.setid_producto_defi_produ(productoprodumano.getid_producto_defi_produ());	
					productoprodumanoLocal.setid_tipo_mano_produ_empresa(productoprodumano.getid_tipo_mano_produ_empresa());	
					productoprodumanoLocal.setid_tipo_proceso_empresa_produ(productoprodumano.getid_tipo_proceso_empresa_produ());	
					productoprodumanoLocal.setid_unidad(productoprodumano.getid_unidad());	
					productoprodumanoLocal.setcantidad(productoprodumano.getcantidad());	
					productoprodumanoLocal.setcosto(productoprodumano.getcosto());	
					productoprodumanoLocal.setcosto_total(productoprodumano.getcosto_total());	
					productoprodumanoLocal.setdescripcion(productoprodumano.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoprodumano.getIsDeleted()) {
				if(!existe) {
					productoprodumanos.add(productoprodumano);
				}
			} else {
				if(productoprodumanoEncontrado!=null && permiteQuitar)  {
					productoprodumanos.remove(productoprodumanoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProduMano productoprodumano,List<ProductoProduMano> productoprodumanos) throws Exception {
		try	{			
			for(ProductoProduMano productoprodumanoLocal:productoprodumanos) {
				if(productoprodumanoLocal.getId().equals(productoprodumano.getId())) {
					productoprodumanoLocal.setIsSelected(productoprodumano.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProduMano(List<ProductoProduMano> productoprodumanosAux) throws Exception {
		//this.productoprodumanosAux=productoprodumanosAux;
		
		for(ProductoProduMano productoprodumanoAux:productoprodumanosAux) {
			if(productoprodumanoAux.getIsChanged()) {
				productoprodumanoAux.setIsChanged(false);
			}		
			
			if(productoprodumanoAux.getIsNew()) {
				productoprodumanoAux.setIsNew(false);
			}	
			
			if(productoprodumanoAux.getIsDeleted()) {
				productoprodumanoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProduMano(ProductoProduMano productoprodumanoAux) throws Exception {
		//this.productoprodumanoAux=productoprodumanoAux;
		
			if(productoprodumanoAux.getIsChanged()) {
				productoprodumanoAux.setIsChanged(false);
			}		
			
			if(productoprodumanoAux.getIsNew()) {
				productoprodumanoAux.setIsNew(false);
			}	
			
			if(productoprodumanoAux.getIsDeleted()) {
				productoprodumanoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProduMano productoprodumanoAsignar,ProductoProduMano productoprodumano) throws Exception {
		productoprodumanoAsignar.setId(productoprodumano.getId());	
		productoprodumanoAsignar.setVersionRow(productoprodumano.getVersionRow());	
		productoprodumanoAsignar.setid_producto_defi_produ(productoprodumano.getid_producto_defi_produ());
		productoprodumanoAsignar.setproductodefiprodu_descripcion(productoprodumano.getproductodefiprodu_descripcion());	
		productoprodumanoAsignar.setid_tipo_mano_produ_empresa(productoprodumano.getid_tipo_mano_produ_empresa());
		productoprodumanoAsignar.settipomanoproduempresa_descripcion(productoprodumano.gettipomanoproduempresa_descripcion());	
		productoprodumanoAsignar.setid_tipo_proceso_empresa_produ(productoprodumano.getid_tipo_proceso_empresa_produ());
		productoprodumanoAsignar.settipoprocesoempresaprodu_descripcion(productoprodumano.gettipoprocesoempresaprodu_descripcion());	
		productoprodumanoAsignar.setid_unidad(productoprodumano.getid_unidad());
		productoprodumanoAsignar.setunidad_descripcion(productoprodumano.getunidad_descripcion());	
		productoprodumanoAsignar.setcantidad(productoprodumano.getcantidad());	
		productoprodumanoAsignar.setcosto(productoprodumano.getcosto());	
		productoprodumanoAsignar.setcosto_total(productoprodumano.getcosto_total());	
		productoprodumanoAsignar.setdescripcion(productoprodumano.getdescripcion());	
	}
	
	public static void inicializarProductoProduMano(ProductoProduMano productoprodumano) throws Exception {
		try {
				productoprodumano.setId(0L);	
					
				productoprodumano.setid_producto_defi_produ(-1L);	
				productoprodumano.setid_tipo_mano_produ_empresa(-1L);	
				productoprodumano.setid_tipo_proceso_empresa_produ(-1L);	
				productoprodumano.setid_unidad(-1L);	
				productoprodumano.setcantidad(0L);	
				productoprodumano.setcosto(0.0);	
				productoprodumano.setcosto_total(0.0);	
				productoprodumano.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProduMano(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduManoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProduMano(String sTipo,Row row,Workbook workbook,ProductoProduMano productoprodumano,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getproductodefiprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.gettipomanoproduempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.gettipoprocesoempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumano.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProduMano=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProduMano() {
		return this.sFinalQueryProductoProduMano;
	}
	
	public void setsFinalQueryProductoProduMano(String sFinalQueryProductoProduMano) {
		this.sFinalQueryProductoProduMano= sFinalQueryProductoProduMano;
	}
	
	public Border resaltarSeleccionarProductoProduMano=null;
	
	public Border setResaltarSeleccionarProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProduMano= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProduMano() {
		return this.resaltarSeleccionarProductoProduMano;
	}
	
	public void setResaltarSeleccionarProductoProduMano(Border borderResaltarSeleccionarProductoProduMano) {
		this.resaltarSeleccionarProductoProduMano= borderResaltarSeleccionarProductoProduMano;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProduMano=null;
	public Boolean mostraridProductoProduMano=true;
	public Boolean activaridProductoProduMano=true;

	public Border resaltarid_producto_defi_produProductoProduMano=null;
	public Boolean mostrarid_producto_defi_produProductoProduMano=true;
	public Boolean activarid_producto_defi_produProductoProduMano=true;
	public Boolean cargarid_producto_defi_produProductoProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_defi_produProductoProduMano=false;//ConEventDepend=true

	public Border resaltarid_tipo_mano_produ_empresaProductoProduMano=null;
	public Boolean mostrarid_tipo_mano_produ_empresaProductoProduMano=true;
	public Boolean activarid_tipo_mano_produ_empresaProductoProduMano=true;
	public Boolean cargarid_tipo_mano_produ_empresaProductoProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_mano_produ_empresaProductoProduMano=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_empresa_produProductoProduMano=null;
	public Boolean mostrarid_tipo_proceso_empresa_produProductoProduMano=true;
	public Boolean activarid_tipo_proceso_empresa_produProductoProduMano=true;
	public Boolean cargarid_tipo_proceso_empresa_produProductoProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_empresa_produProductoProduMano=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoProduMano=null;
	public Boolean mostrarid_unidadProductoProduMano=true;
	public Boolean activarid_unidadProductoProduMano=true;
	public Boolean cargarid_unidadProductoProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoProduMano=false;//ConEventDepend=true

	public Border resaltarcantidadProductoProduMano=null;
	public Boolean mostrarcantidadProductoProduMano=true;
	public Boolean activarcantidadProductoProduMano=true;

	public Border resaltarcostoProductoProduMano=null;
	public Boolean mostrarcostoProductoProduMano=true;
	public Boolean activarcostoProductoProduMano=true;

	public Border resaltarcosto_totalProductoProduMano=null;
	public Boolean mostrarcosto_totalProductoProduMano=true;
	public Boolean activarcosto_totalProductoProduMano=true;

	public Border resaltardescripcionProductoProduMano=null;
	public Boolean mostrardescripcionProductoProduMano=true;
	public Boolean activardescripcionProductoProduMano=true;

	
	

	public Border setResaltaridProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltaridProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProduMano() {
		return this.resaltaridProductoProduMano;
	}

	public void setResaltaridProductoProduMano(Border borderResaltar) {
		this.resaltaridProductoProduMano= borderResaltar;
	}

	public Boolean getMostraridProductoProduMano() {
		return this.mostraridProductoProduMano;
	}

	public void setMostraridProductoProduMano(Boolean mostraridProductoProduMano) {
		this.mostraridProductoProduMano= mostraridProductoProduMano;
	}

	public Boolean getActivaridProductoProduMano() {
		return this.activaridProductoProduMano;
	}

	public void setActivaridProductoProduMano(Boolean activaridProductoProduMano) {
		this.activaridProductoProduMano= activaridProductoProduMano;
	}

	public Border setResaltarid_producto_defi_produProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarid_producto_defi_produProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_defi_produProductoProduMano() {
		return this.resaltarid_producto_defi_produProductoProduMano;
	}

	public void setResaltarid_producto_defi_produProductoProduMano(Border borderResaltar) {
		this.resaltarid_producto_defi_produProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarid_producto_defi_produProductoProduMano() {
		return this.mostrarid_producto_defi_produProductoProduMano;
	}

	public void setMostrarid_producto_defi_produProductoProduMano(Boolean mostrarid_producto_defi_produProductoProduMano) {
		this.mostrarid_producto_defi_produProductoProduMano= mostrarid_producto_defi_produProductoProduMano;
	}

	public Boolean getActivarid_producto_defi_produProductoProduMano() {
		return this.activarid_producto_defi_produProductoProduMano;
	}

	public void setActivarid_producto_defi_produProductoProduMano(Boolean activarid_producto_defi_produProductoProduMano) {
		this.activarid_producto_defi_produProductoProduMano= activarid_producto_defi_produProductoProduMano;
	}

	public Boolean getCargarid_producto_defi_produProductoProduMano() {
		return this.cargarid_producto_defi_produProductoProduMano;
	}

	public void setCargarid_producto_defi_produProductoProduMano(Boolean cargarid_producto_defi_produProductoProduMano) {
		this.cargarid_producto_defi_produProductoProduMano= cargarid_producto_defi_produProductoProduMano;
	}

	public Border setResaltarid_tipo_mano_produ_empresaProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarid_tipo_mano_produ_empresaProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_mano_produ_empresaProductoProduMano() {
		return this.resaltarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public void setResaltarid_tipo_mano_produ_empresaProductoProduMano(Border borderResaltar) {
		this.resaltarid_tipo_mano_produ_empresaProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarid_tipo_mano_produ_empresaProductoProduMano() {
		return this.mostrarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public void setMostrarid_tipo_mano_produ_empresaProductoProduMano(Boolean mostrarid_tipo_mano_produ_empresaProductoProduMano) {
		this.mostrarid_tipo_mano_produ_empresaProductoProduMano= mostrarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public Boolean getActivarid_tipo_mano_produ_empresaProductoProduMano() {
		return this.activarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public void setActivarid_tipo_mano_produ_empresaProductoProduMano(Boolean activarid_tipo_mano_produ_empresaProductoProduMano) {
		this.activarid_tipo_mano_produ_empresaProductoProduMano= activarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public Boolean getCargarid_tipo_mano_produ_empresaProductoProduMano() {
		return this.cargarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public void setCargarid_tipo_mano_produ_empresaProductoProduMano(Boolean cargarid_tipo_mano_produ_empresaProductoProduMano) {
		this.cargarid_tipo_mano_produ_empresaProductoProduMano= cargarid_tipo_mano_produ_empresaProductoProduMano;
	}

	public Border setResaltarid_tipo_proceso_empresa_produProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_empresa_produProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_empresa_produProductoProduMano() {
		return this.resaltarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public void setResaltarid_tipo_proceso_empresa_produProductoProduMano(Border borderResaltar) {
		this.resaltarid_tipo_proceso_empresa_produProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_empresa_produProductoProduMano() {
		return this.mostrarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public void setMostrarid_tipo_proceso_empresa_produProductoProduMano(Boolean mostrarid_tipo_proceso_empresa_produProductoProduMano) {
		this.mostrarid_tipo_proceso_empresa_produProductoProduMano= mostrarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public Boolean getActivarid_tipo_proceso_empresa_produProductoProduMano() {
		return this.activarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public void setActivarid_tipo_proceso_empresa_produProductoProduMano(Boolean activarid_tipo_proceso_empresa_produProductoProduMano) {
		this.activarid_tipo_proceso_empresa_produProductoProduMano= activarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public Boolean getCargarid_tipo_proceso_empresa_produProductoProduMano() {
		return this.cargarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public void setCargarid_tipo_proceso_empresa_produProductoProduMano(Boolean cargarid_tipo_proceso_empresa_produProductoProduMano) {
		this.cargarid_tipo_proceso_empresa_produProductoProduMano= cargarid_tipo_proceso_empresa_produProductoProduMano;
	}

	public Border setResaltarid_unidadProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoProduMano() {
		return this.resaltarid_unidadProductoProduMano;
	}

	public void setResaltarid_unidadProductoProduMano(Border borderResaltar) {
		this.resaltarid_unidadProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoProduMano() {
		return this.mostrarid_unidadProductoProduMano;
	}

	public void setMostrarid_unidadProductoProduMano(Boolean mostrarid_unidadProductoProduMano) {
		this.mostrarid_unidadProductoProduMano= mostrarid_unidadProductoProduMano;
	}

	public Boolean getActivarid_unidadProductoProduMano() {
		return this.activarid_unidadProductoProduMano;
	}

	public void setActivarid_unidadProductoProduMano(Boolean activarid_unidadProductoProduMano) {
		this.activarid_unidadProductoProduMano= activarid_unidadProductoProduMano;
	}

	public Boolean getCargarid_unidadProductoProduMano() {
		return this.cargarid_unidadProductoProduMano;
	}

	public void setCargarid_unidadProductoProduMano(Boolean cargarid_unidadProductoProduMano) {
		this.cargarid_unidadProductoProduMano= cargarid_unidadProductoProduMano;
	}

	public Border setResaltarcantidadProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoProduMano() {
		return this.resaltarcantidadProductoProduMano;
	}

	public void setResaltarcantidadProductoProduMano(Border borderResaltar) {
		this.resaltarcantidadProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoProduMano() {
		return this.mostrarcantidadProductoProduMano;
	}

	public void setMostrarcantidadProductoProduMano(Boolean mostrarcantidadProductoProduMano) {
		this.mostrarcantidadProductoProduMano= mostrarcantidadProductoProduMano;
	}

	public Boolean getActivarcantidadProductoProduMano() {
		return this.activarcantidadProductoProduMano;
	}

	public void setActivarcantidadProductoProduMano(Boolean activarcantidadProductoProduMano) {
		this.activarcantidadProductoProduMano= activarcantidadProductoProduMano;
	}

	public Border setResaltarcostoProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarcostoProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoProduMano() {
		return this.resaltarcostoProductoProduMano;
	}

	public void setResaltarcostoProductoProduMano(Border borderResaltar) {
		this.resaltarcostoProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarcostoProductoProduMano() {
		return this.mostrarcostoProductoProduMano;
	}

	public void setMostrarcostoProductoProduMano(Boolean mostrarcostoProductoProduMano) {
		this.mostrarcostoProductoProduMano= mostrarcostoProductoProduMano;
	}

	public Boolean getActivarcostoProductoProduMano() {
		return this.activarcostoProductoProduMano;
	}

	public void setActivarcostoProductoProduMano(Boolean activarcostoProductoProduMano) {
		this.activarcostoProductoProduMano= activarcostoProductoProduMano;
	}

	public Border setResaltarcosto_totalProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoProduMano() {
		return this.resaltarcosto_totalProductoProduMano;
	}

	public void setResaltarcosto_totalProductoProduMano(Border borderResaltar) {
		this.resaltarcosto_totalProductoProduMano= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoProduMano() {
		return this.mostrarcosto_totalProductoProduMano;
	}

	public void setMostrarcosto_totalProductoProduMano(Boolean mostrarcosto_totalProductoProduMano) {
		this.mostrarcosto_totalProductoProduMano= mostrarcosto_totalProductoProduMano;
	}

	public Boolean getActivarcosto_totalProductoProduMano() {
		return this.activarcosto_totalProductoProduMano;
	}

	public void setActivarcosto_totalProductoProduMano(Boolean activarcosto_totalProductoProduMano) {
		this.activarcosto_totalProductoProduMano= activarcosto_totalProductoProduMano;
	}

	public Border setResaltardescripcionProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumanoBeanSwingJInternalFrame.jTtoolBarProductoProduMano.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoProduMano() {
		return this.resaltardescripcionProductoProduMano;
	}

	public void setResaltardescripcionProductoProduMano(Border borderResaltar) {
		this.resaltardescripcionProductoProduMano= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoProduMano() {
		return this.mostrardescripcionProductoProduMano;
	}

	public void setMostrardescripcionProductoProduMano(Boolean mostrardescripcionProductoProduMano) {
		this.mostrardescripcionProductoProduMano= mostrardescripcionProductoProduMano;
	}

	public Boolean getActivardescripcionProductoProduMano() {
		return this.activardescripcionProductoProduMano;
	}

	public void setActivardescripcionProductoProduMano(Boolean activardescripcionProductoProduMano) {
		this.activardescripcionProductoProduMano= activardescripcionProductoProduMano;
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
		
		
		this.setMostraridProductoProduMano(esInicial);
		this.setMostrarid_producto_defi_produProductoProduMano(esInicial);
		this.setMostrarid_tipo_mano_produ_empresaProductoProduMano(esInicial);
		this.setMostrarid_tipo_proceso_empresa_produProductoProduMano(esInicial);
		this.setMostrarid_unidadProductoProduMano(esInicial);
		this.setMostrarcantidadProductoProduMano(esInicial);
		this.setMostrarcostoProductoProduMano(esInicial);
		this.setMostrarcosto_totalProductoProduMano(esInicial);
		this.setMostrardescripcionProductoProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.ID)) {
				this.setMostraridProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setMostrarid_producto_defi_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setMostrarid_tipo_mano_produ_empresaProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setMostrarid_tipo_proceso_empresa_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoProduMano(esAsigna);
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
		
		
		this.setActivaridProductoProduMano(esInicial);
		this.setActivarid_producto_defi_produProductoProduMano(esInicial);
		this.setActivarid_tipo_mano_produ_empresaProductoProduMano(esInicial);
		this.setActivarid_tipo_proceso_empresa_produProductoProduMano(esInicial);
		this.setActivarid_unidadProductoProduMano(esInicial);
		this.setActivarcantidadProductoProduMano(esInicial);
		this.setActivarcostoProductoProduMano(esInicial);
		this.setActivarcosto_totalProductoProduMano(esInicial);
		this.setActivardescripcionProductoProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.ID)) {
				this.setActivaridProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setActivarid_producto_defi_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setActivarid_tipo_mano_produ_empresaProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setActivarid_tipo_proceso_empresa_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoProduMano(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProduMano(esInicial);
		this.setResaltarid_producto_defi_produProductoProduMano(esInicial);
		this.setResaltarid_tipo_mano_produ_empresaProductoProduMano(esInicial);
		this.setResaltarid_tipo_proceso_empresa_produProductoProduMano(esInicial);
		this.setResaltarid_unidadProductoProduMano(esInicial);
		this.setResaltarcantidadProductoProduMano(esInicial);
		this.setResaltarcostoProductoProduMano(esInicial);
		this.setResaltarcosto_totalProductoProduMano(esInicial);
		this.setResaltardescripcionProductoProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.ID)) {
				this.setResaltaridProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setResaltarid_producto_defi_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setResaltarid_tipo_mano_produ_empresaProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setResaltarid_tipo_proceso_empresa_produProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduManoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoProduMano(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdProductoDefiProduProductoProduMano=true;

	public Boolean getMostrarFK_IdProductoDefiProduProductoProduMano() {
		return this.mostrarFK_IdProductoDefiProduProductoProduMano;
	}

	public void setMostrarFK_IdProductoDefiProduProductoProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDefiProduProductoProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoManoProduEmpresaProductoProduMano=true;

	public Boolean getMostrarFK_IdTipoManoProduEmpresaProductoProduMano() {
		return this.mostrarFK_IdTipoManoProduEmpresaProductoProduMano;
	}

	public void setMostrarFK_IdTipoManoProduEmpresaProductoProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoManoProduEmpresaProductoProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoEmpresaProduProductoProduMano=true;

	public Boolean getMostrarFK_IdTipoProcesoEmpresaProduProductoProduMano() {
		return this.mostrarFK_IdTipoProcesoEmpresaProduProductoProduMano;
	}

	public void setMostrarFK_IdTipoProcesoEmpresaProduProductoProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoEmpresaProduProductoProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoProduMano=true;

	public Boolean getMostrarFK_IdUnidadProductoProduMano() {
		return this.mostrarFK_IdUnidadProductoProduMano;
	}

	public void setMostrarFK_IdUnidadProductoProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoProduMano= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdProductoDefiProduProductoProduMano=true;

	public Boolean getActivarFK_IdProductoDefiProduProductoProduMano() {
		return this.activarFK_IdProductoDefiProduProductoProduMano;
	}

	public void setActivarFK_IdProductoDefiProduProductoProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDefiProduProductoProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoManoProduEmpresaProductoProduMano=true;

	public Boolean getActivarFK_IdTipoManoProduEmpresaProductoProduMano() {
		return this.activarFK_IdTipoManoProduEmpresaProductoProduMano;
	}

	public void setActivarFK_IdTipoManoProduEmpresaProductoProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdTipoManoProduEmpresaProductoProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoEmpresaProduProductoProduMano=true;

	public Boolean getActivarFK_IdTipoProcesoEmpresaProduProductoProduMano() {
		return this.activarFK_IdTipoProcesoEmpresaProduProductoProduMano;
	}

	public void setActivarFK_IdTipoProcesoEmpresaProduProductoProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoEmpresaProduProductoProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoProduMano=true;

	public Boolean getActivarFK_IdUnidadProductoProduMano() {
		return this.activarFK_IdUnidadProductoProduMano;
	}

	public void setActivarFK_IdUnidadProductoProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoProduMano= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdProductoDefiProduProductoProduMano=null;

	public Border getResaltarFK_IdProductoDefiProduProductoProduMano() {
		return this.resaltarFK_IdProductoDefiProduProductoProduMano;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMano(Border borderResaltar) {
		this.resaltarFK_IdProductoDefiProduProductoProduMano= borderResaltar;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDefiProduProductoProduMano= borderResaltar;
	}

	public Border resaltarFK_IdTipoManoProduEmpresaProductoProduMano=null;

	public Border getResaltarFK_IdTipoManoProduEmpresaProductoProduMano() {
		return this.resaltarFK_IdTipoManoProduEmpresaProductoProduMano;
	}

	public void setResaltarFK_IdTipoManoProduEmpresaProductoProduMano(Border borderResaltar) {
		this.resaltarFK_IdTipoManoProduEmpresaProductoProduMano= borderResaltar;
	}

	public void setResaltarFK_IdTipoManoProduEmpresaProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoManoProduEmpresaProductoProduMano= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoEmpresaProduProductoProduMano=null;

	public Border getResaltarFK_IdTipoProcesoEmpresaProduProductoProduMano() {
		return this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMano;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoProduMano(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMano= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMano= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoProduMano=null;

	public Border getResaltarFK_IdUnidadProductoProduMano() {
		return this.resaltarFK_IdUnidadProductoProduMano;
	}

	public void setResaltarFK_IdUnidadProductoProduMano(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoProduMano= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduManoBeanSwingJInternalFrame productoprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoProduMano= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}