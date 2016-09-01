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


import com.bydan.erp.inventario.util.TallaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.TallaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TallaProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TallaProductoConstantesFunciones extends TallaProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TallaProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TallaProducto"+TallaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TallaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TallaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TallaProductoConstantesFunciones.SCHEMA+"_"+TallaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TallaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TallaProductoConstantesFunciones.SCHEMA+"_"+TallaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TallaProductoConstantesFunciones.SCHEMA+"_"+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TallaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TallaProductoConstantesFunciones.SCHEMA+"_"+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TallaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TallaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TallaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TallaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TallaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TallaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Talla Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Talla Producto";
	public static final String SCLASSWEBTITULO_LOWER="Talla Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TallaProducto";
	public static final String OBJECTNAME="tallaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="talla_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tallaproducto from "+TallaProductoConstantesFunciones.SPERSISTENCENAME+" tallaproducto";
	public static String QUERYSELECTNATIVE="select "+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".id,"+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".version_row,"+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".id_empresa,"+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".codigo,"+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME+".nombre from "+TallaProductoConstantesFunciones.SCHEMA+"."+TallaProductoConstantesFunciones.TABLENAME;//+" as "+TallaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TallaProductoConstantesFuncionesAdditional tallaproductoConstantesFuncionesAdditional=null;
	
	public TallaProductoConstantesFuncionesAdditional getTallaProductoConstantesFuncionesAdditional() {
		return this.tallaproductoConstantesFuncionesAdditional;
	}
	
	public void setTallaProductoConstantesFuncionesAdditional(TallaProductoConstantesFuncionesAdditional tallaproductoConstantesFuncionesAdditional) {
		try {
			this.tallaproductoConstantesFuncionesAdditional=tallaproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTallaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TallaProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TallaProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TallaProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=TallaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(TallaProductoConstantesFunciones.CODIGO)) {sLabelColumna=TallaProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TallaProductoConstantesFunciones.NOMBRE)) {sLabelColumna=TallaProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTallaProductoDescripcion(TallaProducto tallaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tallaproducto !=null/* && tallaproducto.getId()!=0*/) {
			sDescripcion=tallaproducto.getcodigo();//tallaproductotallaproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTallaProductoDescripcionDetallado(TallaProducto tallaproducto) {
		String sDescripcion="";
			
		sDescripcion+=TallaProductoConstantesFunciones.ID+"=";
		sDescripcion+=tallaproducto.getId().toString()+",";
		sDescripcion+=TallaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tallaproducto.getVersionRow().toString()+",";
		sDescripcion+=TallaProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tallaproducto.getid_empresa().toString()+",";
		sDescripcion+=TallaProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=tallaproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=TallaProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tallaproducto.getcodigo()+",";
		sDescripcion+=TallaProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tallaproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTallaProductoDescripcion(TallaProducto tallaproducto,String sValor) throws Exception {			
		if(tallaproducto !=null) {
			tallaproducto.setcodigo(sValor);;//tallaproductotallaproducto.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproducto!=null/*&&tipoproducto.getId()>0*/) {
			sDescripcion=TipoProductoConstantesFunciones.getTipoProductoDescripcion(tipoproducto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoProducto")) {
			sNombreIndice="Tipo=  Por Tipo Producto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTallaProducto(TallaProducto tallaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tallaproducto.setcodigo(tallaproducto.getcodigo().trim());
		tallaproducto.setnombre(tallaproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosTallaProductos(List<TallaProducto> tallaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TallaProducto tallaproducto: tallaproductos) {
			tallaproducto.setcodigo(tallaproducto.getcodigo().trim());
			tallaproducto.setnombre(tallaproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTallaProducto(TallaProducto tallaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tallaproducto.getConCambioAuxiliar()) {
			tallaproducto.setIsDeleted(tallaproducto.getIsDeletedAuxiliar());	
			tallaproducto.setIsNew(tallaproducto.getIsNewAuxiliar());	
			tallaproducto.setIsChanged(tallaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tallaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tallaproducto.setIsDeletedAuxiliar(false);	
			tallaproducto.setIsNewAuxiliar(false);	
			tallaproducto.setIsChangedAuxiliar(false);
			
			tallaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTallaProductos(List<TallaProducto> tallaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TallaProducto tallaproducto : tallaproductos) {
			if(conAsignarBase && tallaproducto.getConCambioAuxiliar()) {
				tallaproducto.setIsDeleted(tallaproducto.getIsDeletedAuxiliar());	
				tallaproducto.setIsNew(tallaproducto.getIsNewAuxiliar());	
				tallaproducto.setIsChanged(tallaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tallaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tallaproducto.setIsDeletedAuxiliar(false);	
				tallaproducto.setIsNewAuxiliar(false);	
				tallaproducto.setIsChangedAuxiliar(false);
				
				tallaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTallaProducto(TallaProducto tallaproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTallaProductos(List<TallaProducto> tallaproductos,Boolean conEnteros) throws Exception  {
		
		for(TallaProducto tallaproducto: tallaproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTallaProducto(List<TallaProducto> tallaproductos,TallaProducto tallaproductoAux) throws Exception  {
		TallaProductoConstantesFunciones.InicializarValoresTallaProducto(tallaproductoAux,true);
		
		for(TallaProducto tallaproducto: tallaproductos) {
			if(tallaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTallaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TallaProductoConstantesFunciones.getArrayColumnasGlobalesTallaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTallaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TallaProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TallaProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTallaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TallaProducto> tallaproductos,TallaProducto tallaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TallaProducto tallaproductoAux: tallaproductos) {
			if(tallaproductoAux!=null && tallaproducto!=null) {
				if((tallaproductoAux.getId()==null && tallaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tallaproductoAux.getId()!=null && tallaproducto.getId()!=null){
					if(tallaproductoAux.getId().equals(tallaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTallaProducto(List<TallaProducto> tallaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TallaProducto tallaproducto: tallaproductos) {			
			if(tallaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTallaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_ID, TallaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_VERSIONROW, TallaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_IDEMPRESA, TallaProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, TallaProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_CODIGO, TallaProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaProductoConstantesFunciones.LABEL_NOMBRE, TallaProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTallaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaProducto() throws Exception  {
		return TallaProductoConstantesFunciones.getTiposSeleccionarTallaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaProducto(Boolean conFk) throws Exception  {
		return TallaProductoConstantesFunciones.getTiposSeleccionarTallaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TallaProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(TallaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TallaProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TallaProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTallaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTallaProducto(TallaProducto tallaproductoAux) throws Exception {
		
			tallaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tallaproductoAux.getEmpresa()));
			tallaproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(tallaproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTallaProducto(List<TallaProducto> tallaproductosTemp) throws Exception {
		for(TallaProducto tallaproductoAux:tallaproductosTemp) {
			
			tallaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tallaproductoAux.getEmpresa()));
			tallaproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(tallaproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTallaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProducto.class)) {
						classes.add(new Classe(TipoProducto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTallaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTallaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TallaProductoConstantesFunciones.getClassesRelationshipsOfTallaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTallaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTallaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TallaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfTallaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTallaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	public static void actualizarLista(TallaProducto tallaproducto,List<TallaProducto> tallaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TallaProducto tallaproductoEncontrado=null;
			
			for(TallaProducto tallaproductoLocal:tallaproductos) {
				if(tallaproductoLocal.getId().equals(tallaproducto.getId())) {
					tallaproductoEncontrado=tallaproductoLocal;
					
					tallaproductoLocal.setIsChanged(tallaproducto.getIsChanged());
					tallaproductoLocal.setIsNew(tallaproducto.getIsNew());
					tallaproductoLocal.setIsDeleted(tallaproducto.getIsDeleted());
					
					tallaproductoLocal.setGeneralEntityOriginal(tallaproducto.getGeneralEntityOriginal());
					
					tallaproductoLocal.setId(tallaproducto.getId());	
					tallaproductoLocal.setVersionRow(tallaproducto.getVersionRow());	
					tallaproductoLocal.setid_empresa(tallaproducto.getid_empresa());	
					tallaproductoLocal.setid_tipo_producto(tallaproducto.getid_tipo_producto());	
					tallaproductoLocal.setcodigo(tallaproducto.getcodigo());	
					tallaproductoLocal.setnombre(tallaproducto.getnombre());	
					
					
					tallaproductoLocal.setProductos(tallaproducto.getProductos());
					tallaproductoLocal.setParametroInventarioDefectos(tallaproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tallaproducto.getIsDeleted()) {
				if(!existe) {
					tallaproductos.add(tallaproducto);
				}
			} else {
				if(tallaproductoEncontrado!=null && permiteQuitar)  {
					tallaproductos.remove(tallaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TallaProducto tallaproducto,List<TallaProducto> tallaproductos) throws Exception {
		try	{			
			for(TallaProducto tallaproductoLocal:tallaproductos) {
				if(tallaproductoLocal.getId().equals(tallaproducto.getId())) {
					tallaproductoLocal.setIsSelected(tallaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTallaProducto(List<TallaProducto> tallaproductosAux) throws Exception {
		//this.tallaproductosAux=tallaproductosAux;
		
		for(TallaProducto tallaproductoAux:tallaproductosAux) {
			if(tallaproductoAux.getIsChanged()) {
				tallaproductoAux.setIsChanged(false);
			}		
			
			if(tallaproductoAux.getIsNew()) {
				tallaproductoAux.setIsNew(false);
			}	
			
			if(tallaproductoAux.getIsDeleted()) {
				tallaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTallaProducto(TallaProducto tallaproductoAux) throws Exception {
		//this.tallaproductoAux=tallaproductoAux;
		
			if(tallaproductoAux.getIsChanged()) {
				tallaproductoAux.setIsChanged(false);
			}		
			
			if(tallaproductoAux.getIsNew()) {
				tallaproductoAux.setIsNew(false);
			}	
			
			if(tallaproductoAux.getIsDeleted()) {
				tallaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TallaProducto tallaproductoAsignar,TallaProducto tallaproducto) throws Exception {
		tallaproductoAsignar.setId(tallaproducto.getId());	
		tallaproductoAsignar.setVersionRow(tallaproducto.getVersionRow());	
		tallaproductoAsignar.setid_empresa(tallaproducto.getid_empresa());
		tallaproductoAsignar.setempresa_descripcion(tallaproducto.getempresa_descripcion());	
		tallaproductoAsignar.setid_tipo_producto(tallaproducto.getid_tipo_producto());
		tallaproductoAsignar.settipoproducto_descripcion(tallaproducto.gettipoproducto_descripcion());	
		tallaproductoAsignar.setcodigo(tallaproducto.getcodigo());	
		tallaproductoAsignar.setnombre(tallaproducto.getnombre());	
	}
	
	public static void inicializarTallaProducto(TallaProducto tallaproducto) throws Exception {
		try {
				tallaproducto.setId(0L);	
					
				tallaproducto.setid_empresa(-1L);	
				tallaproducto.setid_tipo_producto(-1L);	
				tallaproducto.setcodigo("");	
				tallaproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTallaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTallaProducto(String sTipo,Row row,Workbook workbook,TallaProducto tallaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tallaproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallaproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallaproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallaproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTallaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTallaProducto() {
		return this.sFinalQueryTallaProducto;
	}
	
	public void setsFinalQueryTallaProducto(String sFinalQueryTallaProducto) {
		this.sFinalQueryTallaProducto= sFinalQueryTallaProducto;
	}
	
	public Border resaltarSeleccionarTallaProducto=null;
	
	public Border setResaltarSeleccionarTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTallaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTallaProducto() {
		return this.resaltarSeleccionarTallaProducto;
	}
	
	public void setResaltarSeleccionarTallaProducto(Border borderResaltarSeleccionarTallaProducto) {
		this.resaltarSeleccionarTallaProducto= borderResaltarSeleccionarTallaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTallaProducto=null;
	public Boolean mostraridTallaProducto=true;
	public Boolean activaridTallaProducto=true;

	public Border resaltarid_empresaTallaProducto=null;
	public Boolean mostrarid_empresaTallaProducto=true;
	public Boolean activarid_empresaTallaProducto=true;
	public Boolean cargarid_empresaTallaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTallaProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoTallaProducto=null;
	public Boolean mostrarid_tipo_productoTallaProducto=true;
	public Boolean activarid_tipo_productoTallaProducto=true;
	public Boolean cargarid_tipo_productoTallaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoTallaProducto=false;//ConEventDepend=true

	public Border resaltarcodigoTallaProducto=null;
	public Boolean mostrarcodigoTallaProducto=true;
	public Boolean activarcodigoTallaProducto=true;

	public Border resaltarnombreTallaProducto=null;
	public Boolean mostrarnombreTallaProducto=true;
	public Boolean activarnombreTallaProducto=true;

	
	

	public Border setResaltaridTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltaridTallaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTallaProducto() {
		return this.resaltaridTallaProducto;
	}

	public void setResaltaridTallaProducto(Border borderResaltar) {
		this.resaltaridTallaProducto= borderResaltar;
	}

	public Boolean getMostraridTallaProducto() {
		return this.mostraridTallaProducto;
	}

	public void setMostraridTallaProducto(Boolean mostraridTallaProducto) {
		this.mostraridTallaProducto= mostraridTallaProducto;
	}

	public Boolean getActivaridTallaProducto() {
		return this.activaridTallaProducto;
	}

	public void setActivaridTallaProducto(Boolean activaridTallaProducto) {
		this.activaridTallaProducto= activaridTallaProducto;
	}

	public Border setResaltarid_empresaTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaTallaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTallaProducto() {
		return this.resaltarid_empresaTallaProducto;
	}

	public void setResaltarid_empresaTallaProducto(Border borderResaltar) {
		this.resaltarid_empresaTallaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaTallaProducto() {
		return this.mostrarid_empresaTallaProducto;
	}

	public void setMostrarid_empresaTallaProducto(Boolean mostrarid_empresaTallaProducto) {
		this.mostrarid_empresaTallaProducto= mostrarid_empresaTallaProducto;
	}

	public Boolean getActivarid_empresaTallaProducto() {
		return this.activarid_empresaTallaProducto;
	}

	public void setActivarid_empresaTallaProducto(Boolean activarid_empresaTallaProducto) {
		this.activarid_empresaTallaProducto= activarid_empresaTallaProducto;
	}

	public Boolean getCargarid_empresaTallaProducto() {
		return this.cargarid_empresaTallaProducto;
	}

	public void setCargarid_empresaTallaProducto(Boolean cargarid_empresaTallaProducto) {
		this.cargarid_empresaTallaProducto= cargarid_empresaTallaProducto;
	}

	public Border setResaltarid_tipo_productoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoTallaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoTallaProducto() {
		return this.resaltarid_tipo_productoTallaProducto;
	}

	public void setResaltarid_tipo_productoTallaProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoTallaProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoTallaProducto() {
		return this.mostrarid_tipo_productoTallaProducto;
	}

	public void setMostrarid_tipo_productoTallaProducto(Boolean mostrarid_tipo_productoTallaProducto) {
		this.mostrarid_tipo_productoTallaProducto= mostrarid_tipo_productoTallaProducto;
	}

	public Boolean getActivarid_tipo_productoTallaProducto() {
		return this.activarid_tipo_productoTallaProducto;
	}

	public void setActivarid_tipo_productoTallaProducto(Boolean activarid_tipo_productoTallaProducto) {
		this.activarid_tipo_productoTallaProducto= activarid_tipo_productoTallaProducto;
	}

	public Boolean getCargarid_tipo_productoTallaProducto() {
		return this.cargarid_tipo_productoTallaProducto;
	}

	public void setCargarid_tipo_productoTallaProducto(Boolean cargarid_tipo_productoTallaProducto) {
		this.cargarid_tipo_productoTallaProducto= cargarid_tipo_productoTallaProducto;
	}

	public Border setResaltarcodigoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoTallaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTallaProducto() {
		return this.resaltarcodigoTallaProducto;
	}

	public void setResaltarcodigoTallaProducto(Border borderResaltar) {
		this.resaltarcodigoTallaProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoTallaProducto() {
		return this.mostrarcodigoTallaProducto;
	}

	public void setMostrarcodigoTallaProducto(Boolean mostrarcodigoTallaProducto) {
		this.mostrarcodigoTallaProducto= mostrarcodigoTallaProducto;
	}

	public Boolean getActivarcodigoTallaProducto() {
		return this.activarcodigoTallaProducto;
	}

	public void setActivarcodigoTallaProducto(Boolean activarcodigoTallaProducto) {
		this.activarcodigoTallaProducto= activarcodigoTallaProducto;
	}

	public Border setResaltarnombreTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltar);
		
		this.resaltarnombreTallaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTallaProducto() {
		return this.resaltarnombreTallaProducto;
	}

	public void setResaltarnombreTallaProducto(Border borderResaltar) {
		this.resaltarnombreTallaProducto= borderResaltar;
	}

	public Boolean getMostrarnombreTallaProducto() {
		return this.mostrarnombreTallaProducto;
	}

	public void setMostrarnombreTallaProducto(Boolean mostrarnombreTallaProducto) {
		this.mostrarnombreTallaProducto= mostrarnombreTallaProducto;
	}

	public Boolean getActivarnombreTallaProducto() {
		return this.activarnombreTallaProducto;
	}

	public void setActivarnombreTallaProducto(Boolean activarnombreTallaProducto) {
		this.activarnombreTallaProducto= activarnombreTallaProducto;
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
		
		
		this.setMostraridTallaProducto(esInicial);
		this.setMostrarid_empresaTallaProducto(esInicial);
		this.setMostrarid_tipo_productoTallaProducto(esInicial);
		this.setMostrarcodigoTallaProducto(esInicial);
		this.setMostrarnombreTallaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaProductoConstantesFunciones.ID)) {
				this.setMostraridTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTallaProducto(esAsigna);
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
		
		
		this.setActivaridTallaProducto(esInicial);
		this.setActivarid_empresaTallaProducto(esInicial);
		this.setActivarid_tipo_productoTallaProducto(esInicial);
		this.setActivarcodigoTallaProducto(esInicial);
		this.setActivarnombreTallaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaProductoConstantesFunciones.ID)) {
				this.setActivaridTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTallaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTallaProducto(esInicial);
		this.setResaltarid_empresaTallaProducto(esInicial);
		this.setResaltarid_tipo_productoTallaProducto(esInicial);
		this.setResaltarcodigoTallaProducto(esInicial);
		this.setResaltarnombreTallaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaProductoConstantesFunciones.ID)) {
				this.setResaltaridTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTallaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTallaProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoTallaProducto=null;

	public Border getResaltarProductoTallaProducto() {
		return this.resaltarProductoTallaProducto;
	}

	public void setResaltarProductoTallaProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoTallaProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoTallaProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoTallaProducto=true;

	public Boolean getMostrarProductoTallaProducto() {
		return this.mostrarProductoTallaProducto;
	}

	public void setMostrarProductoTallaProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoTallaProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoTallaProducto=true;

	public Boolean gethabilitarResaltarProductoTallaProducto() {
		return this.activarProductoTallaProducto;
	}

	public void setActivarProductoTallaProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoTallaProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoTallaProducto=null;

	public Border getResaltarParametroInventarioDefectoTallaProducto() {
		return this.resaltarParametroInventarioDefectoTallaProducto;
	}

	public void setResaltarParametroInventarioDefectoTallaProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTallaProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tallaproductoBeanSwingJInternalFrame.jTtoolBarTallaProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTallaProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTallaProducto=true;

	public Boolean getMostrarParametroInventarioDefectoTallaProducto() {
		return this.mostrarParametroInventarioDefectoTallaProducto;
	}

	public void setMostrarParametroInventarioDefectoTallaProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTallaProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTallaProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTallaProducto() {
		return this.activarParametroInventarioDefectoTallaProducto;
	}

	public void setActivarParametroInventarioDefectoTallaProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTallaProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoTallaProducto(esInicial);
		this.setMostrarParametroInventarioDefectoTallaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoTallaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTallaProducto(esAsigna);
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

		this.setActivarProductoTallaProducto(esInicial);
		this.setActivarParametroInventarioDefectoTallaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoTallaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTallaProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoTallaProducto(esInicial);
		this.setResaltarParametroInventarioDefectoTallaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoTallaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTallaProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTallaProducto=true;

	public Boolean getMostrarBusquedaPorCodigoTallaProducto() {
		return this.mostrarBusquedaPorCodigoTallaProducto;
	}

	public void setMostrarBusquedaPorCodigoTallaProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTallaProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTallaProducto=true;

	public Boolean getMostrarBusquedaPorNombreTallaProducto() {
		return this.mostrarBusquedaPorNombreTallaProducto;
	}

	public void setMostrarBusquedaPorNombreTallaProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTallaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTallaProducto=true;

	public Boolean getMostrarFK_IdEmpresaTallaProducto() {
		return this.mostrarFK_IdEmpresaTallaProducto;
	}

	public void setMostrarFK_IdEmpresaTallaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTallaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoTallaProducto=true;

	public Boolean getMostrarFK_IdTipoProductoTallaProducto() {
		return this.mostrarFK_IdTipoProductoTallaProducto;
	}

	public void setMostrarFK_IdTipoProductoTallaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoTallaProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTallaProducto=true;

	public Boolean getActivarBusquedaPorCodigoTallaProducto() {
		return this.activarBusquedaPorCodigoTallaProducto;
	}

	public void setActivarBusquedaPorCodigoTallaProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTallaProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTallaProducto=true;

	public Boolean getActivarBusquedaPorNombreTallaProducto() {
		return this.activarBusquedaPorNombreTallaProducto;
	}

	public void setActivarBusquedaPorNombreTallaProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTallaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTallaProducto=true;

	public Boolean getActivarFK_IdEmpresaTallaProducto() {
		return this.activarFK_IdEmpresaTallaProducto;
	}

	public void setActivarFK_IdEmpresaTallaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTallaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoTallaProducto=true;

	public Boolean getActivarFK_IdTipoProductoTallaProducto() {
		return this.activarFK_IdTipoProductoTallaProducto;
	}

	public void setActivarFK_IdTipoProductoTallaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoTallaProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTallaProducto=null;

	public Border getResaltarBusquedaPorCodigoTallaProducto() {
		return this.resaltarBusquedaPorCodigoTallaProducto;
	}

	public void setResaltarBusquedaPorCodigoTallaProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTallaProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTallaProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTallaProducto=null;

	public Border getResaltarBusquedaPorNombreTallaProducto() {
		return this.resaltarBusquedaPorNombreTallaProducto;
	}

	public void setResaltarBusquedaPorNombreTallaProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTallaProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTallaProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTallaProducto=null;

	public Border getResaltarFK_IdEmpresaTallaProducto() {
		return this.resaltarFK_IdEmpresaTallaProducto;
	}

	public void setResaltarFK_IdEmpresaTallaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTallaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTallaProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoTallaProducto=null;

	public Border getResaltarFK_IdTipoProductoTallaProducto() {
		return this.resaltarFK_IdTipoProductoTallaProducto;
	}

	public void setResaltarFK_IdTipoProductoTallaProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoTallaProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoTallaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TallaProductoBeanSwingJInternalFrame tallaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoTallaProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}