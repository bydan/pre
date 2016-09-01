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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.CajaEgresoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaEgresoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaEgresoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaEgresoConstantesFunciones extends CajaEgresoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajaEgreso";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaEgreso"+CajaEgresoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaEgresoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaEgresoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaEgresoConstantesFunciones.SCHEMA+"_"+CajaEgresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaEgresoConstantesFunciones.SCHEMA+"_"+CajaEgresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaEgresoConstantesFunciones.SCHEMA+"_"+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaEgresoConstantesFunciones.SCHEMA+"_"+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaEgresoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaEgresoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaEgresoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaEgresoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Egresos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Egreso";
	public static final String SCLASSWEBTITULO_LOWER="Caja Egreso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaEgreso";
	public static final String OBJECTNAME="cajaegreso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja_egreso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajaegreso from "+CajaEgresoConstantesFunciones.SPERSISTENCENAME+" cajaegreso";
	public static String QUERYSELECTNATIVE="select "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".version_row,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_empresa,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_sucursal,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_usuario,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_caja,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_turno_pun_ven,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".secuencial,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".fecha,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".hora,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".valor from "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME;//+" as "+CajaEgresoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajaEgresoConstantesFuncionesAdditional cajaegresoConstantesFuncionesAdditional=null;
	
	public CajaEgresoConstantesFuncionesAdditional getCajaEgresoConstantesFuncionesAdditional() {
		return this.cajaegresoConstantesFuncionesAdditional;
	}
	
	public void setCajaEgresoConstantesFuncionesAdditional(CajaEgresoConstantesFuncionesAdditional cajaegresoConstantesFuncionesAdditional) {
		try {
			this.cajaegresoConstantesFuncionesAdditional=cajaegresoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCAJA= "id_caja";
    public static final String IDTURNOPUNVEN= "id_turno_pun_ven";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDTURNOPUNVEN= "Turno";
		public static final String LABEL_IDTURNOPUNVEN_LOWER= "Turno Pun Ven";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getCajaEgresoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.IDUSUARIO)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.IDCAJA)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.IDTURNOPUNVEN)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_IDTURNOPUNVEN;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.SECUENCIAL)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.FECHA)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.HORA)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(CajaEgresoConstantesFunciones.VALOR)) {sLabelColumna=CajaEgresoConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajaEgresoDescripcion(CajaEgreso cajaegreso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajaegreso !=null/* && cajaegreso.getId()!=0*/) {
			sDescripcion=cajaegreso.getsecuencial();//cajaegresocajaegreso.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaEgresoDescripcionDetallado(CajaEgreso cajaegreso) {
		String sDescripcion="";
			
		sDescripcion+=CajaEgresoConstantesFunciones.ID+"=";
		sDescripcion+=cajaegreso.getId().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajaegreso.getVersionRow().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajaegreso.getid_empresa().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajaegreso.getid_sucursal().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=cajaegreso.getid_usuario().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajaegreso.getid_caja().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.IDTURNOPUNVEN+"=";
		sDescripcion+=cajaegreso.getid_turno_pun_ven().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=cajaegreso.getsecuencial()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.FECHA+"=";
		sDescripcion+=cajaegreso.getfecha().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.HORA+"=";
		sDescripcion+=cajaegreso.gethora().toString()+",";
		sDescripcion+=CajaEgresoConstantesFunciones.VALOR+"=";
		sDescripcion+=cajaegreso.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaEgresoDescripcion(CajaEgreso cajaegreso,String sValor) throws Exception {			
		if(cajaegreso !=null) {
			cajaegreso.setsecuencial(sValor);;//cajaegresocajaegreso.getsecuencial().trim();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getTurnoPunVenDescripcion(TurnoPunVen turnopunven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(turnopunven!=null/*&&turnopunven.getId()>0*/) {
			sDescripcion=TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(turnopunven);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTurnoPunVen")) {
			sNombreIndice="Tipo=  Por Turno";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

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

	public static String getDetalleIndiceFK_IdTurnoPunVen(Long id_turno_pun_ven) {
		String sDetalleIndice=" Parametros->";
		if(id_turno_pun_ven!=null) {sDetalleIndice+=" Codigo Unico De Turno="+id_turno_pun_ven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaEgreso(CajaEgreso cajaegreso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaegreso.setsecuencial(cajaegreso.getsecuencial().trim());
	}
	
	public static void quitarEspaciosCajaEgresos(List<CajaEgreso> cajaegresos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaEgreso cajaegreso: cajaegresos) {
			cajaegreso.setsecuencial(cajaegreso.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaEgreso(CajaEgreso cajaegreso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajaegreso.getConCambioAuxiliar()) {
			cajaegreso.setIsDeleted(cajaegreso.getIsDeletedAuxiliar());	
			cajaegreso.setIsNew(cajaegreso.getIsNewAuxiliar());	
			cajaegreso.setIsChanged(cajaegreso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajaegreso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajaegreso.setIsDeletedAuxiliar(false);	
			cajaegreso.setIsNewAuxiliar(false);	
			cajaegreso.setIsChangedAuxiliar(false);
			
			cajaegreso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaEgresos(List<CajaEgreso> cajaegresos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaEgreso cajaegreso : cajaegresos) {
			if(conAsignarBase && cajaegreso.getConCambioAuxiliar()) {
				cajaegreso.setIsDeleted(cajaegreso.getIsDeletedAuxiliar());	
				cajaegreso.setIsNew(cajaegreso.getIsNewAuxiliar());	
				cajaegreso.setIsChanged(cajaegreso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajaegreso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajaegreso.setIsDeletedAuxiliar(false);	
				cajaegreso.setIsNewAuxiliar(false);	
				cajaegreso.setIsChangedAuxiliar(false);
				
				cajaegreso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaEgreso(CajaEgreso cajaegreso,Boolean conEnteros) throws Exception  {
		cajaegreso.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaEgresos(List<CajaEgreso> cajaegresos,Boolean conEnteros) throws Exception  {
		
		for(CajaEgreso cajaegreso: cajaegresos) {
			cajaegreso.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaEgreso(List<CajaEgreso> cajaegresos,CajaEgreso cajaegresoAux) throws Exception  {
		CajaEgresoConstantesFunciones.InicializarValoresCajaEgreso(cajaegresoAux,true);
		
		for(CajaEgreso cajaegreso: cajaegresos) {
			if(cajaegreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajaegresoAux.setvalor(cajaegresoAux.getvalor()+cajaegreso.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaEgreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaEgresoConstantesFunciones.getArrayColumnasGlobalesCajaEgreso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaEgreso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaEgresoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaEgresoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaEgresoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaEgresoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaEgresoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaEgresoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaEgreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaEgreso> cajaegresos,CajaEgreso cajaegreso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaEgreso cajaegresoAux: cajaegresos) {
			if(cajaegresoAux!=null && cajaegreso!=null) {
				if((cajaegresoAux.getId()==null && cajaegreso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajaegresoAux.getId()!=null && cajaegreso.getId()!=null){
					if(cajaegresoAux.getId().equals(cajaegreso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaEgreso(List<CajaEgreso> cajaegresos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(CajaEgreso cajaegreso: cajaegresos) {			
			if(cajaegreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=cajaegreso.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaEgresoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaEgreso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_ID, CajaEgresoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_VERSIONROW, CajaEgresoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_IDEMPRESA, CajaEgresoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_IDSUCURSAL, CajaEgresoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_IDUSUARIO, CajaEgresoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_IDCAJA, CajaEgresoConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_IDTURNOPUNVEN, CajaEgresoConstantesFunciones.IDTURNOPUNVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_SECUENCIAL, CajaEgresoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_FECHA, CajaEgresoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_HORA, CajaEgresoConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoConstantesFunciones.LABEL_VALOR, CajaEgresoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaEgreso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.IDTURNOPUNVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgreso() throws Exception  {
		return CajaEgresoConstantesFunciones.getTiposSeleccionarCajaEgreso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgreso(Boolean conFk) throws Exception  {
		return CajaEgresoConstantesFunciones.getTiposSeleccionarCajaEgreso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgreso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_IDTURNOPUNVEN);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_IDTURNOPUNVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CajaEgresoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaEgreso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaEgreso(CajaEgreso cajaegresoAux) throws Exception {
		
			cajaegresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaegresoAux.getEmpresa()));
			cajaegresoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaegresoAux.getSucursal()));
			cajaegresoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajaegresoAux.getUsuario()));
			cajaegresoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajaegresoAux.getCaja()));
			cajaegresoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajaegresoAux.getTurnoPunVen()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaEgreso(List<CajaEgreso> cajaegresosTemp) throws Exception {
		for(CajaEgreso cajaegresoAux:cajaegresosTemp) {
			
			cajaegresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaegresoAux.getEmpresa()));
			cajaegresoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaegresoAux.getSucursal()));
			cajaegresoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajaegresoAux.getUsuario()));
			cajaegresoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajaegresoAux.getCaja()));
			cajaegresoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajaegresoAux.getTurnoPunVen()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(TurnoPunVen.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TurnoPunVen.class)) {
						classes.add(new Classe(TurnoPunVen.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaEgresoConstantesFunciones.getClassesRelationshipsOfCajaEgreso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CajaEgresoDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaEgresoDetalle.class)) {
						classes.add(new Classe(CajaEgresoDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaEgresoConstantesFunciones.getClassesRelationshipsFromStringsOfCajaEgreso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaEgresoDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgresoDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaEgresoDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgresoDetalle.class)); continue;
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
	public static void actualizarLista(CajaEgreso cajaegreso,List<CajaEgreso> cajaegresos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajaEgreso cajaegresoEncontrado=null;
			
			for(CajaEgreso cajaegresoLocal:cajaegresos) {
				if(cajaegresoLocal.getId().equals(cajaegreso.getId())) {
					cajaegresoEncontrado=cajaegresoLocal;
					
					cajaegresoLocal.setIsChanged(cajaegreso.getIsChanged());
					cajaegresoLocal.setIsNew(cajaegreso.getIsNew());
					cajaegresoLocal.setIsDeleted(cajaegreso.getIsDeleted());
					
					cajaegresoLocal.setGeneralEntityOriginal(cajaegreso.getGeneralEntityOriginal());
					
					cajaegresoLocal.setId(cajaegreso.getId());	
					cajaegresoLocal.setVersionRow(cajaegreso.getVersionRow());	
					cajaegresoLocal.setid_empresa(cajaegreso.getid_empresa());	
					cajaegresoLocal.setid_sucursal(cajaegreso.getid_sucursal());	
					cajaegresoLocal.setid_usuario(cajaegreso.getid_usuario());	
					cajaegresoLocal.setid_caja(cajaegreso.getid_caja());	
					cajaegresoLocal.setid_turno_pun_ven(cajaegreso.getid_turno_pun_ven());	
					cajaegresoLocal.setsecuencial(cajaegreso.getsecuencial());	
					cajaegresoLocal.setfecha(cajaegreso.getfecha());	
					cajaegresoLocal.sethora(cajaegreso.gethora());	
					cajaegresoLocal.setvalor(cajaegreso.getvalor());	
					
					
					cajaegresoLocal.setCajaEgresoDetalles(cajaegreso.getCajaEgresoDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!cajaegreso.getIsDeleted()) {
				if(!existe) {
					cajaegresos.add(cajaegreso);
				}
			} else {
				if(cajaegresoEncontrado!=null && permiteQuitar)  {
					cajaegresos.remove(cajaegresoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajaEgreso cajaegreso,List<CajaEgreso> cajaegresos) throws Exception {
		try	{			
			for(CajaEgreso cajaegresoLocal:cajaegresos) {
				if(cajaegresoLocal.getId().equals(cajaegreso.getId())) {
					cajaegresoLocal.setIsSelected(cajaegreso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaEgreso(List<CajaEgreso> cajaegresosAux) throws Exception {
		//this.cajaegresosAux=cajaegresosAux;
		
		for(CajaEgreso cajaegresoAux:cajaegresosAux) {
			if(cajaegresoAux.getIsChanged()) {
				cajaegresoAux.setIsChanged(false);
			}		
			
			if(cajaegresoAux.getIsNew()) {
				cajaegresoAux.setIsNew(false);
			}	
			
			if(cajaegresoAux.getIsDeleted()) {
				cajaegresoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaEgreso(CajaEgreso cajaegresoAux) throws Exception {
		//this.cajaegresoAux=cajaegresoAux;
		
			if(cajaegresoAux.getIsChanged()) {
				cajaegresoAux.setIsChanged(false);
			}		
			
			if(cajaegresoAux.getIsNew()) {
				cajaegresoAux.setIsNew(false);
			}	
			
			if(cajaegresoAux.getIsDeleted()) {
				cajaegresoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaEgreso cajaegresoAsignar,CajaEgreso cajaegreso) throws Exception {
		cajaegresoAsignar.setId(cajaegreso.getId());	
		cajaegresoAsignar.setVersionRow(cajaegreso.getVersionRow());	
		cajaegresoAsignar.setid_empresa(cajaegreso.getid_empresa());
		cajaegresoAsignar.setempresa_descripcion(cajaegreso.getempresa_descripcion());	
		cajaegresoAsignar.setid_sucursal(cajaegreso.getid_sucursal());
		cajaegresoAsignar.setsucursal_descripcion(cajaegreso.getsucursal_descripcion());	
		cajaegresoAsignar.setid_usuario(cajaegreso.getid_usuario());
		cajaegresoAsignar.setusuario_descripcion(cajaegreso.getusuario_descripcion());	
		cajaegresoAsignar.setid_caja(cajaegreso.getid_caja());
		cajaegresoAsignar.setcaja_descripcion(cajaegreso.getcaja_descripcion());	
		cajaegresoAsignar.setid_turno_pun_ven(cajaegreso.getid_turno_pun_ven());
		cajaegresoAsignar.setturnopunven_descripcion(cajaegreso.getturnopunven_descripcion());	
		cajaegresoAsignar.setsecuencial(cajaegreso.getsecuencial());	
		cajaegresoAsignar.setfecha(cajaegreso.getfecha());	
		cajaegresoAsignar.sethora(cajaegreso.gethora());	
		cajaegresoAsignar.setvalor(cajaegreso.getvalor());	
	}
	
	public static void inicializarCajaEgreso(CajaEgreso cajaegreso) throws Exception {
		try {
				cajaegreso.setId(0L);	
					
				cajaegreso.setid_empresa(-1L);	
				cajaegreso.setid_sucursal(-1L);	
				cajaegreso.setid_usuario(-1L);	
				cajaegreso.setid_caja(-1L);	
				cajaegreso.setid_turno_pun_ven(-1L);	
				cajaegreso.setsecuencial("");	
				cajaegreso.setfecha(new Date());	
				cajaegreso.sethora(new Time((new Date()).getTime()));	
				cajaegreso.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaEgreso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_IDTURNOPUNVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaEgreso(String sTipo,Row row,Workbook workbook,CajaEgreso cajaegreso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getturnopunven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegreso.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaEgreso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajaEgreso() {
		return this.sFinalQueryCajaEgreso;
	}
	
	public void setsFinalQueryCajaEgreso(String sFinalQueryCajaEgreso) {
		this.sFinalQueryCajaEgreso= sFinalQueryCajaEgreso;
	}
	
	public Border resaltarSeleccionarCajaEgreso=null;
	
	public Border setResaltarSeleccionarCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaEgreso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaEgreso() {
		return this.resaltarSeleccionarCajaEgreso;
	}
	
	public void setResaltarSeleccionarCajaEgreso(Border borderResaltarSeleccionarCajaEgreso) {
		this.resaltarSeleccionarCajaEgreso= borderResaltarSeleccionarCajaEgreso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaEgreso=null;
	public Boolean mostraridCajaEgreso=true;
	public Boolean activaridCajaEgreso=true;

	public Border resaltarid_empresaCajaEgreso=null;
	public Boolean mostrarid_empresaCajaEgreso=true;
	public Boolean activarid_empresaCajaEgreso=true;
	public Boolean cargarid_empresaCajaEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaEgreso=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajaEgreso=null;
	public Boolean mostrarid_sucursalCajaEgreso=true;
	public Boolean activarid_sucursalCajaEgreso=true;
	public Boolean cargarid_sucursalCajaEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajaEgreso=false;//ConEventDepend=true

	public Border resaltarid_usuarioCajaEgreso=null;
	public Boolean mostrarid_usuarioCajaEgreso=true;
	public Boolean activarid_usuarioCajaEgreso=true;
	public Boolean cargarid_usuarioCajaEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCajaEgreso=false;//ConEventDepend=true

	public Border resaltarid_cajaCajaEgreso=null;
	public Boolean mostrarid_cajaCajaEgreso=true;
	public Boolean activarid_cajaCajaEgreso=true;
	public Boolean cargarid_cajaCajaEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajaEgreso=false;//ConEventDepend=true

	public Border resaltarid_turno_pun_venCajaEgreso=null;
	public Boolean mostrarid_turno_pun_venCajaEgreso=true;
	public Boolean activarid_turno_pun_venCajaEgreso=true;
	public Boolean cargarid_turno_pun_venCajaEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_turno_pun_venCajaEgreso=false;//ConEventDepend=true

	public Border resaltarsecuencialCajaEgreso=null;
	public Boolean mostrarsecuencialCajaEgreso=true;
	public Boolean activarsecuencialCajaEgreso=true;

	public Border resaltarfechaCajaEgreso=null;
	public Boolean mostrarfechaCajaEgreso=true;
	public Boolean activarfechaCajaEgreso=true;

	public Border resaltarhoraCajaEgreso=null;
	public Boolean mostrarhoraCajaEgreso=true;
	public Boolean activarhoraCajaEgreso=true;

	public Border resaltarvalorCajaEgreso=null;
	public Boolean mostrarvalorCajaEgreso=true;
	public Boolean activarvalorCajaEgreso=true;

	
	

	public Border setResaltaridCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltaridCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaEgreso() {
		return this.resaltaridCajaEgreso;
	}

	public void setResaltaridCajaEgreso(Border borderResaltar) {
		this.resaltaridCajaEgreso= borderResaltar;
	}

	public Boolean getMostraridCajaEgreso() {
		return this.mostraridCajaEgreso;
	}

	public void setMostraridCajaEgreso(Boolean mostraridCajaEgreso) {
		this.mostraridCajaEgreso= mostraridCajaEgreso;
	}

	public Boolean getActivaridCajaEgreso() {
		return this.activaridCajaEgreso;
	}

	public void setActivaridCajaEgreso(Boolean activaridCajaEgreso) {
		this.activaridCajaEgreso= activaridCajaEgreso;
	}

	public Border setResaltarid_empresaCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaEgreso() {
		return this.resaltarid_empresaCajaEgreso;
	}

	public void setResaltarid_empresaCajaEgreso(Border borderResaltar) {
		this.resaltarid_empresaCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaEgreso() {
		return this.mostrarid_empresaCajaEgreso;
	}

	public void setMostrarid_empresaCajaEgreso(Boolean mostrarid_empresaCajaEgreso) {
		this.mostrarid_empresaCajaEgreso= mostrarid_empresaCajaEgreso;
	}

	public Boolean getActivarid_empresaCajaEgreso() {
		return this.activarid_empresaCajaEgreso;
	}

	public void setActivarid_empresaCajaEgreso(Boolean activarid_empresaCajaEgreso) {
		this.activarid_empresaCajaEgreso= activarid_empresaCajaEgreso;
	}

	public Boolean getCargarid_empresaCajaEgreso() {
		return this.cargarid_empresaCajaEgreso;
	}

	public void setCargarid_empresaCajaEgreso(Boolean cargarid_empresaCajaEgreso) {
		this.cargarid_empresaCajaEgreso= cargarid_empresaCajaEgreso;
	}

	public Border setResaltarid_sucursalCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajaEgreso() {
		return this.resaltarid_sucursalCajaEgreso;
	}

	public void setResaltarid_sucursalCajaEgreso(Border borderResaltar) {
		this.resaltarid_sucursalCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajaEgreso() {
		return this.mostrarid_sucursalCajaEgreso;
	}

	public void setMostrarid_sucursalCajaEgreso(Boolean mostrarid_sucursalCajaEgreso) {
		this.mostrarid_sucursalCajaEgreso= mostrarid_sucursalCajaEgreso;
	}

	public Boolean getActivarid_sucursalCajaEgreso() {
		return this.activarid_sucursalCajaEgreso;
	}

	public void setActivarid_sucursalCajaEgreso(Boolean activarid_sucursalCajaEgreso) {
		this.activarid_sucursalCajaEgreso= activarid_sucursalCajaEgreso;
	}

	public Boolean getCargarid_sucursalCajaEgreso() {
		return this.cargarid_sucursalCajaEgreso;
	}

	public void setCargarid_sucursalCajaEgreso(Boolean cargarid_sucursalCajaEgreso) {
		this.cargarid_sucursalCajaEgreso= cargarid_sucursalCajaEgreso;
	}

	public Border setResaltarid_usuarioCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCajaEgreso() {
		return this.resaltarid_usuarioCajaEgreso;
	}

	public void setResaltarid_usuarioCajaEgreso(Border borderResaltar) {
		this.resaltarid_usuarioCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCajaEgreso() {
		return this.mostrarid_usuarioCajaEgreso;
	}

	public void setMostrarid_usuarioCajaEgreso(Boolean mostrarid_usuarioCajaEgreso) {
		this.mostrarid_usuarioCajaEgreso= mostrarid_usuarioCajaEgreso;
	}

	public Boolean getActivarid_usuarioCajaEgreso() {
		return this.activarid_usuarioCajaEgreso;
	}

	public void setActivarid_usuarioCajaEgreso(Boolean activarid_usuarioCajaEgreso) {
		this.activarid_usuarioCajaEgreso= activarid_usuarioCajaEgreso;
	}

	public Boolean getCargarid_usuarioCajaEgreso() {
		return this.cargarid_usuarioCajaEgreso;
	}

	public void setCargarid_usuarioCajaEgreso(Boolean cargarid_usuarioCajaEgreso) {
		this.cargarid_usuarioCajaEgreso= cargarid_usuarioCajaEgreso;
	}

	public Border setResaltarid_cajaCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajaEgreso() {
		return this.resaltarid_cajaCajaEgreso;
	}

	public void setResaltarid_cajaCajaEgreso(Border borderResaltar) {
		this.resaltarid_cajaCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajaEgreso() {
		return this.mostrarid_cajaCajaEgreso;
	}

	public void setMostrarid_cajaCajaEgreso(Boolean mostrarid_cajaCajaEgreso) {
		this.mostrarid_cajaCajaEgreso= mostrarid_cajaCajaEgreso;
	}

	public Boolean getActivarid_cajaCajaEgreso() {
		return this.activarid_cajaCajaEgreso;
	}

	public void setActivarid_cajaCajaEgreso(Boolean activarid_cajaCajaEgreso) {
		this.activarid_cajaCajaEgreso= activarid_cajaCajaEgreso;
	}

	public Boolean getCargarid_cajaCajaEgreso() {
		return this.cargarid_cajaCajaEgreso;
	}

	public void setCargarid_cajaCajaEgreso(Boolean cargarid_cajaCajaEgreso) {
		this.cargarid_cajaCajaEgreso= cargarid_cajaCajaEgreso;
	}

	public Border setResaltarid_turno_pun_venCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarid_turno_pun_venCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_turno_pun_venCajaEgreso() {
		return this.resaltarid_turno_pun_venCajaEgreso;
	}

	public void setResaltarid_turno_pun_venCajaEgreso(Border borderResaltar) {
		this.resaltarid_turno_pun_venCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarid_turno_pun_venCajaEgreso() {
		return this.mostrarid_turno_pun_venCajaEgreso;
	}

	public void setMostrarid_turno_pun_venCajaEgreso(Boolean mostrarid_turno_pun_venCajaEgreso) {
		this.mostrarid_turno_pun_venCajaEgreso= mostrarid_turno_pun_venCajaEgreso;
	}

	public Boolean getActivarid_turno_pun_venCajaEgreso() {
		return this.activarid_turno_pun_venCajaEgreso;
	}

	public void setActivarid_turno_pun_venCajaEgreso(Boolean activarid_turno_pun_venCajaEgreso) {
		this.activarid_turno_pun_venCajaEgreso= activarid_turno_pun_venCajaEgreso;
	}

	public Boolean getCargarid_turno_pun_venCajaEgreso() {
		return this.cargarid_turno_pun_venCajaEgreso;
	}

	public void setCargarid_turno_pun_venCajaEgreso(Boolean cargarid_turno_pun_venCajaEgreso) {
		this.cargarid_turno_pun_venCajaEgreso= cargarid_turno_pun_venCajaEgreso;
	}

	public Border setResaltarsecuencialCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarsecuencialCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialCajaEgreso() {
		return this.resaltarsecuencialCajaEgreso;
	}

	public void setResaltarsecuencialCajaEgreso(Border borderResaltar) {
		this.resaltarsecuencialCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarsecuencialCajaEgreso() {
		return this.mostrarsecuencialCajaEgreso;
	}

	public void setMostrarsecuencialCajaEgreso(Boolean mostrarsecuencialCajaEgreso) {
		this.mostrarsecuencialCajaEgreso= mostrarsecuencialCajaEgreso;
	}

	public Boolean getActivarsecuencialCajaEgreso() {
		return this.activarsecuencialCajaEgreso;
	}

	public void setActivarsecuencialCajaEgreso(Boolean activarsecuencialCajaEgreso) {
		this.activarsecuencialCajaEgreso= activarsecuencialCajaEgreso;
	}

	public Border setResaltarfechaCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarfechaCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCajaEgreso() {
		return this.resaltarfechaCajaEgreso;
	}

	public void setResaltarfechaCajaEgreso(Border borderResaltar) {
		this.resaltarfechaCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarfechaCajaEgreso() {
		return this.mostrarfechaCajaEgreso;
	}

	public void setMostrarfechaCajaEgreso(Boolean mostrarfechaCajaEgreso) {
		this.mostrarfechaCajaEgreso= mostrarfechaCajaEgreso;
	}

	public Boolean getActivarfechaCajaEgreso() {
		return this.activarfechaCajaEgreso;
	}

	public void setActivarfechaCajaEgreso(Boolean activarfechaCajaEgreso) {
		this.activarfechaCajaEgreso= activarfechaCajaEgreso;
	}

	public Border setResaltarhoraCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarhoraCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraCajaEgreso() {
		return this.resaltarhoraCajaEgreso;
	}

	public void setResaltarhoraCajaEgreso(Border borderResaltar) {
		this.resaltarhoraCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarhoraCajaEgreso() {
		return this.mostrarhoraCajaEgreso;
	}

	public void setMostrarhoraCajaEgreso(Boolean mostrarhoraCajaEgreso) {
		this.mostrarhoraCajaEgreso= mostrarhoraCajaEgreso;
	}

	public Boolean getActivarhoraCajaEgreso() {
		return this.activarhoraCajaEgreso;
	}

	public void setActivarhoraCajaEgreso(Boolean activarhoraCajaEgreso) {
		this.activarhoraCajaEgreso= activarhoraCajaEgreso;
	}

	public Border setResaltarvalorCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltar);
		
		this.resaltarvalorCajaEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCajaEgreso() {
		return this.resaltarvalorCajaEgreso;
	}

	public void setResaltarvalorCajaEgreso(Border borderResaltar) {
		this.resaltarvalorCajaEgreso= borderResaltar;
	}

	public Boolean getMostrarvalorCajaEgreso() {
		return this.mostrarvalorCajaEgreso;
	}

	public void setMostrarvalorCajaEgreso(Boolean mostrarvalorCajaEgreso) {
		this.mostrarvalorCajaEgreso= mostrarvalorCajaEgreso;
	}

	public Boolean getActivarvalorCajaEgreso() {
		return this.activarvalorCajaEgreso;
	}

	public void setActivarvalorCajaEgreso(Boolean activarvalorCajaEgreso) {
		this.activarvalorCajaEgreso= activarvalorCajaEgreso;
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
		
		
		this.setMostraridCajaEgreso(esInicial);
		this.setMostrarid_empresaCajaEgreso(esInicial);
		this.setMostrarid_sucursalCajaEgreso(esInicial);
		this.setMostrarid_usuarioCajaEgreso(esInicial);
		this.setMostrarid_cajaCajaEgreso(esInicial);
		this.setMostrarid_turno_pun_venCajaEgreso(esInicial);
		this.setMostrarsecuencialCajaEgreso(esInicial);
		this.setMostrarfechaCajaEgreso(esInicial);
		this.setMostrarhoraCajaEgreso(esInicial);
		this.setMostrarvalorCajaEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoConstantesFunciones.ID)) {
				this.setMostraridCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setMostrarid_turno_pun_venCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.FECHA)) {
				this.setMostrarfechaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.HORA)) {
				this.setMostrarhoraCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.VALOR)) {
				this.setMostrarvalorCajaEgreso(esAsigna);
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
		
		
		this.setActivaridCajaEgreso(esInicial);
		this.setActivarid_empresaCajaEgreso(esInicial);
		this.setActivarid_sucursalCajaEgreso(esInicial);
		this.setActivarid_usuarioCajaEgreso(esInicial);
		this.setActivarid_cajaCajaEgreso(esInicial);
		this.setActivarid_turno_pun_venCajaEgreso(esInicial);
		this.setActivarsecuencialCajaEgreso(esInicial);
		this.setActivarfechaCajaEgreso(esInicial);
		this.setActivarhoraCajaEgreso(esInicial);
		this.setActivarvalorCajaEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoConstantesFunciones.ID)) {
				this.setActivaridCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setActivarid_turno_pun_venCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.FECHA)) {
				this.setActivarfechaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.HORA)) {
				this.setActivarhoraCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.VALOR)) {
				this.setActivarvalorCajaEgreso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaEgreso(esInicial);
		this.setResaltarid_empresaCajaEgreso(esInicial);
		this.setResaltarid_sucursalCajaEgreso(esInicial);
		this.setResaltarid_usuarioCajaEgreso(esInicial);
		this.setResaltarid_cajaCajaEgreso(esInicial);
		this.setResaltarid_turno_pun_venCajaEgreso(esInicial);
		this.setResaltarsecuencialCajaEgreso(esInicial);
		this.setResaltarfechaCajaEgreso(esInicial);
		this.setResaltarhoraCajaEgreso(esInicial);
		this.setResaltarvalorCajaEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoConstantesFunciones.ID)) {
				this.setResaltaridCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setResaltarid_turno_pun_venCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.FECHA)) {
				this.setResaltarfechaCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.HORA)) {
				this.setResaltarhoraCajaEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoConstantesFunciones.VALOR)) {
				this.setResaltarvalorCajaEgreso(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCajaEgresoDetalleCajaEgreso=null;

	public Border getResaltarCajaEgresoDetalleCajaEgreso() {
		return this.resaltarCajaEgresoDetalleCajaEgreso;
	}

	public void setResaltarCajaEgresoDetalleCajaEgreso(Border borderResaltarCajaEgresoDetalle) {
		if(borderResaltarCajaEgresoDetalle!=null) {
			this.resaltarCajaEgresoDetalleCajaEgreso= borderResaltarCajaEgresoDetalle;
		}
	}

	public Border setResaltarCajaEgresoDetalleCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaEgresoDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaegresoBeanSwingJInternalFrame.jTtoolBarCajaEgreso.setBorder(borderResaltarCajaEgresoDetalle);
			
		this.resaltarCajaEgresoDetalleCajaEgreso= borderResaltarCajaEgresoDetalle;

		 return borderResaltarCajaEgresoDetalle;
	}



	public Boolean mostrarCajaEgresoDetalleCajaEgreso=true;

	public Boolean getMostrarCajaEgresoDetalleCajaEgreso() {
		return this.mostrarCajaEgresoDetalleCajaEgreso;
	}

	public void setMostrarCajaEgresoDetalleCajaEgreso(Boolean visibilidadResaltarCajaEgresoDetalle) {
		this.mostrarCajaEgresoDetalleCajaEgreso= visibilidadResaltarCajaEgresoDetalle;
	}



	public Boolean activarCajaEgresoDetalleCajaEgreso=true;

	public Boolean gethabilitarResaltarCajaEgresoDetalleCajaEgreso() {
		return this.activarCajaEgresoDetalleCajaEgreso;
	}

	public void setActivarCajaEgresoDetalleCajaEgreso(Boolean habilitarResaltarCajaEgresoDetalle) {
		this.activarCajaEgresoDetalleCajaEgreso= habilitarResaltarCajaEgresoDetalle;
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

		this.setMostrarCajaEgresoDetalleCajaEgreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaEgresoDetalle.class)) {
				this.setMostrarCajaEgresoDetalleCajaEgreso(esAsigna);
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

		this.setActivarCajaEgresoDetalleCajaEgreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaEgresoDetalle.class)) {
				this.setActivarCajaEgresoDetalleCajaEgreso(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCajaEgresoDetalleCajaEgreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaEgresoDetalle.class)) {
				this.setResaltarCajaEgresoDetalleCajaEgreso(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCajaCajaEgreso=true;

	public Boolean getMostrarFK_IdCajaCajaEgreso() {
		return this.mostrarFK_IdCajaCajaEgreso;
	}

	public void setMostrarFK_IdCajaCajaEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaCajaEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajaEgreso=true;

	public Boolean getMostrarFK_IdEmpresaCajaEgreso() {
		return this.mostrarFK_IdEmpresaCajaEgreso;
	}

	public void setMostrarFK_IdEmpresaCajaEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajaEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajaEgreso=true;

	public Boolean getMostrarFK_IdSucursalCajaEgreso() {
		return this.mostrarFK_IdSucursalCajaEgreso;
	}

	public void setMostrarFK_IdSucursalCajaEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajaEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTurnoPunVenCajaEgreso=true;

	public Boolean getMostrarFK_IdTurnoPunVenCajaEgreso() {
		return this.mostrarFK_IdTurnoPunVenCajaEgreso;
	}

	public void setMostrarFK_IdTurnoPunVenCajaEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTurnoPunVenCajaEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioCajaEgreso=true;

	public Boolean getMostrarFK_IdUsuarioCajaEgreso() {
		return this.mostrarFK_IdUsuarioCajaEgreso;
	}

	public void setMostrarFK_IdUsuarioCajaEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioCajaEgreso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaCajaEgreso=true;

	public Boolean getActivarFK_IdCajaCajaEgreso() {
		return this.activarFK_IdCajaCajaEgreso;
	}

	public void setActivarFK_IdCajaCajaEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdCajaCajaEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajaEgreso=true;

	public Boolean getActivarFK_IdEmpresaCajaEgreso() {
		return this.activarFK_IdEmpresaCajaEgreso;
	}

	public void setActivarFK_IdEmpresaCajaEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajaEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajaEgreso=true;

	public Boolean getActivarFK_IdSucursalCajaEgreso() {
		return this.activarFK_IdSucursalCajaEgreso;
	}

	public void setActivarFK_IdSucursalCajaEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajaEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdTurnoPunVenCajaEgreso=true;

	public Boolean getActivarFK_IdTurnoPunVenCajaEgreso() {
		return this.activarFK_IdTurnoPunVenCajaEgreso;
	}

	public void setActivarFK_IdTurnoPunVenCajaEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdTurnoPunVenCajaEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioCajaEgreso=true;

	public Boolean getActivarFK_IdUsuarioCajaEgreso() {
		return this.activarFK_IdUsuarioCajaEgreso;
	}

	public void setActivarFK_IdUsuarioCajaEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioCajaEgreso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaCajaEgreso=null;

	public Border getResaltarFK_IdCajaCajaEgreso() {
		return this.resaltarFK_IdCajaCajaEgreso;
	}

	public void setResaltarFK_IdCajaCajaEgreso(Border borderResaltar) {
		this.resaltarFK_IdCajaCajaEgreso= borderResaltar;
	}

	public void setResaltarFK_IdCajaCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaCajaEgreso= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajaEgreso=null;

	public Border getResaltarFK_IdEmpresaCajaEgreso() {
		return this.resaltarFK_IdEmpresaCajaEgreso;
	}

	public void setResaltarFK_IdEmpresaCajaEgreso(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajaEgreso= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajaEgreso= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajaEgreso=null;

	public Border getResaltarFK_IdSucursalCajaEgreso() {
		return this.resaltarFK_IdSucursalCajaEgreso;
	}

	public void setResaltarFK_IdSucursalCajaEgreso(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajaEgreso= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajaEgreso= borderResaltar;
	}

	public Border resaltarFK_IdTurnoPunVenCajaEgreso=null;

	public Border getResaltarFK_IdTurnoPunVenCajaEgreso() {
		return this.resaltarFK_IdTurnoPunVenCajaEgreso;
	}

	public void setResaltarFK_IdTurnoPunVenCajaEgreso(Border borderResaltar) {
		this.resaltarFK_IdTurnoPunVenCajaEgreso= borderResaltar;
	}

	public void setResaltarFK_IdTurnoPunVenCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTurnoPunVenCajaEgreso= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioCajaEgreso=null;

	public Border getResaltarFK_IdUsuarioCajaEgreso() {
		return this.resaltarFK_IdUsuarioCajaEgreso;
	}

	public void setResaltarFK_IdUsuarioCajaEgreso(Border borderResaltar) {
		this.resaltarFK_IdUsuarioCajaEgreso= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioCajaEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoBeanSwingJInternalFrame cajaegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioCajaEgreso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}