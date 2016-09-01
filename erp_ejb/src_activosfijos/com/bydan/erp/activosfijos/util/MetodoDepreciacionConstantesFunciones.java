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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.MetodoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.MetodoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MetodoDepreciacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MetodoDepreciacionConstantesFunciones extends MetodoDepreciacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MetodoDepreciacion";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MetodoDepreciacion"+MetodoDepreciacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MetodoDepreciacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MetodoDepreciacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MetodoDepreciacionConstantesFunciones.SCHEMA+"_"+MetodoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MetodoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MetodoDepreciacionConstantesFunciones.SCHEMA+"_"+MetodoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MetodoDepreciacionConstantesFunciones.SCHEMA+"_"+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MetodoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MetodoDepreciacionConstantesFunciones.SCHEMA+"_"+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MetodoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MetodoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MetodoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MetodoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MetodoDepreciacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MetodoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MetodoDepreciacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Metodo Depreciaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Metodo Depreciacion";
	public static final String SCLASSWEBTITULO_LOWER="Metodo Depreciacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MetodoDepreciacion";
	public static final String OBJECTNAME="metododepreciacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="metodo_depreciacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select metododepreciacion from "+MetodoDepreciacionConstantesFunciones.SPERSISTENCENAME+" metododepreciacion";
	public static String QUERYSELECTNATIVE="select "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".version_row,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_empresa,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_sucursal,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_anio,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".fecha_desde,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".fecha_hasta,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".porcentaje,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".valor,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".numero_dias from "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME;//+" as "+MetodoDepreciacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MetodoDepreciacionConstantesFuncionesAdditional metododepreciacionConstantesFuncionesAdditional=null;
	
	public MetodoDepreciacionConstantesFuncionesAdditional getMetodoDepreciacionConstantesFuncionesAdditional() {
		return this.metododepreciacionConstantesFuncionesAdditional;
	}
	
	public void setMetodoDepreciacionConstantesFuncionesAdditional(MetodoDepreciacionConstantesFuncionesAdditional metododepreciacionConstantesFuncionesAdditional) {
		try {
			this.metododepreciacionConstantesFuncionesAdditional=metododepreciacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDANIO= "id_anio";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String NUMERODIAS= "numero_dias";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getMetodoDepreciacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.IDANIO)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.FECHADESDE)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.FECHAHASTA)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.PORCENTAJE)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.VALOR)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(MetodoDepreciacionConstantesFunciones.NUMERODIAS)) {sLabelColumna=MetodoDepreciacionConstantesFunciones.LABEL_NUMERODIAS;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMetodoDepreciacionDescripcion(MetodoDepreciacion metododepreciacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(metododepreciacion !=null/* && metododepreciacion.getId()!=0*/) {
			if(metododepreciacion.getId()!=null) {
				sDescripcion=metododepreciacion.getId().toString();
			}//metododepreciacionmetododepreciacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMetodoDepreciacionDescripcionDetallado(MetodoDepreciacion metododepreciacion) {
		String sDescripcion="";
			
		sDescripcion+=MetodoDepreciacionConstantesFunciones.ID+"=";
		sDescripcion+=metododepreciacion.getId().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=metododepreciacion.getVersionRow().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=metododepreciacion.getid_empresa().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=metododepreciacion.getid_sucursal().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=metododepreciacion.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.IDANIO+"=";
		sDescripcion+=metododepreciacion.getid_anio().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=metododepreciacion.getfecha_desde().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=metododepreciacion.getfecha_hasta().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=metododepreciacion.getporcentaje().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.VALOR+"=";
		sDescripcion+=metododepreciacion.getvalor().toString()+",";
		sDescripcion+=MetodoDepreciacionConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=metododepreciacion.getnumero_dias().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMetodoDepreciacionDescripcion(MetodoDepreciacion metododepreciacion,String sValor) throws Exception {			
		if(metododepreciacion !=null) {
			//metododepreciacionmetododepreciacion.getId().toString();
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

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMetodoDepreciacion(MetodoDepreciacion metododepreciacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosMetodoDepreciacions(List<MetodoDepreciacion> metododepreciacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MetodoDepreciacion metododepreciacion: metododepreciacions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMetodoDepreciacion(MetodoDepreciacion metododepreciacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && metododepreciacion.getConCambioAuxiliar()) {
			metododepreciacion.setIsDeleted(metododepreciacion.getIsDeletedAuxiliar());	
			metododepreciacion.setIsNew(metododepreciacion.getIsNewAuxiliar());	
			metododepreciacion.setIsChanged(metododepreciacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			metododepreciacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			metododepreciacion.setIsDeletedAuxiliar(false);	
			metododepreciacion.setIsNewAuxiliar(false);	
			metododepreciacion.setIsChangedAuxiliar(false);
			
			metododepreciacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMetodoDepreciacions(List<MetodoDepreciacion> metododepreciacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MetodoDepreciacion metododepreciacion : metododepreciacions) {
			if(conAsignarBase && metododepreciacion.getConCambioAuxiliar()) {
				metododepreciacion.setIsDeleted(metododepreciacion.getIsDeletedAuxiliar());	
				metododepreciacion.setIsNew(metododepreciacion.getIsNewAuxiliar());	
				metododepreciacion.setIsChanged(metododepreciacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				metododepreciacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				metododepreciacion.setIsDeletedAuxiliar(false);	
				metododepreciacion.setIsNewAuxiliar(false);	
				metododepreciacion.setIsChangedAuxiliar(false);
				
				metododepreciacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMetodoDepreciacion(MetodoDepreciacion metododepreciacion,Boolean conEnteros) throws Exception  {
		metododepreciacion.setporcentaje(0.0);
		metododepreciacion.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			metododepreciacion.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresMetodoDepreciacions(List<MetodoDepreciacion> metododepreciacions,Boolean conEnteros) throws Exception  {
		
		for(MetodoDepreciacion metododepreciacion: metododepreciacions) {
			metododepreciacion.setporcentaje(0.0);
			metododepreciacion.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				metododepreciacion.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaMetodoDepreciacion(List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacion metododepreciacionAux) throws Exception  {
		MetodoDepreciacionConstantesFunciones.InicializarValoresMetodoDepreciacion(metododepreciacionAux,true);
		
		for(MetodoDepreciacion metododepreciacion: metododepreciacions) {
			if(metododepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			metododepreciacionAux.setporcentaje(metododepreciacionAux.getporcentaje()+metododepreciacion.getporcentaje());			
			metododepreciacionAux.setvalor(metododepreciacionAux.getvalor()+metododepreciacion.getvalor());			
			metododepreciacionAux.setnumero_dias(metododepreciacionAux.getnumero_dias()+metododepreciacion.getnumero_dias());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMetodoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MetodoDepreciacionConstantesFunciones.getArrayColumnasGlobalesMetodoDepreciacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMetodoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MetodoDepreciacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MetodoDepreciacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MetodoDepreciacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MetodoDepreciacionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMetodoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacion metododepreciacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MetodoDepreciacion metododepreciacionAux: metododepreciacions) {
			if(metododepreciacionAux!=null && metododepreciacion!=null) {
				if((metododepreciacionAux.getId()==null && metododepreciacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(metododepreciacionAux.getId()!=null && metododepreciacion.getId()!=null){
					if(metododepreciacionAux.getId().equals(metododepreciacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMetodoDepreciacion(List<MetodoDepreciacion> metododepreciacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(MetodoDepreciacion metododepreciacion: metododepreciacions) {			
			if(metododepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=metododepreciacion.getporcentaje();
			valorTotal+=metododepreciacion.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MetodoDepreciacionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MetodoDepreciacionConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMetodoDepreciacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_ID, MetodoDepreciacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_VERSIONROW, MetodoDepreciacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_IDEMPRESA, MetodoDepreciacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_IDSUCURSAL, MetodoDepreciacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_IDANIO, MetodoDepreciacionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_FECHADESDE, MetodoDepreciacionConstantesFunciones.FECHADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_FECHAHASTA, MetodoDepreciacionConstantesFunciones.FECHAHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE, MetodoDepreciacionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_VALOR, MetodoDepreciacionConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MetodoDepreciacionConstantesFunciones.LABEL_NUMERODIAS, MetodoDepreciacionConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMetodoDepreciacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.FECHADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.FECHAHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MetodoDepreciacionConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMetodoDepreciacion() throws Exception  {
		return MetodoDepreciacionConstantesFunciones.getTiposSeleccionarMetodoDepreciacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMetodoDepreciacion(Boolean conFk) throws Exception  {
		return MetodoDepreciacionConstantesFunciones.getTiposSeleccionarMetodoDepreciacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMetodoDepreciacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MetodoDepreciacionConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(MetodoDepreciacionConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMetodoDepreciacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMetodoDepreciacion(MetodoDepreciacion metododepreciacionAux) throws Exception {
		
			metododepreciacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(metododepreciacionAux.getEmpresa()));
			metododepreciacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(metododepreciacionAux.getSucursal()));
			metododepreciacionAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(metododepreciacionAux.getDetalleActivoFijo()));
			metododepreciacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(metododepreciacionAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMetodoDepreciacion(List<MetodoDepreciacion> metododepreciacionsTemp) throws Exception {
		for(MetodoDepreciacion metododepreciacionAux:metododepreciacionsTemp) {
			
			metododepreciacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(metododepreciacionAux.getEmpresa()));
			metododepreciacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(metododepreciacionAux.getSucursal()));
			metododepreciacionAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(metododepreciacionAux.getDetalleActivoFijo()));
			metododepreciacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(metododepreciacionAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMetodoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(Anio.class));
				
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMetodoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMetodoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MetodoDepreciacionConstantesFunciones.getClassesRelationshipsOfMetodoDepreciacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMetodoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMetodoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MetodoDepreciacionConstantesFunciones.getClassesRelationshipsFromStringsOfMetodoDepreciacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMetodoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MetodoDepreciacion metododepreciacion,List<MetodoDepreciacion> metododepreciacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MetodoDepreciacion metododepreciacionEncontrado=null;
			
			for(MetodoDepreciacion metododepreciacionLocal:metododepreciacions) {
				if(metododepreciacionLocal.getId().equals(metododepreciacion.getId())) {
					metododepreciacionEncontrado=metododepreciacionLocal;
					
					metododepreciacionLocal.setIsChanged(metododepreciacion.getIsChanged());
					metododepreciacionLocal.setIsNew(metododepreciacion.getIsNew());
					metododepreciacionLocal.setIsDeleted(metododepreciacion.getIsDeleted());
					
					metododepreciacionLocal.setGeneralEntityOriginal(metododepreciacion.getGeneralEntityOriginal());
					
					metododepreciacionLocal.setId(metododepreciacion.getId());	
					metododepreciacionLocal.setVersionRow(metododepreciacion.getVersionRow());	
					metododepreciacionLocal.setid_empresa(metododepreciacion.getid_empresa());	
					metododepreciacionLocal.setid_sucursal(metododepreciacion.getid_sucursal());	
					metododepreciacionLocal.setid_detalle_activo_fijo(metododepreciacion.getid_detalle_activo_fijo());	
					metododepreciacionLocal.setid_anio(metododepreciacion.getid_anio());	
					metododepreciacionLocal.setfecha_desde(metododepreciacion.getfecha_desde());	
					metododepreciacionLocal.setfecha_hasta(metododepreciacion.getfecha_hasta());	
					metododepreciacionLocal.setporcentaje(metododepreciacion.getporcentaje());	
					metododepreciacionLocal.setvalor(metododepreciacion.getvalor());	
					metododepreciacionLocal.setnumero_dias(metododepreciacion.getnumero_dias());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!metododepreciacion.getIsDeleted()) {
				if(!existe) {
					metododepreciacions.add(metododepreciacion);
				}
			} else {
				if(metododepreciacionEncontrado!=null && permiteQuitar)  {
					metododepreciacions.remove(metododepreciacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MetodoDepreciacion metododepreciacion,List<MetodoDepreciacion> metododepreciacions) throws Exception {
		try	{			
			for(MetodoDepreciacion metododepreciacionLocal:metododepreciacions) {
				if(metododepreciacionLocal.getId().equals(metododepreciacion.getId())) {
					metododepreciacionLocal.setIsSelected(metododepreciacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMetodoDepreciacion(List<MetodoDepreciacion> metododepreciacionsAux) throws Exception {
		//this.metododepreciacionsAux=metododepreciacionsAux;
		
		for(MetodoDepreciacion metododepreciacionAux:metododepreciacionsAux) {
			if(metododepreciacionAux.getIsChanged()) {
				metododepreciacionAux.setIsChanged(false);
			}		
			
			if(metododepreciacionAux.getIsNew()) {
				metododepreciacionAux.setIsNew(false);
			}	
			
			if(metododepreciacionAux.getIsDeleted()) {
				metododepreciacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMetodoDepreciacion(MetodoDepreciacion metododepreciacionAux) throws Exception {
		//this.metododepreciacionAux=metododepreciacionAux;
		
			if(metododepreciacionAux.getIsChanged()) {
				metododepreciacionAux.setIsChanged(false);
			}		
			
			if(metododepreciacionAux.getIsNew()) {
				metododepreciacionAux.setIsNew(false);
			}	
			
			if(metododepreciacionAux.getIsDeleted()) {
				metododepreciacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MetodoDepreciacion metododepreciacionAsignar,MetodoDepreciacion metododepreciacion) throws Exception {
		metododepreciacionAsignar.setId(metododepreciacion.getId());	
		metododepreciacionAsignar.setVersionRow(metododepreciacion.getVersionRow());	
		metododepreciacionAsignar.setid_empresa(metododepreciacion.getid_empresa());
		metododepreciacionAsignar.setempresa_descripcion(metododepreciacion.getempresa_descripcion());	
		metododepreciacionAsignar.setid_sucursal(metododepreciacion.getid_sucursal());
		metododepreciacionAsignar.setsucursal_descripcion(metododepreciacion.getsucursal_descripcion());	
		metododepreciacionAsignar.setid_detalle_activo_fijo(metododepreciacion.getid_detalle_activo_fijo());
		metododepreciacionAsignar.setdetalleactivofijo_descripcion(metododepreciacion.getdetalleactivofijo_descripcion());	
		metododepreciacionAsignar.setid_anio(metododepreciacion.getid_anio());
		metododepreciacionAsignar.setanio_descripcion(metododepreciacion.getanio_descripcion());	
		metododepreciacionAsignar.setfecha_desde(metododepreciacion.getfecha_desde());	
		metododepreciacionAsignar.setfecha_hasta(metododepreciacion.getfecha_hasta());	
		metododepreciacionAsignar.setporcentaje(metododepreciacion.getporcentaje());	
		metododepreciacionAsignar.setvalor(metododepreciacion.getvalor());	
		metododepreciacionAsignar.setnumero_dias(metododepreciacion.getnumero_dias());	
	}
	
	public static void inicializarMetodoDepreciacion(MetodoDepreciacion metododepreciacion) throws Exception {
		try {
				metododepreciacion.setId(0L);	
					
				metododepreciacion.setid_empresa(-1L);	
				metododepreciacion.setid_sucursal(-1L);	
				metododepreciacion.setid_detalle_activo_fijo(-1L);	
				metododepreciacion.setid_anio(null);	
				metododepreciacion.setfecha_desde(new Date());	
				metododepreciacion.setfecha_hasta(new Date());	
				metododepreciacion.setporcentaje(0.0);	
				metododepreciacion.setvalor(0.0);	
				metododepreciacion.setnumero_dias(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMetodoDepreciacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MetodoDepreciacionConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMetodoDepreciacion(String sTipo,Row row,Workbook workbook,MetodoDepreciacion metododepreciacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(metododepreciacion.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMetodoDepreciacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMetodoDepreciacion() {
		return this.sFinalQueryMetodoDepreciacion;
	}
	
	public void setsFinalQueryMetodoDepreciacion(String sFinalQueryMetodoDepreciacion) {
		this.sFinalQueryMetodoDepreciacion= sFinalQueryMetodoDepreciacion;
	}
	
	public Border resaltarSeleccionarMetodoDepreciacion=null;
	
	public Border setResaltarSeleccionarMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMetodoDepreciacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMetodoDepreciacion() {
		return this.resaltarSeleccionarMetodoDepreciacion;
	}
	
	public void setResaltarSeleccionarMetodoDepreciacion(Border borderResaltarSeleccionarMetodoDepreciacion) {
		this.resaltarSeleccionarMetodoDepreciacion= borderResaltarSeleccionarMetodoDepreciacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMetodoDepreciacion=null;
	public Boolean mostraridMetodoDepreciacion=true;
	public Boolean activaridMetodoDepreciacion=true;

	public Border resaltarid_empresaMetodoDepreciacion=null;
	public Boolean mostrarid_empresaMetodoDepreciacion=true;
	public Boolean activarid_empresaMetodoDepreciacion=true;
	public Boolean cargarid_empresaMetodoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMetodoDepreciacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalMetodoDepreciacion=null;
	public Boolean mostrarid_sucursalMetodoDepreciacion=true;
	public Boolean activarid_sucursalMetodoDepreciacion=true;
	public Boolean cargarid_sucursalMetodoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMetodoDepreciacion=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoMetodoDepreciacion=null;
	public Boolean mostrarid_detalle_activo_fijoMetodoDepreciacion=true;
	public Boolean activarid_detalle_activo_fijoMetodoDepreciacion=true;
	public Boolean cargarid_detalle_activo_fijoMetodoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoMetodoDepreciacion=false;//ConEventDepend=true

	public Border resaltarid_anioMetodoDepreciacion=null;
	public Boolean mostrarid_anioMetodoDepreciacion=true;
	public Boolean activarid_anioMetodoDepreciacion=true;
	public Boolean cargarid_anioMetodoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioMetodoDepreciacion=false;//ConEventDepend=true

	public Border resaltarfecha_desdeMetodoDepreciacion=null;
	public Boolean mostrarfecha_desdeMetodoDepreciacion=true;
	public Boolean activarfecha_desdeMetodoDepreciacion=false;

	public Border resaltarfecha_hastaMetodoDepreciacion=null;
	public Boolean mostrarfecha_hastaMetodoDepreciacion=true;
	public Boolean activarfecha_hastaMetodoDepreciacion=false;

	public Border resaltarporcentajeMetodoDepreciacion=null;
	public Boolean mostrarporcentajeMetodoDepreciacion=true;
	public Boolean activarporcentajeMetodoDepreciacion=true;

	public Border resaltarvalorMetodoDepreciacion=null;
	public Boolean mostrarvalorMetodoDepreciacion=true;
	public Boolean activarvalorMetodoDepreciacion=true;

	public Border resaltarnumero_diasMetodoDepreciacion=null;
	public Boolean mostrarnumero_diasMetodoDepreciacion=true;
	public Boolean activarnumero_diasMetodoDepreciacion=true;

	
	

	public Border setResaltaridMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltaridMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMetodoDepreciacion() {
		return this.resaltaridMetodoDepreciacion;
	}

	public void setResaltaridMetodoDepreciacion(Border borderResaltar) {
		this.resaltaridMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostraridMetodoDepreciacion() {
		return this.mostraridMetodoDepreciacion;
	}

	public void setMostraridMetodoDepreciacion(Boolean mostraridMetodoDepreciacion) {
		this.mostraridMetodoDepreciacion= mostraridMetodoDepreciacion;
	}

	public Boolean getActivaridMetodoDepreciacion() {
		return this.activaridMetodoDepreciacion;
	}

	public void setActivaridMetodoDepreciacion(Boolean activaridMetodoDepreciacion) {
		this.activaridMetodoDepreciacion= activaridMetodoDepreciacion;
	}

	public Border setResaltarid_empresaMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMetodoDepreciacion() {
		return this.resaltarid_empresaMetodoDepreciacion;
	}

	public void setResaltarid_empresaMetodoDepreciacion(Border borderResaltar) {
		this.resaltarid_empresaMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaMetodoDepreciacion() {
		return this.mostrarid_empresaMetodoDepreciacion;
	}

	public void setMostrarid_empresaMetodoDepreciacion(Boolean mostrarid_empresaMetodoDepreciacion) {
		this.mostrarid_empresaMetodoDepreciacion= mostrarid_empresaMetodoDepreciacion;
	}

	public Boolean getActivarid_empresaMetodoDepreciacion() {
		return this.activarid_empresaMetodoDepreciacion;
	}

	public void setActivarid_empresaMetodoDepreciacion(Boolean activarid_empresaMetodoDepreciacion) {
		this.activarid_empresaMetodoDepreciacion= activarid_empresaMetodoDepreciacion;
	}

	public Boolean getCargarid_empresaMetodoDepreciacion() {
		return this.cargarid_empresaMetodoDepreciacion;
	}

	public void setCargarid_empresaMetodoDepreciacion(Boolean cargarid_empresaMetodoDepreciacion) {
		this.cargarid_empresaMetodoDepreciacion= cargarid_empresaMetodoDepreciacion;
	}

	public Border setResaltarid_sucursalMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMetodoDepreciacion() {
		return this.resaltarid_sucursalMetodoDepreciacion;
	}

	public void setResaltarid_sucursalMetodoDepreciacion(Border borderResaltar) {
		this.resaltarid_sucursalMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMetodoDepreciacion() {
		return this.mostrarid_sucursalMetodoDepreciacion;
	}

	public void setMostrarid_sucursalMetodoDepreciacion(Boolean mostrarid_sucursalMetodoDepreciacion) {
		this.mostrarid_sucursalMetodoDepreciacion= mostrarid_sucursalMetodoDepreciacion;
	}

	public Boolean getActivarid_sucursalMetodoDepreciacion() {
		return this.activarid_sucursalMetodoDepreciacion;
	}

	public void setActivarid_sucursalMetodoDepreciacion(Boolean activarid_sucursalMetodoDepreciacion) {
		this.activarid_sucursalMetodoDepreciacion= activarid_sucursalMetodoDepreciacion;
	}

	public Boolean getCargarid_sucursalMetodoDepreciacion() {
		return this.cargarid_sucursalMetodoDepreciacion;
	}

	public void setCargarid_sucursalMetodoDepreciacion(Boolean cargarid_sucursalMetodoDepreciacion) {
		this.cargarid_sucursalMetodoDepreciacion= cargarid_sucursalMetodoDepreciacion;
	}

	public Border setResaltarid_detalle_activo_fijoMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoMetodoDepreciacion() {
		return this.resaltarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public void setResaltarid_detalle_activo_fijoMetodoDepreciacion(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoMetodoDepreciacion() {
		return this.mostrarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public void setMostrarid_detalle_activo_fijoMetodoDepreciacion(Boolean mostrarid_detalle_activo_fijoMetodoDepreciacion) {
		this.mostrarid_detalle_activo_fijoMetodoDepreciacion= mostrarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public Boolean getActivarid_detalle_activo_fijoMetodoDepreciacion() {
		return this.activarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public void setActivarid_detalle_activo_fijoMetodoDepreciacion(Boolean activarid_detalle_activo_fijoMetodoDepreciacion) {
		this.activarid_detalle_activo_fijoMetodoDepreciacion= activarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public Boolean getCargarid_detalle_activo_fijoMetodoDepreciacion() {
		return this.cargarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public void setCargarid_detalle_activo_fijoMetodoDepreciacion(Boolean cargarid_detalle_activo_fijoMetodoDepreciacion) {
		this.cargarid_detalle_activo_fijoMetodoDepreciacion= cargarid_detalle_activo_fijoMetodoDepreciacion;
	}

	public Border setResaltarid_anioMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_anioMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioMetodoDepreciacion() {
		return this.resaltarid_anioMetodoDepreciacion;
	}

	public void setResaltarid_anioMetodoDepreciacion(Border borderResaltar) {
		this.resaltarid_anioMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_anioMetodoDepreciacion() {
		return this.mostrarid_anioMetodoDepreciacion;
	}

	public void setMostrarid_anioMetodoDepreciacion(Boolean mostrarid_anioMetodoDepreciacion) {
		this.mostrarid_anioMetodoDepreciacion= mostrarid_anioMetodoDepreciacion;
	}

	public Boolean getActivarid_anioMetodoDepreciacion() {
		return this.activarid_anioMetodoDepreciacion;
	}

	public void setActivarid_anioMetodoDepreciacion(Boolean activarid_anioMetodoDepreciacion) {
		this.activarid_anioMetodoDepreciacion= activarid_anioMetodoDepreciacion;
	}

	public Boolean getCargarid_anioMetodoDepreciacion() {
		return this.cargarid_anioMetodoDepreciacion;
	}

	public void setCargarid_anioMetodoDepreciacion(Boolean cargarid_anioMetodoDepreciacion) {
		this.cargarid_anioMetodoDepreciacion= cargarid_anioMetodoDepreciacion;
	}

	public Border setResaltarfecha_desdeMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeMetodoDepreciacion() {
		return this.resaltarfecha_desdeMetodoDepreciacion;
	}

	public void setResaltarfecha_desdeMetodoDepreciacion(Border borderResaltar) {
		this.resaltarfecha_desdeMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeMetodoDepreciacion() {
		return this.mostrarfecha_desdeMetodoDepreciacion;
	}

	public void setMostrarfecha_desdeMetodoDepreciacion(Boolean mostrarfecha_desdeMetodoDepreciacion) {
		this.mostrarfecha_desdeMetodoDepreciacion= mostrarfecha_desdeMetodoDepreciacion;
	}

	public Boolean getActivarfecha_desdeMetodoDepreciacion() {
		return this.activarfecha_desdeMetodoDepreciacion;
	}

	public void setActivarfecha_desdeMetodoDepreciacion(Boolean activarfecha_desdeMetodoDepreciacion) {
		this.activarfecha_desdeMetodoDepreciacion= activarfecha_desdeMetodoDepreciacion;
	}

	public Border setResaltarfecha_hastaMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaMetodoDepreciacion() {
		return this.resaltarfecha_hastaMetodoDepreciacion;
	}

	public void setResaltarfecha_hastaMetodoDepreciacion(Border borderResaltar) {
		this.resaltarfecha_hastaMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaMetodoDepreciacion() {
		return this.mostrarfecha_hastaMetodoDepreciacion;
	}

	public void setMostrarfecha_hastaMetodoDepreciacion(Boolean mostrarfecha_hastaMetodoDepreciacion) {
		this.mostrarfecha_hastaMetodoDepreciacion= mostrarfecha_hastaMetodoDepreciacion;
	}

	public Boolean getActivarfecha_hastaMetodoDepreciacion() {
		return this.activarfecha_hastaMetodoDepreciacion;
	}

	public void setActivarfecha_hastaMetodoDepreciacion(Boolean activarfecha_hastaMetodoDepreciacion) {
		this.activarfecha_hastaMetodoDepreciacion= activarfecha_hastaMetodoDepreciacion;
	}

	public Border setResaltarporcentajeMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarporcentajeMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeMetodoDepreciacion() {
		return this.resaltarporcentajeMetodoDepreciacion;
	}

	public void setResaltarporcentajeMetodoDepreciacion(Border borderResaltar) {
		this.resaltarporcentajeMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarporcentajeMetodoDepreciacion() {
		return this.mostrarporcentajeMetodoDepreciacion;
	}

	public void setMostrarporcentajeMetodoDepreciacion(Boolean mostrarporcentajeMetodoDepreciacion) {
		this.mostrarporcentajeMetodoDepreciacion= mostrarporcentajeMetodoDepreciacion;
	}

	public Boolean getActivarporcentajeMetodoDepreciacion() {
		return this.activarporcentajeMetodoDepreciacion;
	}

	public void setActivarporcentajeMetodoDepreciacion(Boolean activarporcentajeMetodoDepreciacion) {
		this.activarporcentajeMetodoDepreciacion= activarporcentajeMetodoDepreciacion;
	}

	public Border setResaltarvalorMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarvalorMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorMetodoDepreciacion() {
		return this.resaltarvalorMetodoDepreciacion;
	}

	public void setResaltarvalorMetodoDepreciacion(Border borderResaltar) {
		this.resaltarvalorMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarvalorMetodoDepreciacion() {
		return this.mostrarvalorMetodoDepreciacion;
	}

	public void setMostrarvalorMetodoDepreciacion(Boolean mostrarvalorMetodoDepreciacion) {
		this.mostrarvalorMetodoDepreciacion= mostrarvalorMetodoDepreciacion;
	}

	public Boolean getActivarvalorMetodoDepreciacion() {
		return this.activarvalorMetodoDepreciacion;
	}

	public void setActivarvalorMetodoDepreciacion(Boolean activarvalorMetodoDepreciacion) {
		this.activarvalorMetodoDepreciacion= activarvalorMetodoDepreciacion;
	}

	public Border setResaltarnumero_diasMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//metododepreciacionBeanSwingJInternalFrame.jTtoolBarMetodoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarnumero_diasMetodoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasMetodoDepreciacion() {
		return this.resaltarnumero_diasMetodoDepreciacion;
	}

	public void setResaltarnumero_diasMetodoDepreciacion(Border borderResaltar) {
		this.resaltarnumero_diasMetodoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarnumero_diasMetodoDepreciacion() {
		return this.mostrarnumero_diasMetodoDepreciacion;
	}

	public void setMostrarnumero_diasMetodoDepreciacion(Boolean mostrarnumero_diasMetodoDepreciacion) {
		this.mostrarnumero_diasMetodoDepreciacion= mostrarnumero_diasMetodoDepreciacion;
	}

	public Boolean getActivarnumero_diasMetodoDepreciacion() {
		return this.activarnumero_diasMetodoDepreciacion;
	}

	public void setActivarnumero_diasMetodoDepreciacion(Boolean activarnumero_diasMetodoDepreciacion) {
		this.activarnumero_diasMetodoDepreciacion= activarnumero_diasMetodoDepreciacion;
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
		
		
		this.setMostraridMetodoDepreciacion(esInicial);
		this.setMostrarid_empresaMetodoDepreciacion(esInicial);
		this.setMostrarid_sucursalMetodoDepreciacion(esInicial);
		this.setMostrarid_detalle_activo_fijoMetodoDepreciacion(esInicial);
		this.setMostrarid_anioMetodoDepreciacion(esInicial);
		this.setMostrarfecha_desdeMetodoDepreciacion(esInicial);
		this.setMostrarfecha_hastaMetodoDepreciacion(esInicial);
		this.setMostrarporcentajeMetodoDepreciacion(esInicial);
		this.setMostrarvalorMetodoDepreciacion(esInicial);
		this.setMostrarnumero_diasMetodoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.ID)) {
				this.setMostraridMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.VALOR)) {
				this.setMostrarvalorMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasMetodoDepreciacion(esAsigna);
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
		
		
		this.setActivaridMetodoDepreciacion(esInicial);
		this.setActivarid_empresaMetodoDepreciacion(esInicial);
		this.setActivarid_sucursalMetodoDepreciacion(esInicial);
		this.setActivarid_detalle_activo_fijoMetodoDepreciacion(esInicial);
		this.setActivarid_anioMetodoDepreciacion(esInicial);
		this.setActivarfecha_desdeMetodoDepreciacion(esInicial);
		this.setActivarfecha_hastaMetodoDepreciacion(esInicial);
		this.setActivarporcentajeMetodoDepreciacion(esInicial);
		this.setActivarvalorMetodoDepreciacion(esInicial);
		this.setActivarnumero_diasMetodoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.ID)) {
				this.setActivaridMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.VALOR)) {
				this.setActivarvalorMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasMetodoDepreciacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMetodoDepreciacion(esInicial);
		this.setResaltarid_empresaMetodoDepreciacion(esInicial);
		this.setResaltarid_sucursalMetodoDepreciacion(esInicial);
		this.setResaltarid_detalle_activo_fijoMetodoDepreciacion(esInicial);
		this.setResaltarid_anioMetodoDepreciacion(esInicial);
		this.setResaltarfecha_desdeMetodoDepreciacion(esInicial);
		this.setResaltarfecha_hastaMetodoDepreciacion(esInicial);
		this.setResaltarporcentajeMetodoDepreciacion(esInicial);
		this.setResaltarvalorMetodoDepreciacion(esInicial);
		this.setResaltarnumero_diasMetodoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.ID)) {
				this.setResaltaridMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.VALOR)) {
				this.setResaltarvalorMetodoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(MetodoDepreciacionConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasMetodoDepreciacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioMetodoDepreciacion=true;

	public Boolean getMostrarFK_IdAnioMetodoDepreciacion() {
		return this.mostrarFK_IdAnioMetodoDepreciacion;
	}

	public void setMostrarFK_IdAnioMetodoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioMetodoDepreciacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoMetodoDepreciacion=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoMetodoDepreciacion() {
		return this.mostrarFK_IdDetalleActivoFijoMetodoDepreciacion;
	}

	public void setMostrarFK_IdDetalleActivoFijoMetodoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoMetodoDepreciacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMetodoDepreciacion=true;

	public Boolean getMostrarFK_IdEmpresaMetodoDepreciacion() {
		return this.mostrarFK_IdEmpresaMetodoDepreciacion;
	}

	public void setMostrarFK_IdEmpresaMetodoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMetodoDepreciacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMetodoDepreciacion=true;

	public Boolean getMostrarFK_IdSucursalMetodoDepreciacion() {
		return this.mostrarFK_IdSucursalMetodoDepreciacion;
	}

	public void setMostrarFK_IdSucursalMetodoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMetodoDepreciacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioMetodoDepreciacion=true;

	public Boolean getActivarFK_IdAnioMetodoDepreciacion() {
		return this.activarFK_IdAnioMetodoDepreciacion;
	}

	public void setActivarFK_IdAnioMetodoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdAnioMetodoDepreciacion= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoMetodoDepreciacion=true;

	public Boolean getActivarFK_IdDetalleActivoFijoMetodoDepreciacion() {
		return this.activarFK_IdDetalleActivoFijoMetodoDepreciacion;
	}

	public void setActivarFK_IdDetalleActivoFijoMetodoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoMetodoDepreciacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMetodoDepreciacion=true;

	public Boolean getActivarFK_IdEmpresaMetodoDepreciacion() {
		return this.activarFK_IdEmpresaMetodoDepreciacion;
	}

	public void setActivarFK_IdEmpresaMetodoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMetodoDepreciacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMetodoDepreciacion=true;

	public Boolean getActivarFK_IdSucursalMetodoDepreciacion() {
		return this.activarFK_IdSucursalMetodoDepreciacion;
	}

	public void setActivarFK_IdSucursalMetodoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMetodoDepreciacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioMetodoDepreciacion=null;

	public Border getResaltarFK_IdAnioMetodoDepreciacion() {
		return this.resaltarFK_IdAnioMetodoDepreciacion;
	}

	public void setResaltarFK_IdAnioMetodoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdAnioMetodoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdAnioMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioMetodoDepreciacion= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoMetodoDepreciacion=null;

	public Border getResaltarFK_IdDetalleActivoFijoMetodoDepreciacion() {
		return this.resaltarFK_IdDetalleActivoFijoMetodoDepreciacion;
	}

	public void setResaltarFK_IdDetalleActivoFijoMetodoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoMetodoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoMetodoDepreciacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMetodoDepreciacion=null;

	public Border getResaltarFK_IdEmpresaMetodoDepreciacion() {
		return this.resaltarFK_IdEmpresaMetodoDepreciacion;
	}

	public void setResaltarFK_IdEmpresaMetodoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMetodoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMetodoDepreciacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMetodoDepreciacion=null;

	public Border getResaltarFK_IdSucursalMetodoDepreciacion() {
		return this.resaltarFK_IdSucursalMetodoDepreciacion;
	}

	public void setResaltarFK_IdSucursalMetodoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalMetodoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMetodoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*MetodoDepreciacionBeanSwingJInternalFrame metododepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMetodoDepreciacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}