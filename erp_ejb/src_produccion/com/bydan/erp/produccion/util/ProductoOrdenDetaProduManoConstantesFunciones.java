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


import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoParameterGeneral;

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
final public class ProductoOrdenDetaProduManoConstantesFunciones extends ProductoOrdenDetaProduManoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoOrdenDetaProduMano";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoOrdenDetaProduMano"+ProductoOrdenDetaProduManoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoOrdenDetaProduManoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoOrdenDetaProduManoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduManoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduManoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoOrdenDetaProduManoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduManoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoOrdenDetaProduManoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduManoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden  Mano De Obraes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden  Mano De Obra";
	public static final String SCLASSWEBTITULO_LOWER="Producto Orden Deta Produ Mano";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoOrdenDetaProduMano";
	public static final String OBJECTNAME="productoordendetaprodumano";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_orden_deta_produ_mano";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoordendetaprodumano from "+ProductoOrdenDetaProduManoConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumano";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_tipo_mano_produ_empresa,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoOrdenDetaProduManoConstantesFuncionesAdditional productoordendetaprodumanoConstantesFuncionesAdditional=null;
	
	public ProductoOrdenDetaProduManoConstantesFuncionesAdditional getProductoOrdenDetaProduManoConstantesFuncionesAdditional() {
		return this.productoordendetaprodumanoConstantesFuncionesAdditional;
	}
	
	public void setProductoOrdenDetaProduManoConstantesFuncionesAdditional(ProductoOrdenDetaProduManoConstantesFuncionesAdditional productoordendetaprodumanoConstantesFuncionesAdditional) {
		try {
			this.productoordendetaprodumanoConstantesFuncionesAdditional=productoordendetaprodumanoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENDETAPRODU= "id_orden_deta_produ";
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
    	public static final String LABEL_IDORDENDETAPRODU= "Orden Deta Produ";
		public static final String LABEL_IDORDENDETAPRODU_LOWER= "Orden Deta Produ";
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
	
	public static String getProductoOrdenDetaProduManoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDORDENDETAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTO)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoOrdenDetaProduManoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoOrdenDetaProduManoDescripcion(ProductoOrdenDetaProduMano productoordendetaprodumano) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoordendetaprodumano !=null/* && productoordendetaprodumano.getId()!=0*/) {
			if(productoordendetaprodumano.getId()!=null) {
				sDescripcion=productoordendetaprodumano.getId().toString();
			}//productoordendetaprodumanoproductoordendetaprodumano.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoOrdenDetaProduManoDescripcionDetallado(ProductoOrdenDetaProduMano productoordendetaprodumano) {
		String sDescripcion="";
			
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.ID+"=";
		sDescripcion+=productoordendetaprodumano.getId().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoordendetaprodumano.getVersionRow().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU+"=";
		sDescripcion+=productoordendetaprodumano.getid_orden_deta_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA+"=";
		sDescripcion+=productoordendetaprodumano.getid_tipo_mano_produ_empresa().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU+"=";
		sDescripcion+=productoordendetaprodumano.getid_tipo_proceso_empresa_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoordendetaprodumano.getid_unidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoordendetaprodumano.getcantidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.COSTO+"=";
		sDescripcion+=productoordendetaprodumano.getcosto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoordendetaprodumano.getcosto_total().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoordendetaprodumano.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoOrdenDetaProduManoDescripcion(ProductoOrdenDetaProduMano productoordendetaprodumano,String sValor) throws Exception {			
		if(productoordendetaprodumano !=null) {
			//productoordendetaprodumanoproductoordendetaprodumano.getId().toString();
		}		
	}
	
		

	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordendetaprodu!=null/*&&ordendetaprodu.getId()>0*/) {
			sDescripcion=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(ordendetaprodu);
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
		} else if(sNombreIndice.equals("FK_IdOrdenDetaProdu")) {
			sNombreIndice="Tipo=  Por Orden Deta Produ";
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

	public static String getDetalleIndiceFK_IdOrdenDetaProdu(Long id_orden_deta_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_deta_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Deta Produ="+id_orden_deta_produ.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodumano.setdescripcion(productoordendetaprodumano.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano: productoordendetaprodumanos) {
			productoordendetaprodumano.setdescripcion(productoordendetaprodumano.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoordendetaprodumano.getConCambioAuxiliar()) {
			productoordendetaprodumano.setIsDeleted(productoordendetaprodumano.getIsDeletedAuxiliar());	
			productoordendetaprodumano.setIsNew(productoordendetaprodumano.getIsNewAuxiliar());	
			productoordendetaprodumano.setIsChanged(productoordendetaprodumano.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoordendetaprodumano.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoordendetaprodumano.setIsDeletedAuxiliar(false);	
			productoordendetaprodumano.setIsNewAuxiliar(false);	
			productoordendetaprodumano.setIsChangedAuxiliar(false);
			
			productoordendetaprodumano.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano : productoordendetaprodumanos) {
			if(conAsignarBase && productoordendetaprodumano.getConCambioAuxiliar()) {
				productoordendetaprodumano.setIsDeleted(productoordendetaprodumano.getIsDeletedAuxiliar());	
				productoordendetaprodumano.setIsNew(productoordendetaprodumano.getIsNewAuxiliar());	
				productoordendetaprodumano.setIsChanged(productoordendetaprodumano.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoordendetaprodumano.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoordendetaprodumano.setIsDeletedAuxiliar(false);	
				productoordendetaprodumano.setIsNewAuxiliar(false);	
				productoordendetaprodumano.setIsChangedAuxiliar(false);
				
				productoordendetaprodumano.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean conEnteros) throws Exception  {
		productoordendetaprodumano.setcosto(0.0);
		productoordendetaprodumano.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoordendetaprodumano.setcantidad(0L);
		}
	}		
	
	public static void InicializarValoresProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,Boolean conEnteros) throws Exception  {
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano: productoordendetaprodumanos) {
			productoordendetaprodumano.setcosto(0.0);
			productoordendetaprodumano.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoordendetaprodumano.setcantidad(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduMano productoordendetaprodumanoAux) throws Exception  {
		ProductoOrdenDetaProduManoConstantesFunciones.InicializarValoresProductoOrdenDetaProduMano(productoordendetaprodumanoAux,true);
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano: productoordendetaprodumanos) {
			if(productoordendetaprodumano.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoordendetaprodumanoAux.setcantidad(productoordendetaprodumanoAux.getcantidad()+productoordendetaprodumano.getcantidad());			
			productoordendetaprodumanoAux.setcosto(productoordendetaprodumanoAux.getcosto()+productoordendetaprodumano.getcosto());			
			productoordendetaprodumanoAux.setcosto_total(productoordendetaprodumanoAux.getcosto_total()+productoordendetaprodumano.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMano(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoOrdenDetaProduManoConstantesFunciones.getArrayColumnasGlobalesProductoOrdenDetaProduMano(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMano(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoOrdenDetaProduMano(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumanoAux: productoordendetaprodumanos) {
			if(productoordendetaprodumanoAux!=null && productoordendetaprodumano!=null) {
				if((productoordendetaprodumanoAux.getId()==null && productoordendetaprodumano.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoordendetaprodumanoAux.getId()!=null && productoordendetaprodumano.getId()!=null){
					if(productoordendetaprodumanoAux.getId().equals(productoordendetaprodumano.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduMano productoordendetaprodumano: productoordendetaprodumanos) {			
			if(productoordendetaprodumano.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoordendetaprodumano.getcosto();
			costo_totalTotal+=productoordendetaprodumano.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoOrdenDetaProduMano() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_ID, ProductoOrdenDetaProduManoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_VERSIONROW, ProductoOrdenDetaProduManoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDORDENDETAPRODU, ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA, ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU, ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDUNIDAD, ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_CANTIDAD, ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO, ProductoOrdenDetaProduManoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL, ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduManoConstantesFunciones.LABEL_DESCRIPCION, ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoOrdenDetaProduMano() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMano() throws Exception  {
		return ProductoOrdenDetaProduManoConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMano(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMano(Boolean conFk) throws Exception  {
		return ProductoOrdenDetaProduManoConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMano(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMano(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDORDENDETAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDORDENDETAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoOrdenDetaProduMano(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumanoAux) throws Exception {
		
			productoordendetaprodumanoAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumanoAux.getOrdenDetaProdu()));
			productoordendetaprodumanoAux.settipomanoproduempresa_descripcion(TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaDescripcion(productoordendetaprodumanoAux.getTipoManoProduEmpresa()));
			productoordendetaprodumanoAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoordendetaprodumanoAux.getTipoProcesoEmpresaProdu()));
			productoordendetaprodumanoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumanoAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> productoordendetaprodumanosTemp) throws Exception {
		for(ProductoOrdenDetaProduMano productoordendetaprodumanoAux:productoordendetaprodumanosTemp) {
			
			productoordendetaprodumanoAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumanoAux.getOrdenDetaProdu()));
			productoordendetaprodumanoAux.settipomanoproduempresa_descripcion(TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaDescripcion(productoordendetaprodumanoAux.getTipoManoProduEmpresa()));
			productoordendetaprodumanoAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoordendetaprodumanoAux.getTipoProcesoEmpresaProdu()));
			productoordendetaprodumanoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumanoAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(TipoManoProduEmpresa.class));
				classes.add(new Classe(TipoProcesoEmpresaProdu.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoOrdenDetaProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduManoConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMano(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduManoConstantesFunciones.getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMano(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMano(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoOrdenDetaProduMano productoordendetaprodumano,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoOrdenDetaProduMano productoordendetaprodumanoEncontrado=null;
			
			for(ProductoOrdenDetaProduMano productoordendetaprodumanoLocal:productoordendetaprodumanos) {
				if(productoordendetaprodumanoLocal.getId().equals(productoordendetaprodumano.getId())) {
					productoordendetaprodumanoEncontrado=productoordendetaprodumanoLocal;
					
					productoordendetaprodumanoLocal.setIsChanged(productoordendetaprodumano.getIsChanged());
					productoordendetaprodumanoLocal.setIsNew(productoordendetaprodumano.getIsNew());
					productoordendetaprodumanoLocal.setIsDeleted(productoordendetaprodumano.getIsDeleted());
					
					productoordendetaprodumanoLocal.setGeneralEntityOriginal(productoordendetaprodumano.getGeneralEntityOriginal());
					
					productoordendetaprodumanoLocal.setId(productoordendetaprodumano.getId());	
					productoordendetaprodumanoLocal.setVersionRow(productoordendetaprodumano.getVersionRow());	
					productoordendetaprodumanoLocal.setid_orden_deta_produ(productoordendetaprodumano.getid_orden_deta_produ());	
					productoordendetaprodumanoLocal.setid_tipo_mano_produ_empresa(productoordendetaprodumano.getid_tipo_mano_produ_empresa());	
					productoordendetaprodumanoLocal.setid_tipo_proceso_empresa_produ(productoordendetaprodumano.getid_tipo_proceso_empresa_produ());	
					productoordendetaprodumanoLocal.setid_unidad(productoordendetaprodumano.getid_unidad());	
					productoordendetaprodumanoLocal.setcantidad(productoordendetaprodumano.getcantidad());	
					productoordendetaprodumanoLocal.setcosto(productoordendetaprodumano.getcosto());	
					productoordendetaprodumanoLocal.setcosto_total(productoordendetaprodumano.getcosto_total());	
					productoordendetaprodumanoLocal.setdescripcion(productoordendetaprodumano.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoordendetaprodumano.getIsDeleted()) {
				if(!existe) {
					productoordendetaprodumanos.add(productoordendetaprodumano);
				}
			} else {
				if(productoordendetaprodumanoEncontrado!=null && permiteQuitar)  {
					productoordendetaprodumanos.remove(productoordendetaprodumanoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoOrdenDetaProduMano productoordendetaprodumano,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos) throws Exception {
		try	{			
			for(ProductoOrdenDetaProduMano productoordendetaprodumanoLocal:productoordendetaprodumanos) {
				if(productoordendetaprodumanoLocal.getId().equals(productoordendetaprodumano.getId())) {
					productoordendetaprodumanoLocal.setIsSelected(productoordendetaprodumano.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> productoordendetaprodumanosAux) throws Exception {
		//this.productoordendetaprodumanosAux=productoordendetaprodumanosAux;
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumanoAux:productoordendetaprodumanosAux) {
			if(productoordendetaprodumanoAux.getIsChanged()) {
				productoordendetaprodumanoAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumanoAux.getIsNew()) {
				productoordendetaprodumanoAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumanoAux.getIsDeleted()) {
				productoordendetaprodumanoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumanoAux) throws Exception {
		//this.productoordendetaprodumanoAux=productoordendetaprodumanoAux;
		
			if(productoordendetaprodumanoAux.getIsChanged()) {
				productoordendetaprodumanoAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumanoAux.getIsNew()) {
				productoordendetaprodumanoAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumanoAux.getIsDeleted()) {
				productoordendetaprodumanoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoOrdenDetaProduMano productoordendetaprodumanoAsignar,ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {
		productoordendetaprodumanoAsignar.setId(productoordendetaprodumano.getId());	
		productoordendetaprodumanoAsignar.setVersionRow(productoordendetaprodumano.getVersionRow());	
		productoordendetaprodumanoAsignar.setid_orden_deta_produ(productoordendetaprodumano.getid_orden_deta_produ());
		productoordendetaprodumanoAsignar.setordendetaprodu_descripcion(productoordendetaprodumano.getordendetaprodu_descripcion());	
		productoordendetaprodumanoAsignar.setid_tipo_mano_produ_empresa(productoordendetaprodumano.getid_tipo_mano_produ_empresa());
		productoordendetaprodumanoAsignar.settipomanoproduempresa_descripcion(productoordendetaprodumano.gettipomanoproduempresa_descripcion());	
		productoordendetaprodumanoAsignar.setid_tipo_proceso_empresa_produ(productoordendetaprodumano.getid_tipo_proceso_empresa_produ());
		productoordendetaprodumanoAsignar.settipoprocesoempresaprodu_descripcion(productoordendetaprodumano.gettipoprocesoempresaprodu_descripcion());	
		productoordendetaprodumanoAsignar.setid_unidad(productoordendetaprodumano.getid_unidad());
		productoordendetaprodumanoAsignar.setunidad_descripcion(productoordendetaprodumano.getunidad_descripcion());	
		productoordendetaprodumanoAsignar.setcantidad(productoordendetaprodumano.getcantidad());	
		productoordendetaprodumanoAsignar.setcosto(productoordendetaprodumano.getcosto());	
		productoordendetaprodumanoAsignar.setcosto_total(productoordendetaprodumano.getcosto_total());	
		productoordendetaprodumanoAsignar.setdescripcion(productoordendetaprodumano.getdescripcion());	
	}
	
	public static void inicializarProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {
		try {
				productoordendetaprodumano.setId(0L);	
					
				productoordendetaprodumano.setid_orden_deta_produ(-1L);	
				productoordendetaprodumano.setid_tipo_mano_produ_empresa(-1L);	
				productoordendetaprodumano.setid_tipo_proceso_empresa_produ(-1L);	
				productoordendetaprodumano.setid_unidad(-1L);	
				productoordendetaprodumano.setcantidad(0L);	
				productoordendetaprodumano.setcosto(0.0);	
				productoordendetaprodumano.setcosto_total(0.0);	
				productoordendetaprodumano.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoOrdenDetaProduMano(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDORDENDETAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOMANOPRODUEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduManoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoOrdenDetaProduMano(String sTipo,Row row,Workbook workbook,ProductoOrdenDetaProduMano productoordendetaprodumano,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getordendetaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.gettipomanoproduempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.gettipoprocesoempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumano.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoOrdenDetaProduMano=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoOrdenDetaProduMano() {
		return this.sFinalQueryProductoOrdenDetaProduMano;
	}
	
	public void setsFinalQueryProductoOrdenDetaProduMano(String sFinalQueryProductoOrdenDetaProduMano) {
		this.sFinalQueryProductoOrdenDetaProduMano= sFinalQueryProductoOrdenDetaProduMano;
	}
	
	public Border resaltarSeleccionarProductoOrdenDetaProduMano=null;
	
	public Border setResaltarSeleccionarProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoOrdenDetaProduMano= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoOrdenDetaProduMano() {
		return this.resaltarSeleccionarProductoOrdenDetaProduMano;
	}
	
	public void setResaltarSeleccionarProductoOrdenDetaProduMano(Border borderResaltarSeleccionarProductoOrdenDetaProduMano) {
		this.resaltarSeleccionarProductoOrdenDetaProduMano= borderResaltarSeleccionarProductoOrdenDetaProduMano;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoOrdenDetaProduMano=null;
	public Boolean mostraridProductoOrdenDetaProduMano=true;
	public Boolean activaridProductoOrdenDetaProduMano=true;

	public Border resaltarid_orden_deta_produProductoOrdenDetaProduMano=null;
	public Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMano=true;
	public Boolean activarid_orden_deta_produProductoOrdenDetaProduMano=true;
	public Boolean cargarid_orden_deta_produProductoOrdenDetaProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_deta_produProductoOrdenDetaProduMano=false;//ConEventDepend=true

	public Border resaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano=null;
	public Boolean mostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano=true;
	public Boolean activarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano=true;
	public Boolean cargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_mano_produ_empresaProductoOrdenDetaProduMano=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano=null;
	public Boolean mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano=true;
	public Boolean activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano=true;
	public Boolean cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_empresa_produProductoOrdenDetaProduMano=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoOrdenDetaProduMano=null;
	public Boolean mostrarid_unidadProductoOrdenDetaProduMano=true;
	public Boolean activarid_unidadProductoOrdenDetaProduMano=true;
	public Boolean cargarid_unidadProductoOrdenDetaProduMano=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoOrdenDetaProduMano=false;//ConEventDepend=true

	public Border resaltarcantidadProductoOrdenDetaProduMano=null;
	public Boolean mostrarcantidadProductoOrdenDetaProduMano=true;
	public Boolean activarcantidadProductoOrdenDetaProduMano=true;

	public Border resaltarcostoProductoOrdenDetaProduMano=null;
	public Boolean mostrarcostoProductoOrdenDetaProduMano=true;
	public Boolean activarcostoProductoOrdenDetaProduMano=true;

	public Border resaltarcosto_totalProductoOrdenDetaProduMano=null;
	public Boolean mostrarcosto_totalProductoOrdenDetaProduMano=true;
	public Boolean activarcosto_totalProductoOrdenDetaProduMano=true;

	public Border resaltardescripcionProductoOrdenDetaProduMano=null;
	public Boolean mostrardescripcionProductoOrdenDetaProduMano=true;
	public Boolean activardescripcionProductoOrdenDetaProduMano=true;

	
	

	public Border setResaltaridProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltaridProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoOrdenDetaProduMano() {
		return this.resaltaridProductoOrdenDetaProduMano;
	}

	public void setResaltaridProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltaridProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostraridProductoOrdenDetaProduMano() {
		return this.mostraridProductoOrdenDetaProduMano;
	}

	public void setMostraridProductoOrdenDetaProduMano(Boolean mostraridProductoOrdenDetaProduMano) {
		this.mostraridProductoOrdenDetaProduMano= mostraridProductoOrdenDetaProduMano;
	}

	public Boolean getActivaridProductoOrdenDetaProduMano() {
		return this.activaridProductoOrdenDetaProduMano;
	}

	public void setActivaridProductoOrdenDetaProduMano(Boolean activaridProductoOrdenDetaProduMano) {
		this.activaridProductoOrdenDetaProduMano= activaridProductoOrdenDetaProduMano;
	}

	public Border setResaltarid_orden_deta_produProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_deta_produProductoOrdenDetaProduMano() {
		return this.resaltarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public void setResaltarid_orden_deta_produProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarid_orden_deta_produProductoOrdenDetaProduMano() {
		return this.mostrarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public void setMostrarid_orden_deta_produProductoOrdenDetaProduMano(Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMano) {
		this.mostrarid_orden_deta_produProductoOrdenDetaProduMano= mostrarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public Boolean getActivarid_orden_deta_produProductoOrdenDetaProduMano() {
		return this.activarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public void setActivarid_orden_deta_produProductoOrdenDetaProduMano(Boolean activarid_orden_deta_produProductoOrdenDetaProduMano) {
		this.activarid_orden_deta_produProductoOrdenDetaProduMano= activarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public Boolean getCargarid_orden_deta_produProductoOrdenDetaProduMano() {
		return this.cargarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public void setCargarid_orden_deta_produProductoOrdenDetaProduMano(Boolean cargarid_orden_deta_produProductoOrdenDetaProduMano) {
		this.cargarid_orden_deta_produProductoOrdenDetaProduMano= cargarid_orden_deta_produProductoOrdenDetaProduMano;
	}

	public Border setResaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano() {
		return this.resaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public void setResaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano() {
		return this.mostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public void setMostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(Boolean mostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano) {
		this.mostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano= mostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public Boolean getActivarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano() {
		return this.activarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public void setActivarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(Boolean activarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano) {
		this.activarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano= activarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public Boolean getCargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano() {
		return this.cargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public void setCargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(Boolean cargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano) {
		this.cargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano= cargarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano;
	}

	public Border setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano() {
		return this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public void setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano() {
		return this.mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public void setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(Boolean mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano) {
		this.mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano= mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public Boolean getActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano() {
		return this.activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public void setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(Boolean activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano) {
		this.activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano= activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public Boolean getCargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano() {
		return this.cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public void setCargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(Boolean cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano) {
		this.cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano= cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano;
	}

	public Border setResaltarid_unidadProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoOrdenDetaProduMano() {
		return this.resaltarid_unidadProductoOrdenDetaProduMano;
	}

	public void setResaltarid_unidadProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarid_unidadProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoOrdenDetaProduMano() {
		return this.mostrarid_unidadProductoOrdenDetaProduMano;
	}

	public void setMostrarid_unidadProductoOrdenDetaProduMano(Boolean mostrarid_unidadProductoOrdenDetaProduMano) {
		this.mostrarid_unidadProductoOrdenDetaProduMano= mostrarid_unidadProductoOrdenDetaProduMano;
	}

	public Boolean getActivarid_unidadProductoOrdenDetaProduMano() {
		return this.activarid_unidadProductoOrdenDetaProduMano;
	}

	public void setActivarid_unidadProductoOrdenDetaProduMano(Boolean activarid_unidadProductoOrdenDetaProduMano) {
		this.activarid_unidadProductoOrdenDetaProduMano= activarid_unidadProductoOrdenDetaProduMano;
	}

	public Boolean getCargarid_unidadProductoOrdenDetaProduMano() {
		return this.cargarid_unidadProductoOrdenDetaProduMano;
	}

	public void setCargarid_unidadProductoOrdenDetaProduMano(Boolean cargarid_unidadProductoOrdenDetaProduMano) {
		this.cargarid_unidadProductoOrdenDetaProduMano= cargarid_unidadProductoOrdenDetaProduMano;
	}

	public Border setResaltarcantidadProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoOrdenDetaProduMano() {
		return this.resaltarcantidadProductoOrdenDetaProduMano;
	}

	public void setResaltarcantidadProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarcantidadProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoOrdenDetaProduMano() {
		return this.mostrarcantidadProductoOrdenDetaProduMano;
	}

	public void setMostrarcantidadProductoOrdenDetaProduMano(Boolean mostrarcantidadProductoOrdenDetaProduMano) {
		this.mostrarcantidadProductoOrdenDetaProduMano= mostrarcantidadProductoOrdenDetaProduMano;
	}

	public Boolean getActivarcantidadProductoOrdenDetaProduMano() {
		return this.activarcantidadProductoOrdenDetaProduMano;
	}

	public void setActivarcantidadProductoOrdenDetaProduMano(Boolean activarcantidadProductoOrdenDetaProduMano) {
		this.activarcantidadProductoOrdenDetaProduMano= activarcantidadProductoOrdenDetaProduMano;
	}

	public Border setResaltarcostoProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarcostoProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoOrdenDetaProduMano() {
		return this.resaltarcostoProductoOrdenDetaProduMano;
	}

	public void setResaltarcostoProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarcostoProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarcostoProductoOrdenDetaProduMano() {
		return this.mostrarcostoProductoOrdenDetaProduMano;
	}

	public void setMostrarcostoProductoOrdenDetaProduMano(Boolean mostrarcostoProductoOrdenDetaProduMano) {
		this.mostrarcostoProductoOrdenDetaProduMano= mostrarcostoProductoOrdenDetaProduMano;
	}

	public Boolean getActivarcostoProductoOrdenDetaProduMano() {
		return this.activarcostoProductoOrdenDetaProduMano;
	}

	public void setActivarcostoProductoOrdenDetaProduMano(Boolean activarcostoProductoOrdenDetaProduMano) {
		this.activarcostoProductoOrdenDetaProduMano= activarcostoProductoOrdenDetaProduMano;
	}

	public Border setResaltarcosto_totalProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoOrdenDetaProduMano() {
		return this.resaltarcosto_totalProductoOrdenDetaProduMano;
	}

	public void setResaltarcosto_totalProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarcosto_totalProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoOrdenDetaProduMano() {
		return this.mostrarcosto_totalProductoOrdenDetaProduMano;
	}

	public void setMostrarcosto_totalProductoOrdenDetaProduMano(Boolean mostrarcosto_totalProductoOrdenDetaProduMano) {
		this.mostrarcosto_totalProductoOrdenDetaProduMano= mostrarcosto_totalProductoOrdenDetaProduMano;
	}

	public Boolean getActivarcosto_totalProductoOrdenDetaProduMano() {
		return this.activarcosto_totalProductoOrdenDetaProduMano;
	}

	public void setActivarcosto_totalProductoOrdenDetaProduMano(Boolean activarcosto_totalProductoOrdenDetaProduMano) {
		this.activarcosto_totalProductoOrdenDetaProduMano= activarcosto_totalProductoOrdenDetaProduMano;
	}

	public Border setResaltardescripcionProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumanoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMano.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoOrdenDetaProduMano= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoOrdenDetaProduMano() {
		return this.resaltardescripcionProductoOrdenDetaProduMano;
	}

	public void setResaltardescripcionProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltardescripcionProductoOrdenDetaProduMano= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoOrdenDetaProduMano() {
		return this.mostrardescripcionProductoOrdenDetaProduMano;
	}

	public void setMostrardescripcionProductoOrdenDetaProduMano(Boolean mostrardescripcionProductoOrdenDetaProduMano) {
		this.mostrardescripcionProductoOrdenDetaProduMano= mostrardescripcionProductoOrdenDetaProduMano;
	}

	public Boolean getActivardescripcionProductoOrdenDetaProduMano() {
		return this.activardescripcionProductoOrdenDetaProduMano;
	}

	public void setActivardescripcionProductoOrdenDetaProduMano(Boolean activardescripcionProductoOrdenDetaProduMano) {
		this.activardescripcionProductoOrdenDetaProduMano= activardescripcionProductoOrdenDetaProduMano;
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
		
		
		this.setMostraridProductoOrdenDetaProduMano(esInicial);
		this.setMostrarid_orden_deta_produProductoOrdenDetaProduMano(esInicial);
		this.setMostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esInicial);
		this.setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esInicial);
		this.setMostrarid_unidadProductoOrdenDetaProduMano(esInicial);
		this.setMostrarcantidadProductoOrdenDetaProduMano(esInicial);
		this.setMostrarcostoProductoOrdenDetaProduMano(esInicial);
		this.setMostrarcosto_totalProductoOrdenDetaProduMano(esInicial);
		this.setMostrardescripcionProductoOrdenDetaProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.ID)) {
				this.setMostraridProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setMostrarid_orden_deta_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setMostrarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoOrdenDetaProduMano(esAsigna);
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
		
		
		this.setActivaridProductoOrdenDetaProduMano(esInicial);
		this.setActivarid_orden_deta_produProductoOrdenDetaProduMano(esInicial);
		this.setActivarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esInicial);
		this.setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esInicial);
		this.setActivarid_unidadProductoOrdenDetaProduMano(esInicial);
		this.setActivarcantidadProductoOrdenDetaProduMano(esInicial);
		this.setActivarcostoProductoOrdenDetaProduMano(esInicial);
		this.setActivarcosto_totalProductoOrdenDetaProduMano(esInicial);
		this.setActivardescripcionProductoOrdenDetaProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.ID)) {
				this.setActivaridProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setActivarid_orden_deta_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setActivarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoOrdenDetaProduMano(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoOrdenDetaProduMano(esInicial);
		this.setResaltarid_orden_deta_produProductoOrdenDetaProduMano(esInicial);
		this.setResaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esInicial);
		this.setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esInicial);
		this.setResaltarid_unidadProductoOrdenDetaProduMano(esInicial);
		this.setResaltarcantidadProductoOrdenDetaProduMano(esInicial);
		this.setResaltarcostoProductoOrdenDetaProduMano(esInicial);
		this.setResaltarcosto_totalProductoOrdenDetaProduMano(esInicial);
		this.setResaltardescripcionProductoOrdenDetaProduMano(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.ID)) {
				this.setResaltaridProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setResaltarid_orden_deta_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA)) {
				this.setResaltarid_tipo_mano_produ_empresaProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoOrdenDetaProduMano(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoOrdenDetaProduMano(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMano=true;

	public Boolean getMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMano() {
		return this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMano;
	}

	public void setMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano=true;

	public Boolean getMostrarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano() {
		return this.mostrarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano;
	}

	public void setMostrarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano=true;

	public Boolean getMostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano() {
		return this.mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano;
	}

	public void setMostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoOrdenDetaProduMano=true;

	public Boolean getMostrarFK_IdUnidadProductoOrdenDetaProduMano() {
		return this.mostrarFK_IdUnidadProductoOrdenDetaProduMano;
	}

	public void setMostrarFK_IdUnidadProductoOrdenDetaProduMano(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoOrdenDetaProduMano= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdOrdenDetaProduProductoOrdenDetaProduMano=true;

	public Boolean getActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMano() {
		return this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMano;
	}

	public void setActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano=true;

	public Boolean getActivarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano() {
		return this.activarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano;
	}

	public void setActivarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano=true;

	public Boolean getActivarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano() {
		return this.activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano;
	}

	public void setActivarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoOrdenDetaProduMano=true;

	public Boolean getActivarFK_IdUnidadProductoOrdenDetaProduMano() {
		return this.activarFK_IdUnidadProductoOrdenDetaProduMano;
	}

	public void setActivarFK_IdUnidadProductoOrdenDetaProduMano(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoOrdenDetaProduMano= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano=null;

	public Border getResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano() {
		return this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano= borderResaltar;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMano= borderResaltar;
	}

	public Border resaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano=null;

	public Border getResaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano() {
		return this.resaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano;
	}

	public void setResaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano= borderResaltar;
	}

	public void setResaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoManoProduEmpresaProductoOrdenDetaProduMano= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano=null;

	public Border getResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano() {
		return this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMano= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoOrdenDetaProduMano=null;

	public Border getResaltarFK_IdUnidadProductoOrdenDetaProduMano() {
		return this.resaltarFK_IdUnidadProductoOrdenDetaProduMano;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMano(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMano= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMano(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduManoBeanSwingJInternalFrame productoordendetaprodumanoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMano= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}