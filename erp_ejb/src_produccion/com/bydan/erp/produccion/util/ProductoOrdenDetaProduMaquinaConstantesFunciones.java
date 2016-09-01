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


import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaParameterGeneral;

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
final public class ProductoOrdenDetaProduMaquinaConstantesFunciones extends ProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoOrdenDetaProduMaquina";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoOrdenDetaProduMaquina"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoOrdenDetaProduMaquinaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoOrdenDetaProduMaquinaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduMaquinaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduMaquinaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoOrdenDetaProduMaquinaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduMaquinaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoOrdenDetaProduMaquinaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduMaquinaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden Maquinaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden Maquina";
	public static final String SCLASSWEBTITULO_LOWER="Producto Orden Deta Produ Maquina";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoOrdenDetaProduMaquina";
	public static final String OBJECTNAME="productoordendetaprodumaquina";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_orden_deta_produ_maquina";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoordendetaprodumaquina from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumaquina";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_area_empresa_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional productoordendetaprodumaquinaConstantesFuncionesAdditional=null;
	
	public ProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional getProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional() {
		return this.productoordendetaprodumaquinaConstantesFuncionesAdditional;
	}
	
	public void setProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional(ProductoOrdenDetaProduMaquinaConstantesFuncionesAdditional productoordendetaprodumaquinaConstantesFuncionesAdditional) {
		try {
			this.productoordendetaprodumaquinaConstantesFuncionesAdditional=productoordendetaprodumaquinaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENDETAPRODU= "id_orden_deta_produ";
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
    	public static final String LABEL_IDORDENDETAPRODU= "Orden Deta Produ";
		public static final String LABEL_IDORDENDETAPRODU_LOWER= "Orden Deta Produ";
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
	
	public static String getProductoOrdenDetaProduMaquinaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDORDENDETAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoOrdenDetaProduMaquinaDescripcion(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoordendetaprodumaquina !=null/* && productoordendetaprodumaquina.getId()!=0*/) {
			if(productoordendetaprodumaquina.getId()!=null) {
				sDescripcion=productoordendetaprodumaquina.getId().toString();
			}//productoordendetaprodumaquinaproductoordendetaprodumaquina.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoOrdenDetaProduMaquinaDescripcionDetallado(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) {
		String sDescripcion="";
			
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.ID+"=";
		sDescripcion+=productoordendetaprodumaquina.getId().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoordendetaprodumaquina.getVersionRow().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU+"=";
		sDescripcion+=productoordendetaprodumaquina.getid_orden_deta_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU+"=";
		sDescripcion+=productoordendetaprodumaquina.getid_tipo_area_empresa_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU+"=";
		sDescripcion+=productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA+"=";
		sDescripcion+=productoordendetaprodumaquina.getid_tipo_merma_empresa().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoordendetaprodumaquina.getid_unidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoordendetaprodumaquina.getcantidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO+"=";
		sDescripcion+=productoordendetaprodumaquina.getcosto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoordendetaprodumaquina.getcosto_total().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoordendetaprodumaquina.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoOrdenDetaProduMaquinaDescripcion(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,String sValor) throws Exception {			
		if(productoordendetaprodumaquina !=null) {
			//productoordendetaprodumaquinaproductoordendetaprodumaquina.getId().toString();
		}		
	}
	
		

	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordendetaprodu!=null/*&&ordendetaprodu.getId()>0*/) {
			sDescripcion=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(ordendetaprodu);
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
		} else if(sNombreIndice.equals("FK_IdOrdenDetaProdu")) {
			sNombreIndice="Tipo=  Por Orden Deta Produ";
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

	public static String getDetalleIndiceFK_IdOrdenDetaProdu(Long id_orden_deta_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_deta_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Deta Produ="+id_orden_deta_produ.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodumaquina.setdescripcion(productoordendetaprodumaquina.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {
			productoordendetaprodumaquina.setdescripcion(productoordendetaprodumaquina.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoordendetaprodumaquina.getConCambioAuxiliar()) {
			productoordendetaprodumaquina.setIsDeleted(productoordendetaprodumaquina.getIsDeletedAuxiliar());	
			productoordendetaprodumaquina.setIsNew(productoordendetaprodumaquina.getIsNewAuxiliar());	
			productoordendetaprodumaquina.setIsChanged(productoordendetaprodumaquina.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoordendetaprodumaquina.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoordendetaprodumaquina.setIsDeletedAuxiliar(false);	
			productoordendetaprodumaquina.setIsNewAuxiliar(false);	
			productoordendetaprodumaquina.setIsChangedAuxiliar(false);
			
			productoordendetaprodumaquina.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina : productoordendetaprodumaquinas) {
			if(conAsignarBase && productoordendetaprodumaquina.getConCambioAuxiliar()) {
				productoordendetaprodumaquina.setIsDeleted(productoordendetaprodumaquina.getIsDeletedAuxiliar());	
				productoordendetaprodumaquina.setIsNew(productoordendetaprodumaquina.getIsNewAuxiliar());	
				productoordendetaprodumaquina.setIsChanged(productoordendetaprodumaquina.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoordendetaprodumaquina.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoordendetaprodumaquina.setIsDeletedAuxiliar(false);	
				productoordendetaprodumaquina.setIsNewAuxiliar(false);	
				productoordendetaprodumaquina.setIsChangedAuxiliar(false);
				
				productoordendetaprodumaquina.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean conEnteros) throws Exception  {
		productoordendetaprodumaquina.setcosto(0.0);
		productoordendetaprodumaquina.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoordendetaprodumaquina.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,Boolean conEnteros) throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {
			productoordendetaprodumaquina.setcosto(0.0);
			productoordendetaprodumaquina.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoordendetaprodumaquina.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux) throws Exception  {
		ProductoOrdenDetaProduMaquinaConstantesFunciones.InicializarValoresProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaAux,true);
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {
			if(productoordendetaprodumaquina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoordendetaprodumaquinaAux.setcantidad(productoordendetaprodumaquinaAux.getcantidad()+productoordendetaprodumaquina.getcantidad());			
			productoordendetaprodumaquinaAux.setcosto(productoordendetaprodumaquinaAux.getcosto()+productoordendetaprodumaquina.getcosto());			
			productoordendetaprodumaquinaAux.setcosto_total(productoordendetaprodumaquinaAux.getcosto_total()+productoordendetaprodumaquina.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoOrdenDetaProduMaquinaConstantesFunciones.getArrayColumnasGlobalesProductoOrdenDetaProduMaquina(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoOrdenDetaProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux: productoordendetaprodumaquinas) {
			if(productoordendetaprodumaquinaAux!=null && productoordendetaprodumaquina!=null) {
				if((productoordendetaprodumaquinaAux.getId()==null && productoordendetaprodumaquina.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoordendetaprodumaquinaAux.getId()!=null && productoordendetaprodumaquina.getId()!=null){
					if(productoordendetaprodumaquinaAux.getId().equals(productoordendetaprodumaquina.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {			
			if(productoordendetaprodumaquina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoordendetaprodumaquina.getcosto();
			costo_totalTotal+=productoordendetaprodumaquina.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoOrdenDetaProduMaquina() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_ID, ProductoOrdenDetaProduMaquinaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_VERSIONROW, ProductoOrdenDetaProduMaquinaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDORDENDETAPRODU, ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU, ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU, ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA, ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDUNIDAD, ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_CANTIDAD, ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO, ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL, ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_DESCRIPCION, ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoOrdenDetaProduMaquina() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMaquina() throws Exception  {
		return ProductoOrdenDetaProduMaquinaConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMaquina(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMaquina(Boolean conFk) throws Exception  {
		return ProductoOrdenDetaProduMaquinaConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduMaquina(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduMaquina(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDORDENDETAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDORDENDETAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoOrdenDetaProduMaquina(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux) throws Exception {
		
			productoordendetaprodumaquinaAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumaquinaAux.getOrdenDetaProdu()));
			productoordendetaprodumaquinaAux.settipoareaempresaprodu_descripcion(TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduDescripcion(productoordendetaprodumaquinaAux.getTipoAreaEmpresaProdu()));
			productoordendetaprodumaquinaAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoordendetaprodumaquinaAux.getTipoProcesoEmpresaProdu()));
			productoordendetaprodumaquinaAux.settipomaquinaempresa_descripcion(TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaDescripcion(productoordendetaprodumaquinaAux.getTipoMaquinaEmpresa()));
			productoordendetaprodumaquinaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumaquinaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinasTemp) throws Exception {
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux:productoordendetaprodumaquinasTemp) {
			
			productoordendetaprodumaquinaAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodumaquinaAux.getOrdenDetaProdu()));
			productoordendetaprodumaquinaAux.settipoareaempresaprodu_descripcion(TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduDescripcion(productoordendetaprodumaquinaAux.getTipoAreaEmpresaProdu()));
			productoordendetaprodumaquinaAux.settipoprocesoempresaprodu_descripcion(TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduDescripcion(productoordendetaprodumaquinaAux.getTipoProcesoEmpresaProdu()));
			productoordendetaprodumaquinaAux.settipomaquinaempresa_descripcion(TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaDescripcion(productoordendetaprodumaquinaAux.getTipoMaquinaEmpresa()));
			productoordendetaprodumaquinaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodumaquinaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(TipoAreaEmpresaProdu.class));
				classes.add(new Classe(TipoProcesoEmpresaProdu.class));
				classes.add(new Classe(TipoMaquinaEmpresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoOrdenDetaProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMaquina(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMaquina(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduMaquina(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaEncontrado=null;
			
			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal:productoordendetaprodumaquinas) {
				if(productoordendetaprodumaquinaLocal.getId().equals(productoordendetaprodumaquina.getId())) {
					productoordendetaprodumaquinaEncontrado=productoordendetaprodumaquinaLocal;
					
					productoordendetaprodumaquinaLocal.setIsChanged(productoordendetaprodumaquina.getIsChanged());
					productoordendetaprodumaquinaLocal.setIsNew(productoordendetaprodumaquina.getIsNew());
					productoordendetaprodumaquinaLocal.setIsDeleted(productoordendetaprodumaquina.getIsDeleted());
					
					productoordendetaprodumaquinaLocal.setGeneralEntityOriginal(productoordendetaprodumaquina.getGeneralEntityOriginal());
					
					productoordendetaprodumaquinaLocal.setId(productoordendetaprodumaquina.getId());	
					productoordendetaprodumaquinaLocal.setVersionRow(productoordendetaprodumaquina.getVersionRow());	
					productoordendetaprodumaquinaLocal.setid_orden_deta_produ(productoordendetaprodumaquina.getid_orden_deta_produ());	
					productoordendetaprodumaquinaLocal.setid_tipo_area_empresa_produ(productoordendetaprodumaquina.getid_tipo_area_empresa_produ());	
					productoordendetaprodumaquinaLocal.setid_tipo_proceso_empresa_produ(productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ());	
					productoordendetaprodumaquinaLocal.setid_tipo_merma_empresa(productoordendetaprodumaquina.getid_tipo_merma_empresa());	
					productoordendetaprodumaquinaLocal.setid_unidad(productoordendetaprodumaquina.getid_unidad());	
					productoordendetaprodumaquinaLocal.setcantidad(productoordendetaprodumaquina.getcantidad());	
					productoordendetaprodumaquinaLocal.setcosto(productoordendetaprodumaquina.getcosto());	
					productoordendetaprodumaquinaLocal.setcosto_total(productoordendetaprodumaquina.getcosto_total());	
					productoordendetaprodumaquinaLocal.setdescripcion(productoordendetaprodumaquina.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoordendetaprodumaquina.getIsDeleted()) {
				if(!existe) {
					productoordendetaprodumaquinas.add(productoordendetaprodumaquina);
				}
			} else {
				if(productoordendetaprodumaquinaEncontrado!=null && permiteQuitar)  {
					productoordendetaprodumaquinas.remove(productoordendetaprodumaquinaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas) throws Exception {
		try	{			
			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal:productoordendetaprodumaquinas) {
				if(productoordendetaprodumaquinaLocal.getId().equals(productoordendetaprodumaquina.getId())) {
					productoordendetaprodumaquinaLocal.setIsSelected(productoordendetaprodumaquina.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinasAux) throws Exception {
		//this.productoordendetaprodumaquinasAux=productoordendetaprodumaquinasAux;
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux:productoordendetaprodumaquinasAux) {
			if(productoordendetaprodumaquinaAux.getIsChanged()) {
				productoordendetaprodumaquinaAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumaquinaAux.getIsNew()) {
				productoordendetaprodumaquinaAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumaquinaAux.getIsDeleted()) {
				productoordendetaprodumaquinaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux) throws Exception {
		//this.productoordendetaprodumaquinaAux=productoordendetaprodumaquinaAux;
		
			if(productoordendetaprodumaquinaAux.getIsChanged()) {
				productoordendetaprodumaquinaAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodumaquinaAux.getIsNew()) {
				productoordendetaprodumaquinaAux.setIsNew(false);
			}	
			
			if(productoordendetaprodumaquinaAux.getIsDeleted()) {
				productoordendetaprodumaquinaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAsignar,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {
		productoordendetaprodumaquinaAsignar.setId(productoordendetaprodumaquina.getId());	
		productoordendetaprodumaquinaAsignar.setVersionRow(productoordendetaprodumaquina.getVersionRow());	
		productoordendetaprodumaquinaAsignar.setid_orden_deta_produ(productoordendetaprodumaquina.getid_orden_deta_produ());
		productoordendetaprodumaquinaAsignar.setordendetaprodu_descripcion(productoordendetaprodumaquina.getordendetaprodu_descripcion());	
		productoordendetaprodumaquinaAsignar.setid_tipo_area_empresa_produ(productoordendetaprodumaquina.getid_tipo_area_empresa_produ());
		productoordendetaprodumaquinaAsignar.settipoareaempresaprodu_descripcion(productoordendetaprodumaquina.gettipoareaempresaprodu_descripcion());	
		productoordendetaprodumaquinaAsignar.setid_tipo_proceso_empresa_produ(productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ());
		productoordendetaprodumaquinaAsignar.settipoprocesoempresaprodu_descripcion(productoordendetaprodumaquina.gettipoprocesoempresaprodu_descripcion());	
		productoordendetaprodumaquinaAsignar.setid_tipo_merma_empresa(productoordendetaprodumaquina.getid_tipo_merma_empresa());
		productoordendetaprodumaquinaAsignar.settipomaquinaempresa_descripcion(productoordendetaprodumaquina.gettipomaquinaempresa_descripcion());	
		productoordendetaprodumaquinaAsignar.setid_unidad(productoordendetaprodumaquina.getid_unidad());
		productoordendetaprodumaquinaAsignar.setunidad_descripcion(productoordendetaprodumaquina.getunidad_descripcion());	
		productoordendetaprodumaquinaAsignar.setcantidad(productoordendetaprodumaquina.getcantidad());	
		productoordendetaprodumaquinaAsignar.setcosto(productoordendetaprodumaquina.getcosto());	
		productoordendetaprodumaquinaAsignar.setcosto_total(productoordendetaprodumaquina.getcosto_total());	
		productoordendetaprodumaquinaAsignar.setdescripcion(productoordendetaprodumaquina.getdescripcion());	
	}
	
	public static void inicializarProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {
		try {
				productoordendetaprodumaquina.setId(0L);	
					
				productoordendetaprodumaquina.setid_orden_deta_produ(-1L);	
				productoordendetaprodumaquina.setid_tipo_area_empresa_produ(-1L);	
				productoordendetaprodumaquina.setid_tipo_proceso_empresa_produ(-1L);	
				productoordendetaprodumaquina.setid_tipo_merma_empresa(-1L);	
				productoordendetaprodumaquina.setid_unidad(-1L);	
				productoordendetaprodumaquina.setcantidad(0);	
				productoordendetaprodumaquina.setcosto(0.0);	
				productoordendetaprodumaquina.setcosto_total(0.0);	
				productoordendetaprodumaquina.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoOrdenDetaProduMaquina(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDORDENDETAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOAREAEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOPROCESOEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDTIPOMAQUINAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoOrdenDetaProduMaquina(String sTipo,Row row,Workbook workbook,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getordendetaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.gettipoareaempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.gettipoprocesoempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.gettipomaquinaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodumaquina.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoOrdenDetaProduMaquina=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoOrdenDetaProduMaquina() {
		return this.sFinalQueryProductoOrdenDetaProduMaquina;
	}
	
	public void setsFinalQueryProductoOrdenDetaProduMaquina(String sFinalQueryProductoOrdenDetaProduMaquina) {
		this.sFinalQueryProductoOrdenDetaProduMaquina= sFinalQueryProductoOrdenDetaProduMaquina;
	}
	
	public Border resaltarSeleccionarProductoOrdenDetaProduMaquina=null;
	
	public Border setResaltarSeleccionarProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoOrdenDetaProduMaquina= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoOrdenDetaProduMaquina() {
		return this.resaltarSeleccionarProductoOrdenDetaProduMaquina;
	}
	
	public void setResaltarSeleccionarProductoOrdenDetaProduMaquina(Border borderResaltarSeleccionarProductoOrdenDetaProduMaquina) {
		this.resaltarSeleccionarProductoOrdenDetaProduMaquina= borderResaltarSeleccionarProductoOrdenDetaProduMaquina;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoOrdenDetaProduMaquina=null;
	public Boolean mostraridProductoOrdenDetaProduMaquina=true;
	public Boolean activaridProductoOrdenDetaProduMaquina=true;

	public Border resaltarid_orden_deta_produProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMaquina=true;
	public Boolean activarid_orden_deta_produProductoOrdenDetaProduMaquina=true;
	public Boolean cargarid_orden_deta_produProductoOrdenDetaProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_deta_produProductoOrdenDetaProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina=true;
	public Boolean activarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina=true;
	public Boolean cargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_area_empresa_produProductoOrdenDetaProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina=true;
	public Boolean activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina=true;
	public Boolean cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina=true;
	public Boolean activarid_tipo_merma_empresaProductoOrdenDetaProduMaquina=true;
	public Boolean cargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_merma_empresaProductoOrdenDetaProduMaquina=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarid_unidadProductoOrdenDetaProduMaquina=true;
	public Boolean activarid_unidadProductoOrdenDetaProduMaquina=true;
	public Boolean cargarid_unidadProductoOrdenDetaProduMaquina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoOrdenDetaProduMaquina=false;//ConEventDepend=true

	public Border resaltarcantidadProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarcantidadProductoOrdenDetaProduMaquina=true;
	public Boolean activarcantidadProductoOrdenDetaProduMaquina=true;

	public Border resaltarcostoProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarcostoProductoOrdenDetaProduMaquina=true;
	public Boolean activarcostoProductoOrdenDetaProduMaquina=true;

	public Border resaltarcosto_totalProductoOrdenDetaProduMaquina=null;
	public Boolean mostrarcosto_totalProductoOrdenDetaProduMaquina=true;
	public Boolean activarcosto_totalProductoOrdenDetaProduMaquina=true;

	public Border resaltardescripcionProductoOrdenDetaProduMaquina=null;
	public Boolean mostrardescripcionProductoOrdenDetaProduMaquina=true;
	public Boolean activardescripcionProductoOrdenDetaProduMaquina=true;

	
	

	public Border setResaltaridProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltaridProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoOrdenDetaProduMaquina() {
		return this.resaltaridProductoOrdenDetaProduMaquina;
	}

	public void setResaltaridProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltaridProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostraridProductoOrdenDetaProduMaquina() {
		return this.mostraridProductoOrdenDetaProduMaquina;
	}

	public void setMostraridProductoOrdenDetaProduMaquina(Boolean mostraridProductoOrdenDetaProduMaquina) {
		this.mostraridProductoOrdenDetaProduMaquina= mostraridProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivaridProductoOrdenDetaProduMaquina() {
		return this.activaridProductoOrdenDetaProduMaquina;
	}

	public void setActivaridProductoOrdenDetaProduMaquina(Boolean activaridProductoOrdenDetaProduMaquina) {
		this.activaridProductoOrdenDetaProduMaquina= activaridProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarid_orden_deta_produProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_deta_produProductoOrdenDetaProduMaquina() {
		return this.resaltarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public void setResaltarid_orden_deta_produProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarid_orden_deta_produProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_orden_deta_produProductoOrdenDetaProduMaquina() {
		return this.mostrarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public void setMostrarid_orden_deta_produProductoOrdenDetaProduMaquina(Boolean mostrarid_orden_deta_produProductoOrdenDetaProduMaquina) {
		this.mostrarid_orden_deta_produProductoOrdenDetaProduMaquina= mostrarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarid_orden_deta_produProductoOrdenDetaProduMaquina() {
		return this.activarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public void setActivarid_orden_deta_produProductoOrdenDetaProduMaquina(Boolean activarid_orden_deta_produProductoOrdenDetaProduMaquina) {
		this.activarid_orden_deta_produProductoOrdenDetaProduMaquina= activarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getCargarid_orden_deta_produProductoOrdenDetaProduMaquina() {
		return this.cargarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public void setCargarid_orden_deta_produProductoOrdenDetaProduMaquina(Boolean cargarid_orden_deta_produProductoOrdenDetaProduMaquina) {
		this.cargarid_orden_deta_produProductoOrdenDetaProduMaquina= cargarid_orden_deta_produProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina() {
		return this.resaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setResaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina() {
		return this.mostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setMostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(Boolean mostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina) {
		this.mostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina= mostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina() {
		return this.activarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setActivarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(Boolean activarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina) {
		this.activarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina= activarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getCargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina() {
		return this.cargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setCargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(Boolean cargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina) {
		this.cargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina= cargarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina() {
		return this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina() {
		return this.mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(Boolean mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina) {
		this.mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina= mostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina() {
		return this.activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(Boolean activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina) {
		this.activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina= activarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Boolean getCargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina() {
		return this.cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public void setCargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(Boolean cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina) {
		this.cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina= cargarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina() {
		return this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public void setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina() {
		return this.mostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public void setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(Boolean mostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina) {
		this.mostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina= mostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarid_tipo_merma_empresaProductoOrdenDetaProduMaquina() {
		return this.activarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public void setActivarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(Boolean activarid_tipo_merma_empresaProductoOrdenDetaProduMaquina) {
		this.activarid_tipo_merma_empresaProductoOrdenDetaProduMaquina= activarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public Boolean getCargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina() {
		return this.cargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public void setCargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(Boolean cargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina) {
		this.cargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina= cargarid_tipo_merma_empresaProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarid_unidadProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoOrdenDetaProduMaquina() {
		return this.resaltarid_unidadProductoOrdenDetaProduMaquina;
	}

	public void setResaltarid_unidadProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarid_unidadProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoOrdenDetaProduMaquina() {
		return this.mostrarid_unidadProductoOrdenDetaProduMaquina;
	}

	public void setMostrarid_unidadProductoOrdenDetaProduMaquina(Boolean mostrarid_unidadProductoOrdenDetaProduMaquina) {
		this.mostrarid_unidadProductoOrdenDetaProduMaquina= mostrarid_unidadProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarid_unidadProductoOrdenDetaProduMaquina() {
		return this.activarid_unidadProductoOrdenDetaProduMaquina;
	}

	public void setActivarid_unidadProductoOrdenDetaProduMaquina(Boolean activarid_unidadProductoOrdenDetaProduMaquina) {
		this.activarid_unidadProductoOrdenDetaProduMaquina= activarid_unidadProductoOrdenDetaProduMaquina;
	}

	public Boolean getCargarid_unidadProductoOrdenDetaProduMaquina() {
		return this.cargarid_unidadProductoOrdenDetaProduMaquina;
	}

	public void setCargarid_unidadProductoOrdenDetaProduMaquina(Boolean cargarid_unidadProductoOrdenDetaProduMaquina) {
		this.cargarid_unidadProductoOrdenDetaProduMaquina= cargarid_unidadProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarcantidadProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoOrdenDetaProduMaquina() {
		return this.resaltarcantidadProductoOrdenDetaProduMaquina;
	}

	public void setResaltarcantidadProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarcantidadProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoOrdenDetaProduMaquina() {
		return this.mostrarcantidadProductoOrdenDetaProduMaquina;
	}

	public void setMostrarcantidadProductoOrdenDetaProduMaquina(Boolean mostrarcantidadProductoOrdenDetaProduMaquina) {
		this.mostrarcantidadProductoOrdenDetaProduMaquina= mostrarcantidadProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarcantidadProductoOrdenDetaProduMaquina() {
		return this.activarcantidadProductoOrdenDetaProduMaquina;
	}

	public void setActivarcantidadProductoOrdenDetaProduMaquina(Boolean activarcantidadProductoOrdenDetaProduMaquina) {
		this.activarcantidadProductoOrdenDetaProduMaquina= activarcantidadProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarcostoProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcostoProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoOrdenDetaProduMaquina() {
		return this.resaltarcostoProductoOrdenDetaProduMaquina;
	}

	public void setResaltarcostoProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarcostoProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcostoProductoOrdenDetaProduMaquina() {
		return this.mostrarcostoProductoOrdenDetaProduMaquina;
	}

	public void setMostrarcostoProductoOrdenDetaProduMaquina(Boolean mostrarcostoProductoOrdenDetaProduMaquina) {
		this.mostrarcostoProductoOrdenDetaProduMaquina= mostrarcostoProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarcostoProductoOrdenDetaProduMaquina() {
		return this.activarcostoProductoOrdenDetaProduMaquina;
	}

	public void setActivarcostoProductoOrdenDetaProduMaquina(Boolean activarcostoProductoOrdenDetaProduMaquina) {
		this.activarcostoProductoOrdenDetaProduMaquina= activarcostoProductoOrdenDetaProduMaquina;
	}

	public Border setResaltarcosto_totalProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoOrdenDetaProduMaquina() {
		return this.resaltarcosto_totalProductoOrdenDetaProduMaquina;
	}

	public void setResaltarcosto_totalProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarcosto_totalProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoOrdenDetaProduMaquina() {
		return this.mostrarcosto_totalProductoOrdenDetaProduMaquina;
	}

	public void setMostrarcosto_totalProductoOrdenDetaProduMaquina(Boolean mostrarcosto_totalProductoOrdenDetaProduMaquina) {
		this.mostrarcosto_totalProductoOrdenDetaProduMaquina= mostrarcosto_totalProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivarcosto_totalProductoOrdenDetaProduMaquina() {
		return this.activarcosto_totalProductoOrdenDetaProduMaquina;
	}

	public void setActivarcosto_totalProductoOrdenDetaProduMaquina(Boolean activarcosto_totalProductoOrdenDetaProduMaquina) {
		this.activarcosto_totalProductoOrdenDetaProduMaquina= activarcosto_totalProductoOrdenDetaProduMaquina;
	}

	public Border setResaltardescripcionProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodumaquinaBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduMaquina.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoOrdenDetaProduMaquina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoOrdenDetaProduMaquina() {
		return this.resaltardescripcionProductoOrdenDetaProduMaquina;
	}

	public void setResaltardescripcionProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltardescripcionProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoOrdenDetaProduMaquina() {
		return this.mostrardescripcionProductoOrdenDetaProduMaquina;
	}

	public void setMostrardescripcionProductoOrdenDetaProduMaquina(Boolean mostrardescripcionProductoOrdenDetaProduMaquina) {
		this.mostrardescripcionProductoOrdenDetaProduMaquina= mostrardescripcionProductoOrdenDetaProduMaquina;
	}

	public Boolean getActivardescripcionProductoOrdenDetaProduMaquina() {
		return this.activardescripcionProductoOrdenDetaProduMaquina;
	}

	public void setActivardescripcionProductoOrdenDetaProduMaquina(Boolean activardescripcionProductoOrdenDetaProduMaquina) {
		this.activardescripcionProductoOrdenDetaProduMaquina= activardescripcionProductoOrdenDetaProduMaquina;
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
		
		
		this.setMostraridProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarid_orden_deta_produProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarid_unidadProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarcantidadProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarcostoProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrarcosto_totalProductoOrdenDetaProduMaquina(esInicial);
		this.setMostrardescripcionProductoOrdenDetaProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.ID)) {
				this.setMostraridProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setMostrarid_orden_deta_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setMostrarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setMostrarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setMostrarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoOrdenDetaProduMaquina(esAsigna);
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
		
		
		this.setActivaridProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarid_orden_deta_produProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarid_unidadProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarcantidadProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarcostoProductoOrdenDetaProduMaquina(esInicial);
		this.setActivarcosto_totalProductoOrdenDetaProduMaquina(esInicial);
		this.setActivardescripcionProductoOrdenDetaProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.ID)) {
				this.setActivaridProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setActivarid_orden_deta_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setActivarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setActivarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setActivarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarid_orden_deta_produProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarid_unidadProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarcantidadProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarcostoProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltarcosto_totalProductoOrdenDetaProduMaquina(esInicial);
		this.setResaltardescripcionProductoOrdenDetaProduMaquina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.ID)) {
				this.setResaltaridProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU)) {
				this.setResaltarid_orden_deta_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU)) {
				this.setResaltarid_tipo_area_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU)) {
				this.setResaltarid_tipo_proceso_empresa_produProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA)) {
				this.setResaltarid_tipo_merma_empresaProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoOrdenDetaProduMaquina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoOrdenDetaProduMaquina(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina() {
		return this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina;
	}

	public void setMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getMostrarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.mostrarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setMostrarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina=true;

	public Boolean getMostrarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina() {
		return this.mostrarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina;
	}

	public void setMostrarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getMostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setMostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoOrdenDetaProduMaquina=true;

	public Boolean getMostrarFK_IdUnidadProductoOrdenDetaProduMaquina() {
		return this.mostrarFK_IdUnidadProductoOrdenDetaProduMaquina;
	}

	public void setMostrarFK_IdUnidadProductoOrdenDetaProduMaquina(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoOrdenDetaProduMaquina= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina() {
		return this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina;
	}

	public void setActivarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getActivarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.activarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setActivarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina=true;

	public Boolean getActivarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina() {
		return this.activarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina;
	}

	public void setActivarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina=true;

	public Boolean getActivarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setActivarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoOrdenDetaProduMaquina=true;

	public Boolean getActivarFK_IdUnidadProductoOrdenDetaProduMaquina() {
		return this.activarFK_IdUnidadProductoOrdenDetaProduMaquina;
	}

	public void setActivarFK_IdUnidadProductoOrdenDetaProduMaquina(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoOrdenDetaProduMaquina= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina=null;

	public Border getResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina() {
		return this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina=null;

	public Border getResaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.resaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setResaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoAreaEmpresaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina=null;

	public Border getResaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina() {
		return this.resaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina;
	}

	public void setResaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMaquinaEmpresaProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina=null;

	public Border getResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina() {
		return this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProcesoEmpresaProduProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoOrdenDetaProduMaquina=null;

	public Border getResaltarFK_IdUnidadProductoOrdenDetaProduMaquina() {
		return this.resaltarFK_IdUnidadProductoOrdenDetaProduMaquina;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMaquina(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMaquina= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduMaquina(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduMaquinaBeanSwingJInternalFrame productoordendetaprodumaquinaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoOrdenDetaProduMaquina= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}