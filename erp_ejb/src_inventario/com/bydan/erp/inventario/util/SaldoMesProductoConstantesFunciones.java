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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.SaldoMesProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SaldoMesProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SaldoMesProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SaldoMesProductoConstantesFunciones extends SaldoMesProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SaldoMesProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SaldoMesProducto"+SaldoMesProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SaldoMesProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SaldoMesProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SaldoMesProductoConstantesFunciones.SCHEMA+"_"+SaldoMesProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SaldoMesProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SaldoMesProductoConstantesFunciones.SCHEMA+"_"+SaldoMesProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SaldoMesProductoConstantesFunciones.SCHEMA+"_"+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SaldoMesProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SaldoMesProductoConstantesFunciones.SCHEMA+"_"+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldoMesProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldoMesProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoMesProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SaldoMesProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SaldoMesProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SaldoMesProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SaldoMesProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Saldo Mes Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Saldo Mes Producto";
	public static final String SCLASSWEBTITULO_LOWER="Saldo Mes Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SaldoMesProducto";
	public static final String OBJECTNAME="saldomesproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="saldo_mes_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select saldomesproducto from "+SaldoMesProductoConstantesFunciones.SPERSISTENCENAME+" saldomesproducto";
	public static String QUERYSELECTNATIVE="select "+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".version_row,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_empresa,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_sucursal,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_bodega,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_producto,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_anio,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".id_mes,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".saldo,"+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME+".costo from "+SaldoMesProductoConstantesFunciones.SCHEMA+"."+SaldoMesProductoConstantesFunciones.TABLENAME;//+" as "+SaldoMesProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SaldoMesProductoConstantesFuncionesAdditional saldomesproductoConstantesFuncionesAdditional=null;
	
	public SaldoMesProductoConstantesFuncionesAdditional getSaldoMesProductoConstantesFuncionesAdditional() {
		return this.saldomesproductoConstantesFuncionesAdditional;
	}
	
	public void setSaldoMesProductoConstantesFuncionesAdditional(SaldoMesProductoConstantesFuncionesAdditional saldomesproductoConstantesFuncionesAdditional) {
		try {
			this.saldomesproductoConstantesFuncionesAdditional=saldomesproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String SALDO= "saldo";
    public static final String COSTO= "costo";
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
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getSaldoMesProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDANIO)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.IDMES)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.SALDO)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(SaldoMesProductoConstantesFunciones.COSTO)) {sLabelColumna=SaldoMesProductoConstantesFunciones.LABEL_COSTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getSaldoMesProductoDescripcion(SaldoMesProducto saldomesproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(saldomesproducto !=null/* && saldomesproducto.getId()!=0*/) {
			if(saldomesproducto.getId()!=null) {
				sDescripcion=saldomesproducto.getId().toString();
			}//saldomesproductosaldomesproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSaldoMesProductoDescripcionDetallado(SaldoMesProducto saldomesproducto) {
		String sDescripcion="";
			
		sDescripcion+=SaldoMesProductoConstantesFunciones.ID+"=";
		sDescripcion+=saldomesproducto.getId().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=saldomesproducto.getVersionRow().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=saldomesproducto.getid_empresa().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=saldomesproducto.getid_sucursal().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=saldomesproducto.getid_bodega().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=saldomesproducto.getid_producto().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDANIO+"=";
		sDescripcion+=saldomesproducto.getid_anio().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.IDMES+"=";
		sDescripcion+=saldomesproducto.getid_mes().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.SALDO+"=";
		sDescripcion+=saldomesproducto.getsaldo().toString()+",";
		sDescripcion+=SaldoMesProductoConstantesFunciones.COSTO+"=";
		sDescripcion+=saldomesproducto.getcosto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSaldoMesProductoDescripcion(SaldoMesProducto saldomesproducto,String sValor) throws Exception {			
		if(saldomesproducto !=null) {
			//saldomesproductosaldomesproducto.getId().toString();
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosSaldoMesProducto(SaldoMesProducto saldomesproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosSaldoMesProductos(List<SaldoMesProducto> saldomesproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldoMesProducto saldomesproducto: saldomesproductos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldoMesProducto(SaldoMesProducto saldomesproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && saldomesproducto.getConCambioAuxiliar()) {
			saldomesproducto.setIsDeleted(saldomesproducto.getIsDeletedAuxiliar());	
			saldomesproducto.setIsNew(saldomesproducto.getIsNewAuxiliar());	
			saldomesproducto.setIsChanged(saldomesproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			saldomesproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			saldomesproducto.setIsDeletedAuxiliar(false);	
			saldomesproducto.setIsNewAuxiliar(false);	
			saldomesproducto.setIsChangedAuxiliar(false);
			
			saldomesproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldoMesProductos(List<SaldoMesProducto> saldomesproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SaldoMesProducto saldomesproducto : saldomesproductos) {
			if(conAsignarBase && saldomesproducto.getConCambioAuxiliar()) {
				saldomesproducto.setIsDeleted(saldomesproducto.getIsDeletedAuxiliar());	
				saldomesproducto.setIsNew(saldomesproducto.getIsNewAuxiliar());	
				saldomesproducto.setIsChanged(saldomesproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				saldomesproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				saldomesproducto.setIsDeletedAuxiliar(false);	
				saldomesproducto.setIsNewAuxiliar(false);	
				saldomesproducto.setIsChangedAuxiliar(false);
				
				saldomesproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSaldoMesProducto(SaldoMesProducto saldomesproducto,Boolean conEnteros) throws Exception  {
		saldomesproducto.setsaldo(0.0);
		saldomesproducto.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSaldoMesProductos(List<SaldoMesProducto> saldomesproductos,Boolean conEnteros) throws Exception  {
		
		for(SaldoMesProducto saldomesproducto: saldomesproductos) {
			saldomesproducto.setsaldo(0.0);
			saldomesproducto.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSaldoMesProducto(List<SaldoMesProducto> saldomesproductos,SaldoMesProducto saldomesproductoAux) throws Exception  {
		SaldoMesProductoConstantesFunciones.InicializarValoresSaldoMesProducto(saldomesproductoAux,true);
		
		for(SaldoMesProducto saldomesproducto: saldomesproductos) {
			if(saldomesproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldomesproductoAux.setsaldo(saldomesproductoAux.getsaldo()+saldomesproducto.getsaldo());			
			saldomesproductoAux.setcosto(saldomesproductoAux.getcosto()+saldomesproducto.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldoMesProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SaldoMesProductoConstantesFunciones.getArrayColumnasGlobalesSaldoMesProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldoMesProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoMesProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoMesProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoMesProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoMesProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSaldoMesProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldoMesProducto> saldomesproductos,SaldoMesProducto saldomesproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldoMesProducto saldomesproductoAux: saldomesproductos) {
			if(saldomesproductoAux!=null && saldomesproducto!=null) {
				if((saldomesproductoAux.getId()==null && saldomesproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(saldomesproductoAux.getId()!=null && saldomesproducto.getId()!=null){
					if(saldomesproductoAux.getId().equals(saldomesproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldoMesProducto(List<SaldoMesProducto> saldomesproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
		Double costoTotal=0.0;
	
		for(SaldoMesProducto saldomesproducto: saldomesproductos) {			
			if(saldomesproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=saldomesproducto.getsaldo();
			costoTotal+=saldomesproducto.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoMesProductoConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoMesProductoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSaldoMesProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_ID, SaldoMesProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_VERSIONROW, SaldoMesProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDEMPRESA, SaldoMesProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDSUCURSAL, SaldoMesProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDBODEGA, SaldoMesProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDPRODUCTO, SaldoMesProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDANIO, SaldoMesProductoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_IDMES, SaldoMesProductoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_SALDO, SaldoMesProductoConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoMesProductoConstantesFunciones.LABEL_COSTO, SaldoMesProductoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSaldoMesProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoMesProductoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoMesProducto() throws Exception  {
		return SaldoMesProductoConstantesFunciones.getTiposSeleccionarSaldoMesProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoMesProducto(Boolean conFk) throws Exception  {
		return SaldoMesProductoConstantesFunciones.getTiposSeleccionarSaldoMesProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoMesProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoMesProductoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(SaldoMesProductoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSaldoMesProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSaldoMesProducto(SaldoMesProducto saldomesproductoAux) throws Exception {
		
			saldomesproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldomesproductoAux.getEmpresa()));
			saldomesproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldomesproductoAux.getSucursal()));
			saldomesproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(saldomesproductoAux.getBodega()));
			saldomesproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(saldomesproductoAux.getProducto()));
			saldomesproductoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(saldomesproductoAux.getAnio()));
			saldomesproductoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(saldomesproductoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSaldoMesProducto(List<SaldoMesProducto> saldomesproductosTemp) throws Exception {
		for(SaldoMesProducto saldomesproductoAux:saldomesproductosTemp) {
			
			saldomesproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldomesproductoAux.getEmpresa()));
			saldomesproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldomesproductoAux.getSucursal()));
			saldomesproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(saldomesproductoAux.getBodega()));
			saldomesproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(saldomesproductoAux.getProducto()));
			saldomesproductoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(saldomesproductoAux.getAnio()));
			saldomesproductoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(saldomesproductoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSaldoMesProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSaldoMesProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoMesProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldoMesProductoConstantesFunciones.getClassesRelationshipsOfSaldoMesProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoMesProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldoMesProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldoMesProductoConstantesFunciones.getClassesRelationshipsFromStringsOfSaldoMesProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldoMesProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SaldoMesProducto saldomesproducto,List<SaldoMesProducto> saldomesproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SaldoMesProducto saldomesproductoEncontrado=null;
			
			for(SaldoMesProducto saldomesproductoLocal:saldomesproductos) {
				if(saldomesproductoLocal.getId().equals(saldomesproducto.getId())) {
					saldomesproductoEncontrado=saldomesproductoLocal;
					
					saldomesproductoLocal.setIsChanged(saldomesproducto.getIsChanged());
					saldomesproductoLocal.setIsNew(saldomesproducto.getIsNew());
					saldomesproductoLocal.setIsDeleted(saldomesproducto.getIsDeleted());
					
					saldomesproductoLocal.setGeneralEntityOriginal(saldomesproducto.getGeneralEntityOriginal());
					
					saldomesproductoLocal.setId(saldomesproducto.getId());	
					saldomesproductoLocal.setVersionRow(saldomesproducto.getVersionRow());	
					saldomesproductoLocal.setid_empresa(saldomesproducto.getid_empresa());	
					saldomesproductoLocal.setid_sucursal(saldomesproducto.getid_sucursal());	
					saldomesproductoLocal.setid_bodega(saldomesproducto.getid_bodega());	
					saldomesproductoLocal.setid_producto(saldomesproducto.getid_producto());	
					saldomesproductoLocal.setid_anio(saldomesproducto.getid_anio());	
					saldomesproductoLocal.setid_mes(saldomesproducto.getid_mes());	
					saldomesproductoLocal.setsaldo(saldomesproducto.getsaldo());	
					saldomesproductoLocal.setcosto(saldomesproducto.getcosto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!saldomesproducto.getIsDeleted()) {
				if(!existe) {
					saldomesproductos.add(saldomesproducto);
				}
			} else {
				if(saldomesproductoEncontrado!=null && permiteQuitar)  {
					saldomesproductos.remove(saldomesproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SaldoMesProducto saldomesproducto,List<SaldoMesProducto> saldomesproductos) throws Exception {
		try	{			
			for(SaldoMesProducto saldomesproductoLocal:saldomesproductos) {
				if(saldomesproductoLocal.getId().equals(saldomesproducto.getId())) {
					saldomesproductoLocal.setIsSelected(saldomesproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSaldoMesProducto(List<SaldoMesProducto> saldomesproductosAux) throws Exception {
		//this.saldomesproductosAux=saldomesproductosAux;
		
		for(SaldoMesProducto saldomesproductoAux:saldomesproductosAux) {
			if(saldomesproductoAux.getIsChanged()) {
				saldomesproductoAux.setIsChanged(false);
			}		
			
			if(saldomesproductoAux.getIsNew()) {
				saldomesproductoAux.setIsNew(false);
			}	
			
			if(saldomesproductoAux.getIsDeleted()) {
				saldomesproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSaldoMesProducto(SaldoMesProducto saldomesproductoAux) throws Exception {
		//this.saldomesproductoAux=saldomesproductoAux;
		
			if(saldomesproductoAux.getIsChanged()) {
				saldomesproductoAux.setIsChanged(false);
			}		
			
			if(saldomesproductoAux.getIsNew()) {
				saldomesproductoAux.setIsNew(false);
			}	
			
			if(saldomesproductoAux.getIsDeleted()) {
				saldomesproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SaldoMesProducto saldomesproductoAsignar,SaldoMesProducto saldomesproducto) throws Exception {
		saldomesproductoAsignar.setId(saldomesproducto.getId());	
		saldomesproductoAsignar.setVersionRow(saldomesproducto.getVersionRow());	
		saldomesproductoAsignar.setid_empresa(saldomesproducto.getid_empresa());
		saldomesproductoAsignar.setempresa_descripcion(saldomesproducto.getempresa_descripcion());	
		saldomesproductoAsignar.setid_sucursal(saldomesproducto.getid_sucursal());
		saldomesproductoAsignar.setsucursal_descripcion(saldomesproducto.getsucursal_descripcion());	
		saldomesproductoAsignar.setid_bodega(saldomesproducto.getid_bodega());
		saldomesproductoAsignar.setbodega_descripcion(saldomesproducto.getbodega_descripcion());	
		saldomesproductoAsignar.setid_producto(saldomesproducto.getid_producto());
		saldomesproductoAsignar.setproducto_descripcion(saldomesproducto.getproducto_descripcion());	
		saldomesproductoAsignar.setid_anio(saldomesproducto.getid_anio());
		saldomesproductoAsignar.setanio_descripcion(saldomesproducto.getanio_descripcion());	
		saldomesproductoAsignar.setid_mes(saldomesproducto.getid_mes());
		saldomesproductoAsignar.setmes_descripcion(saldomesproducto.getmes_descripcion());	
		saldomesproductoAsignar.setsaldo(saldomesproducto.getsaldo());	
		saldomesproductoAsignar.setcosto(saldomesproducto.getcosto());	
	}
	
	public static void inicializarSaldoMesProducto(SaldoMesProducto saldomesproducto) throws Exception {
		try {
				saldomesproducto.setId(0L);	
					
				saldomesproducto.setid_empresa(-1L);	
				saldomesproducto.setid_sucursal(-1L);	
				saldomesproducto.setid_bodega(-1L);	
				saldomesproducto.setid_producto(-1L);	
				saldomesproducto.setid_anio(null);	
				saldomesproducto.setid_mes(null);	
				saldomesproducto.setsaldo(0.0);	
				saldomesproducto.setcosto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSaldoMesProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoMesProductoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSaldoMesProducto(String sTipo,Row row,Workbook workbook,SaldoMesProducto saldomesproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldomesproducto.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySaldoMesProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySaldoMesProducto() {
		return this.sFinalQuerySaldoMesProducto;
	}
	
	public void setsFinalQuerySaldoMesProducto(String sFinalQuerySaldoMesProducto) {
		this.sFinalQuerySaldoMesProducto= sFinalQuerySaldoMesProducto;
	}
	
	public Border resaltarSeleccionarSaldoMesProducto=null;
	
	public Border setResaltarSeleccionarSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSaldoMesProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSaldoMesProducto() {
		return this.resaltarSeleccionarSaldoMesProducto;
	}
	
	public void setResaltarSeleccionarSaldoMesProducto(Border borderResaltarSeleccionarSaldoMesProducto) {
		this.resaltarSeleccionarSaldoMesProducto= borderResaltarSeleccionarSaldoMesProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSaldoMesProducto=null;
	public Boolean mostraridSaldoMesProducto=true;
	public Boolean activaridSaldoMesProducto=true;

	public Border resaltarid_empresaSaldoMesProducto=null;
	public Boolean mostrarid_empresaSaldoMesProducto=true;
	public Boolean activarid_empresaSaldoMesProducto=true;
	public Boolean cargarid_empresaSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalSaldoMesProducto=null;
	public Boolean mostrarid_sucursalSaldoMesProducto=true;
	public Boolean activarid_sucursalSaldoMesProducto=true;
	public Boolean cargarid_sucursalSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaSaldoMesProducto=null;
	public Boolean mostrarid_bodegaSaldoMesProducto=true;
	public Boolean activarid_bodegaSaldoMesProducto=true;
	public Boolean cargarid_bodegaSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarid_productoSaldoMesProducto=null;
	public Boolean mostrarid_productoSaldoMesProducto=true;
	public Boolean activarid_productoSaldoMesProducto=true;
	public Boolean cargarid_productoSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarid_anioSaldoMesProducto=null;
	public Boolean mostrarid_anioSaldoMesProducto=true;
	public Boolean activarid_anioSaldoMesProducto=true;
	public Boolean cargarid_anioSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarid_mesSaldoMesProducto=null;
	public Boolean mostrarid_mesSaldoMesProducto=true;
	public Boolean activarid_mesSaldoMesProducto=true;
	public Boolean cargarid_mesSaldoMesProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesSaldoMesProducto=false;//ConEventDepend=true

	public Border resaltarsaldoSaldoMesProducto=null;
	public Boolean mostrarsaldoSaldoMesProducto=true;
	public Boolean activarsaldoSaldoMesProducto=true;

	public Border resaltarcostoSaldoMesProducto=null;
	public Boolean mostrarcostoSaldoMesProducto=true;
	public Boolean activarcostoSaldoMesProducto=true;

	
	

	public Border setResaltaridSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltaridSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSaldoMesProducto() {
		return this.resaltaridSaldoMesProducto;
	}

	public void setResaltaridSaldoMesProducto(Border borderResaltar) {
		this.resaltaridSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostraridSaldoMesProducto() {
		return this.mostraridSaldoMesProducto;
	}

	public void setMostraridSaldoMesProducto(Boolean mostraridSaldoMesProducto) {
		this.mostraridSaldoMesProducto= mostraridSaldoMesProducto;
	}

	public Boolean getActivaridSaldoMesProducto() {
		return this.activaridSaldoMesProducto;
	}

	public void setActivaridSaldoMesProducto(Boolean activaridSaldoMesProducto) {
		this.activaridSaldoMesProducto= activaridSaldoMesProducto;
	}

	public Border setResaltarid_empresaSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSaldoMesProducto() {
		return this.resaltarid_empresaSaldoMesProducto;
	}

	public void setResaltarid_empresaSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_empresaSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaSaldoMesProducto() {
		return this.mostrarid_empresaSaldoMesProducto;
	}

	public void setMostrarid_empresaSaldoMesProducto(Boolean mostrarid_empresaSaldoMesProducto) {
		this.mostrarid_empresaSaldoMesProducto= mostrarid_empresaSaldoMesProducto;
	}

	public Boolean getActivarid_empresaSaldoMesProducto() {
		return this.activarid_empresaSaldoMesProducto;
	}

	public void setActivarid_empresaSaldoMesProducto(Boolean activarid_empresaSaldoMesProducto) {
		this.activarid_empresaSaldoMesProducto= activarid_empresaSaldoMesProducto;
	}

	public Boolean getCargarid_empresaSaldoMesProducto() {
		return this.cargarid_empresaSaldoMesProducto;
	}

	public void setCargarid_empresaSaldoMesProducto(Boolean cargarid_empresaSaldoMesProducto) {
		this.cargarid_empresaSaldoMesProducto= cargarid_empresaSaldoMesProducto;
	}

	public Border setResaltarid_sucursalSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSaldoMesProducto() {
		return this.resaltarid_sucursalSaldoMesProducto;
	}

	public void setResaltarid_sucursalSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_sucursalSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSaldoMesProducto() {
		return this.mostrarid_sucursalSaldoMesProducto;
	}

	public void setMostrarid_sucursalSaldoMesProducto(Boolean mostrarid_sucursalSaldoMesProducto) {
		this.mostrarid_sucursalSaldoMesProducto= mostrarid_sucursalSaldoMesProducto;
	}

	public Boolean getActivarid_sucursalSaldoMesProducto() {
		return this.activarid_sucursalSaldoMesProducto;
	}

	public void setActivarid_sucursalSaldoMesProducto(Boolean activarid_sucursalSaldoMesProducto) {
		this.activarid_sucursalSaldoMesProducto= activarid_sucursalSaldoMesProducto;
	}

	public Boolean getCargarid_sucursalSaldoMesProducto() {
		return this.cargarid_sucursalSaldoMesProducto;
	}

	public void setCargarid_sucursalSaldoMesProducto(Boolean cargarid_sucursalSaldoMesProducto) {
		this.cargarid_sucursalSaldoMesProducto= cargarid_sucursalSaldoMesProducto;
	}

	public Border setResaltarid_bodegaSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaSaldoMesProducto() {
		return this.resaltarid_bodegaSaldoMesProducto;
	}

	public void setResaltarid_bodegaSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_bodegaSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaSaldoMesProducto() {
		return this.mostrarid_bodegaSaldoMesProducto;
	}

	public void setMostrarid_bodegaSaldoMesProducto(Boolean mostrarid_bodegaSaldoMesProducto) {
		this.mostrarid_bodegaSaldoMesProducto= mostrarid_bodegaSaldoMesProducto;
	}

	public Boolean getActivarid_bodegaSaldoMesProducto() {
		return this.activarid_bodegaSaldoMesProducto;
	}

	public void setActivarid_bodegaSaldoMesProducto(Boolean activarid_bodegaSaldoMesProducto) {
		this.activarid_bodegaSaldoMesProducto= activarid_bodegaSaldoMesProducto;
	}

	public Boolean getCargarid_bodegaSaldoMesProducto() {
		return this.cargarid_bodegaSaldoMesProducto;
	}

	public void setCargarid_bodegaSaldoMesProducto(Boolean cargarid_bodegaSaldoMesProducto) {
		this.cargarid_bodegaSaldoMesProducto= cargarid_bodegaSaldoMesProducto;
	}

	public Border setResaltarid_productoSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoSaldoMesProducto() {
		return this.resaltarid_productoSaldoMesProducto;
	}

	public void setResaltarid_productoSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_productoSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoSaldoMesProducto() {
		return this.mostrarid_productoSaldoMesProducto;
	}

	public void setMostrarid_productoSaldoMesProducto(Boolean mostrarid_productoSaldoMesProducto) {
		this.mostrarid_productoSaldoMesProducto= mostrarid_productoSaldoMesProducto;
	}

	public Boolean getActivarid_productoSaldoMesProducto() {
		return this.activarid_productoSaldoMesProducto;
	}

	public void setActivarid_productoSaldoMesProducto(Boolean activarid_productoSaldoMesProducto) {
		this.activarid_productoSaldoMesProducto= activarid_productoSaldoMesProducto;
	}

	public Boolean getCargarid_productoSaldoMesProducto() {
		return this.cargarid_productoSaldoMesProducto;
	}

	public void setCargarid_productoSaldoMesProducto(Boolean cargarid_productoSaldoMesProducto) {
		this.cargarid_productoSaldoMesProducto= cargarid_productoSaldoMesProducto;
	}

	public Border setResaltarid_anioSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_anioSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioSaldoMesProducto() {
		return this.resaltarid_anioSaldoMesProducto;
	}

	public void setResaltarid_anioSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_anioSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_anioSaldoMesProducto() {
		return this.mostrarid_anioSaldoMesProducto;
	}

	public void setMostrarid_anioSaldoMesProducto(Boolean mostrarid_anioSaldoMesProducto) {
		this.mostrarid_anioSaldoMesProducto= mostrarid_anioSaldoMesProducto;
	}

	public Boolean getActivarid_anioSaldoMesProducto() {
		return this.activarid_anioSaldoMesProducto;
	}

	public void setActivarid_anioSaldoMesProducto(Boolean activarid_anioSaldoMesProducto) {
		this.activarid_anioSaldoMesProducto= activarid_anioSaldoMesProducto;
	}

	public Boolean getCargarid_anioSaldoMesProducto() {
		return this.cargarid_anioSaldoMesProducto;
	}

	public void setCargarid_anioSaldoMesProducto(Boolean cargarid_anioSaldoMesProducto) {
		this.cargarid_anioSaldoMesProducto= cargarid_anioSaldoMesProducto;
	}

	public Border setResaltarid_mesSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarid_mesSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesSaldoMesProducto() {
		return this.resaltarid_mesSaldoMesProducto;
	}

	public void setResaltarid_mesSaldoMesProducto(Border borderResaltar) {
		this.resaltarid_mesSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarid_mesSaldoMesProducto() {
		return this.mostrarid_mesSaldoMesProducto;
	}

	public void setMostrarid_mesSaldoMesProducto(Boolean mostrarid_mesSaldoMesProducto) {
		this.mostrarid_mesSaldoMesProducto= mostrarid_mesSaldoMesProducto;
	}

	public Boolean getActivarid_mesSaldoMesProducto() {
		return this.activarid_mesSaldoMesProducto;
	}

	public void setActivarid_mesSaldoMesProducto(Boolean activarid_mesSaldoMesProducto) {
		this.activarid_mesSaldoMesProducto= activarid_mesSaldoMesProducto;
	}

	public Boolean getCargarid_mesSaldoMesProducto() {
		return this.cargarid_mesSaldoMesProducto;
	}

	public void setCargarid_mesSaldoMesProducto(Boolean cargarid_mesSaldoMesProducto) {
		this.cargarid_mesSaldoMesProducto= cargarid_mesSaldoMesProducto;
	}

	public Border setResaltarsaldoSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarsaldoSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoSaldoMesProducto() {
		return this.resaltarsaldoSaldoMesProducto;
	}

	public void setResaltarsaldoSaldoMesProducto(Border borderResaltar) {
		this.resaltarsaldoSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarsaldoSaldoMesProducto() {
		return this.mostrarsaldoSaldoMesProducto;
	}

	public void setMostrarsaldoSaldoMesProducto(Boolean mostrarsaldoSaldoMesProducto) {
		this.mostrarsaldoSaldoMesProducto= mostrarsaldoSaldoMesProducto;
	}

	public Boolean getActivarsaldoSaldoMesProducto() {
		return this.activarsaldoSaldoMesProducto;
	}

	public void setActivarsaldoSaldoMesProducto(Boolean activarsaldoSaldoMesProducto) {
		this.activarsaldoSaldoMesProducto= activarsaldoSaldoMesProducto;
	}

	public Border setResaltarcostoSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldomesproductoBeanSwingJInternalFrame.jTtoolBarSaldoMesProducto.setBorder(borderResaltar);
		
		this.resaltarcostoSaldoMesProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoSaldoMesProducto() {
		return this.resaltarcostoSaldoMesProducto;
	}

	public void setResaltarcostoSaldoMesProducto(Border borderResaltar) {
		this.resaltarcostoSaldoMesProducto= borderResaltar;
	}

	public Boolean getMostrarcostoSaldoMesProducto() {
		return this.mostrarcostoSaldoMesProducto;
	}

	public void setMostrarcostoSaldoMesProducto(Boolean mostrarcostoSaldoMesProducto) {
		this.mostrarcostoSaldoMesProducto= mostrarcostoSaldoMesProducto;
	}

	public Boolean getActivarcostoSaldoMesProducto() {
		return this.activarcostoSaldoMesProducto;
	}

	public void setActivarcostoSaldoMesProducto(Boolean activarcostoSaldoMesProducto) {
		this.activarcostoSaldoMesProducto= activarcostoSaldoMesProducto;
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
		
		
		this.setMostraridSaldoMesProducto(esInicial);
		this.setMostrarid_empresaSaldoMesProducto(esInicial);
		this.setMostrarid_sucursalSaldoMesProducto(esInicial);
		this.setMostrarid_bodegaSaldoMesProducto(esInicial);
		this.setMostrarid_productoSaldoMesProducto(esInicial);
		this.setMostrarid_anioSaldoMesProducto(esInicial);
		this.setMostrarid_mesSaldoMesProducto(esInicial);
		this.setMostrarsaldoSaldoMesProducto(esInicial);
		this.setMostrarcostoSaldoMesProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.ID)) {
				this.setMostraridSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.SALDO)) {
				this.setMostrarsaldoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.COSTO)) {
				this.setMostrarcostoSaldoMesProducto(esAsigna);
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
		
		
		this.setActivaridSaldoMesProducto(esInicial);
		this.setActivarid_empresaSaldoMesProducto(esInicial);
		this.setActivarid_sucursalSaldoMesProducto(esInicial);
		this.setActivarid_bodegaSaldoMesProducto(esInicial);
		this.setActivarid_productoSaldoMesProducto(esInicial);
		this.setActivarid_anioSaldoMesProducto(esInicial);
		this.setActivarid_mesSaldoMesProducto(esInicial);
		this.setActivarsaldoSaldoMesProducto(esInicial);
		this.setActivarcostoSaldoMesProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.ID)) {
				this.setActivaridSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDMES)) {
				this.setActivarid_mesSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.SALDO)) {
				this.setActivarsaldoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.COSTO)) {
				this.setActivarcostoSaldoMesProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSaldoMesProducto(esInicial);
		this.setResaltarid_empresaSaldoMesProducto(esInicial);
		this.setResaltarid_sucursalSaldoMesProducto(esInicial);
		this.setResaltarid_bodegaSaldoMesProducto(esInicial);
		this.setResaltarid_productoSaldoMesProducto(esInicial);
		this.setResaltarid_anioSaldoMesProducto(esInicial);
		this.setResaltarid_mesSaldoMesProducto(esInicial);
		this.setResaltarsaldoSaldoMesProducto(esInicial);
		this.setResaltarcostoSaldoMesProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.ID)) {
				this.setResaltaridSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.SALDO)) {
				this.setResaltarsaldoSaldoMesProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoMesProductoConstantesFunciones.COSTO)) {
				this.setResaltarcostoSaldoMesProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioSaldoMesProducto=true;

	public Boolean getMostrarFK_IdAnioSaldoMesProducto() {
		return this.mostrarFK_IdAnioSaldoMesProducto;
	}

	public void setMostrarFK_IdAnioSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioSaldoMesProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaSaldoMesProducto=true;

	public Boolean getMostrarFK_IdBodegaSaldoMesProducto() {
		return this.mostrarFK_IdBodegaSaldoMesProducto;
	}

	public void setMostrarFK_IdBodegaSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaSaldoMesProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSaldoMesProducto=true;

	public Boolean getMostrarFK_IdEmpresaSaldoMesProducto() {
		return this.mostrarFK_IdEmpresaSaldoMesProducto;
	}

	public void setMostrarFK_IdEmpresaSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSaldoMesProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesSaldoMesProducto=true;

	public Boolean getMostrarFK_IdMesSaldoMesProducto() {
		return this.mostrarFK_IdMesSaldoMesProducto;
	}

	public void setMostrarFK_IdMesSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesSaldoMesProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoSaldoMesProducto=true;

	public Boolean getMostrarFK_IdProductoSaldoMesProducto() {
		return this.mostrarFK_IdProductoSaldoMesProducto;
	}

	public void setMostrarFK_IdProductoSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoSaldoMesProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSaldoMesProducto=true;

	public Boolean getMostrarFK_IdSucursalSaldoMesProducto() {
		return this.mostrarFK_IdSucursalSaldoMesProducto;
	}

	public void setMostrarFK_IdSucursalSaldoMesProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSaldoMesProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioSaldoMesProducto=true;

	public Boolean getActivarFK_IdAnioSaldoMesProducto() {
		return this.activarFK_IdAnioSaldoMesProducto;
	}

	public void setActivarFK_IdAnioSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdAnioSaldoMesProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaSaldoMesProducto=true;

	public Boolean getActivarFK_IdBodegaSaldoMesProducto() {
		return this.activarFK_IdBodegaSaldoMesProducto;
	}

	public void setActivarFK_IdBodegaSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaSaldoMesProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSaldoMesProducto=true;

	public Boolean getActivarFK_IdEmpresaSaldoMesProducto() {
		return this.activarFK_IdEmpresaSaldoMesProducto;
	}

	public void setActivarFK_IdEmpresaSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSaldoMesProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdMesSaldoMesProducto=true;

	public Boolean getActivarFK_IdMesSaldoMesProducto() {
		return this.activarFK_IdMesSaldoMesProducto;
	}

	public void setActivarFK_IdMesSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdMesSaldoMesProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoSaldoMesProducto=true;

	public Boolean getActivarFK_IdProductoSaldoMesProducto() {
		return this.activarFK_IdProductoSaldoMesProducto;
	}

	public void setActivarFK_IdProductoSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoSaldoMesProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSaldoMesProducto=true;

	public Boolean getActivarFK_IdSucursalSaldoMesProducto() {
		return this.activarFK_IdSucursalSaldoMesProducto;
	}

	public void setActivarFK_IdSucursalSaldoMesProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSaldoMesProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioSaldoMesProducto=null;

	public Border getResaltarFK_IdAnioSaldoMesProducto() {
		return this.resaltarFK_IdAnioSaldoMesProducto;
	}

	public void setResaltarFK_IdAnioSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdAnioSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdAnioSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioSaldoMesProducto= borderResaltar;
	}

	public Border resaltarFK_IdBodegaSaldoMesProducto=null;

	public Border getResaltarFK_IdBodegaSaldoMesProducto() {
		return this.resaltarFK_IdBodegaSaldoMesProducto;
	}

	public void setResaltarFK_IdBodegaSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaSaldoMesProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSaldoMesProducto=null;

	public Border getResaltarFK_IdEmpresaSaldoMesProducto() {
		return this.resaltarFK_IdEmpresaSaldoMesProducto;
	}

	public void setResaltarFK_IdEmpresaSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSaldoMesProducto= borderResaltar;
	}

	public Border resaltarFK_IdMesSaldoMesProducto=null;

	public Border getResaltarFK_IdMesSaldoMesProducto() {
		return this.resaltarFK_IdMesSaldoMesProducto;
	}

	public void setResaltarFK_IdMesSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdMesSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdMesSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesSaldoMesProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoSaldoMesProducto=null;

	public Border getResaltarFK_IdProductoSaldoMesProducto() {
		return this.resaltarFK_IdProductoSaldoMesProducto;
	}

	public void setResaltarFK_IdProductoSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoSaldoMesProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSaldoMesProducto=null;

	public Border getResaltarFK_IdSucursalSaldoMesProducto() {
		return this.resaltarFK_IdSucursalSaldoMesProducto;
	}

	public void setResaltarFK_IdSucursalSaldoMesProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalSaldoMesProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSaldoMesProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoMesProductoBeanSwingJInternalFrame saldomesproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSaldoMesProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}