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


import com.bydan.erp.inventario.util.TipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoPrecioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPrecioConstantesFunciones extends TipoPrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPrecio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPrecio"+TipoPrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPrecioConstantesFunciones.SCHEMA+"_"+TipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPrecioConstantesFunciones.SCHEMA+"_"+TipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPrecioConstantesFunciones.SCHEMA+"_"+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPrecioConstantesFunciones.SCHEMA+"_"+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Precioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Precio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPrecio";
	public static final String OBJECTNAME="tipoprecio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprecio from "+TipoPrecioConstantesFunciones.SPERSISTENCENAME+" tipoprecio";
	public static String QUERYSELECTNATIVE="select "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".id,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".codigo,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".nombre,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".fecha_desde,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".fecha_hasta,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".monto,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".esta_activo,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".descripcion from "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME;//+" as "+TipoPrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPrecioConstantesFuncionesAdditional tipoprecioConstantesFuncionesAdditional=null;
	
	public TipoPrecioConstantesFuncionesAdditional getTipoPrecioConstantesFuncionesAdditional() {
		return this.tipoprecioConstantesFuncionesAdditional;
	}
	
	public void setTipoPrecioConstantesFuncionesAdditional(TipoPrecioConstantesFuncionesAdditional tipoprecioConstantesFuncionesAdditional) {
		try {
			this.tipoprecioConstantesFuncionesAdditional=tipoprecioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String MONTO= "monto";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.CODIGO)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.FECHADESDE)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.FECHAHASTA)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.MONTO)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.ESTAACTIVO)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(TipoPrecioConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoPrecioConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(TipoPrecio tipoprecio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipoprecio.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(TipoPrecio tipoprecio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipoprecio.getId(),tipoprecio.getesta_activo());

		return sDescripcion;
	}	
			
	
	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprecio !=null/* && tipoprecio.getId()!=0*/) {
			sDescripcion=tipoprecio.getcodigo();//tipopreciotipoprecio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPrecioDescripcionDetallado(TipoPrecio tipoprecio) {
		String sDescripcion="";
			
		sDescripcion+=TipoPrecioConstantesFunciones.ID+"=";
		sDescripcion+=tipoprecio.getId().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprecio.getVersionRow().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoprecio.getid_empresa().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprecio.getcodigo()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprecio.getnombre()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=tipoprecio.getfecha_desde().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=tipoprecio.getfecha_hasta().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.MONTO+"=";
		sDescripcion+=tipoprecio.getmonto().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=tipoprecio.getesta_activo().toString()+",";
		sDescripcion+=TipoPrecioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoprecio.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPrecioDescripcion(TipoPrecio tipoprecio,String sValor) throws Exception {			
		if(tipoprecio !=null) {
			tipoprecio.setcodigo(sValor);;//tipopreciotipoprecio.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaPorFechaDesde")) {
			sNombreIndice="Tipo=  Por Fecha Desde";
		} else if(sNombreIndice.equals("BusquedaPorFechaHasta")) {
			sNombreIndice="Tipo=  Por Fecha Hasta";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceBusquedaPorFechaDesde(Date fecha_desde) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaHasta(Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPrecio(TipoPrecio tipoprecio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprecio.setcodigo(tipoprecio.getcodigo().trim());
		tipoprecio.setnombre(tipoprecio.getnombre().trim());
		tipoprecio.setdescripcion(tipoprecio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoPrecios(List<TipoPrecio> tipoprecios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrecio tipoprecio: tipoprecios) {
			tipoprecio.setcodigo(tipoprecio.getcodigo().trim());
			tipoprecio.setnombre(tipoprecio.getnombre().trim());
			tipoprecio.setdescripcion(tipoprecio.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrecio(TipoPrecio tipoprecio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprecio.getConCambioAuxiliar()) {
			tipoprecio.setIsDeleted(tipoprecio.getIsDeletedAuxiliar());	
			tipoprecio.setIsNew(tipoprecio.getIsNewAuxiliar());	
			tipoprecio.setIsChanged(tipoprecio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprecio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprecio.setIsDeletedAuxiliar(false);	
			tipoprecio.setIsNewAuxiliar(false);	
			tipoprecio.setIsChangedAuxiliar(false);
			
			tipoprecio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrecios(List<TipoPrecio> tipoprecios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPrecio tipoprecio : tipoprecios) {
			if(conAsignarBase && tipoprecio.getConCambioAuxiliar()) {
				tipoprecio.setIsDeleted(tipoprecio.getIsDeletedAuxiliar());	
				tipoprecio.setIsNew(tipoprecio.getIsNewAuxiliar());	
				tipoprecio.setIsChanged(tipoprecio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprecio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprecio.setIsDeletedAuxiliar(false);	
				tipoprecio.setIsNewAuxiliar(false);	
				tipoprecio.setIsChangedAuxiliar(false);
				
				tipoprecio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPrecio(TipoPrecio tipoprecio,Boolean conEnteros) throws Exception  {
		tipoprecio.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPrecios(List<TipoPrecio> tipoprecios,Boolean conEnteros) throws Exception  {
		
		for(TipoPrecio tipoprecio: tipoprecios) {
			tipoprecio.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPrecio(List<TipoPrecio> tipoprecios,TipoPrecio tipoprecioAux) throws Exception  {
		TipoPrecioConstantesFunciones.InicializarValoresTipoPrecio(tipoprecioAux,true);
		
		for(TipoPrecio tipoprecio: tipoprecios) {
			if(tipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipoprecioAux.setmonto(tipoprecioAux.getmonto()+tipoprecio.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPrecioConstantesFunciones.getArrayColumnasGlobalesTipoPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPrecioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPrecioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrecio> tipoprecios,TipoPrecio tipoprecio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrecio tipoprecioAux: tipoprecios) {
			if(tipoprecioAux!=null && tipoprecio!=null) {
				if((tipoprecioAux.getId()==null && tipoprecio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprecioAux.getId()!=null && tipoprecio.getId()!=null){
					if(tipoprecioAux.getId().equals(tipoprecio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrecio(List<TipoPrecio> tipoprecios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
	
		for(TipoPrecio tipoprecio: tipoprecios) {			
			if(tipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=tipoprecio.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoPrecioConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_ID, TipoPrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_VERSIONROW, TipoPrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_IDEMPRESA, TipoPrecioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_CODIGO, TipoPrecioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_NOMBRE, TipoPrecioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_FECHADESDE, TipoPrecioConstantesFunciones.FECHADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_FECHAHASTA, TipoPrecioConstantesFunciones.FECHAHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_MONTO, TipoPrecioConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_ESTAACTIVO, TipoPrecioConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrecioConstantesFunciones.LABEL_DESCRIPCION, TipoPrecioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.FECHADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.FECHAHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrecioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrecio() throws Exception  {
		return TipoPrecioConstantesFunciones.getTiposSeleccionarTipoPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrecio(Boolean conFk) throws Exception  {
		return TipoPrecioConstantesFunciones.getTiposSeleccionarTipoPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrecioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoPrecioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrecio(TipoPrecio tipoprecioAux) throws Exception {
		
			tipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprecioAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrecio(List<TipoPrecio> tipopreciosTemp) throws Exception {
		for(TipoPrecio tipoprecioAux:tipopreciosTemp) {
			
			tipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprecioAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrecioConstantesFunciones.getClassesRelationshipsOfTipoPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Precio.class));
				classes.add(new Classe(UtilidadTipoPrecio.class));
				classes.add(new Classe(PedidoPuntoVenta.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				classes.add(new Classe(DescuentoTipoPrecio.class));
				classes.add(new Classe(PoliticasCliente.class));
				classes.add(new Classe(Proforma.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(NotaCreditoSoli.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(ServicioCliente.class));
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(GuiaRemision.class));
				classes.add(new Classe(NotaCredito.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Precio.class)) {
						classes.add(new Classe(Precio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UtilidadTipoPrecio.class)) {
						classes.add(new Classe(UtilidadTipoPrecio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DescuentoTipoPrecio.class)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioCliente.class)) {
						classes.add(new Classe(ServicioCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCredito.class)) {
						classes.add(new Classe(NotaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrecioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(UtilidadTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UtilidadTipoPrecio.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(DescuentoTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(UtilidadTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UtilidadTipoPrecio.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(DescuentoTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
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
	public static void actualizarLista(TipoPrecio tipoprecio,List<TipoPrecio> tipoprecios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPrecio tipoprecioEncontrado=null;
			
			for(TipoPrecio tipoprecioLocal:tipoprecios) {
				if(tipoprecioLocal.getId().equals(tipoprecio.getId())) {
					tipoprecioEncontrado=tipoprecioLocal;
					
					tipoprecioLocal.setIsChanged(tipoprecio.getIsChanged());
					tipoprecioLocal.setIsNew(tipoprecio.getIsNew());
					tipoprecioLocal.setIsDeleted(tipoprecio.getIsDeleted());
					
					tipoprecioLocal.setGeneralEntityOriginal(tipoprecio.getGeneralEntityOriginal());
					
					tipoprecioLocal.setId(tipoprecio.getId());	
					tipoprecioLocal.setVersionRow(tipoprecio.getVersionRow());	
					tipoprecioLocal.setid_empresa(tipoprecio.getid_empresa());	
					tipoprecioLocal.setcodigo(tipoprecio.getcodigo());	
					tipoprecioLocal.setnombre(tipoprecio.getnombre());	
					tipoprecioLocal.setfecha_desde(tipoprecio.getfecha_desde());	
					tipoprecioLocal.setfecha_hasta(tipoprecio.getfecha_hasta());	
					tipoprecioLocal.setmonto(tipoprecio.getmonto());	
					tipoprecioLocal.setesta_activo(tipoprecio.getesta_activo());	
					tipoprecioLocal.setdescripcion(tipoprecio.getdescripcion());	
					
					
					tipoprecioLocal.setPrecios(tipoprecio.getPrecios());
					tipoprecioLocal.setPoliticasClientes(tipoprecio.getPoliticasClientes());
					tipoprecioLocal.setNotaCreditoSolis(tipoprecio.getNotaCreditoSolis());
					tipoprecioLocal.setGuiaRemisions(tipoprecio.getGuiaRemisions());
					tipoprecioLocal.setPedidoExpors(tipoprecio.getPedidoExpors());
					tipoprecioLocal.setFacturaPuntoVentas(tipoprecio.getFacturaPuntoVentas());
					tipoprecioLocal.setPedidoPuntoVentas(tipoprecio.getPedidoPuntoVentas());
					tipoprecioLocal.setUtilidadTipoPrecios(tipoprecio.getUtilidadTipoPrecios());
					tipoprecioLocal.setClientes(tipoprecio.getClientes());
					tipoprecioLocal.setServicioClientes(tipoprecio.getServicioClientes());
					tipoprecioLocal.setProformas(tipoprecio.getProformas());
					tipoprecioLocal.setDescuentoTipoPrecios(tipoprecio.getDescuentoTipoPrecios());
					tipoprecioLocal.setNotaCreditoPuntoVentas(tipoprecio.getNotaCreditoPuntoVentas());
					tipoprecioLocal.setParametroCarteraDefectos(tipoprecio.getParametroCarteraDefectos());
					tipoprecioLocal.setConsignacions(tipoprecio.getConsignacions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprecio.getIsDeleted()) {
				if(!existe) {
					tipoprecios.add(tipoprecio);
				}
			} else {
				if(tipoprecioEncontrado!=null && permiteQuitar)  {
					tipoprecios.remove(tipoprecioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPrecio tipoprecio,List<TipoPrecio> tipoprecios) throws Exception {
		try	{			
			for(TipoPrecio tipoprecioLocal:tipoprecios) {
				if(tipoprecioLocal.getId().equals(tipoprecio.getId())) {
					tipoprecioLocal.setIsSelected(tipoprecio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPrecio(List<TipoPrecio> tipopreciosAux) throws Exception {
		//this.tipopreciosAux=tipopreciosAux;
		
		for(TipoPrecio tipoprecioAux:tipopreciosAux) {
			if(tipoprecioAux.getIsChanged()) {
				tipoprecioAux.setIsChanged(false);
			}		
			
			if(tipoprecioAux.getIsNew()) {
				tipoprecioAux.setIsNew(false);
			}	
			
			if(tipoprecioAux.getIsDeleted()) {
				tipoprecioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPrecio(TipoPrecio tipoprecioAux) throws Exception {
		//this.tipoprecioAux=tipoprecioAux;
		
			if(tipoprecioAux.getIsChanged()) {
				tipoprecioAux.setIsChanged(false);
			}		
			
			if(tipoprecioAux.getIsNew()) {
				tipoprecioAux.setIsNew(false);
			}	
			
			if(tipoprecioAux.getIsDeleted()) {
				tipoprecioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPrecio tipoprecioAsignar,TipoPrecio tipoprecio) throws Exception {
		tipoprecioAsignar.setId(tipoprecio.getId());	
		tipoprecioAsignar.setVersionRow(tipoprecio.getVersionRow());	
		tipoprecioAsignar.setid_empresa(tipoprecio.getid_empresa());
		tipoprecioAsignar.setempresa_descripcion(tipoprecio.getempresa_descripcion());	
		tipoprecioAsignar.setcodigo(tipoprecio.getcodigo());	
		tipoprecioAsignar.setnombre(tipoprecio.getnombre());	
		tipoprecioAsignar.setfecha_desde(tipoprecio.getfecha_desde());	
		tipoprecioAsignar.setfecha_hasta(tipoprecio.getfecha_hasta());	
		tipoprecioAsignar.setmonto(tipoprecio.getmonto());	
		tipoprecioAsignar.setesta_activo(tipoprecio.getesta_activo());	
		tipoprecioAsignar.setdescripcion(tipoprecio.getdescripcion());	
	}
	
	public static void inicializarTipoPrecio(TipoPrecio tipoprecio) throws Exception {
		try {
				tipoprecio.setId(0L);	
					
				tipoprecio.setid_empresa(-1L);	
				tipoprecio.setcodigo("");	
				tipoprecio.setnombre("");	
				tipoprecio.setfecha_desde(new Date());	
				tipoprecio.setfecha_hasta(new Date());	
				tipoprecio.setmonto(0.0);	
				tipoprecio.setesta_activo(false);	
				tipoprecio.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrecioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPrecio(String sTipo,Row row,Workbook workbook,TipoPrecio tipoprecio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipoprecio.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprecio.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPrecio() {
		return this.sFinalQueryTipoPrecio;
	}
	
	public void setsFinalQueryTipoPrecio(String sFinalQueryTipoPrecio) {
		this.sFinalQueryTipoPrecio= sFinalQueryTipoPrecio;
	}
	
	public Border resaltarSeleccionarTipoPrecio=null;
	
	public Border setResaltarSeleccionarTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPrecio() {
		return this.resaltarSeleccionarTipoPrecio;
	}
	
	public void setResaltarSeleccionarTipoPrecio(Border borderResaltarSeleccionarTipoPrecio) {
		this.resaltarSeleccionarTipoPrecio= borderResaltarSeleccionarTipoPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPrecio=null;
	public Boolean mostraridTipoPrecio=true;
	public Boolean activaridTipoPrecio=true;

	public Border resaltarid_empresaTipoPrecio=null;
	public Boolean mostrarid_empresaTipoPrecio=true;
	public Boolean activarid_empresaTipoPrecio=true;
	public Boolean cargarid_empresaTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPrecio=false;//ConEventDepend=true

	public Border resaltarcodigoTipoPrecio=null;
	public Boolean mostrarcodigoTipoPrecio=true;
	public Boolean activarcodigoTipoPrecio=true;

	public Border resaltarnombreTipoPrecio=null;
	public Boolean mostrarnombreTipoPrecio=true;
	public Boolean activarnombreTipoPrecio=true;

	public Border resaltarfecha_desdeTipoPrecio=null;
	public Boolean mostrarfecha_desdeTipoPrecio=true;
	public Boolean activarfecha_desdeTipoPrecio=true;

	public Border resaltarfecha_hastaTipoPrecio=null;
	public Boolean mostrarfecha_hastaTipoPrecio=true;
	public Boolean activarfecha_hastaTipoPrecio=true;

	public Border resaltarmontoTipoPrecio=null;
	public Boolean mostrarmontoTipoPrecio=true;
	public Boolean activarmontoTipoPrecio=true;

	public Border resaltaresta_activoTipoPrecio=null;
	public Boolean mostraresta_activoTipoPrecio=true;
	public Boolean activaresta_activoTipoPrecio=true;

	public Border resaltardescripcionTipoPrecio=null;
	public Boolean mostrardescripcionTipoPrecio=true;
	public Boolean activardescripcionTipoPrecio=true;

	
	

	public Border setResaltaridTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltaridTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPrecio() {
		return this.resaltaridTipoPrecio;
	}

	public void setResaltaridTipoPrecio(Border borderResaltar) {
		this.resaltaridTipoPrecio= borderResaltar;
	}

	public Boolean getMostraridTipoPrecio() {
		return this.mostraridTipoPrecio;
	}

	public void setMostraridTipoPrecio(Boolean mostraridTipoPrecio) {
		this.mostraridTipoPrecio= mostraridTipoPrecio;
	}

	public Boolean getActivaridTipoPrecio() {
		return this.activaridTipoPrecio;
	}

	public void setActivaridTipoPrecio(Boolean activaridTipoPrecio) {
		this.activaridTipoPrecio= activaridTipoPrecio;
	}

	public Border setResaltarid_empresaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPrecio() {
		return this.resaltarid_empresaTipoPrecio;
	}

	public void setResaltarid_empresaTipoPrecio(Border borderResaltar) {
		this.resaltarid_empresaTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPrecio() {
		return this.mostrarid_empresaTipoPrecio;
	}

	public void setMostrarid_empresaTipoPrecio(Boolean mostrarid_empresaTipoPrecio) {
		this.mostrarid_empresaTipoPrecio= mostrarid_empresaTipoPrecio;
	}

	public Boolean getActivarid_empresaTipoPrecio() {
		return this.activarid_empresaTipoPrecio;
	}

	public void setActivarid_empresaTipoPrecio(Boolean activarid_empresaTipoPrecio) {
		this.activarid_empresaTipoPrecio= activarid_empresaTipoPrecio;
	}

	public Boolean getCargarid_empresaTipoPrecio() {
		return this.cargarid_empresaTipoPrecio;
	}

	public void setCargarid_empresaTipoPrecio(Boolean cargarid_empresaTipoPrecio) {
		this.cargarid_empresaTipoPrecio= cargarid_empresaTipoPrecio;
	}

	public Border setResaltarcodigoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPrecio() {
		return this.resaltarcodigoTipoPrecio;
	}

	public void setResaltarcodigoTipoPrecio(Border borderResaltar) {
		this.resaltarcodigoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPrecio() {
		return this.mostrarcodigoTipoPrecio;
	}

	public void setMostrarcodigoTipoPrecio(Boolean mostrarcodigoTipoPrecio) {
		this.mostrarcodigoTipoPrecio= mostrarcodigoTipoPrecio;
	}

	public Boolean getActivarcodigoTipoPrecio() {
		return this.activarcodigoTipoPrecio;
	}

	public void setActivarcodigoTipoPrecio(Boolean activarcodigoTipoPrecio) {
		this.activarcodigoTipoPrecio= activarcodigoTipoPrecio;
	}

	public Border setResaltarnombreTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPrecio() {
		return this.resaltarnombreTipoPrecio;
	}

	public void setResaltarnombreTipoPrecio(Border borderResaltar) {
		this.resaltarnombreTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPrecio() {
		return this.mostrarnombreTipoPrecio;
	}

	public void setMostrarnombreTipoPrecio(Boolean mostrarnombreTipoPrecio) {
		this.mostrarnombreTipoPrecio= mostrarnombreTipoPrecio;
	}

	public Boolean getActivarnombreTipoPrecio() {
		return this.activarnombreTipoPrecio;
	}

	public void setActivarnombreTipoPrecio(Boolean activarnombreTipoPrecio) {
		this.activarnombreTipoPrecio= activarnombreTipoPrecio;
	}

	public Border setResaltarfecha_desdeTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeTipoPrecio() {
		return this.resaltarfecha_desdeTipoPrecio;
	}

	public void setResaltarfecha_desdeTipoPrecio(Border borderResaltar) {
		this.resaltarfecha_desdeTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeTipoPrecio() {
		return this.mostrarfecha_desdeTipoPrecio;
	}

	public void setMostrarfecha_desdeTipoPrecio(Boolean mostrarfecha_desdeTipoPrecio) {
		this.mostrarfecha_desdeTipoPrecio= mostrarfecha_desdeTipoPrecio;
	}

	public Boolean getActivarfecha_desdeTipoPrecio() {
		return this.activarfecha_desdeTipoPrecio;
	}

	public void setActivarfecha_desdeTipoPrecio(Boolean activarfecha_desdeTipoPrecio) {
		this.activarfecha_desdeTipoPrecio= activarfecha_desdeTipoPrecio;
	}

	public Border setResaltarfecha_hastaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaTipoPrecio() {
		return this.resaltarfecha_hastaTipoPrecio;
	}

	public void setResaltarfecha_hastaTipoPrecio(Border borderResaltar) {
		this.resaltarfecha_hastaTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaTipoPrecio() {
		return this.mostrarfecha_hastaTipoPrecio;
	}

	public void setMostrarfecha_hastaTipoPrecio(Boolean mostrarfecha_hastaTipoPrecio) {
		this.mostrarfecha_hastaTipoPrecio= mostrarfecha_hastaTipoPrecio;
	}

	public Boolean getActivarfecha_hastaTipoPrecio() {
		return this.activarfecha_hastaTipoPrecio;
	}

	public void setActivarfecha_hastaTipoPrecio(Boolean activarfecha_hastaTipoPrecio) {
		this.activarfecha_hastaTipoPrecio= activarfecha_hastaTipoPrecio;
	}

	public Border setResaltarmontoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarmontoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoTipoPrecio() {
		return this.resaltarmontoTipoPrecio;
	}

	public void setResaltarmontoTipoPrecio(Border borderResaltar) {
		this.resaltarmontoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarmontoTipoPrecio() {
		return this.mostrarmontoTipoPrecio;
	}

	public void setMostrarmontoTipoPrecio(Boolean mostrarmontoTipoPrecio) {
		this.mostrarmontoTipoPrecio= mostrarmontoTipoPrecio;
	}

	public Boolean getActivarmontoTipoPrecio() {
		return this.activarmontoTipoPrecio;
	}

	public void setActivarmontoTipoPrecio(Boolean activarmontoTipoPrecio) {
		this.activarmontoTipoPrecio= activarmontoTipoPrecio;
	}

	public Border setResaltaresta_activoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltaresta_activoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoTipoPrecio() {
		return this.resaltaresta_activoTipoPrecio;
	}

	public void setResaltaresta_activoTipoPrecio(Border borderResaltar) {
		this.resaltaresta_activoTipoPrecio= borderResaltar;
	}

	public Boolean getMostraresta_activoTipoPrecio() {
		return this.mostraresta_activoTipoPrecio;
	}

	public void setMostraresta_activoTipoPrecio(Boolean mostraresta_activoTipoPrecio) {
		this.mostraresta_activoTipoPrecio= mostraresta_activoTipoPrecio;
	}

	public Boolean getActivaresta_activoTipoPrecio() {
		return this.activaresta_activoTipoPrecio;
	}

	public void setActivaresta_activoTipoPrecio(Boolean activaresta_activoTipoPrecio) {
		this.activaresta_activoTipoPrecio= activaresta_activoTipoPrecio;
	}

	public Border setResaltardescripcionTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoPrecio() {
		return this.resaltardescripcionTipoPrecio;
	}

	public void setResaltardescripcionTipoPrecio(Border borderResaltar) {
		this.resaltardescripcionTipoPrecio= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoPrecio() {
		return this.mostrardescripcionTipoPrecio;
	}

	public void setMostrardescripcionTipoPrecio(Boolean mostrardescripcionTipoPrecio) {
		this.mostrardescripcionTipoPrecio= mostrardescripcionTipoPrecio;
	}

	public Boolean getActivardescripcionTipoPrecio() {
		return this.activardescripcionTipoPrecio;
	}

	public void setActivardescripcionTipoPrecio(Boolean activardescripcionTipoPrecio) {
		this.activardescripcionTipoPrecio= activardescripcionTipoPrecio;
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
		
		
		this.setMostraridTipoPrecio(esInicial);
		this.setMostrarid_empresaTipoPrecio(esInicial);
		this.setMostrarcodigoTipoPrecio(esInicial);
		this.setMostrarnombreTipoPrecio(esInicial);
		this.setMostrarfecha_desdeTipoPrecio(esInicial);
		this.setMostrarfecha_hastaTipoPrecio(esInicial);
		this.setMostrarmontoTipoPrecio(esInicial);
		this.setMostraresta_activoTipoPrecio(esInicial);
		this.setMostrardescripcionTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ID)) {
				this.setMostraridTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.MONTO)) {
				this.setMostrarmontoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoPrecio(esAsigna);
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
		
		
		this.setActivaridTipoPrecio(esInicial);
		this.setActivarid_empresaTipoPrecio(esInicial);
		this.setActivarcodigoTipoPrecio(esInicial);
		this.setActivarnombreTipoPrecio(esInicial);
		this.setActivarfecha_desdeTipoPrecio(esInicial);
		this.setActivarfecha_hastaTipoPrecio(esInicial);
		this.setActivarmontoTipoPrecio(esInicial);
		this.setActivaresta_activoTipoPrecio(esInicial);
		this.setActivardescripcionTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ID)) {
				this.setActivaridTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.MONTO)) {
				this.setActivarmontoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPrecio(esInicial);
		this.setResaltarid_empresaTipoPrecio(esInicial);
		this.setResaltarcodigoTipoPrecio(esInicial);
		this.setResaltarnombreTipoPrecio(esInicial);
		this.setResaltarfecha_desdeTipoPrecio(esInicial);
		this.setResaltarfecha_hastaTipoPrecio(esInicial);
		this.setResaltarmontoTipoPrecio(esInicial);
		this.setResaltaresta_activoTipoPrecio(esInicial);
		this.setResaltardescripcionTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ID)) {
				this.setResaltaridTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.MONTO)) {
				this.setResaltarmontoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPrecioTipoPrecio=null;

	public Border getResaltarPrecioTipoPrecio() {
		return this.resaltarPrecioTipoPrecio;
	}

	public void setResaltarPrecioTipoPrecio(Border borderResaltarPrecio) {
		if(borderResaltarPrecio!=null) {
			this.resaltarPrecioTipoPrecio= borderResaltarPrecio;
		}
	}

	public Border setResaltarPrecioTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarPrecio);
			
		this.resaltarPrecioTipoPrecio= borderResaltarPrecio;

		 return borderResaltarPrecio;
	}



	public Boolean mostrarPrecioTipoPrecio=true;

	public Boolean getMostrarPrecioTipoPrecio() {
		return this.mostrarPrecioTipoPrecio;
	}

	public void setMostrarPrecioTipoPrecio(Boolean visibilidadResaltarPrecio) {
		this.mostrarPrecioTipoPrecio= visibilidadResaltarPrecio;
	}



	public Boolean activarPrecioTipoPrecio=true;

	public Boolean gethabilitarResaltarPrecioTipoPrecio() {
		return this.activarPrecioTipoPrecio;
	}

	public void setActivarPrecioTipoPrecio(Boolean habilitarResaltarPrecio) {
		this.activarPrecioTipoPrecio= habilitarResaltarPrecio;
	}


	public Border resaltarUtilidadTipoPrecioTipoPrecio=null;

	public Border getResaltarUtilidadTipoPrecioTipoPrecio() {
		return this.resaltarUtilidadTipoPrecioTipoPrecio;
	}

	public void setResaltarUtilidadTipoPrecioTipoPrecio(Border borderResaltarUtilidadTipoPrecio) {
		if(borderResaltarUtilidadTipoPrecio!=null) {
			this.resaltarUtilidadTipoPrecioTipoPrecio= borderResaltarUtilidadTipoPrecio;
		}
	}

	public Border setResaltarUtilidadTipoPrecioTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarUtilidadTipoPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarUtilidadTipoPrecio);
			
		this.resaltarUtilidadTipoPrecioTipoPrecio= borderResaltarUtilidadTipoPrecio;

		 return borderResaltarUtilidadTipoPrecio;
	}



	public Boolean mostrarUtilidadTipoPrecioTipoPrecio=true;

	public Boolean getMostrarUtilidadTipoPrecioTipoPrecio() {
		return this.mostrarUtilidadTipoPrecioTipoPrecio;
	}

	public void setMostrarUtilidadTipoPrecioTipoPrecio(Boolean visibilidadResaltarUtilidadTipoPrecio) {
		this.mostrarUtilidadTipoPrecioTipoPrecio= visibilidadResaltarUtilidadTipoPrecio;
	}



	public Boolean activarUtilidadTipoPrecioTipoPrecio=true;

	public Boolean gethabilitarResaltarUtilidadTipoPrecioTipoPrecio() {
		return this.activarUtilidadTipoPrecioTipoPrecio;
	}

	public void setActivarUtilidadTipoPrecioTipoPrecio(Boolean habilitarResaltarUtilidadTipoPrecio) {
		this.activarUtilidadTipoPrecioTipoPrecio= habilitarResaltarUtilidadTipoPrecio;
	}


	public Border resaltarPedidoPuntoVentaTipoPrecio=null;

	public Border getResaltarPedidoPuntoVentaTipoPrecio() {
		return this.resaltarPedidoPuntoVentaTipoPrecio;
	}

	public void setResaltarPedidoPuntoVentaTipoPrecio(Border borderResaltarPedidoPuntoVenta) {
		if(borderResaltarPedidoPuntoVenta!=null) {
			this.resaltarPedidoPuntoVentaTipoPrecio= borderResaltarPedidoPuntoVenta;
		}
	}

	public Border setResaltarPedidoPuntoVentaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarPedidoPuntoVenta);
			
		this.resaltarPedidoPuntoVentaTipoPrecio= borderResaltarPedidoPuntoVenta;

		 return borderResaltarPedidoPuntoVenta;
	}



	public Boolean mostrarPedidoPuntoVentaTipoPrecio=true;

	public Boolean getMostrarPedidoPuntoVentaTipoPrecio() {
		return this.mostrarPedidoPuntoVentaTipoPrecio;
	}

	public void setMostrarPedidoPuntoVentaTipoPrecio(Boolean visibilidadResaltarPedidoPuntoVenta) {
		this.mostrarPedidoPuntoVentaTipoPrecio= visibilidadResaltarPedidoPuntoVenta;
	}



	public Boolean activarPedidoPuntoVentaTipoPrecio=true;

	public Boolean gethabilitarResaltarPedidoPuntoVentaTipoPrecio() {
		return this.activarPedidoPuntoVentaTipoPrecio;
	}

	public void setActivarPedidoPuntoVentaTipoPrecio(Boolean habilitarResaltarPedidoPuntoVenta) {
		this.activarPedidoPuntoVentaTipoPrecio= habilitarResaltarPedidoPuntoVenta;
	}


	public Border resaltarParametroCarteraDefectoTipoPrecio=null;

	public Border getResaltarParametroCarteraDefectoTipoPrecio() {
		return this.resaltarParametroCarteraDefectoTipoPrecio;
	}

	public void setResaltarParametroCarteraDefectoTipoPrecio(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoTipoPrecio= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoTipoPrecio= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoTipoPrecio=true;

	public Boolean getMostrarParametroCarteraDefectoTipoPrecio() {
		return this.mostrarParametroCarteraDefectoTipoPrecio;
	}

	public void setMostrarParametroCarteraDefectoTipoPrecio(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoTipoPrecio= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoTipoPrecio=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoTipoPrecio() {
		return this.activarParametroCarteraDefectoTipoPrecio;
	}

	public void setActivarParametroCarteraDefectoTipoPrecio(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoTipoPrecio= habilitarResaltarParametroCarteraDefecto;
	}


	public Border resaltarDescuentoTipoPrecioTipoPrecio=null;

	public Border getResaltarDescuentoTipoPrecioTipoPrecio() {
		return this.resaltarDescuentoTipoPrecioTipoPrecio;
	}

	public void setResaltarDescuentoTipoPrecioTipoPrecio(Border borderResaltarDescuentoTipoPrecio) {
		if(borderResaltarDescuentoTipoPrecio!=null) {
			this.resaltarDescuentoTipoPrecioTipoPrecio= borderResaltarDescuentoTipoPrecio;
		}
	}

	public Border setResaltarDescuentoTipoPrecioTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarDescuentoTipoPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarDescuentoTipoPrecio);
			
		this.resaltarDescuentoTipoPrecioTipoPrecio= borderResaltarDescuentoTipoPrecio;

		 return borderResaltarDescuentoTipoPrecio;
	}



	public Boolean mostrarDescuentoTipoPrecioTipoPrecio=true;

	public Boolean getMostrarDescuentoTipoPrecioTipoPrecio() {
		return this.mostrarDescuentoTipoPrecioTipoPrecio;
	}

	public void setMostrarDescuentoTipoPrecioTipoPrecio(Boolean visibilidadResaltarDescuentoTipoPrecio) {
		this.mostrarDescuentoTipoPrecioTipoPrecio= visibilidadResaltarDescuentoTipoPrecio;
	}



	public Boolean activarDescuentoTipoPrecioTipoPrecio=true;

	public Boolean gethabilitarResaltarDescuentoTipoPrecioTipoPrecio() {
		return this.activarDescuentoTipoPrecioTipoPrecio;
	}

	public void setActivarDescuentoTipoPrecioTipoPrecio(Boolean habilitarResaltarDescuentoTipoPrecio) {
		this.activarDescuentoTipoPrecioTipoPrecio= habilitarResaltarDescuentoTipoPrecio;
	}


	public Border resaltarPoliticasClienteTipoPrecio=null;

	public Border getResaltarPoliticasClienteTipoPrecio() {
		return this.resaltarPoliticasClienteTipoPrecio;
	}

	public void setResaltarPoliticasClienteTipoPrecio(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteTipoPrecio= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteTipoPrecio= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteTipoPrecio=true;

	public Boolean getMostrarPoliticasClienteTipoPrecio() {
		return this.mostrarPoliticasClienteTipoPrecio;
	}

	public void setMostrarPoliticasClienteTipoPrecio(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteTipoPrecio= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteTipoPrecio=true;

	public Boolean gethabilitarResaltarPoliticasClienteTipoPrecio() {
		return this.activarPoliticasClienteTipoPrecio;
	}

	public void setActivarPoliticasClienteTipoPrecio(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteTipoPrecio= habilitarResaltarPoliticasCliente;
	}


	public Border resaltarProformaTipoPrecio=null;

	public Border getResaltarProformaTipoPrecio() {
		return this.resaltarProformaTipoPrecio;
	}

	public void setResaltarProformaTipoPrecio(Border borderResaltarProforma) {
		if(borderResaltarProforma!=null) {
			this.resaltarProformaTipoPrecio= borderResaltarProforma;
		}
	}

	public Border setResaltarProformaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarProforma);
			
		this.resaltarProformaTipoPrecio= borderResaltarProforma;

		 return borderResaltarProforma;
	}



	public Boolean mostrarProformaTipoPrecio=true;

	public Boolean getMostrarProformaTipoPrecio() {
		return this.mostrarProformaTipoPrecio;
	}

	public void setMostrarProformaTipoPrecio(Boolean visibilidadResaltarProforma) {
		this.mostrarProformaTipoPrecio= visibilidadResaltarProforma;
	}



	public Boolean activarProformaTipoPrecio=true;

	public Boolean gethabilitarResaltarProformaTipoPrecio() {
		return this.activarProformaTipoPrecio;
	}

	public void setActivarProformaTipoPrecio(Boolean habilitarResaltarProforma) {
		this.activarProformaTipoPrecio= habilitarResaltarProforma;
	}


	public Border resaltarNotaCreditoSoliTipoPrecio=null;

	public Border getResaltarNotaCreditoSoliTipoPrecio() {
		return this.resaltarNotaCreditoSoliTipoPrecio;
	}

	public void setResaltarNotaCreditoSoliTipoPrecio(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliTipoPrecio= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliTipoPrecio= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliTipoPrecio=true;

	public Boolean getMostrarNotaCreditoSoliTipoPrecio() {
		return this.mostrarNotaCreditoSoliTipoPrecio;
	}

	public void setMostrarNotaCreditoSoliTipoPrecio(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliTipoPrecio= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliTipoPrecio=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliTipoPrecio() {
		return this.activarNotaCreditoSoliTipoPrecio;
	}

	public void setActivarNotaCreditoSoliTipoPrecio(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliTipoPrecio= habilitarResaltarNotaCreditoSoli;
	}


	public Border resaltarConsignacionTipoPrecio=null;

	public Border getResaltarConsignacionTipoPrecio() {
		return this.resaltarConsignacionTipoPrecio;
	}

	public void setResaltarConsignacionTipoPrecio(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionTipoPrecio= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionTipoPrecio= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionTipoPrecio=true;

	public Boolean getMostrarConsignacionTipoPrecio() {
		return this.mostrarConsignacionTipoPrecio;
	}

	public void setMostrarConsignacionTipoPrecio(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionTipoPrecio= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionTipoPrecio=true;

	public Boolean gethabilitarResaltarConsignacionTipoPrecio() {
		return this.activarConsignacionTipoPrecio;
	}

	public void setActivarConsignacionTipoPrecio(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionTipoPrecio= habilitarResaltarConsignacion;
	}


	public Border resaltarPedidoExporTipoPrecio=null;

	public Border getResaltarPedidoExporTipoPrecio() {
		return this.resaltarPedidoExporTipoPrecio;
	}

	public void setResaltarPedidoExporTipoPrecio(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporTipoPrecio= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporTipoPrecio= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporTipoPrecio=true;

	public Boolean getMostrarPedidoExporTipoPrecio() {
		return this.mostrarPedidoExporTipoPrecio;
	}

	public void setMostrarPedidoExporTipoPrecio(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporTipoPrecio= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporTipoPrecio=true;

	public Boolean gethabilitarResaltarPedidoExporTipoPrecio() {
		return this.activarPedidoExporTipoPrecio;
	}

	public void setActivarPedidoExporTipoPrecio(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporTipoPrecio= habilitarResaltarPedidoExpor;
	}


	public Border resaltarServicioClienteTipoPrecio=null;

	public Border getResaltarServicioClienteTipoPrecio() {
		return this.resaltarServicioClienteTipoPrecio;
	}

	public void setResaltarServicioClienteTipoPrecio(Border borderResaltarServicioCliente) {
		if(borderResaltarServicioCliente!=null) {
			this.resaltarServicioClienteTipoPrecio= borderResaltarServicioCliente;
		}
	}

	public Border setResaltarServicioClienteTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarServicioCliente);
			
		this.resaltarServicioClienteTipoPrecio= borderResaltarServicioCliente;

		 return borderResaltarServicioCliente;
	}



	public Boolean mostrarServicioClienteTipoPrecio=true;

	public Boolean getMostrarServicioClienteTipoPrecio() {
		return this.mostrarServicioClienteTipoPrecio;
	}

	public void setMostrarServicioClienteTipoPrecio(Boolean visibilidadResaltarServicioCliente) {
		this.mostrarServicioClienteTipoPrecio= visibilidadResaltarServicioCliente;
	}



	public Boolean activarServicioClienteTipoPrecio=true;

	public Boolean gethabilitarResaltarServicioClienteTipoPrecio() {
		return this.activarServicioClienteTipoPrecio;
	}

	public void setActivarServicioClienteTipoPrecio(Boolean habilitarResaltarServicioCliente) {
		this.activarServicioClienteTipoPrecio= habilitarResaltarServicioCliente;
	}


	public Border resaltarFacturaPuntoVentaTipoPrecio=null;

	public Border getResaltarFacturaPuntoVentaTipoPrecio() {
		return this.resaltarFacturaPuntoVentaTipoPrecio;
	}

	public void setResaltarFacturaPuntoVentaTipoPrecio(Border borderResaltarFacturaPuntoVenta) {
		if(borderResaltarFacturaPuntoVenta!=null) {
			this.resaltarFacturaPuntoVentaTipoPrecio= borderResaltarFacturaPuntoVenta;
		}
	}

	public Border setResaltarFacturaPuntoVentaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarFacturaPuntoVenta);
			
		this.resaltarFacturaPuntoVentaTipoPrecio= borderResaltarFacturaPuntoVenta;

		 return borderResaltarFacturaPuntoVenta;
	}



	public Boolean mostrarFacturaPuntoVentaTipoPrecio=true;

	public Boolean getMostrarFacturaPuntoVentaTipoPrecio() {
		return this.mostrarFacturaPuntoVentaTipoPrecio;
	}

	public void setMostrarFacturaPuntoVentaTipoPrecio(Boolean visibilidadResaltarFacturaPuntoVenta) {
		this.mostrarFacturaPuntoVentaTipoPrecio= visibilidadResaltarFacturaPuntoVenta;
	}



	public Boolean activarFacturaPuntoVentaTipoPrecio=true;

	public Boolean gethabilitarResaltarFacturaPuntoVentaTipoPrecio() {
		return this.activarFacturaPuntoVentaTipoPrecio;
	}

	public void setActivarFacturaPuntoVentaTipoPrecio(Boolean habilitarResaltarFacturaPuntoVenta) {
		this.activarFacturaPuntoVentaTipoPrecio= habilitarResaltarFacturaPuntoVenta;
	}


	public Border resaltarGuiaRemisionTipoPrecio=null;

	public Border getResaltarGuiaRemisionTipoPrecio() {
		return this.resaltarGuiaRemisionTipoPrecio;
	}

	public void setResaltarGuiaRemisionTipoPrecio(Border borderResaltarGuiaRemision) {
		if(borderResaltarGuiaRemision!=null) {
			this.resaltarGuiaRemisionTipoPrecio= borderResaltarGuiaRemision;
		}
	}

	public Border setResaltarGuiaRemisionTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarGuiaRemision=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarGuiaRemision);
			
		this.resaltarGuiaRemisionTipoPrecio= borderResaltarGuiaRemision;

		 return borderResaltarGuiaRemision;
	}



	public Boolean mostrarGuiaRemisionTipoPrecio=true;

	public Boolean getMostrarGuiaRemisionTipoPrecio() {
		return this.mostrarGuiaRemisionTipoPrecio;
	}

	public void setMostrarGuiaRemisionTipoPrecio(Boolean visibilidadResaltarGuiaRemision) {
		this.mostrarGuiaRemisionTipoPrecio= visibilidadResaltarGuiaRemision;
	}



	public Boolean activarGuiaRemisionTipoPrecio=true;

	public Boolean gethabilitarResaltarGuiaRemisionTipoPrecio() {
		return this.activarGuiaRemisionTipoPrecio;
	}

	public void setActivarGuiaRemisionTipoPrecio(Boolean habilitarResaltarGuiaRemision) {
		this.activarGuiaRemisionTipoPrecio= habilitarResaltarGuiaRemision;
	}


	public Border resaltarClienteTipoPrecio=null;

	public Border getResaltarClienteTipoPrecio() {
		return this.resaltarClienteTipoPrecio;
	}

	public void setResaltarClienteTipoPrecio(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoPrecio= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoPrecio= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoPrecio=true;

	public Boolean getMostrarClienteTipoPrecio() {
		return this.mostrarClienteTipoPrecio;
	}

	public void setMostrarClienteTipoPrecio(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoPrecio= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoPrecio=true;

	public Boolean gethabilitarResaltarClienteTipoPrecio() {
		return this.activarClienteTipoPrecio;
	}

	public void setActivarClienteTipoPrecio(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoPrecio= habilitarResaltarCliente;
	}


	public Border resaltarNotaCreditoPuntoVentaTipoPrecio=null;

	public Border getResaltarNotaCreditoPuntoVentaTipoPrecio() {
		return this.resaltarNotaCreditoPuntoVentaTipoPrecio;
	}

	public void setResaltarNotaCreditoPuntoVentaTipoPrecio(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaTipoPrecio= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprecioBeanSwingJInternalFrame.jTtoolBarTipoPrecio.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaTipoPrecio= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaTipoPrecio=true;

	public Boolean getMostrarNotaCreditoPuntoVentaTipoPrecio() {
		return this.mostrarNotaCreditoPuntoVentaTipoPrecio;
	}

	public void setMostrarNotaCreditoPuntoVentaTipoPrecio(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaTipoPrecio= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaTipoPrecio=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaTipoPrecio() {
		return this.activarNotaCreditoPuntoVentaTipoPrecio;
	}

	public void setActivarNotaCreditoPuntoVentaTipoPrecio(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaTipoPrecio= habilitarResaltarNotaCreditoPuntoVenta;
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

		this.setMostrarPrecioTipoPrecio(esInicial);
		this.setMostrarUtilidadTipoPrecioTipoPrecio(esInicial);
		this.setMostrarPedidoPuntoVentaTipoPrecio(esInicial);
		this.setMostrarParametroCarteraDefectoTipoPrecio(esInicial);
		this.setMostrarDescuentoTipoPrecioTipoPrecio(esInicial);
		this.setMostrarPoliticasClienteTipoPrecio(esInicial);
		this.setMostrarProformaTipoPrecio(esInicial);
		this.setMostrarNotaCreditoSoliTipoPrecio(esInicial);
		this.setMostrarConsignacionTipoPrecio(esInicial);
		this.setMostrarPedidoExporTipoPrecio(esInicial);
		this.setMostrarServicioClienteTipoPrecio(esInicial);
		this.setMostrarFacturaPuntoVentaTipoPrecio(esInicial);
		this.setMostrarGuiaRemisionTipoPrecio(esInicial);
		this.setMostrarClienteTipoPrecio(esInicial);
		this.setMostrarNotaCreditoPuntoVentaTipoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setMostrarPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(UtilidadTipoPrecio.class)) {
				this.setMostrarUtilidadTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setMostrarPedidoPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setMostrarDescuentoTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setMostrarProformaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setMostrarServicioClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setMostrarFacturaPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setMostrarGuiaRemisionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaTipoPrecio(esAsigna);
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

		this.setActivarPrecioTipoPrecio(esInicial);
		this.setActivarUtilidadTipoPrecioTipoPrecio(esInicial);
		this.setActivarPedidoPuntoVentaTipoPrecio(esInicial);
		this.setActivarParametroCarteraDefectoTipoPrecio(esInicial);
		this.setActivarDescuentoTipoPrecioTipoPrecio(esInicial);
		this.setActivarPoliticasClienteTipoPrecio(esInicial);
		this.setActivarProformaTipoPrecio(esInicial);
		this.setActivarNotaCreditoSoliTipoPrecio(esInicial);
		this.setActivarConsignacionTipoPrecio(esInicial);
		this.setActivarPedidoExporTipoPrecio(esInicial);
		this.setActivarServicioClienteTipoPrecio(esInicial);
		this.setActivarFacturaPuntoVentaTipoPrecio(esInicial);
		this.setActivarGuiaRemisionTipoPrecio(esInicial);
		this.setActivarClienteTipoPrecio(esInicial);
		this.setActivarNotaCreditoPuntoVentaTipoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setActivarPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(UtilidadTipoPrecio.class)) {
				this.setActivarUtilidadTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setActivarPedidoPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setActivarDescuentoTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setActivarProformaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setActivarServicioClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setActivarFacturaPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setActivarGuiaRemisionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaTipoPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPrecioTipoPrecio(esInicial);
		this.setResaltarUtilidadTipoPrecioTipoPrecio(esInicial);
		this.setResaltarPedidoPuntoVentaTipoPrecio(esInicial);
		this.setResaltarParametroCarteraDefectoTipoPrecio(esInicial);
		this.setResaltarDescuentoTipoPrecioTipoPrecio(esInicial);
		this.setResaltarPoliticasClienteTipoPrecio(esInicial);
		this.setResaltarProformaTipoPrecio(esInicial);
		this.setResaltarNotaCreditoSoliTipoPrecio(esInicial);
		this.setResaltarConsignacionTipoPrecio(esInicial);
		this.setResaltarPedidoExporTipoPrecio(esInicial);
		this.setResaltarServicioClienteTipoPrecio(esInicial);
		this.setResaltarFacturaPuntoVentaTipoPrecio(esInicial);
		this.setResaltarGuiaRemisionTipoPrecio(esInicial);
		this.setResaltarClienteTipoPrecio(esInicial);
		this.setResaltarNotaCreditoPuntoVentaTipoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setResaltarPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(UtilidadTipoPrecio.class)) {
				this.setResaltarUtilidadTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setResaltarPedidoPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setResaltarDescuentoTipoPrecioTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setResaltarProformaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setResaltarServicioClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setResaltarFacturaPuntoVentaTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setResaltarGuiaRemisionTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaTipoPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoPrecio=true;

	public Boolean getMostrarBusquedaPorCodigoTipoPrecio() {
		return this.mostrarBusquedaPorCodigoTipoPrecio;
	}

	public void setMostrarBusquedaPorCodigoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaDesdeTipoPrecio=true;

	public Boolean getMostrarBusquedaPorFechaDesdeTipoPrecio() {
		return this.mostrarBusquedaPorFechaDesdeTipoPrecio;
	}

	public void setMostrarBusquedaPorFechaDesdeTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaDesdeTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaHastaTipoPrecio=true;

	public Boolean getMostrarBusquedaPorFechaHastaTipoPrecio() {
		return this.mostrarBusquedaPorFechaHastaTipoPrecio;
	}

	public void setMostrarBusquedaPorFechaHastaTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaHastaTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoPrecio=true;

	public Boolean getMostrarBusquedaPorNombreTipoPrecio() {
		return this.mostrarBusquedaPorNombreTipoPrecio;
	}

	public void setMostrarBusquedaPorNombreTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoPrecio=true;

	public Boolean getMostrarFK_IdEmpresaTipoPrecio() {
		return this.mostrarFK_IdEmpresaTipoPrecio;
	}

	public void setMostrarFK_IdEmpresaTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPrecio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoPrecio=true;

	public Boolean getActivarBusquedaPorCodigoTipoPrecio() {
		return this.activarBusquedaPorCodigoTipoPrecio;
	}

	public void setActivarBusquedaPorCodigoTipoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoPrecio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaDesdeTipoPrecio=true;

	public Boolean getActivarBusquedaPorFechaDesdeTipoPrecio() {
		return this.activarBusquedaPorFechaDesdeTipoPrecio;
	}

	public void setActivarBusquedaPorFechaDesdeTipoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaDesdeTipoPrecio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaHastaTipoPrecio=true;

	public Boolean getActivarBusquedaPorFechaHastaTipoPrecio() {
		return this.activarBusquedaPorFechaHastaTipoPrecio;
	}

	public void setActivarBusquedaPorFechaHastaTipoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaHastaTipoPrecio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoPrecio=true;

	public Boolean getActivarBusquedaPorNombreTipoPrecio() {
		return this.activarBusquedaPorNombreTipoPrecio;
	}

	public void setActivarBusquedaPorNombreTipoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoPrecio=true;

	public Boolean getActivarFK_IdEmpresaTipoPrecio() {
		return this.activarFK_IdEmpresaTipoPrecio;
	}

	public void setActivarFK_IdEmpresaTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPrecio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoPrecio=null;

	public Border getResaltarBusquedaPorCodigoTipoPrecio() {
		return this.resaltarBusquedaPorCodigoTipoPrecio;
	}

	public void setResaltarBusquedaPorCodigoTipoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoPrecio= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaDesdeTipoPrecio=null;

	public Border getResaltarBusquedaPorFechaDesdeTipoPrecio() {
		return this.resaltarBusquedaPorFechaDesdeTipoPrecio;
	}

	public void setResaltarBusquedaPorFechaDesdeTipoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorFechaDesdeTipoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaDesdeTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaDesdeTipoPrecio= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaHastaTipoPrecio=null;

	public Border getResaltarBusquedaPorFechaHastaTipoPrecio() {
		return this.resaltarBusquedaPorFechaHastaTipoPrecio;
	}

	public void setResaltarBusquedaPorFechaHastaTipoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorFechaHastaTipoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaHastaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaHastaTipoPrecio= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoPrecio=null;

	public Border getResaltarBusquedaPorNombreTipoPrecio() {
		return this.resaltarBusquedaPorNombreTipoPrecio;
	}

	public void setResaltarBusquedaPorNombreTipoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoPrecio=null;

	public Border getResaltarFK_IdEmpresaTipoPrecio() {
		return this.resaltarFK_IdEmpresaTipoPrecio;
	}

	public void setResaltarFK_IdEmpresaTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrecioBeanSwingJInternalFrame tipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPrecio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}