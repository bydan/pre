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


import com.bydan.erp.produccion.util.ProductoProduMaquinaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduMaquinaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduMaquinaParameterGeneral;

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
final public class ProductoProduMaquinaConstantesFunciones extends ProductoProduMaquinaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProduMaquina";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProduMaquina"+ProductoProduMaquinaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProduMaquinaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProduMaquinaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoProduMaquinaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoProduMaquinaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProduMaquinaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProduMaquinaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProduMaquinaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProduMaquinaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Maquina Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Maquina Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Produ Maquina";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProduMaquina";
	public static final String OBJECTNAME="productoprodumaquina";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_produ_maquina";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoprodumaquina from "+ProductoProduMaquinaConstantesFunciones.SPERSISTENCENAME+" productoprodumaquina";
	public static String QUERYSELECTNATIVE="select "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".version_row,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_area_empresa_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".costo,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMaquinaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProduMaquinaConstantesFuncionesAdditional productoprodumaquinaConstantesFuncionesAdditional=null;
	
	public ProductoProduMaquinaConstantesFuncionesAdditional getProductoProduMaquinaConstantesFuncionesAdditional() {
		return this.productoprodumaquinaConstantesFuncionesAdditional;
	}
	
	public void setProductoProduMaquinaConstantesFuncionesAdditional(ProductoProduMaquinaConstantesFuncionesAdditional productoprodumaquinaConstantesFuncionesAdditional) {
		try {
			this.productoprodumaquinaConstantesFuncionesAdditional=productoprodumaquinaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTODEFIPRODU= "id_producto_defi_produ";
    public static final String IDTIPOAREAEMPRESAPRODU= "id_tipo_area_empresa_produ";
    public static final String IDTIPOPROCESOEMPRESAPRODU= "id_tipo_proceso_empresa_produ";
    public static final String IDTIPOMAQUINAEMPRESA= "id_tipo_merma_empresa";
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
    	public static final String LABEL_IDTIPOAREAEMPRESAPRODU= "Tipo Area Empresa Produ";
		public static final String LABEL_IDTIPOAREAEMPRESAPRODU_LOWER= "Tipo Area Empresa Produ";
    	public static final String LABEL_IDTIPOPROCESOEMPRESAPRODU= "Tipo Proceso Empresa Produ";
		public static final String LABEL_IDTIPOPROCESOEMPRESAPRODU_LOWER= "Tipo Proceso Empresa Produ";
    	public static final String LABEL_IDTIPOMAQUINAEMPRESA= "Tipo Merma Empresa";
		public static final String LABEL_IDTIPOMAQUINAEMPRESA_LOWER= "Tipo Maquina Empresa";
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
	
	public static String getProductoProduMaquinaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.COSTO)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoProduMaquinaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoProduMaquinaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProduMaquinaDescripcion(ProductoProduMaquina productoprodumaquina) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoprodumaquina !=null/* && productoprodumaquina.getId()!=0*/) {
			if(productoprodumaquina.getId()!=null) {
				sDescripcion=productoprodumaquina.getId().toString();
			}//productoprodumaquinaproductoprodumaquina.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProduMaquinaDescripcionDetallado(ProductoProduMaquina productoprodumaquina) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.ID+"=";
		sDescripcion+=productoprodumaquina.getId().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoprodumaquina.getVersionRow().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU+"=";
		sDescripcion+=productoprodumaquina.getid_producto_defi_produ().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU+"=";
		sDescripcion+=productoprodumaquina.getid_tipo_area_empresa_produ().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU+"=";
		sDescripcion+=productoprodumaquina.getid_tipo_proceso_empresa_produ().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA+"=";
		sDescripcion+=productoprodumaquina.getid_tipo_merma_empresa().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoprodumaquina.getid_unidad().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoprodumaquina.getcantidad().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.COSTO+"=";
		sDescripcion+=productoprodumaquina.getcosto().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoprodumaquina.getcosto_total().toString()+",";
		sDescripcion+=ProductoProduMaquinaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoprodumaquina.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProduMaquinaDescripcion(ProductoProduMaquina productoprodumaquina,String sValor) throws Exception {			
		if(productoprodumaquina !=null) {
			//productoprodumaquinaproductoprodumaquina.getId().toString();
		}		
	}
	
		

	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(productodefiprodu!=null/*&&productodefiprodu.getId()>0*/) {
			sDescripcion=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productodefiprodu);
		}

		return sDescripcion;
	}

	public static String getTipoAreaEmpresaProduDescripcion(TipoAreaEmpresaProdu tipoareaempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoareaempresaprodu!=null/*&&tipoareaempresaprodu.getId()>0*/) {
			sDescripcion=TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduDescripcion(tipoareaempresaprodu);
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

	public static String getTipoMaquinaEmpresaDescripcion(TipoMaquinaEmpresa tipomaquinaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomaquinaempresa!=null/*&&tipomaquinaempresa.getId()>0*/) {
			sDescripcion=TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaDescripcion(tipomaquinaempresa);
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
		} else if(sNombreIndice.equals("FK_IdTipoAreaEmpresaProdu")) {
			sNombreIndice="Tipo=  Por Tipo Area Empresa Produ";
		} else if(sNombreIndice.equals("FK_IdTipoMaquinaEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Merma Empresa";
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

	public static String getDetalleIndiceFK_IdTipoAreaEmpresaProdu(Long id_tipo_area_empresa_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_area_empresa_produ!=null) {sDetalleIndice+=" Codigo Unico De Tipo Area Empresa Produ="+id_tipo_area_empresa_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMaquinaEmpresa(Long id_tipo_merma_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_merma_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Merma Empresa="+id_tipo_merma_empresa.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoProduMaquina(ProductoProduMaquina productoprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodumaquina.setdescripcion(productoprodumaquina.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProduMaquina productoprodumaquina: productoprodumaquinas) {
			productoprodumaquina.setdescripcion(productoprodumaquina.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduMaquina(ProductoProduMaquina productoprodumaquina,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoprodumaquina.getConCambioAuxiliar()) {
			productoprodumaquina.setIsDeleted(productoprodumaquina.getIsDeletedAuxiliar());	
			productoprodumaquina.setIsNew(productoprodumaquina.getIsNewAuxiliar());	
			productoprodumaquina.setIsChanged(productoprodumaquina.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoprodumaquina.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoprodumaquina.setIsDeletedAuxiliar(false);	
			productoprodumaquina.setIsNewAuxiliar(false);	
			productoprodumaquina.setIsChangedAuxiliar(false);
			
			productoprodumaquina.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProduMaquina productoprodumaquina : productoprodumaquinas) {
			if(conAsignarBase && productoprodumaquina.getConCambioAuxiliar()) {
				productoprodumaquina.setIsDeleted(productoprodumaquina.getIsDeletedAuxiliar());	
				productoprodumaquina.setIsNew(productoprodumaquina.getIsNewAuxiliar());	
				productoprodumaquina.setIsChanged(productoprodumaquina.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoprodumaquina.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoprodumaquina.setIsDeletedAuxiliar(false);	
				productoprodumaquina.setIsNewAuxiliar(false);	
				productoprodumaquina.setIsChangedAuxiliar(false);
				
				productoprodumaquina.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProduMaquina(ProductoProduMaquina productoprodumaquina,Boolean conEnteros) throws Exception  {
		productoprodumaquina.setcosto(0.0);
		productoprodumaquina.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoprodumaquina.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas,Boolean conEnteros) throws Exception  {
		
		for(ProductoProduMaquina productoprodumaquina: productoprodumaquinas) {
			productoprodumaquina.setcosto(0.0);
			productoprodumaquina.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoprodumaquina.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProduMaquina(List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquina productoprodumaquinaAux) throws Exception  {
		ProductoProduMaquinaConstantesFunciones.InicializarValoresProductoProduMaquina(productoprodumaquinaAux,true);
		
		for(ProductoProduMaquina productoprodumaquina: productoprodumaquinas) {
			if(productoprodumaquina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoprodumaquinaAux.setcantidad(productoprodumaquinaAux.getcantidad()+productoprodumaquina.getcantidad());			
			productoprodumaquinaAux.setcosto(productoprodumaquinaAux.getcosto()+productoprodumaquina.getcosto());			
			productoprodumaquinaAux.setcosto_total(productoprodumaquinaAux.getcosto_total()+productoprodumaquina.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProduMaquinaConstantesFunciones.getArrayColumnasGlobalesProductoProduMaquina(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquina productoprodumaquina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProduMaquina productoprodumaquinaAux: productoprodumaquinas) {
			if(productoprodumaquinaAux!=null && productoprodumaquina!=null) {
				if((productoprodumaquinaAux.getId()==null && productoprodumaquina.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoprodumaquinaAux.getId()!=null && productoprodumaquina.getId()!=null){
					if(productoprodumaquinaAux.getId().equals(productoprodumaquina.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProduMaquina(List<ProductoProduMaquina> productoprodumaquinas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProduMaquina productoprodumaquina: productoprodumaquinas) {			
			if(productoprodumaquina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoprodumaquina.getcosto();
			costo_totalTotal+=productoprodumaquina.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduMaquinaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduMaquinaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProduMaquina() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_ID, ProductoProduMaquinaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_VERSIONROW, ProductoProduMaquinaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU, ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU, ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU, ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA, ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_IDUNIDAD, ProductoProduMaquinaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_CANTIDAD, ProductoProduMaquinaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_COSTO, ProductoProduMaquinaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL, ProductoProduMaquinaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduMaquinaConstantesFunciones.LABEL_DESCRIPCION, ProductoProduMaquinaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProduMaquina() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduMaquinaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMaquina() throws Exception  {
		return ProductoProduMaquinaConstantesFunciones.getTiposSeleccionarProductoProduMaquina(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMaquina(Boolean conFk) throws Exception  {
		return ProductoProduMaquinaConstantesFunciones.getTiposSeleccionarProductoProduMaquina(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduMaquina(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProduMaquina(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMaquina(ProductoProduMaquina productoprodumaquinaAux) throws Exception {
		
			productoprodumaquinaAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumaquinaAux.getProductoDefiProdu()));
			productoprodumaquinaAux.settipoareaempresaprodu_descripcion(TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduDescripcion(productoprodumaquinaAux.getTipoAreaEmpresaProdu()));
			productoprodumaquinaAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoprodumaquinaAux.getTipoProcesoEmpresaProdu()));
			productoprodumaquinaAux.settipomaquinaempresa_descripcion(TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaDescripcion(productoprodumaquinaAux.getTipoMaquinaEmpresa()));
			productoprodumaquinaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumaquinaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduMaquina(List<ProductoProduMaquina> productoprodumaquinasTemp) throws Exception {
		for(ProductoProduMaquina productoprodumaquinaAux:productoprodumaquinasTemp) {
			
			productoprodumaquinaAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodumaquinaAux.getProductoDefiProdu()));
			productoprodumaquinaAux.settipoareaempresaprodu_descripcion(TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduDescripcion(productoprodumaquinaAux.getTipoAreaEmpresaProdu()));
			productoprodumaquinaAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoprodumaquinaAux.getTipoProcesoEmpresaProdu()));
			productoprodumaquinaAux.settipomaquinaempresa_descripcion(TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaDescripcion(productoprodumaquinaAux.getTipoMaquinaEmpresa()));
			productoprodumaquinaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodumaquinaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoDefiProdu.class));
				classes.add(new Classe(TipoAreaEmpresaProdu.class));
				classes.add(new Classe(TipoProcesoEmpresaProdu.class));
				classes.add(new Classe(TipoMaquinaEmpresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoDefiProdu.class)) {
						classes.add(new Classe(ProductoDefiProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
						classes.add(new Classe(TipoAreaEmpresaProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
						classes.add(new Classe(TipoMaquinaEmpresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
					}

					if(TipoAreaEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAreaEmpresaProdu.class)); continue;
					}

					if(TipoProcesoEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class)); continue;
					}

					if(TipoMaquinaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMaquinaEmpresa.class)); continue;
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

					if(TipoAreaEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAreaEmpresaProdu.class)); continue;
					}

					if(TipoProcesoEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoEmpresaProdu.class)); continue;
					}

					if(TipoMaquinaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMaquinaEmpresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduMaquinaConstantesFunciones.getClassesRelationshipsOfProductoProduMaquina(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduMaquinaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProduMaquina(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProduMaquina productoprodumaquina,List<ProductoProduMaquina> productoprodumaquinas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProduMaquina productoprodumaquinaEncontrado=null;
			
			for(ProductoProduMaquina productoprodumaquinaLocal:productoprodumaquinas) {
				if(productoprodumaquinaLocal.getId().equals(productoprodumaquina.getId())) {
					productoprodumaquinaEncontrado=productoprodumaquinaLocal;
					
					productoprodumaquinaLocal.setIsChanged(productoprodumaquina.getIsChanged());
					productoprodumaquinaLocal.setIsNew(productoprodumaquina.getIsNew());
					productoprodumaquinaLocal.setIsDeleted(productoprodumaquina.getIsDeleted());
					
					productoprodumaquinaLocal.setGeneralEntityOriginal(productoprodumaquina.getGeneralEntityOriginal());
					
					productoprodumaquinaLocal.setId(productoprodumaquina.getId());	
					productoprodumaquinaLocal.setVersionRow(productoprodumaquina.getVersionRow());	
					productoprodumaquinaLocal.setid_producto_defi_produ(productoprodumaquina.getid_producto_defi_produ());	
					productoprodumaquinaLocal.setid_tipo_area_empresa_produ(productoprodumaquina.getid_tipo_area_empresa_produ());	
					productoprodumaquinaLocal.setid_tipo_proceso_empresa_produ(productoprodumaquina.getid_tipo_proceso_empresa_produ());	
					productoprodumaquinaLocal.setid_tipo_merma_empresa(productoprodumaquina.getid_tipo_merma_empresa());	
					productoprodumaquinaLocal.setid_unidad(productoprodumaquina.getid_unidad());	
					productoprodumaquinaLocal.setcantidad(productoprodumaquina.getcantidad());	
					productoprodumaquinaLocal.setcosto(productoprodumaquina.getcosto());	
					productoprodumaquinaLocal.setcosto_total(productoprodumaquina.getcosto_total());	
					productoprodumaquinaLocal.setdescripcion(productoprodumaquina.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoprodumaquina.getIsDeleted()) {
				if(!existe) {
					productoprodumaquinas.add(productoprodumaquina);
				}
			} else {
				if(productoprodumaquinaEncontrado!=null && permiteQuitar)  {
					productoprodumaquinas.remove(productoprodumaquinaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProduMaquina productoprodumaquina,List<ProductoProduMaquina> productoprodumaquinas) throws Exception {
		try	{			
			for(ProductoProduMaquina productoprodumaquinaLocal:productoprodumaquinas) {
				if(productoprodumaquinaLocal.getId().equals(productoprodumaquina.getId())) {
					productoprodumaquinaLocal.setIsSelected(productoprodumaquina.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProduMaquina(List<ProductoProduMaquina> productoprodumaquinasAux) throws Exception {
		//this.productoprodumaquinasAux=productoprodumaquinasAux;
		
		for(ProductoProduMaquina productoprodumaquinaAux:productoprodumaquinasAux) {
			if(productoprodumaquinaAux.getIsChanged()) {
				productoprodumaquinaAux.setIsChanged(false);
			}		
			
			if(productoprodumaquinaAux.getIsNew()) {
				productoprodumaquinaAux.setIsNew(false);
			}	
			
			if(productoprodumaquinaAux.getIsDeleted()) {
				productoprodumaquinaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProduMaquina(ProductoProduMaquina productoprodumaquinaAux) throws Exception {
		//this.productoprodumaquinaAux=productoprodumaquinaAux;
		
			if(productoprodumaquinaAux.getIsChanged()) {
				productoprodumaquinaAux.setIsChanged(false);
			}		
			
			if(productoprodumaquinaAux.getIsNew()) {
				productoprodumaquinaAux.setIsNew(false);
			}	
			
			if(productoprodumaquinaAux.getIsDeleted()) {
				productoprodumaquinaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProduMaquina productoprodumaquinaAsignar,ProductoProduMaquina productoprodumaquina) throws Exception {
		productoprodumaquinaAsignar.setId(productoprodumaquina.getId());	
		productoprodumaquinaAsignar.setVersionRow(productoprodumaquina.getVersionRow());	
		productoprodumaquinaAsignar.setid_producto_defi_produ(productoprodumaquina.getid_producto_defi_produ());
		productoprodumaquinaAsignar.setproductodefiprodu_descripcion(productoprodumaquina.getproductodefiprodu_descripcion());	
		productoprodumaquinaAsignar.setid_tipo_area_empresa_produ(productoprodumaquina.getid_tipo_area_empresa_produ());
		productoprodumaquinaAsignar.settipoareaempresaprodu_descripcion(productoprodumaquina.gettipoareaempresaprodu_descripcion());	
		productoprodumaquinaAsignar.setid_tipo_proceso_empresa_produ(productoprodumaquina.getid_tipo_proceso_empresa_produ());
		productoprodumaquinaAsignar.settipoprocesoempresaprodu_descripcion(productoprodumaquina.gettipoprocesoempresaprodu_descripcion());	
		productoprodumaquinaAsignar.setid_tipo_merma_empresa(productoprodumaquina.getid_tipo_merma_empresa());
		productoprodumaquinaAsignar.settipomaquinaempresa_descripcion(productoprodumaquina.gettipomaquinaempresa_descripcion());	
		productoprodumaquinaAsignar.setid_unidad(productoprodumaquina.getid_unidad());
		productoprodumaquinaAsignar.setunidad_descripcion(productoprodumaquina.getunidad_descripcion());	
		productoprodumaquinaAsignar.setcantidad(productoprodumaquina.getcantidad());	
		productoprodumaquinaAsignar.setcosto(productoprodumaquina.getcosto());	
		productoprodumaquinaAsignar.setcosto_total(productoprodumaquina.getcosto_total());	
		productoprodumaquinaAsignar.setdescripcion(productoprodumaquina.getdescripcion());	
	}
	
	public static void inicializarProductoProduMaquina(ProductoProduMaquina productoprodumaquina) throws Exception {
		try {
				productoprodumaquina.setId(0L);	
					
				productoprodumaquina.setid_producto_defi_produ(-1L);	
				productoprodumaquina.setid_tipo_area_empresa_produ(-1L);	
				productoprodumaquina.setid_tipo_proceso_empresa_produ(-1L);	
				productoprodumaquina.setid_tipo_merma_empresa(-1L);	
				productoprodumaquina.setid_unidad(-1L);	
				productoprodumaquina.setcantidad(0);	
				productoprodumaquina.setcosto(0.0);	
				productoprodumaquina.setcosto_total(0.0);	
				productoprodumaquina.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProduMaquina(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProduMaquina(String sTipo,Row row,Workbook workbook,ProductoProduMaquina productoprodumaquina,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getproductodefiprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.gettipoareaempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.gettipoprocesoempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.gettipomaquinaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodumaquina.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProduMaquina=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProduMaquina() {
		return this.sFinalQueryProductoProduMaquina;
	}
	
	public void setsFinalQueryProductoProduMaquina(String sFinalQueryProductoProduMaquina) {
		this.sFinalQueryProductoProduMaquina= sFinalQueryProductoProduMaquina;
	}
	
	public Border resaltarSeleccionarProductoProduMaquina=null;
	
	public Border setResaltarSeleccionarProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProduMaquina= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProduMaquina() {
		return this.resaltarSeleccionarProductoProduMaquina;
	}
	
	public void setResaltarSeleccionarProductoProduMaquina(Border borderResaltarSeleccionarProductoProduMaquina) {
		this.resaltarSeleccionarProductoProduMaquina= borderResaltarSeleccionarProductoProduMaquina;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProduMaquina=null;
	public Boolean mostraridProductoProduMaquina=true;
	public Boolean activaridProductoProduMaquina=true;

	public Border resaltarid_producto_defi_produProductoProduMaquina=null;
	public Boolean mostrarid_producto_defi_produProductoProduMaquina=true;
	public Boolean activarid_producto_defi_produProductoProduMaquina=true;
	public Boolean cargarid_producto_defi_produProductoProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_defi_produProductoProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_area_empresa_produProductoProduMaquina=null;
	public Boolean mostrarid_tipo_area_empresa_produProductoProduMaquina=true;
	public Boolean activarid_tipo_area_empresa_produProductoProduMaquina=true;
	public Boolean cargarid_tipo_area_empresa_produProductoProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_area_empresa_produProductoProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_empresa_produProductoProduMaquina=null;
	public Boolean mostrarid_tipo_proceso_empresa_produProductoProduMaquina=true;
	public Boolean activarid_tipo_proceso_empresa_produProductoProduMaquina=true;
	public Boolean cargarid_tipo_proceso_empresa_produProductoProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_empresa_produProductoProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_merma_empresaProductoProduMaquina=null;
	public Boolean mostrarid_tipo_merma_empresaProductoProduMaquina=true;
	public Boolean activarid_tipo_merma_empresaProductoProduMaquina=true;
	public Boolean cargarid_tipo_merma_empresaProductoProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_merma_empresaProductoProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoProduMaquina=null;
	public Boolean mostrarid_unidadProductoProduMaquina=true;
	public Boolean activarid_unidadProductoProduMaquina=true;
	public Boolean cargarid_unidadProductoProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoProduMaquina=false;//ConEventDepend=true

	public Border resaltarcantidadProductoProduMaquina=null;
	public Boolean mostrarcantidadProductoProduMaquina=true;
	public Boolean activarcantidadProductoProduMaquina=true;

	public Border resaltarcostoProductoProduMaquina=null;
	public Boolean mostrarcostoProductoProduMaquina=true;
	public Boolean activarcostoProductoProduMaquina=true;

	public Border resaltarcosto_totalProductoProduMaquina=null;
	public Boolean mostrarcosto_totalProductoProduMaquina=true;
	public Boolean activarcosto_totalProductoProduMaquina=true;

	public Border resaltardescripcionProductoProduMaquina=null;
	public Boolean mostrardescripcionProductoProduMaquina=true;
	public Boolean activardescripcionProductoProduMaquina=true;

	
	

	public Border setResaltaridProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltaridProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProduMaquina() {
		return this.resaltaridProductoProduMaquina;
	}

	public void setResaltaridProductoProduMaquina(Border borderResaltar) {
		this.resaltaridProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostraridProductoProduMaquina() {
		return this.mostraridProductoProduMaquina;
	}

	public void setMostraridProductoProduMaquina(Boolean mostraridProductoProduMaquina) {
		this.mostraridProductoProduMaquina= mostraridProductoProduMaquina;
	}

	public Boolean getActivaridProductoProduMaquina() {
		return this.activaridProductoProduMaquina;
	}

	public void setActivaridProductoProduMaquina(Boolean activaridProductoProduMaquina) {
		this.activaridProductoProduMaquina= activaridProductoProduMaquina;
	}

	public Border setResaltarid_producto_defi_produProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_producto_defi_produProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_defi_produProductoProduMaquina() {
		return this.resaltarid_producto_defi_produProductoProduMaquina;
	}

	public void setResaltarid_producto_defi_produProductoProduMaquina(Border borderResaltar) {
		this.resaltarid_producto_defi_produProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_producto_defi_produProductoProduMaquina() {
		return this.mostrarid_producto_defi_produProductoProduMaquina;
	}

	public void setMostrarid_producto_defi_produProductoProduMaquina(Boolean mostrarid_producto_defi_produProductoProduMaquina) {
		this.mostrarid_producto_defi_produProductoProduMaquina= mostrarid_producto_defi_produProductoProduMaquina;
	}

	public Boolean getActivarid_producto_defi_produProductoProduMaquina() {
		return this.activarid_producto_defi_produProductoProduMaquina;
	}

	public void setActivarid_producto_defi_produProductoProduMaquina(Boolean activarid_producto_defi_produProductoProduMaquina) {
		this.activarid_producto_defi_produProductoProduMaquina= activarid_producto_defi_produProductoProduMaquina;
	}

	public Boolean getCargarid_producto_defi_produProductoProduMaquina() {
		return this.cargarid_producto_defi_produProductoProduMaquina;
	}

	public void setCargarid_producto_defi_produProductoProduMaquina(Boolean cargarid_producto_defi_produProductoProduMaquina) {
		this.cargarid_producto_defi_produProductoProduMaquina= cargarid_producto_defi_produProductoProduMaquina;
	}

	public Border setResaltarid_tipo_area_empresa_produProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_area_empresa_produProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_area_empresa_produProductoProduMaquina() {
		return this.resaltarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public void setResaltarid_tipo_area_empresa_produProductoProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_area_empresa_produProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_area_empresa_produProductoProduMaquina() {
		return this.mostrarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public void setMostrarid_tipo_area_empresa_produProductoProduMaquina(Boolean mostrarid_tipo_area_empresa_produProductoProduMaquina) {
		this.mostrarid_tipo_area_empresa_produProductoProduMaquina= mostrarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public Boolean getActivarid_tipo_area_empresa_produProductoProduMaquina() {
		return this.activarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public void setActivarid_tipo_area_empresa_produProductoProduMaquina(Boolean activarid_tipo_area_empresa_produProductoProduMaquina) {
		this.activarid_tipo_area_empresa_produProductoProduMaquina= activarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public Boolean getCargarid_tipo_area_empresa_produProductoProduMaquina() {
		return this.cargarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public void setCargarid_tipo_area_empresa_produProductoProduMaquina(Boolean cargarid_tipo_area_empresa_produProductoProduMaquina) {
		this.cargarid_tipo_area_empresa_produProductoProduMaquina= cargarid_tipo_area_empresa_produProductoProduMaquina;
	}

	public Border setResaltarid_tipo_proceso_empresa_produProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_empresa_produProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_empresa_produProductoProduMaquina() {
		return this.resaltarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public void setResaltarid_tipo_proceso_empresa_produProductoProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_proceso_empresa_produProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_empresa_produProductoProduMaquina() {
		return this.mostrarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public void setMostrarid_tipo_proceso_empresa_produProductoProduMaquina(Boolean mostrarid_tipo_proceso_empresa_produProductoProduMaquina) {
		this.mostrarid_tipo_proceso_empresa_produProductoProduMaquina= mostrarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public Boolean getActivarid_tipo_proceso_empresa_produProductoProduMaquina() {
		return this.activarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public void setActivarid_tipo_proceso_empresa_produProductoProduMaquina(Boolean activarid_tipo_proceso_empresa_produProductoProduMaquina) {
		this.activarid_tipo_proceso_empresa_produProductoProduMaquina= activarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public Boolean getCargarid_tipo_proceso_empresa_produProductoProduMaquina() {
		return this.cargarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public void setCargarid_tipo_proceso_empresa_produProductoProduMaquina(Boolean cargarid_tipo_proceso_empresa_produProductoProduMaquina) {
		this.cargarid_tipo_proceso_empresa_produProductoProduMaquina= cargarid_tipo_proceso_empresa_produProductoProduMaquina;
	}

	public Border setResaltarid_tipo_merma_empresaProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_merma_empresaProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_merma_empresaProductoProduMaquina() {
		return this.resaltarid_tipo_merma_empresaProductoProduMaquina;
	}

	public void setResaltarid_tipo_merma_empresaProductoProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_merma_empresaProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_merma_empresaProductoProduMaquina() {
		return this.mostrarid_tipo_merma_empresaProductoProduMaquina;
	}

	public void setMostrarid_tipo_merma_empresaProductoProduMaquina(Boolean mostrarid_tipo_merma_empresaProductoProduMaquina) {
		this.mostrarid_tipo_merma_empresaProductoProduMaquina= mostrarid_tipo_merma_empresaProductoProduMaquina;
	}

	public Boolean getActivarid_tipo_merma_empresaProductoProduMaquina() {
		return this.activarid_tipo_merma_empresaProductoProduMaquina;
	}

	public void setActivarid_tipo_merma_empresaProductoProduMaquina(Boolean activarid_tipo_merma_empresaProductoProduMaquina) {
		this.activarid_tipo_merma_empresaProductoProduMaquina= activarid_tipo_merma_empresaProductoProduMaquina;
	}

	public Boolean getCargarid_tipo_merma_empresaProductoProduMaquina() {
		return this.cargarid_tipo_merma_empresaProductoProduMaquina;
	}

	public void setCargarid_tipo_merma_empresaProductoProduMaquina(Boolean cargarid_tipo_merma_empresaProductoProduMaquina) {
		this.cargarid_tipo_merma_empresaProductoProduMaquina= cargarid_tipo_merma_empresaProductoProduMaquina;
	}

	public Border setResaltarid_unidadProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoProduMaquina() {
		return this.resaltarid_unidadProductoProduMaquina;
	}

	public void setResaltarid_unidadProductoProduMaquina(Border borderResaltar) {
		this.resaltarid_unidadProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoProduMaquina() {
		return this.mostrarid_unidadProductoProduMaquina;
	}

	public void setMostrarid_unidadProductoProduMaquina(Boolean mostrarid_unidadProductoProduMaquina) {
		this.mostrarid_unidadProductoProduMaquina= mostrarid_unidadProductoProduMaquina;
	}

	public Boolean getActivarid_unidadProductoProduMaquina() {
		return this.activarid_unidadProductoProduMaquina;
	}

	public void setActivarid_unidadProductoProduMaquina(Boolean activarid_unidadProductoProduMaquina) {
		this.activarid_unidadProductoProduMaquina= activarid_unidadProductoProduMaquina;
	}

	public Boolean getCargarid_unidadProductoProduMaquina() {
		return this.cargarid_unidadProductoProduMaquina;
	}

	public void setCargarid_unidadProductoProduMaquina(Boolean cargarid_unidadProductoProduMaquina) {
		this.cargarid_unidadProductoProduMaquina= cargarid_unidadProductoProduMaquina;
	}

	public Border setResaltarcantidadProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoProduMaquina() {
		return this.resaltarcantidadProductoProduMaquina;
	}

	public void setResaltarcantidadProductoProduMaquina(Border borderResaltar) {
		this.resaltarcantidadProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoProduMaquina() {
		return this.mostrarcantidadProductoProduMaquina;
	}

	public void setMostrarcantidadProductoProduMaquina(Boolean mostrarcantidadProductoProduMaquina) {
		this.mostrarcantidadProductoProduMaquina= mostrarcantidadProductoProduMaquina;
	}

	public Boolean getActivarcantidadProductoProduMaquina() {
		return this.activarcantidadProductoProduMaquina;
	}

	public void setActivarcantidadProductoProduMaquina(Boolean activarcantidadProductoProduMaquina) {
		this.activarcantidadProductoProduMaquina= activarcantidadProductoProduMaquina;
	}

	public Border setResaltarcostoProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcostoProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoProduMaquina() {
		return this.resaltarcostoProductoProduMaquina;
	}

	public void setResaltarcostoProductoProduMaquina(Border borderResaltar) {
		this.resaltarcostoProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcostoProductoProduMaquina() {
		return this.mostrarcostoProductoProduMaquina;
	}

	public void setMostrarcostoProductoProduMaquina(Boolean mostrarcostoProductoProduMaquina) {
		this.mostrarcostoProductoProduMaquina= mostrarcostoProductoProduMaquina;
	}

	public Boolean getActivarcostoProductoProduMaquina() {
		return this.activarcostoProductoProduMaquina;
	}

	public void setActivarcostoProductoProduMaquina(Boolean activarcostoProductoProduMaquina) {
		this.activarcostoProductoProduMaquina= activarcostoProductoProduMaquina;
	}

	public Border setResaltarcosto_totalProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoProduMaquina() {
		return this.resaltarcosto_totalProductoProduMaquina;
	}

	public void setResaltarcosto_totalProductoProduMaquina(Border borderResaltar) {
		this.resaltarcosto_totalProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoProduMaquina() {
		return this.mostrarcosto_totalProductoProduMaquina;
	}

	public void setMostrarcosto_totalProductoProduMaquina(Boolean mostrarcosto_totalProductoProduMaquina) {
		this.mostrarcosto_totalProductoProduMaquina= mostrarcosto_totalProductoProduMaquina;
	}

	public Boolean getActivarcosto_totalProductoProduMaquina() {
		return this.activarcosto_totalProductoProduMaquina;
	}

	public void setActivarcosto_totalProductoProduMaquina(Boolean activarcosto_totalProductoProduMaquina) {
		this.activarcosto_totalProductoProduMaquina= activarcosto_totalProductoProduMaquina;
	}

	public Border setResaltardescripcionProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoProduMaquina.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoProduMaquina() {
		return this.resaltardescripcionProductoProduMaquina;
	}

	public void setResaltardescripcionProductoProduMaquina(Border borderResaltar) {
		this.resaltardescripcionProductoProduMaquina= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoProduMaquina() {
		return this.mostrardescripcionProductoProduMaquina;
	}

	public void setMostrardescripcionProductoProduMaquina(Boolean mostrardescripcionProductoProduMaquina) {
		this.mostrardescripcionProductoProduMaquina= mostrardescripcionProductoProduMaquina;
	}

	public Boolean getActivardescripcionProductoProduMaquina() {
		return this.activardescripcionProductoProduMaquina;
	}

	public void setActivardescripcionProductoProduMaquina(Boolean activardescripcionProductoProduMaquina) {
		this.activardescripcionProductoProduMaquina= activardescripcionProductoProduMaquina;
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
		
		
		this.setMostraridProductoProduMaquina(esInicial);
		this.setMostrarid_producto_defi_produProductoProduMaquina(esInicial);
		this.setMostrarid_tipo_area_empresa_produProductoProduMaquina(esInicial);
		this.setMostrarid_tipo_proceso_empresa_produProductoProduMaquina(esInicial);
		this.setMostrarid_tipo_merma_empresaProductoProduMaquina(esInicial);
		this.setMostrarid_unidadProductoProduMaquina(esInicial);
		this.setMostrarcantidadProductoProduMaquina(esInicial);
		this.setMostrarcostoProductoProduMaquina(esInicial);
		this.setMostrarcosto_totalProductoProduMaquina(esInicial);
		this.setMostrardescripcionProductoProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.ID)) {
				this.setMostraridProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setMostrarid_producto_defi_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setMostrarid_tipo_area_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setMostrarid_tipo_proceso_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setMostrarid_tipo_merma_empresaProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoProduMaquina(esAsigna);
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
		
		
		this.setActivaridProductoProduMaquina(esInicial);
		this.setActivarid_producto_defi_produProductoProduMaquina(esInicial);
		this.setActivarid_tipo_area_empresa_produProductoProduMaquina(esInicial);
		this.setActivarid_tipo_proceso_empresa_produProductoProduMaquina(esInicial);
		this.setActivarid_tipo_merma_empresaProductoProduMaquina(esInicial);
		this.setActivarid_unidadProductoProduMaquina(esInicial);
		this.setActivarcantidadProductoProduMaquina(esInicial);
		this.setActivarcostoProductoProduMaquina(esInicial);
		this.setActivarcosto_totalProductoProduMaquina(esInicial);
		this.setActivardescripcionProductoProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.ID)) {
				this.setActivaridProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setActivarid_producto_defi_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setActivarid_tipo_area_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setActivarid_tipo_proceso_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setActivarid_tipo_merma_empresaProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoProduMaquina(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProduMaquina(esInicial);
		this.setResaltarid_producto_defi_produProductoProduMaquina(esInicial);
		this.setResaltarid_tipo_area_empresa_produProductoProduMaquina(esInicial);
		this.setResaltarid_tipo_proceso_empresa_produProductoProduMaquina(esInicial);
		this.setResaltarid_tipo_merma_empresaProductoProduMaquina(esInicial);
		this.setResaltarid_unidadProductoProduMaquina(esInicial);
		this.setResaltarcantidadProductoProduMaquina(esInicial);
		this.setResaltarcostoProductoProduMaquina(esInicial);
		this.setResaltarcosto_totalProductoProduMaquina(esInicial);
		this.setResaltardescripcionProductoProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.ID)) {
				this.setResaltaridProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setResaltarid_producto_defi_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setResaltarid_tipo_area_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setResaltarid_tipo_proceso_empresa_produProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setResaltarid_tipo_merma_empresaProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoProduMaquina(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdProductoDefiProduProductoProduMaquina=true;

	public Boolean getMostrarFK_IdProductoDefiProduProductoProduMaquina() {
		return this.mostrarFK_IdProductoDefiProduProductoProduMaquina;
	}

	public void setMostrarFK_IdProductoDefiProduProductoProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDefiProduProductoProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoAreaEmpresaProduProductoProduMaquina=true;

	public Boolean getMostrarFK_IdTipoAreaEmpresaProduProductoProduMaquina() {
		return this.mostrarFK_IdTipoAreaEmpresaProduProductoProduMaquina;
	}

	public void setMostrarFK_IdTipoAreaEmpresaProduProductoProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoAreaEmpresaProduProductoProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMaquinaEmpresaProductoProduMaquina=true;

	public Boolean getMostrarFK_IdTipoMaquinaEmpresaProductoProduMaquina() {
		return this.mostrarFK_IdTipoMaquinaEmpresaProductoProduMaquina;
	}

	public void setMostrarFK_IdTipoMaquinaEmpresaProductoProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMaquinaEmpresaProductoProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoEmpresaProduProductoProduMaquina=true;

	public Boolean getMostrarFK_IdTipoProcesoEmpresaProduProductoProduMaquina() {
		return this.mostrarFK_IdTipoProcesoEmpresaProduProductoProduMaquina;
	}

	public void setMostrarFK_IdTipoProcesoEmpresaProduProductoProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoEmpresaProduProductoProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoProduMaquina=true;

	public Boolean getMostrarFK_IdUnidadProductoProduMaquina() {
		return this.mostrarFK_IdUnidadProductoProduMaquina;
	}

	public void setMostrarFK_IdUnidadProductoProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoProduMaquina= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdProductoDefiProduProductoProduMaquina=true;

	public Boolean getActivarFK_IdProductoDefiProduProductoProduMaquina() {
		return this.activarFK_IdProductoDefiProduProductoProduMaquina;
	}

	public void setActivarFK_IdProductoDefiProduProductoProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDefiProduProductoProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoAreaEmpresaProduProductoProduMaquina=true;

	public Boolean getActivarFK_IdTipoAreaEmpresaProduProductoProduMaquina() {
		return this.activarFK_IdTipoAreaEmpresaProduProductoProduMaquina;
	}

	public void setActivarFK_IdTipoAreaEmpresaProduProductoProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoAreaEmpresaProduProductoProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMaquinaEmpresaProductoProduMaquina=true;

	public Boolean getActivarFK_IdTipoMaquinaEmpresaProductoProduMaquina() {
		return this.activarFK_IdTipoMaquinaEmpresaProductoProduMaquina;
	}

	public void setActivarFK_IdTipoMaquinaEmpresaProductoProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMaquinaEmpresaProductoProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoEmpresaProduProductoProduMaquina=true;

	public Boolean getActivarFK_IdTipoProcesoEmpresaProduProductoProduMaquina() {
		return this.activarFK_IdTipoProcesoEmpresaProduProductoProduMaquina;
	}

	public void setActivarFK_IdTipoProcesoEmpresaProduProductoProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoEmpresaProduProductoProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoProduMaquina=true;

	public Boolean getActivarFK_IdUnidadProductoProduMaquina() {
		return this.activarFK_IdUnidadProductoProduMaquina;
	}

	public void setActivarFK_IdUnidadProductoProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoProduMaquina= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdProductoDefiProduProductoProduMaquina=null;

	public Border getResaltarFK_IdProductoDefiProduProductoProduMaquina() {
		return this.resaltarFK_IdProductoDefiProduProductoProduMaquina;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdProductoDefiProduProductoProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDefiProduProductoProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina=null;

	public Border getResaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina() {
		return this.resaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina;
	}

	public void setResaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoAreaEmpresaProduProductoProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina=null;

	public Border getResaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina() {
		return this.resaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina;
	}

	public void setResaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMaquinaEmpresaProductoProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina=null;

	public Border getResaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina() {
		return this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoProduMaquina=null;

	public Border getResaltarFK_IdUnidadProductoProduMaquina() {
		return this.resaltarFK_IdUnidadProductoProduMaquina;
	}

	public void setResaltarFK_IdUnidadProductoProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduMaquinaBeanSwingJInternalFrame productoprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoProduMaquina= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}